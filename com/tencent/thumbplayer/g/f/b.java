package com.tencent.thumbplayer.g.f;

import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/f/b.class */
public final class b {
    public static final b e = new b(WBConstants.SDK_NEW_PAY_VERSION, WBConstants.SDK_NEW_PAY_VERSION);
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f25662c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25661a = true;
    public a d = a.First;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/f/b$a.class */
    public enum a {
        First,
        SAME
    }

    public b(int i, int i2) {
        this.b = i;
        this.f25662c = i2;
    }

    public final String toString() {
        return "[initWidth:" + this.b + ", initHeight:" + this.f25662c + ", reConfigByRealFormat:" + this.f25661a + ']';
    }
}
