$(document).ready(function() {

	$('.modal').on('hidden.bs.modal', function() {
		var index = $("#cultivatorIndex").val();
		var indexOE = $("#cultivatorIndexOE").val();
		$("#searchParam" + index).val('0');
		$("#aadharNo").val('');
		$("#ocName").val('');
		$("#fatherName").val('');
		$("#occupantExtent").val('');

		$("#searchParam" + indexOE).val('0');
		$("#occupantExtentOE").val('');
	})
	alertify.set('notifier', 'position', 'top-right');

	Number.prototype.round = function(p) {
		p = p || 10;
		return parseFloat(this.toFixed(p));
	};

	// Change the selector if needed
	var $table = $('table.scroll'),
		$bodyCells = $table.find('tbody tr:first').children(),
		colWidth;

	// Adjust the width of thead cells when window resizes
	$(window).resize(function() {
		// Get the tbody columns width array
		colWidth = $bodyCells.map(function() {
			return $(this).width();
		}).get();

		// Set the width of thead columns
		$table.find('thead tr').children().each(function(i, v) {
			$(v).width(colWidth[i]);
		});
	}).resize(); // Trigger resize handler

});




var sel = document.getElementById("searchParam"), text = document.getElementById("text");

function onUserTypeChange(index, selectedValue) {
	
	var cultivatorType = $("#cultivatorType" + index).val();
	var cultivatorTypeCcrc= $("#cultivatorType_Ccrc" + index).val();
	if (selectedValue === '1') {
		document.getElementById("ccrcbtnId").style.display = "none";
        document.getElementById("ownerbtnId").style.display = "";
		if (cultivatorType == 'L') {
			$("#searchParam" + index).val('0');
			swal.fire("Already Registered as Enjoyer!", "", "warning");
			return false;
		} else if (cultivatorType == 'O') {
			$("#searchParam" + index).val('0');
			swal.fire("Already Registered as Owner!", "", "warning");
			return false;
		}
		else{
			
			
			var availableExtent = parseFloat($("#availableExtent" + index).val()).round(3);
			if (availableExtent > 0) {
				var originalExt = document.getElementById("anubhavadarExtent" + index).value;
				setModalValues(index, "O", "Owner",originalExt);
				$('#ownerOrEnjoyerModal').modal('show');
			} else {
				$("#searchParam" + index).val('0');
				swal.fire("No Available Extent", "", "warning");
			}
		}
				
	
	} else if (selectedValue === '2') {
		var availableExtent = parseFloat($("#availableExtent" + index).val()).round(3);
		if (availableExtent > 0) {
			setModalValues(index, "K", "Cultivator");
			$('#cultivatorModal').modal('show');
		} else {
			$("#searchParam" + index).val('0');
			swal.fire("No Available Extent", "", "warning");
		}
	} else if (selectedValue === '3') {
		document.getElementById("ccrcbtnId").style.display = "none";
        document.getElementById("ownerbtnId").style.display = "";
		if (cultivatorType == 'L') {
			$("#searchParam" + index).val('0');
			swal.fire("Already Registered as Enjoyer!", "", "warning");
			return false;
		} else if (cultivatorType == 'O') {
			$("#searchParam" + index).val('0');
			swal.fire("Already Registered as Owner!", "", "warning");
			return false;
		}
		
	else{
			
			
			var availableExtent = parseFloat($("#availableExtent" + index).val()).round(3);
			if (availableExtent > 0) {
				var originalExt = document.getElementById("anubhavadarExtent" + index).value;
				setModalValues(index, "L", 'Enjoyer',originalExt);
				$('#ownerOrEnjoyerModal').modal('show');
			} else {
				$("#searchParam" + index).val('0');
				swal.fire("No Available Extent", "", "warning");
			}
		}
		
		
	
	}
	if (selectedValue === '4') {
//		var availableExtent =$("#availableExtent_Ccrc" + index).val();
//		alert(availableExtent)
		document.getElementById("ccrcbtnId").style.display = "block";
        document.getElementById("ownerbtnId").style.display = "none";
		
		if (cultivatorTypeCcrc == 'C') {
			$("#searchId" + index).val('0');
			swal.fire("Already CCRC added!", "", "warning");
			return false;
		} 
		var kh_no = document.getElementById("khNo_Ccrc" + index).value;
		var survey_no = document.getElementById("crSno_Ccrc" + index).value;
		var inputs = document.querySelectorAll('input[name="cr_vcode_c"]');
		count = inputs.length;
		var originalExt=0;
		var avail=0;
//		alert(count)
		for (var i = 0; i < count; i++) {
			if (kh_no == document.getElementById("khNo" + i).value && survey_no == document.getElementById("crSno" + i).value) {
				originalExt	 = document.getElementById("anubhavadarExtent_Ccrc" + i).value;
				avail= (document.getElementById("availableCcrc" + i).value);
			}
//			alert(avail+'---'+originalExt)
		}
//		alert(avail+'---'+originalExt)
		if (avail <= 0) {
			$("#searchId" + index).val('0');
			swal.fire("No Available Extent for CCRC", "", "warning");
		}
		else if(avail > 0){
//			alert('else')
			$("#searchId" + index).val('0');
		setModal(index, "C", "CCRC", originalExt, avail);
		$('#ownerOrEnjoyerModal').modal('show');
	}
	}
	
}

