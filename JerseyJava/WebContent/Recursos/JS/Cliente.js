var appCliente = angular.module('clientes', [ 'ngRoute' ]);

appCliente.service('clientes', function($http) {

	this.listaClientes = function() {
		return $http({
			url : 'http://localhost:8080/JerseyJava/marcela/Cliente',
			method : 'GET'
		});

	}

	this.guardar = function(cliente) {
		return $http({
			url : 'http://localhost:8080/JerseyJava/marcela/Cliente',
			method : 'POST',
			params : {
				identificacion : cliente.cedula,
				nombres : cliente.nombre,
				apellidos : cliente.apellidos,
				correo : cliente.email,
				usuarioCrea : 'elver'
			}
		});

	}
});

appCliente.service('usuarios', function($http) {
	
	this.autenticar = function(usuario,passwd) {
		return $http({
			url : 'http://localhost:8080/JerseyJava/marcela/Usuario',
			method : 'GET',
			params : {
				login : usuario,
				pws : passwd,
			}
		});

	}
}

appCliente.controller('listaClientes', function($scope, clientes, $location) {

	clientes.listaClientes().then(

	function success(data) {
		$scope.listaClientes = data.data.clienteJersey;
	});

	$scope.agregar = function() {
		$location.url('/nuevo');
	}
});

appCliente.controller('cliente', function($scope, $location, clientes) {

	$scope.cliente = {
		nombre : "",
		apellidos : "",
		cedula : "",
		email : ""
	};

	$scope.guardar = function() {

		clientes.guardar($scope.cliente).then(

		function success(data) {
			alert('Cliente creado');
			$location.url('/listaClientes');
		});
	}
});

appCliente.controller('Login', function($scope, $location, usuarios) {
	
	$scope.nombreUsuario = "";
	$scope.passwd = "";
	
	$scope.login = function() {
		usuarios.autenticar($scope.nombreUsuario, $scope.passwd).then(
				
			function success(data) {
				$location.url('/listaClientes');
			},
			function failure(data) {
				alert(data.data);
			});
	}
});

appCliente.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'login.html',
		controller : 'Login'
	});
	
	$routeProvider.when('/listaClientes', {
		templateUrl : 'ListaCliente.html',
		controller : 'listaClientes'
	});

	$routeProvider.when('/nuevo', {
		templateUrl : 'Cliente.html',
		controller : 'cliente'
	});

} ]);