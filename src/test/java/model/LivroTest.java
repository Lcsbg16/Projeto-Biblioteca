package model;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LivroTest {

    @Test
    void testConstrutorVazio(){
        Livro livro = new Livro();
        String esperado =null;
        Assertions.assertEquals(esperado,livro.toString());
    }

    @Test
    void testConstrutorPreenchidoSemAutor() throws Exception {
        //Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();

        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        String esperado = "TituloTeste";

        Assertions.assertEquals(esperado,livro.toString());

    }


    @Test
    void testConstrutorPreenchidoComUmAutor() throws Exception {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();
        AutoresTest.add(autor);
        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        String esperado = "TituloTeste";

        Assertions.assertEquals(esperado,livro.toString());

    }


    @Test
    void testConstrutorPreenchidoComMaisAutores() throws Exception {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        Autor autor2 = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();
        AutoresTest.add(autor);
        AutoresTest.add(autor2);

        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        String esperado = "TituloTeste";

        Assertions.assertEquals(esperado,livro.toString());

    }

    @Test
    void testAtualizarCodigo() throws Exception {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();
        AutoresTest.add(autor);
        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");
        livro.atualizarProximoCodigo();
        Long maior = 0L;
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro livro1 : livros) {
                if (livro1.getCodigo() > maior) {
                    maior = livro1.getCodigo();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(maior,livro.getCodigo()-1);
    }



    @Test
    void testToString() throws Exception {
        Autor autor = new Autor("NomeTeste","SobrenomeTeste","NacionalidadeTeste");
        List<Autor> AutoresTest = new ArrayList<>();
        AutoresTest.add(autor);
        Livro livro = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        String esperado = "TituloTeste";

        Assertions.assertEquals(esperado,livro.toString());

    }

    @Test
    void testEquals() throws Exception {
        List<Autor> AutoresTest = new ArrayList<>();

        Livro livro1 = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        Livro livro2 = new Livro("TituloTeste",
                AutoresTest,
                "AnoTest");

        Assertions.assertTrue(livro1.equals(livro2));

    }


}
