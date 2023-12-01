package java.util.logging;

import com.alipay.sdk.util.i;
import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/Logger.class */
public class Logger {
    private final String androidTag;
    private Filter filter;
    volatile Level levelObjVal;
    private volatile String name;
    Logger parent;
    private volatile ResourceBundle resourceBundle;
    private volatile String resourceBundleName;
    private static final DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() { // from class: java.util.logging.Logger.1
        @Override // dalvik.system.DalvikLogHandler
        public void publish(Logger logger, String str, Level level, String str2) {
            LogRecord logRecord = new LogRecord(level, str2);
            logRecord.setLoggerName(logger.name);
            logger.setResourceBundle(logRecord);
            logger.log(logRecord);
        }
    };
    public static final String GLOBAL_LOGGER_NAME = "global";
    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
    volatile int levelIntVal = Level.INFO.intValue();
    private final List<Handler> handlers = new CopyOnWriteArrayList();
    private boolean notifyParentHandlers = true;
    private boolean isNamed = true;
    final List<Logger> children = new ArrayList();
    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;

    /* JADX INFO: Access modifiers changed from: protected */
    public Logger(String str, String str2) {
        this.name = str;
        initResourceBundle(str2);
        this.androidTag = DalvikLogging.loggerNameToTag(str);
        updateDalvikLogHandler();
    }

    public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    public static Logger getAnonymousLogger(String str) {
        Logger logger = new Logger(null, str);
        logger.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(logger, logManager.getLogger(""));
        return logger;
    }

    public static Logger getGlobal() {
        return global;
    }

    public static Logger getLogger(String str) {
        return LogManager.getLogManager().getOrCreate(str, null);
    }

    public static Logger getLogger(String str, String str2) {
        Logger orCreate = LogManager.getLogManager().getOrCreate(str, str2);
        orCreate.initResourceBundle(str2);
        return orCreate;
    }

    private void initResourceBundle(String str) {
        synchronized (this) {
            String str2 = this.resourceBundleName;
            if (str2 != null) {
                if (!str2.equals(str)) {
                    throw new IllegalArgumentException("Resource bundle name '" + str + "' is inconsistent with the existing '" + str2 + "'");
                }
            } else if (str != null) {
                this.resourceBundle = loadResourceBundle(str);
                this.resourceBundleName = str;
            }
        }
    }

