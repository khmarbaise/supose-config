package com.soebes.jaxb;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {

	private URI uri;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	public URI getUri() {
		return uri;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repository other = (Repository) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
//	[JaGoSI]
//	 url = http://svn.traveler/jagosi
//	 fromrev = 1
//	 torev = HEAD
//	 indexusername = kama
//	 indexpassword = kama
//	 result = result
//
//	 [SupoSE]
//	 url = http://svn.traveler/supose
//	 fromrev = 1
//	 torev = HEAD
//	 indexusername = kama
//	 indexpassword = kama
//	 result = result
//
//	 [AntSVK]
//	 url = http://svn.traveler/antsvk
//	 fromrev = 1
//	 torev = HEAD
//	 indexusername = kama
//	 indexpassword = kama
//	 result = result
//
//	 [GForge]
//	 url = http://svn.traveler/gforge
//	 fromrev = 1
//	 torev = HEAD
//	 indexusername = kama
//	 indexpassword = kama
//	 result = result

}
