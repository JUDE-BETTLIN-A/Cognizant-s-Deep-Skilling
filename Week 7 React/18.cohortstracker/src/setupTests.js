import '@testing-library/jest-dom';



import {configure } from "enzyme";

import Adapter from "enzyme-adapter-react-16";
configure({ adapter: new Adapter()});

// Polyfill for TextEncoder and TextDecoder
const { TextEncoder, TextDecoder } = require('util');
global.TextEncoder = TextEncoder;
global.TextDecoder = TextDecoder;

// Enzyme configuration
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });
