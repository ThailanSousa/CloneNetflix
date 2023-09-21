package br.com.unifacol.cloneflix.enums;

public enum Message {
  MODELOCPF("O padrão do CPF é: XXXXXXXXXXX"),
  INVALID_EMAIL("E-mail inválido."),
  CAMPO_OBRIGATORIO("Este campo é obrigatório"),
  SUCESSO("Cadastro Realizado com Sucesso!!"),
  ALTERACAO("Alteração Realizada com Sucesso"),
  NAME("Digite o nome: "),
  AGE("Digite a idade: "),
  CPF("Digite seu CPF: "),
  PHONE("Digite seu telefone: "),
  EMAIL("Digite seu E-mail: "),
  INVALIDO("Informação inserida errada:"),
  ERRO("ERRO TIPO:"),
  PASSWORD("Digite sua senha: ");




  private String descricao;

  Message(String descricao){
    this.descricao = descricao;
  }
  public String getDescricao(){
    return descricao;
  }
}