function setModal(index, cultivatorType, roleType, originalExt, avail) {
	if (cultivatorType == 'C') {
		suffix = 'OE'
		$("#owner_tenant").val(cultivatorType);
//		document.getElementById("aadharNo" + suffix).disabled = true;
//		document.getElementById("occupantExtent" + suffix).disabled = true;
		$("#refBookingId").val($("#bookingId" + index).val());
	}
	 var aadharDisplay = document.querySelector(".aadharDisplay");
		    var aadharInput = document.querySelector(".aadharInput");
		    var occupantExtent = document.querySelector(".occupantExtentDisplay");
		    var occupantExtentInput = document.querySelector(".occupantExtentInput");
	 var inputValue = $("#aadharNoC" + index).val();
 aadharDisplay.style.display = "inline";
		    	 aadharDisplay.textContent = inputValue;
		    	 aadharInput.style.display = "none";
		    	  var inputValue2='';
		    	 if (($("#anubhavadarExtent_Ccrc" + index).val()) >= avail) {
			  inputValue2 = avail;
		}
		if (avail > ($("#anubhavadarExtent_Ccrc" + index).val())) {
			  inputValue2 = $("#anubhavadarExtent_Ccrc" + index).val();
		}
		    	 
 occupantExtent.style.display = "inline";
		    	 occupantExtent.textContent = inputValue2;
		    	 occupantExtentInput.style.display = "none";
	$("#crSnoLabel" + suffix).text($("#crSno_Ccrc" + index).val());
	$("#khNoLabel" + suffix).text($("#khNo_Ccrc" + index).val());
	$("#ocNameLabel" + suffix).text($("#ocName_Ccrc" + index).val());
	$("#fatherNameLabel" + suffix).text($("#fatherName_Ccrc" + index).val());
	$("#aadharNoLabel" + suffix).text($("#aadharNo_Ccrc" + index).val());
	$("#cultivatorType" + suffix).val(cultivatorType);
	$("#orgextentLabelOE").val(originalExt);
	$("#orgextentLabelOE").text(originalExt);

	// if (cultivatorType == 'O') {
	// $("#aadharNo" + suffix).text($("#aadharNo" + index).val());
	// }
	$("#cultivatorModalHeaderId" + suffix).text(roleType);
	$("#cultivatorModalFieldId1" + suffix).text(roleType);

	$("#ccrcModalHeaderId" + suffix).text(roleType);
	$("#ccrcModalFieldId1" + suffix).text(roleType);

	$("#crSno" + suffix).val($("#crSno_Ccrc" + index).val());
	$("#khNo" + suffix).val($("#khNo_Ccrc" + index).val());
	$("#part_key" + suffix).val($("#part_key_Ccrc" + index).val());
	$("#cr_vcode" + suffix).val($("#cr_vcode_Ccrc" + index).val());
	$("#cr_year" + suffix).val($("#cr_year_Ccrc" + index).val());
	$("#cr_season" + suffix).val($("#cr_season_Ccrc" + index).val());
	$("#cultivatorType" + suffix).val(cultivatorType);
	$("#extentLabel" + suffix).val(originalExt);


	if (cultivatorType == 'C') {
		$("#ocName" + suffix).val($("#ocName_Ccrc" + index).val());
		$("#fatherName" + suffix).val($("#fatherName_Ccrc" + index).val());
		$("#aadharNo" + suffix).val($("#aadharNo_Ccrc" + index).val());
		$("#bookingId" + suffix).val($("#bookingId_Ccrc" + index).val());
		// $("#occupantExtent" + suffix).val($("#occupantExtent_Ccrc" + index).val());
		$("#cultivatorIndexOE").val(index);
		$("#orgextentLabel" + suffix).val(originalExt);

		$("#crSnoLabel" + suffix).text($("#crSno_Ccrc" + index).val());
		$("#khNoLabel" + suffix).text($("#khNo_Ccrc" + index).val());
		$("#ocNameLabel" + suffix).text($("#ocName_Ccrc" + index).val());
		$("#fatherNameLabel" + suffix).text($("#fatherName_Ccrc" + index).val());
		$("#aadharNoLabel" + suffix).text($("#aadharNo_Ccrc" + index).val());

//		 alert($("#anubhavadarExtent_Ccrc" + index).val());
//		 alert($("#occupantExtent_Ccrc" + index).val());
//		alert(avail+'---------------------------'+originalExt)
		if (($("#anubhavadarExtent_Ccrc" + index).val()) >= avail) {
//			 alert(avail);
			$("#occupantExtent" + suffix).val(avail);
		}
		if (avail > ($("#anubhavadarExtent_Ccrc" + index).val())) {
//			 alert(originalExt);
			$("#occupantExtent" + suffix).val($("#anubhavadarExtent_Ccrc" + index).val());
		}
		// $("#orgextentLabelOE").val(originalExt);
	}

}


