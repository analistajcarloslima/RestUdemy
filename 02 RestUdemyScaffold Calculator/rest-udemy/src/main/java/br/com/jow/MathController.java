package br.com.jow;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jow.exception.UnsuportedMathOperation;

@RestController
public class MathController {
	
	// request mapping define que é uma função que será disponibilizada no webservice
	//os parametros a serem recebidos são definidos nas entre chaves
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)

	// a notação @RequestParam permite que os valores passados sejam opcionais
	// Default value adiciona um valor padrão caso não seja pasasado uma parametro

	// no caso da caulculadora vamos usar o PathVariable para indicar que são obrigatórios os envios dos parametros
	public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception  {

		//criar um método de verificação para saver se os valores passados são numerios 

		// neste caso estou usando a negação "!"" e a estrutura de comparação '||' "ou" para fazer essa verificação
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuportedMathOperation("Insira um número válido");
		}

		// criar o método de conversão de string para double 
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;		
	}

	private double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		// realizar as substituição do  ponto por virgula // . é usado por padrão por sistemas para double
		String number = strNumber.replaceAll(",", ".");

		// se number for npumero então vai ocorrer a conversão para double
		if (isNumeric(number)) return Double.parseDouble(number);
		return 1D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		// realizar as substituição do  ponto por virgula // . é usado por padrão por sistemas para double
		String number = strNumber.replaceAll(",", ".");
		// verificar se o que vai ser retornado é um numero
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}

