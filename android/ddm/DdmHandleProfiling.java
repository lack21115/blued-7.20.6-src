package android.ddm;

import android.os.Debug;
import android.util.Log;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleProfiling.class */
public class DdmHandleProfiling extends ChunkHandler {
    private static final boolean DEBUG = false;
    public static final int CHUNK_MPRS = type("MPRS");
    public static final int CHUNK_MPRE = type("MPRE");
    public static final int CHUNK_MPSS = type("MPSS");
    public static final int CHUNK_MPSE = type("MPSE");
    public static final int CHUNK_MPRQ = type("MPRQ");
    public static final int CHUNK_SPSS = type("SPSS");
    public static final int CHUNK_SPSE = type("SPSE");
    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();

    private DdmHandleProfiling() {
    }

    private Chunk handleMPRE(Chunk chunk) {
        byte b;
        try {
            Debug.stopMethodTracing();
            b = 0;
        } catch (RuntimeException e) {
            Log.w("ddm-heap", "Method profiling end failed: " + e.getMessage());
            b = 1;
        }
        byte[] bArr = {b};
        return new Chunk(CHUNK_MPRE, bArr, 0, bArr.length);
    }

    private Chunk handleMPRQ(Chunk chunk) {
        byte[] bArr = {(byte) Debug.getMethodTracingMode()};
        return new Chunk(CHUNK_MPRQ, bArr, 0, bArr.length);
    }

    private Chunk handleMPRS(Chunk chunk) {
        ByteBuffer wrapChunk = wrapChunk(chunk);
        try {
            Debug.startMethodTracing(getString(wrapChunk, wrapChunk.getInt()), wrapChunk.getInt(), wrapChunk.getInt());
            return null;
        } catch (RuntimeException e) {
            return createFailChunk(1, e.getMessage());
        }
    }

    private Chunk handleMPSEOrSPSE(Chunk chunk, String str) {
        try {
            Debug.stopMethodTracing();
            return null;
        } catch (RuntimeException e) {
            Log.w("ddm-heap", str + " prof stream end failed: " + e.getMessage());
            return createFailChunk(1, e.getMessage());
        }
    }

    private Chunk handleMPSS(Chunk chunk) {
        ByteBuffer wrapChunk = wrapChunk(chunk);
        try {
            Debug.startMethodTracingDdms(wrapChunk.getInt(), wrapChunk.getInt(), false, 0);
            return null;
        } catch (RuntimeException e) {
            return createFailChunk(1, e.getMessage());
        }
    }

    private Chunk handleSPSS(Chunk chunk) {
        ByteBuffer wrapChunk = wrapChunk(chunk);
        try {
            Debug.startMethodTracingDdms(wrapChunk.getInt(), wrapChunk.getInt(), true, wrapChunk.getInt());
            return null;
        } catch (RuntimeException e) {
            return createFailChunk(1, e.getMessage());
        }
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
        DdmServer.registerHandler(CHUNK_SPSS, mInstance);
        DdmServer.registerHandler(CHUNK_SPSE, mInstance);
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
        if (i == CHUNK_MPRS) {
            return handleMPRS(chunk);
        }
        if (i == CHUNK_MPRE) {
            return handleMPRE(chunk);
        }
        if (i == CHUNK_MPSS) {
            return handleMPSS(chunk);
        }
        if (i == CHUNK_MPSE) {
            return handleMPSEOrSPSE(chunk, "Method");
        }
        if (i == CHUNK_MPRQ) {
            return handleMPRQ(chunk);
        }
        if (i == CHUNK_SPSS) {
            return handleSPSS(chunk);
        }
        if (i == CHUNK_SPSE) {
            return handleMPSEOrSPSE(chunk, "Sample");
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
