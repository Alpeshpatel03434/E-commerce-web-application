/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addTOCart(SllerId, ProductId, ProductName, ProductPrice) {

    let cart = localStorage.getItem("cart");
    if (cart == null) {

        let productsLst = [];
        let product = {
            productId: ProductId,
            SellerId: SllerId,
            ProductName: ProductName,
            ProductQuantity: 1,
            ProductPrice: ProductPrice
        };
        productsLst.push(product);
        localStorage.setItem("cart", JSON.stringify(productsLst));
        console.log("First item added");
        showToast(product.ProductName + " is added to Cart");
    } else {

        let pcart = JSON.parse(cart);

        let oldProduct = pcart.find((item) => item.productId == ProductId)
        console.log(oldProduct);
        if (oldProduct) {
            // Only Increse (Same Product)
            oldProduct.ProductQuantity = oldProduct.ProductQuantity + 1;


            pcart.map((item) => {
                if (item.productId == oldProduct.productId) {
                    item.ProductQuantity = oldProduct.ProductQuantity;
                }
            });

            localStorage.setItem("cart", JSON.stringify(pcart));
            showToast(oldProduct.ProductName + " Quantity Incresed by " + oldProduct.ProductQuantity);
        } else {
            // Add other Product so add Quantuty

            let product = {
                productId: ProductId,
                SellerId: SllerId,
                ProductName: ProductName,
                ProductQuantity: 1,
                ProductPrice: ProductPrice
            };

            pcart.push(product);
            localStorage.setItem("cart", JSON.stringify(pcart));
            showToast(product.ProductName + " is added to Cart");
        }

    }

    UpdateCart();
}

function UpdateCart() {
    let scart = localStorage.getItem("cart");
    let cart = JSON.parse(scart);

    if (cart == null || cart.length == 0) {
        console.log("Cart is Empty...");
        $(".card-items").html("(0)");
        $(".cart-body").html("<h3>Cart does not have any items</h3>");
//        $(".checkout-btn").addClass("disabled");
        $(".checkout-btn").attr('disabled', true);
    } else {
        $(".checkout-btn").removeAttr('disabled');
        //attr('disabled', false);
        console.log("Cart - " + cart);
        $(".card-items").html(`(${cart.length})`);
        let table = `
        <table class='table'>
        <thead class='thread-light'>
         <tr>
        <th>Item Name</th> 
        <th>Price</th> 
        <th>Quantity</th> 
        <th>Toal Price</th> 
        <th>Action</th> 
        
        </tr>
        </thead>
         `;
        let totalPrice = 0;
        cart.map((item) => {
            table += `
            <tr>
            <td>${item.ProductName}</td>
            <td>₹ ${item.ProductPrice}</td>
            <td>${item.ProductQuantity}&nbsp;<button onclick='decrezingItemFromCart(${item.productId})' class="btn btn-primary btn-sm px-2 text-center ml-2 font-weight-bold">-</button></td>
            <td>${item.ProductPrice * item.ProductQuantity}</td>
            <td><button onclick='deleteItemFromCart(${item.productId})' class="btn btn-danger btn-sm">Remove</button></td>
            </tr>
          `;
            totalPrice += item.ProductPrice * item.ProductQuantity;
        });
        table = table + `<tr><td colspan='5' class='text-right font-weight-bold m-5'> Toal Price : ₹ ${totalPrice} </td></tr>
            </table>`;
        $(".cart-body").html(table);
    }
}

function decrezingItemFromCart(ProductId) {
    let scart = localStorage.getItem("cart");
    let cart = JSON.parse(scart);

    console.log('cart - ' + cart);
    console.log('ProductId - ' + ProductId);

    /*  
     let updatedcart = cart.filter((item1)=>item1.productId!=ProductId);
     let Itemfilter = cart.filter((item2)=>item2.productId==ProductId);
     console.log('1 updatedcart - '+updatedcart);
     if(Itemfilter.ProductQuantity>0){
     //     Itemfilter.ProductQuantity = Itemfilter.ProductQuantity - 1;;
     console.log('Itemfilter - '+Itemfilter);
     updatedcart.push(Itemfilter);
     }
     console.log('2 updatedcart - '+updatedcart);
     localStorage.setItem("cart", JSON.stringify(updatedcart));
     UpdateCart(); */

    let oldProduct = cart.find((item) => item.productId == ProductId)
    console.log(oldProduct);
    if (oldProduct) {
        // Only Increse (Same Product)
        if (oldProduct.ProductQuantity > 1) {
            oldProduct.ProductQuantity = oldProduct.ProductQuantity - 1;
        } else {
            console.log("Delete");
            deleteItemFromCart(oldProduct.productId);
            return;
        }
        cart.map((item) => {

            if (item.productId == oldProduct.productId) {
                item.ProductQuantity = oldProduct.ProductQuantity;
            }

        });
    }
    localStorage.setItem("cart", JSON.stringify(cart));
    UpdateCart();
}

