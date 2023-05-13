function fetchCartProducts() {
    fetch('http://localhost:8080/product/cart')
        .then(response => response.json())
        .then(products => {
            const cartDiv = document.getElementById('cart');
            cartDiv.innerHTML = '';
            products.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.textContent = `商品ID：${product.id}，名称：${product.name}，数量：${product.quantity}`;
                cartDiv.appendChild(productDiv);
            });
        });
}

document.getElementById('add-to-cart-form').addEventListener('submit', event => {
    event.preventDefault();
    const productId = document.getElementById('add-product-id').value;
    const quantity = document.getElementById('add-quantity').value;
    fetch(`http://localhost:8080/product/addToCart/${productId}?quantity=${quantity}`, {
        method: 'POST'
    }).then(() => {
        fetchCartProducts();
    });
});

document.getElementById('remove-from-cart-form').addEventListener('submit', event => {
    event.preventDefault();
    const productId = document.getElementById('remove-product-id').value;
    fetch(`http://localhost:8080/product/removeFromCart/${productId}`, {
        method: 'POST'
    }).then(() => {
        fetchCartProducts();
    });
});

fetchCartProducts();
