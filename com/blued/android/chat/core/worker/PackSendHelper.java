package com.blued.android.chat.core.worker;

import android.os.SystemClock;
import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.utils.DataUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/PackSendHelper.class */
public class PackSendHelper extends BaseWorker implements TimeoutUtils.TimeoutListener {
    private static final String TAG = "Chat_PackSendHelper";
    private static PackCallback emptyPackCallback = new PackCallback() { // from class: com.blued.android.chat.core.worker.PackSendHelper.1
        @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
        public void onAckTimeout(BasePackage basePackage) {
        }

        @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
        public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
        }

        @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
        public void onSendFailed(BasePackage basePackage) {
        }

        @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
        public void onSendFinish(BasePackage basePackage) {
        }

        @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
        public void onSendTimeout(BasePackage basePackage) {
        }
    };
    private Connector connector;
    private ConcurrentHashMap<Long, Pair<StatePackage, PackCallback>> sendingList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Short, Pair<StatePackage, PackCallback>> sendingListForType = new ConcurrentHashMap<>();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/PackSendHelper$PackCallback.class */
    public interface PackCallback {
        void onAckTimeout(BasePackage basePackage);

        void onReceiveAck(BasePackage basePackage, BasePackage basePackage2);

        void onSendFailed(BasePackage basePackage);

        void onSendFinish(BasePackage basePackage);

        void onSendTimeout(BasePackage basePackage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/PackSendHelper$StatePackage.class */
    public static class StatePackage {
        public static final int ACK_FINISHED = 4;
        public static final int IDLE = 0;
        public static final int SENDING = 1;
        public static final int SENDING_FAILED = 2;
        public static final int WAITING_ACK = 3;
        final BasePackage basePackage;
        private int _state = 0;
        private long _lastStateTime = System.currentTimeMillis();

        public StatePackage(BasePackage basePackage) {
            this.basePackage = basePackage;
        }

        public void changeState(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ChatManager.debug) {
                Log.v(PackSendHelper.TAG, "(" + this.basePackage.localId + ") change state: " + stateToString(this._state) + " -> " + stateToString(i) + ", take time: " + (currentTimeMillis - this._lastStateTime));
            }
            this._state = i;
            this._lastStateTime = currentTimeMillis;
        }

        public int getState() {
            return this._state;
        }

        protected String stateToString(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return "UNKNOWN(" + i + ")";
                            }
                            return "ACK_FINISHED";
                        }
                        return "WAITING_ACK";
                    }
                    return "SENDING_FAILED";
                }
                return "SENDING";
            }
            return "IDLE";
        }
    }

    public PackSendHelper(Connector connector) {
        this.connector = connector;
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    protected String getWorkerName() {
        return "PackSendHelper";
    }

    public boolean handlePackageSendFailed(BasePackage basePackage, String str) {
        Pair<StatePackage, PackCallback> remove = basePackage.localId > 0 ? this.sendingList.remove(Long.valueOf(basePackage.localId)) : this.sendingListForType.remove(Short.valueOf(basePackage.type));
        if (remove != null) {
            DataUtils.imMessageFailed(BasePackage.typeToString(((StatePackage) remove.first).basePackage), SystemClock.uptimeMillis() - ((StatePackage) remove.first).basePackage.sendTime, str);
            ((StatePackage) remove.first).changeState(2);
            PackCallback packCallback = (PackCallback) remove.second;
            if (packCallback != null) {
                packCallback.onSendFailed(((StatePackage) remove.first).basePackage);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean handlePackageSendFinish(BasePackage basePackage) {
        Pair<StatePackage, PackCallback> pair = basePackage.localId > 0 ? this.sendingList.get(Long.valueOf(basePackage.localId)) : this.sendingListForType.get(Short.valueOf(basePackage.type));
        if (pair != null) {
            ((StatePackage) pair.first).changeState(3);
            PackCallback packCallback = (PackCallback) pair.second;
            if (packCallback != null) {
                packCallback.onSendFinish(((StatePackage) pair.first).basePackage);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean handleReceiveAckPackage(BasePackage basePackage) {
        Pair<StatePackage, PackCallback> remove = basePackage.localId > 0 ? this.sendingList.remove(Long.valueOf(basePackage.localId)) : this.sendingListForType.remove(Short.valueOf(basePackage.type));
        if (remove != null) {
            if (ChatManager.debug) {
                Log.v(TAG, "(" + basePackage.localId + ") receive ack: " + basePackage);
            }
            DataUtils.imMessageSuccess(BasePackage.typeToString(((StatePackage) remove.first).basePackage), SystemClock.uptimeMillis() - ((StatePackage) remove.first).basePackage.sendTime);
            ((StatePackage) remove.first).changeState(4);
            PackCallback packCallback = (PackCallback) remove.second;
            if (packCallback != null) {
                packCallback.onReceiveAck(((StatePackage) remove.first).basePackage, basePackage);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.blued.android.chat.core.utils.TimeoutUtils.TimeoutListener
    public void onPackageTimeout(long j, Object obj) {
        Pair<StatePackage, PackCallback> remove = this.sendingList.remove(Long.valueOf(j));
        Pair<StatePackage, PackCallback> pair = remove;
        if (remove == null) {
            pair = this.sendingListForType.remove(Long.valueOf(j));
        }
        if (pair != null) {
            int state = ((StatePackage) pair.first).getState();
            ((StatePackage) pair.first).changeState(2);
            String typeToString = BasePackage.typeToString(((StatePackage) pair.first).basePackage);
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = ((StatePackage) pair.first).basePackage.sendTime;
            DataUtils.imMessageFailed(typeToString, uptimeMillis - j2, "package timeout, old state:" + ((StatePackage) pair.first).stateToString(state) + ", connect state:" + this.connector.getConnectStatus());
            PackCallback packCallback = (PackCallback) pair.second;
            if (packCallback != null) {
                if (state == 1) {
                    packCallback.onSendTimeout(((StatePackage) pair.first).basePackage);
                } else if (state == 3) {
                    packCallback.onAckTimeout(((StatePackage) pair.first).basePackage);
                }
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStop() {
        this.sendingList.clear();
        this.sendingListForType.clear();
    }

    public void sendPackage(BasePackage basePackage, int i, PackCallback packCallback) {
        if (ChatManager.debug) {
            Log.v(TAG, "(" + basePackage.localId + ") sendPackage: " + basePackage);
        }
        PackCallback packCallback2 = packCallback;
        if (ChatManager.debug) {
            packCallback2 = packCallback;
            if (packCallback == null) {
                packCallback2 = emptyPackCallback;
            }
        }
        if (basePackage.localId > 0 && packCallback2 != null) {
            StatePackage statePackage = new StatePackage(basePackage);
            statePackage.changeState(1);
            this.sendingList.put(Long.valueOf(basePackage.localId), new Pair<>(statePackage, packCallback2));
            TimeoutUtils.addTimeoutPackage(basePackage.localId, basePackage, i, this);
        }
        this.connector.sendPackage(basePackage);
    }

    public void sendPackage(BasePackage basePackage, PackCallback packCallback) {
        sendPackage(basePackage, 30000, packCallback);
    }
}
