package com.amplexor.beans.db;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"description"})
public class DbHost {
	
	private String server;
	
	private int port;
	
	private UserCredentials defaultUser;
	
	private List<Db> databases;
	

	public List<Db> getDatabases() {
		return databases;
	}

	public void setDatabases(List<Db> databases) {
		this.databases = databases;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	@JsonProperty("defaultuser")
	public UserCredentials getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(UserCredentials defaultUser) {
		this.defaultUser = defaultUser;
	}
	
	

}
