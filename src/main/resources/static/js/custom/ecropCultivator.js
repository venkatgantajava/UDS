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
		document.getElementById("occupantExtent" + index).disabled = false;
		$("#occupantExtent" + index).removeAttr('disabled').focus();
		$("#update" + index).css({ 'display': '' });
	} else if (selectedValue === '2') {
		document.getElementById("occupantExtent" + index).disabled = true;
		setModalValues(index);
		$("#update" + index).css({ 'display': 'none' });
		$('.modal').modal('show');
	}
	else if (selectedValue === '3') {
		document.getElementById("aadharNo" + index).disabled = false;
		document.getElementById("occupantExtent" + index).disabled = false;
		$("#aadharNo" + index).removeAttr('disabled').focus();
		$("#occupantExtent" + index).removeAttr('disabled').focus();
		$("#update" + index).css({ 'display': '' });
	}
}
function setModalValues(index) {
	$("#crSno").val($("#crSno" + index).val());
	$("#khNo").val($("#khNo" + index).val());
	$("#part_key").val($("#part_key" + index).val());
	$("#cr_vcode").val($("#cr_vcode" + index).val());
	$("#cr_year").val($("#cr_year" + index).val());
	$("#cr_season").val($("#cr_season" + index).val());
	$("#owner_tenant").val('T');
	$("#cultivatorIndex").val(index);
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
				url: "cultivator/owner/update",
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

function editCultivatorTenantDetails(index) {

	document.getElementById("aadharNo" + index).disabled = false;
	document.getElementById("occupantExtent" + index).disabled = false;
	$("#update" + index).css({ 'display': '' });
}

function updateCultivatorTenantDetails(index) {

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
				url: "cultivator/tenant/update",
				data: {
					"part_key": $("#part_key" + index).val(),
					"bookingId": $("#bookingId" + index).val(),
					"aadharNo": $("#aadharNo" + index).val(),
					"occupantExtent": $("#occupantExtent" + index).val(),
				},
				success: function(resData) {
					document.getElementById("aadharNo" + index).disabled = true;
					document.getElementById("occupantExtent" + index).disabled = true;
					$("#update" + index).hide();
					$("#searchParam" + index).val('0');
					resData ?
						alertify.notify("Data Updated Successfully!", "success", 10)
						: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
				},
				error: function(xhr, err) {
					console.log(err);
					console.log("Failed to Update Details");
				}
			});
		} else if (result.isDenied) {
			Swal.fire("Changes are not saved", "", "info");
		}
	});


}

function deleteCultivatorTenantDetails(index) {
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
				url: "cultivator/tenant/delete",
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

function saveCultivatorTenantData(index) {
	$.ajax({
		type: "POST",
		url: "cultivator/tenant/save",
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
			"owner_tenant": $("#owner_tenant").val(),
			"occupantExtent": $("#occupantExtent").val(),
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
