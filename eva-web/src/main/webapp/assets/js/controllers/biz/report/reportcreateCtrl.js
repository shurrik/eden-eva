'use strict';
/**
 * reportCreate
 */
app.controller('ReportCreateCtrl', ['$scope','$http','toaster','$filter','SweetAlert','$state','$parse',
    function ($scope,$http,toaster,$filter,SweetAlert,$state,$parse) {
        $scope.currentStep = 1;

        // Initial Value
        $scope.form = {

            next: function (form) {

                $scope.toTheTop();

                if (form.$valid) {
                    nextStep();
                } else {
                    var field = null, firstError = null;
                    for (field in form) {
                        if (field[0] != '$') {
                            if (firstError === null && !form[field].$valid) {
                                firstError = form[field].$name;
                            }

                            if (form[field].$pristine) {
                                form[field].$dirty = true;
                            }
                        }
                    }

                    angular.element('.ng-invalid[name=' + firstError + ']').focus();
                    errorMessage();
                }
            },
            prev: function (form) {
                $scope.toTheTop();
                prevStep();
            },
            goTo: function (form, i) {
                if (parseInt($scope.currentStep) > parseInt(i)) {
                    $scope.toTheTop();
                    goToStep(i);

                } else {
                    if (form.$valid) {
                        $scope.toTheTop();
                        goToStep(i);

                    } else
                        errorMessage();
                }
            },
            submit: function () {

            },
            reset: function () {

            }
        };


        var nextStep = function () {
            $scope.currentStep++;
        };
        var prevStep = function () {
            $scope.currentStep--;
        };
        var goToStep = function (i) {
            $scope.currentStep = i;
        };
        var errorMessage = function (i) {
            toaster.pop('error', 'Error', 'please complete the form in this step before proceeding');
        };

        $scope.items = [];

        $scope.queryJoin = {};
        $scope.addItem = function () {
            if($scope.queryJoin.tbNameL===undefined||$scope.queryJoin.colL===undefined||$scope.queryJoin.tbNameR===undefined||$scope.queryJoin.colR===undefined)
            {
               return
            }

            var newItemNo = $scope.items.length + 1;
            $scope.queryJoin.no = newItemNo;
            var item = $scope.queryJoin;
            $scope.items.push(item);
            $scope.myModel.joins =  $scope.items;
            $scope.queryJoin = {};
        };

        $scope.getDatabase = function () {
            $http.post('/rest/database/findall','{}').success(function(res){
                $scope.databases = res;
            });
        };

        $scope.init = function(){
            $scope.getDatabase();
        }
        $scope.init();

        $scope.dbChange = function () {
            var map = {};
            map.dbId = $scope.myModel.database;
            $http.post('/rest/database/gettables',map).success(function(res){
                $scope.tableNames = res;
                $scope.myModel.table = {};
            });
        };


        $scope.tbChange = function (no,tbName) {
            var map = {};
            map.dbId = $scope.myModel.database;
            map.tbName = tbName;

            $http.post('/rest/database/getcols',map).success(function(res){
                var the_string = 'cols'+no;
                var model = $parse(the_string);
                model.assign($scope, res);
                $scope.$apply();
            });
        };


        $scope.submit = function () {
            $http.post('/rest/report/create',$scope.myModel).success(function(res){
                console.log(res);
            });
            $scope.submitSucc();
        };

        $scope.submitSucc = function () {
            SweetAlert.swal({
                title: "提交成功!",
                type: "success",
                confirmButtonColor: "#007AFF",
                confirmButtonText: "返回",
            }, function () {
                //$state.transitionTo($state.current, null, {'reload':true});
                $state.transitionTo('app.report.list', null, {'reload':true});
            });
        };

    }]);
