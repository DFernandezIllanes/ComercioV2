package ecommerce.app.dtos;

import ecommerce.app.ProductoBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.config.Projection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOProductoBase {
    String nombre;
    String descripcion;
    //Long gestorId;
}
