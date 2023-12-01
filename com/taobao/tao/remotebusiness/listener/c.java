package com.taobao.tao.remotebusiness.listener;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.jaq.SecurityVerification;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.sobot.network.http.SobotOkHttpUtils;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Closeable;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.global.SDKConfig;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/listener/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private SecurityGuardManager f21224a = null;
    private SDKConfig b = null;

    /* renamed from: c  reason: collision with root package name */
    private SecurityVerification f21225c;

    public static String a(String str, MtopBusiness mtopBusiness, boolean z, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" [");
        if (mtopBusiness != null) {
            sb.append("apiName=");
            sb.append(mtopBusiness.request.a());
            sb.append(";version=");
            sb.append(mtopBusiness.request.b());
            sb.append(";requestType=");
            sb.append(mtopBusiness.getRequestType());
            if (z) {
                sb.append(";clazz=");
                sb.append(mtopBusiness.clazz);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String a(Map map, String str) {
        List list;
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (Map.Entry entry : map.entrySet()) {
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    list = (List) entry.getValue();
                    break;
                }
            }
        }
        list = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public static MtopListener a(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MtopCallback.MtopFinishListener.class);
        if (mtopListener instanceof IRemoteProcessListener) {
            arrayList.add(MtopCallback.MtopProgressListener.class);
            arrayList.add(MtopCallback.MtopHeaderListener.class);
        }
        if ((mtopListener instanceof IRemoteCacheListener) || mtopBusiness.mtopProp.h) {
            arrayList.add(MtopCallback.MtopCacheListener.class);
        }
        return (MtopListener) Proxy.newProxyInstance(MtopListener.class.getClassLoader(), (Class[]) arrayList.toArray(new Class[arrayList.size()]), new a(mtopBusiness, mtopListener));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(SobotOkHttpUtils.METHOD.PATCH);
    }

    public static boolean a(Map map) {
        try {
            return "gzip".equalsIgnoreCase(a(map, "Content-Encoding"));
        } catch (Exception e) {
            return false;
        }
    }

    public static String b(String str) {
        if (StringUtils.b(str)) {
            return str;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuffer.toString();
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.SecurityUtils", "[getMd5] compute md5 value failed for source str=" + str, e);
            return null;
        }
    }

    private static String c(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String a() {
        try {
            if (this.f21225c != null) {
                return this.f21225c.doJAQVerfificationSync((HashMap) null, 20);
            }
            return null;
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.SecuritySignImpl", "[getSecBodyDataEx] SecurityVerification doJAQVerfificationSync error", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.HashMap r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a(java.util.HashMap, java.lang.String):java.lang.String");
    }

    public String a(mtopsdk.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (aVar.b != null) {
            return aVar.b;
        }
        IStaticDataStoreComponent staticDataStoreComp = this.f21224a.getStaticDataStoreComp();
        try {
            String i = this.b.i();
            return staticDataStoreComp.getAppKeyByIndex(aVar.a, i != null ? i : "");
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.SecuritySignImpl", "[getAppkey]getAppKeyByIndex error.", e);
            return null;
        }
    }

    public void a(Context context, int i) {
        String str;
        if (context == null) {
            str = "[init]SecuritySignImpl init.context is null";
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.b = SDKConfig.a();
                SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
                this.f21224a = securityGuardManager;
                IStaticDataStoreComponent staticDataStoreComp = securityGuardManager.getStaticDataStoreComp();
                String i2 = this.b.i();
                if (i2 == null) {
                    i2 = "";
                }
                String appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, i2);
                if (TBSdkLog.a(TBSdkLog.LogEnable.b)) {
                    TBSdkLog.a("mtopsdk.SecuritySignImpl", "[init]SecuritySignImpl ISign init.set GlobalAppKey=" + appKeyByIndex);
                }
                this.f21225c = new SecurityVerification(context);
                if (TBSdkLog.a(TBSdkLog.LogEnable.b)) {
                    TBSdkLog.a("mtopsdk.SecuritySignImpl", "[init]SecuritySignImpl ISign init succeed.init time=" + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            } catch (Throwable th) {
                str = "[init]SecuritySignImpl init securityguard error.---" + th.toString();
            }
        }
        TBSdkLog.d("mtopsdk.SecuritySignImpl", str);
    }
}
