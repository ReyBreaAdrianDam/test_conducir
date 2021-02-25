# Test de conducir
[![](https://static.oprah.com/2017/08/released-logo-header-310x120.png)](https://github.com/ReyBreaAdrianDam/test_conducir/releases/tag/1.0)

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

Este test esta realizado en java, para la plataforma windows

## Caracteristicas
- Permite al usuario realizar tests a traves de ficheros *.tdc o online
- Pueges guardar el resultado de los tests para verlos mas adelante
- Puedes cambiarle el tema a oscuro

## Diseño
- Hay una pantalla de inicio, que permite al usuario iniciar un test, online o no, ver resultados de tests anteriores o salir
- La pantalla test incluye la imagen asociada a la pregunta, la pregunta y las diferentes respuestas a estas en radio buttons
- La pantalla para visualizar los resultados, también permite abrir test anteriores *.fdt
- Dispone de modo oscuro, como de modo claro



>  ****NOTA****
> Este ejercicio dispone de un easter egg para
> activar el modo dios dale a salir 4 veces y a no,
> entonces a la 5ª vez que le des a salir, dale a si,
> se activara el modo dios

## Lenguaje usado y herramientas

Se ha usado java para este proyecto, ya que es lo que se da en el ciclo

- [Java](https://www.oracle.com/es/java/technologies/javase-jdk11-downloads.html) - Lenguaje de programación usado
- [FlatLaf](https://www.formdev.com/flatlaf/) - Libreria de Looks and Feels usados
- [NetBeans IDE](https://netbeans.org/) - IDE usado para este proyecto
- [SQLite](https://www.sqlite.org/index.html) - Bases SQLite y Drivers
- [MySQL](https://www.mysql.com/) - Base MySQL y drivers

## Clases
- **ConexionBDPreguntas** - Clase que recupera los datos de las diferentes bases de datos
- **PantallaPrincipal** - Clase que invoca la pantalla principal del programa
- **PantallaResultados** - Clase que abre los resultados de los tests (actual o no)
- **PantallaTest** - Clase que tras recibir los datos de ConexionBDPreguntas genera un test
- **PreguntaRespondida** - es un JPanel, que se implementa en PantallaResultados
- **objetos**
    - Pregunta - Clase que genera objetos Pregunta, cada pregunta tiene un enlace de imagen, el texto de la pregunta y cuatro posibles respuestas. Tambien tiene un int que se inicia a -1, cambia cuando una respuesta ha sido marcada
    - Respuesta - Clase que genera objetos Respuesta, cada respuesta tiene un texto de respuesta y un booleano que verifica si es verdadera


### Constructor de la clase Pregunta.

```java
public Pregunta(String enlaceImg, String pregunta, Respuesta r1, Respuesta r2, Respuesta r3, Respuesta r4){
        respuestaMarcada = -1;
        this.enlaceImg = enlaceImg;
        this.pregunta = pregunta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }
```

### Constructor de la clase Respuesta.

```java
public Respuesta(String respuesta, boolean correcta){
        this.respuesta = respuesta;
        this.correcta = correcta;
    }
```

## Como funciona
    
El  usuario inicia el programa, y procedera a realizar un test, ver anteriores tests

**TEST**

Modalidades:
- [Online](https://remotemysql.com/): Carga los datos de una base de datos online 
- Fichero: Carga preguntas de un fichero con extension *.tdc

Puede cambiarse el tema del test

El usuario al finalizar vera sus respuestas y si esta suspenso o aprobado
