package br.com.scheiner.swagger.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.scheiner.swagger.annotation.CodeSample;
import br.com.scheiner.swagger.extension.CodeSampleVendorExtension;
import br.com.scheiner.swagger.extension.LanguageExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1010)
public class CodeSamplerSwaggerProcessor implements OperationBuilderPlugin {
	
    private final static String X_CODE_SAMPLES = "x-code-samples";


	@Override
	public boolean supports(final DocumentationType documentationType) {
		return DocumentationType.SWAGGER_2.equals(documentationType);
	}

	@Override
	public void apply(final OperationContext operationContext) {
		List<CodeSample> annotations = operationContext.findAllAnnotations(CodeSample.class);
		
		if (!annotations.isEmpty()) {
			
			CodeSample codeSample = annotations.stream().findFirst().get();
			
			var lists = Arrays.asList(codeSample.langs()).stream().map( l -> {
				return LanguageExtension.builder().source(l.source()).lang(l.lang()).build();
			}).collect(Collectors.toList());
			
			final CodeSampleVendorExtension vendorExtension = new CodeSampleVendorExtension(X_CODE_SAMPLES, lists);
			operationContext.operationBuilder().extensions(Collections.singletonList(vendorExtension));
		}
	}
}