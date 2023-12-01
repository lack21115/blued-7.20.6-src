package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/UrlLinkFrame.class */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.UrlLinkFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame[] newArray(int i) {
            return new UrlLinkFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11849a;
    public final String b;

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.f11849a = parcel.readString();
        this.b = parcel.readString();
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f11849a = str2;
        this.b = str3;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
                z = false;
                if (this.f.equals(urlLinkFrame.f)) {
                    z = false;
                    if (u.a(this.f11849a, urlLinkFrame.f11849a)) {
                        if (!u.a(this.b, urlLinkFrame.b)) {
                            return false;
                        }
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        int hashCode = this.f.hashCode();
        String str = this.f11849a;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + ((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31) + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f11849a);
        parcel.writeString(this.b);
    }
}
