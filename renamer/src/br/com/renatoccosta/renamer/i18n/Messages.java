package br.com.renatoccosta.renamer.i18n;

import java.util.ResourceBundle;

/**
 *
 * @author renato
 */
public class Messages {

    private static ResourceBundle messages = ResourceBundle.getBundle(
            "br/com/renatoccosta/renamer/i18n/Messages");

    public static String getExpressionNotFoundMessage(String xpName) {
        return String.format(messages.getString("ExpressionNotFoundException"),
                xpName);
    }

    public static String getReplaceElementInvalidNumberParametersMessage() {
        return messages.getString("ReplaceElementInvalidNumberParametersMessage");
    }

}
