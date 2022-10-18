
package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livro {
    private Long codigo;
    private String titulo;

    private List<Autor> autores = new ArrayList<>();
    private String ano;

    private List<Exemplar> exemplares = new ArrayList<>();
    private static Long proximoCodigo = 1L;

    public Livro(String titulo,List<Autor> autores,String ano) throws Exception {
        this.codigo = proximoCodigo;
        this.titulo = titulo;
        this.autores=autores;
        this.ano = ano;
        atualizarProximoCodigo();
        this.exemplares = new DaoExemplar().getAll();
    }

    public Livro(){
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autores;
    }

    public void setAutor(List<Autor> autor) {
        this.autores = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public static Long getProximoCodigo() {
        return proximoCodigo;
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Livro.proximoCodigo = proximoCodigo;
    }

    public void atualizarProximoCodigo(){
        Long maior = 0L;
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro livro : livros) {
                if (livro.getCodigo() > maior) {
                    maior = livro.getCodigo();
                    setCodigo(maior+1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return this.titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(codigo, livro.codigo)
                && Objects.equals(titulo, livro.titulo)
                && Objects.equals(autores, livro.autores)
                && Objects.equals(ano, livro.ano);
    }


}
