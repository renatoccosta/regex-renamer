/*
 *  Copyright 2011 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.element.base.Element;
import br.com.renatoccosta.renamer.element.meta.Parameter;
import br.com.renatoccosta.renamer.i18n.Messages;
import br.com.renatoccosta.renamer.util.AnnotationsUtil;
import java.lang.reflect.Field;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Renato Costa
 */
public class ElementParametersTableModel extends AbstractTableModel {

    private Class<Element> elementClazz;

    private Field[] parameters;

    private String[] columnNames = new String[]{
        Messages.getBundle().getString("parameter.name"),
        Messages.getBundle().getString("parameter.value")};

    /* ---------------------------------------------------------------------- */
    public ElementParametersTableModel(Class<Element> elementClazz) {
        this.elementClazz = elementClazz;
        parameters = AnnotationsUtil.extractAnnotatedFields(elementClazz,
                Parameter.class);
    }

    /* ---------------------------------------------------------------------- */
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return parameters.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            //column titles
            Field f = parameters[rowIndex];
            Parameter p = f.getAnnotation(Parameter.class);
            return p.caption().equals("") ? f.getName() : p.caption();
        } else {
            //column values
            return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    /* ---------------------------------------------------------------------- */
}
