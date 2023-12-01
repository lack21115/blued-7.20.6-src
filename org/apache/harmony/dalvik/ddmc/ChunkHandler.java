package org.apache.harmony.dalvik.ddmc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/dalvik/ddmc/ChunkHandler.class */
public abstract class ChunkHandler {
    public static final ByteOrder CHUNK_ORDER = ByteOrder.BIG_ENDIAN;
    public static final int CHUNK_FAIL = type("FAIL");

    public static Chunk createFailChunk(int i, String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        ByteBuffer allocate = ByteBuffer.allocate((str2.length() * 2) + 8);
        allocate.order(CHUNK_ORDER);
        allocate.putInt(i);
        allocate.putInt(str2.length());
        putString(allocate, str2);
        return new Chunk(CHUNK_FAIL, allocate);
    }

    public static String getString(ByteBuffer byteBuffer, int i) {
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return new String(cArr);
            }
            cArr[i3] = byteBuffer.getChar();
            i2 = i3 + 1;
        }
    }

    public static String name(int i) {
        return new String(new char[]{(char) ((i >> 24) & 255), (char) ((i >> 16) & 255), (char) ((i >> 8) & 255), (char) (i & 255)});
    }

    public static void putString(ByteBuffer byteBuffer, String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            byteBuffer.putChar(str.charAt(i2));
            i = i2 + 1;
        }
    }

    public static int type(String str) {
        if (str.length() != 4) {
            throw new IllegalArgumentException("Bad type name: " + str);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return i;
            }
            i = (i << 8) | (str.charAt(i3) & 255);
            i2 = i3 + 1;
        }
    }

    public static ByteBuffer wrapChunk(Chunk chunk) {
        ByteBuffer wrap = ByteBuffer.wrap(chunk.data, chunk.offset, chunk.length);
        wrap.order(CHUNK_ORDER);
        return wrap;
    }

    public abstract void connected();

    public abstract void disconnected();

    public abstract Chunk handleChunk(Chunk chunk);
}
