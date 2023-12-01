package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Spanned;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/BulletSpan.class */
public class BulletSpan implements LeadingMarginSpan, ParcelableSpan {
    private static final int BULLET_RADIUS = 3;
    public static final int STANDARD_GAP_WIDTH = 2;
    private static Path sBulletPath = null;
    private final int mColor;
    private final int mGapWidth;
    private final boolean mWantColor;

    public BulletSpan() {
        this.mGapWidth = 2;
        this.mWantColor = false;
        this.mColor = 0;
    }

    public BulletSpan(int i) {
        this.mGapWidth = i;
        this.mWantColor = false;
        this.mColor = 0;
    }

    public BulletSpan(int i, int i2) {
        this.mGapWidth = i;
        this.mWantColor = true;
        this.mColor = i2;
    }

    public BulletSpan(Parcel parcel) {
        this.mGapWidth = parcel.readInt();
        this.mWantColor = parcel.readInt() != 0;
        this.mColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            int i8 = 0;
            if (this.mWantColor) {
                i8 = paint.getColor();
                paint.setColor(this.mColor);
            }
            paint.setStyle(Paint.Style.FILL);
            if (canvas.isHardwareAccelerated()) {
                if (sBulletPath == null) {
                    sBulletPath = new Path();
                    sBulletPath.addCircle(0.0f, 0.0f, 3.6000001f, Path.Direction.CW);
                }
                canvas.save();
                canvas.translate((i2 * 3) + i, (i3 + i5) / 2.0f);
                canvas.drawPath(sBulletPath, paint);
                canvas.restore();
            } else {
                canvas.drawCircle((i2 * 3) + i, (i3 + i5) / 2.0f, 3.0f, paint);
            }
            if (this.mWantColor) {
                paint.setColor(i8);
            }
            paint.setStyle(style);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.mGapWidth + 6;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 8;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mGapWidth);
        parcel.writeInt(this.mWantColor ? 1 : 0);
        parcel.writeInt(this.mColor);
    }
}
