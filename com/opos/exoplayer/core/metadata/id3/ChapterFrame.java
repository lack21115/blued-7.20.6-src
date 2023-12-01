package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.g.b.c;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/ChapterFrame.class */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.ChapterFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11839a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11840c;
    public final long d;
    public final long e;
    private final Id3Frame[] g;

    ChapterFrame(Parcel parcel) {
        super(c.f4507a);
        this.f11839a = parcel.readString();
        this.b = parcel.readInt();
        this.f11840c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        int readInt = parcel.readInt();
        this.g = new Id3Frame[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super(c.f4507a);
        this.f11839a = str;
        this.b = i;
        this.f11840c = i2;
        this.d = j;
        this.e = j2;
        this.g = id3FrameArr;
    }

    @Override // com.opos.exoplayer.core.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                ChapterFrame chapterFrame = (ChapterFrame) obj;
                z = false;
                if (this.b == chapterFrame.b) {
                    z = false;
                    if (this.f11840c == chapterFrame.f11840c) {
                        z = false;
                        if (this.d == chapterFrame.d) {
                            z = false;
                            if (this.e == chapterFrame.e) {
                                z = false;
                                if (u.a(this.f11839a, chapterFrame.f11839a)) {
                                    if (!Arrays.equals(this.g, chapterFrame.g)) {
                                        return false;
                                    }
                                }
                            }
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
        int i = this.b;
        int i2 = this.f11840c;
        int i3 = (int) this.d;
        int i4 = (int) this.e;
        String str = this.f11839a;
        return (str != null ? str.hashCode() : 0) + ((((((((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i2) * 31) + i3) * 31) + i4) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11839a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f11840c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.g.length);
        Id3Frame[] id3FrameArr = this.g;
        int length = id3FrameArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeParcelable(id3FrameArr[i3], 0);
            i2 = i3 + 1;
        }
    }
}
