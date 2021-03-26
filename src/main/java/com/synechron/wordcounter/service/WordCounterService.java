package com.synechron.wordcounter.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.wordcounter.utility.Translator;

@Service
public class WordCounterService {

	/**
	 * Considering the static storage mechanism, as requested not to use any
	 * Database storage
	 */

	private static Map<String, Long> wordLibrary = new HashMap<>();

	@Autowired
	private Translator translator;

	public boolean addWord(String word) throws Exception {

		validate(word);

		String givenWord = translator.translate(word);

		boolean flag = false;

		if (wordLibrary.containsKey(givenWord)) {
			Long count = wordLibrary.get(givenWord);
			wordLibrary.put(givenWord, ++count);
			flag = true;
		} else {
			wordLibrary.put(givenWord, 1l);
			flag = true;
		}

		return flag;
	}

	public void validate(String word) throws Exception {

		boolean result = Pattern.matches("^[a-zA-Z]*$", word);

		if (!result) {
			throw new IllegalArgumentException("Only Alphabets allowed");
		}
	}

	public Long getWordCount(String givenWord) {

		Long count = wordLibrary.get(givenWord);

		return count;

	}

}
