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
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Renato Costa
 */
public class JPropertyTable extends JTable {

    static class EnumEditor extends DefaultCellEditor {

        public EnumEditor() {
            super(new JCheckBox());
            JCheckBox checkBox = (JCheckBox) getComponent();
            checkBox.setHorizontalAlignment(JCheckBox.CENTER);
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

            if (model instanceof ElementParametersTableModel) {
                editor = getDefaultEditor(
                        ((ElementParametersTableModel) model).getCellClass(
                        row, column));
            } else {
                editor = getDefaultEditor(getColumnClass(column));
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

}
