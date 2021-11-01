# ¿Como construir la aplicacion de forma local?

Primero hay que construir la aplicacion usando el siguiente comando

Si estas en Linux o Mac usa el siguiente comando
```
./mvnw clean package
```

Si estas en Windows usa.

```
mvnw.cmd clean package
```
Se tiene que intalar Docker y docker compose para deplegar la api y se creee la DB

Despues construye la imagen de Docker usando el siguiente comando.

```
docker-compose build
```
Seguidamente se debe ejecutar 

```
docker-compose up
```

# ¿Como deplegar el front de manera local?

Se debe descargar el repositorio de los enlace:

Front
```
https://gitlab.com/des.software.g3/plafip.git
```
Backend - API

```
https://github.com/ronaldleal/plafip-api.git
```

En el front es necesario correr el comando en la terminal 

```
npm install
```
seguidamente instalar desplegar el front con el comando 

```
npm run start
```

