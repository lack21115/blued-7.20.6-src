package android.ddm;

import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleThread.class */
public class DdmHandleThread extends ChunkHandler {
    public static final int CHUNK_THEN = type("THEN");
    public static final int CHUNK_THCR = type("THCR");
    public static final int CHUNK_THDE = type("THDE");
    public static final int CHUNK_THST = type("THST");
    public static final int CHUNK_STKL = type("STKL");
    private static DdmHandleThread mInstance = new DdmHandleThread();

    private DdmHandleThread() {
    }

    private Chunk createStackChunk(StackTraceElement[] stackTraceElementArr, int i) {
        int i2 = 0 + 4 + 4 + 4;
        int length = stackTraceElementArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            int length2 = i2 + (stackTraceElement.getClassName().length() * 2) + 4 + (stackTraceElement.getMethodName().length() * 2) + 4 + 4;
            int i5 = length2;
            if (stackTraceElement.getFileName() != null) {
                i5 = length2 + (stackTraceElement.getFileName().length() * 2);
            }
            i2 = i5 + 4;
            i3 = i4 + 1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.putInt(0);
        allocate.putInt(i);
        allocate.putInt(stackTraceElementArr.length);
        int length3 = stackTraceElementArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length3) {
                return new Chunk(CHUNK_STKL, allocate);
            }
            StackTraceElement stackTraceElement2 = stackTraceElementArr[i7];
            allocate.putInt(stackTraceElement2.getClassName().length());
            putString(allocate, stackTraceElement2.getClassName());
            allocate.putInt(stackTraceElement2.getMethodName().length());
            putString(allocate, stackTraceElement2.getMethodName());
            if (stackTraceElement2.getFileName() != null) {
                allocate.putInt(stackTraceElement2.getFileName().length());
                putString(allocate, stackTraceElement2.getFileName());
            } else {
                allocate.putInt(0);
            }
            allocate.putInt(stackTraceElement2.getLineNumber());
            i6 = i7 + 1;
        }
    }

    private Chunk handleSTKL(Chunk chunk) {
        int i = wrapChunk(chunk).getInt();
        StackTraceElement[] stackTraceById = DdmVmInternal.getStackTraceById(i);
        return stackTraceById == null ? createFailChunk(1, "Stack trace unavailable") : createStackChunk(stackTraceById, i);
    }

    private Chunk handleTHEN(Chunk chunk) {
        DdmVmInternal.threadNotify(wrapChunk(chunk).get() != 0);
        return null;
    }

    private Chunk handleTHST(Chunk chunk) {
        wrapChunk(chunk);
        byte[] threadStats = DdmVmInternal.getThreadStats();
        return threadStats != null ? new Chunk(CHUNK_THST, threadStats, 0, threadStats.length) : createFailChunk(1, "Can't build THST chunk");
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }

    @Override // org.apache.harmony.dalvik.ddmc.ChunkHandler
    public void connected() {
    }

    @Override // org.apache.harmony.dalvik.ddmc.ChunkHandler
    public void disconnected() {
    }

    @Override // org.apache.harmony.dalvik.ddmc.ChunkHandler
    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        if (i == CHUNK_THEN) {
            return handleTHEN(chunk);
        }
        if (i == CHUNK_THST) {
            return handleTHST(chunk);
        }
        if (i == CHUNK_STKL) {
            return handleSTKL(chunk);
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
