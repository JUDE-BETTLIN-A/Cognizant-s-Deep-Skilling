// src/Components/CalculateScore.js
import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ name, school, total, goal }) {
  const percentage = ((total / goal) * 100).toFixed(2);

  return (
    <div className="score-container">
      <h2 className="heading">Student Details:</h2>
      <div className="line"><span className="label name">Name:</span> {name}</div>
      <div className="line"><span className="label school">School:</span> {school}</div>
      <div className="line"><span className="label total">Total:</span> {total} Marks</div>
      <div className="line"><span className="label score">Score:</span> {percentage}%</div>
    </div>
  );
}

export default CalculateScore;
