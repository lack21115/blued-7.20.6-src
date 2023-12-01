package android.content.pm;

import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageItemInfo.class */
public class PackageItemInfo {
    public int banner;
    public int icon;
    public int labelRes;
    public int logo;
    public Bundle metaData;
    public String name;
    public CharSequence nonLocalizedLabel;
    public String packageName;
    public int showUserIcon;
    public int themedIcon;

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageItemInfo$DisplayNameComparator.class */
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packageManager) {
            this.mPM = packageManager;
        }

        @Override // java.util.Comparator
        public final int compare(PackageItemInfo packageItemInfo, PackageItemInfo packageItemInfo2) {
            CharSequence loadLabel = packageItemInfo.loadLabel(this.mPM);
            String str = loadLabel;
            if (loadLabel == null) {
                str = packageItemInfo.name;
            }
            CharSequence loadLabel2 = packageItemInfo2.loadLabel(this.mPM);
            String str2 = loadLabel2;
            if (loadLabel2 == null) {
                str2 = packageItemInfo2.name;
            }
            return this.sCollator.compare(str.toString(), str2.toString());
        }
    }

    public PackageItemInfo() {
        this.showUserIcon = -10000;
    }

    public PackageItemInfo(PackageItemInfo packageItemInfo) {
        this.name = packageItemInfo.name;
        if (this.name != null) {
            this.name = this.name.trim();
        }
        this.packageName = packageItemInfo.packageName;
        this.labelRes = packageItemInfo.labelRes;
        this.nonLocalizedLabel = packageItemInfo.nonLocalizedLabel;
        if (this.nonLocalizedLabel != null) {
            this.nonLocalizedLabel = this.nonLocalizedLabel.toString().trim();
        }
        this.icon = packageItemInfo.icon;
        this.banner = packageItemInfo.banner;
        this.logo = packageItemInfo.logo;
        this.metaData = packageItemInfo.metaData;
        this.showUserIcon = packageItemInfo.showUserIcon;
        this.themedIcon = packageItemInfo.themedIcon;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PackageItemInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.packageName = parcel.readString();
        this.labelRes = parcel.readInt();
        this.nonLocalizedLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.icon = parcel.readInt();
        this.logo = parcel.readInt();
        this.metaData = parcel.readBundle();
        this.banner = parcel.readInt();
        this.showUserIcon = parcel.readInt();
        this.themedIcon = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dumpBack(Printer printer, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dumpFront(Printer printer, String str) {
        if (this.name != null) {
            printer.println(str + "name=" + this.name);
        }
        printer.println(str + "packageName=" + this.packageName);
        if (this.labelRes == 0 && this.nonLocalizedLabel == null && this.icon == 0 && this.banner == 0) {
            return;
        }
        printer.println(str + "labelRes=0x" + Integer.toHexString(this.labelRes) + " nonLocalizedLabel=" + ((Object) this.nonLocalizedLabel) + " icon=0x" + Integer.toHexString(this.icon) + " banner=0x" + Integer.toHexString(this.banner));
    }

    protected ApplicationInfo getApplicationInfo() {
        return null;
    }

    public Drawable loadBanner(PackageManager packageManager) {
        Drawable drawable;
        return (this.banner == 0 || (drawable = packageManager.getDrawable(this.packageName, this.banner, getApplicationInfo())) == null) ? loadDefaultBanner(packageManager) : drawable;
    }

    protected Drawable loadDefaultBanner(PackageManager packageManager) {
        return null;
    }

    public Drawable loadDefaultIcon(PackageManager packageManager) {
        return packageManager.getDefaultActivityIcon();
    }

    protected Drawable loadDefaultLogo(PackageManager packageManager) {
        return null;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        return packageManager.loadItemIcon(this, getApplicationInfo());
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        CharSequence text;
        return this.nonLocalizedLabel != null ? this.nonLocalizedLabel : (this.labelRes == 0 || (text = packageManager.getText(this.packageName, this.labelRes, getApplicationInfo())) == null) ? this.name != null ? this.name : this.packageName : text.toString().trim();
    }

    public Drawable loadLogo(PackageManager packageManager) {
        Drawable drawable;
        return (this.logo == 0 || (drawable = packageManager.getDrawable(this.packageName, this.logo, getApplicationInfo())) == null) ? loadDefaultLogo(packageManager) : drawable;
    }

    public Drawable loadUnbadgedIcon(PackageManager packageManager) {
        return packageManager.loadUnbadgedItemIcon(this, getApplicationInfo());
    }

    public XmlResourceParser loadXmlMetaData(PackageManager packageManager, String str) {
        int i;
        if (this.metaData == null || (i = this.metaData.getInt(str)) == 0) {
            return null;
        }
        return packageManager.getXml(this.packageName, i, getApplicationInfo());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.labelRes);
        TextUtils.writeToParcel(this.nonLocalizedLabel, parcel, i);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.logo);
        parcel.writeBundle(this.metaData);
        parcel.writeInt(this.banner);
        parcel.writeInt(this.showUserIcon);
        parcel.writeInt(this.themedIcon);
    }
}