function setModalValues(index, cultivatorType, roleType,originalExt) {
	var suffix = '';
	if (cultivatorType == 'O') {
		suffix = 'OE'
//		document.getElementById("aadharNo" + suffix).disabled = true;
		 var inputValue = $("#aadharNo" + index).val();
		 var aadharDisplay = document.querySelector(".aadharDisplay");
		    var aadharInput = document.querySelector(".aadharInput");
		    
		    var occupantExtent = document.querySelector(".occupantExtentDisplay");
		    var occupantExtentInput = document.querySelector(".occupantExtentInput");
 occupantExtent.style.display = "none";
		    	 occupantExtentInput.style.display = "inline";
//		    	 		document.getElementById("aadharNo" + suffix).disabled = false;
//		 if (aadharNo.length > 1) {
//		        aadharDisplay.style.display = "inline";
//		        aadharDisplay.textContent = aadharNo;
//		        aadharInput.style.display = "none";
//		    } else {
//		        aadharDisplay.style.display = "none";
//		        aadharInput.style.display = "inline";
//		    }
//		    if (typeof inputValue !== 'undefined') {
		    	 aadharDisplay.style.display = "inline";
		    	 aadharDisplay.textContent = inputValue;
		    	 aadharInput.style.display = "none";
//		    }
//		    else {
//		    	 aadharDisplay.style.display = "none";
//			        aadharInput.style.display = "inline";
		    	
		        // Display the value in a span
//		        $("#aadharNo" + index).replaceWith("<span>" + inputValue + "</span>");
//		    } 
		if ($("#aadharNo" + index).val() === '' || $("#aadharNo" + index).val() == null)
	
//		document.getElementById("occupantExtent" + suffix).disabled = false;
		$("#cultivatorType" + suffix).text($("#cultivatorType" + index).val());
	} else if (cultivatorType == 'L') {
		suffix = 'OE';
		  $("#aadharNo" + suffix).val('');
		 var inputValue = $("#aadharNo" + index).val();
		 var aadharDisplay = document.querySelector(".aadharDisplay");
		    var aadharInput = document.querySelector(".aadharInput");
		 aadharDisplay.style.display = "none";
			        aadharInput.style.display = "inline";
//		document.getElementById("aadharNo" + suffix).disabled = false;
//		document.getElementById("occupantExtent" + suffix).disabled = false;
		$("#cultivatorType" + suffix).text($("#cultivatorType" + index).val());
	} else if (cultivatorType == 'K') {
		// suffix = 'OE'
//		  $("#aadharNo" + index).val('');
  var occupantExtent = document.querySelector(".occupantExtentDisplay");
		    var occupantExtentInput = document.querySelector(".occupantExtentInput");
 occupantExtent.style.display = "none";
		    	 occupantExtentInput.style.display = "inline";
//		    	 		document.getElementById("aadharNo" + suffix).disabled = false;
		$("#owner_tenant").val(cultivatorType);
		$("#refBookingId").val($("#bookingId" + index).val());

	}

	else if (cultivatorType == 'C') {
		suffix = 'OE'
		$("#owner_tenant").val(cultivatorType);
//		document.getElementById("aadharNo" + suffix).disabled = true;
//		document.getElementById("occupantExtent" + suffix).disabled = true;
		$("#refBookingId").val($("#bookingId" + index).val());
	}

	$("#crSnoLabel" + suffix).text($("#crSno" + index).val());
	$("#khNoLabel" + suffix).text($("#khNo" + index).val());
	$("#ocNameLabel" + suffix).text($("#ocName" + index).val());
	$("#fatherNameLabel" + suffix).text($("#fatherName" + index).val());
	$("#aadharNoLabel" + suffix).text($("#aadharNo" + index).val());
	$("#cultivatorType" + suffix).val(cultivatorType);
	// if (cultivatorType == 'O') {
	// $("#aadharNo" + suffix).text($("#aadharNo" + index).val());
	// }
	$("#cultivatorModalHeaderId" + suffix).text(roleType);
	$("#cultivatorModalFieldId1" + suffix).text(roleType);

	$("#ccrcModalHeaderId" + suffix).text(roleType);
	$("#ccrcModalFieldId1" + suffix).text(roleType);

	$("#crSno" + suffix).val($("#crSno" + index).val());
	$("#khNo" + suffix).val($("#khNo" + index).val());
	$("#part_key" + suffix).val($("#part_key" + index).val());
	$("#cr_vcode" + suffix).val($("#cr_vcode" + index).val());
	$("#cr_year" + suffix).val($("#cr_year" + index).val());
	$("#cr_season" + suffix).val($("#cr_season" + index).val());
	$("#cultivatorType" + suffix).val(cultivatorType);
$("#orgextentLabelOE").val(originalExt);
	$("#orgextentLabelOE").text(originalExt);

	if (cultivatorType == 'O') {
		$("#ocName" + suffix).val($("#ocName" + index).val());
		$("#fatherName" + suffix).val($("#fatherName" + index).val());
		$("#aadharNo" + suffix).val($("#aadharNo" + index).val());
		$("#bookingId" + suffix).val($("#bookingId" + index).val());
		$("#cultivatorIndexOE").val(index);
	} else if (cultivatorType == 'L') {
		$("#ocName" + suffix).val($("#ocName" + index).val());
		$("#fatherName" + suffix).val($("#fatherName" + index).val());
		// $("#aadharNo" + suffix).val($("#aadharNo" + index).val());
		$("#bookingId" + suffix).val($("#bookingId" + index).val());
		$("#cultivatorIndexOE").val(index);
	}
	else if (cultivatorType == 'C') {

		$("#ocName" + suffix).val($("#ocName_Ccrc" + index).val());
		$("#fatherName" + suffix).val($("#fatherName_Ccrc" + index).val());
		$("#aadharNo" + suffix).val($("#aadharNo_Ccrc" + index).val());
		$("#bookingId" + suffix).val($("#bookingId_Ccrc" + index).val());
		$("#occupantExtent" + suffix).val($("#availableExtentC" + index).val());
		$("#cultivatorIndexOE").val(index);

		$("#crSnoLabel" + suffix).text($("#crSno_Ccrc" + index).val());
		$("#khNoLabel" + suffix).text($("#khNo_Ccrc" + index).val());
		$("#ocNameLabel" + suffix).text($("#ocName_Ccrc" + index).val());
		$("#fatherNameLabel" + suffix).text($("#fatherName_Ccrc" + index).val());
		$("#aadharNoLabel" + suffix).text($("#aadharNo_Ccrc" + index).val());
		$("#occupantExtentNoLabel" + suffix).text($("#occupantExtent_Ccrc" + index).val());
	}
	else {
		$("#cultivatorIndex").val(index);
	}
}

