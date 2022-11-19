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

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController
public class GestoresControllerComplement {

    @Autowired
    RepoGestor repoGestor;

    @Autowired
    RepoProductoBase repoProductoBase;

    @PostMapping("/gestores/{gestorId}/productos")
    public @ResponseBody ResponseEntity<Object> crearProductoBase(
            @PathVariable("gestorId") Long gestorId,
            @RequestBody DTOProductoBase producto
    ){
        //Long gestorId = producto.getGestorId();
        Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
        if(!gestorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el gestor");
        } else {
            Gestor gestor = gestorOptional.get();

            if(repoProductoBase.findByNombre(producto.getNombre()) != null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un producto con ese nombre");
            } else {
                ProductoBase productoBase = new ProductoBase(producto.getNombre(), producto.getDescripcion(), gestor);
                repoProductoBase.save(productoBase);
                return ResponseEntity.status(HttpStatus.OK).body("Producto Base creado");
            }
        }
    }


}
