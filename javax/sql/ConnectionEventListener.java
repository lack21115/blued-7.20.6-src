package javax.sql;

import java.util.EventListener;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/ConnectionEventListener.class */
public interface ConnectionEventListener extends EventListener {
    void connectionClosed(ConnectionEvent connectionEvent);

    void connectionErrorOccurred(ConnectionEvent connectionEvent);
}
