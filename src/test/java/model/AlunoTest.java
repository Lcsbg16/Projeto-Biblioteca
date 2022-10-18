package model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AlunoTest {

    @Test
    void testConstrutorVazio(){
        Aluno aluno = new Aluno();
        String esperado = "null    null";

        Assertions.assertEquals(esperado, aluno.toString());
    }

    @Test
    void testConstrutorPreenchido(){
        Aluno aluno = new Aluno("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        String Nome = "NomeTeste";
        String Endereco = "EnderecoTeste";
        String Telefone = "TelefoneTeste";
        String Matricula = "MatriculaTeste";

        Assertions.assertEquals(Nome,aluno.getNome());
        Assertions.assertEquals(Endereco,aluno.getEndereco());
        Assertions.assertEquals(Telefone,aluno.getTelefone());
        Assertions.assertEquals(Matricula,aluno.getMatricula());
    }

    @Test
    void testAtualizarCodigo(){
        Aluno aluno =  new Aluno("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");
        aluno.AtualizarProximoCodigo();
        Long maior = 0L;
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno aluno1 : alunos) {
                if (aluno1.getCodigo() > maior) {
                    maior = aluno1.getCodigo();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(maior,aluno.getCodigo()-1);
    }

    @Test
    void testToString(){
        Aluno aluno =  new Aluno("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        String esperado = "NomeTeste    MatriculaTeste";

        Assertions.assertEquals(esperado,aluno.toString());

    }


    @Test
    void testEquals(){
        Aluno aluno1 = new Aluno("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        Aluno aluno2 = new Aluno("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        Assertions.assertTrue(aluno1.equals(aluno2));

    }



}
