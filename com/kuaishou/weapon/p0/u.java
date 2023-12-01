package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/u.class */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10258a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10259c = 4;
    public static final int d = 0;
    public static final int e = 8;
    public static final int f = 1;
    public static final int g = 3;
    public static final int h = 4;
    private static long o;
    private Context j;
    private q k;
    private t l;
    private File m;
    private Cdo n;
    private int p;
    private boolean r;
    private int q = 0;
    List<Integer> i = new ArrayList();
    private Map<Integer, a> s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/u$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f10260a;

        public a(int i) {
            this.f10260a = i;
        }
    }

    public u(Context context, int i, boolean z) {
        this.p = 0;
        this.r = false;
        this.j = context;
        this.k = q.a(context);
        this.l = t.a(context);
        this.n = Cdo.a(context);
        this.m = new File(context.getFilesDir(), ".tmp");
        this.p = i;
        this.r = z;
    }

    private void a(s sVar) {
        boolean z;
        long j;
        try {
            if (!TextUtils.isEmpty(sVar.j) && sVar.j.length() >= 10) {
                if (!this.m.exists()) {
                    this.m.mkdir();
                }
                File file = new File(this.m, sVar.f10253a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sVar.d + ".tmp");
                File file2 = new File(this.m, sVar.f10253a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sVar.d + ".zip");
                boolean a2 = l.a(this.j).a(sVar.i, file);
                boolean z2 = a2;
                if (!a2) {
                    z2 = l.a(this.j).a(sVar.i, file);
                }
                if (z2) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int c2 = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c2 != 0) {
                        long length = file2.exists() ? file2.length() : -1L;
                        if (file2.exists()) {
                            file2.delete();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("e", cj.p);
                        StringBuilder sb = new StringBuilder();
                        sb.append(sVar.f10253a);
                        hashMap.put("pk", sb.toString());
                        hashMap.put("pv", sVar.d);
                        hashMap.put("m", sVar.j);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(length);
                        hashMap.put("len", sb2.toString());
                        hashMap.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                        bg.a(this.j, "1002001", hashMap);
                        z2 = false;
                    }
                    if (c2 == 0 && file.exists()) {
                        file.delete();
                    }
                    z = "e";
                } else {
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sVar.f10253a);
                    hashMap2.put("pk", sb3.toString());
                    hashMap2.put("pv", sVar.d);
                    hashMap2.put("m", sVar.j);
                    z = "e";
                    hashMap2.put(z, "download fail");
                    hashMap2.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                    bg.a(this.j, "1002001", hashMap2);
                    this.s.put(Integer.valueOf(sVar.f10253a), new a(3));
                }
                String a3 = f.a(file2);
                if (z2 && sVar.j.equals(a3)) {
                    dm.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.e = file2.getAbsolutePath();
                    if (this.k.a(sVar, (String) null, (String) null)) {
                        if (this.s != null && !this.s.containsKey(Integer.valueOf(sVar.f10253a))) {
                            this.s.put(Integer.valueOf(sVar.f10253a), new a(1));
                        }
                        this.n.a(Cdo.b, System.currentTimeMillis(), true);
                        return;
                    }
                    if (this.s != null && !this.s.containsKey(Integer.valueOf(sVar.f10253a))) {
                        this.s.put(Integer.valueOf(sVar.f10253a), new a(4));
                    }
                    this.k.a(sVar.f10253a, sVar.d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    j = file.length();
                    file.delete();
                } else {
                    j = -1;
                }
                this.k.a(sVar.f10253a, sVar.d, (PackageInfo) null);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(z, cj.q);
                hashMap3.put("ret", z2 ? "1" : "0");
                hashMap3.put("am", sVar.j);
                hashMap3.put("acm", a3);
                hashMap3.put("p", file2.getAbsolutePath());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(j);
                hashMap3.put("len", sb4.toString());
                hashMap3.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                bg.a(this.j, "1002001", hashMap3);
                return;
            }
            this.k.a(sVar.f10253a, sVar.d, (PackageInfo) null);
        } catch (Throwable th) {
            this.k.a(sVar.f10253a, sVar.d, (PackageInfo) null);
        }
    }

    public JSONObject a() {
        try {
            String str = ct.f10190a + ct.g;
            String a2 = cu.a(this.j);
            String str2 = str;
            if (!TextUtils.isEmpty(a2)) {
                str2 = str + "?" + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c2 = cu.c(this.j);
            if (c2 != null) {
                jSONObject.put("data", new bm(this.j).c(c2.toString()));
            }
            l a3 = l.a(this.j);
            m mVar = new m(str2, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a3.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt == -7) {
                    Cdo.a(this.j).a(Cdo.f10221a, 1, false);
                    return null;
                }
                return null;
            }
            String a4 = new bm(this.j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a4)) {
                if (this.q == 0) {
                    this.q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a4);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            if (this.n != null) {
                this.n.a(Cdo.b, System.currentTimeMillis(), true);
                return null;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        String str;
        try {
            synchronized (u.class) {
                if (this.p == 1 || this.p == 2 || this.p == 4 || this.r || System.currentTimeMillis() - o >= 300000) {
                    this.l.d();
                    o = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.n.a(Cdo.b)) - (this.n.a(Cdo.f10222c, 6) * 3600000) > 0) {
                        List<s> a2 = this.l.a();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<s> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject a3 = a();
                        if (a3 == null) {
                            throw new Exception("pluginJsonObject is null ");
                        }
                        try {
                            boolean b2 = dl.b(this.j);
                            Iterator<String> keys = a3.keys();
                            HashSet<String> hashSet = new HashSet();
                            boolean z3 = false;
                            while (true) {
                                z = z3;
                                if (!keys.hasNext()) {
                                    break;
                                }
                                String next = keys.next();
                                if (b2 && next.endsWith("64")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".32";
                                        hashSet.add(str);
                                        z3 = true;
                                    } else {
                                        z2 = true;
                                        z3 = z2;
                                    }
                                } else if (b2 || !next.endsWith("32")) {
                                    if (!b2 || !next.endsWith("v8")) {
                                        z2 = z;
                                        if (!b2) {
                                            z2 = z;
                                            if (next.endsWith("v7")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                                }
                                            }
                                        }
                                        z3 = z2;
                                    } else if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".v7";
                                        hashSet.add(str);
                                        z3 = true;
                                    }
                                    z2 = true;
                                    z3 = z2;
                                } else if (next.length() > 3) {
                                    hashSet.add(next.substring(0, next.length() - 3));
                                    str = next.substring(0, next.length() - 3) + ".64";
                                    hashSet.add(str);
                                    z3 = true;
                                } else {
                                    z2 = true;
                                    z3 = z2;
                                }
                            }
                            if (z) {
                                for (String str2 : hashSet) {
                                    a3.remove(str2);
                                }
                            }
                        } catch (Throwable th) {
                            z = false;
                        }
                        Iterator<String> keys2 = a3.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            s a4 = o.a(a3.optJSONObject(next2));
                            if (a4 != null) {
                                if (z && !a4.y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                    a4.y = true;
                                }
                                if (a4.v) {
                                    arrayList4.add(next2);
                                }
                                if (!a4.y) {
                                    arrayList3.add(a4);
                                }
                                int indexOf = a2.indexOf(a4);
                                if (indexOf >= 0 && a4.y) {
                                    s sVar = a2.get(indexOf);
                                    if (dm.b(a4.d, sVar.d)) {
                                        if (a4.x != sVar.x) {
                                            this.l.c(a4.f10253a, a4.x);
                                        }
                                        if (!this.l.d(a4.f10253a)) {
                                            arrayList2.add(a4);
                                        }
                                    } else {
                                        this.n.a(Cdo.b, System.currentTimeMillis(), true);
                                        if (a4.x != sVar.x) {
                                            this.l.c(a4.f10253a, a4.x);
                                        }
                                        arrayList.add(a4);
                                    }
                                    a2.remove(indexOf);
                                } else if (a4.y) {
                                    arrayList2.add(a4);
                                }
                            }
                        }
                        for (s sVar2 : a2) {
                            if (!arrayList4.contains(sVar2.f10254c)) {
                                if (this.i != null) {
                                    this.i.add(Integer.valueOf(sVar2.f10253a));
                                }
                                this.k.a(sVar2.f10254c);
                            }
                        }
                        for (s sVar3 : arrayList3) {
                            if (!arrayList4.contains(sVar3.f10254c)) {
                                if (this.i != null) {
                                    this.i.add(Integer.valueOf(sVar3.f10253a));
                                }
                                this.k.a(sVar3.f10254c);
                            }
                        }
                        ArrayList<s> arrayList5 = new ArrayList();
                        if (arrayList2.size() != 0) {
                            arrayList5.addAll(arrayList2);
                        }
                        if (arrayList.size() != 0) {
                            arrayList5.addAll(arrayList);
                        }
                        for (s sVar4 : arrayList5) {
                            if (sVar4 != null) {
                                if (arrayList.contains(sVar4)) {
                                    this.k.a(sVar4.f10253a, sVar4.d, (PackageInfo) null);
                                } else if (arrayList2.contains(sVar4)) {
                                    a(sVar4);
                                }
                            }
                        }
                    } else {
                        this.k.c();
                        this.l.b();
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                this.k.c();
                this.l.b();
            } finally {
                WeaponHI.iD();
            }
        }
    }
}
