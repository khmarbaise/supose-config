package com.soebes.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Configuration")
@XmlRootElement
public class Configuration {

	private ArrayList<Repository> repositories = new ArrayList<Repository>();
	
	public void setRepositories(ArrayList<Repository> repositories) {
		this.repositories = repositories;
	}

	public ArrayList<Repository> getRepositories() {
		return repositories;
	}
	
	public void addRepository(Repository repository) {
		getRepositories().add(repository);
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
