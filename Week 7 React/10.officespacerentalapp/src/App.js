import React from 'react';
import './App.css';

function App() {
  // Office object list
  const offices = [
    {
      name: 'Downtown Tech Hub',
      rent: 55000,
      address: '123 Main St, Mumbai',
      image: 'https://plus.unsplash.com/premium_photo-1661931749081-23d69ddb62d1?q=80&w=1883&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'
    }
  ];

  return (
    <div className="App">
      <h1>Office Space , at Affordable Range</h1>

      {offices.map((office, index) => (
        <div key={index} className="office-card">
          <img src={office.image} alt={office.name} />
          <p><strong>Name:</strong>{office.name}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            <strong>Rent:</strong> ₹{office.rent}
          </p>
          <p><strong>Address:</strong> {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
