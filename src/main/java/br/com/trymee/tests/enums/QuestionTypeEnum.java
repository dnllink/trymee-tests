package br.com.trymee.tests.enums;

import java.io.Serializable;
import java.util.Arrays;

public enum QuestionTypeEnum implements Serializable {

	DISCURSIVA(1, "Discursiva"),
	MULTIPLA_ESCOLHA(2, "Múltipla escolha");

	QuestionTypeEnum(final Integer id, final String description) {
		this.id = id;
		this.description = description;
	}

	private Integer id;
	private String description;

	public static QuestionTypeEnum getById(final Integer id) {
		return Arrays.stream(QuestionTypeEnum.values())
				.filter(questionTypeEnum -> questionTypeEnum.id.equals(id))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(String.format("QuestionType id %s dont exists", id)));
	}
}
