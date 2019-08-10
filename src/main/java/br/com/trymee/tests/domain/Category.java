package br.com.trymee.tests.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 7517201126391187844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private Long id;

	@Column(name = "ds_category", length = 100)
	private String description;

	@Column(name = "cd_category", length = 50)
	private String code;
}