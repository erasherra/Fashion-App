document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let theme = document.querySelector(".aTheme");
    let detailedCard = document.querySelector("#detailedCard");
    let detailedCardArea = document.querySelector("#detailedCardArea");
    let detailedCardContent = document.querySelector("#detailedCardContent");
    let backHome = document.querySelector("#backHome");
    let dark = document.querySelector("#dark");
    let uniqueId = 0;
    let uniqueCardId = 0;
    backHome.addEventListener("click", function () {
        window.location.href = "http://10.114.32.54:8080/FashionApp/home.html"
    });
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
                <input type="text" class="name" id="name${newCard.id}" placeholder="Product name">
                <div id="deleteCardArea">
                    <button class="delete" id="closeDetailedCard">x</button>
                </div>
                <img src="images/cap.jpg" class="img" id="img${newCard.id}">
                
                <div class="article lineHeight">Article: </div>
                <input class="code" id="code${newCard.id}" placeholder="Article code">
                
                <div class="materials lineHeight">Materials: </div>
                <input type="text" class="materialNames" id="materials${newCard.id}" placeholder="Add...">
                
                <div class="colors lineHeight">Colors: </div>
                <input type="text" class="colorNames" id="colors${newCard.id}" placeholder="Add...">
                
                <div class="sizes lineHeight">Sizes: </div>
                <input type="text" class="sizeNames" id="sizes${newCard.id}" placeholder="Add...">
                
                <div class="amount lineHeight">Amount: </div>
                <input type="number" class="amountNumber" id="amount${newCard.id}">
                
                <div class="purchase lineHeight">Purchase price:</div>
                <input type="number" class="purPrice" id="pur${newCard.id}">
                
                <div class="selling lineHeight">Selling price:</div>
                <input type="number" class="selPrice" id="sel${newCard.id}">
                
                <div class="consumer lineHeight">Consumer price:</div>
                <input type="number" class="conPrice" id="con${newCard.id}">
                
                <div class="empty"></div>
                <div class="loadButton">
                    <select class="load buttons" id="lb${newCard.id}">
                    </select>
                </div>
                <div class="saveButton" id="sb${newCard.id}">
                    <div class="save buttons">Save</div>
                </div>
                `;

                //setting the detailed card fields
                let thisName = document.querySelector(`#name${newCard.id}`);
                let thisImg = document.querySelector(`#img${newCard.id}`);
                let thisCode = document.querySelector(`#code${newCard.id}`);
                let thisMaterials = document.querySelector(`#materials${newCard.id}`);
                let thisColors = document.querySelector(`#colors${newCard.id}`);
                let thisSizes = document.querySelector(`#sizes${newCard.id}`);
                let thisAmount = document.querySelector(`#amount${newCard.id}`);
                let thisPurPrice = document.querySelector(`#pur${newCard.id}`);
                let thisSelPrice = document.querySelector(`#sel${newCard.id}`);
                let thisConPrice = document.querySelector(`#con${newCard.id}`);


                //load button
                let dropdown = document.querySelector(`#lb${newCard.id}`);
                dropdown.length = 0;

                let defaultOption = document.createElement("option");
                defaultOption.text = "Choose product...";

                dropdown.add(defaultOption);
                dropdown.selectedIndex = 0;

                const cardUrl = "http://10.114.32.54:8080/FashionApp/ws/model.solutioncard/";

                fetch(cardUrl)
                        .then(
                                function (response) {
                                    if (response.status !== 200) {
                                        console.warn('Looks like there was a problem. Status Code: ' +
                                                response.status);
                                        return;
                                    }

                                    response.json().then(function (data) {
                                        let option;
                                        for (let i = 0; i < data.length; i++) {
                                            option = document.createElement('option');
                                            option.text = data[i].name;
                                            option.value = data[i].id;

                                            dropdown.add(option);
                                        }

                                        //puts all the info from database to detailed card
                                        dropdown.addEventListener("change", function () {
                                            console.log("jani");
                                            let theValue = dropdown.value - 1;
                                            thisName.value = data[theValue].name;
                                            thisCode.value = data[theValue].articlecode;
                                            thisMaterials.value = data[theValue].materials;
                                            thisColors.value = data[theValue].colors;
                                            thisSizes.value = data[theValue].sizes;
                                            thisAmount.value = data[theValue].amount;
                                            thisPurPrice.value = data[theValue].pprice;
                                            thisSelPrice.value = data[theValue].sprice;
                                            thisConPrice.value = data[theValue].conprice;

                                        });
                                    });
                                });




                //save card button functionality
                let saveCard = document.querySelector(`#sb${newCard.id}`);
                saveCard.addEventListener("click", function () {
                    //save everything into the database
                    console.log(`sb${newCard.id}`);
                    let saveButton = document.querySelector(`#sb${newCard.id}`);
                    saveButton.addEventListener("click", function () {

                        let name = document.querySelector(".name").value;
                        let code = document.querySelector(".code").value;
                        let materialNames = document.querySelector(".materialNames").value;
                        let colorNames = document.querySelector(".colorNames").value;
                        let sizeNames = document.querySelector(".sizeNames").value;
                        let amountNumber = document.querySelector(".amountNumber").value;
                        let purPrice = document.querySelector(".purPrice").value;
                        let selPrice = document.querySelector(".selPrice").value;
                        let conPrice = document.querySelector(".conPrice").value;
                        let comment = document.querySelector(".img").value;
                        let img = document.querySelector(".img").value;

                        const cardUrl = "http://10.114.32.54:8080/FashionApp/ws/model.solutioncard/";
                        let card = {
                            /*"name": name,
                             "articlecode": code,
                             "amount": amountNumber,
                             "pprice": purPrice,
                             "sprice": selPrice,
                             "conprice": conPrice,
                             "materials": materialNames,
                             "sizes": sizeNames,
                             "img": img,
                             "comment": comment,
                             "colors": colorNames
                             */
                            "name": name,
                            "comment": comment,
                            "articlecode": code,
                            "amount": amountNumber,
                            "pprice": purPrice,
                            "sprice": selPrice,
                            "conprice": conPrice,
                            "materials": materialNames,
                            "sizes": sizeNames,
                            "img": img,
                            "colors": colorNames
                        };

                        fetch(cardUrl, {
                            headers: {"Content-type": "application/json"},
                            body: JSON.stringify(card),
                            method: "POST"
                        })
                                .catch(error => console.error('Error: ' + error))
                                .then(response => console.log('Success:', response));
                    });
                });

                //closing detailed card
                let closeDetailedCard = document.querySelector("#closeDetailedCard");
                closeDetailedCard.addEventListener("click", function () {
                    detailedCard.classList.add("hidden");
                    dark.classList.add("behind");
                });
                //closing detailed card by clicking dark area
                let closeDetailedCardAround = document.querySelector("#dark");
                closeDetailedCardAround.addEventListener("click", function () {
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





});