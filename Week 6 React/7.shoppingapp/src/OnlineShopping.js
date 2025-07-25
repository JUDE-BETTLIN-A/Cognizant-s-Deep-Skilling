// src/OnlineShopping.js
import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        new Cart('Laptop', 75000),
        new Cart('Smartphone', 30000),
        new Cart('Headphones', 5000),
        new Cart('Keyboard', 1500),
        new Cart('Mouse', 1000),
      ]
    };
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1 style={{ color: 'green' }}>Shopping Cart Items</h1>
        <table
          border="1"
          cellPadding="10"
          style={{
            margin: '0 auto',
            borderCollapse: 'collapse',
            color: 'green'
          }}
        >
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price (₹)</th>
            </tr>
          </thead>
          <tbody>
            {this.state.items.map((item, index) => (
              <tr key={index}>
                <td>{item.itemName}</td>
                <td>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
