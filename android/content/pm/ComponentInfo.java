package android.content.pm;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ComponentInfo.class */
public class ComponentInfo extends PackageItemInfo {
    public ApplicationInfo applicationInfo;
    public int descriptionRes;
    public boolean enabled;
    public boolean exported;
    public String processName;

    public ComponentInfo() {
        this.enabled = true;
        this.exported = false;
    }

    public ComponentInfo(ComponentInfo componentInfo) {
        super(componentInfo);
        this.enabled = true;
        this.exported = false;
        this.applicationInfo = componentInfo.applicationInfo;
        this.processName = componentInfo.processName;
        this.descriptionRes = componentInfo.descriptionRes;
        this.enabled = componentInfo.enabled;
        this.exported = componentInfo.exported;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ComponentInfo(Parcel parcel) {
        super(parcel);
        this.enabled = true;
        this.exported = false;
        this.applicationInfo = ApplicationInfo.CREATOR.createFromParcel(parcel);
        this.processName = parcel.readString();
        this.descriptionRes = parcel.readInt();
        this.enabled = parcel.readInt() != 0;
        this.exported = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.pm.PackageItemInfo
    public void dumpBack(Printer printer, String str) {
        if (this.applicationInfo != null) {
            printer.println(str + "ApplicationInfo:");
            this.applicationInfo.dump(printer, str + "  ");
        } else {
            printer.println(str + "ApplicationInfo: null");
        }
        super.dumpBack(printer, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.pm.PackageItemInfo
    public void dumpFront(Printer printer, String str) {
        super.dumpFront(printer, str);
        printer.println(str + "enabled=" + this.enabled + " exported=" + this.exported + " processName=" + this.processName);
        if (this.descriptionRes != 0) {
            printer.println(str + "description=" + this.descriptionRes);
        }
    }

    @Override // android.content.pm.PackageItemInfo
    protected ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public final int getBannerResource() {
        return this.banner != 0 ? this.banner : this.applicationInfo.banner;
    }

    public final int getIconResource() {
        return this.icon != 0 ? this.icon : this.applicationInfo.icon;
    }

    public final int getLogoResource() {
        return this.logo != 0 ? this.logo : this.applicationInfo.logo;
    }

    public boolean isEnabled() {
        return this.enabled && this.applicationInfo.enabled;
    }

    @Override // android.content.pm.PackageItemInfo
    protected Drawable loadDefaultBanner(PackageManager packageManager) {
        return this.applicationInfo.loadBanner(packageManager);
    }

    @Override // android.content.pm.PackageItemInfo
    public Drawable loadDefaultIcon(PackageManager packageManager) {
        return this.applicationInfo.loadIcon(packageManager);
    }

    @Override // android.content.pm.PackageItemInfo
    protected Drawable loadDefaultLogo(PackageManager packageManager) {
        return this.applicationInfo.loadLogo(packageManager);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r0 == null) goto L19;
     */
    @Override // android.content.pm.PackageItemInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence loadLabel(android.content.pm.PackageManager r6) {
        /*
            r5 = this;
            r0 = r5
            java.lang.CharSequence r0 = r0.nonLocalizedLabel
            if (r0 == 0) goto Le
            r0 = r5
            java.lang.CharSequence r0 = r0.nonLocalizedLabel
            r7 = r0
        Lc:
            r0 = r7
            return r0
        Le:
            r0 = r5
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            r9 = r0
            r0 = r5
            int r0 = r0.labelRes
            if (r0 == 0) goto L30
            r0 = r6
            r1 = r5
            java.lang.String r1 = r1.packageName
            r2 = r5
            int r2 = r2.labelRes
            r3 = r9
            java.lang.CharSequence r0 = r0.getText(r1, r2, r3)
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto Lc
        L30:
            r0 = r9
            java.lang.CharSequence r0 = r0.nonLocalizedLabel
            if (r0 == 0) goto L3e
            r0 = r9
            java.lang.CharSequence r0 = r0.nonLocalizedLabel
            return r0
        L3e:
            r0 = r9
            int r0 = r0.labelRes
            if (r0 == 0) goto L5c
            r0 = r6
            r1 = r5
            java.lang.String r1 = r1.packageName
            r2 = r9
            int r2 = r2.labelRes
            r3 = r9
            java.lang.CharSequence r0 = r0.getText(r1, r2, r3)
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            if (r0 != 0) goto Lc
        L5c:
            r0 = r5
            java.lang.String r0 = r0.name
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.ComponentInfo.loadLabel(android.content.pm.PackageManager):java.lang.CharSequence");
    }

    @Override // android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.applicationInfo.writeToParcel(parcel, i);
        parcel.writeString(this.processName);
        parcel.writeInt(this.descriptionRes);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.exported ? 1 : 0);
    }
}
