package android.content.pm;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Printer;
import android.util.Slog;
import java.text.Collator;
import java.util.Comparator;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ResolveInfo.class */
public class ResolveInfo implements Parcelable {
    public static final Parcelable.Creator<ResolveInfo> CREATOR = new Parcelable.Creator<ResolveInfo>() { // from class: android.content.pm.ResolveInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResolveInfo createFromParcel(Parcel parcel) {
            return new ResolveInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResolveInfo[] newArray(int i) {
            return new ResolveInfo[i];
        }
    };
    private static final String TAG = "ResolveInfo";
    public ActivityInfo activityInfo;
    public IntentFilter filter;
    public int icon;
    public boolean isDefault;
    public int labelRes;
    public int match;
    public boolean noResourceId;
    public CharSequence nonLocalizedLabel;
    public int preferredOrder;
    public int priority;
    public ProviderInfo providerInfo;
    public String resolvePackageName;
    public ServiceInfo serviceInfo;
    public int specificIndex;
    public boolean system;
    public ComponentName targetComponentName;
    public int targetUserId;

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/ResolveInfo$DisplayNameComparator.class */
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
        private final Collator mCollator = Collator.getInstance();
        private PackageManager mPM;

        public DisplayNameComparator(PackageManager packageManager) {
            this.mPM = packageManager;
            this.mCollator.setStrength(0);
        }

