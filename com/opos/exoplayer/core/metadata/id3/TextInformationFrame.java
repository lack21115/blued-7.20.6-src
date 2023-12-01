package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/TextInformationFrame.class */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.TextInformationFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f25536a;
    public final String b;

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.f25536a = parcel.readString();
        this.b = parcel.readString();
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f25536a = str2;
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
                TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
                z = false;
                if (this.f.equals(textInformationFrame.f)) {
                    z = false;
                    if (u.a(this.f25536a, textInformationFrame.f25536a)) {
                        if (!u.a(this.b, textInformationFrame.b)) {
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
        String str = this.f25536a;
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
        parcel.writeString(this.f25536a);
        parcel.writeString(this.b);
    }
}
