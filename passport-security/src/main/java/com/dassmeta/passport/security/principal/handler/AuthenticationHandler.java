package com.dassmeta.passport.security.principal.handler;

import com.dassmeta.passport.security.auth.exception.AuthenticationException;
import com.dassmeta.passport.security.principal.Credentials;

public abstract interface AuthenticationHandler {
	public abstract boolean authenticate(Credentials paramCredentials) throws AuthenticationException;

	public abstract boolean supports(Credentials paramCredentials);
}
