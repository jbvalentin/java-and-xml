package model.db;

import java.time.Duration;
import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.DurationDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.PeriodKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import model.db.ser.PeriodDeserializer;
import model.db.ser.PeriodSerializer;

@JsonIgnoreProperties({"description"})
public class DbHost {
	
	private String server;
	
	private int port;
	
	private UserCredentials defaultUser;
	
	private List<Db> databases;

	@JsonDeserialize(using = DurationDeserializer.class)
	private Duration timeoutDuration;

	@JsonDeserialize(using = PeriodDeserializer.class)
	@JsonSerialize(using = PeriodSerializer.class)
	private Period licenseDuration;


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


	public Duration getTimeoutDuration() {
		return timeoutDuration;
	}

	public void setTimeoutDuration(Duration timeoutDuration) {
		this.timeoutDuration = timeoutDuration;
	}

	public Period getLicenseDuration() {
		return licenseDuration;
	}

	public void setLicenseDuration(Period licenseDuration) {
		this.licenseDuration = licenseDuration;
	}
}
