package br.ufc.quixada.poo.banco.model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numero) {
		super(numero);
	}

	public void renderJuros(double taxa) {
		this.creditar(this.obterSaldo() * taxa);
	}
}