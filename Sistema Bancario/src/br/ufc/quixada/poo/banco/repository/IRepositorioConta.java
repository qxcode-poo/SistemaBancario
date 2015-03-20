package br.ufc.quixada.poo.banco.repository;

import br.ufc.quixada.poo.banco.model.ContaAbstrata;
import br.ufc.quixada.poo.banco.model.ContaEspecial;
import br.ufc.quixada.poo.banco.model.ContaPoupanca;

public interface IRepositorioConta {
	public void inserir(ContaAbstrata conta);

	public void remover(String numero);

	public ContaAbstrata procurar(String numero);

	public ContaAbstrata[] listar();

	public ContaEspecial[] listarEspecial();

	public ContaPoupanca[] listarPoupanca();

	public int numero();
}
