//let nt = document.querySelector('#newTable');
//let tbldiv = document.querySelector('#tbldiv');
let tbl = document.createElement("table");

document.addEventListener("DOMContentLoaded", function(){   
        let tbl = document.createElement("table");
        let tr = document.createElement("tr");
        let th = document.createElement("th");
        let txt = document.createTextNode("hai!");
        let th2 = document.createElement("th");
        let txt2 = document.createTextNode("haiiii!");
        th.appendChild(txt);
        th2.appendChild(txt2);
        tr.appendChild(th);
        tr.appendChild(th2);
        tbl.appendChild(tr);
        document.querySelector('#newTable').addEventListener("click", function(){
        document.querySelector('#tbldiv').appendChild(tbl);
        
    });

});
