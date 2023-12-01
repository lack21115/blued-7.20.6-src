package com.anythink.core.common;

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

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/m.class */
public final class m {
    static final int a = 1;
    private static final String b = "InnerBroadcastManager";
    private static final boolean c = false;
    private static final Object i = new Object();
    private static m j;
    private final Context d;
    private final HashMap<BroadcastReceiver, ArrayList<b>> e = new HashMap<>();
    private final HashMap<String, ArrayList<b>> f = new HashMap<>();
    private final ArrayList<a> g = new ArrayList<>();
    private final Handler h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/m$a.class */
    public static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/m$b.class */
    public static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.util.i.d);
            return sb.toString();
        }
    }

    private m(Context context) {
        this.d = context;
        this.h = new Handler(context.getMainLooper()) { // from class: com.anythink.core.common.m.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    m.this.a();
                }
            }
        };
    }

    public static m a(Context context) {
        m mVar;
        synchronized (i) {
            if (j == null) {
                j = new m(context.getApplicationContext());
            }
            mVar = j;
        }
        return mVar;
    }

    private void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    final void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.e) {
                size = this.g.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.g.toArray(aVarArr);
                this.g.clear();
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < size) {
                    a aVar = aVarArr[i3];
                    int size2 = aVar.b.size();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < size2) {
                            b bVar = aVar.b.get(i5);
                            if (!bVar.d) {
                                bVar.b.onReceive(this.d, aVar.a);
                            }
                            i4 = i5 + 1;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.e) {
            ArrayList<b> remove = this.e.remove(broadcastReceiver);
            if (remove != null) {
                int size = remove.size();
                while (true) {
                    int i2 = size - 1;
                    if (i2 < 0) {
                        break;
                    }
                    b bVar = remove.get(i2);
                    bVar.d = true;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < bVar.a.countActions()) {
                            String action = bVar.a.getAction(i4);
                            ArrayList<b> arrayList = this.f.get(action);
                            if (arrayList != null) {
                                int size2 = arrayList.size();
                                while (true) {
                                    int i5 = size2 - 1;
                                    if (i5 < 0) {
                                        break;
                                    }
                                    b bVar2 = arrayList.get(i5);
                                    if (bVar2.b == broadcastReceiver) {
                                        bVar2.d = true;
                                        arrayList.remove(i5);
                                    }
                                    size2 = i5;
                                }
                                if (arrayList.size() <= 0) {
                                    this.f.remove(action);
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                    size = i2;
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.e) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.e.get(broadcastReceiver);
            ArrayList<b> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList2);
            }
            arrayList2.add(bVar);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i3);
                    ArrayList<b> arrayList3 = this.f.get(action);
                    ArrayList<b> arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList<>(1);
                        this.f.put(action, arrayList4);
                    }
                    arrayList4.add(bVar);
                    i2 = i3 + 1;
                }
            }
        }
    }

    public final boolean a(Intent intent) {
        synchronized (this.e) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.d.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList = this.f.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList)));
                }
                ArrayList arrayList2 = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    b bVar = arrayList.get(i3);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.a);
                    }
                    if (!bVar.c) {
                        IntentFilter intentFilter = bVar.a;
                        ArrayList arrayList3 = arrayList2;
                        int match = intentFilter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList2 = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList2.add(bVar);
                            bVar.c = true;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    } else if (z) {
                        Log.v("LocalBroadcastManager", "  Filter's target already added");
                    }
                    i2 = i3 + 1;
                }
                if (arrayList2 != null) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= arrayList2.size()) {
                            break;
                        }
                        ((b) arrayList2.get(i5)).c = false;
                        i4 = i5 + 1;
                    }
                    this.g.add(new a(intent, arrayList2));
                    if (!this.h.hasMessages(1)) {
                        this.h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
