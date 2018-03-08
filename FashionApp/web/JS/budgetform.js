document.addEventListener("DOMContentLoaded", function () {
    // let tableHeader = document.querySelector("#list-header");
    let button = document.querySelector("#new-table");
    //let pgroup = document.querySelector("#product-group-list");
    let flist = document.querySelector("#final-list");
    let table = document.querySelector("#list-table");
    let addbutton = document.querySelector("#addRow");

    let show_json = document.querySelector("#sendjson");


    let themeNames = [];


    let theme = [{"themeid": 0, "amount": 0}];

    let row = {"form": {"product": "", "amountStyles": 0,
            "avgPrice": 0, "aamountStyles": 0, "totalSales": 0, "totalCover": 0},
        "themes": [theme]};
    let json_obj = {"rows": [row]};

    let rowList = [row];

    let amount_styles = 0;
    let total_sales = 0;
    //let cover_totals = 0;

    const productInput = document.querySelector("#product-input");

    let number;
    let rowCount = 0;

    let addThemes = function (amount) {
        let divs = "";
        for (i = 1; i <= amount; i++) {
            divs += "<th class='ib' id='theme" + i + "'><input type='text' id='text-theme" + i + "' placeholder='Theme name'> Theme";
            divs += i;
            divs += "</th>";

        }
        return divs;
    }




    button.addEventListener("click", function () {
        number = document.getElementById("number").value;
        //let amountOfWeeks = number.getAttribute("value");
        let element = document.querySelector("#themeAmount");
        let element2 = document.querySelector(".addButton");
        element.classList.add("hidden");
        element2.classList.remove("hidden");

        table.innerHTML +=
                `<tr>
        
        <th id="p-group">Product group</th>`
                + addThemes(number) +
                `<th class="ib id="A-styles">Amount of styles</th>
        <th class="ib" id="A-prices">Average price</th>
        <th class="ib" id="A-amount">Average amount/style</th>
        <th class="ib" id="T-sale">Total sale</th>
        <th class="ib" id="T-cover">Average cover 50% Total</th>
        </tr>`;

        addFinalInput();
    });

    addbutton.addEventListener("click", function () {
        buildJson();
        //restoreValues();
        table.innerHTML += addInput();
        restoreAllValues(false);



    });



    let addThemeInput = function (addRow) {
        let newRow = "";
        if (addRow) {
            for (i = 1; i <= number; i++) {

                newRow += `<td><input type="number"  id="theme-` + i + `-row-` + rowCount + `"></td>`;
            }

        } else {
            for (i = 1; i <= number; i++) {

                newRow += `<p id="theme-final` + i + `">t` + i + `</p>`;
            }

        }

        return newRow;


    };


    let addInput = function () {

        let rowline = "";
        rowCount++;
        rowline += `<tr>
        
        
        
        
        <td><input type="text"  id="pg-input` + rowCount + `"></td>
        
        ` + addThemeInput(true) + `
        <td><p id="as-input` + rowCount + `"></p></td>
        
        
        
        <td><input type="number"  id="ap-input` + rowCount + `"></td>
        
        
        
        <td><input type="number"  id="aa-input` + rowCount + `"></td>
        
        
        
        <td><p id="ts-input` + rowCount + `">sad</p></td>
        
        
        
        <td><p id="cover-input` + rowCount + `">dsa</p></td>
        
            </tr>`;



        return rowline;
    };




    let addFinalInput = function () {

        flist.innerHTML += `
        
        
        
        
        <p id="pg-final">pg</p>
        
        ` + addThemeInput(false) + `
        <p id="as-final">as</p>
        
        
        
        <p id="ap-final">ap</p>
        
        
        
        <p id="aa-final">aa</p>
        
        
        
        <p id="ts-final">ts</p>
        
        
        
        <p id="cover-final">cover</p>
        
        `;




    };

    productInput.addEventListener("input", function () {


        inputToCall();

    });

    let setThemeAmountInRow = function () {
        let amount = 0;
        console.log(rowCount);
        amount_styles = 0;
        for (i = 1; i <= rowCount; i++) {
            amount = 0;
            for (j = 1; j <= number; j++) {


                console.log("theme-" + j + "-row-" + i);
                amount += document.querySelector("#theme-" + j + "-row-" + i).value * 1;
                console.log(amount);
            }

            document.querySelector("#as-input" + i).textContent = amount;
            amount_styles += amount;
        }

        document.querySelector("#as-final").textContent = amount_styles;
        console.log("amoutn:" + amount);



    }



    let setTotalSale = function () {
        let total = 0;

        total_sales = 0;


        for (i = 1; i <= rowCount; i++) {
            let styles = Number(document.querySelector('#as-input' + i).textContent);
            let price = document.querySelector('#ap-input' + i).value;
            let amount = document.querySelector('#aa-input' + i).value;
            total = styles * price * amount;

            total_sales += total;


            document.querySelector("#ts-input" + i).textContent = total;

            document.querySelector("#cover-input" + i).textContent = total / 2;
        }

        document.querySelector("#ts-final").textContent = total_sales;
        document.querySelector("#cover-final").textContent = total_sales / 2;

    };

    let buildJson = function () {
        console.log("###################buildJson##############");

        theme = [];
        row = {"form": {"product": "", "amountStyles": 0,
                    "avgPrice": 0, "aamountStyles": 0, "totalSales": 0, "totalCover": 0}, "themes": [theme]};
        json_obj = {"rows": [row]};
        rowList = [];

        themeNames = [];


        for (j = 1; j <= number; j++) {
            let b = {"theme": document.querySelector("#text-theme" + j).value};
            themeNames.push(b);

        }




        let amount = 0;
        let amountOfStyles = 0;
        for (i = 1; i <= rowCount; i++) {
            row = {};
            theme = [];
            row = {"form": {"product": "", "amountStyles": 0,
                    "avgPrice": 0, "aamountStyles": 0, "totalSales": 0, "totalCover": 0}, "themes": [theme]};


            row.form.product = document.querySelector('#pg-input' + i).value;
            if (row.form.product === null) {
                row.form.product = "no name";
            }
            theme = [];
            amountOfStyles = 0;
            for (j = 1; j <= number; j++) {
                amount = 0;


                amount += document.querySelector("#theme-" + j + "-row-" + i).value * 1;
                theme.push({"themeid": j, "amount": amount});
                console.log(amount);
                amountOfStyles += amount;
            }

            row.themes = theme;

            row.form.amountStyles = amountOfStyles;
            // document.querySelector("#as-input" + i).textContent = row.amountStyles;
            row.form.avgPrice = parseFloat(document.querySelector('#ap-input' + i).value);
            row.form.aamountStyles = document.querySelector('#aa-input' + i).value;

            row.form.totalSales = row.form.amountStyles * row.form.aamountStyles * row.form.avgPrice;
            row.form.totalCover = row.form.totalSales / 2;



            json_obj.rows.push(row);
            rowList.push(row);
        }
        show_json.textContent = JSON.stringify(json_obj);

    };

    let restoreAllValues = function (isInput) {

        console.log("##########################restoreAllValue###########################");
        if (isInput) {
            for (let i = 1; i <= json_obj.rows.length - 1; i++) {

                let correctvalue = i;



                /*document.querySelector("#pg-input" + (correctvalue)).textContent = json_obj.rows[i].product;*/

                document.querySelector("#as-input" + (correctvalue)).textContent = json_obj.rows[i].form.amountStyles;



                document.querySelector("#ts-input" + (correctvalue)).textContent = json_obj.rows[i].form.totalSales;
                document.querySelector("#cover-input" + (correctvalue)).textContent = json_obj.rows[i].form.totalCover;

            }

        } else {



            for (let i = 1; i <= json_obj.rows.length - 1; i++) {

                let correctvalue = i;



                document.querySelector("#pg-input" + (correctvalue)).value = json_obj.rows[i].form.product;
                theme = json_obj.rows[i].themes;
                for (let t = 1; t <= json_obj.rows[i].themes.length; t++) {

                    document.querySelector("#theme-" + t + "-row-" + correctvalue).value = theme[t - 1].amount;
                }

                document.querySelector("#as-input" + (correctvalue)).textContent = json_obj.rows[i].form.amountStyles;

                document.querySelector("#ap-input" + (correctvalue)).value = json_obj.rows[i].form.avgPrice;
                document.querySelector("#aa-input" + (correctvalue)).value = json_obj.rows[i].form.aamountStyles;

                document.querySelector("#ts-input" + (correctvalue)).textContent = json_obj.rows[i].form.totalSales;
                document.querySelector("#cover-input" + (correctvalue)).textContent = json_obj.rows[i].form.totalCover;

            }
        }
    };
    inputToCall = function () {

        //setThemeAmountInRow();
        // setTotalSale();
        buildJson();
        // restoreValue();
        restoreAllValues(true);


    };

    let b = document.querySelector('#form-submit');
    b.addEventListener('click', function addForm(event) {


        ///////////////////////////////////////////add form
        for (let i of json_obj.rows) {
            const formUrl = "http://10.114.32.54:8080/FashionApp/ws/model.form/";
            let Formobj = "";



            Formobj += JSON.stringify(i.form);







            console.log(Formobj);




            fetch(formUrl, {

                headers: {"Content-type": "application/json"},
                body: Formobj,
                method: "POST"
            })
                    //.then(response => response.json())
                    .catch(error => console.error('Error: ' + error))
                    .then(response => console.log('Success:', response));

        }

/////////////////////////////////////////////////////////////add theme
        for (let i of themeNames) {
            const themeUrl = "http://10.114.32.54:8080/FashionApp/ws/model.themes/";
            let Themeobj = "";

            /*
             for (let i of themeNames) {
             
             let temp = i
             
             Themeobj += JSON.stringify(temp);
             
             }
             */
            Themeobj = JSON.stringify(i);
            document.querySelector('#sendtheme').textContent += Themeobj;




            fetch(themeUrl, {

                headers: {"Content-type": "application/json"},
                body: Themeobj,
                method: "POST"
            })
                    //.then(response => response.json())
                    .catch(error => console.error('Error: ' + error))
                    .then(response => console.log('Success:', response));
            //.then(json => console.log(json));
        }
    });

});