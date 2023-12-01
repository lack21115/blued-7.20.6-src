package com.anythink.expressad.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.b.i;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkClickMiniCardView.class */
public class AnythinkClickMiniCardView extends AnythinkH5EndCardView {
    private static final float A = 0.7f;
    private boolean B;

    public AnythinkClickMiniCardView(Context context) {
        super(context);
        this.B = false;
    }

    public AnythinkClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
    }

    private void a(View view) {
        int f = t.f(this.f8440a);
        int i = (int) ((f * 0.7f) + 0.5f);
        int e = (int) ((t.e(this.f8440a) * 0.7f) + 0.5f);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = e;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final String a() {
        String str = null;
        String str2 = null;
        if (this.b != null) {
            c.C0143c M = this.b.M();
            if (M != null) {
                str2 = M.d();
            }
            str = str2;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
                if (str2.contains(".zip")) {
                    String c2 = i.a().c(str2);
                    str = str2;
                    if (!TextUtils.isEmpty(c2)) {
                        str = c2;
                    }
                }
            }
        }
        return str;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final void e() {
        super.e();
        if (this.f) {
            setBackgroundResource(findColor("anythink_reward_minicard_bg"));
            a(this.p);
            setClickable(true);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f) {
            a(this.p);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i, int i2) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        View findViewById = ((Activity) this.f8440a).getWindow().findViewById(16908290);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        if (i <= 0 || i2 <= 0 || i > width || i2 > height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.p.setLayoutParams(layoutParams);
    }

    public void setAnythinkClickMiniCardViewClickable(boolean z) {
        setClickable(z);
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i, int i2, int i3, int i4) {
        this.B = true;
        resizeMiniCard(i3, i4);
    }

    public void setRadius(int i) {
        if (i > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t.b(getContext(), i));
            gradientDrawable.setColor(-1);
            if (Build.VERSION.SDK_INT >= 16) {
                this.s.setBackground(gradientDrawable);
            } else {
                this.s.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.s.setClipToOutline(true);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        if (this.s != null) {
            this.s.post(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkClickMiniCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        o.a(AnythinkBaseView.TAG, "webviewshow");
                        int[] iArr = new int[2];
                        AnythinkClickMiniCardView.this.s.getLocationOnScreen(iArr);
                        o.d(AnythinkBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                        jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                        String encodeToString = Base64.encodeToString(jSONObject.toString().toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) AnythinkClickMiniCardView.this.s, "webviewshow", encodeToString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
