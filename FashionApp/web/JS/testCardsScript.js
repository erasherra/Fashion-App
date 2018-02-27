document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let theme = document.querySelector(".aTheme");
    let number = 0;
    let addOutfit = addButton.addEventListener("click", function () {
        let outfitNumber = document.querySelectorAll(".outfit").length;
        number++;
        outfitNumber++;
        console.log(`Outfit ${outfitNumber} added.`)
        theme.insertAdjacentHTML('beforeend', 
            `<div class="outfit" id="outfit${number}">
        <div class="spaceBetween">
            <div class="title">Outfit ${outfitNumber}</div>
            <button class="remove" id="ob${number}">x</button>
        </div>
        <div class="aRow">
            <div class="aCard">+</div>
            <div class="aCard">+</div>
            <div class="aCard">+</div>
            <div class="aCard">+</div>
            <div class="aCard">+</div>
        </div>
    </div>`);

    let num = number;
        document.querySelector(`#ob${num}`).addEventListener("click", function () {
            document.querySelector(`#outfit${num}`).remove();
            console.log(`Outfit ${num} removed.`);
        });
    });



});