package br.edu.femass.model;

public class Leitor {
    private Long codigo;
    private static Long proximoCodigo = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    protected Integer prazoMaximoDevolucao;

    public Leitor(){
    }

    public Leitor(String nome, String endereco, String telefone) {
        this.codigo = proximoCodigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        proximoCodigo++;
    }



    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Leitor.proximoCodigo = proximoCodigo;
    }

    public static Long getProximoCodigo() {
        return proximoCodigo;
    }

    public String toString() {
        return (this.nome + " Prazo Maximo de Devolução: "+ this.getPrazoMaximoDevolucao());
    }

    public boolean equals(Object obj) {
        Leitor leitor = (Leitor) obj;
        return leitor.getCodigo().equals(this.codigo);
    }



}
