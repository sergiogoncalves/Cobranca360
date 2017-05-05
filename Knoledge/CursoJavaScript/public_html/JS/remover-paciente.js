var pacientes = document.querySelectorAll(".paciente");

var tabela = document.querySelector("table");


tabela.addEventListener("dblclick", function (event) {
        
        event.target.parentNode.classList.add("fadeOut");
        setTimeout(function(){
            event.target.parentNode.remove();
        }, 500);
        
});

console.log(pacientes);

console.log("Vai ler o paciente");


//for (var i = 0; i <= pacientes.length; i++) {
//    var paciente = pacientes[i];

//    paciente.addEventListener("dblclick", function () {

//        this.remove();
//    });

//}





console.log("Passou pelos pacientes");