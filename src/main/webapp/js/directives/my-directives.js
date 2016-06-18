angular.module('myDirectives', [])
.directive('myPanel',
function() {
		var ddo = {};
		ddo.restric = "AE"; 
		ddo.scope = { 
			titulo: '@'
		};
		ddo.transclude = true; 
		ddo.templateUrl = 'js/directives/my-panel.html';
		return ddo;
})
.directive('myButtonDanger',
function(){
	var ddo = {};
	ddo.restric = "E"; 
	ddo.scope = { 
		nome: '@', 
		acao: '&'
	};
	ddo.template = '<button ng-click="acao(foto)" class="btn btn-danger btn-block">{{nome}}</button>';
	return ddo;
});
