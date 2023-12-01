package com.youzan.spiderman.c.b;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.Constants;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/b/d.class */
public final class d {
    @SerializedName("enable_html_cache")

    /* renamed from: a  reason: collision with root package name */
    private boolean f28057a = true;
    @SerializedName("sync_html_interval")
    private long b = Constants.MILLS_OF_WATCH_DOG;
    @SerializedName("html_download_condition")

    /* renamed from: c  reason: collision with root package name */
    private String f28058c = "wifi";
    @SerializedName("local_html_load_valid")
    private long d = 43200000;
    @SerializedName("cache_html_url")
    private List<String> e;

    public final void a(long j) {
        this.b = Constants.MILLS_OF_WATCH_DOG;
    }

    public final void a(String str) {
        this.f28058c = str;
    }

    public final void a(List<String> list) {
        this.e = list;
    }

    public final void a(boolean z) {
        this.f28057a = true;
    }

    public final boolean a() {
        return this.f28057a;
    }

    public final long b() {
        return this.b;
    }

    public final void b(long j) {
        this.d = 43200000L;
    }

    public final String c() {
        return this.f28058c;
    }

    public final long d() {
        return this.d;
    }

    public final List<String> e() {
        return this.e;
    }
}
