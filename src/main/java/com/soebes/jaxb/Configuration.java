package com.soebes.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement
public class Configuration {

	private ArrayList<Repository> repositories = new ArrayList<Repository>();
	
	public void setRepositories(ArrayList<Repository> repositories) {
		this.repositories = repositories;
	}

	@XmlElementWrapper(name = "repositories") 
	@XmlElement(name = "repository") 
	public ArrayList<Repository> getRepositories() {
		return repositories;
	}
	
	public void addRepository(Repository repository) {
		getRepositories().add(repository);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((repositories == null) ? 0 : repositories.hashCode());
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
		Configuration other = (Configuration) obj;
		if (repositories == null) {
			if (other.repositories != null)
				return false;
		} else if (!repositories.equals(other.repositories))
			return false;
		return true;
	}

}
