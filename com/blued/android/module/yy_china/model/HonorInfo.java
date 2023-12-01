package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HonorInfo.class */
public final class HonorInfo {
    private final String introduce;
    private final String score_double;

    public HonorInfo(String score_double, String introduce) {
        Intrinsics.e(score_double, "score_double");
        Intrinsics.e(introduce, "introduce");
        this.score_double = score_double;
        this.introduce = introduce;
    }

    public static /* synthetic */ HonorInfo copy$default(HonorInfo honorInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorInfo.score_double;
        }
        if ((i & 2) != 0) {
            str2 = honorInfo.introduce;
        }
        return honorInfo.copy(str, str2);
    }

    public final String component1() {
        return this.score_double;
    }

    public final String component2() {
        return this.introduce;
    }

    public final HonorInfo copy(String score_double, String introduce) {
        Intrinsics.e(score_double, "score_double");
        Intrinsics.e(introduce, "introduce");
        return new HonorInfo(score_double, introduce);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HonorInfo) {
            HonorInfo honorInfo = (HonorInfo) obj;
            return Intrinsics.a((Object) this.score_double, (Object) honorInfo.score_double) && Intrinsics.a((Object) this.introduce, (Object) honorInfo.introduce);
        }
        return false;
    }

    public final String getIntroduce() {
        return this.introduce;
    }

    public final String getScore_double() {
        return this.score_double;
    }

    public int hashCode() {
        return (this.score_double.hashCode() * 31) + this.introduce.hashCode();
    }

    public String toString() {
        return "HonorInfo(score_double=" + this.score_double + ", introduce=" + this.introduce + ')';
    }
}
