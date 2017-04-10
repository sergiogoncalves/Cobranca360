/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function soNum(e) {

    var tecla = (window.event) ? event.keyCode : e.which;


    if ((tecla > 47 && tecla < 58))
    {
        return true;
    } else
    {
        if (tecla == 45) //Sinal de negativo
        {
            return true;
        } else if (tecla == 46) //Ponto
        {
            return true;
        } else if (tecla == 09) //TAB
        {
            return true;
        } else if (tecla == 08) //BACKSPACE
        {
            return true;
        } else
        {
            return false;
        }


    }
}

 function onlyNumbers(data){
      data.value = data.value.replace(/[^0-9]/g,'');
   };