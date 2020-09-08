package br.com.logmat;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import br.com.logmat.dao.ArpDao;
import br.com.logmat.model.Arp;

public class AutoVerificacao {
//Gerar uma autoverificação das datas das atas comparando as datas finais e a data atual
//disparando um E-mail alerta quando uma ARP estiver a 6 , 3 ou 1 meses de seu fim.

//Ao iniciar o sistema deverá ser criado um LocalDate dataAtual e chamar o método
//arpDao.listarProduto() dentro de um FOR para verificar cada ARP por meio de um IF.

	private LocalDate dataAtual;
	private LocalDate dataInicial;
	private LocalDate dataDeAlerta6Meses;
	private LocalDate dataDeAlerta9Meses;
	private LocalDate dataDeAlerta11Meses;

	public void emailVerificacao() {
		dataAtual = dataInicial.now();
		ArpDao arpDao = new ArpDao();
		List<Arp> lista = arpDao.listarProduto();

		dataDeAlerta6Meses = dataInicial.plusMonths(6);
		dataDeAlerta9Meses = dataInicial.plusMonths(9);
		dataDeAlerta11Meses = dataInicial.plusMonths(11);

		for (Arp x : lista) {
			dataInicial = x.getInicioVigenciaArp();

			Duration duracao6 = Duration.between(dataAtual, dataDeAlerta6Meses);
			Duration duracao9 = Duration.between(dataAtual, dataDeAlerta9Meses);
			Duration duracao11 = Duration.between(dataAtual, dataDeAlerta11Meses);

			if (duracao6.toDays() > 180) {
				System.out.println("Restam menos de 180 dias para o fim de ARP nº " + x.getNumArp());
			}
			if (duracao9.toDays() > 270) {
				System.out.println("Restam menos de 270 dias para o fim de ARP nº " + x.getNumArp());
			}
			if (duracao11.toDays() > 330) {
				System.out.println("Restam menos de 330 dias para o fim de ARP nº " + x.getNumArp());
			}
		}

	}
}
