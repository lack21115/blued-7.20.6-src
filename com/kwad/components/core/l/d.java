package com.kwad.components.core.l;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.r.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/l/d.class */
public abstract class d extends IActivityProxy {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    private final com.kwad.components.core.l.kwai.a mPageMonitor = new com.kwad.components.core.l.kwai.a();
    public View mRootView;

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    protected boolean checkIntentData(Intent intent) {
        return true;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public <T extends View> T findViewById(int i) {
        T t = (T) this.mRootView.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        j.e(intent);
        return intent;
    }

    protected abstract int getLayoutId();

    protected abstract String getPageName();

    protected abstract void initData();

    protected abstract void initView();

    protected boolean needAdaptionScreen() {
        return false;
    }

    public void onActivityCreate() {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            if (!KsAdSDKImpl.get().hasInitFinish()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            this.mContext = k.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            if (!checkIntentData(intent)) {
                finish();
                return;
            }
            getWindow().setFlags(16777216, 16777216);
            getActivity().setTheme(16973838);
            long j = 0;
            if (intent != null) {
                j = intent.getLongExtra("key_start_time", 0L);
            }
            this.mPageMonitor.ax(getPageName());
            this.mPageMonitor.u(j);
            int layoutId = getLayoutId();
            if (layoutId != 0) {
                setContentView(layoutId);
            }
            initData();
            initView();
            h.oZ().a(this, bundle);
            onActivityCreate();
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
            finish();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        h.oZ().f(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        h.oZ().e(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            if (!KsAdSDKImpl.get().getIsExternal() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                com.kwad.components.core.r.d.a(getActivity(), 0, true, false);
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
        disableFragmentRestore(bundle);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.core.l.kwai.a aVar = this.mPageMonitor;
        getActivity();
        aVar.pa();
        h.oZ().d(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        View inflate = k.inflate(this.mContext, i, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }
}
