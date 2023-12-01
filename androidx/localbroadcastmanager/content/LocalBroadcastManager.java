package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/localbroadcastmanager/content/LocalBroadcastManager.class */
public final class LocalBroadcastManager {
    private static final Object f = new Object();
    private static LocalBroadcastManager g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f3046a;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<ReceiverRecord>> f3047c = new HashMap<>();
    private final ArrayList<BroadcastRecord> d = new ArrayList<>();
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord.class */
    public static final class BroadcastRecord {

        /* renamed from: a  reason: collision with root package name */
        final Intent f3049a;
        final ArrayList<ReceiverRecord> b;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f3049a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord.class */
    public static final class ReceiverRecord {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f3050a;
        final BroadcastReceiver b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3051c;
        boolean d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f3050a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f3050a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f3046a = context;
        this.e = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f) {
            if (g == null) {
                g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = g;
        }
        return localBroadcastManager;
    }

    void a() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.d.toArray(broadcastRecordArr);
                this.d.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    BroadcastRecord broadcastRecord = broadcastRecordArr[i2];
                    int size2 = broadcastRecord.b.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < size2) {
                            ReceiverRecord receiverRecord = broadcastRecord.b.get(i4);
                            if (!receiverRecord.d) {
                                receiverRecord.b.onReceive(this.f3046a, broadcastRecord.f3049a);
                            }
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList = this.b.get(broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList2);
            }
            arrayList2.add(receiverRecord);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    ArrayList<ReceiverRecord> arrayList3 = this.f3047c.get(action);
                    ArrayList<ReceiverRecord> arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList<>(1);
                        this.f3047c.put(action, arrayList4);
                    }
                    arrayList4.add(receiverRecord);
                    i = i2 + 1;
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f3046a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<ReceiverRecord> arrayList = this.f3047c.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                }
                ArrayList arrayList2 = null;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    ReceiverRecord receiverRecord = arrayList.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f3050a);
                    }
                    if (!receiverRecord.f3051c) {
                        IntentFilter intentFilter = receiverRecord.f3050a;
                        ArrayList arrayList3 = arrayList2;
                        int match = intentFilter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList2 = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList2.add(receiverRecord);
                            receiverRecord.f3051c = true;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    } else if (z) {
                        Log.v("LocalBroadcastManager", "  Filter's target already added");
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
                        ((ReceiverRecord) arrayList2.get(i4)).f3051c = false;
                        i3 = i4 + 1;
                    }
                    this.d.add(new BroadcastRecord(intent, arrayList2));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList<ReceiverRecord> remove = this.b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            int size = remove.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                ReceiverRecord receiverRecord = remove.get(i);
                receiverRecord.d = true;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < receiverRecord.f3050a.countActions()) {
                        String action = receiverRecord.f3050a.getAction(i3);
                        ArrayList<ReceiverRecord> arrayList = this.f3047c.get(action);
                        if (arrayList != null) {
                            int size2 = arrayList.size();
                            while (true) {
                                int i4 = size2 - 1;
                                if (i4 < 0) {
                                    break;
                                }
                                ReceiverRecord receiverRecord2 = arrayList.get(i4);
                                if (receiverRecord2.b == broadcastReceiver) {
                                    receiverRecord2.d = true;
                                    arrayList.remove(i4);
                                }
                                size2 = i4;
                            }
                            if (arrayList.size() <= 0) {
                                this.f3047c.remove(action);
                            }
                        }
                        i2 = i3 + 1;
                    }
                }
                size = i;
            }
        }
    }
}
