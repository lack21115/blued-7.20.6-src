package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bytes/BytesResource.class */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7378a;

    public BytesResource(byte[] bArr) {
        this.f7378a = (byte[]) Preconditions.a(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<byte[]> a() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f7378a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: d */
    public byte[] f() {
        return this.f7378a;
    }
}
