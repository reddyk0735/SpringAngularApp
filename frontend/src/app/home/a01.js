var app = angular.module("app", []);
app.controller('contact', function($scope, contactService){
	
	var uid = 1;
	$scope.limit = 2;
		contactService.findContactById($scope.searchEmpno, function(r){
			$scope.contactData = r;
		});		


	$scope.saveContact = function(contact){
		if (contact.id == null) {
            contact.id = uid++;
            $scope.contactData.push(contact);
        } else {
            for (i in $scope.empData) {
                if ($scope.contactData[i].id == contact.id) {
                    $scope.contactData[i] = contact;
                }
            }
        }
        $scope.newcontact = {};
	}

	$scope.delete = function (id) {
		for (i in $scope.contactData) {
            if ($scope.contactData[i].id == id) {
                $scope.contactData.splice(i, 1);
            }
        }
    }

    $scope.edit = function (id) {
    	for (i in $scope.contactData) {
            if ($scope.contactData[i].id == id) {
                var e = $scope.contactData[i];
            }
        }
        $scope.newcontact = angular.copy(e);
    }

    $scope.view = function (data) {
		$scope.viewData = data;
	}

	$scope.loadMore = function(){
		$scope.limit = $scope.limit + 1;
	}

});

app.controller('ModalCtrl', function ($scope, items) {
	$scope.data = items;
});

app.service('contactService', function($http, $log, $filter){
	this.findContactById = function(empno, cb){
		$http({
			url: 'data.json',
			method: 'GET'
		}).then(function(resp){
			$log.log(resp.data.Contacts);
			cb(resp.data.Contacts);
		},function(resp){
			$log.error("ERROR occurred");
		});
	};
});
