package com.blued.android.chat.core.worker;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.ims.ImsConferenceState;
import com.android.internal.widget.LockPatternUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.IMDebuger;
import com.blued.android.chat.core.pack.BaseAckPackage;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.ConnAckPackage;
import com.blued.android.chat.core.pack.ConnPackage;
import com.blued.android.chat.core.pack.DisconnectPackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.core.worker.link.LinkListener;
import com.blued.android.chat.core.worker.link.Linker;
import com.blued.android.chat.data.ConnectState;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.DataUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/Connector.class */
public class Connector extends BaseWorker implements PackageHandler, TimeoutUtils.TimeoutListener, LinkListener {
    private static final int MAX_RETRY_COUNT = 2;
    private static final String TAG = "Chat_Connector";
    private PackSendHelper _packageSendHelper;
    private Linker linker;
    private int connPackSendRetryCount = 0;
    private long connPackLocalId = 0;
    private Set<ConnectListener> connectListenerList = new HashSet();
    private SparseArray<PackageHandler> packHandlerList = new SparseArray<>();
    private boolean connectForbidden = false;
    private ConnectState currentState = ConnectState.DISCONNECT;
    private Object disconnectWaiting = new Object();

    /* renamed from: com.blued.android.chat.core.worker.Connector$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/Connector$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$data$ConnectState;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ConnectState.values().length];
            $SwitchMap$com$blued$android$chat$data$ConnectState = iArr;
            try {
                iArr[ConnectState.DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$data$ConnectState[ConnectState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$blued$android$chat$data$ConnectState[ConnectState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Connector() {
        init();
        this._packageSendHelper = new PackSendHelper(this);
    }

    private void changeState(ConnectState connectState) {
        HashSet<ConnectListener> hashSet = new HashSet();
        synchronized (this.connectListenerList) {
            hashSet.addAll(this.connectListenerList);
        }
        this.currentState = connectState;
        for (ConnectListener connectListener : hashSet) {
            if (connectState == ConnectState.DISCONNECT) {
                IMDebuger.setImStatus("disconnect");
                connectListener.onDisconnected();
            } else if (connectState == ConnectState.CONNECTING) {
                IMDebuger.setImStatus("connecting");
                connectListener.onConnecting();
            } else if (connectState == ConnectState.CONNECTED) {
                IMDebuger.setImStatus(ImsConferenceState.STATUS_CONNECTED);
                this.connPackSendRetryCount = 0;
                connectListener.onConnected();
            }
        }
    }

    private void connect() {
        if (ChatManager.debug) {
            Log.v(TAG, "connect(), connectForbidden:" + this.connectForbidden + ", state:" + getState());
        }
        if (this.connectForbidden || !isWorking()) {
            return;
        }
        this.linker.link();
    }

    private void disconnect() {
        if (ChatManager.debug) {
            Log.v(TAG, "disconnect()");
        }
        this.linker.unlink();
    }

    private void notifyDisconnect(int i, String str) {
        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
        if (tipsListener != null) {
            if (ChatManager.debug) {
                Log.v(TAG, "notify tipsListener disconnect, code:" + i + ", reason:" + str);
            }
            tipsListener.onDisconnect(i, str);
        }
    }

    private void notifyPackageSendFailed(BasePackage basePackage, String str) {
        PackageHandler packageHandler;
        if (this._packageSendHelper.handlePackageSendFailed(basePackage, str) || (packageHandler = this.packHandlerList.get(basePackage.type)) == null) {
            return;
        }
        packageHandler.onSendFailed(basePackage, str);
    }

    private void receiveConnAck(ConnAckPackage connAckPackage) {
        ConnPackage connPackage = (ConnPackage) TimeoutUtils.cancelTimeoutPackage(this.connPackLocalId);
        if (connPackage != null) {
            DataUtils.imMessageSuccess(BasePackage.typeToString(connPackage), SystemClock.uptimeMillis() - connPackage.sendTime);
        }
        switch (connAckPackage.code) {
            case 0:
                if (ChatManager.debug) {
                    Log.v(TAG, "conn ack success, change to authed");
                }
                this.linker.linkAuthed();
                return;
            case 1:
            case 2:
            case 3:
                if (ChatManager.debug) {
                    Log.v(TAG, "conn ack failed, need reconnect");
                }
                reconnect();
                return;
            case 4:
            case 6:
                if (ChatManager.debug) {
                    Log.v(TAG, "conn ack failed, connect reject, forbidden connect and unlink");
                }
                this.connectForbidden = true;
                disconnect();
                notifyDisconnect(3, connAckPackage.reason);
                return;
            case 5:
                if (ChatManager.debug) {
                    Log.v(TAG, "conn ack failed, auth failed, forbidden connect and unlink");
                }
                this.connectForbidden = true;
                disconnect();
                notifyDisconnect(1, connAckPackage.reason);
                return;
            default:
                disconnect();
                return;
        }
    }

    private void reconnect() {
        if (ChatManager.debug) {
            Log.v(TAG, "reconnect(), connectForbidden:" + this.connectForbidden + ", state:" + getState());
        }
        if (this.connectForbidden || !isWorking()) {
            return;
        }
        this.linker.relink(false);
    }

    private void recvDisconnectPackage(DisconnectPackage disconnectPackage) {
        if (disconnectPackage.code == 3) {
            this.connectForbidden = true;
            notifyDisconnect(3, disconnectPackage.reason);
            disconnect();
        } else if (disconnectPackage.code != 4) {
            disconnect();
        } else {
            this.connectForbidden = true;
            notifyDisconnect(4, disconnectPackage.reason);
            disconnect();
        }
    }

    private boolean sendConnPack() {
        if (TextUtils.isEmpty(ChatManager.userInfo.encryToken)) {
            return false;
        }
        ConnPackage connPackage = new ConnPackage(ChatManager.userInfo.uid, ChatManager.userInfo.encryToken);
        long j = this.connPackLocalId;
        if (j != 0) {
            TimeoutUtils.cancelTimeoutPackage(j);
        }
        this.connPackLocalId = ChatHelper.getLocalId();
        this.linker.sendPackage(connPackage);
        TimeoutUtils.addTimeoutPackage(this.connPackLocalId, connPackage, LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS, this);
        return true;
    }

    private void sendConnPackFailed(ConnPackage connPackage, String str) {
        if (connPackage != null) {
            DataUtils.imMessageFailed(BasePackage.typeToString(connPackage), SystemClock.uptimeMillis() - connPackage.sendTime, str);
        }
        if (!isWorking() || this.connectForbidden) {
            if (ChatManager.debug) {
                Log.v(TAG, "don't deal this conn pack");
                return;
            }
            return;
        }
        int i = this.connPackSendRetryCount + 1;
        this.connPackSendRetryCount = i;
        if (i < 2) {
            if (ChatManager.debug) {
                Log.v(TAG, "retry send conn pack, connPackSendRetryCount:" + this.connPackSendRetryCount);
            }
            sendConnPack();
        } else if (i == 2) {
            switchToBackupLink();
        } else {
            if (ChatManager.debug) {
                Log.v(TAG, "retry limited, disconnect, connPackSendRetryCount:" + this.connPackSendRetryCount);
            }
            disconnect();
            ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
            if (tipsListener != null) {
                tipsListener.onConnectException("connect package failed, excep:" + str);
            }
        }
    }

    private void sendDisconnectPack() {
        DisconnectPackage disconnectPackage = new DisconnectPackage();
        this.linker.sendPackage(disconnectPackage, false);
        try {
            if (ChatManager.debug) {
                Log.v(TAG, "waiting disconnect package");
            }
            synchronized (this.disconnectWaiting) {
                this.disconnectWaiting.wait(3000L);
            }
            if (ChatManager.debug) {
                Log.v(TAG, "receive disconnect package, stop wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.linker.cancelPackage(disconnectPackage);
    }

    private void switchToBackupLink() {
        if (ChatManager.debug) {
            Log.v(TAG, "switchToBackupLink()");
        }
        this.linker.relink(true);
    }

    public void appActiveChanged(boolean z) {
        if (this.connectForbidden || !isWorking()) {
            return;
        }
        this.linker.appActiveChanged(z);
    }

    public void cancelPackage(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "cancelPackage(), pack:" + basePackage);
        }
        this.linker.cancelPackage(basePackage);
    }

    public void checkNet() {
        if (ChatManager.debug) {
            Log.v(TAG, "checkNet(), connectForbidden:" + this.connectForbidden + ", state:" + getState());
        }
        if (this.connectForbidden || !isWorking()) {
            return;
        }
        this.linker.checkNet();
    }

    public ConnectState getConnectStatus() {
        return this.currentState;
    }

    public PackSendHelper getPackageSendHelper() {
        return this._packageSendHelper;
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    protected String getWorkerName() {
        return "Connector";
    }

    public void init() {
        if (this.linker == null) {
            this.linker = new Linker();
        }
        this.linker.registerLinkListener(this);
        registerPackageHandler(1, this);
        registerPackageHandler(14, this);
        registerPackageHandler(13, this);
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkReceive(BasePackage basePackage) {
        if (basePackage instanceof ReqAckPackage) {
            ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage;
            if (reqAckPackage.result != 0 || reqAckPackage.error != 0) {
                DataUtils.imMessageFailed(BasePackage.typeToString(basePackage), SystemClock.uptimeMillis() - basePackage.sendTime, reqAckPackage.ackResultToString());
            }
        } else if (basePackage instanceof BaseAckPackage) {
            BaseAckPackage baseAckPackage = (BaseAckPackage) basePackage;
            if (baseAckPackage.result != 0) {
                DataUtils.imMessageFailed(BasePackage.typeToString(basePackage), SystemClock.uptimeMillis() - basePackage.sendTime, baseAckPackage.ackResultToString());
            }
        }
        if (basePackage.ack && this._packageSendHelper.handleReceiveAckPackage(basePackage)) {
            return;
        }
        PackageHandler packageHandler = this.packHandlerList.get(basePackage.type);
        if (packageHandler != null) {
            packageHandler.onReceive(basePackage);
        } else if (ChatManager.debug) {
            Log.v(TAG, "none handler need this pack");
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkSendFailed(BasePackage basePackage, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkSendFailed(), pack:" + basePackage + ", failedMessage: " + str);
        }
        notifyPackageSendFailed(basePackage, str);
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkSendSuccess(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkSendSuccess(), pack:" + basePackage);
        }
        if (this._packageSendHelper.handlePackageSendFinish(basePackage)) {
            return;
        }
        PackageHandler packageHandler = this.packHandlerList.get(basePackage.type);
        if (packageHandler != null) {
            packageHandler.onSendSuccess(basePackage);
        } else if (ChatManager.debug) {
            Log.v(TAG, "none handler need this pack");
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkStateChanged(int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkStateChanged(), newState:" + i);
        }
        if (i == 0) {
            changeState(ConnectState.DISCONNECT);
            if (!ChatManager.debug || ChatManager.getInstance().debugTipsListener == null) {
                return;
            }
            ChatManager.getInstance().debugTipsListener.onTips("连接失败");
        } else if (i == 1) {
            changeState(ConnectState.CONNECTING);
        } else if (i == 2) {
            if (sendConnPack()) {
                return;
            }
            if (ChatManager.debug) {
                Log.v(TAG, "sendConnPack failed, unlink linker");
            }
            this.linker.unlink();
        } else if (i == 3) {
            changeState(ConnectState.CONNECTED);
            if (!ChatManager.debug || ChatManager.getInstance().debugTipsListener == null) {
                return;
            }
            ChatManager.getInstance().debugTipsListener.onTips("鉴权成功");
        } else if (ChatManager.debug) {
            Log.e(TAG, "unknown link state:" + i);
        }
    }

    @Override // com.blued.android.chat.core.utils.TimeoutUtils.TimeoutListener
    public void onPackageTimeout(long j, Object obj) {
        if (ChatManager.debug) {
            Log.v(TAG, "onPackageTimeout(), keyId:" + j + ", data:" + obj);
        }
        if (obj instanceof ConnPackage) {
            if (j == this.connPackLocalId) {
                ConnPackage connPackage = (ConnPackage) obj;
                if (connPackage != null) {
                    DataUtils.imMessageFailed(BasePackage.typeToString(connPackage), SystemClock.uptimeMillis() - connPackage.sendTime, "package timeout");
                }
                if (this.linker.getState() >= 3 || this.linker.getState() < 2) {
                    return;
                }
                sendConnPackFailed(connPackage, "send timeout");
            } else if (ChatManager.debug) {
                Log.v(TAG, "the timeout pack is not current connPack, timeout id:" + j + ", current id:" + this.connPackLocalId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onPause() {
        super.onPause();
        if (ChatManager.debug) {
            Log.v(TAG, "onPause()");
        }
        sendDisconnectPack();
        this._packageSendHelper.stop();
        disconnect();
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onReceive(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceive(), pack:" + basePackage);
        }
        short s = basePackage.type;
        if (s == 1) {
            if (basePackage.ack && (basePackage instanceof ConnAckPackage)) {
                receiveConnAck((ConnAckPackage) basePackage);
            } else if (ChatManager.debug) {
                Log.e(TAG, "can't handle this CONNECT pack");
            }
        } else if (s == 13) {
            reconnect();
        } else if (s != 14) {
            if (ChatManager.debug) {
                Log.e(TAG, "receive unknown package, pack:" + basePackage);
            }
        } else {
            synchronized (this.disconnectWaiting) {
                this.disconnectWaiting.notify();
            }
            if (basePackage instanceof DisconnectPackage) {
                recvDisconnectPackage((DisconnectPackage) basePackage);
            } else if (ChatManager.debug) {
                Log.e(TAG, "can't handle this DISCONNECT pack");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onResume() {
        super.onResume();
        if (ChatManager.debug) {
            Log.v(TAG, "onResume()");
        }
        this._packageSendHelper.start();
        connect();
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onSendFailed(BasePackage basePackage, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSendFailed(), pack:" + basePackage);
        }
        if (basePackage.type == 1 && (basePackage instanceof ConnPackage)) {
            TimeoutUtils.cancelTimeoutPackage(this.connPackLocalId);
            sendConnPackFailed((ConnPackage) basePackage, "send failed: " + str);
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
        if (ChatManager.debug) {
            Log.v(TAG, "start()");
        }
        this.connectForbidden = false;
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStop() {
        if (ChatManager.debug) {
            Log.v(TAG, "stop()");
        }
    }

    public void pingFailed() {
        if (ChatManager.debug) {
            Log.v(TAG, "pingFailed(), currentState:" + this.currentState);
        }
        if (this.currentState == ConnectState.CONNECTED) {
            reconnect();
        } else {
            checkNet();
        }
    }

    public void registerConnectListener(ConnectListener connectListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerConnectListener(), listener:" + connectListener);
        }
        if (connectListener == null) {
            return;
        }
        synchronized (this.connectListenerList) {
            this.connectListenerList.add(connectListener);
        }
        int i = AnonymousClass1.$SwitchMap$com$blued$android$chat$data$ConnectState[this.currentState.ordinal()];
        if (i == 1) {
            connectListener.onDisconnected();
        } else if (i == 2) {
            connectListener.onConnecting();
        } else if (i != 3) {
        } else {
            connectListener.onConnected();
        }
    }

    public void registerPackageHandler(int i, PackageHandler packageHandler) {
        this.packHandlerList.put(i, packageHandler);
    }

    public void sendPackage(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendPackage(), pack:" + basePackage);
        }
        if (!this.connectForbidden && isWorking()) {
            this.linker.sendPackage(basePackage);
            return;
        }
        if (ChatManager.debug) {
            Log.v(TAG, "stopped, notifyPackageSendFailed");
        }
        String str = "";
        if (basePackage instanceof SendMsgPackage) {
            str = ", msgType: " + ((int) ((SendMsgPackage) basePackage).msgType) + "";
        }
        notifyPackageSendFailed(basePackage, "stopped, state: " + getState() + ", connectState: " + getConnectStatus() + ", connectForbidden: " + this.connectForbidden + ", packageType: " + ((int) basePackage.type) + ", name: " + basePackage.getClass().getSimpleName() + str);
    }

    public void unregisterConnectListener(ConnectListener connectListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterConnectListener(), listener:" + connectListener);
        }
        synchronized (this.connectListenerList) {
            this.connectListenerList.remove(connectListener);
        }
    }

    public void unregisterPackageHandler(int i, PackageHandler packageHandler) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterPackageHandler(), type:" + i + ", handler:" + packageHandler);
        }
        if (this.packHandlerList.get(i) == packageHandler) {
            this.packHandlerList.remove(i);
        }
    }
}
