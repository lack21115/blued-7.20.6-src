package javax.sql;

import java.util.EventListener;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/StatementEventListener.class */
public interface StatementEventListener extends EventListener {
    void statementClosed(StatementEvent statementEvent);

    void statementErrorOccurred(StatementEvent statementEvent);
}
