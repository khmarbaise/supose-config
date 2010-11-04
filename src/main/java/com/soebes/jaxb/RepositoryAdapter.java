package com.soebes.jaxb;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RepositoryAdapter extends XmlAdapter<Repository, HashMap<String, Repository>> {

	@Override
	public Repository marshal(HashMap<String, Repository> v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Repository> unmarshal(Repository v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}