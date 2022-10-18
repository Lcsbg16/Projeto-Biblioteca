package model;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Leitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeitorTest {

    @Test
    void testConstrutorVazio(){
        Leitor leitor = new Leitor();
        String esperado = null;
        Assertions.assertEquals(esperado,leitor.toString());
    }

    @Test
    void testConstrutorPreenchido(){
        Leitor leitor = new Leitor("NomeTeste","EnderecoTeste","TelefoneTeste");
        String Nome = "NomeTeste";
        String Endereco = "EnderecoTeste";
        String Telefone = "TelefoneTeste";

        Assertions.assertEquals(Nome,leitor.getNome());
        Assertions.assertEquals(Endereco,leitor.getEndereco());
        Assertions.assertEquals(Telefone,leitor.getTelefone());
    }

    @Test
    void testToString(){
        Leitor leitor = new Leitor("NomeTeste","EnderecoTeste","TelefoneTeste");
        String esperado = "NomeTeste";
        Assertions.assertEquals(esperado,leitor.toString());
    }

    @Test
    void testEquals(){
        Autor leitor1 = new Autor ("NomeTeste","EnderecoTeste","TelefoneTeste");
        Autor leitor2 = new Autor("NomeTeste","EnderecoTeste","TelefoneTeste");
        Assertions.assertTrue(leitor1.equals(leitor2));
    }

}
