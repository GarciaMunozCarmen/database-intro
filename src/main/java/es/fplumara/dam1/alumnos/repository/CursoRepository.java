package es.fplumara.dam1.alumnos.repository;

import es.fplumara.dam1.alumnos.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    void initSchema();
    public Curso crearCurso(Curso curso);
    public Optional<Curso> findById(int id);
    public void activar(Curso curso);
    public Curso modificar (Curso curso);
    public int eliminarSiNombreContiene(String contiene);
    public List<Curso> listar ();
    public List<Curso> listarPorEstado (Boolean estado);
    public List<Curso> listarOrdenadoPor (String campo, TipoOrden tipoOrden);
}
