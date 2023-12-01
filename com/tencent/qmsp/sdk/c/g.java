package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/g.class */
public class g {
    private static final byte[] f = {51, 117, -95};
    private static final byte[] g = {38, 114, -96};
    private static final byte[] h = {20, 125, -96, 80, 13, 57, 57, -7, 36, 100};
    private static final byte[] i = {20, 125, -96, 80, 13, 57, 91, -20, 49};
    private static final byte[] j = {52, 100};
    private static final byte[] k = {20, 125, -96, 80, 96, 24, 117};
    private static final byte[][] l = {new byte[]{54, 100}, new byte[]{49, 99, -70}, new byte[]{54, 115}};
    private static g m;

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, Integer> f24863a = new ConcurrentHashMap<>();
    private CopyOnWriteArrayList<c> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f24864c;
    private long d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/g$a.class */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/g$b.class */
    public class b implements com.tencent.qmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.qmsp.sdk.b.e
        public void a(int i, JSONObject jSONObject) {
            if (i != 161 || jSONObject == null) {
                return;
            }
            g.this.a(jSONObject);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/g$c.class */
    public interface c {
        void a(List<Pair<Integer, Integer>> list);
    }

    private g() {
        AtomicInteger atomCbTimeout;
        Context context;
        this.f24864c = null;
        atomCbTimeout = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
        this.d = atomCbTimeout.get();
        this.e = 0;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        this.f24864c = context.getSharedPreferences(com.tencent.qmsp.sdk.c.b.f24856a + a(i), 0);
        b();
    }

    private int a(int i2, int i3) {
        return a(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private int a(Pair<Integer, Integer> pair) {
        AtomicInteger atomConnTimeOut;
        AtomicInteger atomConnTimeOut2;
        AtomicInteger atomConnTimeOut3;
        AtomicInteger atomReadTimeOut;
        AtomicInteger atomReadTimeOut2;
        AtomicInteger atomReadTimeOut3;
        AtomicInteger atomCbTimeout;
        AtomicInteger atomCbTimeout2;
        AtomicInteger atomCbTimeout3;
        AtomicInteger atomUpdateInterval;
        AtomicInteger atomUpdateInterval2;
        AtomicInteger atomUpdateInterval3;
        if (pair == null) {
            return -1;
        }
        switch (pair.first.intValue()) {
            case 10000:
                atomConnTimeOut = com.tencent.qmsp.sdk.app.a.getAtomConnTimeOut();
                if (atomConnTimeOut.get() == pair.second.intValue() || pair.second.intValue() <= 5000) {
                    return 0;
                }
                atomConnTimeOut2 = com.tencent.qmsp.sdk.app.a.getAtomConnTimeOut();
                atomConnTimeOut2.set(pair.second.intValue());
                String a2 = a(k);
                StringBuilder sb = new StringBuilder();
                sb.append("[CB-CYC] Socket Conn TimeOut: ");
                atomConnTimeOut3 = com.tencent.qmsp.sdk.app.a.getAtomConnTimeOut();
                sb.append(atomConnTimeOut3.get());
                com.tencent.qmsp.sdk.f.g.a(a2, 1, sb.toString());
                return 0;
            case 10001:
                atomReadTimeOut = com.tencent.qmsp.sdk.app.a.getAtomReadTimeOut();
                if (atomReadTimeOut.get() == pair.second.intValue() || pair.second.intValue() <= 5000) {
                    return 0;
                }
                atomReadTimeOut2 = com.tencent.qmsp.sdk.app.a.getAtomReadTimeOut();
                atomReadTimeOut2.set(pair.second.intValue());
                String a3 = a(k);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[CB-CYC] Socket Read TimeOut: ");
                atomReadTimeOut3 = com.tencent.qmsp.sdk.app.a.getAtomReadTimeOut();
                sb2.append(atomReadTimeOut3.get());
                com.tencent.qmsp.sdk.f.g.a(a3, 1, sb2.toString());
                return 0;
            case 10002:
                atomCbTimeout = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
                if (atomCbTimeout.get() == pair.second.intValue() || pair.second.intValue() <= 3600000) {
                    return 0;
                }
                atomCbTimeout2 = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
                atomCbTimeout2.set(pair.second.intValue());
                String a4 = a(k);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[CB-CYC] CB Ruery TimeOut : ");
                atomCbTimeout3 = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
                sb3.append(atomCbTimeout3.get());
                com.tencent.qmsp.sdk.f.g.a(a4, 1, sb3.toString());
                return 0;
            case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /* 10003 */:
                atomUpdateInterval = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
                if (atomUpdateInterval.get() == pair.second.intValue() || pair.second.intValue() <= 3600000) {
                    return 0;
                }
                atomUpdateInterval2 = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
                atomUpdateInterval2.set(pair.second.intValue());
                String a5 = a(k);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[CB-CYC] Plugin Ruery TimeOut : ");
                atomUpdateInterval3 = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
                sb4.append(atomUpdateInterval3.get());
                com.tencent.qmsp.sdk.f.g.a(a5, 1, sb4.toString());
                return 0;
            default:
                return -1;
        }
    }

    private Pair<Integer, Integer> a(String str, JSONObject jSONObject) {
        try {
            return new Pair<>(Integer.valueOf(Integer.parseInt(str)), Integer.valueOf(jSONObject.getInt(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String a(byte[] bArr) {
        return com.tencent.qmsp.sdk.f.h.a(bArr);
    }

    private void a(int i2, int i3, int i4) {
        com.tencent.qmsp.sdk.f.g.a(a(k), 1, String.format("[CB] report: funType=%d, result=%d,  NowTaskID=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        com.tencent.qmsp.sdk.a.g gVar = new com.tencent.qmsp.sdk.a.g();
        try {
            gVar.a(i2).a(i3).a(i4);
            com.tencent.qmsp.sdk.a.f.a(gVar.toString(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            com.tencent.qmsp.sdk.f.g.b(com.tencent.qmsp.sdk.f.g.f24913a, 0, "onReport error!");
        }
    }

    private void a(long j2) {
        f.i().c().postDelayed(new a(), j2);
    }

    private void a(String str) {
        JSONObject jSONObject;
        Iterator<String> keys;
        LinkedList linkedList = new LinkedList();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            a(1002, -1, this.e);
            e.printStackTrace();
        }
        if (jSONObject.getInt(a(f)) != 1) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(a(g));
        if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
            while (keys.hasNext()) {
                Pair<Integer, Integer> a2 = a(keys.next(), jSONObject2);
                if (a2 != null) {
                    a(a2);
                    Integer num = this.f24863a.get(a2.first);
                    if (num == null || num.byteValue() != a2.second.intValue()) {
                        linkedList.add(a2);
                    }
                    this.f24863a.put(a2.first, a2.second);
                }
            }
        }
        g();
        if (linkedList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("cb-->Result: ");
            sb.append(jSONObject);
            com.tencent.qmsp.sdk.f.g.a("Task: ", 0, sb.toString());
            int i2 = -1;
            if (!jSONObject.isNull(a(l[0]))) {
                i2 = -1;
                if (!jSONObject.isNull(a(l[1]))) {
                    i2 = -1;
                    if (!jSONObject.isNull(a(l[2]))) {
                        int optInt = jSONObject.optInt(a(l[0]));
                        this.e = Integer.valueOf(jSONObject.optString(a(l[1]))).intValue();
                        String optString = jSONObject.optString(a(l[2]));
                        i2 = optInt;
                        if (optInt == 0) {
                            i2 = optInt;
                            if (optString != null) {
                                i2 = optInt;
                                if (!optString.equals("")) {
                                    a(optString);
                                    i2 = optInt;
                                }
                            }
                        }
                    }
                }
            }
            a(1001, i2, this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(byte[] bArr) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            dataInputStream = null;
        }
        while (true) {
            DataInputStream dataInputStream3 = dataInputStream;
            try {
                if (dataInputStream.available() != 0) {
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    a(readInt, readInt2);
                    this.f24863a.put(Integer.valueOf(readInt), Integer.valueOf(readInt2));
                }
            } catch (IOException e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                e.printStackTrace();
                if (dataInputStream != null) {
                    dataInputStream3 = dataInputStream;
                    dataInputStream3.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                dataInputStream2 = dataInputStream;
                th = th2;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                dataInputStream3.close();
                return;
            } catch (IOException e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    private JSONObject c() {
        try {
            SharedPreferences.Editor edit = this.f24864c.edit();
            edit.putLong(a(j), System.currentTimeMillis());
            edit.commit();
            JSONObject jSONObject = new JSONObject();
            JSONObject a2 = com.tencent.qmsp.sdk.a.d.a(1);
            if (a2 == null) {
                com.tencent.qmsp.sdk.f.g.d(a(k), 0, "make query head Fail!");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.tencent.qmsp.sdk.a.e.a(20), 1);
            jSONObject2.put(com.tencent.qmsp.sdk.a.e.a(21), 512);
            jSONObject.put(com.tencent.qmsp.sdk.a.e.a(15), a2);
            jSONObject.put(com.tencent.qmsp.sdk.a.e.a(16), jSONObject2);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static g d() {
        if (m == null) {
            synchronized (g.class) {
                try {
                    if (m == null) {
                        m = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return m;
    }

    private String e() {
        return com.tencent.qmsp.sdk.a.b.a() + File.separator + a(h);
    }

    private boolean f() {
        AtomicInteger atomCbTimeout;
        AtomicInteger atomCbTimeout2;
        try {
            atomCbTimeout = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
            this.d = atomCbTimeout.get();
            long j2 = 0;
            long currentTimeMillis = System.currentTimeMillis() - this.f24864c.getLong(a(j), 0L);
            if (currentTimeMillis >= 0) {
                j2 = currentTimeMillis;
            }
            atomCbTimeout2 = com.tencent.qmsp.sdk.app.a.getAtomCbTimeout();
            if (j2 < atomCbTimeout2.get()) {
                this.d -= j2;
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private void g() {
        byte[] h2 = h();
        if (h2 != null) {
            new m().a(e(), h2, null, 1);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0102: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:55:0x0102 */
    private byte[] h() {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        DataOutputStream dataOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4 = null;
        try {
            try {
                byteArrayOutputStream3 = new ByteArrayOutputStream();
            } catch (IOException e) {
                e = e;
                byteArrayOutputStream = null;
                dataOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                dataOutputStream3 = new DataOutputStream(byteArrayOutputStream3);
            } catch (IOException e2) {
                e = e2;
                byteArrayOutputStream = byteArrayOutputStream3;
                dataOutputStream2 = null;
            } catch (Throwable th2) {
                byteArrayOutputStream4 = byteArrayOutputStream3;
                th = th2;
                dataOutputStream = null;
                if (byteArrayOutputStream4 != null) {
                    try {
                        byteArrayOutputStream4.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                for (Map.Entry<Integer, Integer> entry : this.f24863a.entrySet()) {
                    dataOutputStream3.writeInt(entry.getKey().intValue());
                    dataOutputStream3.writeInt(entry.getValue().intValue());
                }
                byte[] byteArray = byteArrayOutputStream3.toByteArray();
                try {
                    byteArrayOutputStream3.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    dataOutputStream3.close();
                    return byteArray;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return byteArray;
                }
            } catch (IOException e7) {
                byteArrayOutputStream = byteArrayOutputStream3;
                dataOutputStream2 = dataOutputStream3;
                e = e7;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                        return null;
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            byteArrayOutputStream4 = byteArrayOutputStream2;
        }
    }

    private void i() {
        String appID;
        try {
            a(1003, 0, this.e);
            JSONObject c2 = c();
            String a2 = a(k);
            StringBuilder sb = new StringBuilder();
            sb.append("CB: ");
            sb.append(c2.toString());
            com.tencent.qmsp.sdk.f.g.d(a2, 0, sb.toString());
            com.tencent.qmsp.sdk.b.g b2 = com.tencent.qmsp.sdk.b.g.b();
            appID = com.tencent.qmsp.sdk.app.a.getAppID();
            b2.a(1, appID, 1, c2, new b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a(int i2) {
        Integer num = this.f24863a.get(Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void a() {
        if (m != null) {
            m = null;
        }
    }

    public void a(c cVar) {
        this.b.add(cVar);
    }

    public void a(boolean z) {
        boolean taskStatus;
        String a2;
        StringBuilder sb;
        taskStatus = com.tencent.qmsp.sdk.app.a.getTaskStatus();
        if (!taskStatus) {
            com.tencent.qmsp.sdk.f.g.a(a(k), 1, "cb Task Finish！");
            return;
        }
        try {
            com.tencent.qmsp.sdk.f.g.a(a(k), 1, "Start to query cb!");
            if (!z) {
                if (f()) {
                    i();
                } else {
                    com.tencent.qmsp.sdk.f.g.a(a(k), 1, "time has not arrived!");
                }
            }
            a2 = a(k);
            sb = new StringBuilder();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                a2 = a(k);
                sb = new StringBuilder();
            } catch (Throwable th2) {
                String a3 = a(k);
                com.tencent.qmsp.sdk.f.g.a(a3, 0, "next time: " + this.d);
                a(this.d);
                throw th2;
            }
        }
        sb.append("next time: ");
        sb.append(this.d);
        com.tencent.qmsp.sdk.f.g.a(a2, 0, sb.toString());
        a(this.d);
    }

    public void b() {
        byte[] a2 = new m().a(e(), null, 1);
        if (a2 != null) {
            b(a2);
        }
    }
}