    private boolean internalIsLoggable(Level level) {
        int i = this.levelIntVal;
        return i != Level.OFF.intValue() && level.intValue() >= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResourceBundle loadResourceBundle(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return ResourceBundle.getBundle(str, Locale.getDefault(), contextClassLoader);
            } catch (MissingResourceException e) {
            }
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                return ResourceBundle.getBundle(str, Locale.getDefault(), systemClassLoader);
            } catch (MissingResourceException e2) {
            }
        }
        throw new MissingResourceException("Failed to load the specified resource bundle \"" + str + "\"", str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceBundle(LogRecord logRecord) {
        Logger logger = this;
        while (true) {
            Logger logger2 = logger;
            if (logger2 == null) {
                return;
            }
            String str = logger2.resourceBundleName;
            if (str != null) {
                logRecord.setResourceBundle(logger2.resourceBundle);
                logRecord.setResourceBundleName(str);
                return;
            }
            logger = logger2.parent;
        }
    }

    public void addHandler(Handler handler) {
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        this.handlers.add(handler);
        updateDalvikLogHandler();
    }

    public void config(String str) {
        log(Level.CONFIG, str);
    }

    public void entering(String str, String str2) {
        if (internalIsLoggable(Level.FINER)) {
            LogRecord logRecord = new LogRecord(Level.FINER, "ENTRY");
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void entering(String str, String str2, Object obj) {
        if (internalIsLoggable(Level.FINER)) {
            LogRecord logRecord = new LogRecord(Level.FINER, "ENTRY {0}");
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(new Object[]{obj});
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void entering(String str, String str2, Object[] objArr) {
        if (internalIsLoggable(Level.FINER)) {
            String str3 = "ENTRY";
            if (objArr != null) {
                StringBuilder sb = new StringBuilder("ENTRY");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        break;
                    }
                    sb.append(" {").append(i2).append(i.d);
                    i = i2 + 1;
                }
                str3 = sb.toString();
            }
            LogRecord logRecord = new LogRecord(Level.FINER, str3);
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(objArr);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void exiting(String str, String str2) {
        if (internalIsLoggable(Level.FINER)) {
            LogRecord logRecord = new LogRecord(Level.FINER, "RETURN");
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void exiting(String str, String str2, Object obj) {
        if (internalIsLoggable(Level.FINER)) {
            LogRecord logRecord = new LogRecord(Level.FINER, "RETURN {0}");
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(new Object[]{obj});
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void fine(String str) {
        log(Level.FINE, str);
    }

    public void finer(String str) {
        log(Level.FINER, str);
    }

    public void finest(String str) {
        log(Level.FINEST, str);
    }

    public Filter getFilter() {
        return this.filter;
    }

    public Handler[] getHandlers() {
        return (Handler[]) this.handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    public Level getLevel() {
        return this.levelObjVal;
    }

    public String getName() {
        return this.name;
    }

    public Logger getParent() {
        return this.parent;
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public boolean getUseParentHandlers() {
        return this.notifyParentHandlers;
    }

    public void info(String str) {
        log(Level.INFO, str);
    }

    public boolean isLoggable(Level level) {
        return internalIsLoggable(level);
    }

    public void log(Level level, String str) {
        if (internalIsLoggable(level)) {
            this.dalvikLogHandler.publish(this, this.androidTag, level, str);
        }
    }

    public void log(Level level, String str, Object obj) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str);
            logRecord.setLoggerName(this.name);
            logRecord.setParameters(new Object[]{obj});
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void log(Level level, String str, Throwable th) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str);
            logRecord.setLoggerName(this.name);
            logRecord.setThrown(th);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void log(Level level, String str, Object[] objArr) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str);
            logRecord.setLoggerName(this.name);
            logRecord.setParameters(objArr);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void log(LogRecord logRecord) {
        if (!internalIsLoggable(logRecord.getLevel())) {
            return;
        }
        Filter filter = this.filter;
        if (filter != null && !filter.isLoggable(logRecord)) {
            return;
        }
        Handler[] handlers = getHandlers();
        int length = handlers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            handlers[i2].publish(logRecord);
            i = i2 + 1;
        }
        Logger logger = this;
        Logger logger2 = logger.parent;
        while (true) {
            Logger logger3 = logger2;
            if (logger3 == null || !logger.getUseParentHandlers()) {
                return;
            }
            Handler[] handlers2 = logger3.getHandlers();
            int length2 = handlers2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    handlers2[i4].publish(logRecord);
                    i3 = i4 + 1;
                }
            }
            logger = logger3;
            logger2 = logger3.parent;
        }
    }

    public void logp(Level level, String str, String str2, String str3) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str3);
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void logp(Level level, String str, String str2, String str3, Object obj) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str3);
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(new Object[]{obj});
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void logp(Level level, String str, String str2, String str3, Throwable th) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str3);
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setThrown(th);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void logp(Level level, String str, String str2, String str3, Object[] objArr) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str3);
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(objArr);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    public void logrb(Level level, String str, String str2, String str3, String str4) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str4);
            if (str3 != null) {
                try {
                    logRecord.setResourceBundle(loadResourceBundle(str3));
                } catch (MissingResourceException e) {
                }
                logRecord.setResourceBundleName(str3);
            }
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            log(logRecord);
        }
    }

    public void logrb(Level level, String str, String str2, String str3, String str4, Object obj) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str4);
            if (str3 != null) {
                try {
                    logRecord.setResourceBundle(loadResourceBundle(str3));
                } catch (MissingResourceException e) {
                }
                logRecord.setResourceBundleName(str3);
            }
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(new Object[]{obj});
            log(logRecord);
        }
    }

    public void logrb(Level level, String str, String str2, String str3, String str4, Throwable th) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str4);
            if (str3 != null) {
                try {
                    logRecord.setResourceBundle(loadResourceBundle(str3));
                } catch (MissingResourceException e) {
                }
                logRecord.setResourceBundleName(str3);
            }
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setThrown(th);
            log(logRecord);
        }
    }

    public void logrb(Level level, String str, String str2, String str3, String str4, Object[] objArr) {
        if (internalIsLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, str4);
            if (str3 != null) {
                try {
                    logRecord.setResourceBundle(loadResourceBundle(str3));
                } catch (MissingResourceException e) {
                }
                logRecord.setResourceBundleName(str3);
            }
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setParameters(objArr);
            log(logRecord);
        }
    }

    public void removeHandler(Handler handler) {
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        if (handler == null) {
            return;
        }
        this.handlers.remove(handler);
        updateDalvikLogHandler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.levelObjVal = null;
        this.levelIntVal = Level.INFO.intValue();
        for (Handler handler : this.handlers) {
            try {
                if (this.handlers.remove(handler)) {
                    handler.close();
                }
            } catch (Exception e) {
            }
        }
        updateDalvikLogHandler();
    }

    public void setFilter(Filter filter) {
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        this.filter = filter;
    }

    public void setLevel(Level level) {
        LogManager logManager = LogManager.getLogManager();
        if (this.isNamed) {
            logManager.checkAccess();
        }
        logManager.setLevelRecursively(this, level);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setManager(LogManager logManager) {
        String property = logManager.getProperty(this.name + ".level");
        if (property != null) {
            try {
                logManager.setLevelRecursively(this, Level.parse(property));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        String property2 = logManager.getProperty(this.name.isEmpty() ? "handlers" : this.name + ".handlers");
        if (property2 != null) {
            String[] split = property2.split(",|\\s");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (!str.isEmpty()) {
                    try {
                        Handler handler = (Handler) LogManager.getInstanceByClass(str);
                        try {
                            String property3 = logManager.getProperty(str + ".level");
                            if (property3 != null) {
                                handler.setLevel(Level.parse(property3));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.handlers.add(handler);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
        }
        updateDalvikLogHandler();
    }

    public void setParent(Logger logger) {
        if (logger == null) {
            throw new NullPointerException("parent == null");
        }
        LogManager logManager = LogManager.getLogManager();
        logManager.checkAccess();
        logManager.setParent(this, logger);
    }

    public void setUseParentHandlers(boolean z) {
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        this.notifyParentHandlers = z;
        updateDalvikLogHandler();
    }

    public void severe(String str) {
        log(Level.SEVERE, str);
    }

    public void throwing(String str, String str2, Throwable th) {
        if (internalIsLoggable(Level.FINER)) {
            LogRecord logRecord = new LogRecord(Level.FINER, "THROW");
            logRecord.setLoggerName(this.name);
            logRecord.setSourceClassName(str);
            logRecord.setSourceMethodName(str2);
            logRecord.setThrown(th);
            setResourceBundle(logRecord);
            log(logRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDalvikLogHandler() {
        DalvikLogHandler dalvikLogHandler;
        DalvikLogHandler dalvikLogHandler2 = GENERAL_LOG_HANDLER;
        Logger logger = this.parent;
        if (getClass() != Logger.class) {
            dalvikLogHandler = dalvikLogHandler2;
        } else if (logger == null) {
            Iterator<Handler> it = this.handlers.iterator();
            dalvikLogHandler = dalvikLogHandler2;
            if (it.hasNext()) {
                Handler next = it.next();
                dalvikLogHandler = dalvikLogHandler2;
                if (!it.hasNext()) {
                    dalvikLogHandler = dalvikLogHandler2;
                    if (next instanceof DalvikLogHandler) {
                        dalvikLogHandler = (DalvikLogHandler) next;
                    }
                }
            }
        } else {
            dalvikLogHandler = dalvikLogHandler2;
            if (this.handlers.isEmpty()) {
                dalvikLogHandler = dalvikLogHandler2;
                if (this.notifyParentHandlers) {
                    dalvikLogHandler = logger.dalvikLogHandler;
                }
            }
        }
        if (dalvikLogHandler == this.dalvikLogHandler) {
            return;
        }
        this.dalvikLogHandler = dalvikLogHandler;
        for (Logger logger2 : this.children) {
            logger2.updateDalvikLogHandler();
        }
    }

    public void warning(String str) {
        log(Level.WARNING, str);
    }
}
