document.addEventListener("DOMContentLoaded", () => {
  const productsContainer = document.getElementById("products-container");

  fetch("/api/products")
      .then(response => response.json())
      .then(products => {
          products.forEach(product => {
              const productCard = document.createElement("div");
              productCard.className = "product-card";
              productCard.innerHTML = `
                  <img src="${product.imageUrl}" alt="${product.name}">
                  <h3>${product.name}</h3>
                  <p>${product.description}</p>
                  <p>¥${product.price}</p>
                  <button>購入する</button>
              `;
              productsContainer.appendChild(productCard);
          });
      });
});
