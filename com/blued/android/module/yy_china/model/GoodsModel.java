package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/GoodsModel.class */
public final class GoodsModel {

    /* renamed from: android  reason: collision with root package name */
    private final String f17613android;
    private final String ios;

    public GoodsModel(String android2, String ios) {
        Intrinsics.e(android2, "android");
        Intrinsics.e(ios, "ios");
        this.f17613android = android2;
        this.ios = ios;
    }

    public static /* synthetic */ GoodsModel copy$default(GoodsModel goodsModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsModel.f17613android;
        }
        if ((i & 2) != 0) {
            str2 = goodsModel.ios;
        }
        return goodsModel.copy(str, str2);
    }

    public final String component1() {
        return this.f17613android;
    }

    public final String component2() {
        return this.ios;
    }

    public final GoodsModel copy(String android2, String ios) {
        Intrinsics.e(android2, "android");
        Intrinsics.e(ios, "ios");
        return new GoodsModel(android2, ios);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsModel) {
            GoodsModel goodsModel = (GoodsModel) obj;
            return Intrinsics.a((Object) this.f17613android, (Object) goodsModel.f17613android) && Intrinsics.a((Object) this.ios, (Object) goodsModel.ios);
        }
        return false;
    }

    public final String getAndroid() {
        return this.f17613android;
    }

    public final String getIos() {
        return this.ios;
    }

    public int hashCode() {
        return (this.f17613android.hashCode() * 31) + this.ios.hashCode();
    }

    public String toString() {
        return "GoodsModel(android=" + this.f17613android + ", ios=" + this.ios + ')';
    }
}
