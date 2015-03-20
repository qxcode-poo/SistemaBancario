package br.ufc.quixada.poo.banco.controller;

import br.ufc.quixada.poo.banco.service.IBanco;

public class AuditorBancoGenerico {

	public void auditar(IBanco banco) {
		if ((banco.saldoTotal() / banco.numeroContas()) > 500) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Nao aprovado!");
		}
	}
}
