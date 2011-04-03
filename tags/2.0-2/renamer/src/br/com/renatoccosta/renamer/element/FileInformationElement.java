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

import br.com.renatoccosta.renamer.element.base.EmptyElement;
import br.com.renatoccosta.renamer.element.meta.ElementType;
import br.com.renatoccosta.renamer.element.meta.Parameter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Element that prints information about the file that it's being changed
 *
 * e.g.
 * Replace: <file mode='date'/>
 * Result: 2011-01-25
 *
 * @author Renato Costa
 */
@ElementType(id="file",
i18n = "br.com.renatoccosta.renamer.i18n.Messages")
public class FileInformationElement extends EmptyElement {

    public enum FileInformationEnum {

        FOLDER,
        DATE,
        SIZE

    }

    @Parameter
    private FileInformationEnum mode = FileInformationEnum.DATE;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /* ---------------------------------------------------------------------- */

    public FileInformationEnum getMode() {
        return mode;
    }

    public void setMode(FileInformationEnum mode) {
        this.mode = mode;
    }

    /* ---------------------------------------------------------------------- */

    @Override
    public String getContent(String find, String target, File file) {
        switch (mode) {
            case DATE:
                return sdf.format(new Date(file.lastModified()));
            case FOLDER:
                return file.getParentFile().getName();
            case SIZE:
                return new Long(file.length()).toString();
        }

        return "";
    }

}
