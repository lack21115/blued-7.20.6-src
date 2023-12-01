package com.youzan.spiderman.c.b;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/b/e.class */
public final class e {
    @SerializedName("ignore_resource")

    /* renamed from: a  reason: collision with root package name */
    private List<String> f41750a;
    @SerializedName("enable_cache")
    private boolean b = true;
    @SerializedName("ignore_extension")

    /* renamed from: c  reason: collision with root package name */
    private List<String> f41751c;

    public final List<String> a() {
        return this.f41750a;
    }

    public final void a(List<String> list) {
        this.f41750a = null;
    }

    public final void a(boolean z) {
        this.b = true;
    }

    public final void b(List<String> list) {
        this.f41751c = null;
    }

    public final boolean b() {
        return this.b;
    }

    public final List<String> c() {
        return this.f41751c;
    }
}
