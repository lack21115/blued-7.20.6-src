package com.amap.api.col.p0003sl;

import android.app.backup.FullBackup;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.jx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jx.class */
public final class jx {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f5235a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f5236c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<kj> f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jx$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jx$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f5237a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        double f5238c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jx$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jx$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        kc f5239a;
        long b;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jx$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jx$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        Map<String, List<a>> f5240a;
        Map<String, String> b;

        private c() {
            this.f5240a = new HashMap(8);
            this.b = new HashMap(8);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f5240a.equals(cVar.f5240a) && this.b.equals(cVar.b);
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f5240a;
            int i = 0;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }
    }

    public static String a(String str, String str2) throws hn {
        synchronized (jx.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = hp.f5081c;
                        if (b == null) {
                            b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !b.contains(str2)) {
                            b.add(str2);
                            String a2 = jj.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(a2)) {
                                a(str2, new JSONObject(a2));
                            }
                        }
                        if (f5235a != null && f5235a.size() > 0) {
                            if (f5235a.containsKey(str2)) {
                                c cVar = f5235a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (a(str, cVar, str2)) {
                                    throw new hn("服务QPS超限");
                                }
                                return b(str, cVar, str2);
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (hn e2) {
                    throw e2;
                } catch (Throwable th) {
                    it.a(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public static void a() {
        try {
            Context context = hp.f5081c;
            if (context == null) {
                return;
            }
            kk.a(b(), context);
        } catch (Throwable th) {
        }
    }

    public static void a(ia iaVar, JSONObject jSONObject) {
        synchronized (jx.class) {
            if (iaVar == null) {
                return;
            }
            try {
                String a2 = iaVar.a();
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                if (jSONObject == null) {
                    a(a2);
                }
                if (!hp.a(jSONObject.optString("able", null), false)) {
                    a(a2);
                    return;
                }
                jj.a(hp.f5081c, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                a(a2, jSONObject);
            } catch (Throwable th) {
                try {
                    it.a(th, "hlUtil", "par");
                } finally {
                }
            }
        }
    }

    private static void a(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    cVar.f5240a = hashMap;
                    return;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        String str = optString;
                        if (!optString.startsWith(BridgeUtil.SPLIT_MARK)) {
                            str = BridgeUtil.SPLIT_MARK.concat(String.valueOf(optString));
                        }
                        String str2 = str;
                        if (str.endsWith(BridgeUtil.SPLIT_MARK)) {
                            str2 = str.substring(0, str.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        if (optJSONArray != null) {
                            ArrayList arrayList = new ArrayList();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= optJSONArray2.length()) {
                                    break;
                                }
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject2 != null) {
                                    a aVar = new a((byte) 0);
                                    aVar.f5237a = optJSONObject2.optString("begin");
                                    aVar.b = optJSONObject2.optInt("duration");
                                    aVar.f5238c = optJSONObject2.optDouble("percent");
                                    arrayList.add(aVar);
                                }
                                i3 = i4 + 1;
                            }
                            hashMap.put(str2, arrayList);
                        }
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            it.a(th, "hlUtil", "pbr");
        }
    }

    private static void a(String str) {
        synchronized (jx.class) {
            try {
                if (f5235a.containsKey(str)) {
                    f5235a.remove(str);
                }
                SharedPreferences.Editor a2 = jj.a(hp.f5081c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                jj.a(a2, str);
                jj.a(a2);
            } catch (Throwable th) {
                try {
                    it.a(th, "hlUtil", com.anythink.core.common.g.c.R);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static void a(String str, c cVar) {
        try {
            if (f5235a == null) {
                f5235a = new ConcurrentHashMap<>(8);
            }
            f5235a.put(str, cVar);
        } catch (Throwable th) {
            it.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(String str, String str2, String str3) {
        try {
            Context context = hp.f5081c;
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (e == null) {
                e = new ConcurrentHashMap<>(8);
            }
            synchronized (e) {
                if (e.containsKey(str2)) {
                    return;
                }
                e.put(str2, str3);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("type", ip.j);
                jSONObject.put("name", str);
                jSONObject.put("version", ip.a(str));
                jSONObject.put("hostname", str2 + "#" + str3);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                kj kjVar = new kj(context, "core", "2.0", "O005");
                kjVar.a(jSONObject2);
                kk.a(kjVar, context);
            }
        } catch (Throwable th) {
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            a(cVar, jSONObject);
            b(cVar, jSONObject);
            if (cVar.b == null && cVar.f5240a == null) {
                a(str);
            } else {
                a(str, cVar);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(URL url, kc kcVar) {
        List<String> list;
        try {
            if (f5236c == null) {
                f5236c = new ConcurrentHashMap<>(8);
            }
            if (kcVar.b == null || !kcVar.b.containsKey(FullBackup.NO_BACKUP_TREE_TOKEN) || (list = kcVar.b.get(FullBackup.NO_BACKUP_TREE_TOKEN)) == null || list.size() <= 0) {
                return;
            }
            String[] split = list.get(0).split("#");
            if (split.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split[0]);
            long parseInt2 = Integer.parseInt(split[1]);
            b bVar = new b((byte) 0);
            bVar.f5239a = kcVar;
            long j = parseInt2;
            if (parseInt2 <= 0) {
                j = 30;
            }
            bVar.b = SystemClock.elapsedRealtime() + (j * 1000);
            if (parseInt == 1) {
                f5236c.put("app", bVar);
            } else if (parseInt != 2 || url == null) {
            } else {
                f5236c.put(url.getPath(), bVar);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(boolean z, String str) {
        try {
            Context context = hp.f5081c;
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            if (z) {
                jSONObject.put("type", ip.g);
            } else {
                jSONObject.put("type", ip.f);
            }
            jSONObject.put("name", str);
            jSONObject.put("version", ip.a(str));
            String jSONObject2 = jSONObject.toString();
            kj kjVar = new kj(context, "core", "2.0", "O005");
            kjVar.a(jSONObject2);
            kk.a(kjVar, context);
        } catch (Throwable th) {
        }
    }

    private static void a(boolean z, String str, String str2, int i) {
        try {
            Context context = hp.f5081c;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", System.currentTimeMillis());
            String a2 = ip.a(str);
            if (z) {
                jSONObject.put("type", ip.i);
            } else {
                jSONObject.put("type", ip.h);
            }
            jSONObject.put("name", str);
            jSONObject.put("version", a2);
            jSONObject.put("uri", Uri.parse(str2).getPath());
            jSONObject.put("blockLevel", i);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return;
            }
            kj kjVar = new kj(context, "core", "2.0", "O005");
            kjVar.a(jSONObject2);
            if (f == null) {
                f = Collections.synchronizedList(new ArrayList(16));
            }
            synchronized (f) {
                f.add(kjVar);
                if (f.size() >= 15) {
                    a();
                }
            }
        } catch (Throwable th) {
        }
    }

    private static boolean a(a aVar) {
        if (aVar == null || aVar.f5238c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(aVar.f5237a) || aVar.b <= 0) {
            return false;
        }
        long timeInMillis = currentTimeMillis - ib.a(aVar.f5237a, "HH:mm:ss").getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis >= aVar.b * 1000) {
            return false;
        }
        if (aVar.f5238c == 0.0d) {
            return true;
        }
        if (d == null) {
            d = new Random();
        }
        d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
        return d.nextDouble() > aVar.f5238c;
    }

    private static boolean a(String str, c cVar, String str2) {
        try {
            Map<String, List<a>> map = cVar.f5240a;
            if (map == null || map.size() <= 0) {
                return false;
            }
            if (map.containsKey(PhoneConstants.APN_TYPE_ALL)) {
                Iterator<Map.Entry<String, List<a>>> it = map.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        return false;
                    }
                } while (!a(it.next().getValue()));
                a(false, str2, str, 1);
                return true;
            }
            String path = Uri.parse(str).getPath();
            if (map.containsKey(path) && a(map.get(path))) {
                a(false, str2, str, 2);
                return true;
            }
            return false;
        } catch (Throwable th) {
            it.a(th, "hlUtil", "inb");
            return false;
        }
    }

    private static boolean a(List<a> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (a aVar : list) {
            if (a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public static kc b(String str, String str2) {
        Uri parse;
        try {
            if (f5236c == null) {
                return null;
            }
            if (f5236c.containsKey("app")) {
                b bVar = f5236c.get("app");
                if (SystemClock.elapsedRealtime() > bVar.b) {
                    f5236c.remove("app");
                    return null;
                }
                kc kcVar = bVar.f5239a;
                if (kcVar != null) {
                    kcVar.e = false;
                }
                a(true, str2, str, 1);
                return kcVar;
            } else if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            } else {
                String path = parse.getPath();
                if (f5236c.containsKey(path)) {
                    b bVar2 = f5236c.get(path);
                    if (SystemClock.elapsedRealtime() > bVar2.b) {
                        f5236c.remove(path);
                        return null;
                    }
                    kc kcVar2 = bVar2.f5239a;
                    if (kcVar2 != null) {
                        kcVar2.e = false;
                    }
                    a(true, str2, str, 2);
                    return kcVar2;
                }
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    private static String b(String str, c cVar, String str2) {
        String str3;
        Map<String, String> map;
        String str4 = str;
        try {
            map = cVar.b;
        } catch (Throwable th) {
            it.a(th, "hlUtil", "pdr");
            str3 = str4;
        }
        if (map != null && map.size() > 0) {
            Uri parse = Uri.parse(str);
            String authority = parse.getAuthority();
            str3 = str;
            if (map.containsKey(authority)) {
                String str5 = map.get(authority);
                String builder = parse.buildUpon().authority(str5).toString();
                str4 = builder;
                a(str2, authority, str5);
                return builder;
            }
            return str3;
        }
        return str;
    }

    public static List<kj> b() {
        Throwable th;
        try {
            synchronized (f) {
                ArrayList arrayList = null;
                ArrayList arrayList2 = null;
                try {
                    try {
                        if (f != null) {
                            arrayList = null;
                            if (f.size() > 0) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.addAll(f);
                                f.clear();
                                arrayList = arrayList3;
                            }
                        }
                        arrayList2 = arrayList;
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            return arrayList2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    arrayList2 = null;
                    throw th;
                }
            }
        } catch (Throwable th5) {
            return null;
        }
    }

    private static void b(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    cVar.b = hashMap;
                    return;
                }
                String optString = names.optString(i2);
                hashMap.put(optString, optJSONObject.optString(optString));
                i = i2 + 1;
            }
        } catch (Throwable th) {
            it.a(th, "hlUtil", "pdr");
        }
    }
}
