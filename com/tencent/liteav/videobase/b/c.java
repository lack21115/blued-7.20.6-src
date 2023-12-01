package com.tencent.liteav.videobase.b;

import android.os.Looper;
import android.os.SystemClock;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final com.tencent.liteav.base.util.b f22900a;
    e d;
    final AtomicInteger b = new AtomicInteger(-1);

    /* renamed from: c  reason: collision with root package name */
    public Object f22901c = null;
    private final String e = String.format(Locale.ENGLISH, "// %s-%s E8083882-0D59-47A1-B4B6-25C15A69875A\nvoid main() {gl_FragColor = vec4(0, 0, 0, 0);}", Integer.valueOf(hashCode()), Long.valueOf(SystemClock.uptimeMillis()));

    public c(Looper looper) {
        this.f22900a = new com.tencent.liteav.base.util.b(looper);
    }
}
