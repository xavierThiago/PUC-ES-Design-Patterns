package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public class LegacyDatabasePriceProvider implements PriceProvider {

	public float getConvertionFactor(String source, String target) {
		//db connection and query about the conversion factor
		return 1.2f;
	}

}
