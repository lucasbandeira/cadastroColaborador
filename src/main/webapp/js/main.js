angular.module('auxpagamento', ['myDirectives', 'ngAnimate', 'ngRoute'])
.config(function($routeProvider, $locationProvider) {
	$locationProvider.html5Mode(true);

	$routeProvider.when('/', {
		templateUrl: 'partials/principal.html',
		controller: 'ColaboradoresController' });
	$routeProvider.when('/new', {
		templateUrl: 'partials/colaborador.html',
		controller: 'ColaboradorController'
	});
	$routeProvider.when('/edit/:id', {
		templateUrl: 'partials/colaborador.html',
		controller: 'ColaboradorController'
	});
	$routeProvider.otherwise({
		redirectTo: '/'
	});
});