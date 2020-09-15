package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestExercicio {

	private String BREAK = System.lineSeparator();

	@Test
	public void exercicio01() {
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP: 13080-395 | Tel: (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}
	
	@Test
	public void exercicio02_tudoVazio() {
		CupomFiscal.NOME_LOJA = "";
		CupomFiscal.LOGRADOURO = "";
		CupomFiscal.NUMERO = 0;
		CupomFiscal.COMPLEMENTO = "";
		CupomFiscal.BAIRRO = "";
		CupomFiscal.MUNICIPIO = "";
		CupomFiscal.ESTADO = "";
		CupomFiscal.CEP = "";
		CupomFiscal.TELEFONE = "";
		CupomFiscal.OBSERVACAO = "";
		CupomFiscal.CNPJ = "";
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		
		rodarTestarOutput("" + BREAK + 
				", 0 " + BREAK + 
				" -  - " + BREAK + 
				"CEP:  | Tel: " + BREAK +
				"" + BREAK + 
				"CNPJ: " + BREAK + 
				"IE: " + BREAK);
	}

	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "LOJAS AMERICANAS S.A.";
		CupomFiscal.LOGRADOURO = "R SACADURA CABRAL";
		CupomFiscal.NUMERO = 102;
		CupomFiscal.COMPLEMENTO = "";
		CupomFiscal.BAIRRO = "GAMBOA";
		CupomFiscal.MUNICIPIO = "RIO DE JANEIRO";
		CupomFiscal.ESTADO = "RJ";
		CupomFiscal.CEP = "20.221-160";
		CupomFiscal.TELEFONE = "(21) 2206-6708";
		CupomFiscal.OBSERVACAO = "47.11-3-02 – Comércio varejista de mercadorias em geral";
		CupomFiscal.CNPJ = "33.014.556/0001-96";
		CupomFiscal.INSCRICAO_ESTADUAL = "85.687.08-5";
		
		//E atualize o texto esperado abaixo
		rodarTestarOutput("LOJAS AMERICANAS S.A." + BREAK +
				"R SACADURA CABRAL, 102 " + BREAK +
				"GAMBOA - RIO DE JANEIRO - RJ" + BREAK +
				"CEP: 20.221-160 | Tel: (21) 2206-6708" + BREAK +
				"47.11-3-02 – Comércio varejista de mercadorias em geral" + BREAK +
				"CNPJ: 33.014.556/0001-96" + BREAK +
				"IE: 85.687.08-5" + BREAK);
	}

	private void rodarTestarOutput(String expected) {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		CupomFiscal.main(null);

		// assertion
		assertEquals(expected, bos.toString());

		// undo the binding in System
		System.setOut(originalOut);
	}
}
