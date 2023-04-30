package com.example.pet.service;

import java.util.Objects;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.pet.model.Action;
import com.example.pet.model.Pet;
import com.example.pet.model.input.PetInput;
import com.example.pet.repository.PetRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepo;
	
	public Pet createPet(PetInput petInput) {
		log.info("Create a new pet: {}", petInput.toString());
		Pet varPet = new Pet();
		varPet.setName(petInput.getName());
		varPet.setType(petInput.getType());
		varPet.setPosition(petInput.getPosition());
		varPet.setWalk(true);
		varPet.setAction(new Action());
		petRepo.setPet(varPet);
		return varPet;
	}
	
//	private Position generateRandomStartingPosition() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = (int) screenSize.getWidth();
//		int height = (int) screenSize.getHeight();
//		Random random = new Random();
//		int x = random.nextInt(width) + 1;
//		int y = random.nextInt(height) + 1;
//		log.info("position: {}, {}", x, y);
//		return new Position(x, y);
//	}
	
	public Pet getPet() {
		return petRepo.getPet();
	}
	
	public Pet toggleWalk() {
		boolean currentWalk = petRepo.getPet().isWalk(); 
		petRepo.getPet().setWalk(!currentWalk);
		log.info("pet is walking: {}", !currentWalk);
		return petRepo.getPet();
	}
	
	@Scheduled(fixedDelay = 5000)
	public void randomAction() {
		int intAction;
		int min = 1;
		int max = 3;
		Random random = new Random();
		Pet varPet = petRepo.getPet();
		if(!Objects.isNull(varPet) && varPet.isWalk()) {
			intAction = random.nextInt(max - min + 1) + min;
			Action currentAction = new Action();
			switch(intAction) {
			case 1:
				currentAction.setWalkLeft(true);
				varPet.setAction(currentAction);
				break;
			case 2:
				currentAction.setWalkRight(true);
				varPet.setAction(currentAction);
				break;
			case 3:
				currentAction.setStop(true);
				varPet.setAction(currentAction);
				break;
			}
			log.info("pet action: {}", varPet.getAction().toString());
			petRepo.setPet(varPet);
		}
	}
}
