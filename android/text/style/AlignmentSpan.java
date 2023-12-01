package android.text.style;

import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/AlignmentSpan.class */
public interface AlignmentSpan extends ParagraphStyle {

    /* loaded from: source-9557208-dex2jar.jar:android/text/style/AlignmentSpan$Standard.class */
    public static class Standard implements AlignmentSpan, ParcelableSpan {
        private final Layout.Alignment mAlignment;

        public Standard(Parcel parcel) {
            this.mAlignment = Layout.Alignment.valueOf(parcel.readString());
        }

        public Standard(Layout.Alignment alignment) {
            this.mAlignment = alignment;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.text.style.AlignmentSpan
        public Layout.Alignment getAlignment() {
            return this.mAlignment;
        }

        @Override // android.text.ParcelableSpan
        public int getSpanTypeId() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAlignment.name());
        }
    }

    Layout.Alignment getAlignment();
}
