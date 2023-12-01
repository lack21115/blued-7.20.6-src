package java.sql;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLClientInfoException.class */
public class SQLClientInfoException extends SQLException {
    private static final long serialVersionUID = -4319604256824655880L;
    private final Map<String, ClientInfoStatus> failedProperties;

    public SQLClientInfoException() {
        this.failedProperties = null;
    }

    public SQLClientInfoException(String str, String str2, int i, Map<String, ClientInfoStatus> map) {
        super(str, str2, i);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(String str, String str2, int i, Map<String, ClientInfoStatus> map, Throwable th) {
        super(str, str2, i, th);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(String str, String str2, Map<String, ClientInfoStatus> map) {
        super(str, str2);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(String str, String str2, Map<String, ClientInfoStatus> map, Throwable th) {
        super(str, str2, th);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(String str, Map<String, ClientInfoStatus> map) {
        super(str);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(String str, Map<String, ClientInfoStatus> map, Throwable th) {
        super(str, th);
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(Map<String, ClientInfoStatus> map) {
        this.failedProperties = new HashMap(map);
    }

    public SQLClientInfoException(Map<String, ClientInfoStatus> map, Throwable th) {
        super(th);
        this.failedProperties = new HashMap(map);
    }

    public Map<String, ClientInfoStatus> getFailedProperties() {
        return this.failedProperties;
    }
}
