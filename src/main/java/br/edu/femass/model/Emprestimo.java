package br.edu.femass.model;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;
    public Emprestimo(){
    }
    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
    }

    public void DevolverExemplar(){
        this.dataDevolucao = LocalDate.now();
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void RealizarDevolucao(){
        this.setDataDevolucao(LocalDate.now());
    }

    public String toString(){
        return (leitor.getNome()+" realizou o emprestimo do exemplar: "+exemplar.getLivro());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(dataEmprestimo, that.dataEmprestimo)
                && Objects.equals(dataPrevistaDevolucao, that.dataPrevistaDevolucao)
                && Objects.equals(dataDevolucao, that.dataDevolucao)
                && Objects.equals(exemplar, that.exemplar)
                && Objects.equals(leitor, that.leitor);
    }

}
