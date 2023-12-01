package dalvik.system.profiler;

import dalvik.system.profiler.BinaryHprof;
import dalvik.system.profiler.HprofData;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprofReader.class */
public final class BinaryHprofReader {
    private static final boolean TRACE = false;
    private final DataInputStream in;
    private String version;
    private boolean strict = true;
    private final Map<HprofData.StackTrace, int[]> stackTraces = new HashMap();
    private final HprofData hprofData = new HprofData(this.stackTraces);
    private final Map<Integer, String> idToString = new HashMap();
    private final Map<Integer, String> idToClassName = new HashMap();
    private final Map<Integer, StackTraceElement> idToStackFrame = new HashMap();
    private final Map<Integer, HprofData.StackTrace> idToStackTrace = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dalvik.system.profiler.BinaryHprofReader$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprofReader$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag = new int[BinaryHprof.Tag.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00af -> B:59:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b3 -> B:61:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b7 -> B:71:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00bb -> B:67:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00bf -> B:79:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00c3 -> B:75:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c7 -> B:85:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00cb -> B:83:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00cf -> B:65:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00d3 -> B:63:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00d7 -> B:73:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00db -> B:69:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00df -> B:81:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.CONTROL_SETTINGS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.STRING_IN_UTF8.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.START_THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.END_THREAD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.LOAD_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.STACK_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.STACK_TRACE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.CPU_SAMPLES.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.UNLOAD_CLASS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.ALLOC_SITES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.HEAP_SUMMARY.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.HEAP_DUMP.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.HEAP_DUMP_SEGMENT.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[BinaryHprof.Tag.HEAP_DUMP_END.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public BinaryHprofReader(InputStream inputStream) throws IOException {
        this.in = new DataInputStream(inputStream);
    }

    private void checkRead() {
        if (this.version == null) {
            throw new IllegalStateException("data access before read()");
        }
    }

    private void parseControlSettings() throws IOException {
        int readInt = this.in.readInt();
        short readShort = this.in.readShort();
        this.hprofData.setFlags(readInt);
        this.hprofData.setDepth(readShort);
    }

    private void parseCpuSamples(int i) throws IOException {
        int i2;
        int readInt = this.in.readInt();
        int readInt2 = this.in.readInt();
        int i3 = (readInt2 * 8) + 8;
        if (i != i3) {
            throw new MalformedHprofException("Expected CPU samples record of size " + i3 + " based on number of samples but header specified a length of  " + i);
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= readInt2) {
                if (this.strict && readInt != i4) {
                    throw new MalformedHprofException("Expected a total of " + readInt + " samples but saw " + i4);
                }
                return;
            }
            int readInt3 = this.in.readInt();
            int readInt4 = this.in.readInt();
            HprofData.StackTrace stackTrace = this.idToStackTrace.get(Integer.valueOf(readInt4));
            if (stackTrace == null) {
                throw new MalformedHprofException("Unknown stack trace id " + readInt4);
            }
            if (readInt3 == 0) {
                throw new MalformedHprofException("Zero sample count for stack trace " + stackTrace);
            }
            int[] iArr = this.stackTraces.get(stackTrace);
            if (this.strict) {
                i2 = readInt3;
                if (iArr[0] != 0) {
                    throw new MalformedHprofException("Setting sample count of stack trace " + stackTrace + " to " + readInt3 + " found it was already initialized to " + iArr[0]);
                }
            } else {
                i2 = readInt3 + iArr[0];
            }
            iArr[0] = i2;
            i4 += i2;
            i5 = i6 + 1;
        }
    }

    private void parseEndThread() throws IOException {
        this.hprofData.addThreadEvent(HprofData.ThreadEvent.end(this.in.readInt()));
    }

    private void parseHeader() throws IOException {
        parseVersion();
        parseIdSize();
        parseTime();
    }

    private void parseIdSize() throws IOException {
        int readInt = this.in.readInt();
        if (readInt != 4) {
            throw new MalformedHprofException("Unsupported identifier size: " + readInt);
        }
    }

    private void parseLoadClass() throws IOException {
        int readInt = this.in.readInt();
        readId();
        this.in.readInt();
        if (this.idToClassName.put(Integer.valueOf(readInt), readString()) != null) {
            throw new MalformedHprofException("Duplicate class id: " + readInt);
        }
    }

    private boolean parseRecord() throws IOException {
        int read = this.in.read();
        if (read == -1) {
            return false;
        }
        byte b = (byte) read;
        this.in.readInt();
        int readInt = this.in.readInt();
        BinaryHprof.Tag tag = BinaryHprof.Tag.get(b);
        if (tag == null) {
            skipRecord(tag, readInt);
            return true;
        }
        String checkSize = tag.checkSize(readInt);
        if (checkSize != null) {
            throw new MalformedHprofException(checkSize);
        }
        switch (AnonymousClass1.$SwitchMap$dalvik$system$profiler$BinaryHprof$Tag[tag.ordinal()]) {
            case 1:
                parseControlSettings();
                return true;
            case 2:
                parseStringInUtf8(readInt);
                return true;
            case 3:
                parseStartThread();
                return true;
            case 4:
                parseEndThread();
                return true;
            case 5:
                parseLoadClass();
                return true;
            case 6:
                parseStackFrame();
                return true;
            case 7:
                parseStackTrace(readInt);
                return true;
            case 8:
                parseCpuSamples(readInt);
                return true;
            default:
                skipRecord(tag, readInt);
                return true;
        }
    }

    private void parseRecords() throws IOException {
        do {
        } while (parseRecord());
    }

    private void parseStackFrame() throws IOException {
        int readId = readId();
        String readString = readString();
        readString();
        if (this.idToStackFrame.put(Integer.valueOf(readId), new StackTraceElement(readClass(), readString, readString(), this.in.readInt())) != null) {
            throw new MalformedHprofException("Duplicate stack frame id: " + readId);
        }
    }

    private void parseStackTrace(int i) throws IOException {
        int readInt = this.in.readInt();
        int readInt2 = this.in.readInt();
        int readInt3 = this.in.readInt();
        int i2 = (readInt3 * 4) + 12;
        if (i != i2) {
            throw new MalformedHprofException("Expected stack trace record of size " + i2 + " based on number of frames but header specified a length of  " + i);
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[readInt3];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= readInt3) {
                HprofData.StackTrace stackTrace = new HprofData.StackTrace(readInt, readInt2, stackTraceElementArr);
                if (this.strict) {
                    this.hprofData.addStackTrace(stackTrace, new int[1]);
                } else if (this.stackTraces.get(stackTrace) == null) {
                    this.hprofData.addStackTrace(stackTrace, new int[1]);
                }
                if (this.idToStackTrace.put(Integer.valueOf(readInt), stackTrace) != null) {
                    throw new MalformedHprofException("Duplicate stack trace id: " + readInt);
                }
                return;
            }
            int readId = readId();
            StackTraceElement stackTraceElement = this.idToStackFrame.get(Integer.valueOf(readId));
            if (stackTraceElement == null) {
                throw new MalformedHprofException("Unknown stack frame id " + readId);
            }
            stackTraceElementArr[i4] = stackTraceElement;
            i3 = i4 + 1;
        }
    }

