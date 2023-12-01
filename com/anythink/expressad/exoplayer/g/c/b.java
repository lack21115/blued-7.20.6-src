package com.anythink.expressad.exoplayer.g.c;

import com.anythink.expressad.exoplayer.g.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/b.class */
public abstract class b implements a.InterfaceC0129a {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
