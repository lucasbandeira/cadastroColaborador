angular.module('auxpagamento').controller('ColaboradoresController', function($scope, $http) {
	$scope.colaboradores = [];
	$scope.filtro = '';
	$scope.mensagem = '';
	$scope.entrada = '';

	$http.get('rest/colaboradores')
	.success(function(colaboradores) {
		$scope.colaboradores = colaboradores;
	})
	.error(function(error) {
		console.log(error);
	});

	$scope.remover = function(colaborador) {
		$http.delete('rest/colaboradores/' + colaborador.id)
		.success(function(){
			var indexFoto = $scope.colaboradores.indexOf(colaborador);
			$scope.colaboradores.splice(indexFoto, 1);
			$scope.mensagem = "O colaborador foi removido com sucesso";
		})
		.error(function(error) {
			console.log(error);
			$scope.mensagem = "Não removida";
		});
	};

});
