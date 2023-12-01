package android.text.style;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.R;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/SuggestionSpan.class */
public class SuggestionSpan extends CharacterStyle implements ParcelableSpan {
    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    public static final Parcelable.Creator<SuggestionSpan> CREATOR = new Parcelable.Creator<SuggestionSpan>() { // from class: android.text.style.SuggestionSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestionSpan createFromParcel(Parcel parcel) {
            return new SuggestionSpan(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestionSpan[] newArray(int i) {
            return new SuggestionSpan[i];
        }
    };
    public static final int FLAG_AUTO_CORRECTION = 4;
    public static final int FLAG_EASY_CORRECT = 1;
    public static final int FLAG_MISSPELLED = 2;
    public static final int SUGGESTIONS_MAX_SIZE = 5;
    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    private static final String TAG = "SuggestionSpan";
    private int mAutoCorrectionUnderlineColor;
    private float mAutoCorrectionUnderlineThickness;
    private int mEasyCorrectUnderlineColor;
    private float mEasyCorrectUnderlineThickness;
    private int mFlags;
    private final int mHashCode;
    private final String mLocaleString;
    private int mMisspelledUnderlineColor;
    private float mMisspelledUnderlineThickness;
    private final String mNotificationTargetClassName;
    private final String mNotificationTargetPackageName;
    private final String[] mSuggestions;

    public SuggestionSpan(Context context, Locale locale, String[] strArr, int i, Class<?> cls) {
        this.mSuggestions = (String[]) Arrays.copyOf(strArr, Math.min(5, strArr.length));
        this.mFlags = i;
        if (locale != null) {
            this.mLocaleString = locale.toString();
        } else if (context != null) {
            this.mLocaleString = context.getResources().getConfiguration().locale.toString();
        } else {
            Log.e(TAG, "No locale or context specified in SuggestionSpan constructor");
            this.mLocaleString = "";
        }
        if (context != null) {
            this.mNotificationTargetPackageName = context.getPackageName();
        } else {
            this.mNotificationTargetPackageName = null;
        }
        if (cls != null) {
            this.mNotificationTargetClassName = cls.getCanonicalName();
        } else {
            this.mNotificationTargetClassName = "";
        }
        this.mHashCode = hashCodeInternal(this.mSuggestions, this.mLocaleString, this.mNotificationTargetClassName);
        initStyle(context);
    }

    public SuggestionSpan(Context context, String[] strArr, int i) {
        this(context, null, strArr, i, null);
    }

    public SuggestionSpan(Parcel parcel) {
        this.mSuggestions = parcel.readStringArray();
        this.mFlags = parcel.readInt();
        this.mLocaleString = parcel.readString();
        this.mNotificationTargetClassName = parcel.readString();
        this.mNotificationTargetPackageName = parcel.readString();
        this.mHashCode = parcel.readInt();
        this.mEasyCorrectUnderlineColor = parcel.readInt();
        this.mEasyCorrectUnderlineThickness = parcel.readFloat();
        this.mMisspelledUnderlineColor = parcel.readInt();
        this.mMisspelledUnderlineThickness = parcel.readFloat();
        this.mAutoCorrectionUnderlineColor = parcel.readInt();
        this.mAutoCorrectionUnderlineThickness = parcel.readFloat();
    }

    public SuggestionSpan(Locale locale, String[] strArr, int i) {
        this(null, locale, strArr, i, null);
    }

    private static int hashCodeInternal(String[] strArr, String str, String str2) {
        return Arrays.hashCode(new Object[]{Long.valueOf(SystemClock.uptimeMillis()), strArr, str, str2});
    }

    private void initStyle(Context context) {
        if (context == null) {
            this.mMisspelledUnderlineThickness = 0.0f;
            this.mEasyCorrectUnderlineThickness = 0.0f;
            this.mAutoCorrectionUnderlineThickness = 0.0f;
            this.mMisspelledUnderlineColor = -16777216;
            this.mEasyCorrectUnderlineColor = -16777216;
            this.mAutoCorrectionUnderlineColor = -16777216;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.SuggestionSpan, R.attr.textAppearanceMisspelledSuggestion, 0);
        this.mMisspelledUnderlineThickness = obtainStyledAttributes.getDimension(1, 0.0f);
        this.mMisspelledUnderlineColor = obtainStyledAttributes.getColor(0, -16777216);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(null, R.styleable.SuggestionSpan, R.attr.textAppearanceEasyCorrectSuggestion, 0);
        this.mEasyCorrectUnderlineThickness = obtainStyledAttributes2.getDimension(1, 0.0f);
        this.mEasyCorrectUnderlineColor = obtainStyledAttributes2.getColor(0, -16777216);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(null, R.styleable.SuggestionSpan, R.attr.textAppearanceAutoCorrectionSuggestion, 0);
        this.mAutoCorrectionUnderlineThickness = obtainStyledAttributes3.getDimension(1, 0.0f);
        this.mAutoCorrectionUnderlineColor = obtainStyledAttributes3.getColor(0, -16777216);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof SuggestionSpan) {
            z = false;
            if (((SuggestionSpan) obj).hashCode() == this.mHashCode) {
                z = true;
            }
        }
        return z;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public String getLocale() {
        return this.mLocaleString;
    }

    public String getNotificationTargetClassName() {
        return this.mNotificationTargetClassName;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 19;
    }

    public String[] getSuggestions() {
        return this.mSuggestions;
    }

    public int getUnderlineColor() {
        int i;
        boolean z = (this.mFlags & 2) != 0;
        boolean z2 = (this.mFlags & 1) != 0;
        boolean z3 = (this.mFlags & 4) != 0;
        if (!z2) {
            i = 0;
            if (z3) {
                return this.mAutoCorrectionUnderlineColor;
            }
        } else if (z) {
            return this.mMisspelledUnderlineColor;
        } else {
            i = this.mEasyCorrectUnderlineColor;
        }
        return i;
    }

    public int hashCode() {
        return this.mHashCode;
    }

    public void notifySelection(Context context, String str, int i) {
        Intent intent = new Intent();
        if (context == null || this.mNotificationTargetClassName == null) {
            return;
        }
        if (this.mSuggestions == null || i < 0 || i >= this.mSuggestions.length) {
            Log.w(TAG, "Unable to notify the suggestion as the index is out of range index=" + i + " length=" + this.mSuggestions.length);
        } else if (this.mNotificationTargetPackageName == null) {
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            if (peekInstance != null) {
                peekInstance.notifySuggestionPicked(this, str, i);
            }
        } else {
            intent.setClassName(this.mNotificationTargetPackageName, this.mNotificationTargetClassName);
            intent.setAction(ACTION_SUGGESTION_PICKED);
            intent.putExtra(SUGGESTION_SPAN_PICKED_BEFORE, str);
            intent.putExtra(SUGGESTION_SPAN_PICKED_AFTER, this.mSuggestions[i]);
            intent.putExtra(SUGGESTION_SPAN_PICKED_HASHCODE, hashCode());
            context.sendBroadcast(intent);
        }
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        boolean z = (this.mFlags & 2) != 0;
        boolean z2 = (this.mFlags & 1) != 0;
        boolean z3 = (this.mFlags & 4) != 0;
        if (!z2) {
            if (z3) {
                textPaint.setUnderlineText(this.mAutoCorrectionUnderlineColor, this.mAutoCorrectionUnderlineThickness);
            }
        } else if (!z) {
            textPaint.setUnderlineText(this.mEasyCorrectUnderlineColor, this.mEasyCorrectUnderlineThickness);
        } else if (textPaint.underlineColor == 0) {
            textPaint.setUnderlineText(this.mMisspelledUnderlineColor, this.mMisspelledUnderlineThickness);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.mSuggestions);
        parcel.writeInt(this.mFlags);
        parcel.writeString(this.mLocaleString);
        parcel.writeString(this.mNotificationTargetClassName);
        parcel.writeString(this.mNotificationTargetPackageName);
        parcel.writeInt(this.mHashCode);
        parcel.writeInt(this.mEasyCorrectUnderlineColor);
        parcel.writeFloat(this.mEasyCorrectUnderlineThickness);
        parcel.writeInt(this.mMisspelledUnderlineColor);
        parcel.writeFloat(this.mMisspelledUnderlineThickness);
        parcel.writeInt(this.mAutoCorrectionUnderlineColor);
        parcel.writeFloat(this.mAutoCorrectionUnderlineThickness);
    }
}
