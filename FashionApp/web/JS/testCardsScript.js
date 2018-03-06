document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let theme = document.querySelector(".aTheme");
    let detailedCard = document.querySelector("#detailedCard");
    let detailedCardArea = document.querySelector("#detailedCardArea");
    let detailedCardContent = document.querySelector("#detailedCardContent");

    let dark = document.querySelector("#dark");
    let uniqueId = 0;
    let uniqueCardId = 0;
    let addOutfit = addButton.addEventListener("click", function () {
        let outfitNumber = document.querySelectorAll(".outfit").length;
        uniqueId++;
        outfitNumber++;
        console.log(`Outfit ${outfitNumber} added.`);
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

                //Outfit texts number part
                let setId = 0;
                let titles = document.querySelectorAll(".title");
                for (let title of titles) {
                    setId++;
                    title.innerHTML = `Outfit ${setId}`;
                }
            }
        });

        //creating the small card
        let addCard = document.querySelector(`#addCard${num}`);
        addCard.addEventListener("click", function () {
            uniqueCardId++;
            let newCard = document.createElement("div");
            newCard.classList.add("addCard");
            newCard.id = `card${uniqueCardId}`;
            newCard.classList.add("simpleCard");

            //card on click
            newCard.addEventListener("click", function () {
                //remove hidden from detailed card
                detailedCard.classList.remove("hidden");
                dark.classList.remove("behind");

                //adding the content to detailed card
                detailedCardContent.innerHTML = `
                <input type="text" class="name" placeholder="Product name">
                <div id="deleteCardArea">
                    <button class="delete" id="closeDetailedCard">x</button>
                </div>
                <img src="images/cap.jpg" class="img">
                <div class="article lineHight">Article: </div>
                <input class="code" placeholder="Article code">
                <div class="materials lineHight">Materials: </div>
                <input type="text" class="materialNames" placeholder="Add...">
                <div class="colors lineHight">Colors: </div>
                <input type="text" class="colorNames" placeholder="Add...">
                <div class="sizes lineHight">Sizes: </div>
                <input type="text" class="sizeNames" placeholder="Add...">
                <div class="amount lineHight">Amount: </div>
                <input type="number" class="amountNumber">
                <div class="purchase lineHight">Purchase price</div>
                <input type="number" class="purPrice">
                <div class="selling lineHight">Selling price</div>
                <input type="number" class="selPrice">
                <div class="consumer lineHight">Consumer price</div>
                <input type="number" class="conPrice">
                <div class="empty"></div>
                <div class="loadButton">
                    <select>
                        <option value="Hat">Hat</option>
                        <option value="Pants">Pants</option>
                        <option value="Scarf">Scarf</option>
                        <option value="Yeezys">Yeezys</option>
                    </select>
                </div>
                <div class="saveButton" id="sb${uniqueCardId}">
                    <div class="save buttons">Save</div>
                </div>
                `;
                //save card button functionality
                let saveCard = document.querySelector(`#sb${uniqueCardId}`);
                saveCard.addEventListener("click", function(){
                    //save everything into the database
                });

                //closing detailed card
                let closeDetailedCard = document.querySelector("#closeDetailedCard");
                closeDetailedCard.addEventListener("click", function () {
                    detailedCard.classList.add("hidden");
                    dark.classList.add("behind");
                });


            });

            //ADD TEXT
            let cardText = document.createElement("div");
            cardText.classList.add("simpleCardName");
            cardText.textContent = uniqueCardId;
            newCard.appendChild(cardText);

            //ADD DELETE
            let deleteCard = document.createElement("button");
            deleteCard.classList.add("simpleCardDel");
            deleteCard.classList.add("remove");
            deleteCard.textContent = "x";
            deleteCard.id = `dc${uniqueCardId}`;
            newCard.appendChild(deleteCard);

            //ADD IMAGE
            //let cardImg = document.createElement("div");

            let aRow = document.querySelector(`#row${num}`);
            aRow.insertBefore(newCard, addCard);
            console.log("hai");
            let cardId = uniqueCardId;
            //Listener for delete
            document.querySelector(`#dc${cardId}`).addEventListener("click", function (e) {
                console.log("asd");
                e.stopPropagation();
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
        newTheme.classList.add("themeButton");
        newTheme.classList.add("buttons");
        newTheme.innerHTML = `Theme ${themeAmount}`;
        let aThemeRow = document.querySelector(".themeRow");
        aThemeRow.insertBefore(newTheme, addTheme);
        console.log(`Theme ${themeAmount} added`);
    });


    /*
        let saveButton = document.querySelector(".saveButton");
        saveButton.addEventListener("click", function() {
            let name = document.querySelector(".name").value;
            let code = document.querySelector(".code").value;
            let materialNames = document.querySelector(".materialNames").value;
            let colorNames = document.querySelector(".colorNames").value;
            let sizeNames = document.querySelector(".sizeNames").value;
            let amountNumber = document.querySelector(".amountNumber").value;
            let purPrice = document.querySelector(".purPrice").value;
            let selPrice = document.querySelector(".selPrice").value;
            let conPrice = document.querySelector(".conPrice").value;
            
            const cardUrl = "http://10.114.32.54:8080/FashionApp/ws/model.cards/";
            let card = {
                code: code,
                materialNames: name
                colorNames: 
            });
        });
    */
});