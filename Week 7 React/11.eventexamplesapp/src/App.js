
import React, { useState } from 'react';
import './App.css';
import CurrencyConverter from './CurrencyConverter';

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello(); // Multiple functions
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayHello = () => {
    console.log("Hello! This is a static message.");
    alert("Hello! This is a static message.");
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div className="App">
      <h1>React Event Examples</h1>

      <h2>Counter: {count}</h2>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>

      <hr />

      <button onClick={() => sayWelcome("Welcome to the Event Handling App!")}>Say Welcome</button>

      <hr />

      <button onClick={handleClick}>Click on me</button>

      <hr />

      <CurrencyConverter />
    </div>
  );
}

export default App;
