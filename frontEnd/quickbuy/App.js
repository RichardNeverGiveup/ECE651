var koa = require('koa');
var app = new koa();
var path = require('path');
var render = require('koa-swig');





var serve = require('koa-static-server');
app.use(serve({
    rootDir: __dirname + '/public',
    rootPath: '/public'
}));


var router = require('./server/router');
app.use(router);
var port = 3030;
app.listen(port);
console.log(`listening${port}`);
app.context.render = render({
    root: path.join(__dirname, './client/views'),
    cache: false,
    ext: 'html'
});

