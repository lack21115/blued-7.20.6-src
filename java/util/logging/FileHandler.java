package java.util.logging;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Hashtable;
import libcore.io.IoUtils;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/FileHandler.class */
public class FileHandler extends StreamHandler {
    private static final boolean DEFAULT_APPEND = false;
    private static final int DEFAULT_COUNT = 1;
    private static final int DEFAULT_LIMIT = 0;
    private static final String DEFAULT_PATTERN = "%h/java%u.log";
    private static final String LCK_EXT = ".lck";
    private static final Hashtable<String, FileLock> allLocks = new Hashtable<>();
    private boolean append;
    private int count;
    private File[] files;
    private int limit;
    private LogManager manager;
    private MeasureOutputStream output;
    private String pattern;
    FileLock lock = null;
    String fileName = null;
    int uniqueID = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/logging/FileHandler$MeasureOutputStream.class */
    public static class MeasureOutputStream extends OutputStream {
        long length;
        OutputStream wrapped;

        public MeasureOutputStream(OutputStream outputStream) {
            this(outputStream, 0L);
        }

        public MeasureOutputStream(OutputStream outputStream, long j) {
            this.wrapped = outputStream;
            this.length = j;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.wrapped.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.wrapped.flush();
        }

        public long getLength() {
            return this.length;
        }

        public void setLength(long j) {
            this.length = j;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.wrapped.write(i);
            this.length++;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.wrapped.write(bArr, i, i2);
            this.length += i2;
        }
    }

    public FileHandler() throws IOException {
        init(null, null, null, null);
    }

