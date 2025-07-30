import React, { Component } from 'react';

class Getuser extends Component {
  constructor() {
    super();
    this.state = {
      user: null
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error("Error fetching user:", error);
    }
  }

  render() {
    const { user } = this.state;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        {user ? (
          <>
            <h1>
              Mr {user.name.first} {user.name.last}
            </h1>
            <img
              src={user.picture.medium}
              alt="User"
              style={{ borderRadius: '8px' }}
            />
          </>
        ) : (
          <p>Loading user...</p>
        )}
      </div>
    );
  }
}

export default Getuser;

