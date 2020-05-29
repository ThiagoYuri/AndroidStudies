package ws.android.atividadeeintencao;

import java.io.Serializable;

public class ClienteV2 implements Serializable {

    private int codigo;
    private String nome;

    public ClienteV2(String nome,int codigo){
        this.setNome(nome);
        this.setCodigo(codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
