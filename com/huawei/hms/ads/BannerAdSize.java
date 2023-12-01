package com.huawei.hms.ads;

import android.content.Context;
import com.blued.das.live.LiveProtos;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/BannerAdSize.class */
public class BannerAdSize extends AdSize {
    public static final BannerAdSize BANNER_SIZE_360_57 = new BannerAdSize(360, 57);
    public static final BannerAdSize BANNER_SIZE_360_144 = new BannerAdSize(360, 144);
    public static final BannerAdSize BANNER_SIZE_320_50 = new BannerAdSize(320, 50);
    public static final BannerAdSize BANNER_SIZE_DYNAMIC = new BannerAdSize(-3, -4);
    public static final BannerAdSize BANNER_SIZE_468_60 = new BannerAdSize(LiveProtos.Event.LIVE_HOT_BANNER_SHOW_VALUE, 60);
    public static final BannerAdSize BANNER_SIZE_INVALID = new BannerAdSize(0, 0);
    public static final BannerAdSize BANNER_SIZE_320_100 = new BannerAdSize(320, 100);
    public static final BannerAdSize BANNER_SIZE_728_90 = new BannerAdSize(728, 90);
    public static final BannerAdSize BANNER_SIZE_300_250 = new BannerAdSize(300, 250);
    public static final BannerAdSize BANNER_SIZE_SMART = new BannerAdSize(-1, -2);
    public static final BannerAdSize BANNER_SIZE_160_600 = new BannerAdSize(160, 600);
    public static final BannerAdSize BANNER_SIZE_ADVANCED = new BannerAdSize(-1, -5, 1);

    public BannerAdSize(int i, int i2) {
        super(i, i2);
    }

    private BannerAdSize(int i, int i2, int i3) {
        super(i, i2);
        this.F = i3;
    }

    private static BannerAdSize Code(Context context, int i, int i2) {
        int Z = c.Z(context, i2);
        return Z == 0 ? BANNER_SIZE_INVALID : new BannerAdSize(i, c.Code(i, Z), 1);
    }

    private boolean Code() {
        return this.C == -1 && this.S == -2;
    }

    private boolean V() {
        return this.C == 0 && this.S == 0;
    }

    public static BannerAdSize getCurrentDirectionBannerSize(Context context, int i) {
        return Code(context, i, 0);
    }

    public static BannerAdSize getLandscapeBannerSize(Context context, int i) {
        return Code(context, i, 2);
    }

    public static BannerAdSize getPortraitBannerSize(Context context, int i) {
        return Code(context, i, 1);
    }

    @Override // com.huawei.hms.ads.AdSize
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hms.ads.AdSize
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // com.huawei.hms.ads.AdSize
    public final int getHeightPx(Context context) {
        return super.getHeightPx(context);
    }

    @Override // com.huawei.hms.ads.AdSize
    public final int getWidth() {
        return super.getWidth();
    }

    @Override // com.huawei.hms.ads.AdSize
    public final int getWidthPx(Context context) {
        return super.getWidthPx(context);
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean isAutoHeightSize() {
        return this.S == -2;
    }

    public final boolean isDynamicSize() {
        return this.C == -3 && this.S == -4;
    }

    public final boolean isFullWidthSize() {
        return this.C == -1;
    }

    public final String toString() {
        if (isDynamicSize()) {
            return "fluid";
        }
        if (Code()) {
            return "smart_banner";
        }
        if (V()) {
            return "invalid";
        }
        String valueOf = isFullWidthSize() ? "FULL_WIDTH" : String.valueOf(this.C);
        String valueOf2 = isAutoHeightSize() ? "AUTO_HEIGHT" : String.valueOf(this.S);
        return valueOf + "x" + valueOf2;
    }
}
