package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.util.i;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/CompletionInfo.class */
public final class CompletionInfo implements Parcelable {
    public static final Parcelable.Creator<CompletionInfo> CREATOR = new Parcelable.Creator<CompletionInfo>() { // from class: android.view.inputmethod.CompletionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompletionInfo createFromParcel(Parcel parcel) {
            return new CompletionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompletionInfo[] newArray(int i) {
            return new CompletionInfo[i];
        }
    };
    private final long mId;
    private final CharSequence mLabel;
    private final int mPosition;
    private final CharSequence mText;

    public CompletionInfo(long j, int i, CharSequence charSequence) {
        this.mId = j;
        this.mPosition = i;
        this.mText = charSequence;
        this.mLabel = null;
    }

    public CompletionInfo(long j, int i, CharSequence charSequence, CharSequence charSequence2) {
        this.mId = j;
        this.mPosition = i;
        this.mText = charSequence;
        this.mLabel = charSequence2;
    }

    private CompletionInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mPosition = parcel.readInt();
        this.mText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mLabel = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.mId;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public String toString() {
        return "CompletionInfo{#" + this.mPosition + " \"" + ((Object) this.mText) + "\" id=" + this.mId + " label=" + ((Object) this.mLabel) + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeInt(this.mPosition);
        TextUtils.writeToParcel(this.mText, parcel, i);
        TextUtils.writeToParcel(this.mLabel, parcel, i);
    }
}
