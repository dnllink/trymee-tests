package br.com.trymee.tests.domain;

import br.com.trymee.tests.enums.QuestionTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "questions")
public class Question implements Serializable {

	private static final long serialVersionUID = -4757793179238107895L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_question")
	private Long id;

	@Column(name = "ds_question", length = 1000)
	private String description;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "cd_type")
	private QuestionTypeEnum type;

	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "id_level")
	private Level level;

	@Column(name = "ds_answer", length = 1000)
	private String answer;

	@Column(name = "nm_link", length = 200)
	private String imageLink;

	@Column(name = "fg_active")
	private Boolean active = true;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "question")
	private List<Alternative> alternatives = new ArrayList<>();

	@Column(name = "dt_creation")
	private LocalDateTime creationDate = LocalDateTime.now();

	public void addAlternative(final Alternative alternative) {
		alternative.setQuestion(this);
		this.alternatives.add(alternative);
	}
}