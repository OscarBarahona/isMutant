# README
Deteccion de Mutantes

A continuacion se detalla la manera correcta de poder consumir el servicio para detectar si una persona es Humano o si es un Mutante.

## Criterios de Aceptacion

- Programa que cumpla con el método pedido para reclutar mutantes:

        boolean isMutant(String[] dna);//Ejemplo Java

- Sabrás si una persona es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

- Si la persona es mutante devolvera un HTTP 200-OK.

- Si la persoona no es Mutante devolvera 403-Forbidden 

- Anexar una base de datos, la cual guarde los ADN’s verificados con la API. Solo 1 registro por ADN

- Exponer un servicio extra "/stats" que devuelva un Json con las estadísticas de las verificaciones de ADN: 
    {"count_mutant_dna":40, "count_human_dna":100: "ratio":0.4} 

- Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1 millón de peticiones por segundo).

- Test-Automáticos, Code coverage > 80%. 

## Coverage > 80%
Se utilizo SonarQube con Docker para poder realizar el Coverage

![App Screenshot](https://raw.githubusercontent.com/OscarBarahona/isMutant/main/Coverage%202.png)

![App Screenshot](https://raw.githubusercontent.com/OscarBarahona/isMutant/main/Coverage.png)

## Documentation Swagger

[Documentation Swagger](https://ismutant-app-crs6e.ondigitalocean.app/swagger-ui/)

## Postman Collection

[Postman Collection](https://raw.githubusercontent.com/OscarBarahona/isMutant/main/Fichosa.postman_collection.json)

## API Reference
Se compartiran las collection de Postman. Dicha API se encuentra hosteada en un servidor Digital Ocean y se encuentra Dockerizada para su optimizacion, la api se encuentra utilizando una base de datos H2 para poder almacenar los registros de los ADN que se han estado verificando.

#### Verifica si es Humano o Mutante

```http
  POST https://ismutant-app-crs6e.ondigitalocean.app/mutant
```

| RequestBody|
| :-------- |
| {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] } |

| Response is Mutant| Response is Human|
| :-------- | :-------- |
|HTTP STATUS-200 |HTTP STATUS 403|


#### Devuelve un Json con las estadísticas de las verificaciones de ADN

```http
  GET https://ismutant-app-crs6e.ondigitalocean.app/mutant/stats
```

| Response example:|
| :-------- |
|{ "count_mutant_dna": 3, "count_human_dna": 6, "ratio": 0.33000001311302185 }|

## By
- Oscar Barahona


## Support

para soporte del repositorio el correo es oscar.barahona04@gmail.com

