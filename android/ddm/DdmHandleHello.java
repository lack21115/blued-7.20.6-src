package android.ddm;

import android.os.Debug;
import android.os.Process;
import android.os.UserHandle;
import dalvik.system.VMRuntime;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleHello.class */
public class DdmHandleHello extends ChunkHandler {
    public static final int CHUNK_HELO = type("HELO");
    public static final int CHUNK_WAIT = type("WAIT");
    public static final int CHUNK_FEAT = type("FEAT");
    private static DdmHandleHello mInstance = new DdmHandleHello();
    private static final String[] FRAMEWORK_FEATURES = {"opengl-tracing", "view-hierarchy"};

    private DdmHandleHello() {
    }

    private Chunk handleFEAT(Chunk chunk) {
        String[] vmFeatureList = Debug.getVmFeatureList();
        int length = ((vmFeatureList.length + FRAMEWORK_FEATURES.length) * 4) + 4;
        int length2 = vmFeatureList.length;
        while (true) {
            int i = length2 - 1;
            if (i < 0) {
                break;
            }
            length += vmFeatureList[i].length() * 2;
            length2 = i;
        }
        int i2 = length;
        int length3 = FRAMEWORK_FEATURES.length - 1;
        while (true) {
            int i3 = length3;
            if (i3 < 0) {
                break;
            }
            i2 += FRAMEWORK_FEATURES[i3].length() * 2;
            length3 = i3 - 1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ChunkHandler.CHUNK_ORDER);
        allocate.putInt(vmFeatureList.length + FRAMEWORK_FEATURES.length);
        int length4 = vmFeatureList.length;
        while (true) {
            int i4 = length4 - 1;
            if (i4 < 0) {
                break;
            }
            allocate.putInt(vmFeatureList[i4].length());
            putString(allocate, vmFeatureList[i4]);
            length4 = i4;
        }
        int length5 = FRAMEWORK_FEATURES.length;
        while (true) {
            int i5 = length5 - 1;
            if (i5 < 0) {
                return new Chunk(CHUNK_FEAT, allocate);
            }
            allocate.putInt(FRAMEWORK_FEATURES[i5].length());
            putString(allocate, FRAMEWORK_FEATURES[i5]);
            length5 = i5;
        }
    }

    private Chunk handleHELO(Chunk chunk) {
        wrapChunk(chunk).getInt();
        String str = System.getProperty("java.vm.name", "?") + " v" + System.getProperty("java.vm.version", "?");
        String appName = DdmHandleAppName.getAppName();
        VMRuntime runtime = VMRuntime.getRuntime();
        String str2 = runtime.is64Bit() ? "64-bit" : "32-bit";
        String vmInstructionSet = runtime.vmInstructionSet();
        String str3 = str2;
        if (vmInstructionSet != null) {
            str3 = str2;
            if (vmInstructionSet.length() > 0) {
                str3 = str2 + " (" + vmInstructionSet + ")";
            }
        }
        String str4 = "CheckJNI=" + (runtime.isCheckJniEnabled() ? "true" : "false");
        ByteBuffer allocate = ByteBuffer.allocate((str.length() * 2) + 28 + (appName.length() * 2) + (str3.length() * 2) + (str4.length() * 2));
        allocate.order(ChunkHandler.CHUNK_ORDER);
        allocate.putInt(1);
        allocate.putInt(Process.myPid());
        allocate.putInt(str.length());
        allocate.putInt(appName.length());
        putString(allocate, str);
        putString(allocate, appName);
        allocate.putInt(UserHandle.myUserId());
        allocate.putInt(str3.length());
        putString(allocate, str3);
        allocate.putInt(str4.length());
        putString(allocate, str4);
        Chunk chunk2 = new Chunk(CHUNK_HELO, allocate);
        if (Debug.waitingForDebugger()) {
            sendWAIT(0);
        }
        return chunk2;
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    public static void sendWAIT(int i) {
        DdmServer.sendChunk(new Chunk(CHUNK_WAIT, new byte[]{(byte) i}, 0, 1));
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
        if (i == CHUNK_HELO) {
            return handleHELO(chunk);
        }
        if (i == CHUNK_FEAT) {
            return handleFEAT(chunk);
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
