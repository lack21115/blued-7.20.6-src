package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents97Model.class */
public final class IMJsonContents97Model {
    private final String link;
    private final String url;

    public IMJsonContents97Model(String link, String url) {
        Intrinsics.e(link, "link");
        Intrinsics.e(url, "url");
        this.link = link;
        this.url = url;
    }

    public static /* synthetic */ IMJsonContents97Model copy$default(IMJsonContents97Model iMJsonContents97Model, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMJsonContents97Model.link;
        }
        if ((i & 2) != 0) {
            str2 = iMJsonContents97Model.url;
        }
        return iMJsonContents97Model.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.url;
    }

    public final IMJsonContents97Model copy(String link, String url) {
        Intrinsics.e(link, "link");
        Intrinsics.e(url, "url");
        return new IMJsonContents97Model(link, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents97Model) {
            IMJsonContents97Model iMJsonContents97Model = (IMJsonContents97Model) obj;
            return Intrinsics.a((Object) this.link, (Object) iMJsonContents97Model.link) && Intrinsics.a((Object) this.url, (Object) iMJsonContents97Model.url);
        }
        return false;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.link.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "IMJsonContents97Model(link=" + this.link + ", url=" + this.url + ')';
    }
}
