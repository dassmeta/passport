package com.dassmeta.passport.security.principal.impl;

import com.dassmeta.passport.security.principal.Credentials;

public class UsernamePasswordCredentials implements Credentials {
	private static final long serialVersionUID = -8343864967200862794L;
	private String username;
	private String password;

	public final String getPassword() {
		return this.password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getUsername() {
		return this.username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public String toString() {
		return "[username: " + this.username + "]";
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;
		if (this.password != null ? !this.password.equals(that.password) : that.password != null) {
			return false;
		}
		if (this.username != null ? !this.username.equals(that.username) : that.username != null) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		int result = this.username != null ? this.username.hashCode() : 0;
		result = 31 * result + (this.password != null ? this.password.hashCode() : 0);
		return result;
	}
}
