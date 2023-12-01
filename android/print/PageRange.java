package android.print;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/print/PageRange.class */
public final class PageRange implements Parcelable {
    public static final PageRange ALL_PAGES = new PageRange(0, Integer.MAX_VALUE);
    public static final Parcelable.Creator<PageRange> CREATOR = new Parcelable.Creator<PageRange>() { // from class: android.print.PageRange.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageRange createFromParcel(Parcel parcel) {
            return new PageRange(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageRange[] newArray(int i) {
            return new PageRange[i];
        }
    };
    private final int mEnd;
    private final int mStart;

    public PageRange(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start cannot be less than zero.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("end cannot be less than zero.");
        }
        if (i > i2) {
            throw new IllegalArgumentException("start must be lesser than end.");
        }
        this.mStart = i;
        this.mEnd = i2;
    }

    private PageRange(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt());
    }

    public boolean contains(int i) {
        return i >= this.mStart && i <= this.mEnd;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PageRange pageRange = (PageRange) obj;
            return this.mEnd == pageRange.mEnd && this.mStart == pageRange.mStart;
        }
        return false;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public int getSize() {
        return (this.mEnd - this.mStart) + 1;
    }

    public int getStart() {
        return this.mStart;
    }

    public int hashCode() {
        return ((this.mEnd + 31) * 31) + this.mStart;
    }

    public String toString() {
        if (this.mStart == 0 && this.mEnd == Integer.MAX_VALUE) {
            return "PageRange[<all pages>]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PageRange[").append(this.mStart).append(" - ").append(this.mEnd).append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStart);
        parcel.writeInt(this.mEnd);
    }
}
