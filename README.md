# ¿Como construir la aplicacion?

Primero hay que construir la aplicacion usando el siguiente comando

Si estas en Linux o Mac usa el siguiente comando
```
./mvnw clean package
```

Si estas en Windows usa.

```
mvnw.cmd clean package
```

Despues construye la imagen de Docker usando el siguiente comando.

```
docker build -t plafip-api .
```