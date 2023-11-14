package raven.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onSubtract(int row);

    public void onDelete(int row);

    public void onAdd(int row);
}
