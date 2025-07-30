import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import './App.css';

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = () => setLoggedIn(true);
  const handleLogout = () => setLoggedIn(false);

  return (
    <div className="App">
      <header>
      

        {loggedIn ? (
          <>
            <h3>Welcome back</h3>
            <button onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <>
            <h3>Please sign up</h3>
            <button onClick={handleLogin}>Login</button>
          </>
        )}
      </header>

      <main>
        {loggedIn ? <UserPage /> : <GuestPage />}
      </main>
    </div>
  );
}

export default App;
