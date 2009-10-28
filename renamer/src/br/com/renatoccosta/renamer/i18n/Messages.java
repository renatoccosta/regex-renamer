package br.com.renatoccosta.renamer.i18n;

import java.util.ResourceBundle;

/**
 *
 * @author renato
 */
public class Messages {

    private static ResourceBundle messages = ResourceBundle.getBundle(
            "br/com/renatoccosta/renamer/i18n/Messages");

    public static String getFieldValidationMessage() {
        return messages.getString("FieldValidation");
    }

    public static String getConflictMessage() {
        return messages.getString("Conflict");
    }

    public static String getExpressionNotFoundMessage(String xpName) {
        return String.format(messages.getString("ExpressionNotFoundException"),
                xpName);
    }

    public static String getReplaceElementInvalidNumberParametersMessage() {
        return messages.getString("ReplaceElementInvalidNumberParametersMessage");
    }

    public static String getFilterElementInvalidParametersMessage() {
        return messages.getString("FilterElementInvalidParametersMessage");
    }

    public static String getCaseElementInvalidParametersMessage() {
        return messages.getString("CaseElementInvalidParametersMessage");
    }

    public static String getInvalidElementMessage(String id) {
        return String.format(messages.getString("InvalidElementException"),
                id);
    }

    public static String getSaveCaption() {
        return messages.getString("FrmPrincipal.mnuSalvar.text");
    }

    public static String getNotReadyMessage() {
        return messages.getString("NotReady");
    }

}