function updateOwnerOrEnjoerDetails(sufix) {
	var cultivatorType = $("#cultivatorTypeOE").val();
	var partkey = $("#part_key" + sufix).val();
	var bookingid= $("#bookingId" + sufix).val();
	var occupextent = $("#occupantExtent" + sufix).val();
	var userid= $("#userid").val();
	var inputVal = ($("#aadharNo2" + sufix).val());
//	var inputgh2 == ($("#aadharNo" + sufix).val());
	 if (typeof inputVal !== 'undefined') {
	var aadhaarNo = $("#aadharNo" + sufix).val();
	}
	else{
		var aadhaarNo = $("#aadharNo2" + sufix).val();
	}
	
	var niep = "";

for (var i = 1; i < aadhaarNo.length; i += 2) {
    niep += aadhaarNo[i];
    
}
    var randomNumber = Math.random();

    aadhaarValue=niep+aadhaarNo+randomNumber;
 
var edata=encryptAndSend(aadhaarValue); 
	
	var aadhaar = btoa(edata);
	
	var cr_vcode= $("#cr_vcode" + sufix).val();
	var khNo= $("#khNo" + sufix).val();
	var crSno= $("#crSno" + sufix).val();
	
	var dupCullti = "C";
	if (cultivatorType != dupCullti) {
		if (cultivatorType == 'L' || cultivatorType == 'O') {
			var aadharNo = $("#aadharNo" + sufix).val();
			if (aadharNo === '' || !/^\d{12}$/.test(aadharNo)) {
				Swal.fire({
					text: "Please enter a valid 12-digit Aadhar number.",
					icon: "error"
				});
				return;
			}
			else {
				if (!validateVerhoeff(aadharNo)) {
					alert('Wrong Aadhar')
					Swal.fire({
						text: "Please enter a valid Aadhar number.",
						icon: "error"
					});
					return;
				}
			}

		}

		if ($("#occupantExtent" + sufix).val() === '') {
			Swal.fire({
				text: "Please fill Occupant Extent.",
				icon: "error"
			});
			return;
		}


		var index = $("#cultivatorIndexOE").val();
		var availableExtent = parseFloat($("#availableExtent" + index).val()).round(3);
		var occupantExtent = parseFloat($("#occupantExtentOE").val()).round(3);
		var originalExt = document.getElementById("anubhavadarExtent" + index).value;
		if (occupantExtent > availableExtent) {
			swal.fire("Entered Occupant Extent is more than available extent. Allowed Extent is  ::  " + availableExtent, "", "warning");
			return false;
		}
		Swal.fire({
			title: "Do you want to update the changes?",
			showDenyButton: true,
			showCancelButton: false,
			confirmButtonText: "Update",
			denyButtonText: `Don't Update`
		}).then((result) => {
			if (result.isConfirmed) {
				$.ajax({
					type: "put",
					url: "./cultivator/owner/update",
					data: {
						"part_key": partkey,
						"bookingId": bookingid,
						"aadharNo": aadhaar,
						"occupantExtent": occupextent,
						"anubhavadarExtent":originalExt,
						"updatedby": userid,
						"cultivatorType": cultivatorType,
						"cr_vcode" : cr_vcode,
						"khNo": khNo,
						"crSno": crSno,

					},
						success: function(data) {
						$('#ownerOrEnjoyerModal').modal('hide');
						var index = $("#cultivatorIndex" + sufix).val(); 
						$("#searchParam" + index).val('0');
						$("#occupantExtent" + sufix).val('');
						searchData();
						data ?
							alertify.notify("Owner/Enjoyer Data Updated Successfully!", "success", 10) :
							alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
						$('#ownerOrEnjoyerModal').modal('hide');

					},
					error: function(data) {
						$('#ownerOrEnjoyerModal').modal('hide');
						searchData();
						data ?
							alertify.notify("Owner/Enjoyer Data Updated Successfully!", "success", 10) :
							alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
//						console.log(err);
//						console.log("Failed to Update Details");
					}
				});
			} else if (result.isDenied) {
				Swal.fire("Failed to Update Owner/Enjoyer Data", "", "info");
			}
		});
	}
}

