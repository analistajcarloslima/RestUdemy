package br.com.jow.request.converter;

public class NumberConverter {
    
	public static double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		// realizar as substituição do ponto por virgula // . é usado por padrão por
		// sistemas para double
		String number = strNumber.replaceAll(",", ".");

		// se number for npumero então vai ocorrer a conversão para double
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 1D;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		// realizar as substituição do ponto por virgula // . é usado por padrão por
		// sistemas para double
		String number = strNumber.replaceAll(",", ".");
		// verificar se o que vai ser retornado é um numero
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}



}
