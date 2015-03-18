(function(angular) {
  'use strict';
angular.module('testa', [])
  .controller('FetchController', ['$scope', '$http', '$templateCache',
    function($scope, $http, $templateCache) {
      var Method = 'GET';
      var Url = '/api/place';

      $scope.fetch = function() {
        $scope.code = null;
        $scope.response = null;

        $http({method: Method, url: Url, cache: $templateCache}).
          success(function(data, status) {
            $scope.status = status;
            $scope.data = data;
          }).
          error(function(data, status) {
            $scope.data = data || "Request failed";
            $scope.status = status;
        });
      };
    }]);
})(window.angular);