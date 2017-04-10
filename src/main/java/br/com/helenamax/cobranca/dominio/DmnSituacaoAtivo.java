/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.dominio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 005712431
 */
public class DmnSituacaoAtivo implements Comparable {

   private static final Map<Boolean, DmnSituacaoAtivo> conjunto = new HashMap<Boolean, DmnSituacaoAtivo>();

   public static final DmnSituacaoAtivo ATIVO = new DmnSituacaoAtivo(true, "A");
   public static final DmnSituacaoAtivo INATIVO = new DmnSituacaoAtivo(false, "I");

   /** Valor atual do domínio */
   private final boolean valor;
   /** Descrição atual do domínio */
   private final String descricao;

   public DmnSituacaoAtivo()
   {
      this.valor = ATIVO.getValor();
      this.descricao = INATIVO.toString();
   }

   private DmnSituacaoAtivo(boolean novoValor, String novaDescricao)
   {
      this.valor = novoValor;
      this.descricao = novaDescricao;
      conjunto.put(new Boolean(novoValor), this);
   }

   public boolean getValor()
   {
      return valor;
   }

   public static DmnSituacaoAtivo obterPorValor(boolean valor)
   {
      DmnSituacaoAtivo resposta = conjunto.get(new Boolean(valor));
      if (resposta == null) throw new IllegalArgumentException("Não existe flag com o valor " + valor + ".");
      if (resposta.valor != valor) throw new AssertionError("Valor procurado é diferente do valor encontrado.");
      return resposta;
   }

   public String toString()
   {
      return descricao;
   }


   public DmnSituacaoAtivo[] getItems()
   {
      return values();
   }

   //Daqui para baixo, métodos para simulação de um enum. Trocar para enum
   //verdadeiro quando migrar o código para Java 1.5 ou superior.

   protected final Object clone() throws CloneNotSupportedException
   {
      throw new CloneNotSupportedException();
   }

   protected final void finalize() {}

   public boolean equals(Object obj)
   {
      if (!(obj instanceof DmnSituacaoAtivo)) return false;
      DmnSituacaoAtivo outro = (DmnSituacaoAtivo)obj;
      return this.valor == outro.valor;
   }


   public static DmnSituacaoAtivo[] values()
   {
      return conjunto.values().toArray(new DmnSituacaoAtivo[0]);
   }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
