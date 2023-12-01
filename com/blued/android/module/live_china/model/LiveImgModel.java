package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveImgModel.class */
public final class LiveImgModel implements Serializable {
    private final String img;

    public LiveImgModel(String img) {
        Intrinsics.e(img, "img");
        this.img = img;
    }

    public static /* synthetic */ LiveImgModel copy$default(LiveImgModel liveImgModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveImgModel.img;
        }
        return liveImgModel.copy(str);
    }

    public final String component1() {
        return this.img;
    }

    public final LiveImgModel copy(String img) {
        Intrinsics.e(img, "img");
        return new LiveImgModel(img);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveImgModel) && Intrinsics.a((Object) this.img, (Object) ((LiveImgModel) obj).img);
    }

    public final String getImg() {
        return this.img;
    }

    public int hashCode() {
        return this.img.hashCode();
    }

    public String toString() {
        return "LiveImgModel(img=" + this.img + ')';
    }
}
