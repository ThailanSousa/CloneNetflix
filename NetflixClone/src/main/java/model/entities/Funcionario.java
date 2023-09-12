package main.java.model.entities;

public class Funcionario extends Pessoa {
  int matricula = 0;

  public Funcionario(String name, String cpf) {
    super(name, cpf);
  }

  public int getMatricula() {
    return matricula;
  }
  public void setMatricula(int matricula){
    this.matricula = matricula;
  }
}
