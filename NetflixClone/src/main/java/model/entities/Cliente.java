package main.java.model.entities;

public class Cliente extends Pessoa {
  String dataDeCadastro;
  String password;
  
  public Cliente(String name, String cpf) {
    super(name, cpf);
  }
  public Cliente(String name, int age, String cpf, String email, String phone, String dataDeCadastro, String password) {
    super(name, age, cpf, email, phone);
    this.dataDeCadastro = dataDeCadastro;
    this.password = password;
  }
  public String getDataDeCadastro() {
    return dataDeCadastro;
  }
  public void setDataDeCadastro(String dataDeCadastro) {
    this.dataDeCadastro = dataDeCadastro;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  

  
  
}
