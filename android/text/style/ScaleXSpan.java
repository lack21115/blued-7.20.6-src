package android.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/ScaleXSpan.class */
public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final float mProportion;

    public ScaleXSpan(float f) {
        this.mProportion = f;
    }

    public ScaleXSpan(Parcel parcel) {
        this.mProportion = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getScaleX() {
        return this.mProportion;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 4;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextScaleX(textPaint.getTextScaleX() * this.mProportion);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextScaleX(textPaint.getTextScaleX() * this.mProportion);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.mProportion);
    }
}
