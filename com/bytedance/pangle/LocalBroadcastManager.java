package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/LocalBroadcastManager.class */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<b>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<b>> mActions = new HashMap<>();
    private final ArrayList<a> mPendingBroadcasts = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/LocalBroadcastManager$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f7741a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f7741a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/LocalBroadcastManager$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f7742a;
        final PluginBroadcastReceiver b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7743c;
        boolean d;

        b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f7742a = intentFilter;
            this.b = pluginBroadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f7742a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    final void executePendingBroadcasts() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.mPendingBroadcasts.toArray(aVarArr);
                this.mPendingBroadcasts.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    a aVar = aVarArr[i2];
                    int size2 = aVar.b.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < size2) {
                            b bVar = aVar.b.get(i4);
                            if (!bVar.d) {
                                bVar.b.onReceive(this.mAppContext, aVar.f7741a);
                            }
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            b bVar = new b(intentFilter, pluginBroadcastReceiver);
            ArrayList<b> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            ArrayList<b> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList2);
            }
            arrayList2.add(bVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    ArrayList<b> arrayList3 = this.mActions.get(action);
                    ArrayList<b> arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList<>(1);
                        this.mActions.put(action, arrayList4);
                    }
                    arrayList4.add(bVar);
                    i = i2 + 1;
                }
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(TAG, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList = this.mActions.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    Log.v(TAG, "Action list: ".concat(String.valueOf(arrayList)));
                }
                ArrayList arrayList2 = null;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    b bVar = arrayList.get(i2);
                    if (z) {
                        Log.v(TAG, "Matching against filter " + bVar.f7742a);
                    }
                    if (!bVar.f7743c) {
                        IntentFilter intentFilter = bVar.f7742a;
                        ArrayList arrayList3 = arrayList2;
                        int match = intentFilter.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (match >= 0) {
                            if (z) {
                                Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList2 = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList2.add(bVar);
                            bVar.f7743c = true;
                        } else if (z) {
                            Log.v(TAG, "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    } else if (z) {
                        Log.v(TAG, "  Filter's target already added");
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
                        ((b) arrayList2.get(i4)).f7743c = false;
                        i3 = i4 + 1;
                    }
                    this.mPendingBroadcasts.add(new a(intent, arrayList2));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public final void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<b> remove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (remove == null) {
                return;
            }
            int size = remove.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                b bVar = remove.get(i);
                bVar.d = true;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < bVar.f7742a.countActions()) {
                        String action = bVar.f7742a.getAction(i3);
                        ArrayList<b> arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            int size2 = arrayList.size();
                            while (true) {
                                int i4 = size2 - 1;
                                if (i4 < 0) {
                                    break;
                                }
                                b bVar2 = arrayList.get(i4);
                                if (bVar2.b == pluginBroadcastReceiver) {
                                    bVar2.d = true;
                                    arrayList.remove(i4);
                                }
                                size2 = i4;
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
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
