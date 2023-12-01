package android.media;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* loaded from: source-9557208-dex2jar.jar:android/media/MutableBackgroundColorSpan.class */
class MutableBackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private int mColor;

    public MutableBackgroundColorSpan(int i) {
        this.mColor = i;
    }

    public MutableBackgroundColorSpan(Parcel parcel) {
        this.mColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBackgroundColor() {
        return this.mColor;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 12;
    }

    public void setBackgroundColor(int i) {
        this.mColor = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.bgColor = this.mColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mColor);
    }
}
