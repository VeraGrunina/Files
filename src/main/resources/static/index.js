
function addDirectoryOnClick() {
   let input_value = $('#myInput').val();

   let ajaxData = {
    name: input_value
   };

   console.log('sending AJAX REQUEst');

   console.log(ajaxData);

   $.ajax({
       url : "http://localhost:8080/directory/",
       type : 'POST',
       dataType : 'json',
       data : ajaxData,
       success : function(data1) {
           console.log(data1);
           appendTableBody(data1)
       },
       error: function(data1){
                   console.log(data1);
       }
       });
}

$(function(){
    $.ajax({
    url : "http://localhost:8080/directory/firstLevel/all",
    type : 'GET',
    dataType : 'json',
    data : {},
    success : function(data1) {
        console.log(data1);
     createTableBody(data1)
    },
    error: function(data1){
                console.log(data1);
    }
    });
});

function createTableBody(data1) {

    var t = $('#myDirectoryTbody');

  $.each(data1, function(k,row) {
        var row_html = '<tr>' +
        '<td>' + row.localDate + '</td>' +
        '<td>' + row.name + '</td>' +
            '<td>' + row.countDirectory + '</td>' +
            '<td>' + row.countFiles + '</td>' +
            '<td>' + row.sumSizeFiles + '</td>' +
            '<td>' + '<button id='+row.id+'>' + 'Files' +'</button>' + '</td>' +
        '</tr>';

        t.append(row_html);

      document.getElementById(row.id).addEventListener('click', function () {
        $( "#dialog" ).dialog( "open" );

       $.ajax({
           url : "http://localhost:8080/directory/" + row.id + "/innerFiles",
           type : 'GET',
           dataType : 'json',
           data : {directoryId: row.id},
           success : function(data1) {
               console.log(data1);
            createInnerTableBody(data1)
           },
           error: function(data1){
                       console.log(data1);
           }
           });
      });

    });

}


function createInnerTableBody(data2) {

    var t = $('#innerTableBody');

    $("#innerTableBody tr").detach();

  $.each(data2, function(k,row) {
        var row_html = '<tr>' +
         '<td>' + row.name + '</td>' +
         '<td>' + row.size + '</td>' +
         '</tr>';

        t.append(row_html);
//        t.html(row_html);
  });
}

function appendTableBody(row) {
    var t = $('#myDirectoryTbody');

    var row_html = '<tr>' +
            '<td>' + row.localDate + '</td>' +
            '<td>' + row.name + '</td>' +
                '<td>' + row.countDirectory + '</td>' +
                '<td>' + row.countFiles + '</td>' +
                '<td>' + row.sumSizeFiles + '</td>' +
                '<td>' + '<button id='+row.id+'>' + 'Files' +'</button>' + '</td>' +
            '</tr>';

      t.append(row_html);
}