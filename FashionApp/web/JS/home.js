/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function () {

    let addbutton = document.querySelector("#addProject");
    let projectBox = document.querySelector("#projectbox");
    let darkArea = document.querySelector("#darkArea");

    let projectCount = 0;
    addbutton.addEventListener("click", function () {
        document.querySelector("#open").style.display = "block";
        let formContainer = document.querySelector(".form-container");
        formContainer.addEventListener("click", function (e) {
            e.stopPropagation();
        });
        darkArea.addEventListener("click", function () {
            document.querySelector("#open").style.display = "none";
        });
    });
    


    let b = document.getElementById('submit');
    b.addEventListener('click', function add(event) {


        console.log("you called button");

        projectBox.innerHTML += AddNewProject();

        console.log(projectCount);



        projectCount++;


        document.getElementById("open").style.display = "none";
    });

    let AddNewProject = function () {

        let text = "";


        text += `<div id="project` + projectCount + `" class="project-container">` + document.querySelector("#colorName").value + `
                    <a href="form.html">Budget</a>
                    <a href="color_picker.html">Colors</a>
                    <a href="testCards.html">Cards</a>
                    
                    
                </div>`;

        return text;

    };
    
    

let name = document.getElementById('addProject').value;
 
let project = {

"name" : name
};


fetch("http://10.114.32.54:8080/FashionApp/ws/model.project")
.then(res => res.json())
.then(function (project){
 
 // console.log(project[0].name);
  
  for(let i=0; i<project.length; i++){
     
     let myProject = document.getElementById("project");
     myProject.innerHTML += 
                  `<div id="project` + projectCount + `" class="project-container">
                  ` + project[i].name + `
                    <a href="form.html">Budget</a>
                    <a href="color_picker.html">Colors</a>
                    <a href="testCards.html">Cards</a>
                   </div>`;
   }

})


});


