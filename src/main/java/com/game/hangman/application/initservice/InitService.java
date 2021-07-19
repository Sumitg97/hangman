package com.game.hangman.application.initservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InitService {

	private static List<String> wordsList = Collections.synchronizedList(new ArrayList<>());

	@PostConstruct
	public void init() {
		// read file and initialize map
		String base = System.getProperty("user.dir");
		try (Stream<String> stream = Files.lines(Paths.get(base + "/data/words.txt"))) {
			stream.forEach(str -> wordsList.add(str));
			log.info("{} words read successfully", wordsList.size());
		} catch (IOException e) {
			log.error("Error occurred while reading dictionary file", e);
		}
	}

	public static List<String> getWordsList() {
		return wordsList;
	}

	public static void setWordsList(List<String> wordsList) {
		InitService.wordsList = wordsList;
	}

	public static int getWordsListSize() {
		return wordsList.size();
	}
	
}