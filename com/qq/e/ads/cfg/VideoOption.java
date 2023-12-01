package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/cfg/VideoOption.class */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14176a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14177c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/cfg/VideoOption$AutoPlayPolicy.class */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/cfg/VideoOption$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f14178a = true;
        private int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14179c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private boolean g = false;
        private int h;
        private int i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f14178a = z;
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
            if (r4 > 2) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.qq.e.ads.cfg.VideoOption.Builder setAutoPlayPolicy(int r4) {
            /*
                r3 = this;
                r0 = r4
                if (r0 < 0) goto Lb
                r0 = r4
                r5 = r0
                r0 = r4
                r1 = 2
                if (r0 <= r1) goto L29
            Lb:
                r0 = 1
                r5 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r6 = r0
                r0 = r6
                java.lang.String r1 = "setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : "
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r6
                r1 = 1
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r6
                java.lang.String r0 = r0.toString()
                com.qq.e.comm.util.GDTLogger.e(r0)
            L29:
                r0 = r3
                r1 = r5
                r0.b = r1
                r0 = r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.cfg.VideoOption.Builder.setAutoPlayPolicy(int):com.qq.e.ads.cfg.VideoOption$Builder");
        }

        public Builder setDetailPageMuted(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.h = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.i = i;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f14179c = z;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f14176a = builder.f14178a;
        this.b = builder.b;
        this.f14177c = builder.f14179c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public boolean getAutoPlayMuted() {
        return this.f14176a;
    }

    public int getAutoPlayPolicy() {
        return this.b;
    }

    public int getMaxVideoDuration() {
        return this.h;
    }

    public int getMinVideoDuration() {
        return this.i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f14176a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.g));
            return jSONObject;
        } catch (Exception e) {
            GDTLogger.d("Get video options error: " + e.getMessage());
            return jSONObject;
        }
    }

    public boolean isDetailPageMuted() {
        return this.g;
    }

    public boolean isEnableDetailPage() {
        return this.e;
    }

    public boolean isEnableUserControl() {
        return this.f;
    }

    public boolean isNeedCoverImage() {
        return this.d;
    }

    public boolean isNeedProgressBar() {
        return this.f14177c;
    }
}
