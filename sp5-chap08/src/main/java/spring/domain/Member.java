package spring.domain;

import java.time.LocalDateTime;
import spring.exception.WrongPasswordException;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(String email, String password, String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		this.password = newPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
}
