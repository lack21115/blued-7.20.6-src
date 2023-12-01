package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ad.class */
public class ad extends bf {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6459a = 17;
    private static final String q = "javascript:";
    private int A;
    private boolean B;
    private String C;
    private int r;
    private int s;
    private int[] t;
    private boolean u;
    private int v;
    private HashMap<String, Object> w;
    private NativeCPUManager.CPUAdListener x;
    private NativeCPUManager y;
    private int z;

    public ad(Context context) {
        super(context);
        this.z = 5;
        this.A = 60;
    }

    public ad(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.z = 5;
        this.A = 60;
        this.o = str;
        this.y = nativeCPUManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                an.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    private String i(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.k.createProdHandler(jSONObject4);
            n();
            this.k.addEventListener("Update_fbReader_Setting", new ae(this));
            this.k.addEventListener("closeInterstitialAd", new af(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.o);
            jSONObject.put("pageIndex", this.s);
            jSONObject.put("pageSize", this.r);
            jSONObject.put("channels", this.t);
            jSONObject.put("showAd", this.u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject2.put("timeout", this.v);
            if (this.w == null || this.w.isEmpty()) {
                av.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            JSONObject a2 = j.a(this.w);
            jSONObject3 = a2;
            if (a2 != null) {
                jSONObject3 = a2;
                a2.put("isInitNovelSDK", this.B);
                jSONObject3 = a2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject3);
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(int i, int i2, int[] iArr, boolean z, HashMap<String, Object> hashMap) {
        this.s = i;
        this.r = i2;
        this.t = iArr;
        this.u = z;
        this.w = hashMap;
        this.B = an.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        super.a(i, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(WebView webView, JSONObject jSONObject) {
        a(new ah(this, jSONObject, webView));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        if (this.x != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) iOAdEvent.getData().get("cpuAdList")) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.h, obj, this.w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.x.onAdLoaded(arrayList);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.x = cPUAdListener;
    }

    public void a(String str) {
        this.C = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        super.b(str, i);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get(BrowserContract.Bookmarks.POSITION);
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(IOAdEvent iOAdEvent) {
        try {
            if (this.x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.x.onLpCustomEventCallBack(hashMap, new ag(this, hashMap.get("activity")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void f() {
        an.a(this.z);
        an.b(this.A);
        an.a(new ai(this));
    }

    public Activity g() {
        return an.c();
    }

    public boolean h() {
        return an.d();
    }
}
