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
import br.com.renatoccosta.renamer.element.meta.MetaElement;
import br.com.renatoccosta.renamer.i18n.Messages;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Renato Costa
 */
public class ElementParametersTableModel extends AbstractTableModel {

    private MetaElement me;

    private String[] columnNames = new String[]{
        Messages.getBundle().getString("parameter.name"),
        Messages.getBundle().getString("parameter.value")};

    /* ---------------------------------------------------------------------- */
    public ElementParametersTableModel(Class<Element> elementClazz) {
        this.me = new MetaElement(elementClazz);
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
        return me.getParams().size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            //column titles
            return me.getParams().get(rowIndex).getCaption();
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

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    public Class<?> getCellClass(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            //column titles
            return me.getParams().get(rowIndex).getField().getType();
        } else {
            //column values
            return String.class;
        }
    }

    /* ---------------------------------------------------------------------- */
}
