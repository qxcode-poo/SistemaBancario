package br.ufc.quixada.poo.banco.service;

import br.ufc.quixada.poo.banco.model.ContaAbstrata;
import br.ufc.quixada.poo.banco.model.ContaEspecial;
import br.ufc.quixada.poo.banco.model.ContaPoupanca;
import br.ufc.quixada.poo.banco.repository.IRepositorioConta;

public class QBanco implements IBanco {
	private IRepositorioConta repositorio;

	private double taxa = 0.06;

	public QBanco(IRepositorioConta repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(ContaAbstrata conta) {
		repositorio.inserir(conta);
	}

	public void creditar(String numero, double valor) {
		ContaAbstrata conta = repositorio.procurar(numero);

		if (conta != null) {
			conta.creditar(valor);
		}
	}

	public void debitar(String numero, double valor) {

		ContaAbstrata conta = repositorio.procurar(numero);

		if (conta != null) {
			conta.debitar(valor);
		}
	}

	public double saldo(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null) {
			return conta.obterSaldo();
		}
		return -1;
	}

	public void transferir(String origem, String destino, double valor) {
		ContaAbstrata contaOrigem = repositorio.procurar(origem);

		if (contaOrigem != null && contaOrigem.obterSaldo() >= valor) {
			ContaAbstrata contaDestino = repositorio.procurar(destino);

			if (contaDestino != null) {
				contaOrigem.debitar(valor);
				contaDestino.creditar(valor);
			}
		}
	}

	public void renderJuros(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);

		if (conta != null && conta instanceof ContaPoupanca) {
			ContaPoupanca poupanca = (ContaPoupanca) conta;
			poupanca.renderJuros(this.taxa);
		}

	}

	public void renderJuros() {
		ContaPoupanca[] poupancas = repositorio.listarPoupanca();
		if (poupancas != null) {
			for (int i = 0; i < poupancas.length; i++) {
				poupancas[i].renderJuros(this.taxa);
			}
		}
	}

	public void renderBonus(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);

		if (conta != null && conta instanceof ContaEspecial) {
			ContaEspecial especial = (ContaEspecial) conta;
			especial.renderBonus();
		}
	}

	public void renderBonus() {
		ContaEspecial[] especiais = repositorio.listarEspecial();
		if (especiais != null) {
			for (int i = 0; i < especiais.length; i++) {
				especiais[i].renderBonus();
			}
		}
	}

	public double saldoTotal() {
		ContaAbstrata[] contas = repositorio.listar();
		double total = 0;

		for (int i = 0; i < contas.length; i++) {
			ContaAbstrata conta = contas[i];
			total += conta.obterSaldo();
		}

		return total;
	}

	public int numeroContas() {
		return repositorio.numero();
	}

}