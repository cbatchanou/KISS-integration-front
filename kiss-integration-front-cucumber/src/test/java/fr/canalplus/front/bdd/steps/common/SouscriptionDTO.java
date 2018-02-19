package fr.canalplus.front.bdd.steps.common;

public class SouscriptionDTO implements IDTO {

	private String browserName;
	
	private Integer sessionId;
	
	
	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public void reset() {
		browserName = null;
		sessionId = null;
	}

}
