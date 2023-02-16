package com.xcale.consulting.springboot.repository;

import com.xcale.consulting.springboot.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends CrudRepository<Usuario,Integer>{

    @Query(value="SELECT u.id, u.nombre_usuario, g.nombre_grupo, m.texto, u.telefono, u.created,u.modified,u.last_login " +
            " FROM chat.usuario u join " +
            "chat.usuario_grupo ug on u.id = ug.id_usuario " +
            "join  chat.grupo g on ug.id_grupo = g.id " +
            "join  chat.mensaje m on m.id_usuario = u.id",nativeQuery = true)
    public List<Usuario> getNotificaciones();


}
