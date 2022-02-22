var path = require('path');


module.exports = {
    entry: './client/index.js',
    output: {
        path: path.join(__dirname, '/public/'),
        filename: 'js/app.js',


    },


    resolve: {
        extensions: ['.js', '.jsx']
    },
    module: {
        loaders: [{
            loader: "babel-loader",     //转换react及ES6语法
            test: /\.jsx?$/,
            query: {
                presets: ['es2015', 'react']
            }
        }, {
            loader: "style-loader!css-loader!sass-loader",  //从右向左执行
            test: /\.(scss|sass)$/
        }]
    }

};