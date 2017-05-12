/**
 * 
 */
var cuestionario = angular.module('modCuestionario', []);

cuestionario.controller('contCuestionario', function($scope) {
	$scope.preguntas = [ {
		id : 1,
		texto : 'Pregunta 1',
		respuestaValida : 1,
		respuesta : null,
		estado : '',
		respuestas : [ {
			id : 1,
			texto : 'Respuesta 1.1'
		}, {
			id : 2,
			texto : 'Respuesta 1.2'
		}, {
			id : 3,
			texto : 'Respuesta 1.3'
		} ]
	}, {
		id : 2,
		texto : 'Pregunta 2',
		respuestaValida : 2,
		respuesta : null,
		estado : '',
		respuestas : [ {
			id : 1,
			texto : 'Respuesta 2.1'
		}, {
			id : 2,
			texto : 'Respuesta 2.2'
		}, {
			id : 3,
			texto : 'Respuesta 2.3'
		} ]
	}, {
		id : 3,
		texto : 'Pregunta 3',
		respuestaValida : 3,
		respuesta : null,
		estado : '',
		respuestas : [ {
			id : 1,
			texto : 'Respuesta 3.1'
		}, {
			id : 2,
			texto : 'Respuesta 3.2'
		}, {
			id : 3,
			texto : 'Respuesta 3.3'
		} ]
	} ];

	$scope.respuestasCorrectas = 0;
	$scope.estadoUsuario = "";

	$scope.validar = function() {
		$scope.respuestasCorrectas = 0;

		angular.forEach($scope.preguntas, function(value, key) {

			if (value.respuestaValida == value.respuesta) {
				$scope.respuestasCorrectas++;
				value.estado = "ok";

			} else {
				if (value.estado == 'ok' && $scope.respuestasCorrectas > 0)
					$scope.respuestasCorrectas--;
				
					value.estado = 'error';
				
			}
			estadoUsuario();

		});
	};
	$scope.clear = function(){
		$scope.respuestasCorrectas = 0;
		
		angular.forEach($scope.preguntas, function(value, key){
			value.respuesta = null;
			value.estado = '';
		});
	};

	function estadoUsuario() {
		var total = $scope.respuestasCorrectas / $scope.preguntas.length;

		if (total == 0) {
			$scope.estadoUsuario = "looser";
		} else if (total == 1) {
			$scope.estadoUsuario = "guru";
		} else {
			$scope.estadoUsuario = "poor";
		}
	}
});