package model;

import br.edu.femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoTest {

    @Test
    void testConstrutorVazio(){
        EmprestimoTest emprestimo = new EmprestimoTest();
        String esperado = "model.EmprestimoTest@24269709";

        Assertions.assertEquals(esperado,emprestimo.toString());
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

        Leitor leitor = new Leitor("NomeTeste","EnderecoTeste","TelefoneTeste");
        String Nome = "NomeTeste";
        String Endereco = "EnderecoTeste";
        String Telefone = "TelefoneTeste";

        Emprestimo emprestimo = new Emprestimo(exemplar,leitor);

        String esperado = "19 realizou o emprestimo do exemplar: exemplar";

        Assertions.assertEquals(esperado,emprestimo.toString());

    }

}
