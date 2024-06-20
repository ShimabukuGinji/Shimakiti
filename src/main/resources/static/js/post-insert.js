'use strict';
var marker;
let num = 0;
function initMapInsert() {
  // マップの初期化
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 9,
    center: {lat: 26.509961, lng: 127.962765}
  });

  // クリックイベントを追加
  map.addListener('click', function(e) {
    getClickLatLng(e.latLng, map);
  });
}

function getClickLatLng(lat_lng, map) {
  // 座標を表示
  document.getElementById('lat').value = lat_lng.lat().toFixed(6);
  document.getElementById('lng').value = lat_lng.lng().toFixed(6);

  // 座標から住所表示
  const url = 'https://maps.google.com/maps/api/geocode/json?key=AIzaSyBwxPEJAiFmyOh3KMR4NzYmvbDuU0YwwQ8&latlng=' + lat_lng.lat() + ',' + lat_lng.lng() + '&sensor=false';
  fetch(url)
    .then(res => {
      console.log('start')
      if(res.status === 400) {
        console.log('400')
      } else {
        res.json()
        .then(data => {
          console.log(data)
          console.log(data.results[0].formatted_address)
          let addressData = data.results[0].formatted_address;
          if (/^(([0-9A-Z\d]{4})\+([0-9A-Z\d]{2}))/.test(addressData)) {
            addressData = data.results[1].formatted_address;
          }
          let noPostCordAddress = addressData.replace(/〒(\d{3})-(\d{4})\s/,"");
          let noCordAddress = noPostCordAddress.replace(/([0-9A-Z\d]{4})\+([0-9A-Z\d]{2})/,"");
          let noNipponAddress = noCordAddress.replace("日本、","");
          let address = noNipponAddress.replace(/\s(.*)/,"");
          document.getElementById('address').value = address;
          addressData = data.results[data.results.length-3].formatted_address;
          if (addressData.includes('国頭郡') || addressData.includes('島尻郡') || addressData.includes('中頭郡')) {
            addressData = data.results[data.results.length-4].formatted_address;
          }
          address = addressData.replace("日本、沖縄県","");
          address = address.replace("国頭郡","");
          address = address.replace("島尻郡","");
          address = address.replace("中頭郡","");
          fetch(`/find-by-id?addressName=${address}`)
          .then(res => {
            res.json()
            .then(data => {
            document.getElementById('city').value = data.id;
            })
          })
        })
      }
    });

   if(marker !== undefined) {
    marker.setMap(null);
   }


  // マーカーを設置
  marker = new google.maps.Marker({
    position: lat_lng,
    map: map
  });

  // 座標の中心をずらす
  // http://syncer.jp/google-maps-javascript-api-matome/map/method/panTo/
  map.panTo(lat_lng);
}