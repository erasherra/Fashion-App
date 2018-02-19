document.addEventListener("DOMContentLoaded", function () {
    let button = document.querySelector("#createButton");
    button.addEventListener("click", function () {
        x = 2;
        y = 2;
        for (let rows = 0; rows < x; rows++) {
            let z = document.querySelector("table").insertRow(rows);
            for (let colNum = 0; colNum < y; colNum++) {
                let v = z.insertCell(colNum);
                v.innerHTML = "Row-" + rows + "Column-" + colNum + 
                `<div class="aCard">
                    <div class="article">article : </div>
                    <input type="text" placeholder="article" class="code">

                    <div class="product">product : </div>
                    <input type="text" placeholder="product" class="name">
                    

                    <img src="johndoe.jpg" class="img">


                    <div class="buyPrice">purchase PRICE / pc : </div>
                    <input type="text" placeholder="price" class="buyNumber">

                    <div class="buyTotal">Total € : </div>
                    <input type="text" placeholder="total" class="buyTotalNumber">

                    <div class="sellPrice">selling PRICE / pc : </div>
                    <input type="text" placeholder="price" class="sellNumber">

                    <div class="sellTotal">Total € : </div>
                    <input type="text" placeholder="total" class="sellTotalNumber">


                    <div class="pieces">PIECES : </div>
                    <input type="text" placeholder="price" class="piecesNumber">

                    <div class="material">MATERIAL : </div>
                    <input type="text" placeholder="price" class="materialNames">

                    <div class="colors">COLORS : </div>
                    <input type="text" placeholder="price" class="colorNames">

                    <div class="size">SIZES : </div>
                    <input type="text" placeholder="price" class="sizeValues">


                <div>`;
            }
        }
    
});
});