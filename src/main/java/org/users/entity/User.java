package org.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

/*@Setter
@Getter*/
/*@ToString
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
public class User {

	public User() {

	}

	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	@Column(nullable = false)
	private String username;

	@NonNull
	@Column(nullable = false)
	private String email;

	/*
	 * Explanation: (?=.*[a-z]) // at least one lowercase letter (?=.*[A-Z]) // at
	 * least one uppercase letter (?=.*\\d) // at least one digit (?=.*[@$!%*?&]) //
	 * at least one special character [A-Za-z\\d@$!%*?&]{8,}$ // total length at
	 * least 8 characters
	 */

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + ", password='"
				+ password + '\'' + '}';
	}

	@NonNull
	@Column(nullable = false)
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public @NonNull String getUsername() {
		return username;
	}

	public void setUsername(@NonNull String username) {
		this.username = username;
	}

	public @NonNull String getEmail() {
		return email;
	}

	public void setEmail(@NonNull String email) {
		this.email = email;
	}

	public @NonNull String getPassword() {
		return password;
	}

	public void setPassword(@NonNull String password) {
		this.password = password;
	}
}
