package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.er;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gn;
import com.xiaomi.push.gw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ServiceClient.class */
public class ServiceClient {

    /* renamed from: a  reason: collision with other field name */
    private static ServiceClient f860a;

    /* renamed from: a  reason: collision with other field name */
    private static String f861a;

    /* renamed from: a  reason: collision with other field name */
    private Context f862a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f865a;

    /* renamed from: b  reason: collision with other field name */
    private Messenger f866b;
    private static String b = gw.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f27876a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f863a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f864a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f867b = false;

    private ServiceClient(Context context) {
        this.f865a = false;
        this.f862a = context.getApplicationContext();
        if (m9026a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f865a = true;
        }
    }

    private Intent a() {
        if (!isMiuiPushServiceEnabled()) {
            Intent intent = new Intent(this.f862a, XMPushService.class);
            intent.putExtra(bk.B, this.f862a.getPackageName());
            b();
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setPackage("com.xiaomi.xmsf");
        intent2.setClassName("com.xiaomi.xmsf", m9022a());
        intent2.putExtra(bk.B, this.f862a.getPackageName());
        m9024a();
        return intent2;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m9022a() {
        try {
            return this.f862a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception e) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int i = 1;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return sb.toString();
            }
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append(":");
            sb.append(next.getValue());
            if (i2 < map.size()) {
                sb.append(",");
            }
            i = i2 + 1;
        }
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m9024a() {
        this.f862a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f862a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m9025a(Intent intent) {
        synchronized (this) {
            if (this.f867b) {
                Message a2 = a(intent);
                if (this.f864a.size() >= 50) {
                    this.f864a.remove(0);
                }
                this.f864a.add(a2);
            } else if (this.f866b == null) {
                this.f862a.bindService(intent, new bu(this), 1);
                this.f867b = true;
                this.f864a.clear();
                this.f864a.add(a(intent));
            } else {
                try {
                    this.f866b.send(a(intent));
                } catch (RemoteException e) {
                    this.f866b = null;
                    this.f867b = false;
                }
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(bk.q, str);
        intent.putExtra(bk.t, str2);
        intent.putExtra(bk.v, str3);
        intent.putExtra(bk.x, str5);
        intent.putExtra(bk.w, str4);
        intent.putExtra(bk.y, z);
        intent.putExtra(bk.F, f861a);
        intent.putExtra(bk.J, this.f863a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(bk.z, a2);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String a3 = a(map2);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        intent.putExtra(bk.A, a3);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m9026a() {
        if (com.xiaomi.push.aa.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f862a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception e) {
            return false;
        }
    }

    private void b() {
        this.f862a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f862a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f860a == null) {
            f860a = new ServiceClient(context);
        }
        return f860a;
    }

    public static String getSession() {
        return f861a;
    }

    public static void setSession(String str) {
        f861a = str;
    }

    public boolean batchSendMessage(gk[] gkVarArr, boolean z) {
        if (com.xiaomi.push.bh.b(this.f862a)) {
            Intent a2 = a();
            int length = gkVarArr.length;
            Bundle[] bundleArr = new Bundle[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gkVarArr.length) {
                    break;
                }
                String a3 = er.a();
                if (!TextUtils.isEmpty(a3)) {
                    gi giVar = new gi("pf", null, null, null);
                    gi giVar2 = new gi("sent", null, null, null);
                    giVar2.m8762a(a3);
                    giVar.a(giVar2);
                    gkVarArr[i2].a(giVar);
                }
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gkVarArr[i2].mo8764a());
                bundleArr[i2] = gkVarArr[i2].a();
                i = i2 + 1;
            }
            if (length > 0) {
                a2.setAction(bk.g);
                a2.putExtra(bk.F, f861a);
                a2.putExtra("ext_packets", bundleArr);
                a2.putExtra("ext_encrypt", z);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(bk.i);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(bk.i);
        a2.putExtra(bk.t, str);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(bk.i);
        a2.putExtra(bk.t, str);
        a2.putExtra(bk.q, str2);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f865a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(bk.d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public boolean sendIQ(gj gjVar) {
        if (com.xiaomi.push.bh.b(this.f862a)) {
            Intent a2 = a();
            Bundle a3 = gjVar.a();
            if (a3 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gjVar.mo8764a());
                a2.setAction(bk.f);
                a2.putExtra(bk.F, f861a);
                a2.putExtra("ext_packet", a3);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public boolean sendMessage(gk gkVar, boolean z) {
        if (com.xiaomi.push.bh.b(this.f862a)) {
            Intent a2 = a();
            String a3 = er.a();
            if (!TextUtils.isEmpty(a3)) {
                gi giVar = new gi("pf", null, null, null);
                gi giVar2 = new gi("sent", null, null, null);
                giVar2.m8762a(a3);
                giVar.a(giVar2);
                gkVar.a(giVar);
            }
            Bundle a4 = gkVar.a();
            if (a4 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gkVar.mo8764a());
                a2.setAction(bk.e);
                a2.putExtra(bk.F, f861a);
                a2.putExtra("ext_packet", a4);
                a2.putExtra("ext_encrypt", z);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        String str4;
        if (!com.xiaomi.push.bh.b(this.f862a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a2 = a();
        if (bArr != null) {
            a2.setAction(bk.e);
            a2.putExtra(bk.F, f861a);
            a2.putExtra("ext_raw_packet", bArr);
            int indexOf = str.indexOf("@");
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                String substring2 = str.substring(indexOf + 1, lastIndexOf);
                String substring3 = str.substring(lastIndexOf + 1);
                str4 = substring2;
                str3 = substring3;
            } else {
                str3 = null;
                str4 = null;
            }
            a2.putExtra(bk.q, substring);
            a2.putExtra(bk.r, str4);
            a2.putExtra(bk.s, str3);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            long j = f27876a;
            f27876a = 1 + j;
            sb.append(j);
            String sb2 = sb.toString();
            a2.putExtra("ext_pkt_id", sb2);
            a2.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
            return startServiceSafely(a2);
        }
        return false;
    }

    public boolean sendPresence(gn gnVar) {
        if (com.xiaomi.push.bh.b(this.f862a)) {
            Intent a2 = a();
            Bundle a3 = gnVar.a();
            if (a3 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gnVar.mo8764a());
                a2.setAction(bk.h);
                a2.putExtra(bk.F, f861a);
                a2.putExtra("ext_packet", a3);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public void setMessenger(Messenger messenger) {
        this.f863a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.j.m8997a() || Build.VERSION.SDK_INT < 26) {
                this.f862a.startService(intent);
                return true;
            }
            m9025a(intent);
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(bk.z, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(bk.A, a4);
            }
        }
        a2.putExtra(bk.t, str);
        startServiceSafely(a2);
    }
}
