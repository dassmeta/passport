package com.dassmeta.passport.security.auth;

public abstract interface URIPreProcessor {
	public abstract String process(String paramString);

	public abstract void setPattern(String paramString);

	public abstract String getPattern();

	public abstract void setIgnoreException(boolean paramBoolean);

	public abstract boolean isIgnoreException();
}
