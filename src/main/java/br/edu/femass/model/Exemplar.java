package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Exemplar {
    private Long codigo;
    private static Long proximoCodigo = 1L;
    private LocalDate dataAquisicao;


    private Livro livro;

    public Exemplar() {
    }

    public Exemplar(Livro livro) {
        this.dataAquisicao = LocalDate.now();
        this.codigo = proximoCodigo;
        this.livro = livro;
        atualizarProximoCodigo();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public void atualizarProximoCodigo(){
        Long maior = 0L;
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            for (Exemplar exemplar : exemplares) {
                if (exemplar.getCodigo() > maior) {
                    maior = exemplar.getCodigo();
                    setCodigo(maior+1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return (this.getCodigo()+" Exemplar do livro  "+this.getLivro());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return Objects.equals(codigo, exemplar.codigo)
                && Objects.equals(dataAquisicao, exemplar.dataAquisicao)
                && Objects.equals(livro, exemplar.livro);
    }

}
