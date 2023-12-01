package com.blued.android.chat.core.worker.chat;

import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.im.private_chat.ReceiptOuterClass;
import java.util.Collection;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/ReadFlagSender.class */
public class ReadFlagSender {
    private static final int FREQ_MS = 5000;
    private static final int IDLE_MS = 3000;
    private static final int MAX_ID_DIFF = 20;
    private static final String TAG = "Chat_ReadFlagSender";
    private long lastTime;
    private Timer timer;
    private final Object timerLock = new Object();
    private final Map<String, ReceiptModel> readPackagePending = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/ReadFlagSender$MyTimerTask.class */
    public class MyTimerTask extends TimerTask {
        private MyTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ReadFlagSender.this.processPendingList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/ReadFlagSender$ReceiptModel.class */
    public static class ReceiptModel {
        public boolean isDeleteMsg;
        public long msgId;
        public ReceiptType receiptType;
        public long sessionId;
        public short sessionType;

        public ReceiptModel(short s, long j, long j2, ReceiptType receiptType) {
            this.sessionType = s;
            this.sessionId = j;
            this.msgId = j2;
            this.receiptType = receiptType;
        }

        public ReceiptModel(short s, long j, long j2, ReceiptType receiptType, boolean z) {
            this.sessionType = s;
            this.sessionId = j;
            this.msgId = j2;
            this.receiptType = receiptType;
            this.isDeleteMsg = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/ReadFlagSender$ReceiptType.class */
    public enum ReceiptType {
        READ,
        RECEIVED
    }

    private void checkTimer() {
        synchronized (this.timerLock) {
            if (this.timer == null) {
                Timer timer = new Timer();
                this.timer = timer;
                timer.scheduleAtFixedRate(new MyTimerTask(), 5000L, 5000L);
                if (ChatManager.debug) {
                    Log.v(TAG, "start timer");
                }
            }
        }
    }

    private long getSessionId(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = -j;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingList() {
        if (ChatManager.debug) {
            Log.v(TAG, "timeout to processPendingList()");
        }
        synchronized (this.readPackagePending) {
            Collection<ReceiptModel> values = this.readPackagePending.values();
            if (values.size() > 0) {
                if (ChatManager.debug) {
                    Log.v(TAG, "pending list size:" + values.size());
                }
                for (ReceiptModel receiptModel : values) {
                    sendReceipt(receiptModel);
                }
                this.readPackagePending.clear();
            }
            if (System.currentTimeMillis() - this.lastTime > 3000) {
                synchronized (this.timerLock) {
                    if (this.timer != null) {
                        this.timer.cancel();
                        this.timer.purge();
                        this.timer = null;
                        if (ChatManager.debug) {
                            Log.v(TAG, "close timer");
                        }
                    }
                }
            }
        }
    }

    private void saveToPendingList(String str, ReceiptModel receiptModel) {
        this.lastTime = System.currentTimeMillis();
        this.readPackagePending.put(str, receiptModel);
        checkTimer();
    }

    private void sendReceipt(ReceiptModel receiptModel) {
        try {
            ReceiptOuterClass.ReceiptRequest build = ReceiptOuterClass.ReceiptRequest.newBuilder().setCommon(Common.a().b()).setSessionType(receiptModel.sessionType).setFrom((int) ChatManager.getInstance().getUid()).setTo((int) receiptModel.sessionId).setIsDeleteMsg(receiptModel.isDeleteMsg).setSeqnum((int) receiptModel.msgId).build();
            boolean z = false;
            if (receiptModel.receiptType == ReceiptType.READ) {
                IM.b(false, build, null);
            } else if (receiptModel.receiptType == ReceiptType.RECEIVED) {
                if (receiptModel.sessionType == 3) {
                    z = true;
                }
                IM.a(z, build, (GrpcUnaryCall.OnFinishListener) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void sendReadReceiptImmediate(short s, long j, long j2) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendReadReceiptImmediate read flag, sessionType:" + ((int) s) + ", sessionId:" + j + ", msgId:" + j2);
        }
        sendReceipt(new ReceiptModel(s, j, j2, ReceiptType.READ, false));
    }

    public void sendReceipt(short s, long j, long j2, ReceiptType receiptType) {
        if (ChatManager.debug) {
            Log.v(TAG, "send read flag, sessionType:" + ((int) s) + ", sessionId:" + j + ", msgId:" + j2 + ", receiptType:" + receiptType);
        }
        if (s != 2) {
            receiptType = ReceiptType.RECEIVED;
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        ReceiptModel receiptModel = new ReceiptModel(s, getSessionId(j), j2, receiptType);
        synchronized (this.readPackagePending) {
            ReceiptModel receiptModel2 = this.readPackagePending.get(sessionKey);
            if (receiptModel2 == null) {
                if (ChatManager.debug) {
                    Log.v(TAG, "save this read pack to pending list");
                }
                saveToPendingList(sessionKey, receiptModel);
            } else if (receiptModel2.msgId > receiptModel.msgId) {
                if (ChatManager.debug) {
                    Log.e(TAG, "why current id is lower than older, oldId:" + receiptModel2.msgId);
                }
            } else {
                this.readPackagePending.remove(sessionKey);
                if (receiptModel.msgId - receiptModel2.msgId > 20) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "current is larger than older more, so send it now");
                    }
                    sendReceipt(receiptModel);
                } else {
                    if (ChatManager.debug) {
                        Log.v(TAG, "save this read pack to pending list");
                    }
                    saveToPendingList(sessionKey, receiptModel);
                }
                if (receiptModel2.receiptType != receiptModel.receiptType) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "old read type is not equal this one, so send old now");
                    }
                    sendReceipt(receiptModel2);
                }
            }
        }
    }

    public void sendReceiptImmediate(short s, long j, long j2, ReceiptType receiptType) {
        ReceiptModel remove;
        if (ChatManager.debug) {
            Log.v(TAG, "sendImmediate read flag, sessionType:" + ((int) s) + ", sessionId:" + j + ", msgId:" + j2 + ", receiptType:" + receiptType);
        }
        ReceiptType receiptType2 = receiptType;
        if (s != 2) {
            receiptType2 = ReceiptType.RECEIVED;
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.readPackagePending) {
            remove = this.readPackagePending.remove(sessionKey);
        }
        ReceiptModel receiptModel = new ReceiptModel(s, getSessionId(j), j2, receiptType2);
        if (remove == null) {
            sendReceipt(receiptModel);
            return;
        }
        ReceiptModel receiptModel2 = remove.msgId > receiptModel.msgId ? remove : receiptModel;
        if (receiptModel.receiptType == ReceiptType.READ || remove.receiptType != ReceiptType.READ) {
            remove = receiptModel;
        }
        sendReceipt(remove);
        if (receiptModel2 != remove) {
            sendReceipt(receiptModel2);
        }
    }

    public void sendReceiptImmediateForOrder(short s, long j, long j2, ReceiptType receiptType, boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendImmediateForRetraction read flag, sessionType:" + ((int) s) + ", sessionId:" + j + ", msgId:" + j2 + ", receiptType:" + receiptType + ", isOrder:" + z);
        }
        ReceiptType receiptType2 = receiptType;
        if (s != 2) {
            receiptType2 = receiptType;
            if (s != 3) {
                receiptType2 = ReceiptType.RECEIVED;
            }
        }
        sendReceipt(new ReceiptModel(s, j, j2, receiptType2, true));
    }
}
