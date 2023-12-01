package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ImageHeaderParserRegistry.class */
public final class ImageHeaderParserRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f21030a = new ArrayList();

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> list;
        synchronized (this) {
            list = this.f21030a;
        }
        return list;
    }

    public void a(ImageHeaderParser imageHeaderParser) {
        synchronized (this) {
            this.f21030a.add(imageHeaderParser);
        }
    }
}
