/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
    Created on : 25/09/2019, 22:14:35
    Author     : tulio
*/
function saudacoes()
{
    var mensagens = [];
    var mensagem;
    mensagens[0] = "Boa Noite";
    mensagens[mensagens.length] = "Bom Dia";
     mensagens[mensagens.length] = "Boa Tarde";
    data = new Date();
    hora = data.getHours();

    if (hora > 5 && hora < 12)
        mensagem = mensagens[1];
    else
    if (hora >= 12 && hora < 18)
        mensagem = mensagens[2];
        else
            mensagem = mensagens[0];

    node = document.getElementById("div-mens");
    node.innerHTML = mensagem;
}


