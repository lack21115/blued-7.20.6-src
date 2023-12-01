package com.youzan.spiderman.c.b;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/b/g.class */
public final class g {
    @SerializedName("enable_upload")

    /* renamed from: a  reason: collision with root package name */
    private boolean f41753a;
    @SerializedName("url_pattern")
    private List<String> b;

    public final void a(List<String> list) {
        this.b = list;
    }

    public final void a(boolean z) {
        this.f41753a = false;
    }

    public final boolean a() {
        return this.f41753a;
    }

    public final List<String> b() {
        return this.b;
    }
}
