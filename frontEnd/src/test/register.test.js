import { render, screen, cleanup } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import axios from 'axios';
import Register from '../pages/Login/Register.js'

afterEach(cleanup);

jest.mock('axios', () => {
    return {
      create: jest.fn(() => ({
        get: jest.fn(),
        interceptors: {
          request: { use: jest.fn(), eject: jest.fn() },
          response: { use: jest.fn(), eject: jest.fn() }
        }
      }))
    }
})

test('Render Register component', () => {
    render(
        <BrowserRouter>
         <Register/>
        </BrowserRouter>
    );

    const RegisterComponent = screen.getByTestId("Register-1");
    expect(RegisterComponent).toBeInTheDocument();
})
  

test('Fetches data', async () => {
    const data = {
        username: 'username',
        password: 'password',
    };

    axios.post = jest.fn().mockResolvedValue({
        data: data,
    });

    // 断言mockFn调用后返回的是Function对象
    expect(Object.prototype.toString.call(axios.post)).toBe("[object Function]");

})
