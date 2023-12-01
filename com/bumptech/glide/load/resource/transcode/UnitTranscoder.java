package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/UnitTranscoder.class */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitTranscoder<?> f21010a = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> a() {
        return f21010a;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Z> a(Resource<Z> resource, Options options) {
        return resource;
    }
}
