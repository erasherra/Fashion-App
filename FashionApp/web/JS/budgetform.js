document.addEventListener("DOMContentLoaded", function () {
    let tableHeader = document.querySelector("#list-header");
    let button = document.querySelector("#new-table");
    let pgroup = document.querySelector("#product-group-list");
    let flist = document.querySelector("#final-list");
    let table = document.querySelector("#list-table");
    let addbutton = document.querySelector("#addRow");

    let show_json = document.querySelector("#sendjson");
    
    let theme = [];
    let row = {"ID": 0, "product":"","themes":[],"amountStyles":0,
        "averagePrice":0,"avarageAmount":0, "totalSale":0,"cover":0};
    let json_obj = {"rows":[]};
        
    let AllThemes = [];
    let Themelist = [];

    let amount_styles = 0;
    let total_sales = 0;
    //let cover_totals = 0;
    
    const productInput = document.querySelector("#product-input");

    let number;
    let rowCount = 0;

    let addThemes = function (amount) {
        let divs = "";
        for (i = 1; i <= amount; i++) {
            divs += "<th class='ib' id='theme" + i + "'>Theme ";
            divs += i;
            divs += "</th>";

        }
        return divs;
    }




    button.addEventListener("click", function () {
        number = document.getElementById("number").value;
        //let amountOfWeeks = number.getAttribute("value");
        table.innerHTML +=
                `<tr>
        <th class="ib" id="id-id">id</th>
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

        table.innerHTML += addInput();



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

        let row = "";
        rowCount++;
        row += `<tr>
        <td><input type="number"  id="id-input` + rowCount + `"></td>
        
        
        
        <td><input type="text"  id="pg-input` + rowCount + `"></td>
        
        ` + addThemeInput(true) + `
        <td><p id="as-input` + rowCount + `"></p></td>
        
        
        
        <td><input type="number"  id="ap-input` + rowCount + `"></td>
        
        
        
        <td><input type="number"  id="aa-input` + rowCount + `"></td>
        
        
        
        <td><p id="ts-input` + rowCount + `">sad</p></td>
        
        
        
        <td><p id="cover-input` + rowCount + `">dsa</p></td>
        
            </tr>`;


        return row;
    }

    let addFinalInput = function () {

        flist.innerHTML += `
        <p id="id-final">id</p>
        
        
        
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
        console.log("works");

        AllStyles();

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
            let price = document.querySelector('#ap-input'+i).value;
            let amount = document.querySelector('#aa-input'+i).value;
            total = styles * price * amount;
            
            total_sales += total;
            
            
            document.querySelector("#ts-input" + i).textContent = total;
            
            document.querySelector("#cover-input" + i).textContent = total/2;
        }
        
            document.querySelector("#ts-final").textContent = total_sales;
            document.querySelector("#cover-final").textContent = total_sales/2;
        
    };
    
    let buildJson = function(){
        
        
        theme = [];
        row = {"ID": 0, "product":"","themes":[],"amountStyles":0,
        "averagePrice":0,"avarageAmount":0, "totalSale":0,"cover":0};
        json_obj = {"rows":[]};
        
        let amount = 0;
        for (i = 1; i <= rowCount; i++) {
            
            row.ID = i;
            row.product = "no name";
            for (j = 1; j <= number; j++) {
                amount = 0;

                console.log("theme-" + j + "-row-" + i);
                amount += document.querySelector("#theme-" + j + "-row-" + i).value * 1;
                theme.push({"themeid":j, "amount":document.querySelector("#theme-" + j + "-row-" + i).value});
                console.log(amount);
            }
            
            row.themes = theme;
            
            row.amountStyles = Number(document.querySelector("#ts-input" + i).textContent);
            row.averagePrice = document.querySelector('#ap-input'+i).value;
            row.avarageAmount = document.querySelector('#aa-input'+i).value;
            
            row.totalSale = row.amountStyles * row.avarageAmount * row.averagePrice;
            row.cover = row.totalSale/2;
            
            json_obj.rows.push(row);
            
        }
        show_json.textContent = JSON.stringify(json_obj);
        
    };

    AllStyles = function () {

        setThemeAmountInRow();
        setTotalSale();
        buildJson();




    };


});