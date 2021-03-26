package com.synechron.wordcounter.utility;

import org.springframework.stereotype.Component;

/**
 * For the simplicity of the task assuming that translation of words will be
 * done via external class provided to you called "Translator" that will have
 * method "translate" accepting word as an argument and it will return English
 * name for it.
 */

@Component
public class Translator {

	public String translate(String word) {

		/**
		 * Code to Translate
		 */
		return word;
	}

}
