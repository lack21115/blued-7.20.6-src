package android.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/util/EventLog.class */
public class EventLog {
    private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
    private static final String TAG = "EventLog";
    private static final String TAGS_FILE = "/system/etc/event-log-tags";
    private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
    private static HashMap<String, Integer> sTagCodes = null;
    private static HashMap<Integer, String> sTagNames = null;

    /* loaded from: source-9557208-dex2jar.jar:android/util/EventLog$Event.class */
    public static final class Event {
        private static final int DATA_OFFSET = 4;
        private static final int HEADER_SIZE_OFFSET = 2;
        private static final byte INT_TYPE = 0;
        private static final int LENGTH_OFFSET = 0;
        private static final byte LIST_TYPE = 3;
        private static final byte LONG_TYPE = 1;
        private static final int NANOSECONDS_OFFSET = 16;
        private static final int PROCESS_OFFSET = 4;
        private static final int SECONDS_OFFSET = 12;
        private static final byte STRING_TYPE = 2;
        private static final int THREAD_OFFSET = 8;
        private static final int V1_PAYLOAD_START = 20;
        private final ByteBuffer mBuffer;

        Event(byte[] bArr) {
            this.mBuffer = ByteBuffer.wrap(bArr);
            this.mBuffer.order(ByteOrder.nativeOrder());
        }

        private Object decodeObject() {
            Object obj;
            byte b = this.mBuffer.get();
            switch (b) {
                case 0:
                    obj = Integer.valueOf(this.mBuffer.getInt());
                    break;
                case 1:
                    return Long.valueOf(this.mBuffer.getLong());
                case 2:
                    try {
                        int i = this.mBuffer.getInt();
                        int position = this.mBuffer.position();
                        this.mBuffer.position(position + i);
                        return new String(this.mBuffer.array(), position, i, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        Log.wtf(EventLog.TAG, "UTF-8 is not supported", e);
                        return null;
                    }
                case 3:
                    byte b2 = this.mBuffer.get();
                    byte b3 = b2;
                    if (b2 < 0) {
                        b3 = b2 + 256;
                    }
                    Object[] objArr = new Object[b3];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        obj = objArr;
                        if (i3 >= b3) {
                            break;
                        } else {
                            objArr[i3] = decodeObject();
                            i2 = i3 + 1;
                        }
                    }
                default:
                    throw new IllegalArgumentException("Unknown entry type: " + ((int) b));
            }
            return obj;
        }

        public Object getData() {
            Object obj = null;
            synchronized (this) {
                try {
                    try {
                        short s = this.mBuffer.getShort(2);
                        short s2 = s;
                        if (s == 0) {
                            s2 = 20;
                        }
                        this.mBuffer.limit(this.mBuffer.getShort(0) + s2);
                        this.mBuffer.position(s2 + 4);
                        obj = decodeObject();
                    } catch (BufferUnderflowException e) {
                        Log.wtf(EventLog.TAG, "Truncated entry payload: tag=" + getTag(), e);
                    }
                } catch (IllegalArgumentException e2) {
                    Log.wtf(EventLog.TAG, "Illegal entry payload: tag=" + getTag(), e2);
                }
            }
            return obj;
        }

        public int getProcessId() {
            return this.mBuffer.getInt(4);
        }

        public int getTag() {
            short s = this.mBuffer.getShort(2);
            short s2 = s;
            if (s == 0) {
                s2 = 20;
            }
            return this.mBuffer.getInt(s2);
        }

        public int getThreadId() {
            return this.mBuffer.getInt(8);
        }

        public long getTimeNanos() {
            return (this.mBuffer.getInt(12) * 1000000000) + this.mBuffer.getInt(16);
        }
    }

    public static int getTagCode(String str) {
        readTagsFile();
        Integer num = sTagCodes.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static String getTagName(int i) {
        readTagsFile();
        return sTagNames.get(Integer.valueOf(i));
    }

    public static native void readEvents(int[] iArr, Collection<Event> collection) throws IOException;

    private static void readTagsFile() {
        BufferedReader bufferedReader;
        Throwable th;
        synchronized (EventLog.class) {
            try {
                if (sTagCodes == null || sTagNames == null) {
                    sTagCodes = new HashMap<>();
                    sTagNames = new HashMap<>();
                    Pattern compile = Pattern.compile(COMMENT_PATTERN);
                    Pattern compile2 = Pattern.compile(TAG_PATTERN);
                    BufferedReader bufferedReader2 = null;
                    try {
                        try {
                            bufferedReader = new BufferedReader(new FileReader(TAGS_FILE), 256);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (!compile.matcher(readLine).matches()) {
                                        Matcher matcher = compile2.matcher(readLine);
                                        if (matcher.matches()) {
                                            try {
                                                int parseInt = Integer.parseInt(matcher.group(1));
                                                String group = matcher.group(2);
                                                sTagCodes.put(group, Integer.valueOf(parseInt));
                                                sTagNames.put(Integer.valueOf(parseInt), group);
                                            } catch (NumberFormatException e) {
                                                Log.wtf(TAG, "Error in /system/etc/event-log-tags: " + readLine, e);
                                            }
                                        } else {
                                            Log.wtf(TAG, "Bad entry in /system/etc/event-log-tags: " + readLine);
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    bufferedReader2 = bufferedReader;
                                    Log.wtf(TAG, "Error reading /system/etc/event-log-tags", e);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                }
                            }
                        } catch (Throwable th3) {
                            bufferedReader = bufferedReader2;
                            th = th3;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = null;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public static native int writeEvent(int i, int i2);

    public static native int writeEvent(int i, long j);

    public static native int writeEvent(int i, String str);

    public static native int writeEvent(int i, Object... objArr);
}
