package br.ufc.quixada.poo.banco.model;
  
public class Conta extends ContaAbstrata { 
    
   public Conta (String numero) {
     super(numero);
   } 
    
   public void debitar (double valor){ 
       saldo = saldo - valor; 
   }  
} 
