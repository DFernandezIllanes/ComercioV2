package ecommerce.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "productosbase")
public interface RepoProductoBase extends JpaRepository<ProductoBase, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(ProductoBase productoBase);

    ProductoBase findByNombre(String nombre);
}
