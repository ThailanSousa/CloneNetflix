package br.com.unifacol.cloneflix.model.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name= "funcionario")
public class Funcionario extends Pessoa {
  @Id
  @Column(name = "id")
  private int matricula = 0;
  private int tipoDeFuncionario = 0;
  private String password;



  public Funcionario(String name, String cpf, int matricula, int tipoDeFuncionario, String password) {
    super(name, cpf);
    this.matricula = matricula;
    this.tipoDeFuncionario = tipoDeFuncionario;
    this.password = password;
  }
  public Funcionario(String name, int age, String cpf, String email, String phone, int matricula,
      int tipoDeFuncionario) {
    super(name, age, cpf, email, phone);
    this.matricula = matricula;
    this.tipoDeFuncionario = tipoDeFuncionario;
  }
  public int getMatricula() {
    return matricula;
  }
  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }
  public int getTipoDeFuncionario() {
    return tipoDeFuncionario;
  }
  public void setTipoDeFuncionario(int tipoDeFuncionario) {
    this.tipoDeFuncionario = tipoDeFuncionario;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
