package android.ddm;

import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleAppName.class */
public class DdmHandleAppName extends ChunkHandler {
    public static final int CHUNK_APNM = type("APNM");
    private static volatile String mAppName = "";
    private static DdmHandleAppName mInstance = new DdmHandleAppName();

    private DdmHandleAppName() {
    }

    public static String getAppName() {
        return mAppName;
    }

    public static void register() {
    }

    private static void sendAPNM(String str, int i) {
        ByteBuffer allocate = ByteBuffer.allocate((str.length() * 2) + 4 + 4);
        allocate.order(ChunkHandler.CHUNK_ORDER);
        allocate.putInt(str.length());
        putString(allocate, str);
        allocate.putInt(i);
        DdmServer.sendChunk(new Chunk(CHUNK_APNM, allocate));
    }

    public static void setAppName(String str, int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        mAppName = str;
        sendAPNM(str, i);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        return null;
    }
}
