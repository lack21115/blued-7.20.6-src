package android.text.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import com.android.internal.R;
import com.anythink.expressad.exoplayer.b;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/TextAppearanceSpan.class */
public class TextAppearanceSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final int mStyle;
    private final ColorStateList mTextColor;
    private final ColorStateList mTextColorLink;
    private final int mTextSize;
    private final String mTypeface;

    public TextAppearanceSpan(Context context, int i) {
        this(context, i, -1);
    }

    public TextAppearanceSpan(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        this.mTextColorLink = obtainStyledAttributes.getColorStateList(6);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.mStyle = obtainStyledAttributes.getInt(2, 0);
        String string = obtainStyledAttributes.getString(12);
        if (string == null) {
            switch (obtainStyledAttributes.getInt(1, 0)) {
                case 1:
                    this.mTypeface = "sans";
                    break;
                case 2:
                    this.mTypeface = b.l;
                    break;
                case 3:
                    this.mTypeface = "monospace";
                    break;
                default:
                    this.mTypeface = null;
                    break;
            }
        } else {
            this.mTypeface = string;
        }
        obtainStyledAttributes.recycle();
        if (i2 >= 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(16973829, R.styleable.Theme);
            colorStateList = obtainStyledAttributes2.getColorStateList(i2);
            obtainStyledAttributes2.recycle();
        }
        this.mTextColor = colorStateList;
    }

    public TextAppearanceSpan(Parcel parcel) {
        this.mTypeface = parcel.readString();
        this.mStyle = parcel.readInt();
        this.mTextSize = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.mTextColor = ColorStateList.CREATOR.createFromParcel(parcel);
        } else {
            this.mTextColor = null;
        }
        if (parcel.readInt() != 0) {
            this.mTextColorLink = ColorStateList.CREATOR.createFromParcel(parcel);
        } else {
            this.mTextColorLink = null;
        }
    }

    public TextAppearanceSpan(String str, int i, int i2, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.mTypeface = str;
        this.mStyle = i;
        this.mTextSize = i2;
        this.mTextColor = colorStateList;
        this.mTextColorLink = colorStateList2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFamily() {
        return this.mTypeface;
    }

    public ColorStateList getLinkTextColor() {
        return this.mTextColorLink;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 17;
    }

    public ColorStateList getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public int getTextStyle() {
        return this.mStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        updateMeasureState(textPaint);
        if (this.mTextColor != null) {
            textPaint.setColor(this.mTextColor.getColorForState(textPaint.drawableState, 0));
        }
        if (this.mTextColorLink != null) {
            textPaint.linkColor = this.mTextColorLink.getColorForState(textPaint.drawableState, 0);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        if (this.mTypeface != null || this.mStyle != 0) {
            Typeface typeface = textPaint.getTypeface();
            int i = 0;
            if (typeface != null) {
                i = typeface.getStyle();
            }
            int i2 = i | this.mStyle;
            Typeface create = this.mTypeface != null ? Typeface.create(this.mTypeface, i2) : typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            int style = i2 & (create.getStyle() ^ (-1));
            if ((style & 1) != 0) {
                textPaint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                textPaint.setTextSkewX(-0.25f);
            }
            textPaint.setTypeface(create);
        }
        if (this.mTextSize > 0) {
            textPaint.setTextSize(this.mTextSize);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTypeface);
        parcel.writeInt(this.mStyle);
        parcel.writeInt(this.mTextSize);
        if (this.mTextColor != null) {
            parcel.writeInt(1);
            this.mTextColor.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.mTextColorLink == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.mTextColorLink.writeToParcel(parcel, i);
    }
}
