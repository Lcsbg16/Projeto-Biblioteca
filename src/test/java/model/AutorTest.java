package model;

import br.edu.femass.model.Autor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutorTest {
    @Test
    void testConstrutorVazio(){
        Autor autor = new Autor();
        String esperado = "null null";

        Assertions.assertEquals(esperado, autor.toString());
    }

    @Test
    void testConstrutorPreenchido(){
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        String Nome ="NomeTeste";
        String Sobrenome ="SobrenomeTeste";
        String Nacionalidade ="NacionalidadeTeste";

        Assertions.assertEquals(Nome,autor.getNome());
        Assertions.assertEquals(Sobrenome,autor.getSobrenome());
        Assertions.assertEquals(Nacionalidade,autor.getNacionalidade());
    }

    @Test
    void testToString() {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        String esperado = "NomeTeste SobrenomeTeste";
        Assertions.assertEquals(esperado,autor.toString());
    }

    @Test
    void testEquals(){
        Autor autor1 = new Autor ("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        Autor autor2 = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        Assertions.assertTrue(autor1.equals(autor2));
    }





}