    private void parseStartThread() throws IOException {
        int readInt = this.in.readInt();
        int readId = readId();
        this.in.readInt();
        this.hprofData.addThreadEvent(HprofData.ThreadEvent.start(readId, readInt, readString(), readString(), readString()));
    }

    private void parseStringInUtf8(int i) throws IOException {
        int readInt = this.in.readInt();
        byte[] bArr = new byte[i - 4];
        readFully(this.in, bArr);
        if (this.idToString.put(Integer.valueOf(readInt), new String(bArr, "UTF-8")) != null) {
            throw new MalformedHprofException("Duplicate string id: " + readInt);
        }
    }

    private void parseTime() throws IOException {
        this.hprofData.setStartMillis(this.in.readLong());
    }

    private void parseVersion() throws IOException {
        String readMagic = BinaryHprof.readMagic(this.in);
        if (readMagic == null) {
            throw new MalformedHprofException("Could not find HPROF version");
        }
        this.version = readMagic;
    }

    private String readClass() throws IOException {
        int readId = readId();
        String str = this.idToClassName.get(Integer.valueOf(readId));
        if (str == null) {
            throw new MalformedHprofException("Unknown class id " + readId);
        }
        return str;
    }

    private static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        int length = bArr.length;
        while (true) {
            int i2 = length;
            if (i2 <= 0) {
                return;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
            length = i2 - read;
        }
    }

    private int readId() throws IOException {
        return this.in.readInt();
    }

    private String readString() throws IOException {
        String str;
        int readId = readId();
        if (readId == 0) {
            str = null;
        } else {
            String str2 = this.idToString.get(Integer.valueOf(readId));
            str = str2;
            if (str2 == null) {
                throw new MalformedHprofException("Unknown string id " + readId);
            }
        }
        return str;
    }

    private void skipRecord(BinaryHprof.Tag tag, long j) throws IOException {
        long skip = this.in.skip(j);
        if (skip != j) {
            throw new EOFException("Expected to skip " + j + " bytes but only skipped " + skip + " bytes");
        }
    }

    public HprofData getHprofData() {
        checkRead();
        return this.hprofData;
    }

    public boolean getStrict() {
        return this.strict;
    }

    public String getVersion() {
        checkRead();
        return this.version;
    }

    public void read() throws IOException {
        parseHeader();
        parseRecords();
    }

    public void setStrict(boolean z) {
        if (this.version != null) {
            throw new IllegalStateException("cannot set strict after read()");
        }
        this.strict = z;
    }
}
