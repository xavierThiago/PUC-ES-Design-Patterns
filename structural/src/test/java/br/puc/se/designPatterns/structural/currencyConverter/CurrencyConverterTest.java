package br.puc.se.designPatterns.structural.currencyConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.puc.se.designPatterns.structural.currencyConverter.legacy.LegacyCurrencyConverterService;

public class CurrencyConverterTest {

	@Test
	public void legacyConvertionTest() {
		LegacyCurrencyConverterService service = new LegacyCurrencyConverterService();
		float converted = service.convert(100.f, "USD", "BRL");
		assertEquals(converted, 340f, 0.001f);
	}
	
	@Test
	public void adptedVersionConvertionTest() {
		CurrencyValue value = new CurrencyValue(100f, "USD");
		String targetCurrency = "BRL";
		CurrencyConverterService service = new CurrencyConverterService();
		service.setOnlineProvider((from, to) -> 3.6f);
		CurrencyValue converted = service.convert(value, targetCurrency );
		assertEquals(converted.getValue(), 360f, 0.001f);
	}
}
