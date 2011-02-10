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
import br.com.renatoccosta.renamer.exception.InvalidParameterException;
import br.com.renatoccosta.renamer.i18n.Messages;
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
public class FileInformationElement extends EmptyElement {

    private enum FileInformationEnum {

        FOLDER,
        DATE,
        SIZE

    }

    private FileInformationEnum mode = FileInformationEnum.DATE;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /* ---------------------------------------------------------------------- */

    @Override
    public void setParameter(String name, String value) throws
            InvalidParameterException {
        if ("mode".equals(name)) {
            this.mode = convertModeValue(value);
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String getParameter(String name) throws
            InvalidParameterException {
        if ("mode".equals(name)) {
            return this.mode.toString();
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String[] getParameterValues() {
        return new String[]{mode.toString()};
    }

    @Override
    public String[] getParameterNames() {
        return new String[] {"mode"};
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

    @Override
    public void resetState() {
    }

    /* ---------------------------------------------------------------------- */

    private FileInformationEnum convertModeValue(String value) throws
            InvalidParameterException {
        try {
            return FileInformationEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException(
                    Messages.getCaseElementInvalidParametersMessage());
        }
    }

}
