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
package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.ExpressionElement;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Elemento que imprime determinadas informações sobre o arquivo que está tendo
 * seu nome alterado.
 *
 * @author Renato Costa
 */
public class FileInformationElement extends ExpressionElement {

    public static final String FOLDER = "folder";

    public static final String DATE = "date";

    public static final String SIZE = "size";

    private String mode = DATE;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setParameters(String... content) {
        if (content.length > 0) {
            String mode = content[0];

            if (FOLDER.equals(mode) || DATE.equals(mode) || SIZE.equals(mode)) {
                this.mode = mode;
            } else {
                throw new IllegalArgumentException(
                        Messages.getFilterElementInvalidParametersMessage());
            }
        }
    }

    @Override
    public String getContent(String find, String target, File file) {
        if (DATE.equals(mode)) {
            return sdf.format(new Date(file.lastModified()));
        } else if (FOLDER.equals(mode)) {
            return file.getParentFile().getName();
        } else {
            return new Long(file.length()).toString();
        }
    }

    @Override
    public String[] getParameters() {
        return new String[] {mode};
    }

    @Override
    public void resetState() {
        
    }

}
