package GUI;

import java.util.Locale;
import java.util.ResourceBundle;

public class HSAlbSigEditorMain {
	
	public static void main(String[] args) {
		Locale locale;
		ResourceBundle messages;
		String language, country;
		if ( args . length != 2) {
			language = new String ("en");
			country = new String ("US");
		} else {
			language = new String ( args [0]) ;
			country = new String ( args [1]) ;
		}
		locale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", locale);
		HSAlbSigEditor gui = new HSAlbSigEditor(messages);
		gui.open();

	}

}