    public FileHandler(String str) throws IOException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be empty");
        }
        init(str, null, 0, 1);
    }

    public FileHandler(String str, int i, int i2) throws IOException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be empty");
        }
        if (i < 0 || i2 < 1) {
            throw new IllegalArgumentException("limit < 0 || count < 1");
        }
        init(str, null, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public FileHandler(String str, int i, int i2, boolean z) throws IOException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be empty");
        }
        if (i < 0 || i2 < 1) {
            throw new IllegalArgumentException("limit < 0 || count < 1");
        }
        init(str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public FileHandler(String str, boolean z) throws IOException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be empty");
        }
        init(str, Boolean.valueOf(z), 0, 1);
    }

    private boolean getBooleanProperty(String str, boolean z) {
        String property = this.manager.getProperty(str);
        if (property == null) {
            return z;
        }
        if ("true".equalsIgnoreCase(property)) {
            z = true;
        } else if ("false".equalsIgnoreCase(property)) {
            z = false;
        }
        return z;
    }

    private int getIntProperty(String str, int i) {
        String property = this.manager.getProperty(str);
        int i2 = i;
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (Exception e) {
                return i;
            }
        }
        return i2;
    }

    private String getStringProperty(String str, String str2) {
        String property = this.manager.getProperty(str);
        return property == null ? str2 : property;
    }

    private void init(String str, Boolean bool, Integer num, Integer num2) throws IOException {
        this.manager = LogManager.getLogManager();
        this.manager.checkAccess();
        initProperties(str, bool, num, num2);
        initOutputFiles();
    }

    private void initOutputFiles() throws FileNotFoundException, IOException {
        while (true) {
            this.uniqueID++;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.count) {
                    break;
                }
                this.files[i2] = new File(parseFileName(i2));
                i = i2 + 1;
            }
            this.fileName = this.files[0].getAbsolutePath();
            synchronized (allLocks) {
                if (allLocks.get(this.fileName) == null) {
                    if (this.files[0].exists() && (!this.append || this.files[0].length() >= this.limit)) {
                        int i3 = this.count;
                        while (true) {
                            int i4 = i3 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            if (this.files[i4].exists()) {
                                this.files[i4].delete();
                            }
                            this.files[i4 - 1].renameTo(this.files[i4]);
                            i3 = i4;
                        }
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(this.fileName + LCK_EXT);
                    this.lock = fileOutputStream.getChannel().tryLock();
                    if (this.lock != null) {
                        allLocks.put(this.fileName, this.lock);
                        this.output = new MeasureOutputStream(new BufferedOutputStream(new FileOutputStream(this.fileName, this.append)), this.files[0].length());
                        setOutputStream(this.output);
                        return;
                    }
                    IoUtils.closeQuietly(fileOutputStream);
                }
            }
        }
    }

    private void initProperties(String str, Boolean bool, Integer num, Integer num2) {
        super.initProperties(Rule.ALL, (String) null, "java.util.logging.XMLFormatter", (String) null);
        String name = getClass().getName();
        String str2 = str;
        if (str == null) {
            str2 = getStringProperty(name + ".pattern", DEFAULT_PATTERN);
        }
        this.pattern = str2;
        if (this.pattern == null) {
            throw new NullPointerException("pattern == null");
        }
        if (this.pattern.isEmpty()) {
            throw new NullPointerException("pattern.isEmpty()");
        }
        this.append = bool == null ? getBooleanProperty(name + ".append", false) : bool.booleanValue();
        this.count = num2 == null ? getIntProperty(name + ".count", 1) : num2.intValue();
        this.limit = num == null ? getIntProperty(name + ".limit", 0) : num.intValue();
        this.count = this.count < 1 ? 1 : this.count;
        this.limit = this.limit < 0 ? 0 : this.limit;
        this.files = new File[this.count];
    }

    private String parseFileName(int i) {
        boolean z;
        boolean z2;
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String property = System.getProperty("java.io.tmpdir");
        boolean endsWith = property == null ? false : property.endsWith(File.separator);
        String property2 = System.getProperty("user.home");
        boolean endsWith2 = property2 == null ? false : property2.endsWith(File.separator);
        StringBuilder sb = new StringBuilder();
        this.pattern = this.pattern.replace('/', File.separatorChar);
        char[] charArray = this.pattern.toCharArray();
        while (true) {
            int indexOf = this.pattern.indexOf(37, i2);
            if (indexOf < 0) {
                sb.append(charArray, i2, charArray.length - i2);
                if (!z4 && this.count > 1) {
                    sb.append(".").append(i);
                }
                if (!z3 && this.uniqueID > 0) {
                    sb.append(".").append(this.uniqueID);
                }
                return sb.toString();
            }
            int i3 = indexOf + 1;
            if (i3 < this.pattern.length()) {
                switch (charArray[i3]) {
                    case '%':
                        sb.append(charArray, i2, (i3 - i2) - 1).append('%');
                        z = z4;
                        z2 = z3;
                        break;
                    case 'g':
                        sb.append(charArray, i2, (i3 - i2) - 1).append(i);
                        z = true;
                        z2 = z3;
                        break;
                    case 'h':
                        sb.append(charArray, i2, (i3 - i2) - 1).append(property2);
                        z = z4;
                        z2 = z3;
                        if (!endsWith2) {
                            sb.append(File.separator);
                            z = z4;
                            z2 = z3;
                            break;
                        }
                        break;
                    case 't':
                        sb.append(charArray, i2, (i3 - i2) - 1).append(property);
                        z = z4;
                        z2 = z3;
                        if (!endsWith) {
                            sb.append(File.separator);
                            z = z4;
                            z2 = z3;
                            break;
                        }
                        break;
                    case 'u':
                        sb.append(charArray, i2, (i3 - i2) - 1).append(this.uniqueID);
                        z2 = true;
                        z = z4;
                        break;
                    default:
                        sb.append(charArray, i2, i3 - i2);
                        z2 = z3;
                        z = z4;
                        break;
                }
                i2 = i3 + 1;
                z4 = z;
                z3 = z2;
            }
        }
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void close() {
        super.close();
        allLocks.remove(this.fileName);
        try {
            FileChannel channel = this.lock.channel();
            this.lock.release();
            channel.close();
            new File(this.fileName + LCK_EXT).delete();
        } catch (IOException e) {
        }
    }

    void findNextGeneration() {
        super.close();
        int i = this.count;
        while (true) {
            int i2 = i - 1;
            if (i2 > 0) {
                if (this.files[i2].exists()) {
                    this.files[i2].delete();
                }
                this.files[i2 - 1].renameTo(this.files[i2]);
                i = i2;
            } else {
                try {
                    break;
                } catch (FileNotFoundException e) {
                    getErrorManager().error("Error opening log file", e, 4);
                }
            }
        }
        this.output = new MeasureOutputStream(new BufferedOutputStream(new FileOutputStream(this.files[0])));
        setOutputStream(this.output);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        synchronized (this) {
            super.publish(logRecord);
            flush();
            if (this.limit > 0 && this.output.getLength() >= this.limit) {
                findNextGeneration();
            }
        }
    }
}
