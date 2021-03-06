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
    addButton.addEventListener("click", function () {
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
            let cardText = document.createElement("div");
            cardText.classList.add("simpleCardName");

            //card on click
            newCard.addEventListener("click", function () {
                //remove hidden from detailed card
                detailedCard.classList.remove("hidden");
                dark.classList.remove("behind");

                //adding the blank content to detailed card
                detailedCardContent.innerHTML = `
                <div class="hidden" id="id${newCard.id}"></div>

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
                <select class="colorNames" id="colors${newCard.id}" ></select>
                
                <div class="sizes lineHeight">Sizes: </div>
                <input type="text" class="sizeNames" id="sizes${newCard.id}" placeholder="Add...">
                
                <div class="amount lineHeight">Amount: </div>
                <input type="number" class="amountNumber" id="amount${newCard.id}">
                
                <div class="purchase lineHeight">Purchase price</div>
                <input type="number" class="purPrice" id="pur${newCard.id}">
                
                <div class="selling lineHeight">Selling price</div>
                <input type="number" class="selPrice" id="sel${newCard.id}">
                
                <div class="consumer lineHeight">Consumer price</div>
                <input type="number" class="conPrice" id="con${newCard.id}">
                
                <div class="empty"></div>
                <div class="loadButton">
                    <select class="load" id="lb${newCard.id}">
                    </select>
                </div>
                <div class="saveButton">
                    <div class="save buttons" id="sb${newCard.id}">Save</div>
                    <div class="update buttons" id="ub${newCard.id}">Update</div>
                </div>
                `;

                //setting the detailed card fields
                let thisId = document.querySelector(`#id${newCard.id}`);
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

                //colorfield
                thisColors.length = 0;

                let defaultColor = document.createElement("option");
                defaultColor.text = "Choose color";

                thisColors.add(defaultColor);
                thisColors.selectedIndex = 0;

                const colorUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/";

                let loadColors = function () {
                    fetch(colorUrl)
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
                                        option.text = data[i].colorName;
                                        option.value = data[i].colorID;
                                        option.setAttribute('data', `colorCode: ''`);
                                        option.dataset.colorCode = data[i].colorCode;
                                        thisColors.add(option);
                                    }

                                    /*thisColors.addEventListener("change", function () {
                                        thisColors.dataset.colorCode = data[thisColors.value].colorCode;
                                    });*/
                                });
                            });
                };

                loadColors();

                //load button
                let dropdown = document.querySelector(`#lb${newCard.id}`);
                dropdown.length = 0;

                let defaultOption = document.createElement("option");
                defaultOption.text = "Choose product...";

                dropdown.add(defaultOption);
                dropdown.selectedIndex = 0;

                const cardUrl = "http://10.114.32.54:8080/FashionApp/ws/model.solutioncard/";

                let loadDropdown = function () {

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
                                        let theValue = dropdown.value - 1;
                                        thisId.value = data[theValue].id;
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
                };
                loadDropdown();
                //if card name not null, search from database by the name and set all the fields accordingly...
                if (cardText.textContent.length > 0) {
                    fetch(cardUrl)
                        .then(
                            function (response) {
                                if (response.status !== 200) {
                                    console.warn('Looks like there was a problem. Status Code: ' +
                                        response.status);
                                    return;
                                }


                                response.json().then(function (data) {
                                    for (let i = 0; i < data.length; i++) {

                                        if (data[i].name == cardText.textContent) {
                                            //puts all the info from database to detailed card
                                            thisId.value = data[i].id;
                                            thisName.value = data[i].name;
                                            thisCode.value = data[i].articlecode;
                                            thisMaterials.value = data[i].materials;
                                            thisColors.value = data[i].colors;
                                            thisSizes.value = data[i].sizes;
                                            thisAmount.value = data[i].amount;
                                            thisPurPrice.value = data[i].pprice;
                                            thisSelPrice.value = data[i].sprice;
                                            thisConPrice.value = data[i].conprice;
                                            break;
                                        }
                                    }




                                });
                            });

                }

                //add name and bg to small card
                let updateSmallCard = function(){
                    let name = document.querySelector(".name").value;
                    cardText.textContent = name;
                    newCard.appendChild(cardText);
                    function setBG() {
                        fetch(colorUrl)
                            .then(
                                function (response) {
                                    if (response.status !== 200) {
                                        console.warn('Looks like there was a problem. Status Code: ' +
                                            response.status);
                                        return;
                                    }
    
                                    response.json().then(function (data) {
                                        newCard.style.background = data[thisColors.value-1].colorCode;
                                        console.log(thisColors.value);
                                        console.log('------------>' +  data[thisColors.value-1].colorCode);
                                    });
                                });
                    };
                    setBG();
                    
                }

                //save everything into the database
                let saveButton = document.querySelector(`#sb${newCard.id}`);
                saveButton.addEventListener("click", function () {
                    console.log(`sb${newCard.id}`);
                    
                    alert("Updated succesfully.");
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
                    console.log(colorNames); 
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
                        headers: { "Content-type": "application/json" },
                        body: JSON.stringify(card),
                        method: "POST"
                    })
                        .catch(error => console.error('Error: ' + error))
                        .then(response => console.log('Success:', response));
                    detailedCard.classList.add("hidden");
                    dark.classList.add("behind");

                    //add name and bg to small card
                    updateSmallCard();
                    

                });


                //Update
                let update = document.querySelector(`#ub${newCard.id}`);
                update.addEventListener("click", function () {

                    let card = {
                        "id": thisId.value,
                        "name": thisName.value,
                        "comment": thisName.value,
                        "articlecode": thisCode.value,
                        "amount": thisAmount.value,
                        "pprice": thisPurPrice.value,
                        "sprice": thisSelPrice.value,
                        "conprice": thisConPrice.value,
                        "materials": thisMaterials.value,
                        "sizes": thisSizes.value,
                        "img": thisImg.value,
                        "colors": thisColors.value
                    };

                    console.log(JSON.stringify(card));
                    fetch("http://10.114.32.54:8080/FashionApp/ws/model.solutioncard/" + thisId.value, {
                        headers: { "Content-type": "application/json" },
                        body: JSON.stringify(card),
                        method: "PUT"
                    })
                        .catch(error => console.error('Error: ' + error))
                        .then(response => console.log('Success:', response));
                    alert("Updated succesfully.");

                    updateSmallCard();
                    //clear dropdown here
                    while (dropdown.options.length > 0) {
                        dropdown.remove(0);
                    }
                    loadDropdown();

                });

                //closing detailed card
                let closeDetailedCard = document.querySelector("#closeDetailedCard");
                closeDetailedCard.addEventListener("click", function () {
                    detailedCard.classList.add("hidden");
                    dark.classList.add("behind");
                    
                    updateSmallCard();
                });
                //closing detailed card by clicking dark area
                let closeDetailedCardAround = document.querySelector("#dark");
                closeDetailedCardAround.addEventListener("click", function () {
                    detailedCard.classList.add("hidden");
                    dark.classList.add("behind");
                    
                    updateSmallCard();
                });
            });



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

    //Adding themes
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