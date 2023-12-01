package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PropModule;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredNoticeView.class */
public class PkDaredNoticeView extends RelativeLayout {
    private View a;
    private RelativeLayout b;
    private List<PkDaredNoticeItemView> c;

    public PkDaredNoticeView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredNoticeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredNoticeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public PkDaredNoticeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void c() {
        if (this.c.isEmpty()) {
            this.a.animate().cancel();
            this.a.animate().alpha(1.0f).setDuration(300L).setListener(null);
        } else {
            for (PkDaredNoticeItemView pkDaredNoticeItemView : this.c) {
                if (pkDaredNoticeItemView.a < 2) {
                    pkDaredNoticeItemView.c();
                }
            }
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void a() {
        b();
        List<PkDaredNoticeItemView> list = this.c;
        if (list != null) {
            list.clear();
        }
        this.a.setAlpha(0.0f);
        this.b.removeAllViews();
        setVisibility(8);
    }

    protected void a(Context context) {
        this.c = new ArrayList();
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_notice, this);
        this.a = findViewById(R.id.view_background);
        this.b = (RelativeLayout) findViewById(R.id.rl_notice_root);
    }

    public void a(IRequestHost iRequestHost, boolean z, PropModule propModule) {
        c();
        PkDaredNoticeItemView pkDaredNoticeItemView = new PkDaredNoticeItemView(getContext());
        this.c.add(pkDaredNoticeItemView);
        this.b.addView(pkDaredNoticeItemView);
        pkDaredNoticeItemView.a(iRequestHost, z, propModule);
    }

    public void a(PkDaredNoticeItemView pkDaredNoticeItemView) {
        this.b.removeView(pkDaredNoticeItemView);
        this.c.remove(pkDaredNoticeItemView);
        if (this.c.isEmpty()) {
            this.a.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredNoticeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (PkDaredNoticeView.this.c.isEmpty()) {
                        PkDaredNoticeView.this.setVisibility(8);
                    }
                }
            });
        }
    }

    public void a(boolean z, String str, String str2, int i) {
        c();
        PkDaredNoticeItemView pkDaredNoticeItemView = new PkDaredNoticeItemView(getContext());
        this.c.add(pkDaredNoticeItemView);
        this.b.addView(pkDaredNoticeItemView);
        pkDaredNoticeItemView.a(z, str, str2, i * 1000);
    }

    public void b() {
        List<PkDaredNoticeItemView> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (PkDaredNoticeItemView pkDaredNoticeItemView : this.c) {
            pkDaredNoticeItemView.a();
        }
    }
}
