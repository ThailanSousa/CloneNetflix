package br.com.unifacol.cloneflix.enums;

public enum Message {
  MODELOCPF("O padrão do CPF é: XXXXXXXXXXX"),
  INVALID_EMAIL("E-mail inválido."),
  CAMPO_OBRIGATORIO("Este campo é obrigatório"),
  SUCESSO("Cadastro Realizado com Sucesso!!");



  private String descricao;

  Message(String descricao){
    this.descricao = descricao;
  }
  public String getDescricao(){
    return descricao;
  }
}
