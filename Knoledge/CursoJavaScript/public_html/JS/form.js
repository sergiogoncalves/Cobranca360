var botaoAdicionar = document.querySelector("#adicionar-paciente");

console.log(botaoAdicionar);
botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var paciente = obtemPacienteDoFormulario(form);

    var pacienteTr = montaTr(paciente);

    var erros = validaPaciente(paciente);

    if (erros.length > 0) {
        var mensagemErro = document.querySelector("#mensagem-erro");

        exibeMensagemErros(erros);

        return;

    }

    var tabela = document.querySelector("#tabela-pacientes");

    tabela.appendChild(pacienteTr);

    form.reset();

    var ul = document.querySelector("#mensagem-erro");
    ul.innerHTML = "";
});


function obtemPacienteDoFormulario(form) {

    var paciente = {
        nome: form.nome.value,
        peso: form.peso.value,
        altura: form.altura.value,
        gordura: form.gordura.value,
        imc: calculaImc(form.peso.value, form.altura.value)
    };

    return paciente;

}
;

function montaTr(paciente) {
    var pacienteTr = document.createElement("tr");
    pacienteTr.classList.add("paciente");

    pacienteTr.appendChild(montaTd(paciente.nome, "info-nome"));
    pacienteTr.appendChild(montaTd(paciente.peso, "info-peso"));
    pacienteTr.appendChild(montaTd(paciente.altura, "info-altura"));
    pacienteTr.appendChild(montaTd(paciente.gordura, "info-gordura"));
    pacienteTr.appendChild(montaTd(paciente.imc, "info-imc"));

    return pacienteTr;
}
;

function montaTd(dado, classe) {

    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);

    return td;
}
;

function validaPeso(peso) {
    if (peso >= 0 && peso < 1000) {
        return true;
    } else {
        return false;
    }
}
;

function validaAltura(altura) {
    if (altura <= 3) {
        return true;
    } else
    {
        return false;
    }
}

function validaPaciente(paciente) {
    var erros = [];

    if (!validaPeso(paciente.peso))
        erros.push("Peso é inválido");

    if (!validaAltura(paciente.peso))
        erros.push("Altura inválida");
    if (paciente.nome.length == 0)
        erros.push("Nome de paciente inválido");

    if (paciente.gordura.length == 0)
        erros.push("Gordura inválida");

    if (paciente.peso.length == 0)
        erros.push("Peso inválido");

    if (paciente.altura.length == 0)
        erros.push("Altura inválida");


    return erros;
}
;

function exibeMensagemErros(erros) {
    var ul = document.querySelector("#mensagem-erro");
    ul.innerHTML = "";

    erros.forEach(function (erro) {
        var li = document.createElement("li");

        li.textContent = erro;

        ul.appendChild(li);
    });
}



