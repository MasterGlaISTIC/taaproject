	// create the module and name it scotchApp
	var app = angular.module('scotchApp', ['ngRoute', 'ngResource']);

	// configure our routes
	app.config(function($routeProvider) {
		$routeProvider
			
			
			/* CONNECTION */
			// route for the connection page
			.when('/auth', {
				templateUrl : 'pages/auth.html',
				controller  : 'authController'
			})
			
	});

	/*
	 * AUTH CONTROLLER
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
	

















//
//
///*
// * controller application angularJS  
// */
//
///*function personController($scope, $http, $location) {
//	$scope.authentificate = function() {				
//		$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
//			alert(data);
////			$scope.auth = data;
//			
////			{
////				$location.path("/auth");
////			}
//		})
//	};
//
//
//};
//*/
//function personController($scope) {
//    $scope.firstName = "John",
//    $scope.lastName = "Doe",
//    $scope.fullName = function() {
//        return $scope.firstName + " " + $scope.lastName;
//    }
//}
//
