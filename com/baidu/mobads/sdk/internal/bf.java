package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.core.common.c.k;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bf.class */
public abstract class bf extends Observable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9335a = "b_f";
    public static final String b = "XAbstractProdTemplate";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9336c = "error_message";
    public static final String d = "error_code";
    protected static final String e = "instanceInfo";
    protected static final String f = "showState";
    protected RelativeLayout g;
    protected Context h;
    public HashMap<String, String> m;
    public String n;
    public String o;
    protected bq i = bq.a();
    public IAdInterListener k = null;
    public boolean l = true;
    public int p = -1;
    public IOAdEventListener j = new a();

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bf$a.class */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            String str;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                str = message;
                if (TextUtils.isEmpty(message)) {
                    Map<String, Object> data = iOAdEvent.getData();
                    str = message;
                    if (data != null) {
                        Object obj = data.get("msg");
                        str = message;
                        if (obj != null) {
                            str = message;
                            if (obj instanceof String) {
                                return (String) obj;
                            }
                        }
                    }
                }
            } else {
                str = null;
            }
            return str;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bf.a(new bi(this, iOAdEvent));
        }
    }

    public bf(Context context) {
        this.h = context;
        z.a().a(this.h, new bg(this));
    }

    private String a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject2.toString());
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bh(runnable));
            }
        } catch (Exception e2) {
        }
    }

    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str) {
        r();
    }

    public void a(Activity activity) {
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IOAdEvent iOAdEvent) {
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            if (this.k != null) {
                this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            if (this.k != null) {
                this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z) {
    }

    public void a(String str, boolean z, String str2) {
        a(str, z, str2, null);
    }

    public void a(String str, boolean z, String str2, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z);
            jSONObject.put("replacement", str2);
            if (hashMap != null) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            if (this.k != null) {
                this.k.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.m = (HashMap) map;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public JSONObject b(Map<String, String> map) {
        JSONObject jSONObject = null;
        if (map != null) {
            if (map.isEmpty()) {
                return null;
            }
            try {
                jSONObject = new JSONObject(map);
            } catch (Exception e2) {
                return null;
            }
        }
        return jSONObject;
    }

    public void b(int i) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(IOAdEvent iOAdEvent) {
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.k == null) {
            b("Initialization doesn't finish yet.", 1);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bidding_data", str);
        a("load_bidding_data", (Map<String, Object>) hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, int i) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        int i = this.p;
        if (i < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f9335a, i);
        } catch (Throwable th) {
            this.i.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.k == null) {
            b("Initialization doesn't finish yet.", 1);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(k.a.b, str);
        a("load_bidding_ad", (Map<String, Object>) hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    public void g(String str) {
        this.o = str;
    }

    public String h(String str) {
        IXAdContainerFactory c2;
        z a2 = z.a();
        if (a2 == null || (c2 = a2.c()) == null) {
            return null;
        }
        Object remoteParam = c2.getRemoteParam(str, new Object[0]);
        if (remoteParam instanceof String) {
            return (String) remoteParam;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(IOAdEvent iOAdEvent) {
    }

    public void i() {
        this.k = (IAdInterListener) ar.a(w.k, bp.a(this.h), new Class[]{Context.class}, this.h);
        if (this.l) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k = k();
        JSONObject l = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k);
        hashMap.put("ad_buss_param", l);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.b.e, new b.a());
            this.k.addEventListener(w.H, this.j);
            this.k.addEventListener(w.J, this.j);
            this.k.addEventListener(w.L, this.j);
            this.k.addEventListener(w.M, this.j);
            this.k.addEventListener(w.W, this.j);
            this.k.addEventListener(w.r, this.j);
            this.k.addEventListener(w.X, this.j);
            this.k.addEventListener(w.s, this.j);
            this.k.addEventListener(w.N, this.j);
            this.k.addEventListener(w.O, this.j);
            this.k.addEventListener(w.K, this.j);
            this.k.addEventListener(w.D, this.j);
            this.k.addEventListener(w.ac, this.j);
            this.k.addEventListener(w.ad, this.j);
            this.k.addEventListener(w.aa, this.j);
            this.k.addEventListener(w.V, this.j);
            this.k.addEventListener(w.ae, this.j);
            this.k.addEventListener(w.af, this.j);
            this.k.addEventListener(w.ag, this.j);
            this.k.addEventListener(w.ah, this.j);
            this.k.addEventListener(w.ai, this.j);
            this.k.addEventListener(w.aj, this.j);
            this.k.addEventListener(w.ab, this.j);
            this.k.addEventListener(w.ak, this.j);
            this.k.addEventListener(w.Y, this.j);
            this.k.addEventListener(w.al, this.j);
            this.k.addEventListener(w.am, this.j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
    }

    public View v() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }
}
