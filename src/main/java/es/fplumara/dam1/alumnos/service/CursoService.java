package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.TipoOrden;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    Optional<Curso> findById(Integer idCurso);
    List<Curso> getCursos();
    List<Curso> getCursos (String campo, TipoOrden tipoOrden);
    List<Curso> getCursos (Boolean estado);
    Curso crearCurso (Curso curso);
    Curso modificarCurso (Curso curso);
    int eliminarCursosPorNombre(String nombre);

}
