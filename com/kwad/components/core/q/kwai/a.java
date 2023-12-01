package com.kwad.components.core.q.kwai;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.a.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/q/kwai/a.class */
public class a extends com.kwad.components.core.j.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> PB = new ConcurrentHashMap();
    private static final AtomicInteger PC = new AtomicInteger(1);
    private int PA;
    private String Px;
    private boolean Py;
    private h Pz;
    private AdTemplate mAdTemplate;
    private AdBaseFrameLayout mRootContainer;
    private StyleTemplate mStyleTemplate;
    private com.kwad.components.core.a.a mTitleBarHelper;

    public static void a(int i, String str, Object obj) {
        Map<String, Object> map = PB.get(Integer.valueOf(i));
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
            PB.put(Integer.valueOf(i), hashMap);
        }
        hashMap.put(str, obj);
    }

    private Object aA(String str) {
        return g(this.PA, str);
    }

    private static void aI(int i) {
        Map<String, Object> map = PB.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    private static Object g(int i, String str) {
        Map<String, Object> map = PB.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.j.b
    /* renamed from: pC */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.mStyleTemplate = this.mStyleTemplate;
        bVar.mRootContainer = this.mRootContainer;
        bVar.Pz = this.Pz;
        return bVar;
    }

    public static int pD() {
        return PC.incrementAndGet();
    }

    public static void register() {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(Intent intent) {
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        try {
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(new JSONObject(stringExtra));
            this.mStyleTemplate = styleTemplate;
            String stringExtra2 = getIntent().getStringExtra("tk_ad_template");
            if (TextUtils.isEmpty(stringExtra2)) {
                return true;
            }
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra2));
                this.mAdTemplate = adTemplate;
                return true;
            } catch (Throwable th) {
                return false;
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.Py = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Px = getIntent().getStringExtra("title");
        this.PA = getIntent().getIntExtra("tk_id", 0);
        this.Pz = (h) aA("native_intent");
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        this.mRootContainer = adBaseFrameLayout;
        if (!this.Py) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adBaseFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            this.mRootContainer.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.a.a aVar = new com.kwad.components.core.a.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0339a() { // from class: com.kwad.components.core.q.kwai.a.1
            @Override // com.kwad.components.core.a.a.InterfaceC0339a
            public final void t(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0339a
            public final void u(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(this.Px));
        this.mTitleBarHelper.am(false);
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        return new com.kwad.components.core.q.a.a();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        aI(this.PA);
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
