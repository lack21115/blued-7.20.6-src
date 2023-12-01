package android.ddm;

import android.util.Log;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleNativeHeap.class */
public class DdmHandleNativeHeap extends ChunkHandler {
    public static final int CHUNK_NHGT = type("NHGT");
    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();

    private DdmHandleNativeHeap() {
    }

    private native byte[] getLeakInfo();

    private Chunk handleNHGT(Chunk chunk) {
        byte[] leakInfo = getLeakInfo();
        if (leakInfo != null) {
            Log.i("ddm-nativeheap", "Sending " + leakInfo.length + " bytes");
            return new Chunk(ChunkHandler.type("NHGT"), leakInfo, 0, leakInfo.length);
        }
        return createFailChunk(1, "Something went wrong");
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        Log.i("ddm-nativeheap", "Handling " + name(chunk.type) + " chunk");
        int i = chunk.type;
        if (i == CHUNK_NHGT) {
            return handleNHGT(chunk);
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
