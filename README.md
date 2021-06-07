# HelloWorldServlets

Esto proyecto es una prueba de concepto sencilla basada en el arquetipo maven **maven-archetype-webapp** (groupId: org.apache.maven.archetypes)
y pensado como aplicación sencilla para demotrar su despliege en Heroku.

## Cosas técnicas

### Crear proyecto

El proyecto se ha creado con maven usando el comando:

    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4

### Webapp Runner

La aplicación se desplegará en Heroku, para ello se usará el componente **Webapp Runner** que permite crear un JAR con un tomcat
(más información en la página [Heroku Dev Center](https://devcenter.heroku.com/articles/java-webapp-runner)).

En el fichero `pom.xml` hay que añadir:

```xml
<build>
    ...
    <plugins>
        ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals><goal>copy</goal></goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                                <groupId>com.heroku</groupId>
                                <artifactId>webapp-runner</artifactId>
                                <version>9.0.41.0</version>
                                <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Ejecutar la aplicación sólo necesita compilar el proyecto y ejecutar el JAR:

    mvn package
    java -jar target/dependency/webapp-runner.jar target/*.war

### Desplegar en Heroku

* URL Heroku: https://dashboard.heroku.com/apps    
* Nombre del repositorio: HelloWorldServlets
* Nombre pipeline: hello-world-servlets
* Nombre de la App: hello-world-servlets
* URL de acceso (publicación): https://hello-world-servlets.herokuapp.com/

### Addons Heroku

#### ClearDB MYSQL

Se ha creado una BD free con nomnre **heroku_35f9f44615d5051**, que crea la variable de entorno `CLEARDB_DATABASE_URL` con el valor:

    mysql://b855dd2babd9c5:1cd62413@eu-cdbr-west-01.cleardb.com/heroku_35f9f44615d5051?reconnect=true


## REFERENCIAS

Webapp Runner
https://devcenter.heroku.com/articles/java-webapp-runner
https://github.com/heroku/webapp-runner