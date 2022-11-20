package ecommerce.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "gestorId", referencedColumnName = "id")
    @Getter @Setter
    private Gestor gestor;

    @OneToMany(mappedBy = "productoBase")
    private List<PosiblePersonalizacion> personalizaciones = new ArrayList<>();

    public ProductoBase(){
        //this.personalizaciones = new ArrayList<>();
    }

    public ProductoBase(String nombre){
        this.nombre = nombre;
        //this.personalizaciones = new ArrayList<>();
    }

    public ProductoBase(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
        //this.personalizaciones = new ArrayList<>();
    }

    public ProductoBase(String nombre, String descripcion, Gestor gestor){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gestor = gestor;
        //this.personalizaciones = new ArrayList<>();
    }

    public ProductoBase(String nombre, Double precio, Gestor gestor){
        this.nombre = nombre;
        this.precio = precio;
        this.gestor = gestor;
        //this.personalizaciones = new ArrayList<>();
    }

    public ProductoBase(String nombre, Gestor gestor){
        this.nombre = nombre;
        this.gestor = gestor;
        //this.personalizaciones = new ArrayList<>();
    }

    public List<PosiblePersonalizacion> getPosiblesPersonalizaciones() {
        return new ArrayList<>(this.personalizaciones);
    }

    public void setPosiblesPersonalizaciones(List<PosiblePersonalizacion> personalizaciones) {
        this.personalizaciones = personalizaciones;
    }
}
