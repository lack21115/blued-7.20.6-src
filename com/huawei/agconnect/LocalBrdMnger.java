package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/LocalBrdMnger.class */
public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = new Object();
    private static LocalBrdMnger mInstance;
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/LocalBrdMnger$BroadcastRecord.class */
    public static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/LocalBrdMnger$ReceiverRecord.class */
    public static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.receiver + " filter=" + this.filter + i.d;
        }
    }

    private LocalBrdMnger(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.huawei.agconnect.LocalBrdMnger.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBrdMnger.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingBroadcasts() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    BroadcastRecord broadcastRecord = broadcastRecordArr[i2];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < broadcastRecord.receivers.size()) {
                            broadcastRecord.receivers.get(i4).receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public static LocalBrdMnger getInstance(Context context) {
        LocalBrdMnger localBrdMnger;
        synchronized (M_LOCK) {
            if (mInstance == null) {
                mInstance = new LocalBrdMnger(context.getApplicationContext());
            }
            localBrdMnger = mInstance;
        }
        return localBrdMnger;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.mReceivers.get(broadcastReceiver);
            ArrayList<IntentFilter> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList2);
            }
            arrayList2.add(intentFilter);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    ArrayList<ReceiverRecord> arrayList3 = this.mActions.get(action);
                    ArrayList<ReceiverRecord> arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList<>(1);
                        this.mActions.put(action, arrayList4);
                    }
                    arrayList4.add(receiverRecord);
                    i = i2 + 1;
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList<ReceiverRecord> arrayList = this.mActions.get(intent.getAction());
            if (arrayList != null) {
                ArrayList arrayList2 = null;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    ReceiverRecord receiverRecord = arrayList.get(i2);
                    if (!receiverRecord.broadcasting) {
                        IntentFilter intentFilter = receiverRecord.filter;
                        ArrayList arrayList3 = arrayList2;
                        if (intentFilter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                            arrayList2 = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList2.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                        }
                    }
                    i = i2 + 1;
                }
                if (arrayList2 != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= arrayList2.size()) {
                            break;
                        }
                        ((ReceiverRecord) arrayList2.get(i4)).broadcasting = false;
                        i3 = i4 + 1;
                    }
                    this.mPendingBroadcasts.add(new BroadcastRecord(intent, arrayList2));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<IntentFilter> remove = this.mReceivers.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= remove.size()) {
                    return;
                }
                IntentFilter intentFilter = remove.get(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < intentFilter.countActions()) {
                        String action = intentFilter.getAction(i4);
                        ArrayList<ReceiverRecord> arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= arrayList.size()) {
                                    break;
                                }
                                int i7 = i6;
                                if (arrayList.get(i6).receiver == broadcastReceiver) {
                                    arrayList.remove(i6);
                                    i7 = i6 - 1;
                                }
                                i5 = i7 + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }
    }
}
