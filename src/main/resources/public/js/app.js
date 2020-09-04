var app = (function () {

	
	var numeros = function (error, info){
		if (error != null){
			alert("Verificar datos");
			return;	
		}
		console.log(info);
		$("#Lista").text(info.Lista);
		$("#Promedio").text(info.Promedio);
		$("#Sumatoria").text(info.Sumatoria);
	}
	
	var enviar = function (){
		var strings = $("#captura").val();
		var listaNums= strings.split(",");
		apiclient.capturarDatos(listaNums, numeros);
	}
	

    return {
		capturarDatos : function(){
			enviar();
		}
    }
})();