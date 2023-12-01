package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/ResourceTranscoder.class */
public interface ResourceTranscoder<Z, R> {
    Resource<R> a(Resource<Z> resource, Options options);
}
