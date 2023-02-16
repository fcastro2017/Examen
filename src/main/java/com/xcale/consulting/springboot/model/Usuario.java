package com.xcale.consulting.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;
    @Column(name = "modified")
    @UpdateTimestamp
    private LocalDateTime modified;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @JoinTable(
            name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_grupo", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Grupo> grupos;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Mensaje mensaje;

}
