package ecommerce.app;

import ecommerce.app.dtos.DTOPosiblePersonalizacion;
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
    RepoPosiblePersonalizacion repoPosiblePersonalizacion;

    @PostMapping("/productosbase/{productoBaseId}/personalizaciones")
    public @ResponseBody ResponseEntity<Object> crearPosiblePersonalizacion(
            @PathVariable("productoBaseId") Long productoBaseId,
            @RequestBody DTOPosiblePersonalizacion personalizacion
            ){
        Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(productoBaseId);
        if(!productoBaseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
        } else {
            ProductoBase productoBase = productoBaseOptional.get();

            if(repoPosiblePersonalizacion.findByAreaDePersonalizacion(personalizacion.getAreaDePersonalizacion()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el área de personalización");
            } else {
                PosiblePersonalizacion posiblePersonalizacion = new PosiblePersonalizacion(personalizacion.getAreaDePersonalizacion(), personalizacion.getTipoDePersonalizacion(), productoBase);
                repoPosiblePersonalizacion.save(posiblePersonalizacion);
                return ResponseEntity.status(HttpStatus.OK).body("Posible personalización añadida");
            }
        }
    }


}
