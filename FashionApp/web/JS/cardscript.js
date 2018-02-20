document.addEventListener("DOMContentLoaded", function () {
    let button = document.querySelector("#createButton");
    button.addEventListener("click", function () {
        x = 4;
        y = 4;
        for (let rows = 0; rows < x; rows++) {
            let z = document.querySelector("table").insertRow(rows);
            for (let columns = 0; columns < y; columns++) {
                let v = z.insertCell(columns);
                v.innerHTML = "Row-" + rows + "Column-" + columns +
                    `<div class="aCard">
                    <div class="article">Article : </div>
                    <input type="text" placeholder="Article" class="code">

                    <div class="product">Product : </div>
                    <input type="text" placeholder="Product code" class="name">
                    
                    <div class="imgName">Image : </div>
                    <img src="images/johndoe.jpg" class="img">


                    <div class="buyPrice">Purchase PRICE / pc : </div>
                    <input type="number" placeholder="Price" class="buyNumber">

                    <div class="buyTotal">Total € : </div>
                    <input type="number" placeholder="Total" class="buyTotalNumber">

                    <div class="sellPrice">Selling PRICE / pc : </div>
                    <input type="number" placeholder="Price" class="sellNumber">

                    <div class="sellTotal">Total € : </div>
                    <input type="number" placeholder="Total" class="sellTotalNumber">


                    <div class="pieces">Pieces : </div>
                    <input type="number" placeholder="Pieces" class="piecesNumber">

                    <div class="material">Material : </div>
                    <input type="text" placeholder="Material" class="materialNames">

                    <div class="colors">Colors : </div>
                    <input type="text" placeholder="Colors" class="colorNames">

                    <div class="size">Sizes : </div>
                    <input type="text" placeholder="Sizes" class="sizeValues">


                <div>`;
            }
        }
    });
});