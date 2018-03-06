document.addEventListener("DOMContentLoaded", function () {
    let addButton = document.querySelector("#add");
    let editButton = document.querySelector("#edit");
    let theme = document.querySelector(".aTheme");
    let colorCard = document.querySelector(".colorCard");
    let colorCardArea = document.querySelector("#colorCardArea");

    let dark = document.querySelector("#dark");
    let uniqueId = 0;
    let uniqueCardId = 0;
    let innerId = 0;
    let putHere = document.querySelector(".putHere");
    let addColor = document.querySelector('#addColor');
    let addOutfit = addButton.addEventListener("click", function () {
        let outfitNumber = document.querySelectorAll(".outfit").length;
        uniqueId++;
        outfitNumber++;
        console.log(`Outfit ${outfitNumber} added.`);
        theme.insertAdjacentHTML('beforeend',
                `<div class="outfit" id="outfit${uniqueId}">
                <div class="spaceBetween">
                    <div class="title">Chart ${outfitNumber}</div>
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
                let titles = document.querySelectorAll(".title");
                for (let title of titles) {
                    setId++;
                    title.innerHTML = `Chart ${setId}`;
                }
            }
        });

        let addCard = document.querySelector(`#addCard${num}`);
        addCard.addEventListener("click", function () {
            uniqueCardId++;
            let newCard = document.createElement("div");
            newCard.classList.add("addCard");
            newCard.id = uniqueCardId;
            newCard.classList.add("simpleCard");





            //card on click
            newCard.addEventListener("click", function () {
                //remove hidden from detailed card

                colorCard.innerHTML = `<div class="innerCard" id="innerCard${newCard.id}" >

                       <div id="deleteCardArea">
                            <button id="closeDetailedCard" class="remove">x</button>
                        </div>
                        <form id="open color${newCard.id}" class="addColorForm" onsubmit="return false">
                            <div class="form-container">
                                <div class="center">
                                    <label>Color name:</label>

                                    <input type="text" id="colorName">
                                </div>
                                </br>
                                <div class="center">
                                    <label>Color code:</label>
                                    <input type="text" id="colorCode">

                                    </br>
                                </div>

                                <div class="buttons" id="colorButton${newCard.id}"> Add Color </div>
                                
                                
                            </div>
                        </form>

                    </div>`;
                
                let saveColor = document.querySelector(`#colorButton${newCard.id}`);
                saveColor.addEventListener("click", function (){
                    
                   let colorCode = document.querySelector("#colorCode").value;
                   console.log(`colorbutton${newCard.id}`);
                   newCard.style.background = "#" + colorCode;
                   colorCard.classList.add("hidden");
                    dark.classList.add("behind");
                    
                });
                
                

                let closeDetailedCard = document.querySelector("#closeDetailedCard");
                closeDetailedCard.addEventListener("click", function () {
                    colorCard.classList.add("hidden");
                    dark.classList.add("behind");
                });


                colorCard.classList.remove("hidden");
                dark.classList.remove("behind");
                console.log("asdfasdfasdf");
            });



            /*  //ADD TEXT
             let cardText = document.createElement("div");
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



    /*addColor.addEventListener("click", function () {
     
     const colorUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/";
     
     
     
     let code = document.getElementById("colorCode").value;
     let name = document.getElementById("colorName").value;
     
     let color = {
     colorCode: code,
     colorName: name
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
     colorCard.classList.add("hidden");
     dark.classList.add("behind");
     
     
     
     
     });*/



});