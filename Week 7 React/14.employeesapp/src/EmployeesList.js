import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [
    { id: 1, name: 'Jojo', email: 'jojo@congizant.com', phone: '98238971234' },
    { id: 2, name: 'Sam', email: 'sam@congizant.com', phone: '9981184126' },
    { id: 3, name: 'Elisa', email: 'elisa@congizant.com', phone: '9989389735' },
  ];

  return (
    <div className="employee-list">
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
