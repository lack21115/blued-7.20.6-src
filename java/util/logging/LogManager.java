package java.util.logging;

import com.android.internal.content.NativeLibraryHelper;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/LogManager.class */
public class LogManager {
    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
    static LogManager manager;
    private static final LoggingPermission perm = new LoggingPermission("control", null);
    private Hashtable<String, Logger> loggers = new Hashtable<>();
    private Properties props = new Properties();
    private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    static {
        String property = System.getProperty("java.util.logging.manager");
        if (property != null) {
            manager = (LogManager) getInstanceByClass(property);
        }
        if (manager == null) {
            manager = new LogManager();
        }
        try {
            LogManager logManager = manager;
            throw new VerifyError("bad dex opcode");
        } catch (Exception e) {
            throw new VerifyError("bad dex opcode");
        }
    }

    protected LogManager() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: java.util.logging.LogManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                LogManager.this.reset();
            }
        });
    }

    private void addToFamilyTree(Logger logger, String str) {
        String substring;
        Logger logger2 = null;
        String str2 = str;
        do {
            int lastIndexOf = str2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                break;
            }
            substring = str2.substring(0, lastIndexOf);
            logger2 = this.loggers.get(substring);
            if (logger2 != null) {
                setParent(logger, logger2);
                break;
            }
            if (getProperty(substring + ".level") != null) {
                break;
            }
            str2 = substring;
        } while (getProperty(substring + ".handlers") == null);
        logger2 = Logger.getLogger(substring);
        setParent(logger, logger2);
        Logger logger3 = logger2;
        if (logger2 == null) {
            Logger logger4 = this.loggers.get("");
            logger3 = logger4;
            if (logger4 != null) {
                setParent(logger, logger4);
                logger3 = logger4;
            }
        }
        String str3 = str + '.';
        for (Logger logger5 : this.loggers.values()) {
            Logger parent = logger5.getParent();
            if (logger3 == parent && (str.length() == 0 || logger5.getName().startsWith(str3))) {
                logger5.setParent(logger);
                if (parent != null) {
                    parent.children.remove(logger5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getInstanceByClass(String str) {
        try {
            return ClassLoader.getSystemClassLoader().loadClass(str).newInstance();
        } catch (Exception e) {
            try {
                return Thread.currentThread().getContextClassLoader().loadClass(str).newInstance();
            } catch (Exception e2) {
                System.err.println("Loading class '" + str + "' failed");
                System.err.println(e2);
                return null;
            }
        }
    }

    public static LogManager getLogManager() {
        return manager;
    }

    public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    private void readConfigurationImpl(InputStream inputStream) throws IOException {
        synchronized (this) {
            reset();
            this.props.load(inputStream);
            Logger logger = this.loggers.get("");
            if (logger != null) {
                logger.setManager(this);
            }
            String property = this.props.getProperty("config");
            if (property != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(property, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    getInstanceByClass(stringTokenizer.nextToken());
                }
            }
            for (Logger logger2 : this.loggers.values()) {
                String property2 = this.props.getProperty(logger2.getName() + ".level");
                if (property2 != null) {
                    logger2.setLevel(Level.parse(property2));
                }
            }
            this.listeners.firePropertyChange((String) null, (Object) null, (Object) null);
        }
    }

    public boolean addLogger(Logger logger) {
        boolean z;
        synchronized (this) {
            String name = logger.getName();
            if (this.loggers.get(name) != null) {
                z = false;
            } else {
                addToFamilyTree(logger, name);
                this.loggers.put(name, logger);
                logger.setManager(this);
                z = true;
            }
        }
        return z;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener == null) {
            throw new NullPointerException("l == null");
        }
        checkAccess();
        this.listeners.addPropertyChangeListener(propertyChangeListener);
    }

    public void checkAccess() {
    }

    public Logger getLogger(String str) {
        Logger logger;
        synchronized (this) {
            logger = this.loggers.get(str);
        }
        return logger;
    }

    public Enumeration<String> getLoggerNames() {
        Enumeration<String> keys;
        synchronized (this) {
            keys = this.loggers.keys();
        }
        return keys;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger getOrCreate(String str, String str2) {
        Logger logger;
        synchronized (this) {
            Logger logger2 = getLogger(str);
            logger = logger2;
            if (logger2 == null) {
                logger = new Logger(str, str2);
                addLogger(logger);
            }
        }
        return logger;
    }

    public String getProperty(String str) {
        return this.props.getProperty(str);
    }

    public void readConfiguration() throws IOException {
        FileInputStream fileInputStream;
        String property = System.getProperty("java.util.logging.config.class");
        if (property == null || getInstanceByClass(property) == null) {
            String property2 = System.getProperty("java.util.logging.config.file");
            String str = property2;
            if (property2 == null) {
                str = System.getProperty("java.home") + File.separator + NativeLibraryHelper.LIB_DIR_NAME + File.separator + "logging.properties";
            }
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e) {
                    InputStream resourceAsStream = LogManager.class.getResourceAsStream("logging.properties");
                    fileInputStream = resourceAsStream;
                    if (resourceAsStream == null) {
                        throw e;
                    }
                }
                InputStream inputStream = fileInputStream;
                readConfiguration(new BufferedInputStream(fileInputStream));
                IoUtils.closeQuietly(fileInputStream);
            } catch (Throwable th) {
                IoUtils.closeQuietly((AutoCloseable) null);
                throw th;
            }
        }
    }

    public void readConfiguration(InputStream inputStream) throws IOException {
        checkAccess();
        readConfigurationImpl(inputStream);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        checkAccess();
        this.listeners.removePropertyChangeListener(propertyChangeListener);
    }

    public void reset() {
        synchronized (this) {
            checkAccess();
            this.props = new Properties();
            Enumeration<String> loggerNames = getLoggerNames();
            while (loggerNames.hasMoreElements()) {
                Logger logger = getLogger(loggerNames.nextElement());
                if (logger != null) {
                    logger.reset();
                }
            }
            Logger logger2 = this.loggers.get("");
            if (logger2 != null) {
                logger2.setLevel(Level.INFO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLevelRecursively(Logger logger, Level level) {
        synchronized (this) {
            int i = logger.levelIntVal;
            logger.levelObjVal = level;
            if (level == null) {
                logger.levelIntVal = logger.parent != null ? logger.parent.levelIntVal : Level.INFO.intValue();
            } else {
                logger.levelIntVal = level.intValue();
            }
            if (i != logger.levelIntVal) {
                for (Logger logger2 : logger.children) {
                    if (logger2.levelObjVal == null) {
                        setLevelRecursively(logger2, null);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParent(Logger logger, Logger logger2) {
        synchronized (this) {
            logger.parent = logger2;
            if (logger.levelObjVal == null) {
                setLevelRecursively(logger, null);
            }
            logger2.children.add(logger);
            logger.updateDalvikLogHandler();
        }
    }
}
