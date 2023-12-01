package com.heytap.msp.mobad.api.params;

import android.text.TextUtils;
import android.view.View;
import com.igexin.push.core.b;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/SplashAdParams.class */
public class SplashAdParams {
    public final View bottomArea;
    public final List<View> clickViews;
    public final String desc;
    public final long fetchTimeout;
    public final boolean isUseSurfaceView;
    public final boolean showPreLoadPage;
    public final SplashSkipView splashSkipView;
    public final String title;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/SplashAdParams$Builder.class */
    public static class Builder {
        private static final boolean DEFAULT_SHOW_PRE_LOAD_PAGE = true;
        private static final long MAX_FETCH_TIMEOUT = 5000;
        private static final long MIX_FETCH_TIMEOUT = 3000;
        private List<View> clickViews;
        private String desc;
        private String title;
        private long fetchTimeout = 5000;
        private boolean showPreLoadPage = true;
        private View bottomArea = null;
        private boolean isUseSurfaceView = false;
        private SplashSkipView splashSkipView = null;

        public SplashAdParams build() {
            return new SplashAdParams(this);
        }

        public Builder setBottomArea(View view) {
            if (view != null) {
                this.bottomArea = view;
            }
            return this;
        }

        public Builder setClickViews(List<View> list) throws Exception {
            if (list == null || list.size() <= 0) {
                throw new Exception("clickViews is null or size <= 0, please check clickViews size");
            }
            this.clickViews = list;
            return this;
        }

        public Builder setDesc(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.desc = str;
            }
            return this;
        }

        public Builder setFetchTimeout(long j) {
            if (j >= 3000 && j <= 5000) {
                this.fetchTimeout = j;
            }
            return this;
        }

        public Builder setShowPreLoadPage(boolean z) {
            this.showPreLoadPage = z;
            return this;
        }

        public Builder setSplashSkipView(SplashSkipView splashSkipView) {
            if (splashSkipView != null) {
                this.splashSkipView = splashSkipView;
            }
            return this;
        }

        public Builder setSurfaceView(boolean z) {
            this.isUseSurfaceView = z;
            return this;
        }

        public Builder setTitle(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.title = str;
            }
            return this;
        }
    }

    public SplashAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
        this.title = builder.title;
        this.desc = builder.desc;
        this.showPreLoadPage = builder.showPreLoadPage;
        this.bottomArea = builder.bottomArea;
        this.isUseSurfaceView = builder.isUseSurfaceView;
        this.splashSkipView = builder.splashSkipView;
        this.clickViews = builder.clickViews;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashAdParams{fetchTimeout=");
        sb.append(this.fetchTimeout);
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", showPreLoadPage=");
        sb.append(this.showPreLoadPage);
        sb.append(", bottomArea=");
        View view = this.bottomArea;
        if (view == null) {
            view = b.l;
        }
        sb.append(view);
        sb.append(", isUseSurfaceView=");
        sb.append(this.isUseSurfaceView);
        sb.append(", splashSkipView=");
        sb.append(this.splashSkipView);
        sb.append(", clickViews=");
        sb.append(this.clickViews);
        sb.append('}');
        return sb.toString();
    }
}
