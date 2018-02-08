document.addEventListener("DOMContentLoaded", function () {
    let tableHeader = document.querySelector("#list-header");
    let button = document.querySelector("#new-table");
    let number;
    

    let addThemes = function (amount){
        let divs="";
        for(i = 1; i <= amount ; i++){
            divs+="<div class='ib'>Theme ";
            divs+=i;
            divs+="</div>";
        }
        return divs;
    }

    
    button.addEventListener("click", function(){
        number = document.getElementById("number").value;
        //let amountOfWeeks = number.getAttribute("value");
        tableHeader.innerHTML +=
        `<div class="ib">id</div>
        <div>Product group</div>`
        + addThemes(number) +
        `<div class="ib">Amount of styles</div>
        <div class="ib">Average price</div>
        <div class="ib">Average amount/style</div>
        <div class="ib">Total sale</div>
        <div class="ib">Average cover 50% Total</div>`
    })
});