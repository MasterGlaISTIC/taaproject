//create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', ['ngRoute','ngResource']);

//configure our routes
scotchApp.config(function($routeProvider) {
	$routeProvider
	// route for the home page


	// route for the about page
	.when('/addevent', {
		templateUrl : 'pages/addEvent.html',
		controller  : 'addEventController'
	})

	// route for the contact page
	.when('/events', {
		templateUrl : 'pages/events.html',
		controller  : 'contactController'
	})

	.when('/inscription', {
		templateUrl : 'pages/inscription.html',
		controller  : 'inscriptionController'
	})

	.when('/addEvent', {
		templateUrl : 'pages/addEvent.html',
		controller  : 'addEventController'
	})
	
	
	.when('/', {
		templateUrl : 'pages/home.html',
		controller  : 'mainController'
	})

});

//create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope , $http, $location) {	
	$scope.authen = function () {
		$http.post('http://localhost:8080/covoit-service/rest/users/auth', {email:$scope.user.email, passwd:$scope.user.passwd})
		.success(function(data, status, headers, config) {
			if(data == "true"){
				$location.path('/events')
			} else {
				$scope.msgErreur="Email ou mot de passe est incorrecte"
			}
		}).
		error(function(data, status, headers, config) {
			alert("erreur "+status)
		});
	}

});

scotchApp.controller('aboutController', function($scope, $http, $location) {
	alert("s")
	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
		$scope.auth = data.data;
	})
});

scotchApp.controller('contactController', function($scope, $http, $location) {
	$http.get("http://localhost:8080/covoit-service/rest/journey/journeys").then(function(data) {
		$scope.event = data.data;
	})
});

scotchApp.controller('addEventsController', function($scope) {
	// add for test
	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
		$scope.auth = data.data;
	})
});

scotchApp.controller('inscriptionController', function($scope, $http, $location) {
	$scope.inscription = function () {
		$http.post('http://localhost:8080/covoit-service/rest/users/addUser', {email:$scope.user.email, passwd:$scope.user.passwd, name:$scope.user.name, location:$scope.user.location})
		.success(function(data, status, headers, config) {

			alert("success")
			$location.path('/')

		}).
		error(function(data, status, headers, config) {
			alert("erreur "+status)
		});

	}
});


	scotchApp.controller('addEventController', function($scope, $http, $location) {
		$scope.addEvent = function () {
			$http.post('http://localhost:8080/covoit-service/rest/journey/addJourney', {name:$scope.user.name, adresse:$scope.user.adresse, date:$scope.user.date})
			.success(function(data, status, headers, config) {

				$location.path('/events')

			}).
			error(function(data, status, headers, config) {
				alert("erreur "+status)
			});

		}
	});



