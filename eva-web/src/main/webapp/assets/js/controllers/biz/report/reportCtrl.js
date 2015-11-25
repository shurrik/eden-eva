'use strict';
/**
 * controller for User Profile Example
 */
app.controller('ReportCtrl', ["$scope","$http","$aside","$state", function ($scope,$http,$aside,$state) {

    var myData = {};
    $scope.reports = [];
    $http.post('/rest/report/getall',myData).success(function(response){
        //console.log(response);
        $scope.reports = response;
    });

    $scope.openAside = function (position) {
        $aside.open({
            templateUrl: 'asideContent.html',
            placement: position,
            size: 'sm',
            backdrop: true,
            controller: function ($scope, $modalInstance) {
                $scope.ok = function (e) {
                    $modalInstance.close();
                    e.stopPropagation();
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };

    $scope.addReport = function(){
        $state.transitionTo("app.report.create", null, {'reload':true});
    };
}]);

app.controller('ReportDetailCtrl', ["$scope","$stateParams","$http", function ($scope,$stateParams,$http) {
    //alert($stateParams.reportId);
    $scope.repId = $stateParams.reportId;
    $scope.year;
    $scope.month;

    $scope.reportData;

    $scope.queryReport = function(){
        //alert($scope.year);
        //alert($scope.month);


        var myData = { repId:$scope.repId,year : $scope.year, month : $scope.month};
        var res = [];
        //$http.post('/rest/reportdata/getbyperoid',myData).success(function(response){
        $http.post('/rest/reportdata/preview',myData).success(function(response){
            var labels = [];
            var datas = [];
            for(var i in response)
            {
                labels.push(response[i].repKey);
                datas.push(response[i].repVal);
            }
            $scope.data = {
                labels: labels,
                datasets: [
                    {
                        label: 'My First dataset',
                        fillColor: 'rgba(151,187,205,0.5)',
                        strokeColor: 'rgba(151,187,205,0.8)',
                        highlightFill: 'rgba(151,187,205,0.75)',
                        highlightStroke: 'rgba(151,187,205,1)',
                        data: datas
                    }
                ]
            };


            // Chart.js Options
            $scope.options = {

                // Sets the chart to be responsive
                responsive: true,

                //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
                scaleBeginAtZero: true,

                //Boolean - Whether grid lines are shown across the chart
                scaleShowGridLines: true,

                //String - Colour of the grid lines
                scaleGridLineColor: "rgba(0,0,0,.05)",

                //Number - Width of the grid lines
                scaleGridLineWidth: 1,

                //Boolean - If there is a stroke on each bar
                barShowStroke: true,

                //Number - Pixel width of the bar stroke
                barStrokeWidth: 2,

                //Number - Spacing between each of the X value sets
                barValueSpacing: 5,

                //Number - Spacing between data sets within X values
                barDatasetSpacing: 1,

                //String - A legend template
                legendTemplate: '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>'
            };
        });

    };


}]);

