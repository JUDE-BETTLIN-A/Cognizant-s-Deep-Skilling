// src/App.js
import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    GitClient.getRepositories("techiesyed")
      .then(setRepos)
      .catch(console.error);
  }, []);

  return (
    <div className="App">
      <h1>GitHub Repositories</h1>
      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
