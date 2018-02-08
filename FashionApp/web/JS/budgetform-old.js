
document.addEventListener("DOMContentLoaded", function () {
    const productForm = document.querySelector("#product-form");

    let productGroupData = {};
    const urlBase = "https://adm-rest.herokuapp.com/";
    const productsUrl = urlBase + "products";

    let listProducts = function (productGroups) {
        const pglElement = document.querySelector("#product-group-list");
        pglElement.innerHTML = "";
        for (let pg of productGroups) {
            productsELement.innerHTML +=
               `<div>${pg.id}</div>
                <div>${pg.productGroup}</div>
                <div>${pg.week1}</div>
                <div><input type="text" name="net-price" value=${pg.}></div>
                <div">${pg.}</div>`;
        }
    }
});