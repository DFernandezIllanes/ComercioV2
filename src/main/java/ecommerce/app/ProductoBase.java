package ecommerce.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productoBase")
@AllArgsConstructor
public class ProductoBase {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    @Getter @Setter
    private String nombre;

    @Column(name = "precio")
    @Getter @Setter
    private Double precio;

    @Column(name = "descripcion", columnDefinition = "VARCHAR(50)")
    @Getter @Setter
    private String descripcion;

    @Column(name = "tiempDeFabricacion")
    @Getter @Setter
    private String tiempoDeFabricacion;

    @Transient
    @Getter @Setter
    private Gestor gestor;

    public ProductoBase(){

    }

    public ProductoBase(String nombre){
        this.nombre = nombre;
    }

    public ProductoBase(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoBase(String nombre, Double precio, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }




}
