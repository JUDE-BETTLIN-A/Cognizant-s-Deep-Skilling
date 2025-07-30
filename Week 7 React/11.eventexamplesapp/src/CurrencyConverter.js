import React, { useState } from 'react';

function CurrencyConverter() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = () => {
    const conversionRate = 0.011; // Example: 1 INR = 0.011 EUR
    const converted = parseFloat(rupees) * conversionRate;
    setEuro(converted.toFixed(2));
  };

  return (
    <div>
      <h2>Currency Converter (INR to EUR)</h2>
      <input
        type="number"
        placeholder="Enter amount in INR"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />
      <button onClick={handleSubmit}>Convert</button>
      {euro !== null && (
        <p>{rupees} INR = {euro} EUR</p>
      )}
    </div>
  );
}

export default CurrencyConverter;
