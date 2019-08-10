package br.com.trymee.tests.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "alternatives")
public class Alternative implements Serializable {

	private static final long serialVersionUID = -6331483097957137944L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alternative")
	private Long id;

	@Column(name = "ds_alternative", length = 1000)
	private String description;

	@Column(name = "fg_correct")
	private Boolean correct;

	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;
}