package es.fplumara.dam1.alumnos;

import es.fplumara.dam1.alumnos.model.Alumno;
import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.*;
import es.fplumara.dam1.alumnos.service.AlumnoService;
import es.fplumara.dam1.alumnos.service.AlumnoServiceImpl;
import es.fplumara.dam1.alumnos.service.CursoService;
import es.fplumara.dam1.alumnos.service.CursoServiceImpl;

public class Main {

    public static void main(String[] args) {
        String url  = "jdbc:postgresql://localhost:5432/dam1";
        String user = "dam1";
        String pass = "dam1pass";

        CursoRepository cursoRepo = new CursoRepositoryPostgreDB(url, user, pass);
        cursoRepo.initSchema();
        CursoService cursoService = new CursoServiceImpl(cursoRepo);

//        Curso c1 = new Curso(null, true, "inglés");
//        Curso c2 = new Curso(null, false, "mates");
//        Curso c3 = new Curso(null, null, "lengua");
//
//        cursoService.crearCurso(c1);
//        cursoService.crearCurso(c2);
//        cursoService.crearCurso(c3);

        System.out.println("=== LISTA DE CURSOS ===");
        cursoService.getCursos().forEach(c ->
                System.out.println(c.getId() + " -> " + c.getNombre() + " " + (c.isActivo() ? "Activo" : "Inactivo"))
        );

        System.out.println("=== LISTA DE CURSOS ORDENADO ==="); /* DA ERROR */
        cursoService.getCursos("nombre", TipoOrden.valueOf("ASC")).forEach(c ->
                System.out.println(c.getId() + " -> " + c.getNombre() + " " + (c.isActivo() ? "Activo" : "Inactivo"))
        );

//        AlumnoRepository repo = new AlumnoRepositoryDB(url, user, pass);
//        AlumnoService service = new AlumnoServiceImpl(repo);
//
//        Alumno a1 = new Alumno(null, "John", "Doe", 2015);
//        Alumno a2 = new Alumno(null, "Jane", "Doe", 2018);
//        Alumno a3 = new Alumno(null, "Tim", "Roe", 2016);
//
//        service.crearAlumno(a1);
//        service.crearAlumno(a2);
//        service.crearAlumno(a3);
//
//        System.out.println("=== LISTA DE ALUMNOS ===");
//        service.getAlumnos().forEach(a ->
//                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
//        );
//
//        System.out.println("\n=== BUSCAR ALUMNO ID 2 ===");
//        Alumno buscado = service.getAlumno(2);
//        System.out.println(buscado.getId() + " -> " + buscado.getNombre() + " " + buscado.getApellidos());
//
//        System.out.println("\n=== MODIFICAR ALUMNO ID 2 ===");
//        Alumno modificado = new Alumno(2, "Jane", "Doe", 2009); // ejemplo: cambia año
//        service.modificarAlumno(modificado);
//
//        System.out.println("\n=== LISTA TRAS MODIFICAR ===");
//        service.getAlumnos().forEach(a ->
//                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
//        );
    }
}