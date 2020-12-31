package com.demo.thymeleafdemo.entity;

import com.demo.thymeleafdemo.audit.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Auditable<String> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull
	@Size(min=2, message="First Name should have atleast 2 characters")
	@Column(name="first_name",length = 64)
	private String firstName;


	@Column(name="last_name",length = 64)
	private String lastName;
	@NotNull
	@Column(name="email",length = 128)
	private String email;

}











