package ecommerce.app;

import ecommerce.app.dtos.DTOProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RepositoryRestController
public class ProductosBaseControllerComplement {

    @Autowired
    RepoProductoBase repoProductoBase;

    @Autowired
    RepoGestor repoGestor;

    @PostMapping("productosbase/producto")
    public @ResponseBody ResponseEntity<Object> crearProductoBase(
            @RequestBody DTOProductoBase producto
            ){
        return ResponseEntity.ok(producto);
    }
}
