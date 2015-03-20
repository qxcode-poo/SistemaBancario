package br.ufc.quixada.poo.banco.controller;

import br.ufc.quixada.poo.banco.repository.VectorContas;
import br.ufc.quixada.poo.banco.service.QBanco;

public class Controlador {

	public static void main(String args[]) {
		VectorContas contas = new VectorContas();
		QBanco bancoVector = new QBanco(contas);
		AuditorBancoGenerico auditor = new AuditorBancoGenerico();
		auditor.auditar(bancoVector);
	}
}
