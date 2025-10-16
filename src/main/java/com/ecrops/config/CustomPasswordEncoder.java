package com.ecrops.config;

import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Service
@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {

		System.out.println(
				"rawpaswword------------------------->" + DigestUtils.sha256Hex((rawPassword.toString().getBytes())));
		return DigestUtils.sha256Hex((rawPassword.toString().getBytes()));

	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		String encodedPassword1 = encode(encodedPassword);

		System.out.println("both are equal------------->" + Objects.equals(rawPassword, encodedPassword1.toString()));
		return Objects.equals(rawPassword.toString(), encodedPassword1.toString());

	}

}