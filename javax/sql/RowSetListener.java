package javax.sql;

import java.util.EventListener;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/RowSetListener.class */
public interface RowSetListener extends EventListener {
    void cursorMoved(RowSetEvent rowSetEvent);

    void rowChanged(RowSetEvent rowSetEvent);

    void rowSetChanged(RowSetEvent rowSetEvent);
}
