package android.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;

/* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetProviderInfo.class */
public class AppWidgetProviderInfo implements Parcelable {
    public static final Parcelable.Creator<AppWidgetProviderInfo> CREATOR = new Parcelable.Creator<AppWidgetProviderInfo>() { // from class: android.appwidget.AppWidgetProviderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppWidgetProviderInfo createFromParcel(Parcel parcel) {
            return new AppWidgetProviderInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppWidgetProviderInfo[] newArray(int i) {
            return new AppWidgetProviderInfo[i];
        }
    };
    public static final int RESIZE_BOTH = 3;
    public static final int RESIZE_HORIZONTAL = 1;
    public static final int RESIZE_NONE = 0;
    public static final int RESIZE_VERTICAL = 2;
    public static final int WIDGET_CATEGORY_HOME_SCREEN = 1;
    public static final int WIDGET_CATEGORY_KEYGUARD = 2;
    public static final int WIDGET_CATEGORY_SEARCHBOX = 4;
    public int autoAdvanceViewId;
    public ComponentName configure;
    public int icon;
    public int initialKeyguardLayout;
    public int initialLayout;
    @Deprecated
    public String label;
    public int minHeight;
    public int minResizeHeight;
    public int minResizeWidth;
    public int minWidth;
    public int previewImage;
    public ComponentName provider;
    public ActivityInfo providerInfo;
    public int resizeMode;
    public int updatePeriodMillis;
    public int widgetCategory;

    public AppWidgetProviderInfo() {
    }

    public AppWidgetProviderInfo(Parcel parcel) {
        if (parcel.readInt() != 0) {
            this.provider = new ComponentName(parcel);
        }
        this.minWidth = parcel.readInt();
        this.minHeight = parcel.readInt();
        this.minResizeWidth = parcel.readInt();
        this.minResizeHeight = parcel.readInt();
        this.updatePeriodMillis = parcel.readInt();
        this.initialLayout = parcel.readInt();
        this.initialKeyguardLayout = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.configure = new ComponentName(parcel);
        }
        this.label = parcel.readString();
        this.icon = parcel.readInt();
        this.previewImage = parcel.readInt();
        this.autoAdvanceViewId = parcel.readInt();
        this.resizeMode = parcel.readInt();
        this.widgetCategory = parcel.readInt();
        this.providerInfo = (ActivityInfo) parcel.readParcelable(null);
    }

    private Drawable loadDrawable(Context context, int i, int i2, boolean z) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(this.providerInfo.applicationInfo);
            if (i2 > 0) {
                int i3 = i;
                if (i <= 0) {
                    i3 = context.getResources().getDisplayMetrics().densityDpi;
                }
                return resourcesForApplication.getDrawableForDensity(i2, i3);
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Resources.NotFoundException e2) {
        }
        if (z) {
            return this.providerInfo.loadIcon(context.getPackageManager());
        }
        return null;
    }

    /* renamed from: clone */
    public AppWidgetProviderInfo m152clone() {
        AppWidgetProviderInfo appWidgetProviderInfo = new AppWidgetProviderInfo();
        appWidgetProviderInfo.provider = this.provider == null ? null : this.provider.m182clone();
        appWidgetProviderInfo.minWidth = this.minWidth;
        appWidgetProviderInfo.minHeight = this.minHeight;
        appWidgetProviderInfo.minResizeWidth = this.minResizeHeight;
        appWidgetProviderInfo.minResizeHeight = this.minResizeHeight;
        appWidgetProviderInfo.updatePeriodMillis = this.updatePeriodMillis;
        appWidgetProviderInfo.initialLayout = this.initialLayout;
        appWidgetProviderInfo.initialKeyguardLayout = this.initialKeyguardLayout;
        appWidgetProviderInfo.configure = this.configure == null ? null : this.configure.m182clone();
        appWidgetProviderInfo.label = this.label == null ? null : this.label.substring(0);
        appWidgetProviderInfo.icon = this.icon;
        appWidgetProviderInfo.previewImage = this.previewImage;
        appWidgetProviderInfo.autoAdvanceViewId = this.autoAdvanceViewId;
        appWidgetProviderInfo.resizeMode = this.resizeMode;
        appWidgetProviderInfo.widgetCategory = this.widgetCategory;
        appWidgetProviderInfo.providerInfo = this.providerInfo;
        return appWidgetProviderInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final UserHandle getProfile() {
        return new UserHandle(UserHandle.getUserId(this.providerInfo.applicationInfo.uid));
    }

    public final Drawable loadIcon(Context context, int i) {
        return loadDrawable(context, i, this.providerInfo.getIconResource(), true);
    }

    public final String loadLabel(PackageManager packageManager) {
        CharSequence loadLabel = this.providerInfo.loadLabel(packageManager);
        if (loadLabel != null) {
            return loadLabel.toString().trim();
        }
        return null;
    }

    public final Drawable loadPreviewImage(Context context, int i) {
        return loadDrawable(context, i, this.previewImage, false);
    }

    public String toString() {
        return "AppWidgetProviderInfo(" + getProfile() + '/' + this.provider + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.provider != null) {
            parcel.writeInt(1);
            this.provider.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.minWidth);
        parcel.writeInt(this.minHeight);
        parcel.writeInt(this.minResizeWidth);
        parcel.writeInt(this.minResizeHeight);
        parcel.writeInt(this.updatePeriodMillis);
        parcel.writeInt(this.initialLayout);
        parcel.writeInt(this.initialKeyguardLayout);
        if (this.configure != null) {
            parcel.writeInt(1);
            this.configure.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.label);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.previewImage);
        parcel.writeInt(this.autoAdvanceViewId);
        parcel.writeInt(this.resizeMode);
        parcel.writeInt(this.widgetCategory);
        parcel.writeParcelable(this.providerInfo, i);
    }
}
