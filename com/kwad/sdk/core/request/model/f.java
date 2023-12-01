package com.kwad.sdk.core.request.model;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/request/model/f.class */
public class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int adStyle;
    public long alK;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.alK = j;
    }

    public final void T(long j) {
        this.alK = j;
    }
}
