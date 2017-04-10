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
public class DmnSituacaoFinanceira implements Comparable {

   private static final Map<Integer, DmnSituacaoFinanceira> conjunto = new HashMap<Integer, DmnSituacaoFinanceira>();

   public static final DmnSituacaoFinanceira EM_ABERTO = new DmnSituacaoFinanceira(0, "A");
   public static final DmnSituacaoFinanceira QUITADO = new DmnSituacaoFinanceira(1, "Q");

   /** Valor atual do domínio */
   private final int valor;
   /** Descrição atual do domínio */
   private final String descricao;

   public DmnSituacaoFinanceira()
   {
      this.valor = EM_ABERTO.getValor();
      this.descricao = EM_ABERTO.toString();
   }

   private DmnSituacaoFinanceira(int novoValor, String novaDescricao)
   {
      this.valor = novoValor;
      this.descricao = novaDescricao;
      conjunto.put(new Integer(novoValor), this);
   }

   public int getValor()
   {
      return valor;
   }

   public static DmnSituacaoFinanceira obterPorValor(int valor)
   {
      DmnSituacaoFinanceira resposta = conjunto.get(new Integer(valor));
      if (resposta == null) throw new IllegalArgumentException("Não existe flag com o valor " + valor + ".");
      if (resposta.valor != valor) throw new AssertionError("Valor procurado é diferente do valor encontrado.");
      return resposta;
   }

   public String toString()
   {
      return descricao;
   }

   public int hashCode()
   {
      return valor;
   }

   public DmnSituacaoFinanceira[] getItems()
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
      if (!(obj instanceof DmnSituacaoFinanceira)) return false;
      DmnSituacaoFinanceira outro = (DmnSituacaoFinanceira)obj;
      return this.valor == outro.valor;
   }

   public int compareTo(Object obj)
   {
      DmnSituacaoFinanceira outro = (DmnSituacaoFinanceira)obj;
      return this.valor - outro.valor;
   }

   public static DmnSituacaoFinanceira[] values()
   {
      return conjunto.values().toArray(new DmnSituacaoFinanceira[0]);
   }

}
