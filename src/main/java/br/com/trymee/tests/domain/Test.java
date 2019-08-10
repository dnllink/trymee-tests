package br.com.trymee.tests.domain;

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
@Table(name = "test")
public class Test implements Serializable {

	private static final long serialVersionUID = -7633652179560622642L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_test")
	private Long id;

	@Column(name = "nm_test", length = 100)
	private String name;

	@Column(name = "ds_test", length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "id_level")
	private Level level;

	@Column(name = "qt_question")
	private Long questionQuantity;

	@Column(name = "fg_active")
	private Boolean active = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "test_categories", joinColumns = @JoinColumn(name = "id_test"), inverseJoinColumns = @JoinColumn(name = "id_category"))
	private List<Category> categories = new ArrayList<Category>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "test_question", joinColumns = @JoinColumn(name = "id_test"), inverseJoinColumns = @JoinColumn(name = "id_question"))
	private List<Question> questions = new ArrayList<Question>();

	@Column(name = "dt_creation")
	private LocalDateTime creationDate = LocalDateTime.now();

}