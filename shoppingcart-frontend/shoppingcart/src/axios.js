import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:9998',
  timeout: 1000
});

export default instance;
