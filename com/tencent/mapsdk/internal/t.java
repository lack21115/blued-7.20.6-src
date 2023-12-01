package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t.class */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24322a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t$a.class */
    public class a implements Callback<Void> {
        public final /* synthetic */ ViewGroup b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TencentMapOptions f24323c;
        public final /* synthetic */ Callback d;

        public a(ViewGroup viewGroup, TencentMapOptions tencentMapOptions, Callback callback) {
            this.b = viewGroup;
            this.f24323c = tencentMapOptions;
            this.d = callback;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Void r6) {
            BaseMapView.MapViewProxy a2 = t.this.a(u.d().f(), this.b, this.f24323c);
            Callback callback = this.d;
            if (callback != null) {
                callback.callback(a2);
            }
        }
    }

    public t(Context context) {
        this.f24322a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseMapView.MapViewProxy a(s sVar, ViewGroup viewGroup, TencentMapOptions tencentMapOptions) {
        return sVar.createDelegate(this.f24322a, tencentMapOptions, viewGroup);
    }

    private String a(TencentMapOptions tencentMapOptions) {
        String mapKey = tencentMapOptions.getMapKey();
        String str = mapKey;
        if (f7.b(mapKey)) {
            str = g7.a(this.f24322a, "TencentMapSDK");
        }
        String customUserId = tencentMapOptions.getCustomUserId();
        String str2 = customUserId;
        if (TextUtils.isEmpty(customUserId)) {
            str2 = "undefined";
        }
        return str + "," + str2;
    }

    public BaseMapView.MapViewProxy a(ViewGroup viewGroup, TencentMapOptions tencentMapOptions) {
        u.d().init(this.f24322a, a(tencentMapOptions));
        return a(u.d().f(), viewGroup, tencentMapOptions);
    }

    public void a(ViewGroup viewGroup, TencentMapOptions tencentMapOptions, Callback<BaseMapView.MapViewProxy> callback) {
        u.d().a(this.f24322a, a(tencentMapOptions), new a(viewGroup, tencentMapOptions, callback));
    }
}
