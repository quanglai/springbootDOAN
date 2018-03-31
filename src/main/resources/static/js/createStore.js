$(document).ready(function () {

    var diachi,gioithieu,phone,email,tencuahang;
    var form_data = new FormData();
    var nameImage;
    var map,infoWindow;
    var pos;
    var mapDev = document.getElementById('map')
    var myLatLng = {lat: 	-34.397, lng: 150.644	};

        $("#OK").click(function () {
            uploadFile();

            diachi = $("#diachi").val(),
            gioithieu = $("#gioithieu").val(),
            email = $("#email").val(),
            phone = $("#phone").val(),
            tencuahang = $("#tencuahang").val(),
            nameImage = $("#upload-file-input").val(),
            console.log("chua cat="+nameImage)
            var splitNameImage = nameImage.split("\\");
            var localNameImage = splitNameImage.length;
            var valueNamImage = splitNameImage[localNameImage-1];
            console.log("cat roi="+valueNamImage);
            console.log("gioi thieu ="+gioithieu);
            console.log("phone ="+phone);
            console.log("ten ="+tencuahang);
            console.log("lng=="+pos.lng);
            console.log("lat=="+pos.lat);

            var json = {

                icon : valueNamImage,
                diachi: "",
                gioithieu:gioithieu,
                phone :phone,
                email :email,
                tenCuaHang :tencuahang,
                toadoX : pos.lat,
                toadoY :pos.lng

            }


            $.ajax({
                type: "POST",
                contentType: "application/json",
                url:'/cuahang',
                data: JSON.stringify(json),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                cache: false,
                success: function () {
                    console.log("thanh cong")
                },
                error: function () {
                    console.log("ERRO")
                }
            })

            console.log(json)



        })

    $("#dinhvi").click(function () {
        initMap();
        function initMap() {
            map = new google.maps.Map(mapDev, {
                center: myLatLng,
                zoom: 18
            });


            infoWindow = new google.maps.InfoWindow;

            // Try HTML5 geolocation.
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {

                    pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    };

                    infoWindow.setPosition(pos);
                    map.setCenter(pos);
                    var marker = new google.maps.Marker({
                        position: pos,
                        map: map,
                        title: 'hello'
                    })
                }, function() {
                    handleLocationError(true, infoWindow, map.getCenter());
                });
            } else {
                // Browser doesn't support Geolocation
                handleLocationError(false, infoWindow, map.getCenter());
            }
        }
        function handleLocationError(browserHasGeolocation, infoWindow, pos) {
            infoWindow.setPosition(pos);
            infoWindow.setContent(browserHasGeolocation ?
                'Error: mang yeu qua.' :
                'Error: Your browser doesn\'t support geolocation.');
            infoWindow.open(map);
        }
    })

})



/**
 * Upload the file sending it via Ajax at the Spring Boot server.
 */

function uploadFile() {
    $.ajax({
        url: "/uploadFile",
        type: "POST",
        data: new FormData($("#upload-file-form")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            // Handle upload success
            $("#upload-file-message").text("File succesfully uploaded");
        },
        error: function () {
            // Handle upload error
            $("#upload-file-message").text(
                "File not uploaded (perhaps it's too much big)");
        }
    });
}



