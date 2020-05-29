package ws.loja.wstowers;

import android.text.Editable;

import java.io.Serializable;

public class ClassCadastro implements Serializable {
    //declaração de variaveis
    private String Login;
    private String Senha;

    private String Nome;
    private String SobreNome;
    private String Email;
    private String WhatsApp;
    private String Telefone;
    private String Cnpj;
    private String Cep;
    private String Endereco;
    private String Bairro;
    private String Cidade;
    private String UF;
    private String Interesse;



    //Construtores
    public ClassCadastro(String Login,String Senha,String Nome,String SobreNome,String Email,String WhatsApp,String Telefone,String Cnpj,String Cep,String Endereco,String Bairro,String Cidade,String UF,String interesse){
      this.setLogin(Login);
      this.setSenha(Senha);
      this.setNome(Nome);
      this.setSobreNome(SobreNome);
      this.setEmail(Email);
      this.setWhatsApp(WhatsApp);
      this.setTelefone(Telefone);
      this.setCnpj(Cnpj);
      this.setCep(Cep);
      this.setEndereco(Endereco);
      this.setBairro(Bairro);
      this.setCidade(Cidade);
      this.setUF(UF);
      this.setInteresse(interesse);
    }

    //getSet
    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobreNome() {
        return SobreNome;
    }

    public void setSobreNome(String sobreNome) {
        SobreNome = sobreNome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWhatsApp() {
        return WhatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        WhatsApp = whatsApp;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String cnpj) {
        Cnpj = cnpj;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getInteresse() {
        return Interesse;
    }

    public void setInteresse(String interesse) {
        Interesse = interesse;
    }
}
