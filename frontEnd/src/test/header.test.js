import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';

import Header from "../components/layout/Header";

it("Header render without crashing", () => {
    render(
        <BrowserRouter>
         <Header/>
        </BrowserRouter>
    );

    const HeaderComponent = screen.getByTestId("Header-1");
    expect(HeaderComponent).toBeInTheDocument();

})