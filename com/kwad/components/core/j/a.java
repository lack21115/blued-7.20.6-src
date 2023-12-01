package com.kwad.components.core.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/j/a.class */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.j.kwai.a> JT = new ArrayList();
    private final b<?> JU;
    public final Context mContext;
    public final View mRootView;

    public a(b<?> bVar) {
        this.JU = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.JU.getActivity();
    }

    public final void hq() {
        this.JU.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.JT.clear();
    }
}
