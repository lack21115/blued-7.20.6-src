package com.blued.android.module.live_china.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveFinishPageData.class */
public final class LiveFinishPageData {
    private boolean hasMore;
    private int page;

    public LiveFinishPageData(int i, boolean z) {
        this.page = i;
        this.hasMore = z;
    }

    public static /* synthetic */ LiveFinishPageData copy$default(LiveFinishPageData liveFinishPageData, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = liveFinishPageData.page;
        }
        if ((i2 & 2) != 0) {
            z = liveFinishPageData.hasMore;
        }
        return liveFinishPageData.copy(i, z);
    }

    public final int component1() {
        return this.page;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final LiveFinishPageData copy(int i, boolean z) {
        return new LiveFinishPageData(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveFinishPageData) {
            LiveFinishPageData liveFinishPageData = (LiveFinishPageData) obj;
            return this.page == liveFinishPageData.page && this.hasMore == liveFinishPageData.hasMore;
        }
        return false;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getPage() {
        return this.page;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public String toString() {
        return "LiveFinishPageData(page=" + this.page + ", hasMore=" + this.hasMore + ')';
    }
}
