	// create the module and name it scotchApp , ['ngRoute', 'ngResource']
	var app = angular.module('myApp');

	// configure our routes
	app.config(function($routeProvider) {
		$routeProvider			
			/* CONNECTION */
			// route for the connection page
			.when('/', {
				templateUrl : 'pages/authentification.html',
				controller  : 'authController'
			})
			
	});

	/*
	 * AUTH CONTROLLER
	 */
	app.controller('authController', function($scope) {//, $http, $location
		alert("ddddd");
		
	});
	
