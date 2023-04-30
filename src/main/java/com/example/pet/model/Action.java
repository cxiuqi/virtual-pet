package com.example.pet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {

	private boolean walkRight;
	private boolean walkLeft;
	private boolean stop;
	
	public Action() {
		this.walkLeft = false;
		this.walkRight = false;
		this.stop = false;
	}
}
