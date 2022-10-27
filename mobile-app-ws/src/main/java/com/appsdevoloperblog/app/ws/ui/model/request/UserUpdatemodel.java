package com.appsdevoloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdatemodel {
	@NotNull(message="firstname can not be null")
	@Size(min=2,message="must have two characted")
		private String firstname;
		@NotNull(message="lastname can not be null")

		private String lastname;
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		

}
