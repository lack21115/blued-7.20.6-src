package java.util.logging;

import android.os.BatteryManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import javax.xml.transform.OutputKeys;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/Handler.class */
public abstract class Handler {
    private static final Level DEFAULT_LEVEL = Level.ALL;
    private ErrorManager errorMan = new ErrorManager();
    private Level level = DEFAULT_LEVEL;
    private String encoding = null;
    private Filter filter = null;
    private Formatter formatter = null;
    private String prefix = getClass().getName();

    private Object getCustomizeInstance(String str) throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = contextClassLoader;
        if (contextClassLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader.loadClass(str).newInstance();
    }

    private Object getDefaultInstance(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str).newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public abstract void close();

    public abstract void flush();

    public String getEncoding() {
        return this.encoding;
    }

    public ErrorManager getErrorManager() {
        LogManager.getLogManager().checkAccess();
        return this.errorMan;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public Formatter getFormatter() {
        return this.formatter;
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initProperties(String str, String str2, String str3, String str4) {
        LogManager logManager = LogManager.getLogManager();
        String property = logManager.getProperty(this.prefix + ".filter");
        if (property != null) {
            try {
                this.filter = (Filter) getCustomizeInstance(property);
            } catch (Exception e) {
                printInvalidPropMessage("filter", property, e);
                this.filter = (Filter) getDefaultInstance(str2);
            }
        } else {
            this.filter = (Filter) getDefaultInstance(str2);
        }
        String property2 = logManager.getProperty(this.prefix + ".level");
        if (property2 != null) {
            try {
                this.level = Level.parse(property2);
            } catch (Exception e2) {
                printInvalidPropMessage(BatteryManager.EXTRA_LEVEL, property2, e2);
                this.level = Level.parse(str);
            }
        } else {
            this.level = Level.parse(str);
        }
        String property3 = logManager.getProperty(this.prefix + ".formatter");
        if (property3 != null) {
            try {
                this.formatter = (Formatter) getCustomizeInstance(property3);
            } catch (Exception e3) {
                printInvalidPropMessage("formatter", property3, e3);
                this.formatter = (Formatter) getDefaultInstance(str3);
            }
        } else {
            this.formatter = (Formatter) getDefaultInstance(str3);
        }
        String property4 = logManager.getProperty(this.prefix + ".encoding");
        try {
            internalSetEncoding(property4);
        } catch (UnsupportedEncodingException e4) {
            printInvalidPropMessage(OutputKeys.ENCODING, property4, e4);
        }
    }

    void internalSetEncoding(String str) throws UnsupportedEncodingException {
        if (str == null) {
            this.encoding = null;
        } else if (!Charset.isSupported(str)) {
            throw new UnsupportedEncodingException(str);
        } else {
            this.encoding = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internalSetFormatter(Formatter formatter) {
        if (formatter == null) {
            throw new NullPointerException("newFormatter == null");
        }
        this.formatter = formatter;
    }

    public boolean isLoggable(LogRecord logRecord) {
        if (logRecord == null) {
            throw new NullPointerException("record == null");
        }
        if (this.level.intValue() != Level.OFF.intValue() && logRecord.getLevel().intValue() >= this.level.intValue()) {
            return this.filter == null || this.filter.isLoggable(logRecord);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void printInvalidPropMessage(String str, String str2, Exception exc) {
        this.errorMan.error("Invalid property value for " + this.prefix + ":" + str + BridgeUtil.SPLIT_MARK + str2, exc, 0);
    }

    public abstract void publish(LogRecord logRecord);

    protected void reportError(String str, Exception exc, int i) {
        this.errorMan.error(str, exc, i);
    }

    public void setEncoding(String str) throws UnsupportedEncodingException {
        LogManager.getLogManager().checkAccess();
        internalSetEncoding(str);
    }

    public void setErrorManager(ErrorManager errorManager) {
        LogManager.getLogManager().checkAccess();
        if (errorManager == null) {
            throw new NullPointerException("newErrorManager == null");
        }
        this.errorMan = errorManager;
    }

    public void setFilter(Filter filter) {
        LogManager.getLogManager().checkAccess();
        this.filter = filter;
    }

    public void setFormatter(Formatter formatter) {
        LogManager.getLogManager().checkAccess();
        internalSetFormatter(formatter);
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("newLevel == null");
        }
        LogManager.getLogManager().checkAccess();
        this.level = level;
    }
}
