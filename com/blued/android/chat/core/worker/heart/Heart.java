package com.blued.android.chat.core.worker.heart;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.PingPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/heart/Heart.class */
public class Heart extends BaseWorker implements PackageHandler {
    private static final int BACK_FREQ_SEC = 300;
    private static final int FORE_FREQ_SEC = 30;
    private static final String TAG = "Chat_Heart";
    private Connector connector;
    private PackSendHelper packSendHelper;
    private boolean appActived = false;
    private short heartFreq = 0;
    private HashSet<PingReceiveListener> pingReceiveListeners = new HashSet<>();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/heart/Heart$PingReceiveListener.class */
    public interface PingReceiveListener {
        void onReceivePing();
    }

    public Heart(Connector connector) {
        this.connector = connector;
        this.packSendHelper = connector.getPackageSendHelper();
        init();
    }

    private short getCurrentHeartFreq() {
        return getHeartFreq(this.appActived);
    }

    private short getHeartFreq(boolean z) {
        return (short) (z ? 30 : 300);
    }

    private void init() {
        this.connector.registerPackageHandler(2, this);
    }

    private void sendHeartPackage() {
        if (ChatManager.debug) {
            Log.v(TAG, "sendHeartPackage(), heartFreq:" + ((int) this.heartFreq));
        }
        this.packSendHelper.sendPackage(new PingPackage(this.heartFreq), null);
    }

    public void appActiveChanged(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "appActiveChanged(), actived:" + z + ", old actived:" + this.appActived);
        }
        this.heartFreq = getHeartFreq(z);
        if (this.appActived != z && isWorking()) {
            sendHeartPackage();
        }
        this.appActived = z;
        if (z) {
            PingCheckerManager.getInstance().checkImLink(null);
        }
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public String getWorkerName() {
        return "Heart";
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onReceive(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceive(), pack:" + basePackage);
        }
        if (basePackage.type != 2) {
            if (ChatManager.debug) {
                Log.e(TAG, "receive unknown package, pack:" + basePackage);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.pingReceiveListeners) {
            arrayList.addAll(this.pingReceiveListeners);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PingReceiveListener) it.next()).onReceivePing();
        }
        if (basePackage.ack) {
            return;
        }
        if (basePackage instanceof PingPackage) {
            int i = ((PingPackage) basePackage).freqMs;
            short s = this.heartFreq;
            if (i == s) {
                if (ChatManager.debug) {
                    Log.v(TAG, "ping pack, equal heart freq");
                }
                this.heartFreq = (short) 0;
            } else if (s == 0) {
                this.heartFreq = getCurrentHeartFreq();
            }
        }
        if (isWorking()) {
            sendHeartPackage();
        } else if (ChatManager.debug) {
            Log.e(TAG, "stopped, drop the ping pack");
        }
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onSendFailed(BasePackage basePackage, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "BasePackage(), pack:" + basePackage + ", failedMessage: " + str);
        }
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onSendSuccess(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSendSuccess(), pack:" + basePackage);
        }
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStart() {
        this.heartFreq = getCurrentHeartFreq();
        if (ChatManager.debug) {
            Log.v(TAG, "onStart(), heartFreq:" + ((int) this.heartFreq));
        }
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStop() {
        if (ChatManager.debug) {
            Log.v(TAG, "onStop()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pingTest() {
        if (ChatManager.debug) {
            Log.v(TAG, "pingTest()");
        }
        this.packSendHelper.sendPackage(new PingPackage(), null);
    }

    public void registerPingReceiveListener(PingReceiveListener pingReceiveListener) {
        synchronized (this.pingReceiveListeners) {
            this.pingReceiveListeners.add(pingReceiveListener);
        }
    }

    public void unregisterPingReceiveListener(PingReceiveListener pingReceiveListener) {
        synchronized (this.pingReceiveListeners) {
            this.pingReceiveListeners.remove(pingReceiveListener);
        }
    }
}
