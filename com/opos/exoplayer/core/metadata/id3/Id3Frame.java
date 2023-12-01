package com.opos.exoplayer.core.metadata.id3;

import com.opos.exoplayer.core.metadata.Metadata;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/Id3Frame.class */
public abstract class Id3Frame implements Metadata.Entry {
    public final String f;

    public Id3Frame(String str) {
        this.f = (String) com.opos.exoplayer.core.i.a.a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
