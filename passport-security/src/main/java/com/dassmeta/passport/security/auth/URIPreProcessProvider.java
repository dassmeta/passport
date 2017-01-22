package com.dassmeta.passport.security.auth;

public abstract interface URIPreProcessProvider
{
  public abstract String process(String paramString);
  
  public abstract void setProcessors(URIPreProcessor[] paramArrayOfURIPreProcessor);
}
