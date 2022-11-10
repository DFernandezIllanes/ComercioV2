package ecommerce.app;

import antlr.collections.impl.LList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gestor")
@AllArgsConstructor
public class Gestor {

    @Getter
    @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Setter
    @Getter
    @Column(name = "apellido", columnDefinition = "VARCHAR(50)")
    private String apellido;

    @Transient
    private List<String> productosBase;

    public Gestor(){
        this.productosBase = new ArrayList<>();
    }

    public Gestor(String nombre){
        this.nombre = nombre;
        this.productosBase = new ArrayList<>();
    }

    public Gestor(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.productosBase = new ArrayList<>();
    }

    public List<String> getProductosBase() {
        return new ArrayList<String>(this.productosBase);
    }

    public void setProductosBase(List<String> productosBase) {
        this.productosBase = productosBase;
    }
}
