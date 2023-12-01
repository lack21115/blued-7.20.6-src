package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/GifDrawableBytesTranscoder.class */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> a(Resource<GifDrawable> resource, Options options) {
        return new BytesResource(ByteBufferUtil.a(resource.f().c()));
    }
}
