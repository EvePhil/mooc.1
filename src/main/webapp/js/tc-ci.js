/**
 * Created by lynn on 2017/7/1.
 */

$(function () {

    var url = {
        getAbsent: "/mooc/getAbsent"
    };

    //TODO

    function loadAbsent() {
        $.get(url.getAbsent, function (json) {
            var tbody = $('table').find('tbody');
            //var jsonParsed = json;
            var jsonParsed = eval('(' + json + ')');
            for (var i = 0; i < jsonParsed.length; i++) {
                var tr = $("<tr></tr>");
                var stuID = jsonParsed[i].stuID;
                var stuName = jsonParsed[i].stuName;
                var stuTeam = jsonParsed[i].stuTeam;
                var record=jsonParsed[i].date;

                var IDtd = $("<td>" + stuID + "</td>");
                IDtd.appendTo(tr);
                var nametd = $("<td>" + stuName + "</td>");
                nametd.appendTo(tr);
                var teamtd = $("<td>" + stuTeam + "</td>");
                teamtd.appendTo(tr);
                var recordtd = $("<td class='red-text'>" + record + "</td>");
                recordtd.appendTo(tr);

                tr.appendTo(tbody);
            }


        });
    }
    loadAbsent();

})
