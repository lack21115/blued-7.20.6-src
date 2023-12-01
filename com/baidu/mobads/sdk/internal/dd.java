package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.huawei.openalliance.ad.constant.bc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dd.class */
public class dd extends bf {
    private e.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private e.b D;
    private int E;

    /* renamed from: a  reason: collision with root package name */
    private List<NativeResponse> f6574a;
    private List<ExpressResponse> q;
    private List<EntryResponse> r;
    private int s;
    private boolean t;
    private String u;
    private String v;
    private int w;
    private int x;
    private RequestParameters y;
    private boolean z;

    public dd(Context context, String str, String str2, boolean z, int i) {
        super(context);
        this.s = 8000;
        this.z = false;
        this.E = 0;
        this.v = str;
        this.u = str2;
        this.t = z;
        this.s = i;
        this.w = 600;
        this.x = 500;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.G());
        } catch (JSONException e) {
            bq.a().a(e);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        this.k.loadAd(k(), l());
    }

    public void a(int i) {
        this.E = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i, str);
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.G());
            hashMap.put("container", viewGroup);
        } catch (JSONException e) {
            bq.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.w = width;
            this.x = height;
        }
        this.y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    public void a(e.a aVar) {
        this.A = aVar;
    }

    public void a(e.b bVar) {
        this.D = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f6574a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f6574a.size()) {
                    break;
                }
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
                i = i2 + 1;
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i4);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.a(z);
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        int i;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        String[] strArr = ArticleInfo.PREDEFINED_KEYS;
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= length) {
                break;
            }
            String str = strArr[i2];
            int i4 = i;
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (TextUtils.isEmpty(str2)) {
                    i4 = i;
                } else {
                    int length2 = str2.length() + i;
                    i4 = i;
                    if (length2 < 150) {
                        hashMap2.put(str, str2);
                        i4 = length2;
                    }
                }
            }
            i2++;
            i3 = i4;
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length3 = i + str3.length() + str4.length();
                        if (length3 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i = length3 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.m = hashMap2;
    }

    public boolean a(View view, a aVar, int i) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put(com.anythink.expressad.a.B, view);
            hashMap.put("code", Integer.valueOf(i));
        } catch (JSONException e) {
            bq.a().a(e);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put("activity", activity);
        } catch (JSONException e) {
            bq.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.f6574a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6574a.size()) {
                return;
            }
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f6574a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f6574a.size()) {
                    break;
                }
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
                i = i2 + 1;
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i4);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.b(z);
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                if (TextUtils.equals("show", str2)) {
                    bnVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get("reason");
                    bnVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    bnVar.e();
                }
            }
            i = i2 + 1;
        }
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a2 = j.a(map);
            if (this.m == null) {
                this.m = new HashMap<>();
            }
            if (a2.isEmpty()) {
                return;
            }
            for (String str : a2.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a2.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.m.put(str, str2);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f6574a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f6574a.size()) {
                    break;
                }
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
                i = i2 + 1;
            }
        }
        if (!TextUtils.isEmpty(str) && this.q != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.q.size()) {
                    break;
                }
                bn bnVar = (bn) this.q.get(i4);
                if (TextUtils.equals(str, bnVar.a())) {
                    bnVar.f();
                }
                i3 = i4 + 1;
            }
        }
        if (TextUtils.isEmpty(str) || this.r == null) {
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.r.size()) {
                return;
            }
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i6);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        if (this.A != null && !TextUtils.isEmpty(message) && this.f6574a != null) {
            for (int i = 0; i < this.f6574a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
            }
        } else if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.q.size()) {
                    return;
                }
                bn bnVar = (bn) this.q.get(i3);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.c();
                }
                i2 = i3 + 1;
            }
        } else if (this.C != null && !TextUtils.isEmpty(message) && this.r != null) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.r.size()) {
                    return;
                }
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i5);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onADExposed();
                }
                i4 = i5 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f6574a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f6574a.size()) {
                    break;
                }
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
                i = i2 + 1;
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i4);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.g();
            }
            i3 = i4 + 1;
        }
    }

    public String f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        if (this.A != null && data != null && this.f6574a != null) {
            String str = (String) data.get("instanceInfo");
            for (int i = 0; i < this.f6574a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
            }
        } else if (this.C != null && data != null && this.r != null) {
            String str2 = (String) data.get("instanceInfo");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.r.size()) {
                    return;
                }
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i3);
                if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                    xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
                }
                i2 = i3 + 1;
            }
        }
    }

    public RequestParameters g() {
        return this.y;
    }

    public String h() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        if (this.A != null && !TextUtils.isEmpty(message) && this.f6574a != null) {
            for (int i = 0; i < this.f6574a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
            }
        } else if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.q.size()) {
                    return;
                }
                bn bnVar = (bn) this.q.get(i3);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.b();
                }
                i2 = i3 + 1;
            }
        } else if (this.C != null && !TextUtils.isEmpty(message) && this.r != null) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.r.size()) {
                    return;
                }
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i5);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onAdClick();
                }
                i4 = i5 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, intValue, intValue2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, str2, intValue);
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.u);
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.v);
            if (cn.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if ("video".equals(this.u)) {
                jSONObject.put("at", "10");
                jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(2);
                jSONObject.put("at", sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.w);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(this.x);
            jSONObject.put("h", sb3.toString());
            jSONObject.put("msa", 143);
            JSONObject a2 = j.a(jSONObject, b(this.m));
            a2.put("opt", this.E);
            if (this.E == 0) {
                a2.put("optn", 1);
            }
            jSONObject2 = a2;
            b(a2);
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f6574a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6574a.size()) {
                return;
            }
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6574a.get(i2);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals(bc.b.C, str2)) {
                xAdNativeResponse.onShakeViewDismiss();
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.s);
            jSONObject.put("isCacheVideo", this.t);
            jSONObject.put("cacheVideoOnlyWifi", this.z);
            jSONObject.put("appConfirmPolicy", this.y == null ? 1 : this.y.getAPPConfirmPolicy());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0147, code lost:
        if (com.baidu.mobads.sdk.internal.br.a(r7.h, r0) != false) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e0 A[SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.bf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dd.q():void");
    }
}
