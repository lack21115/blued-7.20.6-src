package java.util.logging;

import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/LoggingMXBean.class */
public interface LoggingMXBean {
    String getLoggerLevel(String str);

    List<String> getLoggerNames();

    String getParentLoggerName(String str);

    void setLoggerLevel(String str, String str2);
}
