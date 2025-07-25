// src/CountPeople.js
import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1 style={{ color: 'green' }}>People Counter</h1>
        <h2>People Entered: {this.state.entryCount}</h2>
        <h2>People Exited: {this.state.exitCount}</h2>
        <button
          onClick={this.UpdateEntry}
          style={{
            padding: '10px 20px',
            margin: '10px',
            backgroundColor: 'lightgreen',
            border: 'none',
            fontSize: '16px',
            cursor: 'pointer',
          }}
        >
          Login
        </button>
        <button
          onClick={this.UpdateExit}
          style={{
            padding: '10px 20px',
            margin: '10px',
            backgroundColor: 'lightcoral',
            border: 'none',
            fontSize: '16px',
            cursor: 'pointer',
          }}
        >
          Exit
        </button>
      </div>
    );
  }
}

export default CountPeople;
