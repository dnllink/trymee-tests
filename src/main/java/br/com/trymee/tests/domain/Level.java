package br.com.trymee.tests.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "levels")
public class Level implements Serializable {

	private static final long serialVersionUID = 5648181350092378603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_level")
	private Long id;

	@Column(name = "ds_level", length = 100)
	private String description;

	@Column(name = "cd_level", length = 50)
	private String code;
}