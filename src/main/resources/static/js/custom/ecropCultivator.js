$(document).ready(function() {

	$('#cultivatorModal').on('hidden.bs.modal', function() {
		var index = $("#cultivatorIndex").val();
		$("#searchParam" + index).val('0');
	})

});


var sel = document.getElementById("searchParam"), text = document.getElementById("text");

function onUserTypeChange(index, selectedValue) {
	console.log('onUserTypeChange', selectedValue);
	if (selectedValue === '1') {
		setModalValues(index, "O", "Owner");
		$('#ownerOrEnjoyerModal').modal('show');
	} else if (selectedValue === '2') {
		setModalValues(index, "K", "Cultivator");
		$('#cultivatorModal').modal('show');
	}
	else if (selectedValue === '3') {

		setModalValues(index, "L", 'Enjoyer');
		$('#ownerOrEnjoyerModal').modal('show');
	}
}
function setModalValues(index, cultivatorType, roleType) {
	var suffix = '';
	if (cultivatorType == 'O' || cultivatorType == 'L') {
		suffix = 'OE'
	} else {
		suffix = ''
	}

	if (cultivatorType == 'K') {
		$("#refBookingId").val($("#bookingId" + index).val());
	}

	$("#crSnoLabel" + suffix).text($("#crSno" + index).val());
	$("#khNoLabel" + suffix).text($("#khNo" + index).val());
	$("#ocNameLabel" + suffix).text($("#ocName" + index).val());
	$("#fatherNameLabel" + suffix).text($("#fatherName" + index).val());
	$("#aadharNoLabel" + suffix).text($("#aadharNo" + index).val());

	$("#cultivatorIndex" + suffix).val(index);
	$("#cultivatorModalHeaderId" + suffix).text(roleType);
	$("#cultivatorModalFieldId1" + suffix).text(roleType);

	$("#crSno" + suffix).val($("#crSno" + index).val());
	$("#khNo" + suffix).val($("#khNo" + index).val());
	$("#part_key" + suffix).val($("#part_key" + index).val());
	$("#cr_vcode" + suffix).val($("#cr_vcode" + index).val());
	$("#cr_year" + suffix).val($("#cr_year" + index).val());
	$("#cr_season" + suffix).val($("#cr_season" + index).val());
	$("#cultivatorType" + suffix).val(cultivatorType);

	if (cultivatorType == 'O' || cultivatorType == 'L') {
		$("#ocName" + suffix).val($("#ocName" + index).val());
		$("#fatherName" + suffix).val($("#fatherName" + index).val());
		$("#aadharNo" + suffix).val($("#aadharNo" + index).val());

		$("#bookingId" + suffix).val($("#bookingId" + index).val());
	}

}

function getAvailableExtentDetails() {
	$.ajax({
		type: "PUT",
		url: "cultivator/extent",
		data: {
			"khNo": $("#khNo" + index).val(),
			"aadharNo": $("#aadharNo" + index).val(),
			"owner_tenant": $("#owner_tenant" + index).val(),
		},
		success: function(resData) {
			$("#cultivatorIndex").val(index);
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Update Details");
		}
	});
}

function updateCultivatorOwnerDetails(index) {

	Swal.fire({
		title: "Do you want to update the changes?",
		showDenyButton: true,
		showCancelButton: false,
		confirmButtonText: "Update",
		denyButtonText: `Don't Update`
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "PUT",
				url: "cultivator/update",
				data: {
					"part_key": $("#part_key" + index).val(),
					"bookingId": $("#bookingId" + index).val(),
					"aadharNo": $("#aadharNo" + index).val(),
					"occupantExtent": $("#occupantExtent" + index).val(),
				},
				success: function(resData) {
					document.getElementById("aadharNo" + index).disabled = true;
					document.getElementById("occupantExtent" + index).disabled = true;
					$("#update" + index).css({ 'display': 'none' });
					$("#searchParam" + index).val('0');
					resData ?
						alertify.notify("Cultivator Owner Data Updated Successfully!", "success", 10)
						: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);

				},
				error: function(xhr, err) {
					console.log(err);
					console.log("Failed to Update Details");
				}
			});
		} else if (result.isDenied) {
			Swal.fire("Failed to Update Cultivator Owner Data", "", "info");
		}
	});

}

function editCultivatorDetails(index) {

	document.getElementById("aadharNo" + index).disabled = false;
	document.getElementById("occupantExtent" + index).disabled = false;
	$("#update" + index).css({ 'display': '' });
}

function updateCultivatorDetails(sufix) {

	$.ajax({
		type: "PUT",
		url: "cultivator/update",
		data: {
			"part_key": $("#part_key" + sufix).val(),
			"bookingId": $("#bookingId" + sufix).val(),
			"occupantExtent": $("#occupantExtent" + sufix).val(),
			"cultivatorType": $("#cultivatorType" + sufix).val(),
		},
		success: function(resData) {
			searchData();
			resData ?
				alertify.notify("Data Updated Successfully!", "success", 10)
				: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Update Details");
		}
	});

}

function deleteCultivatorDetails(index) {
	Swal.fire({
		title: "Do you want to update the changes?",
		showDenyButton: true,
		showCancelButton: false,
		confirmButtonText: "Delete",
		denyButtonText: `Don't Delete`
	}).then((result) => {
		if (result.isConfirmed) {

			$.ajax({
				type: "DELETE",
				url: "cultivator/delete",
				data: {
					"part_key": $("#part_key" + index).val(),
					"bookingId": $("#bookingId" + index).val(),
				},
				success: function(data) {
					searchData();
					data ?
						alertify.notify("Data Deleted Successfully!", "success", 10)
						: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
				},
				error: function(xhr, err) {
					console.log(err);
					console.log("Failed to Delete Details");
				}
			});
		} else if (result.isDenied) {
			Swal.fire("Failed to Delete", "", "info");
		}
	});

}

function saveCultivatorData() {
	alert($("#cultivatorType").val());

	$.ajax({
		type: "POST",
		url: "cultivator/save",
		data: {
			"khNo": $("#khNo").val(),
			"crSno": $("#crSno").val(),
			"ocName": $("#ocName").val(),
			"cr_year": $("#cr_year").val(),
			"aadharNo": $("#aadharNo").val(),
			"part_key": $("#part_key").val(),
			"cr_vcode": $("#cr_vcode").val(),
			"cr_season": $("#cr_season").val(),
			"fatherName": $("#fatherName").val(),
			"occupantExtent": $("#occupantExtent").val(),
			"refBookingId": $("#refBookingId").val(),
			"cultivatorType": $("#cultivatorType").val(),
		},
		success: function(data) {
			searchData();

			$("#aadharNo").val('');
			$("#ocName").val('');
			$("#fatherName").val('');
			$("#occupantExtent").val('');
			data ?
				alertify.notify("Cultivator Data Saved Successfully", "success", 10)
				: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Save Details");
		}
	});
}

function searchData() {
	$("#contentDivId").html('');
	$.ajax({
		type: "GET",
		url: 'cultivator/kathaNo/?fromKhno=' + $("#fromKhnoId").val(),
		success: function(data) {
			$("#contentDivId").html(data)
		}
	});
}
