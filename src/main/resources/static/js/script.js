$(document).ready(function() {


	var hrefCrp = "./getScheme";
	$.get(hrefCrp, function(mascropyears) { // Line 6
		$("#scheme").empty().append('<option value="0">Select Scheme</option>');

		if (mascropyears != '') {
			var $select1 = $("#scheme");

			$.each(mascropyears, function(i, masCropYear) {

				var option = $('<option>', {
					value: masCropYear.scheme_id
				}).html(masCropYear.crop_year).appendTo($select1);

			});

		}
	});



	var hrefCrp = "./getDistricts";
	$.get(hrefCrp, function(mascropyears) { // Line 6
		//  alert("is call");
		$("#employee").empty().append('<option value="0">Select District</option>');

		if (mascropyears != '') {
			var $select1 = $("#employee");

			$.each(mascropyears, function(i, masCropYear) {

				var option = $('<option>', {
					value: masCropYear.dcode
				}).html(masCropYear.dname).appendTo($select1);

			});

		}
	});


	var hrefCrp = "./getImplementTypes";
	$.get(hrefCrp, function(mascropyears) { // Line 6
		//  alert("is call");
		$("#implementstype").empty().append('<option value="0">Select ImplementsType</option>');

		if (mascropyears != '') {
			var $select1 = $("#implementstype");

			$.each(mascropyears, function(i, masCropYear) {

				var option = $('<option>', {
					value: masCropYear.impltype_id
				}).html(masCropYear.impltype_name).appendTo($select1);

			});

		}
	});

/*
	var hrefCrp = "./getImplements";
	$.get(hrefCrp, function(mascropyears) { // Line 6
		//  alert("is call");
		$("#Implement").empty().append('<option value="0">Select ImplementsType</option>');

		if (mascropyears != '') {
			var $select1 = $("#Implement");

			$.each(mascropyears, function(i, masCropYear) {

				var option = $('<option>', {
					value: masCropYear.impl_id
				}).html(masCropYear.impl_name).appendTo($select1);

			});

		}
	});
	
	
	 $("#table_crop").DataTable({
                destroy: true,
                lengthMenu: [
                    [10, 20, 30, -1],
                    [10, 20, 30, 'All']
                ],
                ajax: {
                    url: "./getmastersimplementationlist",
                    type: "GET",
                    dataSrc: ""
                },
                columns: [
			     { data: "implementid" }, // Hidden ID column for identification

                    { data: "implementname", className: "editable" },
                    { data: "status", className: "editable" },
                    {
                        // Add a column for Edit button
                        render: function(data, type, row) {
                            return '<button type="button" class="btn btn-primary btn-sm edit-btn">Edit</button>';
                        }
                    }
                ],
                columnDefs: [
                    {
                        targets: [0],
                        className: "dt-body-left",
                        width: 200
                    },
                     {
                        targets: [1],
                        className: "dt-body-left",
                        width: 200
                    },
                    {
                        targets: [2],
                        className: "dt-body-left",
                        width: 200
                    },
                     {
                        targets: [3],
                        className: "dt-body-left",
                        width: 200
                    }
                ],
                dom: 'Blfrtip',
                paging: true,
                searching: true,
                buttons: [
                    {
                        extend: 'copy',
                        className: 'btn btn-success rounded-0',
                        text: '<i class="far fa-copy"></i> Copy',
                        footer: true
                    },
                    {
                        extend: 'print',
                        orientation: 'landscape',
                        pageSize: 'A4',
                        className: 'btn btn-success rounded-0',
                        text: '<i class="fas fa-print"></i> Print',
                        footer: true
                    },
                    {
                        extend: 'pdf',
                        orientation: 'landscape',
                        pageSize: 'A4',
                        className: 'btn btn-success rounded-0',
                        text: '<i class="far fa-file-pdf"></i> Pdf',
                        footer: true
                    },
                    {
                        extend: 'csv',
                        className: 'btn btn-success rounded-0',
                        text: '<i class="fas fa-file-csv"></i> CSV',
                        footer: true
                    },
                    {
                        extend: 'excel',
                        className: 'btn btn-success rounded-0',
                        text: '<i class="far fa-file-excel"></i> Excel',
                        footer: true
                    }
                ]
            });
    
    $('#table_crop tbody').on('click', '.edit-btn', function () {
        var row = table.row($(this).parents('tr'));
        alert(row);
        var rowData = row.data();
                alert(rowData);

        // Replace table cell content with input fields
        row.cells().every(function () {
            var cell = $(this.node());
            var cellIndex = this.index().column;
            if (cellIndex === 0 || cellIndex === 3) return; // Skip ID and Action columns
            
            var originalValue = this.data();
            var input = $('<input type="text" class="form-control" value="' + originalValue + '">');
            
            // Update data on input blur
            input.blur(function () {
                var newValue = $(this).val();
                var cellData = table.cell(cell).data();
                var cellDataIndex = cellData.index();
                $.ajax({
                    url: '/updateData',
                    type: 'POST',
                    data: JSON.stringify({id: rowData.id, cellDataIndex: cellDataIndex, newValue: newValue}),
                    contentType: 'application/json',
                    success: function(data) {
                        // Update cell data and redraw table
                        table.cell(cell).data(newValue).draw();
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        console.log('Error updating data:', errorThrown);
                    }
                });
            });
            
            // Replace cell content with input field
            cell.html(input);
            input.focus(); // Focus on the input field for editing
        });
    });*/
    
    //  code    working 
 /* $(document).ready(function() {
    var table = $("#table_crop").DataTable({
        destroy: true,
        lengthMenu: [
            [25, 50, 100, -1],
            [25, 50, 100, 'All']
        ],
        ajax: {
            url: "./getmastersimplementationlist",
            type: "GET",
            dataSrc: ""
        },
        columns: [
            { data: "id", visible: false }, // Hidden ID column for identification
            { data: "implementname", className: "editable" },
            { data: "status", className: "editable" },
            {
                // Edit button column
                render: function(data, type, row) {
                    return '<button type="button" class="btn btn-primary btn-sm edit-btn">Edit</button>';
                }
            }
        ],
        columnDefs: [
            {
                targets: [1, 2],
                className: "dt-body-left",
                width: 200
            }
        ],
        dom: 'Blfrtip',
        paging: true,
        searching: true,
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-success rounded-0',
                text: '<i class="far fa-copy"></i> Copy',
                footer: true
            },
            // Other button configurations...
        ]
    });

    // Handle click on Edit button in DataTable
    $('#table_crop tbody').on('click', '.edit-btn', function () {
        var currentRow = $(this).closest('tr'); // Get the parent row of the clicked button

        // Toggle editing state for the clicked row
        if (currentRow.hasClass('editing')) {
            // If already editing, disable editing
            disableRowEditing(currentRow);
        } else {
            // Disable editing for all rows except the clicked row
            disableAllRowEditing();
            
            // Enable editing for the clicked row
            enableRowEditing(currentRow);
        }
    });

    // Function to disable editing for all rows except the given row
    function disableAllRowEditing() {
        table.rows().nodes().to$().removeClass('editing'); // Remove 'editing' class from all rows
        table.cells().nodes().to$().find('input').each(function () {
            var cell = $(this).parent();
            var value = $(this).val();
            cell.html(value); // Reset cell content to original value
        });
    }

    // Function to enable editing for a specific row
    function enableRowEditing(row) {
        row.addClass('editing'); // Add 'editing' class to the clicked row

        // Replace table cell content with input fields for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var originalValue = table.cell(cell).data();
            var input = $('<input type="text" class="form-control" value="' + originalValue + '">');

            // Update data on input blur
            input.blur(function () {
                var newValue = $(this).val();
                table.cell(cell).data(newValue); // Update cell data in DataTable
                // Optionally, update data in backend via AJAX
                // updateData(row.data().id, cell.index().column, newValue);
            });

            // Replace cell content with input field
            cell.html(input);
        });
    }

    // Function to disable editing for a specific row
    function disableRowEditing(row) {
        row.removeClass('editing'); // Remove 'editing' class from the clicked row

        // Replace input fields with original cell content for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var value = cell.find('input').val(); // Get current input value
            cell.html(value); // Replace input field with original cell content
        });
    }

    // Example function for updating data via AJAX
   function updateData(id, column, value) {
        $.ajax({
            url: './updateData',
            type: 'POST',
            data: {
                id: id,
                column: column,
                value: value
            },
            success: function(response) {
                console.log('Data updated successfully');
            },
            error: function(xhr, textStatus, errorThrown) {
                console.error('Error updating data:', errorThrown);
            }
        });
    }
});*/


/*$(document).ready(function() {
    var table = $("#table_crop").DataTable({
        destroy: true,
        lengthMenu: [
            [10, 20, 30, -1],
            [10, 20, 30, 'All']
        ],
        ajax: {
            url: "./getmastersimplementationlist", // Replace with your data source URL
            type: "GET",
            dataSrc: ""
        },
        columns: [
            { data: "id" },
            { data: "implementname", className: "editable" },
            { data: "status", className: "editable" },
            {
                // Edit button column
                render: function(data, type, row) {
                    return '<button type="button" class="btn btn-primary btn-sm edit-btn">Edit</button>';
                }
            }
        ],
        columnDefs: [
            {
                targets: [0],
                visible: false // Hide ID column
            }
        ],
        dom: 'Blfrtip',
        paging: true,
        searching: true,
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-success rounded-0',
                text: '<i class="far fa-copy"></i> Copy',
                footer: true
            }
            // Add other buttons as needed
        ]
    });

    // Handle click on Edit button in DataTable
    $('#table_crop tbody').on('click', '.edit-btn', function () {
        var currentRow = $(this).closest('tr'); // Get the parent row of the clicked button

        // Toggle editing state for the clicked row
        if (currentRow.hasClass('editing')) {
            // If already editing, disable editing
            disableRowEditing(currentRow);
        } else {
            // Disable editing for all rows except the clicked row
            disableAllRowEditing();
            
            // Enable editing for the clicked row
            enableRowEditing(currentRow);
        }
    });

    // Function to disable editing for all rows except the given row
    function disableAllRowEditing() {
        table.rows().nodes().to$().removeClass('editing'); // Remove 'editing' class from all rows
        table.cells().nodes().to$().find('input').each(function () {
            var cell = $(this).parent();
            var value = $(this).val();
            cell.html(value); // Reset cell content to original value
        });
        $('#saveChangesBtn').prop('disabled', true); // Disable Save Changes button
    }

    // Function to enable editing for a specific row
    function enableRowEditing(row) {
        row.addClass('editing'); // Add 'editing' class to the clicked row

        // Replace table cell content with input fields for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var originalValue = table.cell(cell).data();
            var input = $('<input type="text" class="form-control" value="' + originalValue + '">');

            // Update data on input blur
            input.blur(function () {
                var newValue = $(this).val();
                table.cell(cell).data(newValue); // Update cell data in DataTable
                $('#saveChangesBtn').prop('disabled', false); // Enable Save Changes button on any edit
            });

            // Replace cell content with input field
            cell.html(input);
        });
    }

    // Function to disable editing for a specific row
    function disableRowEditing(row) {
        row.removeClass('editing'); // Remove 'editing' class from the clicked row

        // Replace input fields with original cell content for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var value = cell.find('input').val(); // Get current input value
            cell.html(value); // Replace input field with original cell content
        });

        // Check if there are any other rows in editing mode
        var anyEditingRows = table.rows('.editing').count() > 0;
        if (!anyEditingRows) {
            $('#saveChangesBtn').prop('disabled', true); // Disable Save Changes button if no rows are editing
        }
    }

    // Save Changes button click event
    $('#saveChangesBtn').click(function() {
        saveChanges();
    });

    // Example function for updating data via AJAX
   function saveChanges(rowData) {
    var id = rowData.id;
    var implementname = rowData.implementname;
    var status = rowData.status;

    var updatedData = {
        id: id,
        implementname: implementname,
        status: status
    };

    $.ajax({
        url: './updateData', // Replace with your update data URL
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function(response) {
            console.log('Data saved successfully');
            // Optionally, refresh DataTable after save
            table.ajax.reload(null, false);
        },
        error: function(xhr, textStatus, errorThrown) {
            console.error('Error saving data:', errorThrown);
        }
    });
}
});
*/



/*$(document).ready(function() {
    var table = $("#table_crop").DataTable({
        destroy: true,
        lengthMenu: [
            [10, 20, 30, -1],
            [10, 20, 30, 'All']
        ],
        ajax: {
            url: "./getmastersimplementationlist", // Replace with your data source URL
            type: "GET",
            dataSrc: ""
        },
        columns: [
            { data: "id" },
            { data: "implementname", className: "editable" },
            { data: "status", className: "editable" },
            {
                // Edit button column
                render: function(data, type, row) {
                    return '<button type="button" class="btn btn-primary btn-sm edit-btn">Edit</button>';
                }
            }
        ],
        columnDefs: [
            {
                targets: [0],
                visible: false // Hide ID column
            }
        ],
        dom: 'Blfrtip',
        paging: true,
        searching: true,
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-success rounded-0',
                text: '<i class="far fa-copy"></i> Copy',
                footer: true
            }
            // Add other buttons as needed
        ]
    });

    // Handle click on Edit button in DataTable
    $('#table_crop tbody').on('click', '.edit-btn', function () {
        var currentRow = $(this).closest('tr'); // Get the parent row of the clicked button

        // Toggle editing state for the clicked row
        if (currentRow.hasClass('editing')) {
            // If already editing, disable editing
            disableRowEditing(currentRow);
        } else {
            // Disable editing for all rows except the clicked row
            disableAllRowEditing();
            
            // Enable editing for the clicked row
            enableRowEditing(currentRow);
        }
    });

    // Function to disable editing for all rows except the given row
    function disableAllRowEditing() {
        table.rows().nodes().to$().removeClass('editing'); // Remove 'editing' class from all rows
        table.cells().nodes().to$().find('input').each(function () {
            var cell = $(this).parent();
            var value = $(this).val();
            cell.html(value); // Reset cell content to original value
        });
        $('#saveChangesBtn').prop('disabled', true); // Disable Save Changes button
    }

    // Function to enable editing for a specific row
    function enableRowEditing(row) {
        row.addClass('editing'); // Add 'editing' class to the clicked row

        // Replace table cell content with input fields for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var originalValue = table.cell(cell).data();
            var input = $('<input type="text" class="form-control" value="' + originalValue + '">');

            // Update data on input blur
            input.blur(function () {
                var newValue = $(this).val();
                table.cell(cell).data(newValue); // Update cell data in DataTable
                $('#saveChangesBtn').prop('disabled', false); // Enable Save Changes button on any edit
            });

            // Replace cell content with input field
            cell.html(input);
        });
    }

    // Function to disable editing for a specific row
    function disableRowEditing(row) {
        row.removeClass('editing'); // Remove 'editing' class from the clicked row

        // Replace input fields with original cell content for editable columns
        table.cells(row, '.editable').nodes().to$().each(function () {
            var cell = $(this);
            var value = cell.find('input').val(); // Get current input value
            cell.html(value); // Replace input field with original cell content
        });

        // Check if there are any other rows in editing mode
        var anyEditingRows = table.rows('.editing').count() > 0;
        if (!anyEditingRows) {
            $('#saveChangesBtn').prop('disabled', true); // Disable Save Changes button if no rows are editing
        }
    }

    // Save Changes button click event
    $('#saveChangesBtn').click(function() {
        saveChanges();
    });

    // Example function for updating data via AJAX
    function saveChanges() {
        var data = table.rows().data().toArray();
        var updatedData = [];

        $.each(data, function(index, rowData) {
            var id = rowData.id;
            var implementname = rowData.implementname;
            var status = rowData.status;

            updatedData.push({
                id: id,
                implementname: implementname,
                status: status
            });
        });

        $.ajax({
            url: './updateData', // Replace with your update data URL
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(updatedData),
            success: function(response) {
                console.log('Data saved successfully');
                // Optionally, refresh DataTable after save
                table.ajax.reload(null, false);
            },
            error: function(xhr, textStatus, errorThrown) {
                console.error('Error saving data:', errorThrown);
            }
        });
    }
});
*/

/*$(document).ready(function() {
	// alert("is call");
    var table = $("#table_crop").DataTable({
        destroy: true,
        lengthMenu: [
            [10, 20, 30, -1],
            [10, 20, 30, 'All']
        ],
        ajax: {
            url: "./getmastersimplementationlist", // Replace with your data source URL
            type: "GET",
            dataSrc: ""
        },
        columns: [
            { data: "id" },
            { data: "implementname", className: "editable" },
            { data: "status", className: "editable" },
            {
                // Edit button column
                render: function(data, type, row) {
                   
                }
            }
        ],
        columnDefs: [
            {
                targets: [0],
                visible: false // Hide ID column
            }
        ],
        dom: 'Blfrtip',
        paging: true,
        searching: true,
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-success rounded-0',
                text: '<i class="far fa-copy"></i> Copy',
                footer: true
            }
            // Add other buttons as needed
        ]
    });

});*/

   }); 
   
   
   
   function conPerformaceEdit(id,impname) {
//  alert("ID: " + id);
  // alert("Impname: " + impname);

    // Set the value of the text box
    $('#implementationtype').val(impname); // Assuming your text box ID is 'impnameTextBox'

    // Update form action with id parameter
    $('#masterimplementationtype').attr('action', './updateData?id=' + id + '&impname=' +impname);

    // Set id value (if necessary)
    $('#id').val(id);

    // Set Thymeleaf object attribute if needed
    $('#masterimplementationtype').attr('th:object', '${masterimplementation}');

    // Attach an event listener to the submit button or a specific button
    $('#editButton').click(function(e) {
        e.preventDefault(); // Prevent the default form submission

        // Get the edited impname from the text box
        var editedImpname = $('#implementationtype').val();

        // Now you can use editedImpname for further processing or logging
        console.log("Edited Impname: " + editedImpname);

        // Update the impname parameter in the form action (if needed)
        $('#masterimplementationtype').attr('action', './updateData?id=' + id + '&impname=' + encodeURIComponent(editedImpname));

        // Submit the form
        $('#masterimplementationtype').submit();
    });

 }
 

 
   
 
   
   
    function conPerfomanceDelete(id) {
	//	alert(id);

	 //        $('#deleteVisitModal').modal();
           
      //      $('#delVisitRef').on('click', function(event){
					event.preventDefault();
           
			            $('#masterimplementationtype').attr('action', './deactivateData?id=' + id);
			            
			             $('#id').val(id);
			            
			            $('#masterimplementationtype').attr('th:object', '${masterimplementation}');
			           
			            
			             $('#masterimplementationtype').submit();
			             
			 //      });
            
           
 }
 
   
   
   
 /*   function conImpleEdit(id,impname) {
  alert("ID: " + id);
    alert("Impname: " + impname);

//    alert("name: " + name);

    // Set the value of the text box
    $('#implementationtype').val(impname); // Assuming your text box ID is 'impnameTextBox'

    // Update form action with id parameter
    $('#masterimplementation').attr('action', './updateData?id=' + id + '&impname=' +impname);

    // Set id value (if necessary)
    $('#id').val(id);

    // Set Thymeleaf object attribute if needed
    $('#masterimplementation').attr('th:object', '${masterimple}');

    // Attach an event listener to the submit button or a specific button
    $('#editButton').click(function(e) {
        e.preventDefault(); // Prevent the default form submission

        // Get the edited impname from the text box
        var editedImpname = $('#implementationtype').val();

        // Now you can use editedImpname for further processing or logging
        console.log("Edited Impname: " + editedImpname);

        // Update the impname parameter in the form action (if needed)
        $('#masterimplementation').attr('action', './updateData?id=' + id + '&impname=' + encodeURIComponent(editedImpname));

        // Submit the form
        $('#masterimplementation').submit();
    });

 }
 
*/
 
   
  function conImpleEdit(id) {
	      
            $('#masterimplementation').attr('action', './update?id=' + id);
           
             $('#id').val(id);
             
            $('#masterimplementation').attr('th:object', '${farmperfomance}');
           

             $('#masterimplementation').submit();
            
           
 }
   
   
    function conImpleDelete(id) {

	 //        $('#deleteVisitModal').modal();
           
      //      $('#delVisitRef').on('click', function(event){
					event.preventDefault();
           
			            $('#masterimplementation').attr('action', './deactiveByImpl?id=' + id);
			            
			             $('#id').val(id);
			            
			            $('#masterimplementation').attr('th:object', '${masterimple}');
			           
			            
			             $('#masterimplementation').submit();
			             
			 //      });
            
           
 }
 
   
   
   
   
   
   
   function conmanufatureEdit(id) {
	      
            $('#mastermanufatures').attr('action', './updateByManu?id=' + id);
           
             $('#id').val(id);
             
            $('#mastermanufatures').attr('th:object', '${masterManufacturers}');
           

             $('#mastermanufatures').submit();
            
           
 }
   
   
    function conmanufatureDelete(id) {

	 //        $('#deleteVisitModal').modal();
           
      //      $('#delVisitRef').on('click', function(event){
					event.preventDefault();
           
			            $('#mastermanufatures').attr('action', './deactiveByManu?id=' + id);
			            
			             $('#id').val(id);
			            
			            $('#mastermanufatures').attr('th:object', '${masterManufacturers}');
			           
			            
			             $('#mastermanufatures').submit();
			             
			 //      });
            
           
 }
   
   
    function conFarmGroupEdit(id) {
	      
            $('#masterfarmgroup').attr('action', './updatefarmgroup?id=' + id);
           
             $('#id').val(id);
             
            $('#masterfarmgroup').attr('th:object', '${masterfarmgroup}');
           

             $('#masterfarmgroup').submit();
            
           
 }
   
   
    function conFarmGroupDelete(id) {

	 //        $('#deleteVisitModal').modal();
           
      //      $('#delVisitRef').on('click', function(event){
					event.preventDefault();
           
			            $('#masterfarmgroup').attr('action', './deleteframgroup?id=' + id);
			            
			             $('#id').val(id);
			            
			            $('#masterfarmgroup').attr('th:object', '${masterfarmgroup}');
			           
			            
			             $('#masterfarmgroup').submit();
			             
			 //      });
            
           
 }
 
   
   
   
   
   
   
   