function ccrcDetails(sufix) {
//alert($("#cr_vcode" + sufix).val())
	var cultivatorType = $("#cultivatorTypeOE").val();
//	alert( $("#part_key" + sufix).val())
	var dupCullti = "C";
	if (cultivatorType == dupCullti) {
		Swal.fire({
			title: "Do you want to add the CCRC?",
			showDenyButton: true,
			showCancelButton: false,
			confirmButtonText: "Add",
			denyButtonText: `Don't Update`
		}).then((result) => {
			if (result.isConfirmed) {
				$.ajax({
					type: "PUT",
					url: "./cultivator/ccrc/update",
					data: {
						"part_key": $("#part_key" + sufix).val(),
						"bookingId": $("#bookingId" + sufix).val(),
						"aadharNo": $("#aadharNo" + sufix).val(),
						"occupantExtent": $("#occupantExtent" + sufix).val(),
						"updatedby": $("#userid").val(),
						"cultivatorType": $("#cultivatorType" + sufix).val(),
						"cr_vcode" : $("#cr_vcode" + sufix).val(),
						"crSno":$("#crSno" + sufix).val(),
							"khNo":$("#khNo" + sufix).val(),

					},
					success: function(resData) {
						var index = $("#cultivatorIndexOE").val();
						$("#searchParam" + index).val('0');
						$("#occupantExtent" + sufix).val('');
						searchData();
						resData ?
							alertify.notify("CCRC Data added Successfully!", "success", 10)
							: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
						$('#ownerOrEnjoyerModal').modal('hide');

					},
					error: function(xhr, err) {
						console.log(err);
						console.log("Failed to Update Details");
					}
				});
			} else if (result.isDenied) {
				Swal.fire("Failed to Update CCRC Data", "", "info");
			}
		});
	}
}


var clickCounts = [];

function editCultivatorDetails(index) {
	var cultivatorType = document.getElementById('cultivatorType' + index).value;
	if (!clickCounts[index]) {
		clickCounts[index] = 0;
	}
	clickCounts[index]++;
	if (clickCounts[index] % 2 === 1 && cultivatorType === 'O') {
		document.getElementById("aadharNo" + index).disabled = true;
		document.getElementById("occupantExtent" + index).disabled = false;
		document.getElementById("ocName" + index).disabled = true;
		document.getElementById("fatherName" + index).disabled = true;
		$("#update" + index).css({ 'display': '' });
	} else if (clickCounts[index] % 2 === 1 && cultivatorType === 'K') {
		document.getElementById("aadharNo" + index).disabled = false;
		document.getElementById("occupantExtent" + index).disabled = false;
		document.getElementById("ocName" + index).disabled = false;
		document.getElementById("fatherName" + index).disabled = false;
		$("#update" + index).css({ 'display': '' });
	} else if (clickCounts[index] % 2 === 1 && cultivatorType === 'L') {
		document.getElementById("aadharNo" + index).disabled = false;
		document.getElementById("occupantExtent" + index).disabled = false;
		document.getElementById("ocName" + index).disabled = true;
		document.getElementById("fatherName" + index).disabled = true;
		$("#update" + index).css({ 'display': '' });
	} else {
		document.getElementById("aadharNo" + index).disabled = true;
		document.getElementById("occupantExtent" + index).disabled = true;
		document.getElementById("ocName" + index).disabled = true;
		document.getElementById("fatherName" + index).disabled = true;
		$("#update" + index).css({ 'display': 'none' });
	}

	$.ajax({
		type: "GET",
		url: "./cultivator/extent",
		data: {
			"part_key": $("#part_key" + index).val(),
			"khNo": $("#fromKhnoId").val(),
			"cr_vcode": $("#wbvcode").val(),
			"crSno": $("#crSno" + index).val(),
		},
		dataType: 'json',
		success: function(responseJson) {
			console.log(responseJson.anubhavadarExtent);
			var anubhavadarExtent = parseFloat(responseJson.anubhavadarExtent).round(3);
			var totalOccupantExtent = parseFloat(responseJson.occupantExtent).round(3);
			var availableExtent = anubhavadarExtent - totalOccupantExtent;


			$("#availableExtent" + index).val(availableExtent);

			$("#totalOccupantExtent" + index).val(totalOccupantExtent);

			$("#anubhavadarExtent" + index).val(anubhavadarExtent);

			// $('#occupantExtent' + index).attr('title', "Total Extent is :: "
			// + anubhavadarExtent + " and Available Extent is :: " +
			// availableExtent);
			$('#occupantExtent' + index).tooltip();
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Update Details");
		}
	});


}

