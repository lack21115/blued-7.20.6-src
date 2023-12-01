package android.text.style;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/QuoteSpan.class */
public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
    private static final int GAP_WIDTH = 2;
    private static final int STRIPE_WIDTH = 2;
    private final int mColor;

    public QuoteSpan() {
        this.mColor = Color.BLUE;
    }

    public QuoteSpan(int i) {
        this.mColor = i;
    }

    public QuoteSpan(Parcel parcel) {
        this.mColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.mColor);
        canvas.drawRect(i, i3, (i2 * 2) + i, i5, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 4;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 9;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mColor);
    }
}
