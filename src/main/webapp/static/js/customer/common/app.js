/**
 * Created by Administrator on 15-1-28.
 */
'use strict';
var xueyouApp=angular.module('xueyouApp',['ui.router','angularFileUpload','cumtControllers']);
xueyouApp.config(function($stateProvider,$urlRouterProvider){
	$urlRouterProvider.otherwise("/cumtLrjExcelData001");
    $stateProvider.
        state('index', {
            url: "/index",
            template:"welcome!",
        }).
        state('cumtLrjExcelData001',{
            url:"/cumtLrjExcelData001",
            templateUrl:"static/templates/cumt/lrj-excel-data.html",
            controller:'cumtExcelDataCtrl'
        });
});

