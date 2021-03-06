document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let editButton = document.querySelector("#edit");
    let theme = document.querySelector(".aTheme");
    let colorCard = document.querySelector(".colorCard");
    let colorCardArea = document.querySelector("#colorCardArea");
    let backHome = document.querySelector("#backHome");
    let dark = document.querySelector("#dark");
    let uniqueId = 0;
    let uniqueCardId = 0;
    let exist = false;
    let colorId = 0;

    const colorUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/";

    backHome.addEventListener("click", function () {
        window.location.href = "http://10.114.32.54:8080/FashionApp/home.html";
    });

    let addOutfit = addButton.addEventListener("click", function () {
        let outfitNumber = document.querySelectorAll(".outfit").length;
        uniqueId++;
        outfitNumber++;
        console.log(`Outfit ${outfitNumber} added.`);
        theme.insertAdjacentHTML('beforeend',
                `<div class="outfit" id="outfit${uniqueId}">
                <div class="spaceBetween">
                    <div class="title"><input type="text" id="collectionName${uniqueId}" placeholder="Click to edit"></div>
                    <button class="remove" id="ob${uniqueId}">x</button>
                </div>
                <div class="aRow" id="row${uniqueId}">
                    <div class="addCard aCard" id="addCard${uniqueId}">+</div>
                    </div>
        <div class="commands">
        <div class="buttons" id="saveCollection${uniqueId}">Save collection</div>
        <div class="buttons" id="deleteCollection${uniqueId}">Delete collection</div>
        </div>
            </div>`);



        let num = uniqueId;
        document.querySelector(`#ob${num}`).addEventListener("click", function (e) {
            if (!confirm("Do you really want to delete this?")) {
                e.preventDefault(); //Cancel deleting
            } else {
                document.querySelector(`#outfit${num}`).remove();
                console.log(`Outfit ${num} removed.`);
                /* let setId = 0;
                 let titles = document.querySelectorAll(".title");
                 for (let title of titles) {
                 setId++;
                 title.innerHTML = `Chart ${setId}`;
                 }*/
            }
        });

        let addCard = document.querySelector(`#addCard${num}`);
        addCard.addEventListener("click", function () {
            uniqueCardId++;

            let fullBox = document.createElement("div");
            fullBox.classList.add("fullBox");
            fullBox.id = `fullBox${uniqueCardId}`;

            let newCard = document.createElement("div");
            newCard.classList.add("addCard");
            newCard.id = `card${uniqueCardId}`;
            newCard.classList.add("simpleCard");

            let cardText = document.createElement("div");
            cardText.classList.add("cardText");
            cardText.id = `cardText${uniqueCardId}`;



            fullBox.appendChild(newCard);
            fullBox.appendChild(cardText);





            //card on click
            newCard.addEventListener("click", function () {


                colorCard.innerHTML = `<div class="innerCard" id="innerCard${newCard.id}" >

                       <div id="deleteCardArea">
                            <button id="closeDetailedCard" class="remove">x</button>
                        </div>
                        <form id="open color${newCard.id}" class="addColorForm" onsubmit="return false">
                            <div class="form-container">
                                <div class="center">
                                    <label>Color name:</label>

                                    <input type="text" id="colorName${newCard.id}">
                                </div>
                                </br>
                                <div class="center">
                                    <label>Color code:</label>
                                    <input type="text" id="colorCode${newCard.id}" placeholder="eg. #FF0000">

                                    </br>
                
                                    <input type="color" id="colorMapCode${newCard.id}" value="#FF0000">
                                </div>
                                <div><select class="loadValues" id="dropDown${newCard.id}"></select></div>                                
                                <div class="buttons" id="colorButton${newCard.id}" > Add Color </div>
                                <div class="buttons" id="updateButton${newCard.id}" > Update Color </div>
                                
                                
                                
                            </div>
                        </form>

                    </div>`;
                let colorName = document.querySelector(`#colorName${newCard.id}`);
                let colorCode = document.querySelector(`#colorCode${newCard.id}`);
                let colorMapCode = document.querySelector(`#colorMapCode${newCard.id}`);
                let dropdown = document.querySelector(`#dropDown${newCard.id}`);

                if (cardText.textContent.length > 0) {
                    colorName.value = cardText.textContent;

                    // colorCode.value = colorCode.textContent;
                    // colorMapCode.value = colorMap.value;
                    const updateUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/name/" + cardText.textContent;
                    const processJSON = (function (json) {
                        colorName.value = json.colorName;
                        colorCode.value = json.colorCode;
                        colorMapCode.value = json.colorCode;
                        colorId = json.colorID;

                    });
                    fetch(updateUrl)
                            .then(response => response.json())
                            .then(processJSON);

                }

                dropdown.length = 0;
                let defaultOption = document.createElement("option");
                defaultOption.text = "Choose color";
                dropdown.add(defaultOption);
                dropdown.selectedIndex = 0;

                let loadDropdown = function () {

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

                                                dropdown.add(option);
                                            }

                                            //puts all the info from database to colorcard 
                                            dropdown.addEventListener("change", function () {
                                                let theValue = dropdown.value - 1;
                                                colorId = data[theValue].colorID;
                                                colorName.value = data[theValue].colorName;
                                                colorCode.value = data[theValue].colorCode;
                                                colorMapCode.value = data[theValue].colorCode;


                                                colorName = colorName.value;
                                                colorCode = colorCode.value;
                                                console.log(colorId + ", " + colorName + ", " + colorCode)
                                            });
                                        });
                                    });

                };
                loadDropdown();








                let colorMap = document.querySelector(`#colorMapCode${newCard.id}`);

                // Update colorcodefield from colormap
                colorMap.addEventListener("input", function () {
                    let colorCodeASDF = document.querySelector(`#colorCode${newCard.id}`);
                    colorCodeASDF.value = colorMap.value;

                });

                // Save colorname and -code, make box show changes
                let saveColor = document.querySelector(`#colorButton${newCard.id}`);
                saveColor.addEventListener("click", function () {

                    let colorCode = document.querySelector(`#colorCode${newCard.id}`).value;
                    let colorName = document.querySelector(`#colorName${newCard.id}`).value;
                    console.log(`colorbutton${newCard.id}`);
                    newCard.style.background = colorCode;
                    cardText.textContent = colorName;
                    colorCard.classList.add("hidden");
                    dark.classList.add("behind");


                    let color = {
                        colorCode: colorCode,
                        colorName: colorName
                    };

                    fetch(colorUrl, {

                        headers: {"Content-type": "application/json"},
                        body: JSON.stringify(color),
                        method: "POST"
                    })
                            //.then(response => response.json())
                            .catch(error => console.error('Error: ' + error))
                            .then(response => console.log('Success:', response));
                    //.then(json => console.log(json));

                });

                // update existing color
                let updateColor = document.querySelector(`#updateButton${newCard.id}`);
                updateColor.addEventListener("click", function () {

                    let colorCode = document.querySelector(`#colorCode${newCard.id}`).value;
                    let colorName = document.querySelector(`#colorName${newCard.id}`).value;
                    newCard.style.background = colorCode;

                    console.log(" Tämä toivottavasti näkyisi: " + colorId);

                    let color = {
                        colorCode: colorCode,
                        colorName: colorName,
                        colorID: colorId
                    };

                    const updateUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/" + colorId;

                    cardText.textContent = colorName;

                    fetch(updateUrl, {

                        headers: {"Content-type": "application/json"},
                        body: JSON.stringify(color),
                        method: "PUT"
                    })
                            //.then(response => response.json())
                            .catch(error => console.error('Error: ' + error))
                            .then(response => console.log('Success:', response));


                    colorCard.classList.add("hidden");
                    dark.classList.add("behind");
                });


                // Close colorcard
                let closeDetailedCard = document.querySelector("#closeDetailedCard");
                closeDetailedCard.addEventListener("click", function () {
                    colorCard.classList.add("hidden");
                    dark.classList.add("behind");
                });


                colorCard.classList.remove("hidden");
                dark.classList.remove("behind");
                console.log("asdfasdfasdf");
            });



            //ADD TEXT
            /*  let cardText = document.createElement("div");
             cardText.classList.add("simpleCardName");
             cardText.textContent = uniqueCardId;
             newCard.appendChild(cardText); */



            //ADD DELETE
            let deleteCard = document.createElement("button");
            deleteCard.classList.add("simpleCardDel");
            deleteCard.classList.add("remove");
            deleteCard.textContent = "x";
            deleteCard.id = `dc${uniqueCardId}`;
            newCard.appendChild(deleteCard);



            let aRow = document.querySelector(`#row${num}`);
            aRow.insertBefore(fullBox, addCard);
            console.log("hai");
            let cardId = uniqueCardId;
            //Listener for delete
            document.querySelector(`#dc${cardId}`).addEventListener("click", function (e) {
                console.log("asd");
                e.stopPropagation();
                if (!confirm("Do you really want to delete this?")) {
                    e.preventDefault(); //Cancel deleting
                } else {
                    document.querySelector(`#fullBox${cardId}`).remove();
                }
            });

        });


        let saveCollection = document.querySelector(`#saveCollection${uniqueId}`);
        saveCollection.addEventListener("click", function () {
            console.log("Saving collections here" + `#saveCollection${uniqueId}`);
            let collectionName = document.querySelector(`#collectionName${uniqueId}`);

            let colorString = "";
            let colorFinalString;
            let x = document.querySelectorAll(`#outfit${uniqueId} .aRow .fullBox .cardText`);
            for (let i = 1; i < x.length; i++) {

                if (x[i].textContent.length > 0) {
                    colorString = colorString + `"color${i}":` + `"` + x[i].textContent + `",`;
                }
                if (i == x.length - 1)
                {
                    colorFinalString = colorString.slice(0, -1);

                }

            }
            console.log(colorFinalString);
            let collection = {colorFinalString};
            console.log(collection);

        });

    });







});