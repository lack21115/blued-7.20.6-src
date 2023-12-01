package android.printservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Xml;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/printservice/PrintServiceInfo.class */
public final class PrintServiceInfo implements Parcelable {
    private static final String TAG_PRINT_SERVICE = "print-service";
    private final String mAddPrintersActivityName;
    private final String mAdvancedPrintOptionsActivityName;
    private final String mId;
    private final ResolveInfo mResolveInfo;
    private final String mSettingsActivityName;
    private static final String LOG_TAG = PrintServiceInfo.class.getSimpleName();
    public static final Parcelable.Creator<PrintServiceInfo> CREATOR = new Parcelable.Creator<PrintServiceInfo>() { // from class: android.printservice.PrintServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintServiceInfo createFromParcel(Parcel parcel) {
            return new PrintServiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintServiceInfo[] newArray(int i) {
            return new PrintServiceInfo[i];
        }
    };

    public PrintServiceInfo(ResolveInfo resolveInfo, String str, String str2, String str3) {
        this.mId = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name).flattenToString();
        this.mResolveInfo = resolveInfo;
        this.mSettingsActivityName = str;
        this.mAddPrintersActivityName = str2;
        this.mAdvancedPrintOptionsActivityName = str3;
    }

    public PrintServiceInfo(Parcel parcel) {
        this.mId = parcel.readString();
        this.mResolveInfo = (ResolveInfo) parcel.readParcelable(null);
        this.mSettingsActivityName = parcel.readString();
        this.mAddPrintersActivityName = parcel.readString();
        this.mAdvancedPrintOptionsActivityName = parcel.readString();
    }

    /* JADX WARN: Finally extract failed */
    public static PrintServiceInfo create(ResolveInfo resolveInfo, Context context) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        String str5 = null;
        PackageManager packageManager = context.getPackageManager();
        XmlResourceParser loadXmlMetaData = resolveInfo.serviceInfo.loadXmlMetaData(packageManager, PrintService.SERVICE_META_DATA);
        String str6 = null;
        if (loadXmlMetaData != null) {
            for (int i = 0; i != 1 && i != 2; i = loadXmlMetaData.next()) {
                try {
                    try {
                        try {
                            try {
                            } catch (PackageManager.NameNotFoundException e) {
                                Log.e(LOG_TAG, "Unable to load resources for: " + resolveInfo.serviceInfo.packageName);
                                str6 = null;
                                str5 = null;
                                str4 = null;
                                if (loadXmlMetaData != null) {
                                    loadXmlMetaData.close();
                                    str6 = null;
                                    str5 = null;
                                    str4 = null;
                                }
                            }
                        } catch (IOException e2) {
                            Log.w(LOG_TAG, "Error reading meta-data:" + e2);
                            str6 = null;
                            str5 = null;
                            str4 = null;
                            if (loadXmlMetaData != null) {
                                loadXmlMetaData.close();
                                str6 = null;
                                str5 = null;
                                str4 = null;
                            }
                        }
                    } catch (XmlPullParserException e3) {
                        Log.w(LOG_TAG, "Error reading meta-data:" + e3);
                        str6 = null;
                        str5 = null;
                        str4 = null;
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                            str6 = null;
                            str5 = null;
                            str4 = null;
                        }
                    }
                } catch (Throwable th) {
                    if (loadXmlMetaData != null) {
                        loadXmlMetaData.close();
                    }
                    throw th;
                }
            }
            if (TAG_PRINT_SERVICE.equals(loadXmlMetaData.getName())) {
                TypedArray obtainAttributes = packageManager.getResourcesForApplication(resolveInfo.serviceInfo.applicationInfo).obtainAttributes(Xml.asAttributeSet(loadXmlMetaData), R.styleable.PrintService);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(1);
                String string3 = obtainAttributes.getString(3);
                obtainAttributes.recycle();
                str = string2;
                str2 = string3;
                str3 = string;
            } else {
                Log.e(LOG_TAG, "Ignoring meta-data that does not start with print-service tag");
                str3 = null;
                str2 = null;
                str = null;
            }
            str6 = str;
            str5 = str2;
            str4 = str3;
            if (loadXmlMetaData != null) {
                loadXmlMetaData.close();
                str4 = str3;
                str5 = str2;
                str6 = str;
            }
        }
        return new PrintServiceInfo(resolveInfo, str4, str6, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PrintServiceInfo printServiceInfo = (PrintServiceInfo) obj;
            return this.mId == null ? printServiceInfo.mId == null : this.mId.equals(printServiceInfo.mId);
        }
        return false;
    }

    public String getAddPrintersActivityName() {
        return this.mAddPrintersActivityName;
    }

    public String getAdvancedOptionsActivityName() {
        return this.mAdvancedPrintOptionsActivityName;
    }

    public String getId() {
        return this.mId;
    }

    public ResolveInfo getResolveInfo() {
        return this.mResolveInfo;
    }

    public String getSettingsActivityName() {
        return this.mSettingsActivityName;
    }

    public int hashCode() {
        return (this.mId == null ? 0 : this.mId.hashCode()) + 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrintServiceInfo{");
        sb.append("id=").append(this.mId);
        sb.append(", resolveInfo=").append(this.mResolveInfo);
        sb.append(", settingsActivityName=").append(this.mSettingsActivityName);
        sb.append(", addPrintersActivityName=").append(this.mAddPrintersActivityName);
        sb.append(", advancedPrintOptionsActivityName=").append(this.mAdvancedPrintOptionsActivityName);
        sb.append(i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mResolveInfo, 0);
        parcel.writeString(this.mSettingsActivityName);
        parcel.writeString(this.mAddPrintersActivityName);
        parcel.writeString(this.mAdvancedPrintOptionsActivityName);
    }
}
