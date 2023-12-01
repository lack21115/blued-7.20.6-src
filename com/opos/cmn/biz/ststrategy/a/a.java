package com.opos.cmn.biz.ststrategy.a;

import android.content.Context;
import android.media.TtmlUtils;
import android.provider.BrowserContract;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.b.c;
import com.opos.cmn.an.j.a;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.c.e;
import com.opos.cmn.biz.ststrategy.c.f;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.func.b.b.d;
import com.tencent.tendinsv.a.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/a/a.class */
public class a implements com.opos.cmn.biz.ststrategy.b.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11004a = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, AtomicBoolean> f11005c = new ConcurrentHashMap<>();
    private static com.opos.cmn.an.j.a d = null;
    private static final byte[] e = new byte[1];
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(JSONObject jSONObject) {
        boolean z = false;
        int i = -1;
        if (jSONObject != null) {
            i = -1;
            if (jSONObject.has("code")) {
                i = -1;
                if (!jSONObject.isNull("code")) {
                    try {
                        int i2 = jSONObject.getInt("code");
                        i = i2 == 0 ? 0 : -3 != i2 ? -1 : -3;
                    } catch (JSONException e2) {
                        com.opos.cmn.an.f.a.c(f11004a, "", e2);
                        i = -1;
                    }
                }
            }
        }
        String str = f11004a;
        StringBuilder sb = new StringBuilder();
        sb.append("isResponseOKByCode result ");
        if (i == 0) {
            z = true;
        }
        sb.append(z);
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return i;
    }

    private d a(String str, String str2, boolean z) {
        try {
            return new d.a().b(str2).a(c()).a("POST").a(a(str, z)).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c(f11004a, "getSTConfigNetRequest fail", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(26:13|14|(4:88|89|90|(7:92|(2:95|96)|94|36|(3:38|39|40)|41|(1:48)(2:45|46)))|16|(1:18)(2:86|87)|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(0)|41|(2:43|48)(1:49)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0175, code lost:
        r29 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0177, code lost:
        r16 = false;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0243, code lost:
        r17 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r13, boolean r14, com.opos.cmn.biz.ststrategy.listener.a r15) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.a.a.a(java.lang.String, boolean, com.opos.cmn.biz.ststrategy.listener.a):void");
    }

    private boolean a(Context context, String str) {
        boolean z;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f11004a, "", e2);
            }
            if (!b(context, str) && !c(context, str)) {
                if (!d(context, str)) {
                    z = true;
                    com.opos.cmn.an.f.a.b(f11004a, "isLegalReq :" + z + ",dataType :" + str);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f11004a, "isLegalReq :" + z + ",dataType :" + str);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        boolean f = com.opos.cmn.biz.ststrategy.c.d.f(this.b);
        long b = com.opos.cmn.biz.ststrategy.c.d.b(this.b, str);
        long a2 = com.opos.cmn.biz.ststrategy.c.d.a(this.b);
        boolean c2 = e.c(this.b);
        String str2 = f11004a;
        com.opos.cmn.an.f.a.b(str2, "isStFileExists=" + c2 + ",ntLimit=" + a2 + ",lastTime=" + b + ",nowTime=" + System.currentTimeMillis());
        boolean z = (c2 && 0 != b && System.currentTimeMillis() < b + (a2 * 60000) && f.c(this.b) && f) ? false : true;
        String str3 = f11004a;
        com.opos.cmn.an.f.a.b(str3, "needUpdateStConfigs=" + z + ",pkgName =" + str);
        return z;
    }

    private byte[] a(String str, boolean z) {
        String str2;
        com.opos.cmn.an.f.a.b(f11004a, "getReqConfigContent");
        byte[] bArr = null;
        if (this.b != null) {
            bArr = null;
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                byte[] bArr2 = null;
                bArr = null;
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("model", c.a());
                    jSONObject2.put(b.a.l, com.opos.cmn.an.b.d.a());
                    jSONObject2.put("ptoVer", StStrategyManager.getStVerCode());
                    jSONObject2.put(TtmlUtils.TAG_REGION, com.opos.cmn.biz.a.d.a(this.b));
                    jSONObject2.put("brand", com.opos.cmn.biz.a.b.a(this.b));
                    if (f.b(this.b)) {
                        jSONObject2.put(com.anythink.expressad.foundation.g.a.P, com.opos.cmn.g.a.b.g(this.b));
                    }
                    jSONObject2.put("duId", com.opos.cmn.g.a.b.b(this.b));
                    jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.b));
                    jSONObject2.put("ouIdStatus", com.opos.cmn.g.a.b.h(this.b));
                    jSONObject2.put("from", "client");
                    JSONObject jSONObject3 = new JSONObject();
                    if (z) {
                        if (com.opos.cmn.biz.ststrategy.c.a.f11014c.equals(str)) {
                            str2 = com.opos.cmn.biz.ststrategy.c.a.b;
                        } else if (com.opos.cmn.biz.ststrategy.c.a.d.equals(str)) {
                            str2 = BrowserContract.AUTHORITY;
                        } else if ("com.opos.st.demo".equals(str)) {
                            str2 = com.opos.cmn.biz.ststrategy.c.a.b;
                        } else {
                            jSONObject3.put("pkgName", str);
                        }
                        jSONObject3.put("pkgName", str2);
                    } else {
                        jSONObject3.put(STManager.KEY_DATA_TYPE, str);
                    }
                    if (!f.c(this.b) || !z) {
                        jSONObject3.put("currTime", 0);
                    } else if (z) {
                        jSONObject3.put("currTime", com.opos.cmn.biz.ststrategy.c.d.c(this.b, str));
                    }
                    jSONObject.put("head", jSONObject2);
                    jSONObject.put(TtmlUtils.TAG_BODY, jSONObject3);
                    byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                    String str3 = f11004a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("req st config content=");
                    sb.append(jSONObject.toString());
                    bArr2 = bytes;
                    bArr = bytes;
                    com.opos.cmn.an.f.a.b(str3, sb.toString());
                    return bytes;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    bArr = bArr2;
                    com.opos.cmn.an.f.a.c(f11004a, "", e);
                    return bArr;
                } catch (JSONException e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.c(f11004a, "", e);
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private AtomicBoolean b(String str) {
        AtomicBoolean atomicBoolean;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                atomicBoolean = null;
            } else if (f11005c.containsKey(str)) {
                atomicBoolean = f11005c.get(str);
            } else {
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                f11005c.put(str, atomicBoolean2);
                atomicBoolean = atomicBoolean2;
            }
        }
        return atomicBoolean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        String str2 = f11004a;
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType begin:" + str);
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b(f11004a, "updateSTConfigsByDataType Params dataType is null");
            a(updateSTConfigListener);
            return;
        }
        AtomicBoolean b = b(str);
        if (b == null || !b.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.b(f11004a, "is initing. do nothing!!!");
            c(updateSTConfigListener);
        } else {
            com.opos.cmn.an.f.a.b(f11004a, "has no initted.init!!!");
            try {
                if (a(this.b, str)) {
                    a(str, false, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.a.a.3
                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a() {
                            a.this.a(updateSTConfigListener);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a(com.opos.cmn.func.b.b.e eVar) {
                            JSONObject a2 = e.a(a.this.b, eVar);
                            int a3 = a.this.a(a2);
                            if (a3 == 0) {
                                if (e.b(a.this.b, a2)) {
                                    a.this.b(updateSTConfigListener);
                                    return;
                                }
                            } else if (a3 == -3) {
                                long currentTimeMillis = System.currentTimeMillis();
                                a aVar = a.this;
                                if (aVar.e(aVar.b, str)) {
                                    String str3 = a.f11004a;
                                    com.opos.cmn.an.f.a.b(str3, "set first Req dataType:" + str + ",currTime=" + currentTimeMillis);
                                    com.opos.cmn.biz.ststrategy.c.d.c(a.this.b, str, currentTimeMillis);
                                }
                                com.opos.cmn.biz.ststrategy.c.d.d(a.this.b, str, currentTimeMillis);
                            }
                            a.this.a(updateSTConfigListener);
                        }
                    });
                } else {
                    a(updateSTConfigListener);
                }
            } finally {
                b.set(false);
            }
        }
        String str3 = f11004a;
        com.opos.cmn.an.f.a.b(str3, "update STConfigs by dataType end:" + str);
    }

    private boolean b(Context context, String str) {
        STConfigEntity a2;
        boolean z = (context == null || TextUtils.isEmpty(str) || (a2 = e.a()) == null || a2.dataEntity == null || a2.dataEntity.metaEntityMap == null || !a2.dataEntity.metaEntityMap.containsKey(str)) ? false : true;
        String str2 = f11004a;
        com.opos.cmn.an.f.a.b(str2, " dataType:" + str + " is included in strategy result:" + z);
        return z;
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", "application/json");
        hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        hashMap.put("Connection", com.anythink.expressad.foundation.g.f.g.c.f5066c);
        hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.b));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onNotNeedUpdate();
        }
    }

    private boolean c(Context context, String str) {
        boolean z;
        if (context != null && !TextUtils.isEmpty(str)) {
            long d2 = com.opos.cmn.biz.ststrategy.c.d.d(context, str);
            if (0 != d2 && System.currentTimeMillis() - d2 > com.opos.cmn.biz.ststrategy.c.d.d(context) * 60000) {
                z = true;
                com.opos.cmn.an.f.a.b(f11004a, "isInBlackList :" + z + ",dataType :" + str);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f11004a, "isInBlackList :" + z + ",dataType :" + str);
        return z;
    }

    private void d() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new a.C0452a().a(1).b(1).a("cmn_strategy_single").a();
                }
            }
        }
    }

    private boolean d(Context context, String str) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                long e2 = com.opos.cmn.biz.ststrategy.c.d.e(context, str);
                z = false;
                if (0 != e2) {
                    z = false;
                    if (System.currentTimeMillis() - e2 < com.opos.cmn.biz.ststrategy.c.d.c(context) * 60000) {
                        z = true;
                    }
                }
                com.opos.cmn.an.f.a.b(f11004a, "isWithinDTLimitTime firstInDTLimit:" + e2 + ", result :" + z);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context, String str) {
        boolean z = (context == null || TextUtils.isEmpty(str) || com.opos.cmn.biz.ststrategy.c.d.d(context, str) != 0) ? false : true;
        String str2 = f11004a;
        com.opos.cmn.an.f.a.b(str2, "isFirstSupplyReq result:" + z);
        return z;
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public STConfigEntity a() {
        return e.a(this.b);
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public void a(final UpdateParams updateParams, final UpdateSTConfigListener updateSTConfigListener) {
        String str;
        String str2;
        com.opos.cmn.an.f.a.b(f11004a, "update STConfigs by PkgName");
        if (updateParams == null) {
            str = f11004a;
            str2 = "update Params is null";
        } else if (!TextUtils.isEmpty(updateParams.pkgName)) {
            final AtomicBoolean b = b(updateParams.pkgName);
            if (b == null || !b.compareAndSet(false, true)) {
                com.opos.cmn.an.f.a.b(f11004a, "is initing. do nothing!!!");
                c(updateSTConfigListener);
                return;
            }
            com.opos.cmn.an.f.a.b(f11004a, "has no initted.init!!!");
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (a.this.a(updateParams.pkgName)) {
                            a.this.a(updateParams.pkgName, true, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.a.a.1.1
                                @Override // com.opos.cmn.biz.ststrategy.listener.a
                                public void a() {
                                    a.this.a(updateSTConfigListener);
                                }

                                @Override // com.opos.cmn.biz.ststrategy.listener.a
                                public void a(com.opos.cmn.func.b.b.e eVar) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    com.opos.cmn.biz.ststrategy.c.d.a(a.this.b, updateParams.pkgName, currentTimeMillis);
                                    String str3 = a.f11004a;
                                    com.opos.cmn.an.f.a.b(str3, "set pkgName:" + updateParams.pkgName + ",lastTime=" + currentTimeMillis);
                                    JSONObject a2 = e.a(a.this.b, eVar);
                                    if (a.this.a(a2) != 0 || !e.b(a.this.b, a2)) {
                                        a.this.a(updateSTConfigListener);
                                        return;
                                    }
                                    com.opos.cmn.biz.ststrategy.c.d.e(a.this.b);
                                    com.opos.cmn.biz.ststrategy.c.d.b(a.this.b, updateParams.pkgName, e.a(a.this.b, a2));
                                    a.this.b(updateSTConfigListener);
                                }
                            });
                        } else {
                            com.opos.cmn.an.f.a.b(a.f11004a, "don't need update st configs.");
                            a.this.c(updateSTConfigListener);
                        }
                    } finally {
                        b.set(false);
                    }
                }
            });
            return;
        } else {
            str = f11004a;
            str2 = "update Params pkgName is null";
        }
        com.opos.cmn.an.f.a.b(str, str2);
        a(updateSTConfigListener);
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public void a(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        d();
        com.opos.cmn.an.j.a aVar = d;
        if (aVar != null) {
            try {
                aVar.execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(str, updateSTConfigListener);
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeSingleTask", e2);
            }
        }
    }
}
