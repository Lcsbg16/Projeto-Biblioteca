package model;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProfessorTest {

    @Test
    void testConstrutorVazio(){
        Professor professor = new Professor();
        String esperado = "null    null";

        Assertions.assertEquals(esperado, professor.toString());
    }

    @Test
    void testConstrutorPreenchido(){
        Professor professor = new Professor("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "DisciplinaTeste");

        String Nome = "NomeTeste";
        String Endereco = "EnderecoTeste";
        String Telefone = "TelefoneTeste";
        String Disciplina = "DisciplinaTeste";

        Assertions.assertEquals(Nome,professor.getNome());
        Assertions.assertEquals(Endereco,professor.getEndereco());
        Assertions.assertEquals(Telefone,professor.getTelefone());
        Assertions.assertEquals(Disciplina,professor.getDisciplina());
    }

    @Test
    void testAtualizarCodigo(){
        Professor professor = new Professor("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "DisciplinaTeste");
        professor.AtualizarProximoCodigo();
        Long maior = 0L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor professor1 : professores) {
                if (professor1.getCodigo() > maior) {
                    maior = professor1.getCodigo();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(maior,professor.getCodigo()-1);
    }

    @Test
    void testToString(){
        Professor professor = new Professor("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        String esperado = "NomeTeste    MatriculaTeste";

        Assertions.assertEquals(esperado,professor.toString());

    }

    @Test
    void testEquals(){
        Professor professor = new Professor("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        Professor professor2 = new Professor("NomeTeste",
                "EnderecoTeste",
                "TelefoneTeste",
                "MatriculaTeste");

        Assertions.assertTrue(professor.equals(professor2));

    }




}
