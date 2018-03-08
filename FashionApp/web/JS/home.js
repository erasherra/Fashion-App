/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function () {
    
    let addbutton = document.querySelector("#addProject");
    let projectBox = document.querySelector("#projectbox");
    let projectCount = 0;
    
    addbutton.addEventListener("click",function(){
        document.getElementById("open").style.display = "block";
        
    });
    
    let b= document.getElementById('submit');
    b.addEventListener('click',function add(event) {
        
        
        console.log("you called button");
        
        projectBox.innerHTML += AddNewProject();
        
        console.log(projectCount);
        
        
        projectCount++;
        
        document.getElementById("open").style.display = "none";
    });
    
    
    let AddNewProject = function (){
        
        let text = "";
        
        text += `<div id="project`+projectCount+`" class="project-container">`+ document.querySelector("#colorName").value +`
                    <a href="form.html">Budget</a>
                    <a href="color_picker.html">Colors</a>
                    <a href="testCards.html">Cards</a>
                </div>`;
        
        return text;
        
    };
   
   const projectURL = "http://10.114.32.54:8080/FashionApp/ws/model.project";
   let Projects;

                fetch(projectURL)
                        .then(
                                function (response) {
                                    if (response.status !== 200) {
                                        console.warn('Error: Status Code: ' +
                                                response.status);
                                        return;
                                    }

                                    response.json().then(function (data) {
                                        let row;
                                        for (let i = 0; i < data.length; i++) {
                                            row = document.createElement('row');
                                            row.value = data[i].cards.id;
                                           
                                            console.log(row.value);
                                            Projects.add(row);
   
                                        }

                                       
                });
       });
    
});


