import java.io.Serializable;

public class Livro implements Serializable {
    private String autor;
    private String editora;
    private Integer ano;
    private String nome;
    private Float preco;

    public Livro(String autor, Integer ano, String nome) {
        this.autor = autor;
        this.ano = ano;
        this.nome = nome;
    }

    public Livro(String autor, String editora, Integer ano, String nome, Float preco) {
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.nome = nome;
        this.preco = preco;
    }

    public Livro(String autor, String nome){
        this.autor = autor;
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;

        if (!autor.equals(livro.autor)) return false;
        return nome.equals(livro.nome);
    }

    @Override
    public String toString() {
        return "Livro{"
                + " Autor = " + autor
                + ", Editora = " + editora
                + ", Nome = " + nome
                + ", Ano = " + ano
                + ", Preço = " + preco
                + " }";
    }
}
