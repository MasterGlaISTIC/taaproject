/**
 * 
 */

app.controller('authController', function($scope, $http, $location) {
	$scope.authentificate = function() {				
		$http.get("/rest/conducteur/search2/login").then(function(data) {
			$scope.auth = data;
			{
				$location.path("/auth");
			}
		})
	};


});