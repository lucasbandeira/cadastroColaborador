angular.module('auxpagamento').controller('ColaboradorController', function($scope, $http, $routeParams) {
	$scope.colaborador = {};
	$scope.menssage = '';

	if($routeParams.id) {
		$http.get('rest/colaboradores/' + $routeParams.id)
		.success(function(colaborador) {
			$scope.colaborador = colaborador;
		})
		.error(function(error){
			console.log(erro);
			$scope.menssage = 'colaborador não encontrado';
		});
	}

	$scope.submeter = function() {
		if ($scope.formulario.$valid) {
			if($scope.colaborador.id) {
				$http.post('rest/colaboradores/' + $scope.colaborador.id, $scope.colaborador)
				.success(function(){
					$scope.menssage = 'colaborador alterado';
				})
				.error(function(error){
					console.log(erro);
					$scope.menssage = 'colaborador não alterado';
				});
			} else {
					$http.post('rest/colaboradores', $scope.colaborador)
					.success(function() {
						$scope.colaborador = {};
						$scope.menssage = 'colaborador cadastrado';
					})
					.error(function(erro) {
						console.log(erro);
						$scope.menssage = 'colaborador não cadastrado';
					});
				}
			}
	};

});
