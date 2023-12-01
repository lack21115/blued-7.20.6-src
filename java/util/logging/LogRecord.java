package java.util.logging;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/LogRecord.class */
public class LogRecord implements Serializable {
    private static final int MAJOR = 1;
    private static final int MINOR = 4;
    private static long currentSequenceNumber = 0;
    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<>();
    private static int initThreadId = 0;
    private static final long serialVersionUID = 5372048053134512534L;
    private Level level;
    private String loggerName;
    private String message;
    private long millis;
    private transient Object[] parameters;
    private transient ResourceBundle resourceBundle;
    private String resourceBundleName;
    private long sequenceNumber;
    private String sourceClassName;
    private transient boolean sourceInitialized;
    private String sourceMethodName;
    private int threadID;
    private Throwable thrown;

    public LogRecord(Level level, String str) {
        if (level == null) {
            throw new NullPointerException("level == null");
        }
        this.level = level;
        this.message = str;
        this.millis = System.currentTimeMillis();
        synchronized (LogRecord.class) {
            try {
                long j = currentSequenceNumber;
                currentSequenceNumber = 1 + j;
                this.sequenceNumber = j;
                Integer num = currentThreadId.get();
                if (num == null) {
                    this.threadID = initThreadId;
                    ThreadLocal<Integer> threadLocal = currentThreadId;
                    int i = initThreadId;
                    initThreadId = i + 1;
                    threadLocal.set(Integer.valueOf(i));
                } else {
                    this.threadID = num.intValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.sourceClassName = null;
        this.sourceMethodName = null;
        this.loggerName = null;
        this.parameters = null;
        this.resourceBundle = null;
        this.resourceBundleName = null;
        this.thrown = null;
    }

    private void initSource() {
        boolean z;
        if (this.sourceInitialized) {
            return;
        }
        boolean z2 = false;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getClassName().startsWith(Logger.class.getName())) {
                z = true;
            } else {
                z = z2;
                if (z2) {
                    this.sourceClassName = stackTraceElement.getClassName();
                    this.sourceMethodName = stackTraceElement.getMethodName();
                    break;
                }
            }
            i++;
            z2 = z;
        }
        this.sourceInitialized = true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        byte readByte = objectInputStream.readByte();
        byte readByte2 = objectInputStream.readByte();
        if (readByte != 1) {
            throw new IOException("Different version " + Byte.valueOf(readByte) + "." + Byte.valueOf(readByte2));
        }
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            this.parameters = new Object[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.parameters.length) {
                    break;
                }
                this.parameters[i2] = objectInputStream.readObject();
                i = i2 + 1;
            }
        }
        if (this.resourceBundleName != null) {
            try {
                this.resourceBundle = Logger.loadResourceBundle(this.resourceBundleName);
            } catch (MissingResourceException e) {
                this.resourceBundle = null;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeByte(1);
        objectOutputStream.writeByte(4);
        if (this.parameters == null) {
            objectOutputStream.writeInt(-1);
            return;
        }
        objectOutputStream.writeInt(this.parameters.length);
        Object[] objArr = this.parameters;
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Object obj = objArr[i2];
            objectOutputStream.writeObject(obj == null ? null : obj.toString());
            i = i2 + 1;
        }
    }

    public Level getLevel() {
        return this.level;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public String getMessage() {
        return this.message;
    }

    public long getMillis() {
        return this.millis;
    }

    public Object[] getParameters() {
        return this.parameters;
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public String getSourceClassName() {
        initSource();
        return this.sourceClassName;
    }

    public String getSourceMethodName() {
        initSource();
        return this.sourceMethodName;
    }

    public int getThreadID() {
        return this.threadID;
    }

    public Throwable getThrown() {
        return this.thrown;
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null");
        }
        this.level = level;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMillis(long j) {
        this.millis = j;
    }

    public void setParameters(Object[] objArr) {
        this.parameters = objArr;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void setResourceBundleName(String str) {
        this.resourceBundleName = str;
    }

    public void setSequenceNumber(long j) {
        this.sequenceNumber = j;
    }

    public void setSourceClassName(String str) {
        this.sourceInitialized = true;
        this.sourceClassName = str;
    }

    public void setSourceMethodName(String str) {
        this.sourceInitialized = true;
        this.sourceMethodName = str;
    }

    public void setThreadID(int i) {
        this.threadID = i;
    }

    public void setThrown(Throwable th) {
        this.thrown = th;
    }
}
