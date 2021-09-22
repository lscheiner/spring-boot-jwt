package br.com.scheiner.swagger.extension;

import java.util.List;

import lombok.AllArgsConstructor;
import springfox.documentation.service.VendorExtension;

@AllArgsConstructor
public class CodeSampleVendorExtension implements VendorExtension<List<LanguageExtension>> {

	private String name;
	private List<LanguageExtension> value;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<LanguageExtension> getValue() {
		return value;
	}

}
