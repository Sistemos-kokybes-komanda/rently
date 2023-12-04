# rently
Karočia, kad paleisti duombazę įsirašot Podman'ą arba docker'į (man nuoširdžiai nerūpi ką).

tada rašot į console (toje dir kur ir projektas visas)

`docker build -t rently-db:latest .`

...buildinat image...

Kai subuildinot RAŠOT

`docker run -p 3306:3306 -d rently-db:latest`

vsio db važiuoja

labanaktis