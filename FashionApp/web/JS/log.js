/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function (event) {
   
    //////////////////////////////////////////////////////showsall
    function showAll(response) {
        console.log(response);
        const output = document.querySelector("h3");
        
        

    }


const addUrl = "http://10.114.32.54:8080/FashionApp/FashionApp/ws/Auth/login";
    const submitBtn = document.querySelector("#addbutton");
    submitBtn.addEventListener("click", function () {
        
        let fname = document.querySelector("#un").value;
        let lname = document.querySelector("#pw").value;
        let data = {
            user: lname,
            password: fname
        };
        
        let init = {
            headers: {'content-type': 'application/json'},
            body: JSON.stringify(data),
            method: 'post'
        };
        //alert(data.lastName);
        return fetch(addUrl, init )
                .then(response => response)
                .then(showAll);
    });



});
