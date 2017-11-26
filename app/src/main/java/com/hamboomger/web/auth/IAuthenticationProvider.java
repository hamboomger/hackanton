package com.hamboomger.web.auth;

import org.springframework.security.core.Authentication;

/**
 * @author ddorochov
 */
public interface IAuthenticationProvider {
	Authentication getAuthentication();
}
