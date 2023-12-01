package javax.sql;

import java.io.Serializable;
import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/RowSetEvent.class */
public class RowSetEvent extends EventObject implements Serializable {
    private static final long serialVersionUID = -1875450876546332005L;

    public RowSetEvent(RowSet rowSet) {
        super(rowSet);
    }
}
