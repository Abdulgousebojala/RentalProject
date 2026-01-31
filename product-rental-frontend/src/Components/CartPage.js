import React from "react";
import "./CartPage.css";

function CartPage() {
  const cartItems = [
    { id: 1, name: "Camera", price: "₹800/day" },
  ];

  return (
    <div className="cart-page">
      <h2>Your Rental Cart</h2>
      {cartItems.length > 0 ? (
        <ul>
          {cartItems.map((item) => (
            <li key={item.id}>
              {item.name} — {item.price}
              <button>Remove</button>
            </li>
          ))}
        </ul>
      ) : (
        <p>Your cart is empty.</p>
      )}
      <button className="checkout-btn">Proceed to Checkout</button>
    </div>
  );
}

export default CartPage; 
