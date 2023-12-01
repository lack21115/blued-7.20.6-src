package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.tendinsv.a.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ct.class */
public class ct {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f41318a;

    /* renamed from: a  reason: collision with other field name */
    private static a f264a;

    /* renamed from: a  reason: collision with other field name */
    private static ct f265a;

    /* renamed from: c  reason: collision with root package name */
    private static String f41319c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f267a;

    /* renamed from: a  reason: collision with other field name */
    private cs f268a;

    /* renamed from: a  reason: collision with other field name */
    protected b f269a;

    /* renamed from: a  reason: collision with other field name */
    private String f270a;

    /* renamed from: a  reason: collision with other field name */
    protected final Map<String, cq> f271a;

    /* renamed from: b  reason: collision with other field name */
    private final long f272b;

    /* renamed from: b  reason: collision with other field name */
    private String f273b;

    /* renamed from: c  reason: collision with other field name */
    private long f274c;
    protected static final Map<String, cp> b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f266a = false;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ct$a.class */
    public interface a {
        ct a(Context context, cs csVar, b bVar, String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ct$b.class */
    public interface b {
        String a(String str);
    }

    public ct(Context context, cs csVar, b bVar, String str) {
        this(context, csVar, bVar, str, null, null);
    }

    protected ct(Context context, cs csVar, b bVar, String str, String str2, String str3) {
        this.f271a = new HashMap();
        this.f270a = "0";
        this.f267a = 0L;
        this.f272b = 15L;
        this.f274c = 0L;
        this.f273b = "isp_prov_city_country_ip";
        this.f269a = bVar;
        this.f268a = csVar == null ? new cu(this) : csVar;
        this.f270a = str;
        f41319c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? g() : str3;
    }

    public static ct a() {
        ct ctVar;
        synchronized (ct.class) {
            try {
                if (f265a == null) {
                    throw new IllegalStateException("the host manager is not initialized yet.");
                }
                ctVar = f265a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static String m11597a() {
        NetworkInfo activeNetworkInfo;
        Context context = f41318a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable th) {
            return "unknown";
        }
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bytes.length) {
                    return new String(bytes);
                }
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
                i = i2 + 1;
            }
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private ArrayList<cp> a(ArrayList<String> arrayList) {
        m11608e();
        synchronized (this.f271a) {
            m11603a();
            for (String str : this.f271a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        synchronized (b) {
            Object[] array = b.values().toArray();
            int length = array.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                cp cpVar = (cp) array[i2];
                if (!cpVar.b()) {
                    b.remove(cpVar.f261b);
                }
                i = i2 + 1;
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cp> arrayList2 = new ArrayList<>(arrayList.size());
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < arrayList.size()) {
                arrayList2.add(null);
                i3 = i4 + 1;
            } else {
                try {
                    break;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("failed to get bucket " + e.getMessage());
                }
            }
        }
        String str2 = bh.e(f41318a) ? "wifi" : "wap";
        String a2 = a(arrayList, str2, this.f270a, true);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject(a2);
            com.xiaomi.channel.commonutils.logger.b.b(a2);
            if (com.baidu.mobads.sdk.internal.bw.k.equalsIgnoreCase(jSONObject.getString(ExifInterface.LATITUDE_SOUTH))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                String string = jSONObject2.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                String string2 = jSONObject2.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string3 = jSONObject2.getString("isp");
                String string4 = jSONObject2.getString(b.a.q);
                String string5 = jSONObject2.getString("country");
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject3.toString());
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    String str3 = arrayList.get(i6);
                    JSONArray optJSONArray = jSONObject3.optJSONArray(str3);
                    if (optJSONArray == null) {
                        com.xiaomi.channel.commonutils.logger.b.m11394a("no bucket found for ".concat(String.valueOf(str3)));
                    } else {
                        cp cpVar2 = new cp(str3);
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= optJSONArray.length()) {
                                break;
                            }
                            String string6 = optJSONArray.getString(i8);
                            if (!TextUtils.isEmpty(string6)) {
                                cpVar2.a(new cy(string6, optJSONArray.length() - i8));
                            }
                            i7 = i8 + 1;
                        }
                        arrayList2.set(i6, cpVar2);
                        cpVar2.g = string5;
                        cpVar2.f41315c = string;
                        cpVar2.e = string3;
                        cpVar2.f = string4;
                        cpVar2.d = string2;
                        if (jSONObject2.has("stat-percent")) {
                            cpVar2.a(jSONObject2.getDouble("stat-percent"));
                        }
                        if (jSONObject2.has("stat-domain")) {
                            cpVar2.b(jSONObject2.getString("stat-domain"));
                        }
                        if (jSONObject2.has(RemoteMessageConst.TTL)) {
                            cpVar2.a(jSONObject2.getInt(RemoteMessageConst.TTL) * 1000);
                        }
                        m11602a(cpVar2.a());
                    }
                    i5 = i6 + 1;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("reserved");
                if (optJSONObject != null) {
                    long j = jSONObject2.has("reserved-ttl") ? jSONObject2.getInt("reserved-ttl") * 1000 : 604800000L;
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                        if (optJSONArray2 == null) {
                            com.xiaomi.channel.commonutils.logger.b.m11394a("no bucket found for ".concat(String.valueOf(next)));
                        } else {
                            cp cpVar3 = new cp(next);
                            cpVar3.a(j);
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 >= optJSONArray2.length()) {
                                    break;
                                }
                                String string7 = optJSONArray2.getString(i10);
                                if (!TextUtils.isEmpty(string7)) {
                                    cpVar3.a(new cy(string7, optJSONArray2.length() - i10));
                                }
                                i9 = i10 + 1;
                            }
                            synchronized (b) {
                                if (this.f268a.a(next)) {
                                    b.put(next, cpVar3);
                                }
                            }
                        }
                    }
                }
            }
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= arrayList.size()) {
                m11606c();
                return arrayList2;
            }
            cp cpVar4 = arrayList2.get(i12);
            if (cpVar4 != null) {
                a(arrayList.get(i12), cpVar4);
            }
            i11 = i12 + 1;
        }
    }

    public static void a(Context context, cs csVar, b bVar, String str, String str2, String str3) {
        synchronized (ct.class) {
            try {
                Context applicationContext = context.getApplicationContext();
                f41318a = applicationContext;
                if (applicationContext == null) {
                    f41318a = context;
                }
                if (f265a == null) {
                    if (f264a == null) {
                        f265a = new ct(context, csVar, bVar, str, str2, str3);
                        return;
                    }
                    f265a = f264a.a(context, csVar, bVar, str);
                }
            } finally {
            }
        }
    }

    public static void a(a aVar) {
        synchronized (ct.class) {
            try {
                f264a = aVar;
                f265a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2) {
        cp cpVar = b.get(str);
        synchronized (b) {
            if (cpVar == null) {
                cp cpVar2 = new cp(str);
                cpVar2.a(604800000L);
                cpVar2.m11589a(str2);
                b.put(str, cpVar2);
            } else {
                cpVar.m11589a(str2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private byte[] m11598a() {
        return bm.m11547a(f41318a.getPackageName() + "_key_salt");
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() {
        try {
            PackageInfo packageInfo = f41318a.getPackageManager().getPackageInfo(f41318a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception e) {
            return "0";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public cp m11599a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cp a(String str, boolean z) {
        cp e;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f268a.a(str)) {
            cp c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && bh.b(f41318a) && (e = e(str)) != null) ? e : new cv(this, str, c2) : c2;
        }
        return null;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> a2;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<bg> arrayList3 = new ArrayList();
        arrayList3.add(new be("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new be("conpt", a(bh.m11535a(f41318a))));
        }
        if (z) {
            arrayList3.add(new be("reserved", "1"));
        }
        arrayList3.add(new be("uuid", str2));
        arrayList3.add(new be("list", bn.a(arrayList, ",")));
        arrayList3.add(new be("countrycode", com.xiaomi.push.service.a.a(f41318a).b()));
        arrayList3.add(new be("push_sdk_vc", "50010"));
        String b2 = b();
        cp c2 = c(b2);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", b2);
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                cp cpVar = b.get(b2);
                if (cpVar != null) {
                    Iterator<String> it = cpVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
            a2 = arrayList2;
        } else {
            a2 = c2.a(format);
        }
        Iterator<String> it2 = a2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (bg bgVar : arrayList3) {
                buildUpon.appendQueryParameter(bgVar.a(), bgVar.b());
            }
            try {
                return this.f269a == null ? bh.a(f41318a, new URL(buildUpon.toString())) : this.f269a.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected JSONObject m11600a() {
        JSONObject jSONObject;
        synchronized (this.f271a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cq cqVar : this.f271a.values()) {
                jSONArray.put(cqVar.m11593a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cp cpVar : b.values()) {
                jSONArray2.put(cpVar.m11588a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11601a() {
        synchronized (this.f271a) {
            this.f271a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11602a(String str) {
        this.f273b = str;
    }

    public void a(String str, cp cpVar) {
        if (TextUtils.isEmpty(str) || cpVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cpVar);
        } else if (this.f268a.a(str)) {
            synchronized (this.f271a) {
                m11603a();
                if (this.f271a.containsKey(str)) {
                    this.f271a.get(str).a(cpVar);
                } else {
                    cq cqVar = new cq(str);
                    cqVar.a(cpVar);
                    this.f271a.put(str, cqVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m11603a() {
        synchronized (this.f271a) {
            if (f266a) {
                return true;
            }
            f266a = true;
            this.f271a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m11605b(d2);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public cp b(String str) {
        return a(str, true);
    }

    protected String b() {
        return "resolver.msg.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m11604b() {
        ArrayList<String> arrayList;
        synchronized (this.f271a) {
            m11603a();
            arrayList = new ArrayList<>(this.f271a.keySet());
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                cq cqVar = this.f271a.get(arrayList.get(i));
                if (cqVar != null && cqVar.a() != null) {
                    arrayList.remove(i);
                }
                size = i;
            }
        }
        ArrayList<cp> a2 = a(arrayList);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                return;
            }
            if (a2.get(i3) != null) {
                a(arrayList.get(i3), a2.get(i3));
            }
            i2 = i3 + 1;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m11605b(String str) {
        synchronized (this.f271a) {
            this.f271a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    cq a2 = new cq().a(optJSONArray.getJSONObject(i2));
                    this.f271a.put(a2.m11591a(), a2);
                    i = i2 + 1;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            if (optJSONArray2 != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= optJSONArray2.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                    String optString = jSONObject2.optString("host");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            cp a3 = new cp(optString).a(jSONObject2);
                            b.put(a3.f261b, a3);
                            com.xiaomi.channel.commonutils.logger.b.m11394a("load local reserved host for " + a3.f261b);
                        } catch (JSONException e) {
                            com.xiaomi.channel.commonutils.logger.b.m11394a("parse reserved host fail.");
                        }
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    protected cp c(String str) {
        cq cqVar;
        cp a2;
        synchronized (this.f271a) {
            m11603a();
            cqVar = this.f271a.get(str);
        }
        if (cqVar == null || (a2 = cqVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f271a) {
            for (Map.Entry<String, cq> entry : this.f271a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00e6: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:50:0x00e6 */
    /* renamed from: c  reason: collision with other method in class */
    public void m11606c() {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        synchronized (this.f271a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    String jSONObject = m11600a().toString();
                    com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = ".concat(String.valueOf(jSONObject)));
                    if (TextUtils.isEmpty(jSONObject)) {
                        fileOutputStream = null;
                    } else {
                        fileOutputStream = f41318a.openFileOutput(f(), 0);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedOutputStream = null;
                            e = e;
                            StringBuilder sb = new StringBuilder("persist bucket failure: ");
                            FileOutputStream fileOutputStream3 = fileOutputStream;
                            sb.append(e.getMessage());
                            OutputStream outputStream = fileOutputStream;
                            com.xiaomi.channel.commonutils.logger.b.m11394a(sb.toString());
                            x.a(bufferedOutputStream);
                            x.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            th = th;
                            bufferedOutputStream2 = null;
                            x.a(bufferedOutputStream2);
                            x.a(fileOutputStream);
                            throw th;
                        }
                        try {
                            bufferedOutputStream.write(h.b(m11598a(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                            bufferedOutputStream.flush();
                            bufferedOutputStream2 = bufferedOutputStream;
                        } catch (Exception e3) {
                            e = e3;
                            StringBuilder sb2 = new StringBuilder("persist bucket failure: ");
                            FileOutputStream fileOutputStream32 = fileOutputStream;
                            sb2.append(e.getMessage());
                            OutputStream outputStream2 = fileOutputStream;
                            com.xiaomi.channel.commonutils.logger.b.m11394a(sb2.toString());
                            x.a(bufferedOutputStream);
                            x.a(fileOutputStream);
                        }
                    }
                    x.a(bufferedOutputStream2);
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                x.a(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                x.a(bufferedOutputStream2);
                x.a(fileOutputStream);
                throw th;
            }
        }
    }

    public cp d(String str) {
        cp cpVar;
        synchronized (b) {
            cpVar = b.get(str);
        }
        return cpVar;
    }

    protected String d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        try {
            File file = new File(f41318a.getFilesDir(), f());
            if (!file.isFile()) {
                x.a((Closeable) null);
                x.a((Closeable) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            try {
                String str = new String(h.a(m11598a(), x.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = ".concat(str));
                x.a((Closeable) bufferedInputStream);
                x.a((Closeable) fileInputStream);
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("load host exception " + th.getMessage());
                    x.a((Closeable) bufferedInputStream);
                    x.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    x.a((Closeable) bufferedInputStream);
                    x.a((Closeable) fileInputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            fileInputStream = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m11607d() {
        String e = e();
        try {
            File file = new File(f41318a.getFilesDir(), e);
            if (!file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + e + " does not exist.");
                return;
            }
            boolean delete = file.delete();
            StringBuilder sb = new StringBuilder("Delete old host fallbacks file ");
            sb.append(e);
            sb.append(delete ? " successful." : " failed.");
            com.xiaomi.channel.commonutils.logger.b.m11394a(sb.toString());
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Delete old host fallbacks file " + e + " error: " + e2.getMessage());
        }
    }

    protected cp e(String str) {
        if (System.currentTimeMillis() - this.f274c > this.f267a * 60 * 1000) {
            this.f274c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cp cpVar = a(arrayList).get(0);
            if (cpVar != null) {
                this.f267a = 0L;
                return cpVar;
            }
            long j = this.f267a;
            if (j < 15) {
                this.f267a = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    protected String e() {
        if ("com.xiaomi.xmsf".equals(f41319c)) {
            return f41319c;
        }
        return f41319c + ":pushservice";
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        r0 = true;
     */
    /* renamed from: e  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m11608e() {
        /*
            r3 = this;
            r0 = r3
            java.util.Map<java.lang.String, com.xiaomi.push.cq> r0 = r0.f271a
            r5 = r0
            r0 = r5
            monitor-enter(r0)
            r0 = r3
            java.util.Map<java.lang.String, com.xiaomi.push.cq> r0 = r0.f271a     // Catch: java.lang.Throwable -> L7f
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7f
            r6 = r0
        L16:
            r0 = r6
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L84
            r0 = r6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L7f
            com.xiaomi.push.cq r0 = (com.xiaomi.push.cq) r0     // Catch: java.lang.Throwable -> L7f
            r1 = 1
            r0.a(r1)     // Catch: java.lang.Throwable -> L7f
            goto L16
        L2f:
            r0 = r4
            if (r0 != 0) goto L7c
            r0 = r3
            java.util.Map<java.lang.String, com.xiaomi.push.cq> r0 = r0.f271a     // Catch: java.lang.Throwable -> L7f
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7f
            r6 = r0
        L42:
            r0 = r6
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L89
            r0 = r6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L7f
            r7 = r0
            r0 = r3
            java.util.Map<java.lang.String, com.xiaomi.push.cq> r0 = r0.f271a     // Catch: java.lang.Throwable -> L7f
            r1 = r7
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L7f
            com.xiaomi.push.cq r0 = (com.xiaomi.push.cq) r0     // Catch: java.lang.Throwable -> L7f
            java.util.ArrayList r0 = r0.m11592a()     // Catch: java.lang.Throwable -> L7f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L42
            r0 = r3
            java.util.Map<java.lang.String, com.xiaomi.push.cq> r0 = r0.f271a     // Catch: java.lang.Throwable -> L7f
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L7f
            goto L84
        L7c:
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7f
            return
        L7f:
            r6 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7f
            r0 = r6
            throw r0
        L84:
            r0 = 0
            r4 = r0
            goto L2f
        L89:
            r0 = 1
            r4 = r0
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ct.m11608e():void");
    }
}
