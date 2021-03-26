package com.synechron.wordcounter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synechron.wordcounter.utility.Translator;

@RunWith(SpringJUnit4ClassRunner.class)
public class WordCounterServiceTest {

	@InjectMocks
	@Spy
	WordCounterService wordCounterService;

	@Mock
	private Translator translator;

	@Mock
	private static Map<String, Long> wordLibrary;

	@Test
	public void testAddWord() throws Exception {

		Mockito.when(translator.translate(ArgumentMatchers.anyString())).thenReturn("Hello");

		assertEquals(wordCounterService.addWord("Hello"), true);
	}

	@Test
	public void testValidate() throws Exception {

		wordCounterService.validate("Hello");

		verify(wordCounterService, times(1)).validate(ArgumentMatchers.anyString());

	}

	@Test
	public void testGetWordCount() {

		when(wordLibrary.get(ArgumentMatchers.anyString())).thenReturn(1l);
		assertEquals(wordCounterService.getWordCount("Hello"), 1l);

	}

}
