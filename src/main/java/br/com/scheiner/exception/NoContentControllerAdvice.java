package br.com.scheiner.exception;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice
class NoContentControllerAdvice implements ResponseBodyAdvice<List<?>> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		try {

			if (ResponseEntity.class.isAssignableFrom(returnType.getParameterType())) {

				if (returnType != null && returnType.getGenericParameterType() != null) {

					ParameterizedType type = (ParameterizedType) returnType.getGenericParameterType();

					if (type != null && type.getActualTypeArguments() != null
							&& type.getActualTypeArguments()[0] != null
							&& ParameterizedType.class.isAssignableFrom(type.getActualTypeArguments()[0].getClass())) {

						if (((ParameterizedType) type.getActualTypeArguments()[0]).getRawType() instanceof Class) {
							return List.class.isAssignableFrom( (Class<?>) ((ParameterizedType) type.getActualTypeArguments()[0]).getRawType());

						}

					}
				}
			}

		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@Override
	public List<?> beforeBodyWrite(List<?> body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		if (body == null || body.isEmpty()) {
			response.setStatusCode(HttpStatus.NO_CONTENT);
		}
		return body;
	}

	


}
