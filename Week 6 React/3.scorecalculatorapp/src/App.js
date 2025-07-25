// src/App.js
import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore name="Jude Bettlin A" school="SNS College" total={600} goal={300} />
    </div>
  );
}

export default App;
