import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';

import Footer from "../components/layout/Footer";

it("Header render without crashing", () => {
    render(
        <BrowserRouter>
         <Footer/>
        </BrowserRouter>
    );

    const HeaderComponent = screen.getByTestId("Footer-1");
    expect(HeaderComponent).toBeInTheDocument();

})