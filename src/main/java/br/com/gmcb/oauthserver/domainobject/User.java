package br.com.gmcb.oauthserver.domainobject;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "user")
@SQLDelete(sql = "update user set deleted_date = now() where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_date is null")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	public User(String email, String password){
		
		this.email = email;
		this.password = password;
		this.enabled = true;
		this.nonLocked = true;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique=true)
	@Email(message = "Invalid email address")
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(nullable = false)
	private Boolean nonLocked;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	@Column(nullable = true)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime deletedDate;

}
