package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PropModule;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredNoticeItemView.class */
public class PkDaredNoticeItemView extends FrameLayout {
    public int a;
    private List<View> b;
    private DecelerateInterpolator c;
    private AccelerateInterpolator d;
    private Runnable e;

    public PkDaredNoticeItemView(Context context) {
        super(context);
        this.c = new DecelerateInterpolator(1.7f);
        this.d = new AccelerateInterpolator(1.7f);
        this.a = 0;
        a(context);
    }

    public PkDaredNoticeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new DecelerateInterpolator(1.7f);
        this.d = new AccelerateInterpolator(1.7f);
        this.a = 0;
        a(context);
    }

    public PkDaredNoticeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new DecelerateInterpolator(1.7f);
        this.d = new AccelerateInterpolator(1.7f);
        this.a = 0;
        a(context);
    }

    private SpannableString a(String str, String str2) {
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return new SpannableString("");
            }
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.syc_dark_FFB119)), str.length(), spannableString.length(), 17);
            return spannableString;
        }
        return new SpannableString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        List<View> list = this.b;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                setAlpha(1.0f);
                b(j);
                return;
            }
            View view = this.b.get(i2);
            view.setAlpha(0.0f);
            view.setTranslationX(getWidth());
            view.animate().alpha(1.0f).translationX(0.0f).setDuration((i2 * 120) + HttpURLConnection.HTTP_BAD_REQUEST).setStartDelay((i2 * 100) + 100).setInterpolator(this.c).setListener(null);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PropModule propModule) {
        a(propModule.noticeDuration);
    }

    private void b(long j) {
        if (this.e != null) {
            AppInfo.n().removeCallbacks(this.e);
            this.e = null;
        }
        Handler n = AppInfo.n();
        Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredNoticeItemView$m2X_2MkUC3E6rVpz4QYaLjaVAKA
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredNoticeItemView.this.c();
            }
        };
        this.e = runnable;
        long j2 = j;
        if (j <= 0) {
            j2 = 5000;
        }
        n.postDelayed(runnable, j2);
    }

    public void a() {
        if (this.e != null) {
            AppInfo.n().removeCallbacks(this.e);
            this.e = null;
        }
    }

    protected void a(Context context) {
        this.b = new ArrayList();
    }

    public void a(IRequestHost iRequestHost, boolean z, final PropModule propModule) {
        LayoutInflater.from(getContext()).inflate(R.layout.include_pk_dared_notice_prop, this);
        TextView textView = (TextView) findViewById(R.id.tv_notice_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_notice_content);
        ImageView imageView = (ImageView) findViewById(R.id.iv_icon);
        textView.getPaint().setFakeBoldText(true);
        setAlpha(0.0f);
        String string = getContext().getResources().getString(z ? R.string.live_pk_dared_our : R.string.live_pk_dared_opposite);
        int color = ContextCompat.getColor(getContext(), z ? R.color.syc_dark_4D98FF : R.color.syc_dark_FF2E94);
        textView.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_use_prop), string, propModule.propName));
        textView.setTextColor(color);
        textView2.setText(a(propModule.function, propModule.markUp));
        imageView.setImageResource(R.drawable.live_pk_dared_prop_big_blood);
        ImageLoader.a(iRequestHost, propModule.propIcon).a(imageView);
        this.b.add(textView);
        this.b.add(textView2);
        this.b.add(imageView);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredNoticeItemView$CDeJhxRS2rNuNbVCeQjl9NMlRQc
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredNoticeItemView.this.a(propModule);
            }
        });
    }

    public void a(boolean z, String str, String str2, final int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.include_pk_dared_notice_first_kill, this);
        TextView textView = (TextView) findViewById(R.id.tv_notice_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_notice_content);
        textView.getPaint().setFakeBoldText(true);
        setAlpha(0.0f);
        if (z) {
            String str3 = str;
            if (str.length() > 5) {
                str3 = str.substring(0, 4) + "…";
            }
            textView.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_our_get_first_kill), str3));
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_6397FF));
        } else {
            textView.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_opposite_get_first_kill), new Object[0]));
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_FF5D93));
        }
        textView2.setText(str2);
        this.b.add(textView);
        this.b.add(textView2);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredNoticeItemView$0Pusyww68G0vUY7qShu8Yu3BzqU
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredNoticeItemView.this.a(i);
            }
        });
        this.a = 1;
    }

    /* renamed from: b */
    public void c() {
        a();
        List<View> list = this.b;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a = 2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            View view = this.b.get(i2);
            view.animate().alpha(0.0f).translationX(-getWidth()).setDuration((i2 * 80) + 250).setStartDelay(i2 * 40).setInterpolator(this.d);
            if (i2 == this.b.size() - 1) {
                view.animate().setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredNoticeItemView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        PkDaredNoticeItemView.this.a = 3;
                        PkDaredNoticeItemView.this.setVisibility(8);
                        PkDaredObserver.a().a(PkDaredNoticeItemView.this);
                    }
                });
            } else {
                view.animate().setListener(null);
            }
            i = i2 + 1;
        }
    }
}