function deleteItemFromCart(ProductId) {
    let scart = localStorage.getItem("cart");
    let cart = JSON.parse(scart);

    let updatedcart = cart.filter((item) => item.productId != ProductId);
    localStorage.setItem("cart", JSON.stringify(updatedcart));
    UpdateCart();
    showToast("Item Removed from Cart");
}

function showToast(content) {
    $("#snackbar").addClass("snackbar");
    $("#snackbar").addClass("show");
    $("#snackbar").html(content);
    setTimeout(() => {
        $("#snackbar").removeClass("show");
    }, 2000);
}

$(document).ready(function ()
{
    UpdateCart();
   
   let val1 = document.getElementById("main-index-home-radio").checked;
    if(val1){
        Logout();
    }
    
});


//------------------------------

function PaymentOptionSelect() {

    let val1 = document.getElementById("user_PaymentMode1").checked;
    let val2 = document.getElementById("user_PaymentMode2").checked;

    if (val1 && val2 == false) {
        $("#div-user_PaymentMode1").removeClass("btn-secondary");
        $("#div-user_PaymentMode1").addClass("btn-success");

        $("#div-user_PaymentMode2").removeClass("btn-success");
        $("#div-user_PaymentMode2").addClass("btn-secondary");

    } else {
        $("#div-user_PaymentMode1").removeClass("btn-success");
        $("#div-user_PaymentMode1").addClass("btn-secondary");

        $("#div-user_PaymentMode2").removeClass("btn-secondary");
        $("#div-user_PaymentMode2").addClass("btn-success");
    }
}


function handleOrderNow() {
    let val1 = document.getElementById("user_PaymentMode1").checked;
    let val2 = document.getElementById("user_PaymentMode2").checked;
    let scart = localStorage.getItem("cart");
    let cart = JSON.parse(scart);
    let Items = cart;

    if (val1 & val2 != null) {
        
        
        localStorage.clear();
        UpdateCart();
    } else {
        localStorage.setItem("cart", JSON.stringify(cart));
        UpdateCart();
    }

}


function Logout() {
 
    let scart = localStorage.getItem("cart");
    let cart = JSON.parse(scart);
    let Items = cart;
    localStorage.clear();
     UpdateCart();

}


//-----------------------------------------------

function validateCardNumber(cardType, cardNumber) {

    if (cardType == 'American Express') {
        var pattern = /^(?:3[47][0-9]{13})$/;
        if (cardNumber.match(pattern)) {
            return true;
        } else {
            return false;
        }
    } else if (cardType == 'Visa') {
        var pattern = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;
        if (cardNumber.match(pattern)) {
            console.log("Visa");
            return true;
        } else {
            console.log("NotValid");
            return false;
        }
    } else if (cardType == 'Mastercard') {
        var pattern = /^(?:5[1-5][0-9]{14})$/;
        if (cardNumber.match(pattern)) {
            return true;
        } else {
            return false;
        }
    }

}


function ConfirmButtonhandle() {

    let type1 = document.getElementById("Visa").checked;
    let type2 = document.getElementById("Mastercard").checked;
    let type3 = document.getElementById("Americanexpress").checked;

    let cardType = null;
    if (type1) {
        cardType = "Visa";
    } else if (type2) {
        cardType = "Mastercard";
    } else {
        cardType = "American Express";
    }

    let cardNumber = document.getElementById("cardNumber").value;
    console.log("cardType, cardNumber - " + cardType + ", " + cardNumber);
    let check = validateCardNumber(cardType, cardNumber);

    let cart = JSON.parse(scart);
    let Items = cart;

    if (check) {
        console.log("hey");
        // $("#btn-confirm-forPayment-details").a
        
        localStorage.setItem("cart", null);
        UpdateCart();
        console.log("1-> " + $("#btn-confirm-forPayment-details").type);
        document.getElementById("btn-confirm-forPayment-details").type = "Submit";

        console.log("2-> " + document.getElementById("btn-confirm-forPayment-details").type);
    } else {
        alert("Please Enter Valid " + cardType + " Card Number");
        $("#btn-confirm-forPayment-details").type = ("NotSubmit");
    }

}