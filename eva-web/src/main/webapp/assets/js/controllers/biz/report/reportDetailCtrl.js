'use strict';
/**
 * controller for User Profile Example
 */
app.controller('ReportDetailCtrl', ["$scope","$stateParams", function ($scope,$stateParams) {

    alert($stateParams.reportId);
}]);