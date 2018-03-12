package fr.canalplus.front.bdd.steps.common;

public class SessionDTO implements IDTO {

	private String passId;
	private String __troSYNC;
	private String __troRUID;
	private String cto_lwid;
	private String p_pass_token;
	private String s_pass_token;
	private String s_pass_id; // boutique-recette.mycanal.fr
	private String s_pass_social; // boutique-recette.mycanal.fr
	private String s_pass_userdata; // mycanal.fr
	private String s_token; // .canal-bis.com

	/**
	 * @return the passId
	 */
	public String getPassId() {
		return passId;
	}

	/**
	 * @param passId
	 *            the passId to set
	 */
	public void setPassId(String passId) {
		this.passId = passId;
	}

	/**
	 * @return the __troSYNC
	 */
	public String get__troSYNC() {
		return __troSYNC;
	}

	/**
	 * @param __troSYNC
	 *            the __troSYNC to set
	 */
	public void set__troSYNC(String __troSYNC) {
		this.__troSYNC = __troSYNC;
	}

	/**
	 * @return the __troRUID
	 */
	public String get__troRUID() {
		return __troRUID;
	}

	/**
	 * @param __troRUID
	 *            the __troRUID to set
	 */
	public void set__troRUID(String __troRUID) {
		this.__troRUID = __troRUID;
	}

	/**
	 * @return the cto_lwid
	 */
	public String getCto_lwid() {
		return cto_lwid;
	}

	/**
	 * @param cto_lwid
	 *            the cto_lwid to set
	 */
	public void setCto_lwid(String cto_lwid) {
		this.cto_lwid = cto_lwid;
	}

	/**
	 * @return the p_pass_token
	 */
	public String getP_pass_token() {
		return p_pass_token;
	}

	/**
	 * @param p_pass_token
	 *            the p_pass_token to set
	 */
	public void setP_pass_token(String p_pass_token) {
		this.p_pass_token = p_pass_token;
	}

	/**
	 * @return the s_pass_token
	 */
	public String getS_pass_token() {
		return s_pass_token;
	}

	/**
	 * @param s_pass_token
	 *            the s_pass_token to set
	 */
	public void setS_pass_token(String s_pass_token) {
		this.s_pass_token = s_pass_token;
	}

	/**
	 * @return the s_pass_id
	 */
	public String getS_pass_id() {
		return s_pass_id;
	}

	/**
	 * @param s_pass_id
	 *            the s_pass_id to set
	 */
	public void setS_pass_id(String s_pass_id) {
		this.s_pass_id = s_pass_id;
	}

	/**
	 * @return the s_pass_social
	 */
	public String getS_pass_social() {
		return s_pass_social;
	}

	/**
	 * @param s_pass_social
	 *            the s_pass_social to set
	 */
	public void setS_pass_social(String s_pass_social) {
		this.s_pass_social = s_pass_social;
	}

	/**
	 * @return the s_pass_userdata
	 */
	public String getS_pass_userdata() {
		return s_pass_userdata;
	}

	/**
	 * @param s_pass_userdata
	 *            the s_pass_userdata to set
	 */
	public void setS_pass_userdata(String s_pass_userdata) {
		this.s_pass_userdata = s_pass_userdata;
	}

	/**
	 * @return the s_token
	 */
	public String getS_token() {
		return s_token;
	}

	/**
	 * @param s_token
	 *            the s_token to set
	 */
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}
