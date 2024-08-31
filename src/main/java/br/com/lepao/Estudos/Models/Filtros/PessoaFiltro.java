package br.com.lepao.Estudos.Models.Filtros;

import br.com.lepao.Estudos.Models.Enum.GeneroEnum;

public class PessoaFiltro {

    private String nome;

    private int idade;

    private String genero;

    public PessoaFiltro() {

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
