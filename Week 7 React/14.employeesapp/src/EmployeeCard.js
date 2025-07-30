import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className={`card ${theme}`}>
      <h3>{employee.name}</h3>
      <p>{employee.email}</p>
      <p>{employee.phone}</p>
      <button className={theme}>Edit</button>
      <button className={theme}>Delete</button>
    </div>
  );
}

export default EmployeeCard;
