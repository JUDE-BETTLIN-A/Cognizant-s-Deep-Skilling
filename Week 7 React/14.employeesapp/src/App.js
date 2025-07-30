import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';
import './styles.css';

function App() {
  const [theme1, setTheme1] = useState('dark');
  const [theme2, setTheme2] = useState('light');

  return (
    <div className="app-container">
      {/* First List */}
      <ThemeContext.Provider value={theme1}>
        <div className="list-container">
          <label>
            SELECT A THEME
            <select value={theme1} onChange={(e) => setTheme1(e.target.value)}>
              <option>light</option>
              <option>dark</option>
            </select>
          </label>
          <h2>Employees List</h2>
          <EmployeesList />
        </div>
      </ThemeContext.Provider>

      {/* Second List */}
      <ThemeContext.Provider value={theme2}>
        <div className="list-container">
          <label>
            SELECT A THEME
            <select value={theme2} onChange={(e) => setTheme2(e.target.value)}>
              <option>light</option>
              <option>dark</option>
            </select>
          </label>
          <h2>Employees List</h2>
          <EmployeesList />
        </div>
      </ThemeContext.Provider>
    </div>
  );
}

export default App;