function   validateSumit() {
    console.log("Document ready, starting validation...");
    
 
    
    

    $('#mastermanufatures').submit(function(event) {
        console.log("Form submission intercepted.");

        // Prevent form submission
        event.preventDefault();

        // Clear previous error messages
        $('.error-message').text('');

        // Validate form fields
        var isValid = true;

        // Validate name field (mname)
        var name = $('#manuname').val();
        console.log("Name value:", name);

        if (!name || !name.trim()) {
            alert("Manufacture Type is required.");
            isValid = false;
        } else if (!isValidName(name)) {
            alert('Manufacture Type should be alphanumeric only.');
          $('#manuname').val(''); // Clear the field value

            isValid = false;
        }

        // If all validations pass, submit the form
        if (isValid) {
            console.log("Form is valid, submitting...");
            this.submit();
        }
    });

    // Function to validate alphanumeric name format
    function isValidName(name) {
        // Regex pattern for alphanumeric characters
var namePattern = /^[a-zA-Z0-9 ]*$/;
        return namePattern.test(name);
    }

   }
   
  document.addEventListener('DOMContentLoaded', function () {
            // Add event listener to the main checkbox
            document.getElementById('main').addEventListener('change', function () {
                // Show an alert when the main checkbox is changed
                // Get the state of the main checkbox
                var isChecked = document.getElementById('main').checked;

                // Get all checkboxes with the class 'sub-checkbox'
                var checkboxes = document.querySelectorAll('.sub-checkbox');

                // Loop through each checkbox and update its checked state
                checkboxes.forEach(function (checkbox) {
                    checkbox.checked = isChecked;

                    // Call the updateInputState function (if defined)
                    updateInputState(checkbox);
                });
            });

            // Example definition for the updateInputState function
            function updateInputState(checkbox) {
                console.log('Updated state for:', checkbox);
                // Implement your state update logic here
            }
        });





   /* function validation() {
        var formDataArray = [];
        
        // Iterate over each row in the table body
        document.querySelectorAll('tbody tr').forEach(function (row) {
            var checkbox = row.querySelector('.sub-checkbox');
            if (checkbox && checkbox.checked) {
                formDataArray.push({
                    appno: row.querySelector('[name="appno"]').value,
                    farmername: row.querySelector('[name="farmername"]').value,
                    dropwovalue: document.getElementById('farmer-dropdown').value
                });
            }
        });

        console.log('Before fetch');

        // Perform the AJAX request
        $.ajax({
            url: './farmergroupingselect',
            type: 'POST', // Use POST to send data
            contentType: 'application/json', // Correct content type for JSON
            data: JSON.stringify(formDataArray),
            success: function (data) {
                console.log('Success:', data);
                // Handle success response here
            },
            error: function (xhr, status, error) {
                console.error('Error during fetch operation:', error);
                // Optionally, you could handle different error statuses here
            }
        });

        console.log('After fetch');
    }
		*/

  /* $(document).ready(function() {
    $('#mappinggroupforfarmer').on('submit', function(event) {
        event.preventDefault(); // Prevent default form submission

        var selectedGroupType = $('#grouptype').val();
        var formDataArray = [];
        var isAnyCheckboxSelected = false;
        var isDropwovalueValid = true; // Flag to check if all dropdown values are valid
        var hValueCount = 0; // Counter for 'H' values

        // Check if no group type was selected
        if (!selectedGroupType) {
            alert("Please select a group type before submitting.");
            return; // Exit the function without making the AJAX request
        }

        // Iterate over each row in the table body
        $('tbody tr').each(function () {
            var checkbox = $(this).find('.sub-checkbox');
            var dropwovalue = $(this).find('[name="farmer_dropdown"]').val(); // Get dropdown value

              if (dropwovalue === 'H') {
                hValueCount++;
            }


            // Check if checkbox is checked
            if (checkbox.length > 0 && checkbox.is(':checked')) {
                // Check if dropdown value is empty
                if (dropwovalue === '') {
                    isDropwovalueValid = false; // Set flag to false if dropdown value is empty
                } else {
                    isAnyCheckboxSelected = true; // Set flag to true if at least one checkbox is selected
                    formDataArray.push({
                        appl_no: $(this).find('[name="appno"]').val(),
                        farmer_name: $(this).find('[name="farmername"]').val(),
                        mcode: $(this).find('[name="mandal"]').val(),
                        vcode: $(this).find('[name="village"]').val(),
                        dropwovalue: dropwovalue // Use the variable here
                    });
                }
            }
        });

if (hValueCount > 1) {
            alert("Only one selection with 'Head' is allowed.");
            return; // Exit the function without making the AJAX request
        }


 // Check if any dropdown value was invalid
        if (!isDropwovalueValid) {
            alert("Please select a farmer type for all checked rows.");
            return; // Exit the function without making the AJAX request
        }

        // Check if no checkboxes were selected
        if (!isAnyCheckboxSelected) {
            alert("Please select at least one checkbox before submitting.");
            return; // Exit the function without making the AJAX request
        }

       

        // Create the data object to be sent in the AJAX request
        var requestData = {
            groupType: selectedGroupType,
            formData: formDataArray
        };

        // Convert requestData to a JSON string for debugging
        var requestDataString = JSON.stringify(requestData, null, 2);

        // Alert the requestData as a string for debugging
        alert("Request Data:\n" + requestDataString);
        console.log('Before ajax');

        // Perform the AJAX request using jQuery
        $.ajax({
            url: '/farmergroupingselect', // Ensure this matches your controller mapping
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData), // Send the combined data object
            success: function (data) {
                console.log('Success:', data);
                // Optionally, you might want to redirect or update the page based on the response
                  window.location.href = '/mappinggroup'; // Replace with your actual success URL

            },
            error: function (xhr, status, error) {
                console.error('Error during ajax operation:', error);
                alert("An error occurred while submitting the form. Please try again.");
            }
        });

        console.log('After ajax');
    });
});*/
$(document).ready(function() {
    // Event handler for checkbox change
    $('#framgroupdetails').on('change', '.sub-checkbox', function() {
        var checkbox = $(this);
        var dropdown = checkbox.closest('tr').find('select[name^="farmer_dropdown"]');
        
        // Enable or disable dropdown based on checkbox state
        if (checkbox.is(':checked')) {
            dropdown.prop('disabled', false);
        } else {
            dropdown.prop('disabled', true);
            dropdown.val(''); // Optionally reset the dropdown value
        }
    });

    // Existing form submit event handler
    $('#mappinggroupforfarmer').on('submit', function(event) {
        event.preventDefault(); // Prevent default form submission
        
        var villageid = $('#villageid').val();
        var formDataArray = [];
        var isAnyCheckboxSelected = false;
        var isDropwovalueValid = true;
        var hValueCount = 0;
        var cValueCount = 0;
        var mValueCount = 0;

        var containsH = false; 
        var containsC = false;
        var containsM = false;

        if (!villageid) {
            alert("Please select a village before submitting.");
            return;
        }

        var selectedGroupType = $('#grouptype').val(); // Group type

        // Check if no group type was selected
        if (selectedGroupType == 0) {
            alert("Please select a group type before submitting.");
            return;
        }

        var selectedcropyear = $('#cropyear').val(); // Crop year

        // Check if no crop year was selected
        if (selectedcropyear == 0) {
            alert("Please select a crop year before submitting.");
            return;
        }

        // Iterate over each row in the table body
        $('#framgroupdetails tbody tr').each(function() {
            var checkbox = $(this).find('.sub-checkbox');
            var dropdown = $(this).find('select[name^="farmer_dropdown"]'); // Select by name starting with 'farmer_dropdown'
            var dropwovalue = dropdown.val(); // Get dropdown value

            if (dropwovalue === 'H') {
                containsH = true; // Set flag if 'H' is found
                hValueCount++;
            }
            if (dropwovalue === 'C') {
                containsC = true;
                cValueCount++;
            }
            if (dropwovalue === 'M') {
                containsM = true;
                mValueCount++;
            }

            if (checkbox.is(':checked')) {
                if (dropwovalue === '') {
                    isDropwovalueValid = false;
                } else {
                    isAnyCheckboxSelected = true;
                    formDataArray.push({
                        appl_no: $(this).find('.appno').text().trim(),
                        farmer_name: $(this).find('.farmername').text().trim(),
                        mcode: $(this).find('.mandal').text().trim(),
                        vcode: $(this).find('.village').text().trim(),
                        dropwovalue: dropwovalue
                    });
                }
            }
        });

       

        if (!containsH) {
            alert("At least one 'Convenor' selection is required.");
            return;
        }

        if (hValueCount > 1) {
            alert("Only one selection with 'Convenor' is allowed.");
            return;
        }

        if (!cValueCount) {
            alert("At least one 'Co-convenor' selection is required.");
            return;
        }

        if (cValueCount > 1) {
            alert("Only one selection with 'Co-convenor' is allowed.");
            return;
        }

        if (!mValueCount) {
            alert("At least 3 'Member' selections are required.");
            return;
        }

        if (mValueCount != 3) {
            alert("Only 3 selections with 'Member' are allowed.");
            return;
        }
 if (!isAnyCheckboxSelected) {
            alert("Please select at least one checkbox before submitting.");
            return;
        }
        if (!isDropwovalueValid) {
            alert("Please select a farmer type for all checked rows.");
            return;
        }

        var requestData = {
            groupType: selectedGroupType,
            formData: formDataArray,
            villageid: villageid,
            selectedcropyear: selectedcropyear
        };

        // Convert requestData to a JSON string for debugging
        var requestDataString = JSON.stringify(requestData, null, 2);

        // Alert the requestData as a string for debugging
        console.log('Before ajax');

        $.ajax({
            url: '/farmergroupingselect',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(data) {
                console.log('Success:', data);
                window.location.href = '/mappinggroup'; // Replace with your actual success URL
            },
            error: function(xhr, status, error) {
                console.error('Error during ajax operation:', error);
                alert("An error occurred while submitting the form. Please try again.");
            }
        });

        console.log('After ajax');
    });
});


 function validateSubmit(event) {
            var village = document.getElementById("village").value;
            var cropyear = document.getElementById("cropyear").value;
            var groupname = document.getElementById("groupname").value;
            
            // Check if any of the fields are empty
            if (village === "") {
                alert("Please select a village.");
                        event.preventDefault(); // Prevent form submission

                return false; // Prevent form submission
            }
            
            if (cropyear.trim() === "") {
                alert("Please enter a crop year.");
                        event.preventDefault(); // Prevent form submission

                return false; // Prevent form submission
            }
            
            if (groupname.trim() === "") {
                alert("Please enter a farm group name.");
                        event.preventDefault(); // Prevent form submission

                return false; // Prevent form submission
            }
            
            return true; // Allow form submission if all fields are valid
        }
           

   