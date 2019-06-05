//valida o formulario
function validarFormulario(){
	var campo = document.getElementById('formulario:nome');
	if(campo.value.length==0){
		alert('O campo nome deve ser preenchido.');
		campo.focus();
		return false;
	}
	return true;
}

