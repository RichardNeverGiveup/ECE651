import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import './index.scss';

class Test extends Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div className="content">Hello, React</div>
        )
    }
}
require('./index.scss');
ReactDOM.render(<Test />,
    document.getElementById('container')
);
