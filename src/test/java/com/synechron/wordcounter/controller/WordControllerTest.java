package com.synechron.wordcounter.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synechron.wordcounter.service.WordCounterService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WordControllerTest {

	@InjectMocks
	WordController wordController;
	
	@Mock
	private WordCounterService wordCounterService;
	
	@Test
	public void test() throws Exception {

		Mockito.when(wordCounterService.addWord(ArgumentMatchers.anyString())).thenReturn(true);
		
		assertTrue(wordController.addWords("Hello").getBody().equals("Word Added to Library"));
	}
	
	
	@Test
	public void testGetWordCounts() {

		Mockito.when(wordCounterService.getWordCount(ArgumentMatchers.anyString())).thenReturn(1l);
		
		assertEquals(wordController.getWordCounts("Hello").getStatusCode(), HttpStatus.OK);
	}

}