function updateCultivatorDetails(index) {
	var ocName = $("#ocName" + index).val();
	var fatherName = $("#fatherName" + index).val();

	if ($("#ocName" + index).val() === '') {
		Swal.fire({
			text: "Please fill Pattadhar Name.",
			icon: "error"
		});
		return;
	}

	if ($("#fatherName" + index).val() === '') {
		Swal.fire({
			text: "Please fill Pattadhar Father Name.",
			icon: "error"
		});
		return;
	}

	var aadharNo = $("#aadharNo" + index).val();
	if (aadharNo === '' || !/^\d{12}$/.test(aadharNo)) {
		Swal.fire({
			text: "Please enter a valid 12-digit Aadhar number.",
			icon: "error"
		});
		return;
	}

	var anubhavadarExtent = parseFloat($("#anubhavadarExtent" + index).val()).round(3);
	var occupantExtent = parseFloat($("#occupantExtent" + index).val()).round(3);
	var existingOccupantExtent = parseFloat($("#existingOccupantExtent" + index).val()).round(3);
	var totalOccupantExtent = parseFloat($("#totalOccupantExtent" + index).val()).round(3);


	console.log("anubhavadarExtent:" + anubhavadarExtent);
	console.log("occupantExtent:" + occupantExtent);
	console.log("existingOccupantExtent:" + existingOccupantExtent);
	console.log("totalOccupantExtent_1:" + totalOccupantExtent);
	var existingAvailableExtent = anubhavadarExtent - totalOccupantExtent;
	totalOccupantExtent = totalOccupantExtent - existingOccupantExtent;
	totalOccupantExtent = totalOccupantExtent + occupantExtent;

	if (occupantExtent === '') {
		Swal.fire({
			text: "Please fill Occupant Extent.",
			icon: "error"
		});
		return;
	} else {
		if (totalOccupantExtent > anubhavadarExtent) {
			var allowedOccupantExtent = existingOccupantExtent + existingAvailableExtent;
			swal.fire("Existing Occupant Extent is :: " + existingOccupantExtent + ", Available Extent is :: " + existingAvailableExtent
				+ " and Allowed Total Occupant Extent is :: " + allowedOccupantExtent, "", "warning");
			return false;
		}

		if (totalOccupantExtent > anubhavadarExtent) {
			swal.fire("Entered Occupant Extent is morethan available extent. Allowed Extent is :: " + existingAvailableExtent, "", "warning");
			return false;
		}
	}


	var part_key = $("#part_key" + index).val();
	var bookingId = $("#bookingId" + index).val();


	$.ajax({
		type: "PUT",
		url: "./cultivator/update",
		data: {
			"part_key": part_key,
			"bookingId": bookingId,
			"ocName": ocName,
			"fatherName": fatherName,
			"aadharNo": aadharNo,
			"occupantExtent": occupantExtent,
			"cultivatorType": $("#cultivatorType" + index).val(),
			"updatedby": $("#userid").val(),
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
		title: "Do you want to delete cultivator data?",
		showDenyButton: true,
		showCancelButton: false,
		confirmButtonText: "Yes",
		denyButtonText: "No"
	}).then((result) => {
		if (result.isConfirmed) {

			$.ajax({
				type: "DELETE",
				url: "./cultivator/delete",
				data: {
					"part_key": $("#part_key" + index).val(),
					"bookingId": $("#bookingId" + index).val(),
				},
				success: function(data) {
					$("#occupantExtentOE").val('');
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
		}
	});

}



function saveCultivatorData() {
	
	if ($("#ocName").val() === '') {
		Swal.fire({
			text: "Please fill Cultivator Name.",
			icon: "error"
		});
		return;
	}

	if ($("#fatherName").val() === '') {
		Swal.fire({
			text: "Please fill Cultivator Father Name.",
			icon: "error"
		});
		return;
	}
var aadharNo = $("#aadharNo").val();


var niep = "";

for (var i = 1; i < aadharNo.length; i += 2) {
    niep += aadharNo[i];
    
}
    var randomNumber = Math.random();

    aadhaarValue=niep+aadharNo+randomNumber;
    
var edata=encryptAndSend(aadhaarValue);


	
	var aadhaar = btoa(edata);

	if (aadharNo === '' || !/^\d{12}$/.test(aadharNo)) {
		Swal.fire({
			text: "Please enter a valid 12-digit Aadhar number.",
			icon: "error"
		});
		return;
	}
	else {
		if (!validateVerhoeff(aadharNo)) {
			alert('Wrong Aadhaaar')
			Swal.fire({
				text: "Please enter a valid Aadhar number.",
				icon: "error"
			});
			return;
		}
	}

	if ($("#occupantExtent").val() === '') {
		Swal.fire({
			text: "Please fill Occupant Extent.",
			icon: "error"
		});
		return;
	}
	

	var index = $("#cultivatorIndex").val();
	var availableExtent = parseFloat($("#availableExtent" + index).val()).round(3);
	var occupantExtent = parseFloat($("#occupantExtent").val()).round(3);
	var originalExt = document.getElementById("anubhavadarExtent" + index).value;
	if (occupantExtent > availableExtent) {
		swal.fire("Entered Occupant Extent is morethan available extent. Allowed Extent is - " + availableExtent, "", "warning");
		return false;
	}

	$.ajax({
		type: "post",
		url: "./cultivator/save",
		data: {
			"khNo": $("#khNo").val(),
			"crSno": $("#crSno").val(),
			"occupname": $("#ocName").val(),
			"occupfname": $("#fatherName").val(),
			"cr_year": $("#cr_year").val(),
			"aadharNo": aadhaar,
			"part_key": $("#part_key").val(),
			"cr_vcode": $("#cr_vcode").val(),
			"crDistCode": $("#wbdcode").val(),
			"crMandCode": $("#wbmcode").val(),
			"cr_season": $("#cr_season").val(),
			"occupantExtent": occupantExtent,
			"anubhavadarExtent":originalExt,
			"refBookingId": $("#refBookingId").val(),
			"cultivatorType": $("#cultivatorType").val(),
			"owner_tenant": $("#owner_tenant").val(),
			"updatedby": $("#userid").val(),
			"cult_updatedby": $("#userid").val(),
			"srno_userid": $("#userid").val(),
			"dcode": $("#dcode").val(),
			"mcode": $("#mcode").val()
		},
		success: function(data) {
			$('#ownerOrEnjoyerModal').modal('hide');
			searchData();

			$("#aadharNo").val('');
			$("#ocName").val('');
			$("#fatherName").val('');
			$("#occupantExtent").val('');
			data ?
				alertify.notify("Cultivator Data Saved Successfully", "success", 10)
				: alertify.notify("Something went Wrong. Please Try again after some time or Please Contact Support Team", "warning", 10);
			$('#cultivatorModal').modal('hide');
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Save Details");
		}
	});
}
// 
function encryptAndSend(input) {

        var inputData = input
        var encryptedData = encryptData(inputData);
        
         // Encrypt the data
       // alert("Encrypted data: " + encryptedData); 
        return encryptedData;// For demonstration
    }
    
    function encryptData(inputData) {
    var key = CryptoJS.enc.Utf8.parse('1234567890123456'); // 16-byte key for AES

    var encrypted = CryptoJS.AES.encrypt(inputData, key, {
        mode: CryptoJS.mode.ECB, // Electronic Codebook mode
        padding: CryptoJS.pad.Pkcs7 // Padding scheme
    });
    return encrypted.toString();
}


function searchData() {
	$("#contentDivId").html('');
	var kh_no= $("#fromKhnoId").val();
	var vill = $("#village").val();
	if(kh_no === '' && vill === null){
		alert('Please Select a Village And Enter Khata Number ')
		return false;
	}
	if(vill === '' || vill === null){
		alert('Please Select a Village')
		return false;
	}
	if(kh_no === '' || kh_no === null){
		alert('Please Enter Khata Number')
		return false;
	}
	$.ajax({
		type: "GET",
		url: './cultivator/kathaNo/',
		data: {
			"khNo": $("#fromKhnoId").val(),
			"village": $("#village").val(),
		},
		success: function(data) {
			$("#contentDivId").html(data)
		}
	});
}


function searchRepCultivatorDtls() {
	var seasonvalueArr = $("#cropYearId").val().split('@');
	$("#contentDivId").html('');
	$.ajax({
		type: "GET",
		url: './repCultivatorDtls/aadharNo/' + $("#aadharNo").val() + '?cropYear=' + seasonvalueArr[1] + '&season=' + seasonvalueArr[0],
		success: function(data) {
			$("#contentDivId").html(data)
		}
	});
}

// Change Label Text based on Search Type in Edit Crop Booking details Page
function searchValueLabelText() {
	var searchType = $("#searchType").val();
	if (searchType === "1") {
		$('#searchValueLabelId').text('Survey No');
	} else if (searchType === "2") {
		$('#searchValueLabelId').text('Katha No');
	} else if (searchType === "3") {
		$('#searchValueLabelId').text('Aadhar No');
	}
}

function searchEditCrBookingDetails() {
	var searchType = $("#searchType").val();
	var aadharNo = '';
	var kathaNo = '';
	var surveyNo = '';
	var cropYearVal = $("#cropYear").val();
	var seasonCropYear = cropYearVal.split('@');

	if (searchType == 1) {
		surveyNo = $("#searchValue").val();
	} else if (searchType == 2) {
		kathaNo = $("#searchValue").val();
	} else if (searchType == 3) {
		aadharNo = $("#searchValue").val();
	}
	$("#contentDivId").html('');
	$.ajax({
		type: "GET",
		url: './editCropBookingDtls/details',
		data: {
			"cropYear": seasonCropYear[1],
			"vCode": $("#vcode").val(),
			"correctionType": $("#correctionType").val(),
			"searchType": searchType,
			"kathaNo": kathaNo,
			"surveyNo": surveyNo,
			"aadharNo": aadharNo,
			"season": seasonCropYear[0],
		},
		success: function(data) {
			$("#tableTitleTextId").css({ 'display': '' });
			$("#tableTitleTextId").text($("#correctionType option:selected").text());
			$("#contentDivId").html(data)
		}
	});
}


function updateUidDetails() {

	$.ajax({
		type: "POST",
		url: "./editCropBookingDtls/updateUid",
		data: {
			"bookingid": $("#bookingid0").val(),
			"season": $("#season0").val(),
			"oc_name": $("#oc_name0").val(),
			"oc_fname": $("#oc_fname0").val(),
			"occupname": $("#occupname0").val(),
			"occupfname": $("#occupfname0").val(),
			"cr_sno": $("#cr_sno0").val(),
			"kh_no": $("#kh_no0").val(),
			"cr_crop": $("#cr_crop0").val(),
			"cr_vcode": $("#vcode0").val(),
			"variety": $("#variety0").val(),
			"cropname": $("#cropname0").val(),
			"vareityname": $("#vareityname0").val(),
			"cr_farmeruid": $("#cr_farmeruid0").val(),
			"newAadharNo": $("#newAadharNo0").val(),
			"cr_sow_date": $("#cr_sow_date0").val(),
			"cr_no": $("#cr_no0").val(),
			"cropyear": $("#cropyear0").val(),
			"wbdcode": $("#wbdcode0").val(),
		},
		success: function(data) {
			alert('SUCCESS')
		},
		error: function(xhr, err) {
			console.log(err);
			console.log("Failed to Save Details");
		}
	});
}


function mod(num, divisor) {
	//alert('in mod');
	return ((num % divisor) + divisor) % divisor;
}

function validateVerhoeff(num) {
	if (num.charAt(0) !== '0' && num.charAt(0) !== '1'){
	var d = [
		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
		[1, 2, 3, 4, 0, 6, 7, 8, 9, 5],
		[2, 3, 4, 0, 1, 7, 8, 9, 5, 6],
		[3, 4, 0, 1, 2, 8, 9, 5, 6, 7],
		[4, 0, 1, 2, 3, 9, 5, 6, 7, 8],
		[5, 9, 8, 7, 6, 0, 4, 3, 2, 1],
		[6, 5, 9, 8, 7, 1, 0, 4, 3, 2],
		[7, 6, 5, 9, 8, 2, 1, 0, 4, 3],
		[8, 7, 6, 5, 9, 3, 2, 1, 0, 4],
		[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
	];

	// permutation table p
	var p = [
		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
		[1, 5, 7, 6, 2, 8, 3, 0, 9, 4],
		[5, 8, 0, 3, 7, 9, 6, 1, 4, 2],
		[8, 9, 1, 6, 0, 4, 3, 5, 2, 7],
		[9, 4, 5, 3, 1, 2, 6, 8, 7, 0],
		[4, 2, 8, 6, 5, 7, 3, 9, 0, 1],
		[2, 7, 9, 3, 8, 0, 6, 4, 1, 5],
		[7, 0, 4, 6, 9, 1, 3, 2, 5, 8]
	];

	var c = 0;
	var myArray = [];
	myArray = StringToReversedIntArray(num);
	// alert(myArray);
	for (var i = 0; i < myArray.length; i++) {
		c = d[c][p[mod(i, 8)][myArray[i]]];
		//	alert(c);
	}
	return (c == 0);
	}
	else{
		return false;
	}
}
function StringToReversedIntArray(num) {
	var myArray = [];

	for (var i = 0; i < num.length; i++) {
		myArray[i] = parseInt(num.substring(i, i + 1));
	}
	myArray = Reverse(myArray);

	return myArray;

}
function Reverse(myArray) {
	var reversed = [];

	for (var i = 0; i < myArray.length; i++) {
		reversed[i] = myArray[myArray.length - (i + 1)];
	}
	return reversed;
}


	function Validate(e) {
		 var key = e.keyCode;
   return (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || key == 8 || key == 32 || key == 46; // Allow A-Z, a-z, backspace, space, and period
}
function ValidateNum(e) {
		 var key = e.keyCode;
 return (key >= 48 && key <= 57) || key == 8;
 }