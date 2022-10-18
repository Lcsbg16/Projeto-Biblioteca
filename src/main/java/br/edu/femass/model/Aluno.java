package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;

import java.util.List;
import java.util.Objects;

public class Aluno extends Leitor {
    private String matricula;

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String nome, String endereco, String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        this.prazoMaximoDevolucao = 15;
        AtualizarProximoCodigo();
    }

    public Aluno(){
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return  (this.getNome() +"    "+this.matricula);
    }

    public void AtualizarProximoCodigo(){
        Long maior = 0L;
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno aluno : alunos) {
                if (aluno.getCodigo() > maior) {
                    maior = aluno.getCodigo();
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
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

}
