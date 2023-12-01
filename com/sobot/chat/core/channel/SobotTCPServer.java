package com.sobot.chat.core.channel;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.expressad.video.module.a.a.m;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.apiUtils.SobotBaseUrl;
import com.sobot.chat.api.apiUtils.ZhiChiUrlApi;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.a.a.i;
import com.sobot.chat.core.a.a.j;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.Util;
import com.sobot.chat.utils.ZhiChiConstant;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer.class */
public class SobotTCPServer extends Service {
    public static NetworkInfo b;

    /* renamed from: c  reason: collision with root package name */
    public static WifiInfo f14534c;
    public static boolean d = true;
    private com.sobot.chat.core.a.a B;
    private b M;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    private MyMessageReceiver u;
    private SystemMessageReceiver v;
    private LocalBroadcastManager w;
    private a x;

    /* renamed from: a  reason: collision with root package name */
    int f14535a = 0;
    private final int y = Process.myPid();
    Context e = this;
    boolean m = true;
    int n = 0;
    private boolean z = false;
    final int o = 0;
    final int p = 1;
    int q = 0;
    SparseArray<String> r = new SparseArray<>();
    private LimitQueue<String> A = new LimitQueue<>(50);
    private int C = 0;
    private List<String> D = new ArrayList();
    private Timer E = null;
    private TimerTask F = null;
    private final int G = 0;
    private final int H = 1;
    private int I = 0;
    private boolean J = false;
    private Map<String, String> K = new HashMap();
    private Map<String, String> L = new HashMap();
    public boolean s = false;
    public boolean t = true;
    private Runnable N = new Runnable() { // from class: com.sobot.chat.core.channel.SobotTCPServer.5
        @Override // java.lang.Runnable
        public void run() {
            SobotTCPServer.this.J = true;
            SharedPreferencesUtil.getStringData(SobotTCPServer.this.e, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
            SobotTCPServer.this.K.put("uid", SobotTCPServer.this.f);
            SobotTCPServer.this.K.put(d.N, SobotTCPServer.this.g);
            Map map = SobotTCPServer.this.K;
            map.put("tnk", System.currentTimeMillis() + "");
            HttpUtils httpUtils = HttpUtils.getInstance();
            httpUtils.doPost(null, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.pollingMsg, SobotTCPServer.this.K, new HttpUtils.a() { // from class: com.sobot.chat.core.channel.SobotTCPServer.5.1
                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(int i) {
                }

                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(Exception exc, String str, int i) {
                    SobotTCPServer.this.n().removeCallbacks(SobotTCPServer.this.N);
                    SobotTCPServer.this.n().postDelayed(SobotTCPServer.this.N, 10000L);
                    SobotTCPServer.this.J = false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("请求参数 ");
                    sb.append(SobotTCPServer.this.K != null ? GsonUtil.map2Json(SobotTCPServer.this.K) : "");
                    sb.append(" 失败原因：");
                    sb.append(exc.toString());
                    LogUtils.i2Local("tcpserver 轮询接口失败", sb.toString());
                    try {
                        SobotMsgManager.getInstance(SobotTCPServer.this.e).getZhiChiApi().logCollect(SobotTCPServer.this.e, SharedPreferencesUtil.getAppKey(SobotTCPServer.this.e, ""), true);
                    } catch (Exception e) {
                    }
                }

                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(String str) {
                    LogUtils.i("轮询请求结果:" + str);
                    if (SobotTCPServer.this.s) {
                        LogUtils.i2Local("tcp 轮询结果", str);
                        try {
                            SobotMsgManager.getInstance(SobotTCPServer.this.e).getZhiChiApi().logCollect(SobotTCPServer.this.e, SharedPreferencesUtil.getAppKey(SobotTCPServer.this.e, ""), true);
                        } catch (Exception e) {
                        }
                        SobotTCPServer.this.s = false;
                    }
                    if (SobotTCPServer.this.t) {
                        LogUtils.i2Local("tcp 轮询结果", str);
                        try {
                            SobotMsgManager.getInstance(SobotTCPServer.this.e).getZhiChiApi().logCollect(SobotTCPServer.this.e, SharedPreferencesUtil.getAppKey(SobotTCPServer.this.e, ""), true);
                        } catch (Exception e2) {
                        }
                        SobotTCPServer.this.t = false;
                    }
                    BaseCode jsonToBaseCode = GsonUtil.jsonToBaseCode(str);
                    SobotTCPServer.this.n = 0;
                    SobotTCPServer.this.n().removeCallbacks(SobotTCPServer.this.N);
                    if (jsonToBaseCode != null) {
                        if ("0".equals(jsonToBaseCode.getCode()) && "210021".equals(jsonToBaseCode.getData())) {
                            LogUtils.i2Local("tcp 轮询结果异常", jsonToBaseCode.toString() + " 非法用户，停止轮询");
                        } else if ("0".equals(jsonToBaseCode.getCode()) && "200003".equals(jsonToBaseCode.getData())) {
                            LogUtils.i2Local("tcp 轮询结果异常", jsonToBaseCode.toString() + " 找不到用户，停止轮询");
                        } else {
                            SobotTCPServer.this.n().postDelayed(SobotTCPServer.this.N, 5000L);
                            if (jsonToBaseCode.getData() != null) {
                                SobotTCPServer.this.a(jsonToBaseCode.getData().toString());
                            }
                        }
                    }
                    SobotTCPServer.this.J = false;
                }
            });
        }
    };
    private boolean O = true;
    private PowerManager.WakeLock P = null;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$AssistService.class */
    public static class AssistService extends Service {

        /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$AssistService$a.class */
        public class a extends Binder {
            public a() {
            }

            public AssistService a() {
                return AssistService.this;
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            LogUtils.d("AssistService: onBind()");
            return new a();
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
            LogUtils.d("AssistService: onDestroy()");
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$MyMessageReceiver.class */
    public class MyMessageReceiver extends BroadcastReceiver {
        public MyMessageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            if (Const.SOBOT_CHAT_DISCONNCHANNEL.equals(intent.getAction())) {
                SobotTCPServer.this.c();
            } else if (Const.SOBOT_CHAT_CHECK_CONNCHANNEL.equals(intent.getAction())) {
                SobotTCPServer.this.b(true);
                SobotTCPServer.this.h();
            } else if (Const.SOBOT_CHAT_USER_OUTLINE.equals(intent.getAction())) {
                SharedPreferencesUtil.getStringData(SobotTCPServer.this.e, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
                SobotTCPServer.this.b(false);
                SobotTCPServer.this.c();
            } else if (Const.SOBOT_CHAT_CHECK_SWITCHFLAG.equals(intent.getAction())) {
                SobotTCPServer.this.c();
                SobotTCPServer.this.a(true);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$SystemMessageReceiver.class */
    public class SystemMessageReceiver extends BroadcastReceiver {
        public SystemMessageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            LogUtils.i("SobotTCPServer 接收到系统 网络状态变化 广播");
            NetworkInfo networkInfo = null;
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            } catch (Exception e) {
                LogUtils.i("getActiveNetworkInfo failed.");
            }
            SobotTCPServer.this.a(context, networkInfo);
            if (SobotTCPServer.this.f14535a == 0) {
                SobotTCPServer.this.f14535a++;
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$a.class */
    class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AssistService a2 = ((AssistService.a) iBinder).a();
            SobotTCPServer sobotTCPServer = SobotTCPServer.this;
            sobotTCPServer.startForeground(sobotTCPServer.y, SobotTCPServer.this.j());
            a2.startForeground(SobotTCPServer.this.y, SobotTCPServer.this.j());
            a2.stopForeground(true);
            SobotTCPServer sobotTCPServer2 = SobotTCPServer.this;
            sobotTCPServer2.unbindService(sobotTCPServer2.x);
            SobotTCPServer.this.x = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotTCPServer$b.class */
    public static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    private void a(com.sobot.chat.core.a.a aVar) {
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        String[] split = this.k.split(":");
        if (split.length != 2) {
            return;
        }
        aVar.h().a(split[0]);
        aVar.h().b(split[1]);
        aVar.h().b(10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray3 = new JSONArray(str);
            jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                jSONArray2 = jSONArray;
                try {
                    if (i2 >= jSONArray3.length()) {
                        break;
                    }
                    String string = jSONArray3.getString(i2);
                    String msgId = Util.getMsgId(string);
                    if (TextUtils.isEmpty(msgId)) {
                        Util.notifyMsg(this.e, string);
                    } else {
                        if (this.A.indexOf(msgId) == -1) {
                            this.A.offer(msgId);
                            Util.notifyMsg(this.e, string);
                        }
                        jSONArray.put(new JSONObject("{msgId:" + msgId + "}"));
                    }
                    i = i2 + 1;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    HashMap hashMap = new HashMap();
                    hashMap.put("content", "rl:" + str);
                    hashMap.put("title", "responseAck jsonException:" + e.getMessage());
                    LogUtils.i2Local(hashMap, "tcp responseAck 请求失败");
                    jSONArray2 = jSONArray;
                    if (jSONArray2 != null) {
                        return;
                    }
                    return;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            jSONArray = null;
        }
        if (jSONArray2 != null || jSONArray2.length() <= 0) {
            return;
        }
        this.L.put("content", jSONArray2.toString());
        this.L.put("tnk", System.currentTimeMillis() + "");
        HttpUtils.getInstance().doPost(null, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.ack, this.L, new HttpUtils.a() { // from class: com.sobot.chat.core.channel.SobotTCPServer.6
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i3) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i3) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("ack:::" + str2);
            }
        });
    }

    private void b(com.sobot.chat.core.a.a aVar) {
        aVar.b("UTF-8");
    }

    private void c(com.sobot.chat.core.a.a aVar) {
        aVar.k().a(com.sobot.chat.core.a.b.b.b("ping", "UTF-8"));
        aVar.k().b(com.sobot.chat.core.a.b.b.b("pong", "UTF-8"));
        aVar.k().a(10000L);
        aVar.k().a(true);
    }

    private void d(com.sobot.chat.core.a.a aVar) {
        aVar.j().a(new i.c() { // from class: com.sobot.chat.core.channel.SobotTCPServer.2
            @Override // com.sobot.chat.core.a.a.i.c
            public byte[] a(i iVar, int i) {
                return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            }
        });
        aVar.j().b(10240);
        aVar.j().a(true);
    }

    private void e(com.sobot.chat.core.a.a aVar) {
        aVar.j().a(i.a.AutoReadByLength);
        aVar.j().c(4);
        aVar.j().a(new i.b() { // from class: com.sobot.chat.core.channel.SobotTCPServer.3
            @Override // com.sobot.chat.core.a.a.i.b
            public int a(i iVar, byte[] bArr) {
                return (bArr[3] & 255) + ((bArr[2] & 255) << 8) + ((bArr[1] & 255) << 16) + ((bArr[0] & 255) << 24);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.sobot.chat.core.a.a aVar) {
        String l = l();
        if (TextUtils.isEmpty(l)) {
            return;
        }
        String[] split = l.split(":");
        if (split.length != 2) {
            return;
        }
        aVar.h().a(split[0]);
        aVar.h().b(split[1]);
    }

    private void g() {
        if (this.f14535a == 0) {
            return;
        }
        if (b()) {
            o();
        }
        if (Util.hasNetWork(getApplicationContext())) {
            LogUtils.i("有网络");
            LogUtils.i2Local("tcp 网络发生变化", "有网络");
            k();
            return;
        }
        LogUtils.i("没有网络");
        LogUtils.i2Local("tcp 网络发生变化", "没有网络");
        e();
        Util.notifyConnStatus(getApplicationContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (b() || f()) {
            return;
        }
        k();
    }

    private void i() {
        if (this.u == null) {
            this.u = new MyMessageReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Const.SOBOT_CHAT_DISCONNCHANNEL);
        intentFilter.addAction(Const.SOBOT_CHAT_CHECK_CONNCHANNEL);
        intentFilter.addAction(Const.SOBOT_CHAT_CHECK_SWITCHFLAG);
        intentFilter.addAction(Const.SOBOT_CHAT_USER_OUTLINE);
        LocalBroadcastManager localBroadcastManager = this.w;
        if (localBroadcastManager != null) {
            localBroadcastManager.registerReceiver(this.u, intentFilter);
        }
        if (this.v == null) {
            this.v = new SystemMessageReceiver();
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.v, intentFilter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification j() {
        return new Notification();
    }

    private void k() {
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.h)) {
            return;
        }
        this.m = true;
        if (this.q == 1 || "1".equals(this.l) || TextUtils.isEmpty(this.k)) {
            a(false);
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.j)) {
                JSONArray jSONArray = new JSONArray(this.j);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.D.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Util.notifyConnStatus(this.e, b() ? 2 : 1);
        d().b();
    }

    private String l() {
        try {
            String str = this.D.get(this.C);
            this.C++;
            return str;
        } catch (Exception e) {
            this.C = 0;
            return this.k;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!Util.hasNetWork(getApplicationContext())) {
            Util.notifyConnStatus(this.e, 0);
        } else if (!this.m || this.q == 1 || this.z || TextUtils.isEmpty(this.i) || b()) {
        } else {
            LogUtils.i("开启重连");
            LogUtils.i2Local("tcp 通道", "开启重连");
            Util.notifyConnStatus(this.e, 1);
            this.z = true;
            Timer timer = this.E;
            if (timer != null) {
                timer.cancel();
                this.E = null;
            }
            TimerTask timerTask = this.F;
            if (timerTask != null) {
                timerTask.cancel();
                this.F = null;
            }
            this.E = new Timer();
            TimerTask timerTask2 = new TimerTask() { // from class: com.sobot.chat.core.channel.SobotTCPServer.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (Util.hasNetWork(SobotTCPServer.this.e) && SobotTCPServer.this.q == 0 && SobotTCPServer.this.m) {
                        SobotTCPServer.this.n++;
                        if (SobotTCPServer.this.r == null || SobotTCPServer.this.r.size() <= 0) {
                            if (SobotTCPServer.this.n > 3) {
                                SobotTCPServer.this.a(false);
                                return;
                            } else {
                                SobotTCPServer sobotTCPServer = SobotTCPServer.this;
                                sobotTCPServer.f(sobotTCPServer.d());
                            }
                        } else if (SobotTCPServer.this.n > 3) {
                            SobotTCPServer.this.a(false);
                            return;
                        }
                        if (SobotTCPServer.this.q == 0) {
                            SobotTCPServer.this.d().b();
                        }
                    }
                }
            };
            this.F = timerTask2;
            try {
                this.E.schedule(timerTask2, 300L, 5000L);
            } catch (Exception e) {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b n() {
        if (this.M == null) {
            this.M = new b();
        }
        return this.M;
    }

    private void o() {
        com.sobot.chat.core.a.a aVar = this.B;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.I = 0;
        n().removeCallbacks(this.N);
        HashMap hashMap = new HashMap();
        hashMap.put("content", "isOnline:" + this.O + "  pollingSt:" + this.I + "  inPolling:" + this.J + "  isRunning:" + this.m);
        hashMap.put("title", "stopPolling");
        LogUtils.i2Local(hashMap, "tcp关闭轮询");
    }

    public void a() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(this.y, j());
            return;
        }
        if (this.x == null) {
            this.x = new a();
        }
        bindService(new Intent(this, AssistService.class), this.x, 1);
    }

    public void a(Context context, NetworkInfo networkInfo) {
        if (networkInfo == null) {
            b = null;
            f14534c = null;
            g();
        } else if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
            if (b(context, networkInfo)) {
                g();
            }
            d = true;
        } else {
            if (d) {
                b = null;
                f14534c = null;
                g();
            }
            d = false;
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        synchronized (this) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            if (!TextUtils.isEmpty(str4)) {
                this.j = str4;
            }
            if (!TextUtils.isEmpty(str5)) {
                this.k = str5;
            }
            this.l = str6;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("u", str);
                jSONObject.put(d.N, str2);
                jSONObject.put(RemoteMessageConst.MSGID, Util.createMsgId(str));
                jSONObject.put("t", 0);
                jSONObject.put("appkey", str3);
                this.i = jSONObject.toString();
                k();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(boolean z) {
        this.s = z;
        this.q = 1;
        o();
        e();
        Util.notifyConnStatus(this.e, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("inPolling:");
        sb.append(this.J);
        sb.append("    isRunning:");
        sb.append(this.m);
        sb.append("   isPollingStart:");
        sb.append(f());
        sb.append("   !isOnline");
        sb.append(!this.O);
        LogUtils.i(sb.toString());
        this.I = 1;
        n().removeCallbacks(this.N);
        n().postDelayed(this.N, m.ag);
        HashMap hashMap = new HashMap();
        hashMap.put("content", "isOnline:" + this.O + "  pollingSt:" + this.I + "  inPolling:" + this.J + "  isRunning:" + this.m);
        hashMap.put("title", "startPolling");
        LogUtils.i2Local(hashMap, "tcp开启轮询");
    }

    public void b(boolean z) {
        this.O = z;
        if (z) {
            return;
        }
        p();
    }

    public boolean b() {
        com.sobot.chat.core.a.a aVar = this.B;
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    public boolean b(Context context, NetworkInfo networkInfo) {
        WifiInfo wifiInfo;
        if (networkInfo.getType() == 1) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo wifiInfo2 = null;
            if (wifiManager != null) {
                try {
                    wifiInfo2 = wifiManager.getConnectionInfo();
                } catch (Exception e) {
                    wifiInfo2 = null;
                }
            }
            if (wifiInfo2 != null && (wifiInfo = f14534c) != null && wifiInfo.getBSSID() != null && f14534c.getBSSID().equals(wifiInfo2.getBSSID()) && f14534c.getSSID().equals(wifiInfo2.getSSID()) && f14534c.getNetworkId() == wifiInfo2.getNetworkId()) {
                LogUtils.i("Same Wifi, do not NetworkChanged");
                return false;
            }
            f14534c = wifiInfo2;
        } else {
            NetworkInfo networkInfo2 = b;
            if (networkInfo2 != null && networkInfo2.getExtraInfo() != null && networkInfo.getExtraInfo() != null && b.getExtraInfo().equals(networkInfo.getExtraInfo()) && b.getSubtype() == networkInfo.getSubtype() && b.getType() == networkInfo.getType()) {
                return false;
            }
            NetworkInfo networkInfo3 = b;
            if (networkInfo3 != null && networkInfo3.getExtraInfo() == null && networkInfo.getExtraInfo() == null && b.getSubtype() == networkInfo.getSubtype() && b.getType() == networkInfo.getType()) {
                LogUtils.i("Same Network, do not NetworkChanged");
                return false;
            }
        }
        b = networkInfo;
        return true;
    }

    public void c() {
        synchronized (this) {
            this.n = 0;
            this.m = false;
            o();
            e();
            p();
        }
    }

    public com.sobot.chat.core.a.a d() {
        if (this.B == null) {
            com.sobot.chat.core.a.a aVar = new com.sobot.chat.core.a.a();
            this.B = aVar;
            a(aVar);
            b(this.B);
            c(this.B);
            d(this.B);
            e(this.B);
            this.B.a(new com.sobot.chat.core.a.a.b() { // from class: com.sobot.chat.core.channel.SobotTCPServer.1
                @Override // com.sobot.chat.core.a.a.b
                public void a(com.sobot.chat.core.a.a aVar2) {
                    com.sobot.chat.core.a.a.a g = aVar2.g();
                    if (g != null) {
                        Util.logI("onConnected", "SocketClient: onConnected   " + g.f() + ":" + g.g());
                        SobotTCPServer.this.r.clear();
                        SparseArray<String> sparseArray = SobotTCPServer.this.r;
                        sparseArray.put(0, g.f() + ":" + g.g());
                    }
                    if (TextUtils.isEmpty(SobotTCPServer.this.i)) {
                        return;
                    }
                    SobotTCPServer.this.n = 0;
                    SobotTCPServer.this.p();
                    SobotTCPServer.this.e();
                    SobotTCPServer.this.q = 0;
                    if (SobotTCPServer.this.B != null) {
                        SobotTCPServer.this.B.a(com.sobot.chat.core.a.b.b.c(SobotTCPServer.this.i, "UTF-8"));
                        Util.notifyConnStatus(SobotTCPServer.this.e, 2);
                        LogUtils.i("通道已连接");
                        LogUtils.i2Local("tcp 通道", "通道已连接");
                    }
                }

                @Override // com.sobot.chat.core.a.a.b
                public void a(com.sobot.chat.core.a.a aVar2, j jVar) {
                    if (jVar.f()) {
                        return;
                    }
                    if (jVar.h() != 3) {
                        jVar.h();
                        return;
                    }
                    String msgId = Util.getMsgId(jVar.b());
                    if (TextUtils.isEmpty(msgId)) {
                        Util.notifyMsg(SobotTCPServer.this.e, jVar);
                        return;
                    }
                    if (SobotTCPServer.this.A == null) {
                        Util.notifyMsg(SobotTCPServer.this.e, jVar);
                    } else if (SobotTCPServer.this.A.indexOf(msgId) == -1) {
                        SobotTCPServer.this.A.offer(msgId);
                        Util.notifyMsg(SobotTCPServer.this.e, jVar);
                    }
                    String createReceipt = Util.createReceipt(msgId);
                    if (TextUtils.isEmpty(createReceipt) || SobotTCPServer.this.B == null) {
                        return;
                    }
                    SobotTCPServer.this.B.a(com.sobot.chat.core.a.b.b.e(createReceipt, "UTF-8"));
                }

                @Override // com.sobot.chat.core.a.a.b
                public void b(com.sobot.chat.core.a.a aVar2) {
                    Util.logI("onDisconnected", "SocketClient: onDisconnected");
                    LogUtils.i("通道已断开");
                    LogUtils.i2Local("tcp 通道", "通道已断开");
                    SobotTCPServer.this.m();
                }
            });
        }
        return this.B;
    }

    public void e() {
        try {
            if (this.E != null) {
                this.E.cancel();
                this.E = null;
            }
            if (this.F != null) {
                this.F.cancel();
                this.F = null;
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            this.E = null;
            this.F = null;
            throw th;
        }
        this.E = null;
        this.F = null;
        this.z = false;
        this.n = 0;
    }

    public boolean f() {
        return this.I == 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.saveLongData(this, "sobot_scope_time", 0L);
        this.w = LocalBroadcastManager.getInstance(this);
        i();
    }

    @Override // android.app.Service
    public void onDestroy() {
        MyMessageReceiver myMessageReceiver;
        SharedPreferencesUtil.saveLongData(this, "sobot_scope_time", System.currentTimeMillis());
        LocalBroadcastManager localBroadcastManager = this.w;
        if (localBroadcastManager != null && (myMessageReceiver = this.u) != null) {
            localBroadcastManager.unregisterReceiver(myMessageReceiver);
        }
        SystemMessageReceiver systemMessageReceiver = this.v;
        if (systemMessageReceiver != null) {
            unregisterReceiver(systemMessageReceiver);
            this.v = null;
        }
        c();
        if (this.w != null) {
            this.w = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        if (this.B != null) {
            this.B = null;
        }
        LogUtils.i("推送服务被销毁");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Const.SOBOT_UID);
            String stringExtra2 = intent.getStringExtra(Const.SOBOT_PUID);
            String stringExtra3 = intent.getStringExtra(Const.SOBOT_WSLINKBAK);
            String stringExtra4 = intent.getStringExtra(Const.SOBOT_WSLINKDEFAULT);
            String stringExtra5 = intent.getStringExtra(Const.SOBOT_APPKEY);
            String stringExtra6 = intent.getStringExtra(Const.SOBOT_WAYHTTP);
            b(true);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra5)) {
                return 3;
            }
            a(stringExtra, stringExtra2, stringExtra5, stringExtra3, stringExtra4, stringExtra6);
            return 3;
        }
        return 3;
    }
}
