package android.ddm;

import android.os.Debug;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleHeap.class */
public class DdmHandleHeap extends ChunkHandler {
    public static final int CHUNK_HPIF = type("HPIF");
    public static final int CHUNK_HPSG = type("HPSG");
    public static final int CHUNK_HPDU = type("HPDU");
    public static final int CHUNK_HPDS = type("HPDS");
    public static final int CHUNK_NHSG = type("NHSG");
    public static final int CHUNK_HPGC = type("HPGC");
    public static final int CHUNK_REAE = type("REAE");
    public static final int CHUNK_REAQ = type("REAQ");
    public static final int CHUNK_REAL = type("REAL");
    private static DdmHandleHeap mInstance = new DdmHandleHeap();

    private DdmHandleHeap() {
    }

    private Chunk handleHPDS(Chunk chunk) {
        wrapChunk(chunk);
        String str = null;
        try {
            Debug.dumpHprofDataDdms();
        } catch (UnsupportedOperationException e) {
            str = "hprof dumps not supported in this VM";
        } catch (RuntimeException e2) {
            str = "Exception: " + e2.getMessage();
        }
        if (str != null) {
            Log.w("ddm-heap", str);
            return createFailChunk(1, str);
        }
        return null;
    }

    private Chunk handleHPDU(Chunk chunk) {
        byte b;
        ByteBuffer wrapChunk = wrapChunk(chunk);
        try {
            Debug.dumpHprofData(getString(wrapChunk, wrapChunk.getInt()));
            b = 0;
        } catch (IOException e) {
            b = -1;
        } catch (UnsupportedOperationException e2) {
            Log.w("ddm-heap", "hprof dumps not supported in this VM");
            b = -1;
        } catch (RuntimeException e3) {
            b = -1;
        }
        byte[] bArr = {b};
        return new Chunk(CHUNK_HPDU, bArr, 0, bArr.length);
    }

    private Chunk handleHPGC(Chunk chunk) {
        Runtime.getRuntime().gc();
        return null;
    }

    private Chunk handleHPIF(Chunk chunk) {
        if (DdmVmInternal.heapInfoNotify(wrapChunk(chunk).get())) {
            return null;
        }
        return createFailChunk(1, "Unsupported HPIF what");
    }

    private Chunk handleHPSGNHSG(Chunk chunk, boolean z) {
        ByteBuffer wrapChunk = wrapChunk(chunk);
        if (DdmVmInternal.heapSegmentNotify(wrapChunk.get(), wrapChunk.get(), z)) {
            return null;
        }
        return createFailChunk(1, "Unsupported HPSG what/when");
    }

    private Chunk handleREAE(Chunk chunk) {
        DdmVmInternal.enableRecentAllocations(wrapChunk(chunk).get() != 0);
        return null;
    }

    private Chunk handleREAL(Chunk chunk) {
        byte[] recentAllocations = DdmVmInternal.getRecentAllocations();
        return new Chunk(CHUNK_REAL, recentAllocations, 0, recentAllocations.length);
    }

    private Chunk handleREAQ(Chunk chunk) {
        byte b = 1;
        byte[] bArr = new byte[1];
        if (!DdmVmInternal.getRecentAllocationStatus()) {
            b = 0;
        }
        bArr[0] = b;
        return new Chunk(CHUNK_REAQ, bArr, 0, bArr.length);
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_HPIF, mInstance);
        DdmServer.registerHandler(CHUNK_HPSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPDU, mInstance);
        DdmServer.registerHandler(CHUNK_HPDS, mInstance);
        DdmServer.registerHandler(CHUNK_NHSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPGC, mInstance);
        DdmServer.registerHandler(CHUNK_REAE, mInstance);
        DdmServer.registerHandler(CHUNK_REAQ, mInstance);
        DdmServer.registerHandler(CHUNK_REAL, mInstance);
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
        if (i == CHUNK_HPIF) {
            return handleHPIF(chunk);
        }
        if (i == CHUNK_HPSG) {
            return handleHPSGNHSG(chunk, false);
        }
        if (i == CHUNK_HPDU) {
            return handleHPDU(chunk);
        }
        if (i == CHUNK_HPDS) {
            return handleHPDS(chunk);
        }
        if (i == CHUNK_NHSG) {
            return handleHPSGNHSG(chunk, true);
        }
        if (i == CHUNK_HPGC) {
            return handleHPGC(chunk);
        }
        if (i == CHUNK_REAE) {
            return handleREAE(chunk);
        }
        if (i == CHUNK_REAQ) {
            return handleREAQ(chunk);
        }
        if (i == CHUNK_REAL) {
            return handleREAL(chunk);
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
