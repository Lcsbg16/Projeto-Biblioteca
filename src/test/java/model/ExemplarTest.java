package model;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExemplarTest {

    @Test
    void testConstrutorVazio(){
        Exemplar exemplar = new Exemplar();
        String esperado = "null Exemplar do livro  null";

        Assertions.assertEquals(esperado,exemplar.toString());

    }

    @Test
    void testConstrutorPreenchido() throws Exception {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();
        AutoresTest.add(autor);
        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        Exemplar exemplar = new Exemplar(livro);

        String esperado = "19 Exemplar do livro  TituloTeste";

        Assertions.assertEquals(esperado,exemplar.toString());
    }


    @Test
    void testatualizarProximoCodigo(){
        Exemplar exemplar = new Exemplar();

        exemplar.atualizarProximoCodigo();
        Long maior = 0L;
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            for (Exemplar exemplar1: exemplares){
                if(exemplar1.getCodigo()>maior){
                    maior = exemplar1.getCodigo();
                }
            }
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
        Assertions.assertEquals(maior,exemplar.getCodigo()-1);
    }


    @Test
    void testToString(){
        Exemplar exemplar = new Exemplar();
        String esperado = "null Exemplar do livro  null";

        Assertions.assertEquals(esperado,exemplar.toString());

    }

    @Test
    void testEquals() throws Exception {
        List<Autor> AutoresTest = new ArrayList<>();
        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        Exemplar exemplar1 = new Exemplar(livro);
        Exemplar exemplar2 = new Exemplar(livro);

        Assertions.assertTrue(exemplar1.equals(exemplar2));

    }


}
