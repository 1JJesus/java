package test;

import java.time.LocalDate;
import dao.DaoAutor;
import entidades.Autor;

public class testUpdate {

    public static void main(String[] args) {
        Autor autor = new Autor();
        autor.setIdautor(1);
        autor.setNombre("Nuevo Nombre");

        // Crea un objeto LocalDate con la fecha deseada (2007-01-07)
       // LocalDate fechaNacimiento = LocalDate.of(2000, 1, 7);

        // Crear un objeto java.sql.Date con la fecha deseada (por ejemplo, 2000-01-07)
        java.sql.Date fechaNacimiento = java.sql.Date.valueOf("2000-01-07");

        autor.setFechanacimiento(fechaNacimiento);


        System.out.println(autor);

        // Luego, puedes llamar al método update del DaoAutor para actualizar la fecha de nacimiento
        DaoAutor daoAutor = new DaoAutor();
        daoAutor.update(autor);
    }
}
