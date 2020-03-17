# ZipCodesCodeChallenge
#PROYECTO: LEER CODIGO POSTAL EN BASE A UN ID CON SPRING BOOT, SPRING BATCH Y SPRING DATA

#DESCRIPCION
- El siguiente proyecto hace uso de distintas herramientas de spring framework que nos permitira
    cargar una lista de codigos postales de la CDMX y luego leer su contenido desde un REST API endpoint
    alojado en un servidor local

#DEPLOY GOOGLE CLOUD
- https://zipcodes-271317.appspot.com

#DOCUMENTACION 
- El proyecto contiene una documentacion del funcionamiento localizada en la raiz del proyecto

#HERRAMIENTAS NECESARIAS
- Spring Tools suite 4
- Cualquier version de Java para realizar el deploy use Java 11
- H2 console para manejo de una base de datos

#EJECUCION DE MANERA LOCAL
- Con el H2 console ejecutandose
- Clic derecho al proyecto (springboot-zip-code)
- run as -> spring boot app
- Luego de terminar de cargar por defecto se aloja en puerto 8080
- abrimos un navegador web ya sea google chrome, firefox o una herramienta para leer API como postman
- escribimos en el navegador lo siguiente: http://localhost:8080/zip-codes/25 y asi obtendremos el codigo postal
    con el id 25, podemos cambiar ese id por otro de nuestra preferencia, si estamos usando postman solo damos clic en 
    GET y escribimos la ruta como se mostro en el ejemplo anterior y damos enter y se nos desplegara un json con el 
    resultado
