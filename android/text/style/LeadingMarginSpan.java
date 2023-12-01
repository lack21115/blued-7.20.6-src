package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/LeadingMarginSpan.class */
public interface LeadingMarginSpan extends ParagraphStyle {

    /* loaded from: source-9557208-dex2jar.jar:android/text/style/LeadingMarginSpan$LeadingMarginSpan2.class */
    public interface LeadingMarginSpan2 extends LeadingMarginSpan, WrapTogetherSpan {
        int getLeadingMarginLineCount();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/style/LeadingMarginSpan$Standard.class */
    public static class Standard implements LeadingMarginSpan, ParcelableSpan {
        private final int mFirst;
        private final int mRest;

        public Standard(int i) {
            this(i, i);
        }

        public Standard(int i, int i2) {
            this.mFirst = i;
            this.mRest = i2;
        }

        public Standard(Parcel parcel) {
            this.mFirst = parcel.readInt();
            this.mRest = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return z ? this.mFirst : this.mRest;
        }

        @Override // android.text.ParcelableSpan
        public int getSpanTypeId() {
            return 10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFirst);
            parcel.writeInt(this.mRest);
        }
    }

    void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout);

    int getLeadingMargin(boolean z);
}
