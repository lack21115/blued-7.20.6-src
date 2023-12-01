package java.util.logging;

import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/MemoryHandler.class */
public class MemoryHandler extends Handler {
    private static final int DEFAULT_SIZE = 1000;
    private LogRecord[] buffer;
    private int cursor;
    private final LogManager manager = LogManager.getLogManager();
    private Level push;
    private int size;
    private Handler target;

    public MemoryHandler() {
        this.size = 1000;
        this.push = Level.SEVERE;
        String name = getClass().getName();
        String property = this.manager.getProperty(name + ".target");
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            this.target = (Handler) (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).loadClass(property).newInstance();
            String property2 = this.manager.getProperty(name + ".size");
            if (property2 != null) {
                try {
                    this.size = Integer.parseInt(property2);
                    if (this.size <= 0) {
                        this.size = 1000;
                    }
                } catch (Exception e) {
                    printInvalidPropMessage(name + ".size", property2, e);
                }
            }
            String property3 = this.manager.getProperty(name + ".push");
            if (property3 != null) {
                try {
                    this.push = Level.parse(property3);
                } catch (Exception e2) {
                    printInvalidPropMessage(name + ".push", property3, e2);
                }
            }
            initProperties(Rule.ALL, null, "java.util.logging.SimpleFormatter", null);
            this.buffer = new LogRecord[this.size];
        } catch (Exception e3) {
            throw new RuntimeException("Cannot load target handler '" + property + "'");
        }
    }

    public MemoryHandler(Handler handler, int i, Level level) {
        this.size = 1000;
        this.push = Level.SEVERE;
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        handler.getLevel();
        level.intValue();
        this.target = handler;
        this.size = i;
        this.push = level;
        initProperties(Rule.ALL, null, "java.util.logging.SimpleFormatter", null);
        this.buffer = new LogRecord[i];
    }

    @Override // java.util.logging.Handler
    public void close() {
        this.manager.checkAccess();
        this.target.close();
        setLevel(Level.OFF);
    }

    @Override // java.util.logging.Handler
    public void flush() {
        this.target.flush();
    }

    public Level getPushLevel() {
        return this.push;
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord logRecord) {
        return super.isLoggable(logRecord);
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        synchronized (this) {
            if (isLoggable(logRecord)) {
                if (this.cursor >= this.size) {
                    this.cursor = 0;
                }
                LogRecord[] logRecordArr = this.buffer;
                int i = this.cursor;
                this.cursor = i + 1;
                logRecordArr[i] = logRecord;
                if (logRecord.getLevel().intValue() >= this.push.intValue()) {
                    push();
                }
            }
        }
    }

    public void push() {
        int i = this.cursor;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                break;
            }
            if (this.buffer[i2] != null) {
                this.target.publish(this.buffer[i2]);
            }
            this.buffer[i2] = null;
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.cursor) {
                this.cursor = 0;
                return;
            }
            if (this.buffer[i4] != null) {
                this.target.publish(this.buffer[i4]);
            }
            this.buffer[i4] = null;
            i3 = i4 + 1;
        }
    }

    public void setPushLevel(Level level) {
        this.manager.checkAccess();
        level.intValue();
        this.push = level;
    }
}
