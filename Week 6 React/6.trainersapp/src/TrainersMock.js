// src/TrainersMock.js
import Trainer from './trainer';

const trainers = [
  new Trainer(
    1,
    'Alice Johnson',
    'alice.johnson@example.com',
    '123-456-7890',
    'React',
    ['JSX', 'Hooks', 'State Management']
  ),
  new Trainer(
    2,
    'Bob Smith',
    'bob.smith@example.com',
    '234-567-8901',
    'Angular',
    ['Components', 'Services', 'RxJS']
  ),
  new Trainer(
    3,
    'Charlie Brown',
    'charlie.brown@example.com',
    '345-678-9012',
    'Node.js',
    ['Express', 'MongoDB', 'REST APIs']
  )
];

export default trainers;
