/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

import hangman.model.English;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.OriginalScore;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {

	@Override
	protected void configure() {
		bind(Language.class).to(English.class);
		bind(HangmanDictionary.class).to(EnglishDictionaryDataSource.class);
		bind(HangmanPanel.class).to(HangmanStickmanPanel.class);
		bind(GameScore.class).to(OriginalScore.class);
	}
}