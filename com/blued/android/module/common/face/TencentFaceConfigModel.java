package com.blued.android.module.common.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/face/TencentFaceConfigModel.class */
public final class TencentFaceConfigModel {
    private final String api_version;
    private final String app_id;
    private final String face_id;
    private final String license;
    private final String nonce;
    private final String nonce_sign;
    private final String order_no;

    public TencentFaceConfigModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public TencentFaceConfigModel(String app_id, String face_id, String order_no, String nonce, String nonce_sign, String api_version, String license) {
        Intrinsics.e(app_id, "app_id");
        Intrinsics.e(face_id, "face_id");
        Intrinsics.e(order_no, "order_no");
        Intrinsics.e(nonce, "nonce");
        Intrinsics.e(nonce_sign, "nonce_sign");
        Intrinsics.e(api_version, "api_version");
        Intrinsics.e(license, "license");
        this.app_id = app_id;
        this.face_id = face_id;
        this.order_no = order_no;
        this.nonce = nonce;
        this.nonce_sign = nonce_sign;
        this.api_version = api_version;
        this.license = license;
    }

    public /* synthetic */ TencentFaceConfigModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    public static /* synthetic */ TencentFaceConfigModel copy$default(TencentFaceConfigModel tencentFaceConfigModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tencentFaceConfigModel.app_id;
        }
        if ((i & 2) != 0) {
            str2 = tencentFaceConfigModel.face_id;
        }
        if ((i & 4) != 0) {
            str3 = tencentFaceConfigModel.order_no;
        }
        if ((i & 8) != 0) {
            str4 = tencentFaceConfigModel.nonce;
        }
        if ((i & 16) != 0) {
            str5 = tencentFaceConfigModel.nonce_sign;
        }
        if ((i & 32) != 0) {
            str6 = tencentFaceConfigModel.api_version;
        }
        if ((i & 64) != 0) {
            str7 = tencentFaceConfigModel.license;
        }
        return tencentFaceConfigModel.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.app_id;
    }

    public final String component2() {
        return this.face_id;
    }

    public final String component3() {
        return this.order_no;
    }

    public final String component4() {
        return this.nonce;
    }

    public final String component5() {
        return this.nonce_sign;
    }

    public final String component6() {
        return this.api_version;
    }

    public final String component7() {
        return this.license;
    }

    public final TencentFaceConfigModel copy(String app_id, String face_id, String order_no, String nonce, String nonce_sign, String api_version, String license) {
        Intrinsics.e(app_id, "app_id");
        Intrinsics.e(face_id, "face_id");
        Intrinsics.e(order_no, "order_no");
        Intrinsics.e(nonce, "nonce");
        Intrinsics.e(nonce_sign, "nonce_sign");
        Intrinsics.e(api_version, "api_version");
        Intrinsics.e(license, "license");
        return new TencentFaceConfigModel(app_id, face_id, order_no, nonce, nonce_sign, api_version, license);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TencentFaceConfigModel) {
            TencentFaceConfigModel tencentFaceConfigModel = (TencentFaceConfigModel) obj;
            return Intrinsics.a((Object) this.app_id, (Object) tencentFaceConfigModel.app_id) && Intrinsics.a((Object) this.face_id, (Object) tencentFaceConfigModel.face_id) && Intrinsics.a((Object) this.order_no, (Object) tencentFaceConfigModel.order_no) && Intrinsics.a((Object) this.nonce, (Object) tencentFaceConfigModel.nonce) && Intrinsics.a((Object) this.nonce_sign, (Object) tencentFaceConfigModel.nonce_sign) && Intrinsics.a((Object) this.api_version, (Object) tencentFaceConfigModel.api_version) && Intrinsics.a((Object) this.license, (Object) tencentFaceConfigModel.license);
        }
        return false;
    }

    public final String getApi_version() {
        return this.api_version;
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final String getFace_id() {
        return this.face_id;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getNonce_sign() {
        return this.nonce_sign;
    }

    public final String getOrder_no() {
        return this.order_no;
    }

    public int hashCode() {
        return (((((((((((this.app_id.hashCode() * 31) + this.face_id.hashCode()) * 31) + this.order_no.hashCode()) * 31) + this.nonce.hashCode()) * 31) + this.nonce_sign.hashCode()) * 31) + this.api_version.hashCode()) * 31) + this.license.hashCode();
    }

    public String toString() {
        return "TencentFaceConfigModel(app_id=" + this.app_id + ", face_id=" + this.face_id + ", order_no=" + this.order_no + ", nonce=" + this.nonce + ", nonce_sign=" + this.nonce_sign + ", api_version=" + this.api_version + ", license=" + this.license + ')';
    }
}
