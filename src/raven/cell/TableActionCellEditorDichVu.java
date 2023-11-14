package raven.cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditorDichVu extends DefaultCellEditor {

    private TableActionEvent event;

    public TableActionCellEditorDichVu(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionDichVu action = new PanelActionDichVu();
//        action.cmdEdit.setVisible(false);
//        action.cmdView.setVisible(false);
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
