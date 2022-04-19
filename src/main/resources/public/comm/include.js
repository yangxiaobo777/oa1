$(function () {
    $.get("header.html",function (data) {
        $("#header").html(data)
    });
    $.get("body.html",function (data) {
        $("#body").html(data)
    });
    $.get("foot.html",function (data) {
        $("#foot").html(data)
    });
});