        @Override // java.util.Comparator
        public final int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            if (resolveInfo.targetUserId != -2) {
                return 1;
            }
            if (resolveInfo2.targetUserId != -2) {
                return -1;
            }
            CharSequence loadLabel = resolveInfo.loadLabel(this.mPM);
            String str = loadLabel;
            if (loadLabel == null) {
                str = resolveInfo.activityInfo.name;
            }
            CharSequence loadLabel2 = resolveInfo2.loadLabel(this.mPM);
            String str2 = loadLabel2;
            if (loadLabel2 == null) {
                str2 = resolveInfo2.activityInfo.name;
            }
            return this.mCollator.compare(str.toString(), str2.toString());
        }
    }

    public ResolveInfo() {
        this.specificIndex = -1;
        this.targetUserId = -2;
    }

    public ResolveInfo(ResolveInfo resolveInfo) {
        this.specificIndex = -1;
        this.activityInfo = resolveInfo.activityInfo;
        this.serviceInfo = resolveInfo.serviceInfo;
        this.providerInfo = resolveInfo.providerInfo;
        this.filter = resolveInfo.filter;
        this.priority = resolveInfo.priority;
        this.preferredOrder = resolveInfo.preferredOrder;
        this.match = resolveInfo.match;
        this.specificIndex = resolveInfo.specificIndex;
        this.labelRes = resolveInfo.labelRes;
        this.nonLocalizedLabel = resolveInfo.nonLocalizedLabel;
        this.icon = resolveInfo.icon;
        this.resolvePackageName = resolveInfo.resolvePackageName;
        this.system = resolveInfo.system;
        this.targetUserId = resolveInfo.targetUserId;
    }

    private ResolveInfo(Parcel parcel) {
        this.specificIndex = -1;
        this.activityInfo = null;
        this.serviceInfo = null;
        this.providerInfo = null;
        switch (parcel.readInt()) {
            case 1:
                this.activityInfo = ActivityInfo.CREATOR.createFromParcel(parcel);
                break;
            case 2:
                this.serviceInfo = ServiceInfo.CREATOR.createFromParcel(parcel);
                break;
            case 3:
                this.providerInfo = ProviderInfo.CREATOR.createFromParcel(parcel);
                break;
            default:
                Slog.w(TAG, "Missing ComponentInfo!");
                break;
        }
        if (parcel.readInt() != 0) {
            this.filter = IntentFilter.CREATOR.createFromParcel(parcel);
        }
        this.priority = parcel.readInt();
        this.preferredOrder = parcel.readInt();
        this.match = parcel.readInt();
        this.specificIndex = parcel.readInt();
        this.labelRes = parcel.readInt();
        this.nonLocalizedLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.icon = parcel.readInt();
        this.resolvePackageName = parcel.readString();
        this.targetUserId = parcel.readInt();
        this.system = parcel.readInt() != 0;
        this.noResourceId = parcel.readInt() != 0;
    }

    private ComponentInfo getComponentInfo() {
        if (this.activityInfo != null) {
            return this.activityInfo;
        }
        if (this.serviceInfo != null) {
            return this.serviceInfo;
        }
        if (this.providerInfo != null) {
            return this.providerInfo;
        }
        throw new IllegalStateException("Missing ComponentInfo!");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        if (this.filter != null) {
            printer.println(str + "Filter:");
            this.filter.dump(printer, str + "  ");
        }
        printer.println(str + "priority=" + this.priority + " preferredOrder=" + this.preferredOrder + " match=0x" + Integer.toHexString(this.match) + " specificIndex=" + this.specificIndex + " isDefault=" + this.isDefault);
        if (this.resolvePackageName != null) {
            printer.println(str + "resolvePackageName=" + this.resolvePackageName);
        }
        if (this.labelRes != 0 || this.nonLocalizedLabel != null || this.icon != 0) {
            printer.println(str + "labelRes=0x" + Integer.toHexString(this.labelRes) + " nonLocalizedLabel=" + ((Object) this.nonLocalizedLabel) + " icon=0x" + Integer.toHexString(this.icon));
        }
        if (this.activityInfo != null) {
            printer.println(str + "ActivityInfo:");
            this.activityInfo.dump(printer, str + "  ");
        } else if (this.serviceInfo != null) {
            printer.println(str + "ServiceInfo:");
            this.serviceInfo.dump(printer, str + "  ");
        } else if (this.providerInfo != null) {
            printer.println(str + "ProviderInfo:");
            this.providerInfo.dump(printer, str + "  ");
        }
    }

    public final int getIconResource() {
        if (this.noResourceId) {
            return 0;
        }
        if (this.icon != 0) {
            return this.icon;
        }
        ComponentInfo componentInfo = getComponentInfo();
        if (componentInfo != null) {
            return componentInfo.getIconResource();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r7 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager r6) {
        /*
            r5 = this;
            r0 = r5
            java.lang.String r0 = r0.resolvePackageName
            if (r0 == 0) goto L22
            r0 = r5
            int r0 = r0.icon
            if (r0 == 0) goto L22
            r0 = r6
            r1 = r5
            java.lang.String r1 = r1.resolvePackageName
            r2 = r5
            int r2 = r2.icon
            r3 = 0
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1, r2, r3)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L22
        L20:
            r0 = r7
            return r0
        L22:
            r0 = r5
            android.content.pm.ComponentInfo r0 = r0.getComponentInfo()
            r9 = r0
            r0 = r9
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            r7 = r0
            r0 = r5
            int r0 = r0.icon
            if (r0 == 0) goto L4a
            r0 = r6
            r1 = r9
            java.lang.String r1 = r1.packageName
            r2 = r5
            int r2 = r2.icon
            r3 = r7
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1, r2, r3)
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L20
        L4a:
            r0 = r9
            r1 = r6
            android.graphics.drawable.Drawable r0 = r0.loadIcon(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.ResolveInfo.loadIcon(android.content.pm.PackageManager):android.graphics.drawable.Drawable");
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        CharSequence charSequence;
        CharSequence text;
        CharSequence text2;
        if (this.nonLocalizedLabel != null) {
            charSequence = this.nonLocalizedLabel;
        } else if (this.resolvePackageName != null && this.labelRes != 0 && (text2 = packageManager.getText(this.resolvePackageName, this.labelRes, null)) != null) {
            return text2.toString().trim();
        } else {
            ComponentInfo componentInfo = getComponentInfo();
            ApplicationInfo applicationInfo = componentInfo.applicationInfo;
            if (this.labelRes != 0 && (text = packageManager.getText(componentInfo.packageName, this.labelRes, applicationInfo)) != null) {
                return text.toString().trim();
            }
            CharSequence loadLabel = componentInfo.loadLabel(packageManager);
            charSequence = loadLabel;
            if (loadLabel != null) {
                return loadLabel.toString().trim();
            }
        }
        return charSequence;
    }

    public String toString() {
        ComponentInfo componentInfo = getComponentInfo();
        StringBuilder sb = new StringBuilder(128);
        sb.append("ResolveInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        ComponentName.appendShortString(sb, componentInfo.packageName, componentInfo.name);
        if (this.priority != 0) {
            sb.append(" p=");
            sb.append(this.priority);
        }
        if (this.preferredOrder != 0) {
            sb.append(" o=");
            sb.append(this.preferredOrder);
        }
        sb.append(" m=0x");
        sb.append(Integer.toHexString(this.match));
        if (this.targetUserId != -2) {
            sb.append(" targetUserId=");
            sb.append(this.targetUserId);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.activityInfo != null) {
            parcel.writeInt(1);
            this.activityInfo.writeToParcel(parcel, i);
        } else if (this.serviceInfo != null) {
            parcel.writeInt(2);
            this.serviceInfo.writeToParcel(parcel, i);
        } else if (this.providerInfo != null) {
            parcel.writeInt(3);
            this.providerInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.filter != null) {
            parcel.writeInt(1);
            this.filter.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.priority);
        parcel.writeInt(this.preferredOrder);
        parcel.writeInt(this.match);
        parcel.writeInt(this.specificIndex);
        parcel.writeInt(this.labelRes);
        TextUtils.writeToParcel(this.nonLocalizedLabel, parcel, i);
        parcel.writeInt(this.icon);
        parcel.writeString(this.resolvePackageName);
        parcel.writeInt(this.targetUserId);
        parcel.writeInt(this.system ? 1 : 0);
        parcel.writeInt(this.noResourceId ? 1 : 0);
    }
}
