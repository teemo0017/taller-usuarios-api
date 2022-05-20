package com.example.ejemplo.api.models;

import javax.persistence.*;



@Entity
@Table(name = "users")
public class models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    // fetch = FetchType.LAZY, optional = false

    // @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne()
    private perfilEntidad perfil;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public perfilEntidad getPerfil() {
        return perfil;
    }
    public void setPerfil(perfilEntidad perfil) {
        this.perfil = perfil;
    }

    

}
