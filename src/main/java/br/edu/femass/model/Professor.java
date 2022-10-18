package br.edu.femass.model;

import br.edu.femass.dao.DaoProfessor;

import java.util.List;
import java.util.Objects;

public class Professor extends Leitor{
    private String disciplina;


    public Professor(){

    }
    public Professor(String nome, String endereco, String telefone,String disciplina) {
        super(nome, endereco, telefone);
        this.disciplina = disciplina;
        this.prazoMaximoDevolucao = 30;
        AtualizarProximoCodigo();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return  (this.getNome() +"    "+this.disciplina);
    }

    public void AtualizarProximoCodigo(){
        Long maior = 0L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor professor : professores) {
                if (professor.getCodigo() > maior) {
                    maior = professor.getCodigo();
                    setCodigo(maior+1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(disciplina, professor.disciplina);
    }


}
