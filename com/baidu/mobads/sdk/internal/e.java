package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private dd f9426a;
    private String b;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/e$a.class */
    public interface a {
        void a();

        void a(int i, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i);

        void a(List<NativeResponse> list);

        void b();

        void b(int i, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/e$b.class */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public e(Context context, a aVar, dd ddVar) {
        this.f9426a = ddVar;
        ddVar.a(aVar);
    }

    public e(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        dd ddVar = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.f9426a = ddVar;
        ddVar.a(entryAdListener);
    }

    public e(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        dd ddVar = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i);
        this.f9426a = ddVar;
        ddVar.a(expressAdListener);
        this.f9426a.a(1);
    }

    public e(Context context, String str, a aVar, boolean z, int i) {
        this(context, aVar, new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i));
    }

    public e(Context context, String str, a aVar, boolean z, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f9426a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f9426a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f9426a = new dd(context, str, "video", z, i);
            } else {
                this.f9426a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i);
            }
        }
        this.f9426a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f9426a != null) {
            RequestParameters requestParameters2 = requestParameters;
            if (requestParameters == null) {
                requestParameters2 = new RequestParameters.Builder().build();
            }
            this.f9426a.g(this.b);
            this.f9426a.a(requestParameters2);
            return this.f9426a.m();
        }
        return null;
    }

    public void a() {
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.e();
        }
    }

    public void a(int i) {
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.p = i;
        }
    }

    public void a(b bVar) {
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.a(bVar);
        }
    }

    public void a(String str) {
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.b(str);
        }
    }

    public void a(boolean z) {
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.c(z);
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public void b(RequestParameters requestParameters) {
        RequestParameters requestParameters2 = requestParameters;
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        }
        dd ddVar = this.f9426a;
        if (ddVar != null) {
            ddVar.g(this.b);
        }
        this.f9426a.a(requestParameters2);
        this.f9426a.a();
    }

    public void b(String str) {
        this.b = str;
    }
}
