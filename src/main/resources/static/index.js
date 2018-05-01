
function addDirectoryOnClick() {
   let input_value = $('#myInput').val();
   let input_button = $('#myBestButton').

   $.ajax({
       url : "http://localhost:8080/directory",
       type : 'POST',
       dataType : 'json',
       data : {directoryName: input_value},
       success : function(data1) {
           console.log(data1);
           appendTableBody([data1])
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

    let t = $('#myCoursesTbody');
    $.each(data1, function(k,row) {
        let row_html = '<tr>' +
        '<td>' + row.id + '</td>' +
        '<td>' + row.localDate + '</td>' +
        '<td>' + row.name + '</td>' +
        '</tr>';

        t.append(row_html);
    });
}