package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/Headers.class */
public interface Headers {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final Headers f20877a = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> a() {
            return Collections.emptyMap();
        }
    };
    public static final Headers b = new LazyHeaders.Builder().a();

    Map<String, String> a();
}
