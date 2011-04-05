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
package br.com.renatoccosta.regexrenamer.i18n;

import java.util.ResourceBundle;

/**
 *
 * @author renato
 */
public class Messages {

    private static ResourceBundle bundle = ResourceBundle.getBundle(
            "br/com/renatoccosta/renamer/i18n/Messages");

    /* ---------------------------------------------------------------------- */
    
    public static ResourceBundle getBundle() {
        return bundle;
    }

    public static String getTitle() {
        return bundle.getString("FrmPrincipal.title");
    }

    public static String getFieldValidationMessage() {
        return bundle.getString("FieldValidation");
    }

    public static String getConflictMessage() {
        return bundle.getString("Conflict");
    }

    public static String getExpressionNotFoundMessage(String xpName) {
        return String.format(bundle.getString("ExpressionNotFoundException"),
                xpName);
    }

    public static String getReplaceElementInvalidNumberParametersMessage() {
        return bundle.getString("ReplaceElementInvalidNumberParametersMessage");
    }

    public static String getFilterElementInvalidParametersMessage() {
        return bundle.getString("FilterElementInvalidParametersMessage");
    }

    public static String getCaseElementInvalidParametersMessage() {
        return bundle.getString("CaseElementInvalidParametersMessage");
    }

    public static String getFileInfoElementInvalidParametersMessage() {
        return bundle.getString("FileInfoElementInvalidParametersMessage");
    }

    public static String getInvalidElementMessage(String id) {
        return String.format(bundle.getString("InvalidElementException"),
                id);
    }

    public static String getEmptyElementChildsMessage(String id) {
        return String.format(bundle.getString("EmptyElementChildsException"),
                id);
    }

    public static String getErrorCaption() {
        return bundle.getString("Error");
    }

    public static String getSaveCaption() {
        return bundle.getString("FrmPrincipal.mnuSalvar.text");
    }

    public static String getNotReadyMessage() {
        return bundle.getString("NotReady");
    }

    public static String getFileNotFoundMessage() {
        return bundle.getString("FileNotFound");
    }

    public static String getConfirmRenameMessage() {
        return bundle.getString("ConfirmRename");
    }

    public static String getConfirmReplaceMessage(String fileName) {
        return String.format(bundle.getString("ConfirmReplace"), fileName);
    }

    public static String getOutOfBoundsMessage() {
        return bundle.getString("OutOfBoundsMessage");
    }

    public static String getContiguousSelectionMessage() {
        return bundle.getString("ContiguousSelectionMessage");
    }

    public static String getErrorRenamingMessage() {
        return bundle.getString("ErrorRenaming");
    }

    public static String getErrorRenamingFilesMessage() {
        return bundle.getString("ErrorRenamingFiles");
    }

    public static String getParameterWrongDataTypeInteger(String paramName) {
        return String.format(bundle.getString(
                "ParameterWrongDataTypeInteger"), paramName);
    }

    public static String getInvalidParameterName(String paramName) {
        return String.format(bundle.getString("InvalidParameterName"),
                paramName);
    }

    public static String getInvalidParameterValue(String paramName) {
        return String.format(bundle.getString("InvalidParameterValue"),
                paramName);
    }

}
