package br.ufc.quixada.poo.banco.repository;

import java.util.Vector;

import br.ufc.quixada.poo.banco.model.ContaAbstrata;
import br.ufc.quixada.poo.banco.model.ContaEspecial;
import br.ufc.quixada.poo.banco.model.ContaPoupanca;

public class VectorContas implements IRepositorioConta {

	private Vector<ContaAbstrata> contas;

	public VectorContas() {
		contas = new Vector<ContaAbstrata>();
	}

	public void inserir(ContaAbstrata conta) {
		if (procurar(conta.obterNumero()) == null) {
			contas.add(conta);
		}
	}

	public void remover(String numero) {
		ContaAbstrata conta = procurar(numero);
		if (conta != null) {
			contas.remove(conta);
		}
	}

	public ContaAbstrata procurar(String numero) {
		for (int i = 0; i < contas.size(); i++) {
			ContaAbstrata conta = contas.get(i);
			if (numero.equals(conta.obterNumero())) {
				return conta;
			}
		}
		return null;
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata[] lista = new ContaAbstrata[contas.size()];
		for (int i = 0; i < contas.size(); i++) {
			lista[i] = contas.get(i);
		}
		return lista;
	}

	public ContaEspecial[] listarEspecial() {
		Vector<ContaEspecial> especial = new Vector<ContaEspecial>();
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof ContaEspecial) {
				especial.add((ContaEspecial) contas.get(i));
			}
		}

		if (especial.size() > 0) {
			ContaEspecial[] lista = new ContaEspecial[especial.size()];
			for (int i = 0; i < especial.size(); i++) {
				lista[i] = especial.get(i);
			}
			return lista;
		}

		return null;
	}

	public ContaPoupanca[] listarPoupanca() {
		Vector<ContaPoupanca> poupanca = new Vector<ContaPoupanca>();
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof ContaPoupanca) {
				poupanca.add((ContaPoupanca) contas.get(i));
			}
		}

		if (poupanca.size() > 0) {
			ContaPoupanca[] lista = new ContaPoupanca[poupanca.size()];
			for (int i = 0; i < poupanca.size(); i++) {
				lista[i] = poupanca.get(i);
			}
			return lista;
		}

		return null;
	}

	public int numero() {
		return contas.size();
	}

}