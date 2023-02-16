package com.xcale.consulting.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_grupo")
    private String nombreGrupo;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToMany(mappedBy = "grupos")
    private List<Usuario> usuarios;

    @OneToOne(mappedBy = "grupo")
    private Mensaje mensaje;

}
