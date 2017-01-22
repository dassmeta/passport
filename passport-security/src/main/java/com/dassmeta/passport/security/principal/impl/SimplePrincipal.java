package com.dassmeta.passport.security.principal.impl;

import java.io.Serializable;
import java.security.Principal;
import org.springframework.util.Assert;

public class SimplePrincipal
  implements Principal, Serializable
{
  private static final long serialVersionUID = 1L;
  private final String name;
  
  public SimplePrincipal(String name)
  {
    this.name = name;
    Assert.notNull(name, "name must not be null");
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    return getName();
  }
  
  public boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (!(o instanceof SimplePrincipal)) {
      return false;
    }
    return getName().equals(((SimplePrincipal)o).getName());
  }
  
  public int hashCode()
  {
    return 37 * getName().hashCode();
  }
}
