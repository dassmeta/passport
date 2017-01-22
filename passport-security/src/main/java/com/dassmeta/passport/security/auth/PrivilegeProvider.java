package com.dassmeta.passport.security.auth;

public abstract interface PrivilegeProvider
{
  public abstract boolean isNoControlResource(String paramString);
  
  public abstract String getPrivilegeFailureURL();
  
  public abstract boolean privilege(String paramString);
}
