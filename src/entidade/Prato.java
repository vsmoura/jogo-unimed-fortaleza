package entidade;

public class Prato {

    private String nome;
    private String adjetivo;

    public Prato(String nome, String adjetivo) {
        this.nome = nome;
        this.adjetivo = adjetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAdjetivo() {
        return adjetivo;
    }

    public void setAdjetivo(String adjetivo) {
        this.adjetivo = adjetivo;
    }
}
