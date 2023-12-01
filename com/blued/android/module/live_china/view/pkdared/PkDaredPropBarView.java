package com.blued.android.module.live_china.view.pkdared;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PropModule;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredPropBarView.class */
public class PkDaredPropBarView extends FrameLayout {
    private RelativeLayout a;
    private RelativeLayout b;
    private List<PkDaredPropItemView> c;

    public PkDaredPropBarView(Context context) {
        super(context);
        this.c = new ArrayList();
        a(context);
    }

    public PkDaredPropBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        a(context);
    }

    public PkDaredPropBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        a(context);
    }

    public PkDaredPropBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = new ArrayList();
        a(context);
    }

    public void a() {
        b();
        List<PkDaredPropItemView> list = this.c;
        if (list != null) {
            list.clear();
        }
        this.a.removeAllViews();
        this.b.removeAllViews();
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_prop_bar, this);
        this.a = (RelativeLayout) findViewById(R.id.rl_prop_our);
        this.b = (RelativeLayout) findViewById(R.id.rl_prop_opposite);
    }

    public void a(IRequestHost iRequestHost, PropModule propModule) {
        if (propModule == null) {
            return;
        }
        PkDaredPropItemView pkDaredPropItemView = new PkDaredPropItemView(getContext());
        List<PkDaredPropItemView> list = this.c;
        if (list != null) {
            list.add(pkDaredPropItemView);
        }
        pkDaredPropItemView.a(iRequestHost, propModule.isOur ? this.a : this.b, propModule);
    }

    public void a(boolean z, PkDaredPropItemView pkDaredPropItemView) {
        List<PkDaredPropItemView> list = this.c;
        if (list != null || !list.isEmpty()) {
            this.c.remove(pkDaredPropItemView);
        }
        if (z) {
            this.a.removeView(pkDaredPropItemView);
        } else {
            this.b.removeView(pkDaredPropItemView);
        }
        List<PkDaredPropItemView> list2 = this.c;
        if (list2 == null || list2.isEmpty()) {
            PkDaredObserver.a().c();
        }
    }

    public void b() {
        List<PkDaredPropItemView> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (PkDaredPropItemView pkDaredPropItemView : this.c) {
            if (pkDaredPropItemView != null) {
                pkDaredPropItemView.a();
            }
        }
    }

    public void c() {
        List<PkDaredPropItemView> list = this.c;
        if (list != null || !list.isEmpty()) {
            this.c.clear();
        }
        this.a.removeAllViews();
        this.b.removeAllViews();
        PkDaredObserver.a().c();
    }

    public boolean d() {
        List<PkDaredPropItemView> list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
