package dalvik.system.profiler;

import dalvik.system.profiler.BinaryHprof;
import dalvik.system.profiler.HprofData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprofWriter.class */
public final class BinaryHprofWriter {
    private final HprofData data;
    private final DataOutputStream out;
    private int nextStringId = 1;
    private int nextClassId = 1;
    private int nextStackFrameId = 1;
    private final Map<String, Integer> stringToId = new HashMap();
    private final Map<String, Integer> classNameToId = new HashMap();
    private final Map<StackTraceElement, Integer> stackFrameToId = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dalvik.system.profiler.BinaryHprofWriter$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprofWriter$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType = new int[HprofData.ThreadEventType.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0022 -> B:11:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[HprofData.ThreadEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[HprofData.ThreadEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private BinaryHprofWriter(HprofData hprofData, OutputStream outputStream) {
        this.data = hprofData;
        this.out = new DataOutputStream(outputStream);
    }

    private void write() throws IOException {
        try {
            writeHeader(this.data.getStartMillis());
            writeControlSettings(this.data.getFlags(), this.data.getDepth());
            for (HprofData.ThreadEvent threadEvent : this.data.getThreadHistory()) {
                writeThreadEvent(threadEvent);
            }
            Set<HprofData.Sample> samples = this.data.getSamples();
            int i = 0;
            for (HprofData.Sample sample : samples) {
                i += sample.count;
                writeStackTrace(sample.stackTrace);
            }
            writeCpuSamples(i, samples);
        } finally {
            this.out.flush();
        }
    }

    public static void write(HprofData hprofData, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(hprofData, outputStream).write();
    }

    private void writeControlSettings(int i, int i2) throws IOException {
        if (i2 > 32767) {
            throw new IllegalArgumentException("depth too large for binary hprof: " + i2 + " > " + Short.MAX_VALUE);
        }
        writeRecordHeader(BinaryHprof.Tag.CONTROL_SETTINGS, 0, BinaryHprof.Tag.CONTROL_SETTINGS.maximumSize);
        this.out.writeInt(i);
        this.out.writeShort((short) i2);
    }

    private void writeCpuSamples(int i, Set<HprofData.Sample> set) throws IOException {
        int size = set.size();
        if (size == 0) {
            return;
        }
        writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, (size * 8) + 8);
        this.out.writeInt(i);
        this.out.writeInt(size);
        for (HprofData.Sample sample : set) {
            this.out.writeInt(sample.count);
            this.out.writeInt(sample.stackTrace.stackTraceId);
        }
    }

    private void writeHeader(long j) throws IOException {
        this.out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        this.out.writeByte(0);
        this.out.writeInt(4);
        this.out.writeLong(j);
    }

    private void writeId(int i) throws IOException {
        this.out.writeInt(i);
    }

    private int writeLoadClass(String str) throws IOException {
        Integer num = this.classNameToId.get(str);
        if (num != null) {
            return num.intValue();
        }
        int i = this.nextClassId;
        this.nextClassId = i + 1;
        this.classNameToId.put(str, Integer.valueOf(i));
        int writeString = writeString(str);
        writeRecordHeader(BinaryHprof.Tag.LOAD_CLASS, 0, BinaryHprof.Tag.LOAD_CLASS.maximumSize);
        this.out.writeInt(i);
        writeId(0);
        this.out.writeInt(0);
        writeId(writeString);
        return i;
    }

    private void writeRecordHeader(BinaryHprof.Tag tag, int i, int i2) throws IOException {
        String checkSize = tag.checkSize(i2);
        if (checkSize != null) {
            throw new AssertionError(checkSize);
        }
        this.out.writeByte(tag.tag);
        this.out.writeInt(i);
        this.out.writeInt(i2);
    }

    private int writeStackFrame(StackTraceElement stackTraceElement) throws IOException {
        Integer num = this.stackFrameToId.get(stackTraceElement);
        if (num != null) {
            return num.intValue();
        }
        int i = this.nextStackFrameId;
        this.nextStackFrameId = i + 1;
        this.stackFrameToId.put(stackTraceElement, Integer.valueOf(i));
        int writeLoadClass = writeLoadClass(stackTraceElement.getClassName());
        int writeString = writeString(stackTraceElement.getMethodName());
        int writeString2 = writeString(stackTraceElement.getFileName());
        writeRecordHeader(BinaryHprof.Tag.STACK_FRAME, 0, BinaryHprof.Tag.STACK_FRAME.maximumSize);
        writeId(i);
        writeId(writeString);
        writeId(0);
        writeId(writeString2);
        this.out.writeInt(writeLoadClass);
        this.out.writeInt(stackTraceElement.getLineNumber());
        return i;
    }

    private void writeStackTrace(HprofData.StackTrace stackTrace) throws IOException {
        int length = stackTrace.stackFrames.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            iArr[i2] = writeStackFrame(stackTrace.stackFrames[i2]);
            i = i2 + 1;
        }
        writeRecordHeader(BinaryHprof.Tag.STACK_TRACE, 0, (length * 4) + 12);
        this.out.writeInt(stackTrace.stackTraceId);
        this.out.writeInt(stackTrace.threadId);
        this.out.writeInt(length);
        int length2 = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            writeId(iArr[i4]);
            i3 = i4 + 1;
        }
    }

    private void writeStartThread(HprofData.ThreadEvent threadEvent) throws IOException {
        int writeString = writeString(threadEvent.threadName);
        int writeString2 = writeString(threadEvent.groupName);
        int writeString3 = writeString(threadEvent.parentGroupName);
        writeRecordHeader(BinaryHprof.Tag.START_THREAD, 0, BinaryHprof.Tag.START_THREAD.maximumSize);
        this.out.writeInt(threadEvent.threadId);
        writeId(threadEvent.objectId);
        this.out.writeInt(0);
        writeId(writeString);
        writeId(writeString2);
        writeId(writeString3);
    }

    private void writeStopThread(HprofData.ThreadEvent threadEvent) throws IOException {
        writeRecordHeader(BinaryHprof.Tag.END_THREAD, 0, BinaryHprof.Tag.END_THREAD.maximumSize);
        this.out.writeInt(threadEvent.threadId);
    }

    private int writeString(String str) throws IOException {
        if (str == null) {
            return 0;
        }
        Integer num = this.stringToId.get(str);
        if (num != null) {
            return num.intValue();
        }
        int i = this.nextStringId;
        this.nextStringId = i + 1;
        this.stringToId.put(str, Integer.valueOf(i));
        byte[] bytes = str.getBytes("UTF-8");
        writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8, 0, bytes.length + 4);
        this.out.writeInt(i);
        this.out.write(bytes, 0, bytes.length);
        return i;
    }

    private void writeThreadEvent(HprofData.ThreadEvent threadEvent) throws IOException {
        switch (AnonymousClass1.$SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[threadEvent.type.ordinal()]) {
            case 1:
                writeStartThread(threadEvent);
                return;
            case 2:
                writeStopThread(threadEvent);
                return;
            default:
                throw new IllegalStateException(threadEvent.type.toString());
        }
    }
}
