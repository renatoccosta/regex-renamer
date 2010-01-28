/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer.i18n;

import java.util.ResourceBundle;

/**
 *
 * @author renato
 */
public class Messages {

    private static ResourceBundle messages = ResourceBundle.getBundle(
            "br/com/renatoccosta/renamer/i18n/Messages");

    public static String getTitle() {
        return messages.getString("FrmPrincipal.title");
    }

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

    public static String getFileInfoElementInvalidParametersMessage() {
        return messages.getString("FileInfoElementInvalidParametersMessage");
    }

    public static String getInvalidElementMessage(String id) {
        return String.format(messages.getString("InvalidElementException"),
                id);
    }

    public static String getErrorCaption() {
        return messages.getString("Error");
    }

    public static String getSaveCaption() {
        return messages.getString("FrmPrincipal.mnuSalvar.text");
    }

    public static String getNotReadyMessage() {
        return messages.getString("NotReady");
    }

    public static String getFileNotFoundMessage() {
        return messages.getString("FileNotFound");
    }

    public static String getConfirmRenameMessage() {
        return messages.getString("ConfirmRename");
    }

    public static String getConfirmReplaceMessage(String fileName) {
        return String.format(messages.getString("ConfirmReplace"), fileName);
    }

    public static String getOutOfBoundsMessage() {
        return messages.getString("OutOfBoundsMessage");
    }

    public static String getContiguousSelectionMessage() {
        return messages.getString("ContiguousSelectionMessage");
    }

    public static String getErrorRenamingMessage() {
        return messages.getString("ErrorRenaming");
    }

    public static String getErrorRenamingFilesMessage() {
        return messages.getString("ErrorRenamingFiles");
    }

}
