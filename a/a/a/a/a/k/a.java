package a.a.a.a.a.k;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1393a = new Object();
    public static a b;
    public Context f;
    public Handler g;
    public HandlerThread h;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f1394c = new HashMap<>();
    public final HashMap<String, ArrayList<c>> d = new HashMap<>();
    public final ArrayList<b> e = new ArrayList<>();
    public boolean i = false;
    public boolean j = false;

    /* renamed from: a.a.a.a.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/a$a.class */
    public class HandlerC0013a extends Handler {
        public HandlerC0013a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.c();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/a$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f1396a;
        public final ArrayList<c> b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f1396a = intent;
            this.b = arrayList;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/a$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f1397a;
        public final BroadcastReceiver b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1398c;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1397a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f1397a);
            sb.append(i.d);
            return sb.toString();
        }
    }

    public static a a() {
        a aVar;
        synchronized (f1393a) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        if (this.f == null) {
            throw new IllegalStateException("Context is NULL");
        }
        synchronized (this.f1394c) {
            ArrayList<IntentFilter> remove = this.f1394c.remove(broadcastReceiver);
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
                        ArrayList<c> arrayList = this.d.get(action);
                        if (arrayList != null) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= arrayList.size()) {
                                    break;
                                }
                                int i7 = i6;
                                if (arrayList.get(i6).b == broadcastReceiver) {
                                    arrayList.remove(i6);
                                    i7 = i6 - 1;
                                }
                                i5 = i7 + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.d.remove(action);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f == null) {
            e.f1361c.e("QosBroadcastManager", "Context is NULL");
        }
        synchronized (this.f1394c) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f1394c.get(broadcastReceiver);
            ArrayList<IntentFilter> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.f1394c.put(broadcastReceiver, arrayList2);
            }
            arrayList2.add(intentFilter);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    ArrayList<c> arrayList3 = this.d.get(action);
                    ArrayList<c> arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList<>(1);
                        this.d.put(action, arrayList4);
                    }
                    arrayList4.add(cVar);
                    i = i2 + 1;
                }
            }
        }
    }

    public void a(Context context) {
        synchronized (this.f1394c) {
            if (context != null) {
                if (!this.j) {
                    this.j = true;
                    this.f = context.getApplicationContext();
                    HandlerThread handlerThread = new HandlerThread("QosBroadcastManager");
                    this.h = handlerThread;
                    handlerThread.start();
                    this.g = new HandlerC0013a(this.h.getLooper());
                }
            }
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a(Intent intent) {
        synchronized (this.f1394c) {
            if (this.i && this.f != null && this.j) {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    e.f1361c.a("QosBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList = this.d.get(intent.getAction());
                if (arrayList != null) {
                    if (z) {
                        e.f1361c.a("QosBroadcastManager", "Action list: " + arrayList);
                    }
                    ArrayList arrayList2 = null;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        c cVar = arrayList.get(i2);
                        if (z) {
                            e.f1361c.a("QosBroadcastManager", "Matching against filter " + cVar.f1397a);
                        }
                        if (!cVar.f1398c) {
                            IntentFilter intentFilter = cVar.f1397a;
                            ArrayList arrayList3 = arrayList2;
                            int match = intentFilter.match(action, resolveTypeIfNeeded, scheme, data, categories, "QosBroadcastManager");
                            if (match >= 0) {
                                if (z) {
                                    e.f1361c.a("QosBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList2 = arrayList3 == null ? new ArrayList() : arrayList3;
                                arrayList2.add(cVar);
                                cVar.f1398c = true;
                            } else if (z) {
                                String str = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category";
                                e.f1361c.a("QosBroadcastManager", "  Filter did not match: " + str);
                            }
                        } else if (z) {
                            e.f1361c.a("QosBroadcastManager", "  Filter's target already added");
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
                            ((c) arrayList2.get(i4)).f1398c = false;
                            i3 = i4 + 1;
                        }
                        this.e.add(new b(intent, arrayList2));
                        if (!this.g.hasMessages(1)) {
                            this.g.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public void b() {
        synchronized (this.f1394c) {
            if (this.j) {
                this.j = false;
                this.h.quit();
                this.h = null;
            }
        }
    }

    public final void c() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f1394c) {
                size = this.e.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.e.toArray(bVarArr);
                this.e.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    b bVar = bVarArr[i2];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < bVar.b.size()) {
                            bVar.b.get(i4).b.onReceive(this.f, bVar.f1396a);
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }
}
