$("#dinhvi").click(function () {
    init();
})

function init() {

    var map,infoWindow;
    var pos;
    var mapDev = document.getElementById('map')
    var myLatLng = {lat: -34.397, lng: 150.644};
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


}