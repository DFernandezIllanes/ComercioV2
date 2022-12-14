package ecommerce.app;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "gestores")
public interface RepoGestor extends JpaRepository<Gestor, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Gestor gestor);

    Gestor findByNombre(String nombre);

    Gestor findByApellido(String apellido);
}
