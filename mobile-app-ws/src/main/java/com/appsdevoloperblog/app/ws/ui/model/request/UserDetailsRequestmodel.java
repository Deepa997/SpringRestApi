package com.appsdevoloperblog.app.ws.ui.model.request;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class UserDetailsRequestmodel {
	@NotNull(message="firstname can not be null")
@Size(min=2,message="must have two characted")
	private String firstname;
	@NotNull(message="lastname can not be null")

	private String lastname;
	@NotNull(message="email can not be null")
@Email
	private String email;
	@NotNull(message="password cn not be null")
@Size(min=8,max=16, message="password shuld be greter that or ewual to 8 character")
	private String password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
