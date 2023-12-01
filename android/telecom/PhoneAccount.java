package android.telecom;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.MissingResourceException;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/PhoneAccount.class */
public class PhoneAccount implements Parcelable {
    public static final int ACTIVE = 2;
    public static final int CAPABILITY_CALL_PROVIDER = 2;
    public static final int CAPABILITY_CONNECTION_MANAGER = 1;
    public static final int CAPABILITY_MULTI_USER = 32;
    public static final int CAPABILITY_PLACE_EMERGENCY_CALLS = 16;
    public static final int CAPABILITY_SIM_SUBSCRIPTION = 4;
    public static final int CAPABILITY_VIDEO_CALLING = 8;
    public static final Parcelable.Creator<PhoneAccount> CREATOR = new Parcelable.Creator<PhoneAccount>() { // from class: android.telecom.PhoneAccount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccount createFromParcel(Parcel parcel) {
            return new PhoneAccount(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccount[] newArray(int i) {
            return new PhoneAccount[i];
        }
    };
    public static final int LCH = 1;
    public static final int LCHMUTE = 3;
    public static final int NO_COLOR = -1;
    public static final int NO_HIGHLIGHT_COLOR = 0;
    public static final int NO_ICON_TINT = 0;
    public static final int NO_RESOURCE_ID = -1;
    public static final String SCHEME_SIP = "sip";
    public static final String SCHEME_SMSTO = "smsto";
    public static final String SCHEME_TEL = "tel";
    public static final String SCHEME_VOICEMAIL = "voicemail";
    private BitSet dsda;
    private final PhoneAccountHandle mAccountHandle;
    private final Uri mAddress;
    private final int mCapabilities;
    private final int mColor;
    private final int mHighlightColor;
    private final Bitmap mIconBitmap;
    private final String mIconPackageName;
    private final int mIconResId;
    private final int mIconTint;
    private final CharSequence mLabel;
    private final CharSequence mShortDescription;
    private final Uri mSubscriptionAddress;
    private final List<String> mSupportedUriSchemes;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/PhoneAccount$Builder.class */
    public static class Builder {
        private PhoneAccountHandle mAccountHandle;
        private Uri mAddress;
        private int mCapabilities;
        private int mColor;
        private int mHighlightColor;
        private Bitmap mIconBitmap;
        private String mIconPackageName;
        private int mIconResId;
        private int mIconTint;
        private CharSequence mLabel;
        private CharSequence mShortDescription;
        private Uri mSubscriptionAddress;
        private List<String> mSupportedUriSchemes;

        public Builder(PhoneAccount phoneAccount) {
            this.mColor = -1;
            this.mIconTint = 0;
            this.mHighlightColor = 0;
            this.mSupportedUriSchemes = new ArrayList();
            this.mAccountHandle = phoneAccount.getAccountHandle();
            this.mAddress = phoneAccount.getAddress();
            this.mSubscriptionAddress = phoneAccount.getSubscriptionAddress();
            this.mCapabilities = phoneAccount.getCapabilities();
            this.mIconResId = phoneAccount.getIconResId();
            this.mColor = phoneAccount.getColor();
            this.mIconTint = phoneAccount.getIconTint();
            this.mHighlightColor = phoneAccount.getHighlightColor();
            this.mIconPackageName = phoneAccount.getIconPackageName();
            this.mIconBitmap = phoneAccount.getIconBitmap();
            this.mLabel = phoneAccount.getLabel();
            this.mShortDescription = phoneAccount.getShortDescription();
            this.mSupportedUriSchemes.addAll(phoneAccount.getSupportedUriSchemes());
        }

        public Builder(PhoneAccountHandle phoneAccountHandle, CharSequence charSequence) {
            this.mColor = -1;
            this.mIconTint = 0;
            this.mHighlightColor = 0;
            this.mSupportedUriSchemes = new ArrayList();
            this.mAccountHandle = phoneAccountHandle;
            this.mLabel = charSequence;
        }

        public Builder addSupportedUriScheme(String str) {
            if (!TextUtils.isEmpty(str) && !this.mSupportedUriSchemes.contains(str)) {
                this.mSupportedUriSchemes.add(str);
            }
            return this;
        }

        public PhoneAccount build() {
            if (this.mSupportedUriSchemes.isEmpty()) {
                addSupportedUriScheme(PhoneAccount.SCHEME_TEL);
            }
            return new PhoneAccount(this.mAccountHandle, this.mAddress, this.mSubscriptionAddress, this.mCapabilities, this.mIconResId, this.mColor, this.mIconTint, this.mHighlightColor, this.mIconPackageName, this.mIconBitmap, this.mLabel, this.mShortDescription, this.mSupportedUriSchemes);
        }

        public Builder setAccountHandle(PhoneAccountHandle phoneAccountHandle) {
            this.mAccountHandle = phoneAccountHandle;
            return this;
        }

        public Builder setAddress(Uri uri) {
            this.mAddress = uri;
            return this;
        }

        public Builder setCapabilities(int i) {
            this.mCapabilities = i;
            return this;
        }

        public Builder setColor(int i) {
            this.mColor = i;
            return this;
        }

        public Builder setHighlightColor(int i) {
            this.mHighlightColor = i;
            return this;
        }

        public Builder setIcon(Context context, int i) {
            return setIcon(context.getPackageName(), i);
        }

        public Builder setIcon(Context context, int i, int i2) {
            return setIcon(context.getPackageName(), i, i2);
        }

        public Builder setIcon(Bitmap bitmap) {
            this.mIconBitmap = bitmap;
            this.mIconPackageName = null;
            this.mIconResId = -1;
            this.mIconTint = 0;
            return this;
        }

        public Builder setIcon(String str, int i) {
            return setIcon(str, i, 0);
        }

        public Builder setIcon(String str, int i, int i2) {
            this.mIconPackageName = str;
            this.mIconResId = i;
            this.mIconTint = i2;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.mIconBitmap = bitmap;
            return this;
        }

        public Builder setIconPackageName(String str) {
            this.mIconPackageName = str;
            return this;
        }

        public Builder setShortDescription(CharSequence charSequence) {
            this.mShortDescription = charSequence;
            return this;
        }

        public Builder setSubscriptionAddress(Uri uri) {
            this.mSubscriptionAddress = uri;
            return this;
        }

        public Builder setSupportedUriSchemes(List<String> list) {
            this.mSupportedUriSchemes.clear();
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    addSupportedUriScheme(str);
                }
            }
            return this;
        }
    }

    private PhoneAccount(Parcel parcel) {
        this.dsda = new BitSet();
        if (parcel.readInt() > 0) {
            this.mAccountHandle = PhoneAccountHandle.CREATOR.createFromParcel(parcel);
        } else {
            this.mAccountHandle = null;
        }
        if (parcel.readInt() > 0) {
            this.mAddress = Uri.CREATOR.createFromParcel(parcel);
        } else {
            this.mAddress = null;
        }
        if (parcel.readInt() > 0) {
            this.mSubscriptionAddress = Uri.CREATOR.createFromParcel(parcel);
        } else {
            this.mSubscriptionAddress = null;
        }
        this.mCapabilities = parcel.readInt();
        this.mIconResId = parcel.readInt();
        this.mColor = parcel.readInt();
        this.mIconPackageName = parcel.readString();
        if (parcel.readInt() > 0) {
            this.mIconBitmap = Bitmap.CREATOR.createFromParcel(parcel);
        } else {
            this.mIconBitmap = null;
        }
        this.mIconTint = parcel.readInt();
        this.mHighlightColor = parcel.readInt();
        this.mLabel = parcel.readCharSequence();
        this.mShortDescription = parcel.readCharSequence();
        this.mSupportedUriSchemes = Collections.unmodifiableList(parcel.createStringArrayList());
    }

    private PhoneAccount(PhoneAccountHandle phoneAccountHandle, Uri uri, Uri uri2, int i, int i2, int i3, int i4, int i5, String str, Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2, List<String> list) {
        this.dsda = new BitSet();
        this.mAccountHandle = phoneAccountHandle;
        this.mAddress = uri;
        this.mSubscriptionAddress = uri2;
        this.mCapabilities = i;
        this.mIconResId = i2;
        this.mColor = i3;
        this.mIconTint = i4;
        this.mHighlightColor = i5;
        this.mIconPackageName = str;
        this.mIconBitmap = bitmap;
        this.mLabel = charSequence;
        this.mShortDescription = charSequence2;
        this.mSupportedUriSchemes = Collections.unmodifiableList(list);
    }

    public static Builder builder(PhoneAccountHandle phoneAccountHandle, CharSequence charSequence) {
        return new Builder(phoneAccountHandle, charSequence);
    }

    public Drawable createIconDrawable(Context context) {
        BitmapDrawable bitmapDrawable;
        if (this.mIconBitmap == null) {
            try {
                if (this.mIconResId != 0) {
                    try {
                        Drawable drawable = context.createPackageContext(this.mIconPackageName, 0).getDrawable(this.mIconResId);
                        bitmapDrawable = drawable;
                        if (this.mIconTint != 0) {
                            drawable.setTint(this.mIconTint);
                            return drawable;
                        }
                    } catch (Resources.NotFoundException | MissingResourceException e) {
                        Log.e(this, e, "Cannot find icon %d in package %s", Integer.valueOf(this.mIconResId), this.mIconPackageName);
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w(this, "Cannot find package %s", this.mIconPackageName);
            }
            return new ColorDrawable(0);
        }
        bitmapDrawable = new BitmapDrawable(context.getResources(), this.mIconBitmap);
        return bitmapDrawable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PhoneAccountHandle getAccountHandle() {
        return this.mAccountHandle;
    }

    public Uri getAddress() {
        return this.mAddress;
    }

    public int getCapabilities() {
        return this.mCapabilities;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    public Bitmap getIconBitmap() {
        return this.mIconBitmap;
    }

    public String getIconPackageName() {
        return this.mIconPackageName;
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    public int getIconTint() {
        return this.mIconTint;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence getShortDescription() {
        return this.mShortDescription;
    }

    public Uri getSubscriptionAddress() {
        return this.mSubscriptionAddress;
    }

    public List<String> getSupportedUriSchemes() {
        return this.mSupportedUriSchemes;
    }

    public boolean hasCapabilities(int i) {
        return (this.mCapabilities & i) == i;
    }

    public boolean isSet(int i) {
        return this.dsda.get(i);
    }

    public void setBit(int i) {
        this.dsda.set(i);
    }

    public boolean supportsUriScheme(String str) {
        if (this.mSupportedUriSchemes == null || str == null) {
            return false;
        }
        for (String str2 : this.mSupportedUriSchemes) {
            if (str2 != null && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("[PhoneAccount: ").append(this.mAccountHandle).append(" Capabilities: ").append(this.mCapabilities).append(" Schemes: ");
        for (String str : this.mSupportedUriSchemes) {
            append.append(str).append(" ");
        }
        append.append("]");
        return append.toString();
    }

    public void unSetBit(int i) {
        this.dsda.set(i, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.mAccountHandle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.mAccountHandle.writeToParcel(parcel, i);
        }
        if (this.mAddress == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.mAddress.writeToParcel(parcel, i);
        }
        if (this.mSubscriptionAddress == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.mSubscriptionAddress.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.mCapabilities);
        parcel.writeInt(this.mIconResId);
        parcel.writeInt(this.mColor);
        parcel.writeString(this.mIconPackageName);
        if (this.mIconBitmap == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.mIconBitmap.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.mIconTint);
        parcel.writeInt(this.mHighlightColor);
        parcel.writeCharSequence(this.mLabel);
        parcel.writeCharSequence(this.mShortDescription);
        parcel.writeStringList(this.mSupportedUriSchemes);
    }
}
