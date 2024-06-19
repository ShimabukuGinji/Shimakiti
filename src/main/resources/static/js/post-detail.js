'use strict';
let Lat = Number.parseFloat(document.getElementById('lat').innerText);
let Lng = Number.parseFloat(document.getElementById('lng').innerText);
console.log(Lat);
console.log(Lng);
function initMapDetail() {
  // マップの初期化
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 13,
    center: {lat: Lat, lng: Lng}
  });

  var marker = new google.maps.Marker({
    position: {lat: Lat, lng: Lng},
    map: map
  });
}


const pics_src = new Array(document.getElementById("picImg"),document.getElementById("subImg1"),document.getElementById("subImg2"),document.getElementById("subImg3"),document.getElementById("subImg4"));
var num = 0;

function slideshowNext(){
    const src = new Array(pics_src[0].src, pics_src[1].src, pics_src[2].src, pics_src[3].src, pics_src[4].src)
    document.getElementById("picImg").src=src[1];
    document.getElementById("subImg1").src=src[2];
    document.getElementById("subImg2").src=src[3];
    document.getElementById("subImg3").src=src[4];
    document.getElementById("subImg4").src=src[0];
}

function slideshowBack(){
    const src = new Array(pics_src[0].src, pics_src[1].src, pics_src[2].src, pics_src[3].src, pics_src[4].src)
    document.getElementById("picImg").src=src[4];
    document.getElementById("subImg1").src=src[0];
    document.getElementById("subImg2").src=src[1];
    document.getElementById("subImg3").src=src[2];
    document.getElementById("subImg4").src=src[3];
}