package br.com.scheiner.swagger.extension;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LanguageExtension {

    private String lang;
    private String source;
}