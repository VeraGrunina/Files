
function addDirectoryOnClick() {
   let input_value = $('#myInput').val();
   let input_button = $('#myBestButton');

   $.ajax({
       url : "http://localhost:8080/directory/new",
       type : 'POST',
       dataType : 'json',
       data : {input_value},
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

let button_value = $('.btn').button();

function createTableBody(data1) {

    var t = $('#myCoursesTbody');

  $.each(data1, function(k,row) {
        var row_html = '<tr>' +
        '<td>' + row.id + '</td>' +
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

//        var tableIn = $('#innerTableBody');
//        var row_htmlInner = '<tr>' +
//            '<td>' + 'You' + '</td>' +
//            '<td>' + 'Welcome' + '</td>' +
//            '</tr>';

//        tableIn.append(row_htmlInner);
//          tableIn.html(row_htmlInner);
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
    var t = $('#myCoursesTbody');

    var row_html = '<tr>' +
            '<td>' + row.id + '</td>' +
            '<td>' + row.localDate + '</td>' +
            '<td>' + row.name + '</td>' +
                '<td>' + row.countDirectory + '</td>' +
                '<td>' + row.countFiles + '</td>' +
                '<td>' + row.sumSizeFiles + '</td>' +
                '<td>' + '<button id='+row.id+'>' + 'Files' +'</button>' + '</td>' +
            '</tr>';

      t.append(row_html);

}