package android.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import android.widget.TextView;
import com.android.internal.R;
import com.igexin.push.core.b;

/* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetHostView.class */
public class AppWidgetHostView extends FrameLayout {
    static final boolean CROSSFADE = false;
    static final int FADE_DURATION = 1000;
    static final boolean LOGD = false;
    static final String TAG = "AppWidgetHostView";
    static final int VIEW_MODE_CONTENT = 1;
    static final int VIEW_MODE_DEFAULT = 3;
    static final int VIEW_MODE_ERROR = 2;
    static final int VIEW_MODE_NOINIT = 0;
    static final LayoutInflater.Filter sInflaterFilter = new LayoutInflater.Filter() { // from class: android.appwidget.AppWidgetHostView.1
        @Override // android.view.LayoutInflater.Filter
        public boolean onLoadClass(Class cls) {
            return cls.isAnnotationPresent(RemoteViews.RemoteView.class);
        }
    };
    int mAppWidgetId;
    Context mContext;
    long mFadeStartTime;
    AppWidgetProviderInfo mInfo;
    int mLayoutId;
    Bitmap mOld;
    Paint mOldPaint;
    private RemoteViews.OnClickHandler mOnClickHandler;
    Context mRemoteContext;
    View mView;
    int mViewMode;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetHostView$ParcelableSparseArray.class */
    public static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.Creator<ParcelableSparseArray>() { // from class: android.appwidget.AppWidgetHostView.ParcelableSparseArray.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableSparseArray createFromParcel(Parcel parcel) {
                ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                ClassLoader classLoader = parcelableSparseArray.getClass().getClassLoader();
                int readInt = parcel.readInt();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return parcelableSparseArray;
                    }
                    parcelableSparseArray.put(parcel.readInt(), parcel.readParcelable(classLoader));
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableSparseArray[] newArray(int i) {
                return new ParcelableSparseArray[i];
            }
        };

        private ParcelableSparseArray() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int size = size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                parcel.writeInt(keyAt(i3));
                parcel.writeParcelable(valueAt(i3), 0);
                i2 = i3 + 1;
            }
        }
    }

    public AppWidgetHostView(Context context) {
        this(context, 17432576, 17432577);
    }

    public AppWidgetHostView(Context context, int i, int i2) {
        super(context);
        this.mViewMode = 0;
        this.mLayoutId = -1;
        this.mFadeStartTime = -1L;
        this.mOldPaint = new Paint();
        this.mContext = context;
        setIsRootNamespace(true);
    }

    public AppWidgetHostView(Context context, RemoteViews.OnClickHandler onClickHandler) {
        this(context, 17432576, 17432577);
        this.mOnClickHandler = onClickHandler;
    }

    private int generateId() {
        int id = getId();
        int i = id;
        if (id == -1) {
            i = this.mAppWidgetId;
        }
        return i;
    }

    public static Rect getDefaultPaddingForWidget(Context context, ComponentName componentName, Rect rect) {
        PackageManager packageManager = context.getPackageManager();
        if (rect == null) {
            rect = new Rect(0, 0, 0, 0);
        } else {
            rect.set(0, 0, 0, 0);
        }
        try {
            if (packageManager.getApplicationInfo(componentName.getPackageName(), 0).targetSdkVersion >= 14) {
                Resources resources = context.getResources();
                rect.left = resources.getDimensionPixelSize(R.dimen.default_app_widget_padding_left);
                rect.right = resources.getDimensionPixelSize(R.dimen.default_app_widget_padding_right);
                rect.top = resources.getDimensionPixelSize(R.dimen.default_app_widget_padding_top);
                rect.bottom = resources.getDimensionPixelSize(R.dimen.default_app_widget_padding_bottom);
            }
            return rect;
        } catch (PackageManager.NameNotFoundException e) {
            return rect;
        }
    }

    private Context getRemoteContext() {
        try {
            return this.mContext.createApplicationContext(this.mInfo.providerInfo.applicationInfo, 4);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Package name " + this.mInfo.providerInfo.packageName + " not found");
            return this.mContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(generateId());
        ParcelableSparseArray parcelableSparseArray = null;
        if (parcelable != null) {
            parcelableSparseArray = null;
            if (parcelable instanceof ParcelableSparseArray) {
                parcelableSparseArray = (ParcelableSparseArray) parcelable;
            }
        }
        ParcelableSparseArray parcelableSparseArray2 = parcelableSparseArray;
        if (parcelableSparseArray == null) {
            parcelableSparseArray2 = new ParcelableSparseArray();
        }
        try {
            super.dispatchRestoreInstanceState(parcelableSparseArray2);
        } catch (Exception e) {
            Log.e(TAG, "failed to restoreInstanceState for widget id: " + this.mAppWidgetId + ", " + (this.mInfo == null ? b.l : this.mInfo.provider), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(parcelableSparseArray);
        sparseArray.put(generateId(), parcelableSparseArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new FrameLayout.LayoutParams(this.mRemoteContext != null ? this.mRemoteContext : this.mContext, attributeSet);
    }

    public int getAppWidgetId() {
        return this.mAppWidgetId;
    }

    public AppWidgetProviderInfo getAppWidgetInfo() {
        return this.mInfo;
    }

    protected View getDefaultView() {
        View view = null;
        RuntimeException e = null;
        try {
            if (this.mInfo != null) {
                Context remoteContext = getRemoteContext();
                this.mRemoteContext = remoteContext;
                LayoutInflater cloneInContext = ((LayoutInflater) remoteContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).cloneInContext(remoteContext);
                cloneInContext.setFilter(sInflaterFilter);
                Bundle appWidgetOptions = AppWidgetManager.getInstance(this.mContext).getAppWidgetOptions(this.mAppWidgetId);
                int i = this.mInfo.initialLayout;
                int i2 = i;
                if (appWidgetOptions.containsKey(AppWidgetManager.OPTION_APPWIDGET_HOST_CATEGORY)) {
                    i2 = i;
                    if (appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_HOST_CATEGORY) == 2) {
                        i2 = this.mInfo.initialKeyguardLayout;
                        if (i2 == 0) {
                            i2 = i;
                        }
                    }
                }
                view = cloneInContext.inflate(i2, (ViewGroup) this, false);
            } else {
                Log.w(TAG, "can't inflate defaultView because mInfo is missing");
            }
        } catch (RuntimeException e2) {
            e = e2;
        }
        if (e != null) {
            Log.w(TAG, "Error inflating AppWidget " + this.mInfo + ": " + e.toString());
        }
        View view2 = view;
        if (view == null) {
            view2 = getErrorView();
        }
        return view2;
    }

    protected View getErrorView() {
        TextView textView = new TextView(this.mContext);
        textView.setText(R.string.gadget_host_error_inflating);
        textView.setBackgroundColor(Color.argb(127, 0, 0, 0));
        return textView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AppWidgetHostView.class.getName());
    }

    protected void prepareView(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        }
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetAppWidget(AppWidgetProviderInfo appWidgetProviderInfo) {
        this.mInfo = appWidgetProviderInfo;
        this.mViewMode = 0;
        updateAppWidget(null);
    }

    public void setAppWidget(int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        this.mAppWidgetId = i;
        this.mInfo = appWidgetProviderInfo;
        if (appWidgetProviderInfo != null) {
            Rect defaultPaddingForWidget = getDefaultPaddingForWidget(this.mContext, appWidgetProviderInfo.provider, null);
            setPadding(defaultPaddingForWidget.left, defaultPaddingForWidget.top, defaultPaddingForWidget.right, defaultPaddingForWidget.bottom);
            setContentDescription(appWidgetProviderInfo.label);
        }
    }

    public void setOnClickHandler(RemoteViews.OnClickHandler onClickHandler) {
        this.mOnClickHandler = onClickHandler;
    }

    public void updateAppWidget(RemoteViews remoteViews) {
        View view;
        RuntimeException e;
        boolean z = false;
        if (remoteViews != null) {
            this.mRemoteContext = getRemoteContext();
            int layoutId = remoteViews.getLayoutId();
            View view2 = null;
            RuntimeException e2 = null;
            z = false;
            if (0 == 0) {
                view2 = null;
                e2 = null;
                z = false;
                if (layoutId == this.mLayoutId) {
                    try {
                        remoteViews.reapply(this.mContext, this.mView, this.mOnClickHandler);
                        view2 = this.mView;
                        z = true;
                        e2 = null;
                    } catch (RuntimeException e3) {
                        e2 = e3;
                        view2 = null;
                        z = false;
                    }
                }
            }
            view = view2;
            e = e2;
            if (view2 == null) {
                try {
                    view = remoteViews.apply(this.mContext, this, this.mOnClickHandler);
                    e = e2;
                } catch (RuntimeException e4) {
                    e = e4;
                    view = view2;
                }
            }
            this.mLayoutId = layoutId;
            this.mViewMode = 1;
        } else if (this.mViewMode == 3) {
            return;
        } else {
            view = getDefaultView();
            this.mLayoutId = -1;
            this.mViewMode = 3;
            e = null;
        }
        View view3 = view;
        if (view == null) {
            if (this.mViewMode == 2) {
                return;
            }
            Log.w(TAG, "updateAppWidget couldn't find any view, using error view", e);
            view3 = getErrorView();
            this.mViewMode = 2;
        }
        if (!z) {
            prepareView(view3);
            addView(view3);
        }
        if (this.mView != view3) {
            removeView(this.mView);
            this.mView = view3;
        }
    }

    public void updateAppWidgetOptions(Bundle bundle) {
        AppWidgetManager.getInstance(this.mContext).updateAppWidgetOptions(this.mAppWidgetId, bundle);
    }

    public void updateAppWidgetSize(Bundle bundle, int i, int i2, int i3, int i4) {
        updateAppWidgetSize(bundle, i, i2, i3, i4, false);
    }

    public void updateAppWidgetSize(Bundle bundle, int i, int i2, int i3, int i4, boolean z) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        Rect rect = new Rect();
        Rect rect2 = rect;
        if (this.mInfo != null) {
            rect2 = getDefaultPaddingForWidget(this.mContext, this.mInfo.provider, rect);
        }
        float f = getResources().getDisplayMetrics().density;
        int i5 = (int) ((rect2.left + rect2.right) / f);
        int i6 = (int) ((rect2.top + rect2.bottom) / f);
        int i7 = i - (z ? 0 : i5);
        int i8 = i2 - (z ? 0 : i6);
        if (z) {
            i5 = 0;
        }
        int i9 = i3 - i5;
        if (z) {
            i6 = 0;
        }
        int i10 = i4 - i6;
        Bundle appWidgetOptions = AppWidgetManager.getInstance(this.mContext).getAppWidgetOptions(this.mAppWidgetId);
        boolean z2 = false;
        if (i7 != appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH) || i8 != appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT) || i9 != appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH) || i10 != appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)) {
            z2 = true;
        }
        if (z2) {
            bundle2.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, i7);
            bundle2.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, i8);
            bundle2.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, i9);
            bundle2.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, i10);
            updateAppWidgetOptions(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void viewDataChanged(int i) {
        View findViewById = findViewById(i);
        if (findViewById == null || !(findViewById instanceof AdapterView)) {
            return;
        }
        AdapterView adapterView = (AdapterView) findViewById;
        Adapter adapter = adapterView.getAdapter();
        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).notifyDataSetChanged();
        } else if (adapter == null && (adapterView instanceof RemoteViewsAdapter.RemoteAdapterConnectionCallback)) {
            ((RemoteViewsAdapter.RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
        }
    }
}
