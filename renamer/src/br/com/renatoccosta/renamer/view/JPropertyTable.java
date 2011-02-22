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

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * Table that can have different data types for each cell. It is possible by
 * acessing the method <code>ElementParametersTableModel.getCellClass(col, row)</code>
 * if the model is of this specific class.
 * 
 * This table also create an <code>EnumEditor</code> that displays a combobox
 * with the enumeration items of the cell's data type.
 * 
 * @author Renato Costa
 */
public class JPropertyTable extends JTable {

    static class EnumEditor extends DefaultCellEditor {

        public EnumEditor() {
            super(new JComboBox());
        }

        public void setEnum(Class<Enum> enumClass) {
            JComboBox combo = (JComboBox) editorComponent;
            combo.removeAllItems();

            Enum[] es = enumClass.getEnumConstants();

            for (Enum enumeration : es) {
                combo.addItem(enumeration);
            }
        }

    }

    /* ---------------------------------------------------------------------- */
    public JPropertyTable(TableModel dm, TableColumnModel cm,
            ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    public JPropertyTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    public JPropertyTable(TableModel dm) {
        super(dm);
    }

    public JPropertyTable() {
        super();
    }

    /* ---------------------------------------------------------------------- */
    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        TableColumn tableColumn = getColumnModel().getColumn(column);
        TableCellEditor editor = tableColumn.getCellEditor();

        if (editor == null) {
            TableModel model = getModel();
            Class<?> clazz;

            if (model instanceof ElementParametersTableModel) {
                clazz = ((ElementParametersTableModel) model).getCellClass(
                        convertRowIndexToModel(row),
                        convertColumnIndexToModel(column));
            } else {
                clazz = getColumnClass(column);
            }

            editor = getDefaultEditor(clazz);

            if (editor instanceof EnumEditor) {
                EnumEditor ee = (EnumEditor) editor;
                ee.setEnum((Class<Enum>) clazz);
            }

        }

        return editor;
    }

    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {
        TableColumn tableColumn = getColumnModel().getColumn(column);
        TableCellRenderer renderer = tableColumn.getCellRenderer();

        if (renderer == null) {
            TableModel model = getModel();

            if (model instanceof ElementParametersTableModel) {
                renderer = getDefaultRenderer(
                        ((ElementParametersTableModel) model).getCellClass(
                        row, column));
            } else {
                renderer = getDefaultRenderer(getColumnClass(column));
            }
        }

        return renderer;
    }

    /* ---------------------------------------------------------------------- */
    @Override
    protected void createDefaultEditors() {
        super.createDefaultEditors();

        // Enumerations
        setDefaultEditor(Enum.class, new EnumEditor());
    }

}
