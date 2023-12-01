package com.anythink.expressad.exoplayer.d;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/o.class */
public final class o extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7266a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f7267c;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/o$a.class */
    public @interface a {
    }

    private o(int i) {
        this.f7267c = i;
    }

    public o(Exception exc) {
        super(exc);
        this.f7267c = 2;
    }
}
