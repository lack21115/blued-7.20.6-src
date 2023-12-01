package com.blued.android.module.yy_china.model;

import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYMountModel.class */
public final class YYMountModel {
    private LiveAnimationListener aniListener;
    private final String marqText;
    private final String mounts_icon;
    private final String mounts_img;
    private YYHostUpMode upHost;
    private int weights;

    public YYMountModel(String marqText, String mounts_img, String mounts_icon, int i, YYHostUpMode yYHostUpMode, LiveAnimationListener liveAnimationListener) {
        Intrinsics.e(marqText, "marqText");
        Intrinsics.e(mounts_img, "mounts_img");
        Intrinsics.e(mounts_icon, "mounts_icon");
        this.marqText = marqText;
        this.mounts_img = mounts_img;
        this.mounts_icon = mounts_icon;
        this.weights = i;
        this.upHost = yYHostUpMode;
        this.aniListener = liveAnimationListener;
    }

    public /* synthetic */ YYMountModel(String str, String str2, String str3, int i, YYHostUpMode yYHostUpMode, LiveAnimationListener liveAnimationListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : yYHostUpMode, (i2 & 32) != 0 ? null : liveAnimationListener);
    }

    public static /* synthetic */ YYMountModel copy$default(YYMountModel yYMountModel, String str, String str2, String str3, int i, YYHostUpMode yYHostUpMode, LiveAnimationListener liveAnimationListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYMountModel.marqText;
        }
        if ((i2 & 2) != 0) {
            str2 = yYMountModel.mounts_img;
        }
        if ((i2 & 4) != 0) {
            str3 = yYMountModel.mounts_icon;
        }
        if ((i2 & 8) != 0) {
            i = yYMountModel.weights;
        }
        if ((i2 & 16) != 0) {
            yYHostUpMode = yYMountModel.upHost;
        }
        if ((i2 & 32) != 0) {
            liveAnimationListener = yYMountModel.aniListener;
        }
        return yYMountModel.copy(str, str2, str3, i, yYHostUpMode, liveAnimationListener);
    }

    public final String component1() {
        return this.marqText;
    }

    public final String component2() {
        return this.mounts_img;
    }

    public final String component3() {
        return this.mounts_icon;
    }

    public final int component4() {
        return this.weights;
    }

    public final YYHostUpMode component5() {
        return this.upHost;
    }

    public final LiveAnimationListener component6() {
        return this.aniListener;
    }

    public final YYMountModel copy(String marqText, String mounts_img, String mounts_icon, int i, YYHostUpMode yYHostUpMode, LiveAnimationListener liveAnimationListener) {
        Intrinsics.e(marqText, "marqText");
        Intrinsics.e(mounts_img, "mounts_img");
        Intrinsics.e(mounts_icon, "mounts_icon");
        return new YYMountModel(marqText, mounts_img, mounts_icon, i, yYHostUpMode, liveAnimationListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYMountModel) {
            YYMountModel yYMountModel = (YYMountModel) obj;
            return Intrinsics.a((Object) this.marqText, (Object) yYMountModel.marqText) && Intrinsics.a((Object) this.mounts_img, (Object) yYMountModel.mounts_img) && Intrinsics.a((Object) this.mounts_icon, (Object) yYMountModel.mounts_icon) && this.weights == yYMountModel.weights && Intrinsics.a(this.upHost, yYMountModel.upHost) && Intrinsics.a(this.aniListener, yYMountModel.aniListener);
        }
        return false;
    }

    public final LiveAnimationListener getAniListener() {
        return this.aniListener;
    }

    public final String getMarqText() {
        return this.marqText;
    }

    public final String getMounts_icon() {
        return this.mounts_icon;
    }

    public final String getMounts_img() {
        return this.mounts_img;
    }

    public final YYHostUpMode getUpHost() {
        return this.upHost;
    }

    public final int getWeights() {
        return this.weights;
    }

    public int hashCode() {
        int hashCode = this.marqText.hashCode();
        int hashCode2 = this.mounts_img.hashCode();
        int hashCode3 = this.mounts_icon.hashCode();
        int i = this.weights;
        YYHostUpMode yYHostUpMode = this.upHost;
        int i2 = 0;
        int hashCode4 = yYHostUpMode == null ? 0 : yYHostUpMode.hashCode();
        LiveAnimationListener liveAnimationListener = this.aniListener;
        if (liveAnimationListener != null) {
            i2 = liveAnimationListener.hashCode();
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + i2;
    }

    public final void setAniListener(LiveAnimationListener liveAnimationListener) {
        this.aniListener = liveAnimationListener;
    }

    public final void setUpHost(YYHostUpMode yYHostUpMode) {
        this.upHost = yYHostUpMode;
    }

    public final void setWeights(int i) {
        this.weights = i;
    }

    public String toString() {
        return "YYMountModel(marqText=" + this.marqText + ", mounts_img=" + this.mounts_img + ", mounts_icon=" + this.mounts_icon + ", weights=" + this.weights + ", upHost=" + this.upHost + ", aniListener=" + this.aniListener + ')';
    }
}
