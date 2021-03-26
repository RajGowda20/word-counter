package com.synechron.wordcounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.wordcounter.service.WordCounterService;

@RestController
public class WordController {

	@Autowired
	private WordCounterService wordCounterService;

	@PostMapping(path = "/words/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addWords(@PathVariable(name = "word") String addWord) throws Exception {

		boolean wordAdded = wordCounterService.addWord(addWord);
		return wordAdded == true ? new ResponseEntity<>("Word Added to Library", HttpStatus.CREATED)
				: new ResponseEntity<String>("Word not Added", HttpStatus.CONFLICT);
	}

	@GetMapping("/words/count/{word}")
	public ResponseEntity<Long> getWordCounts(@PathVariable(name = "word") String givenWord) {

		Long wordCount = wordCounterService.getWordCount(givenWord);

		return wordCount == null ? new ResponseEntity<Long>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Long>(wordCount, HttpStatus.OK);
	}
}
