document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let theme = document.querySelector(".aTheme");
    let detailedCard = document.querySelector("#detailedCard");
    let detailedCardArea = document.querySelector("#detailedCardArea");
    let closeDetailedCard = document.querySelector("#closeDetailedCard");
    let dark = document.querySelector("#dark");
    let uniqueId = 0;
    let uniqueCardId = 0;
    let addOutfit = addButton.addEventListener("click", function () {
        let outfitNumber = document.querySelectorAll(".outfit").length;
        uniqueId++;
        outfitNumber++;
        console.log(`Outfit ${outfitNumber} added.`)
        theme.insertAdjacentHTML('beforeend',
            `<div class="outfit" id="outfit${uniqueId}">
                <div class="spaceBetween">
                    <div class="title">Outfit ${outfitNumber}</div>
                    <button class="remove" id="ob${uniqueId}">x</button>
                </div>
                <div class="aRow" id="row${uniqueId}">
                    <div class="addCard aCard" id="addCard${uniqueId}">+</div>
                </div>
            </div>`);

        let num = uniqueId;
        document.querySelector(`#ob${num}`).addEventListener("click", function (e) {
            if (!confirm("Do you really want to delete this?")) {
                e.preventDefault(); //Cancel deleting
            } else {
                document.querySelector(`#outfit${num}`).remove();
                console.log(`Outfit ${num} removed.`);
                let setId = 0;
                let titles = document.querySelectorAll(".title")
                for (let title of titles) {
                    setId++;
                    title.innerHTML = `Outfit ${setId}`;
                }
            }
        });

        let addCard = document.querySelector(`#addCard${num}`);
        addCard.addEventListener("click", function () {
            uniqueCardId++;
            let newCard = document.createElement("div");
            newCard.classList.add("addCard")
            newCard.id = `card${uniqueCardId}`;
            newCard.classList.add("simpleCard");

            //card on click
            newCard.addEventListener("click", function () {
                //remove hidden from detailed card
                detailedCard.classList.remove("hidden");
                dark.classList.remove("behind");
            });

            //ADD TEXT
            let cardText = document.createElement("div");
            cardText.classList.add("simpleCardName");
            cardText.textContent = uniqueCardId;
            newCard.appendChild(cardText);

            //ADD DELETE
            let deleteCard = document.createElement("button");
            deleteCard.classList.add("simpleCardDel")
            deleteCard.classList.add("remove");
            deleteCard.textContent = "x";
            deleteCard.id = `dc${uniqueCardId}`;
            newCard.appendChild(deleteCard);



            let aRow = document.querySelector(`#row${num}`);
            aRow.insertBefore(newCard, addCard);
            console.log("hai");
            let cardId = uniqueCardId;
            //Listener for delete
            document.querySelector(`#dc${cardId}`).addEventListener("click", function (e) {
                console.log("asd");
                if (!confirm("Do you really want to delete this?")) {
                    e.preventDefault(); //Cancel deleting
                } else {
                    document.querySelector(`#card${cardId}`).remove();
                }
            });

        });
    });

    let addTheme = document.querySelector(".plusImg");
    let themeAmount = document.querySelectorAll(".themeButton").length;
    addTheme.addEventListener("click", function () {
        themeAmount++;
        let newTheme = document.createElement("div");
        newTheme.classList.add("themeButton")
        newTheme.classList.add("buttons")
        newTheme.innerHTML = `Theme ${themeAmount}`;
        let aThemeRow = document.querySelector(".themeRow");
        aThemeRow.insertBefore(newTheme, addTheme);
        console.log(`Theme ${themeAmount} added`);
    });

    closeDetailedCard.addEventListener("click", function () {
        detailedCard.classList.add("hidden");
        dark.classList.add("behind");
    });



});