package com.soebes.jaxb;

import java.net.URI;

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
