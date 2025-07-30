import React, { useState } from 'react';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceId = Math.floor(Math.random() * 1000); // generates 0 to 999
    alert(
      `Thanks ${name}\nYour Complaint was Submitted.\nTransaction ID is ${referenceId}`
    );
    setName('');
    setComplaint('');
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h2 style={{ color: 'red' }}>Register your complaints here!!!</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name: </label>
          <input
            type="text"
            value={name}
            required
            onChange={(e) => setName(e.target.value)}
          />
        </div><br />
        <div>
          <label>Complaint: </label>
          <textarea 
            rows="3"
            value={complaint}
            required
            onChange={(e) => setComplaint(e.target.value)}
          />
        </div><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
