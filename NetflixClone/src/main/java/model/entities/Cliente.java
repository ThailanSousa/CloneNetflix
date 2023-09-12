package main.java.model.entities;

public class Cliente extends Pessoa {
  String dataDeCadastro ;
  String tipoDeCliente;

  public Cliente(String name, int age, String cpf, String email, String phone, String dataDeCadastro){
    super(name, age,cpf,email,phone);
    
  }
  public Cliente(String name, String cpf){
    super(name, cpf);
  }
  public String getDataDeCadastro() {
    return dataDeCadastro;
  }
  public void setDataDeCadastro(String dataDeCadastro) {
    this.dataDeCadastro = dataDeCadastro;
  }
  public String getTipoDeCliente() {
    return tipoDeCliente;
  }
  public void setTipoDeCliente(String tipoDeCliente) {
    this.tipoDeCliente = tipoDeCliente;
  }
  
}
