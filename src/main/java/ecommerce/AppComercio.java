package ecommerce;

import ecommerce.app.Gestor;
import ecommerce.app.ProductoBase;
import ecommerce.app.RepoGestor;
import ecommerce.app.RepoProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AppComercio {

    @Autowired
    RepositoryRestConfiguration config;

    public static void main(String[] args) {
        SpringApplication.run(AppComercio.class, args);
    }

    @Bean
    public CommandLineRunner init(RepoGestor repoGestor, RepoProductoBase repoProductoBase){

        config.exposeIdsFor(Gestor.class, ProductoBase.class);

        return (cosas) -> {

            repoGestor.save(new Gestor("Alejandro", "Fantino"));
            repoGestor.save(new Gestor("Sergio", "Figluolo"));

            repoProductoBase.save(new ProductoBase("remera"));
            repoProductoBase.save(new ProductoBase("pantalon"));
            repoProductoBase.save(new ProductoBase("pantalon", 320.5));
        };
    }
}


/*
@SpringBootApplication
public class AppCorrelativas {

    @Autowired
    RepositoryRestConfiguration config; //Nos permite acceder a la configuracion de Spring, para modificarlo

    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner init(RepoMateriaJPA repo, RepoAlumnoJPA repoAlumno){

        config.exposeIdsFor(Materia.class); //Le indicamos a Spring que muestre el id de la clase Materia

        return (cosas) -> {

            repo.save(new Materia("SO", 2));
            repo.save(new Materia("DDS", 3));

            Materia algo = new Materia("Algo", 1);
            repo.save(algo);

            repo.save(new Materia("Analisis", 2));
            repo.save(new Materia("Sintaxis", 3));

            Alumno pepe = new Alumno("pepe", "Gomez");
            pepe.getMateriasAprobadas().add(algo);

            repoAlumno.save(pepe);
            repoAlumno.save(new Alumno("juan", "Benitez"));
            repoAlumno.save(new Alumno("jorge", "Sosa"));
        };
    }
}*/
