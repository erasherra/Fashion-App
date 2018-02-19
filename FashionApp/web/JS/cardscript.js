document.addEventListener("DOMContentLoaded", function () {
    let button = document.querySelector("#createButton");
    button.addEventListener("click", function () {
        x = 3;
        y = 5;
        for (let r = 0; r < x; r++) {
            let z = document.querySelector("table").insertRow(r);
            for (let c = 0; c < y; c++) {
                let v = z.insertCell(c);
                v.innerHTML = "Row-" + r + "Column-" + c;
            }
        }
    
});
});