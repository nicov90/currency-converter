package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Restricts field's input text to numbers only.
 * 
 * @author Nicolas Valdez
 *
 */
public class NumberOnlyDocument extends PlainDocument {
	private static final long serialVersionUID = 1L;

	@Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str != null && str.matches(("^\\d+(\\.\\d+)?$"))) {
            super.insertString(offs, str, a);
        }
    }
}
