package com.game.hangman.application.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.hangman.application.initservice.InitService;
import com.game.hangman.application.util.Constant;

@RestController
public class Controller {

	@GetMapping("/getword")
	public String getWord() {
		int randomIndex = ThreadLocalRandom.current().nextInt(Constant.ZERO, InitService.getWordsListSize());
		return InitService.getWordsList().get(randomIndex);
	}
}
