package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.CursoRepository;
import es.fplumara.dam1.alumnos.repository.TipoOrden;

import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService {
    CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Optional<Curso> findById(Integer idCurso) {
        if(idCurso == null){
            throw new IllegalArgumentException("El id no puede ser nulo");
        }

        return cursoRepository.findById(idCurso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.listar();
    }

    @Override
    public List<Curso> getCursos(String campo, TipoOrden tipoOrden) {
        if(campo == null || tipoOrden == null || campo.isEmpty()){
            throw new IllegalArgumentException("Los campos no pueden ser nulos");
        }
        return cursoRepository.listarOrdenadoPor(campo, tipoOrden);
    }

    @Override
    public List<Curso> getCursos(Boolean estado) {
        if(estado == null){
            throw new IllegalArgumentException("El campo no puede ser nulo");
        }
        return cursoRepository.listarPorEstado(estado);
    }

    @Override
    public Curso crearCurso(Curso curso) {
        if (curso.getNombre() == null || curso.getNombre().isEmpty()){
            throw new IllegalArgumentException("El nombre del curso no puede estar vacio");
        }

        return cursoRepository.crearCurso(curso);
    }

    @Override
    public Curso modificarCurso(Curso curso) {
        if(curso.getId() == 0 || curso.isActivo() == null || curso.getNombre() == null || curso.getNombre().isEmpty()){
            throw new IllegalArgumentException("Los atributos del curso no pueden ser nulos");
        }
        return cursoRepository.modificar(curso);
    }

    @Override
    public int eliminarCursosPorNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }

        return cursoRepository.eliminarSiNombreContiene(nombre);
    }
}
