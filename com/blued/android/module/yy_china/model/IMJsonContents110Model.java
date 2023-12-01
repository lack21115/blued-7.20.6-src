package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents110Model.class */
public final class IMJsonContents110Model {
    private final String type;
    private final String url;

    public IMJsonContents110Model(String type, String url) {
        Intrinsics.e(type, "type");
        Intrinsics.e(url, "url");
        this.type = type;
        this.url = url;
    }

    public static /* synthetic */ IMJsonContents110Model copy$default(IMJsonContents110Model iMJsonContents110Model, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMJsonContents110Model.type;
        }
        if ((i & 2) != 0) {
            str2 = iMJsonContents110Model.url;
        }
        return iMJsonContents110Model.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final IMJsonContents110Model copy(String type, String url) {
        Intrinsics.e(type, "type");
        Intrinsics.e(url, "url");
        return new IMJsonContents110Model(type, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents110Model) {
            IMJsonContents110Model iMJsonContents110Model = (IMJsonContents110Model) obj;
            return Intrinsics.a((Object) this.type, (Object) iMJsonContents110Model.type) && Intrinsics.a((Object) this.url, (Object) iMJsonContents110Model.url);
        }
        return false;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "IMJsonContents110Model(type=" + this.type + ", url=" + this.url + ')';
    }
}
