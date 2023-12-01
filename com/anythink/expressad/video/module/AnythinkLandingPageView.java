package com.anythink.expressad.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.video.signal.factory.b;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkLandingPageView.class */
public class AnythinkLandingPageView extends AnythinkH5EndCardView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkLandingPageView$a.class */
    public static final class a implements com.anythink.expressad.atsignalcommon.base.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.anythink.expressad.atsignalcommon.base.a
        public final boolean a(String str) {
            if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            }
            s.a(n.a().g(), str, null);
            return true;
        }
    }

    public AnythinkLandingPageView(Context context) {
        super(context);
    }

    public AnythinkLandingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final String a() {
        if (this.b != null) {
            return this.b.ad();
        }
        return null;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        super.init(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        if (this.f) {
            this.s.setFilter(new a((byte) 0));
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        try {
            o.a(AnythinkBaseView.TAG, "webviewshow");
            j.a();
            j.a((WebView) this.s, "webviewshow", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
