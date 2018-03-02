/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.addEventListener("DOMContentLoaded", function(event) {

let a = document.getElementById('adding');
a.addEventListener('click',function show() {
  document.getElementById("open").style.display = "block";
});


let b= document.getElementById('submit');
b.addEventListener('click',function add(event) {

  event.preventDefault();

  let code = document.getElementById("colorCode").value;
  let name = document.getElementById("colorName").value;

  var div = document.createElement("div");
  div.style.width = "100px";
  div.style.height = "100px";
  div.style.margin = "3px";
  div.style.background = "#" + code;

  document.getElementById("flex").appendChild(div);
  document.getElementById("open").style.display = "none";


/*const init={
  method:"POST",
  body: JSON.stringify({code:code, name:name}),
  headers:{
    'Accept': 'application/json'

  }
};*/
    const colorUrl = "http://10.114.32.54:8080/FashionApp/ws/model.colordb/";
    let color ={
        colorCode:code,
        colorName:name
    };

  fetch(colorUrl,{

    headers: { "Content-type": "application/json"},
      body: JSON.stringify(color),
      method:"POST"
  })
  //.then(response => response.json())
  .catch(error => console.error('Error: ' + error))
  .then(response => console.log('Success:', response));
  //.then(json => console.log(json));

});


});
