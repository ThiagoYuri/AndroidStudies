package ws.senaidf.listviewpersonalizado;

public class Carro {
    private String nome;
    private int imagem; // vai armazenar o identificador do recurso
    private String modelo;

    public Carro(String nome, String modelo,int imagem){
        this.setNome(nome);
        this.setModelo(modelo);
        this.setImagem(imagem);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String endereco) {
        this.modelo = endereco;
    }
}
