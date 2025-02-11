const path = require('path');

module.exports = {
    entry: './src/main/resources/static/js/main.js', // Your main JS file
    output: {
        path: path.resolve(__dirname, 'src/main/resources/static/dist'),
        filename: 'bundle.js',
        publicPath: '/dist/'
    },
    module: {
        rules: [
            {
                test: /\.scss$/,
                use: ['style-loader', 'css-loader', 'sass-loader']
            },
            {
                test: /\.(png|jpg|jpeg|gif|svg|webp)$/,
                type: 'asset/resource',
                generator: {
                    filename: 'images/[name][ext]'
                }
            }
        ]
    },
    mode: 'development'
};
