package com.onlinetest.beans;


public class ChangePassBean {
	
	public String oldPass;
	public String NewPass;
	public String ConfirmNewPass;
	public String userName;
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return NewPass;
	}
	public void setNewPass(String newPass) {
		NewPass = newPass;
	}
	public String getConfirmNewPass() {
		return ConfirmNewPass;
	}
	public void setConfirmNewPass(String confirmNewPass) {
		ConfirmNewPass = confirmNewPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
