package com.example.pet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

	private String name;
	private String type;
	private boolean walk;
	private Position position;
	private Action action;
}
