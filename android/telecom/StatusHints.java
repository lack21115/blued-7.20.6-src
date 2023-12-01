package android.telecom;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.MissingResourceException;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/StatusHints.class */
public final class StatusHints implements Parcelable {
    public static final Parcelable.Creator<StatusHints> CREATOR = new Parcelable.Creator<StatusHints>() { // from class: android.telecom.StatusHints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusHints createFromParcel(Parcel parcel) {
            return new StatusHints(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusHints[] newArray(int i) {
            return new StatusHints[i];
        }
    };
    private final Bundle mExtras;
    private final int mIconResId;
    private final CharSequence mLabel;
    private final ComponentName mPackageName;

    public StatusHints(ComponentName componentName, CharSequence charSequence, int i, Bundle bundle) {
        this.mPackageName = componentName;
        this.mLabel = charSequence;
        this.mIconResId = i;
        this.mExtras = bundle;
    }

    private StatusHints(Parcel parcel) {
        this.mPackageName = (ComponentName) parcel.readParcelable(getClass().getClassLoader());
        this.mLabel = parcel.readCharSequence();
        this.mIconResId = parcel.readInt();
        this.mExtras = (Bundle) parcel.readParcelable(getClass().getClassLoader());
    }

    private Drawable getIcon(Context context, int i) {
        try {
            try {
                return context.createPackageContext(this.mPackageName.getPackageName(), 0).getDrawable(i);
            } catch (MissingResourceException e) {
                Log.e(this, e, "Cannot find icon %d in package %s", Integer.valueOf(i), this.mPackageName.getPackageName());
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(this, e2, "Cannot find package %s", this.mPackageName.getPackageName());
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            z = false;
            if (obj instanceof StatusHints) {
                StatusHints statusHints = (StatusHints) obj;
                z = false;
                if (Objects.equals(statusHints.getPackageName(), getPackageName())) {
                    z = false;
                    if (Objects.equals(statusHints.getLabel(), getLabel())) {
                        z = false;
                        if (statusHints.getIconResId() == getIconResId()) {
                            z = false;
                            if (Objects.equals(statusHints.getExtras(), getExtras())) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Drawable getIcon(Context context) {
        return getIcon(context, this.mIconResId);
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public ComponentName getPackageName() {
        return this.mPackageName;
    }

    public int hashCode() {
        return Objects.hashCode(this.mPackageName) + Objects.hashCode(this.mLabel) + this.mIconResId + Objects.hashCode(this.mExtras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPackageName, i);
        parcel.writeCharSequence(this.mLabel);
        parcel.writeInt(this.mIconResId);
        parcel.writeParcelable(this.mExtras, 0);
    }
}
