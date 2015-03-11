//create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', ['ngRoute','ngResource']);

//configure our routes
scotchApp.config(function($routeProvider) {
	$routeProvider
	// route for the home page
	

	// route for the about page
	.when('/about', {
		templateUrl : 'pages/about.html',
		controller  : 'aboutController'
	})

	// route for the contact page
	.when('/contact', {
		templateUrl : 'pages/contact.html',
		controller  : 'contactController'
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
				  $location.path('/about')
			  } else {
				  $scope.msgErreur="Email ou mot de passe est incorrecte"
			  }
		  }).
		  error(function(data, status, headers, config) {
			  alert("erreur "+status)
		  });
     }
	
	
	
//	this.reset
	
	

//	 $http.post('http://localhost:8080/covoit-service/rest/users/auth', {email:'mohssine.amhachi@gmail.com', passwd:'123'})
//	 .success(function(data, status, headers, config) {
//		  alert("autehnticate")
//	  }).
//	  error(function(data, status, headers, config) {
//		  alert("erreur ")
//	  });
	// exmple 
	
	// Simple POST request example (passing data) :
//	$http.post('http://localhost:8080/covoit-service/rest/users/addUser', {email:'hellaaa'}).
//	  success(function(data, status, headers, config) {
//		  alert("success")
//	  }).
//	  error(function(data, status, headers, config) {
//		  alert("erreur ")
//	  });
	
//	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data ) {
//		$scope.auth = data.data;
//		alert(data.data);
//	})
});

scotchApp.controller('aboutController', function($scope, $http, $location) {
	alert("s")
	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
		$scope.auth = data.data;
	})
});

scotchApp.controller('contactController', function($scope, $http, $location) {
//	 $scope.authen = function () {
//		 $http.post('http://localhost:8080/covoit-service/rest/users/auth', {email:$scope.user.email, passwd:$scope.user.passwd})
//		 .success(function(data, status, headers, config) {
//			 if(data == "true"){
//				  $location.path('/about')
//			  } else {
//				  $scope.msgErreur="Email ou mot de passe est incorrecte"
//			  }
//		  }).
//		  error(function(data, status, headers, config) {
//			  alert("erreur "+status)
//		  });
//     }
	// add for test
	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
		$scope.auth = data.data;
	})
	});

scotchApp.controller('addEventsController', function($scope) {
	// add for test
	$http.get("http://localhost:8080/covoit-service/rest/users/users").then(function(data) {
		$scope.auth = data.data;
	})
	});







