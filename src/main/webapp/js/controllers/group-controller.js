angular.module('auxpagamento').controller('GruposController', function($scope, $http) {
  $scope.grupos = [];
  $scope.menssage = '';

  $http.get('v1/grupos')
  .success(function(grupos) {
    $scope.grupos = grupos;
  })
  .error(function(error) {
    console.log(error);
    $scope.menssage = 'Grupo não encontrado';
  })
});
