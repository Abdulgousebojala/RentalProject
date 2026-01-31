import React from "react";
import "./ProductList.css";

function ProductList() {
  const products = [
    { id: 1, name: "Camera", price: "₹800/day" },
    { id: 2, name: "Laptop", price: "₹1000/day" },
    { id: 3, name: "Bike", price: "₹600/day" },
  ];

  return (
    <div className="product-list">
      <h2>Available Products for Rent</h2>
      <div className="product-grid">
        {products.map((product) => (
          <div key={product.id} className="product-card">
            <h3>{product.name}</h3>
            <p>{product.price}</p>
            <button>Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ProductList; 
