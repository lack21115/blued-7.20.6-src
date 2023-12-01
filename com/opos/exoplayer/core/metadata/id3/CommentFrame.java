package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.g.b.e;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/CommentFrame.class */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.CommentFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11843a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11844c;

    CommentFrame(Parcel parcel) {
        super(e.f4511a);
        this.f11843a = parcel.readString();
        this.b = parcel.readString();
        this.f11844c = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super(e.f4511a);
        this.f11843a = str;
        this.b = str2;
        this.f11844c = str3;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                CommentFrame commentFrame = (CommentFrame) obj;
                z = false;
                if (u.a(this.b, commentFrame.b)) {
                    z = false;
                    if (u.a(this.f11843a, commentFrame.f11843a)) {
                        if (!u.a(this.f11844c, commentFrame.f11844c)) {
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
        String str = this.f11843a;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f11844c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + ((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31) + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f11843a);
        parcel.writeString(this.f11844c);
    }
}
