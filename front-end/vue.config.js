module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws: true,
                secure: false,
                changeOrigin: true,
                pathRewrite:{
                    '^/api':''
                }
            }
        }
    }
}