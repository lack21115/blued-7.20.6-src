package android.ddm;

import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmRegister.class */
public class DdmRegister {
    private DdmRegister() {
    }

    public static void registerHandlers() {
        DdmHandleHello.register();
        DdmHandleThread.register();
        DdmHandleHeap.register();
        DdmHandleNativeHeap.register();
        DdmHandleProfiling.register();
        DdmHandleExit.register();
        DdmHandleViewDebug.register();
        DdmServer.registrationComplete();
    }
}
