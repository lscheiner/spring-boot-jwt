package br.com.scheiner.utils;

import java.util.Optional;
import java.util.function.Function;

public interface ConvertUtil<F, T> extends Function<F, T> {
	
	public T convert(final F object);

	@Override
	public default T apply(final F input) {
		return Optional.ofNullable(input).map(this::convert).orElse(null);
	}

}
