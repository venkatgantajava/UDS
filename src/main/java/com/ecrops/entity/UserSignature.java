package com.ecrops.entity;

public class UserSignature {
	
	  private String userid;
	    private String signature;
	    private String userName;
	    private String divName;

	    
		public UserSignature() {
			super();
		}


		public UserSignature(String userid, String signature) {
			super();
			this.userid = userid;
			this.signature = signature;
		}


		public String getUserid() {
			return userid;
		}


		public void setUserid(String userid) {
			this.userid = userid;
		}


		public String getSignature() {
			return signature;
		}


		public void setSignature(String signature) {
			this.signature = signature;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getDivName() {
			return divName;
		}


		public void setDivName(String divName) {
			this.divName = divName;
		}


		@Override
		public String toString() {
			return "UserSignature [userid=" + userid + ", signature=" + signature + "]";
		}

		
	    
}
