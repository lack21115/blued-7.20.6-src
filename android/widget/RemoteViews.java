package android.widget;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import com.android.internal.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import libcore.util.Objects;

/* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews.class */
public class RemoteViews implements Parcelable, LayoutInflater.Filter {
    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    private static final String LOG_TAG = "RemoteViews";
    private static final int MODE_HAS_LANDSCAPE_AND_PORTRAIT = 1;
    private static final int MODE_NORMAL = 0;
    private ArrayList<Action> mActions;
    private ApplicationInfo mApplication;
    private BitmapCache mBitmapCache;
    private boolean mIsRoot;
    private boolean mIsWidgetCollectionChild;
    private RemoteViews mLandscape;
    private final int mLayoutId;
    private MemoryUsageCounter mMemoryUsageCounter;
    private final MutablePair<String, Class<?>> mPair;
    private RemoteViews mPortrait;
    private static final OnClickHandler DEFAULT_ON_CLICK_HANDLER = new OnClickHandler();
    private static final Object[] sMethodsLock = new Object[0];
    private static final ArrayMap<Class<? extends View>, ArrayMap<MutablePair<String, Class<?>>, Method>> sMethods = new ArrayMap<>();
    private static final ThreadLocal<Object[]> sInvokeArgsTls = new ThreadLocal<Object[]>() { // from class: android.widget.RemoteViews.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Object[] initialValue() {
            return new Object[1];
        }
    };
    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() { // from class: android.widget.RemoteViews.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteViews[] newArray(int i) {
            return new RemoteViews[i];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.widget.RemoteViews$4  reason: invalid class name */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$Action.class */
    public static abstract class Action implements Parcelable {
        public static final int MERGE_APPEND = 1;
        public static final int MERGE_IGNORE = 2;
        public static final int MERGE_REPLACE = 0;
        int viewId;

        private Action() {
        }

        public abstract void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) throws ActionException;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public abstract String getActionName();

        public String getUniqueKey() {
            return getActionName() + this.viewId;
        }

        public int mergeBehavior() {
            return 0;
        }

        public void setBitmapCache(BitmapCache bitmapCache) {
        }

        public void updateMemoryUsageEstimate(MemoryUsageCounter memoryUsageCounter) {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$ActionException.class */
    public static class ActionException extends RuntimeException {
        public ActionException(Exception exc) {
            super(exc);
        }

        public ActionException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$BitmapCache.class */
    public static class BitmapCache {
        ArrayList<Bitmap> mBitmaps;

        public BitmapCache() {
            this.mBitmaps = new ArrayList<>();
        }

        public BitmapCache(Parcel parcel) {
            int readInt = parcel.readInt();
            this.mBitmaps = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return;
                }
                this.mBitmaps.add(Bitmap.CREATOR.createFromParcel(parcel));
                i = i2 + 1;
            }
        }

        public void addBitmapMemory(MemoryUsageCounter memoryUsageCounter) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mBitmaps.size()) {
                    return;
                }
                memoryUsageCounter.addBitmapMemory(this.mBitmaps.get(i2));
                i = i2 + 1;
            }
        }

        public void assimilate(BitmapCache bitmapCache) {
            ArrayList<Bitmap> arrayList = bitmapCache.mBitmaps;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                Bitmap bitmap = arrayList.get(i2);
                if (!this.mBitmaps.contains(bitmap)) {
                    this.mBitmaps.add(bitmap);
                }
                i = i2 + 1;
            }
        }

        public Bitmap getBitmapForId(int i) {
            if (i == -1 || i >= this.mBitmaps.size()) {
                return null;
            }
            return this.mBitmaps.get(i);
        }

        public int getBitmapId(Bitmap bitmap) {
            if (bitmap == null) {
                return -1;
            }
            if (this.mBitmaps.contains(bitmap)) {
                return this.mBitmaps.indexOf(bitmap);
            }
            this.mBitmaps.add(bitmap);
            return this.mBitmaps.size() - 1;
        }

        public void writeBitmapsToParcel(Parcel parcel, int i) {
            int size = this.mBitmaps.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                this.mBitmaps.get(i3).writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$BitmapReflectionAction.class */
    public class BitmapReflectionAction extends Action {
        public static final int TAG = 12;
        Bitmap bitmap;
        int bitmapId;
        String methodName;

        BitmapReflectionAction(int i, String str, Bitmap bitmap) {
            super();
            this.bitmap = bitmap;
            this.viewId = i;
            this.methodName = str;
            this.bitmapId = RemoteViews.this.mBitmapCache.getBitmapId(bitmap);
        }

        BitmapReflectionAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.methodName = parcel.readString();
            this.bitmapId = parcel.readInt();
            this.bitmap = RemoteViews.this.mBitmapCache.getBitmapForId(this.bitmapId);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) throws ActionException {
            new ReflectionAction(this.viewId, this.methodName, 12, this.bitmap).apply(view, viewGroup, onClickHandler);
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "BitmapReflectionAction";
        }

        @Override // android.widget.RemoteViews.Action
        public void setBitmapCache(BitmapCache bitmapCache) {
            this.bitmapId = bitmapCache.getBitmapId(this.bitmap);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(12);
            parcel.writeInt(this.viewId);
            parcel.writeString(this.methodName);
            parcel.writeInt(this.bitmapId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$MemoryUsageCounter.class */
    public class MemoryUsageCounter {
        int mMemoryUsage;

        private MemoryUsageCounter() {
        }

        public void addBitmapMemory(Bitmap bitmap) {
            Bitmap.Config config = bitmap.getConfig();
            int i = 4;
            if (config != null) {
                switch (AnonymousClass4.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 4;
                        break;
                    default:
                        i = 4;
                        break;
                }
            }
            increment(bitmap.getWidth() * bitmap.getHeight() * i);
        }

        public void clear() {
            this.mMemoryUsage = 0;
        }

        public int getMemoryUsage() {
            return this.mMemoryUsage;
        }

        public void increment(int i) {
            this.mMemoryUsage += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$MutablePair.class */
    public static class MutablePair<F, S> {
        F first;
        S second;

        MutablePair(F f, S s) {
            this.first = f;
            this.second = s;
        }

        public boolean equals(Object obj) {
            if (obj instanceof MutablePair) {
                MutablePair mutablePair = (MutablePair) obj;
                return Objects.equal(mutablePair.first, this.first) && Objects.equal(mutablePair.second, this.second);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.first == null ? 0 : this.first.hashCode();
            if (this.second != null) {
                i = this.second.hashCode();
            }
            return hashCode ^ i;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$OnClickHandler.class */
    public static class OnClickHandler {
        public boolean onClickHandler(View view, PendingIntent pendingIntent, Intent intent) {
            try {
                view.getContext().startIntentSender(pendingIntent.getIntentSender(), intent, 268435456, 268435456, 0, ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()).toBundle());
                return true;
            } catch (IntentSender.SendIntentException e) {
                Log.e(RemoteViews.LOG_TAG, "Cannot send pending intent: ", e);
                return false;
            } catch (Exception e2) {
                Log.e(RemoteViews.LOG_TAG, "Cannot send pending intent due to unknown exception: ", e2);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$ReflectionAction.class */
    public final class ReflectionAction extends Action {
        static final int BITMAP = 12;
        static final int BOOLEAN = 1;
        static final int BUNDLE = 13;
        static final int BYTE = 2;
        static final int CHAR = 8;
        static final int CHAR_SEQUENCE = 10;
        static final int COLOR_STATE_LIST = 15;
        static final int DOUBLE = 7;
        static final int FLOAT = 6;
        static final int INT = 4;
        static final int INTENT = 14;
        static final int LONG = 5;
        static final int SHORT = 3;
        static final int STRING = 9;
        static final int TAG = 2;
        static final int URI = 11;
        String methodName;
        int type;
        Object value;

        ReflectionAction(int i, String str, int i2, Object obj) {
            super();
            this.viewId = i;
            this.methodName = str;
            this.type = i2;
            this.value = obj;
        }

        ReflectionAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.methodName = parcel.readString();
            this.type = parcel.readInt();
            switch (this.type) {
                case 1:
                    this.value = Boolean.valueOf(parcel.readInt() != 0);
                    return;
                case 2:
                    this.value = Byte.valueOf(parcel.readByte());
                    return;
                case 3:
                    this.value = Short.valueOf((short) parcel.readInt());
                    return;
                case 4:
                    this.value = Integer.valueOf(parcel.readInt());
                    return;
                case 5:
                    this.value = Long.valueOf(parcel.readLong());
                    return;
                case 6:
                    this.value = Float.valueOf(parcel.readFloat());
                    return;
                case 7:
                    this.value = Double.valueOf(parcel.readDouble());
                    return;
                case 8:
                    this.value = Character.valueOf((char) parcel.readInt());
                    return;
                case 9:
                    this.value = parcel.readString();
                    return;
                case 10:
                    this.value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    return;
                case 11:
                    if (parcel.readInt() != 0) {
                        this.value = Uri.CREATOR.createFromParcel(parcel);
                        return;
                    }
                    return;
                case 12:
                    if (parcel.readInt() != 0) {
                        this.value = Bitmap.CREATOR.createFromParcel(parcel);
                        return;
                    }
                    return;
                case 13:
                    this.value = parcel.readBundle();
                    return;
                case 14:
                    if (parcel.readInt() != 0) {
                        this.value = Intent.CREATOR.createFromParcel(parcel);
                        return;
                    }
                    return;
                case 15:
                    if (parcel.readInt() != 0) {
                        this.value = ColorStateList.CREATOR.createFromParcel(parcel);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private Class<?> getParameterType() {
            switch (this.type) {
                case 1:
                    return Boolean.TYPE;
                case 2:
                    return Byte.TYPE;
                case 3:
                    return Short.TYPE;
                case 4:
                    return Integer.TYPE;
                case 5:
                    return Long.TYPE;
                case 6:
                    return Float.TYPE;
                case 7:
                    return Double.TYPE;
                case 8:
                    return Character.TYPE;
                case 9:
                    return String.class;
                case 10:
                    return CharSequence.class;
                case 11:
                    return Uri.class;
                case 12:
                    return Bitmap.class;
                case 13:
                    return Bundle.class;
                case 14:
                    return Intent.class;
                case 15:
                    return ColorStateList.class;
                default:
                    return null;
            }
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            Class<?> parameterType = getParameterType();
            if (parameterType == null) {
                throw new ActionException("bad type: " + this.type);
            }
            try {
                RemoteViews.this.getMethod(findViewById, this.methodName, parameterType).invoke(findViewById, RemoteViews.wrapArg(this.value));
            } catch (ActionException e) {
                throw e;
            } catch (Exception e2) {
                throw new ActionException(e2);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "ReflectionAction" + this.methodName + this.type;
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return this.methodName.equals("smoothScrollBy") ? 1 : 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(2);
            parcel.writeInt(this.viewId);
            parcel.writeString(this.methodName);
            parcel.writeInt(this.type);
            switch (this.type) {
                case 1:
                    parcel.writeInt(((Boolean) this.value).booleanValue() ? 1 : 0);
                    return;
                case 2:
                    parcel.writeByte(((Byte) this.value).byteValue());
                    return;
                case 3:
                    parcel.writeInt(((Short) this.value).shortValue());
                    return;
                case 4:
                    parcel.writeInt(((Integer) this.value).intValue());
                    return;
                case 5:
                    parcel.writeLong(((Long) this.value).longValue());
                    return;
                case 6:
                    parcel.writeFloat(((Float) this.value).floatValue());
                    return;
                case 7:
                    parcel.writeDouble(((Double) this.value).doubleValue());
                    return;
                case 8:
                    parcel.writeInt(((Character) this.value).charValue());
                    return;
                case 9:
                    parcel.writeString((String) this.value);
                    return;
                case 10:
                    TextUtils.writeToParcel((CharSequence) this.value, parcel, i);
                    return;
                case 11:
                    if (this.value == null) {
                        i2 = 0;
                    }
                    parcel.writeInt(i2);
                    if (this.value != null) {
                        ((Uri) this.value).writeToParcel(parcel, i);
                        return;
                    }
                    return;
                case 12:
                    parcel.writeInt(this.value != null ? 1 : 0);
                    if (this.value != null) {
                        ((Bitmap) this.value).writeToParcel(parcel, i);
                        return;
                    }
                    return;
                case 13:
                    parcel.writeBundle((Bundle) this.value);
                    return;
                case 14:
                    parcel.writeInt(this.value != null ? 1 : 0);
                    if (this.value != null) {
                        ((Intent) this.value).writeToParcel(parcel, i);
                        return;
                    }
                    return;
                case 15:
                    parcel.writeInt(this.value != null ? 1 : 0);
                    if (this.value != null) {
                        ((ColorStateList) this.value).writeToParcel(parcel, i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$ReflectionActionWithoutParams.class */
    private final class ReflectionActionWithoutParams extends Action {
        public static final int TAG = 5;
        final String methodName;

        ReflectionActionWithoutParams(int i, String str) {
            super();
            this.viewId = i;
            this.methodName = str;
        }

        ReflectionActionWithoutParams(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.methodName = parcel.readString();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            try {
                RemoteViews.this.getMethod(findViewById, this.methodName, null).invoke(findViewById, new Object[0]);
            } catch (ActionException e) {
                throw e;
            } catch (Exception e2) {
                throw new ActionException(e2);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "ReflectionActionWithoutParams";
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return (this.methodName.equals("showNext") || this.methodName.equals("showPrevious")) ? 2 : 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(5);
            parcel.writeInt(this.viewId);
            parcel.writeString(this.methodName);
        }
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$RemoteView.class */
    public @interface RemoteView {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetDrawableParameters.class */
    public class SetDrawableParameters extends Action {
        public static final int TAG = 3;
        int alpha;
        int colorFilter;
        PorterDuff.Mode filterMode;
        int level;
        boolean targetBackground;

        public SetDrawableParameters(int i, boolean z, int i2, int i3, PorterDuff.Mode mode, int i4) {
            super();
            this.viewId = i;
            this.targetBackground = z;
            this.alpha = i2;
            this.colorFilter = i3;
            this.filterMode = mode;
            this.level = i4;
        }

        public SetDrawableParameters(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.targetBackground = parcel.readInt() != 0;
            this.alpha = parcel.readInt();
            this.colorFilter = parcel.readInt();
            if (parcel.readInt() != 0) {
                this.filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            } else {
                this.filterMode = null;
            }
            this.level = parcel.readInt();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            Drawable drawable = null;
            if (this.targetBackground) {
                drawable = findViewById.getBackground();
            } else if (findViewById instanceof ImageView) {
                drawable = ((ImageView) findViewById).getDrawable();
            }
            if (drawable != null) {
                if (this.alpha != -1) {
                    drawable.setAlpha(this.alpha);
                }
                if (this.filterMode != null) {
                    drawable.setColorFilter(this.colorFilter, this.filterMode);
                }
                if (this.level != -1) {
                    drawable.setLevel(this.level);
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetDrawableParameters";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(3);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.targetBackground ? 1 : 0);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.colorFilter);
            if (this.filterMode != null) {
                parcel.writeInt(1);
                parcel.writeString(this.filterMode.toString());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.level);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetEmptyView.class */
    private class SetEmptyView extends Action {
        public static final int TAG = 6;
        int emptyViewId;
        int viewId;

        SetEmptyView(int i, int i2) {
            super();
            this.viewId = i;
            this.emptyViewId = i2;
        }

        SetEmptyView(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.emptyViewId = parcel.readInt();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) findViewById;
                View findViewById2 = view.findViewById(this.emptyViewId);
                if (findViewById2 != null) {
                    adapterView.setEmptyView(findViewById2);
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetEmptyView";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(6);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.emptyViewId);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetOnClickFillInIntent.class */
    private class SetOnClickFillInIntent extends Action {
        public static final int TAG = 9;
        Intent fillInIntent;

        public SetOnClickFillInIntent(int i, Intent intent) {
            super();
            this.viewId = i;
            this.fillInIntent = intent;
        }

        public SetOnClickFillInIntent(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.fillInIntent = Intent.CREATOR.createFromParcel(parcel);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, final OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            if (!RemoteViews.this.mIsWidgetCollectionChild) {
                Log.e(RemoteViews.LOG_TAG, "The method setOnClickFillInIntent is available only from RemoteViewsFactory (ie. on collection items).");
            } else if (findViewById == view) {
                findViewById.setTagInternal(R.id.fillInIntent, this.fillInIntent);
            } else if (this.fillInIntent != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: android.widget.RemoteViews.SetOnClickFillInIntent.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        View view3;
                        ViewParent parent = view2.getParent();
                        while (true) {
                            view3 = (View) parent;
                            if (view3 == null || (view3 instanceof AdapterView) || (view3 instanceof AppWidgetHostView)) {
                                break;
                            }
                            parent = view3.getParent();
                        }
                        if ((view3 instanceof AppWidgetHostView) || view3 == null) {
                            Log.e(RemoteViews.LOG_TAG, "Collection item doesn't have AdapterView parent");
                        } else if (!(view3.getTag() instanceof PendingIntent)) {
                            Log.e(RemoteViews.LOG_TAG, "Attempting setOnClickFillInIntent without calling setPendingIntentTemplate on parent.");
                        } else {
                            PendingIntent pendingIntent = (PendingIntent) view3.getTag();
                            SetOnClickFillInIntent.this.fillInIntent.setSourceBounds(RemoteViews.getSourceBounds(view2));
                            onClickHandler.onClickHandler(view2, pendingIntent, SetOnClickFillInIntent.this.fillInIntent);
                        }
                    }
                });
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetOnClickFillInIntent";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(9);
            parcel.writeInt(this.viewId);
            this.fillInIntent.writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetOnClickPendingIntent.class */
    public class SetOnClickPendingIntent extends Action {
        public static final int TAG = 1;
        PendingIntent pendingIntent;

        public SetOnClickPendingIntent(int i, PendingIntent pendingIntent) {
            super();
            this.viewId = i;
            this.pendingIntent = pendingIntent;
        }

        public SetOnClickPendingIntent(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            if (parcel.readInt() != 0) {
                this.pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, final OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            if (RemoteViews.this.mIsWidgetCollectionChild) {
                Log.w(RemoteViews.LOG_TAG, "Cannot setOnClickPendingIntent for collection item (id: " + this.viewId + ")");
                ApplicationInfo applicationInfo = view.getContext().getApplicationInfo();
                if (applicationInfo != null && applicationInfo.targetSdkVersion >= 16) {
                    return;
                }
            }
            View.OnClickListener onClickListener = null;
            if (this.pendingIntent != null) {
                onClickListener = new View.OnClickListener() { // from class: android.widget.RemoteViews.SetOnClickPendingIntent.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Rect sourceBounds = RemoteViews.getSourceBounds(view2);
                        Intent intent = new Intent();
                        intent.setSourceBounds(sourceBounds);
                        onClickHandler.onClickHandler(view2, SetOnClickPendingIntent.this.pendingIntent, intent);
                    }
                };
            }
            findViewById.setOnClickListener(onClickListener);
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetOnClickPendingIntent";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(1);
            parcel.writeInt(this.viewId);
            if (this.pendingIntent == null) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.pendingIntent != null) {
                this.pendingIntent.writeToParcel(parcel, 0);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetPendingIntentTemplate.class */
    private class SetPendingIntentTemplate extends Action {
        public static final int TAG = 8;
        PendingIntent pendingIntentTemplate;

        public SetPendingIntentTemplate(int i, PendingIntent pendingIntent) {
            super();
            this.viewId = i;
            this.pendingIntentTemplate = pendingIntent;
        }

        public SetPendingIntentTemplate(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, final OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            if (!(findViewById instanceof AdapterView)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot setPendingIntentTemplate on a view which is notan AdapterView (id: " + this.viewId + ")");
                return;
            }
            AdapterView adapterView = (AdapterView) findViewById;
            adapterView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.widget.RemoteViews.SetPendingIntentTemplate.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView2, View view2, int i, long j) {
                    Intent intent;
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view2;
                        ViewGroup viewGroup3 = viewGroup2;
                        if (adapterView2 instanceof AdapterViewAnimator) {
                            viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0);
                        }
                        if (viewGroup3 == null) {
                            return;
                        }
                        int childCount = viewGroup3.getChildCount();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            intent = null;
                            if (i3 >= childCount) {
                                break;
                            }
                            Object tag = viewGroup3.getChildAt(i3).getTag(R.id.fillInIntent);
                            if (tag instanceof Intent) {
                                intent = (Intent) tag;
                                break;
                            }
                            i2 = i3 + 1;
                        }
                        if (intent != null) {
                            new Intent().setSourceBounds(RemoteViews.getSourceBounds(view2));
                            onClickHandler.onClickHandler(view2, SetPendingIntentTemplate.this.pendingIntentTemplate, intent);
                        }
                    }
                }
            });
            adapterView.setTag(this.pendingIntentTemplate);
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetPendingIntentTemplate";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(8);
            parcel.writeInt(this.viewId);
            this.pendingIntentTemplate.writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetRemoteViewsAdapterIntent.class */
    public class SetRemoteViewsAdapterIntent extends Action {
        public static final int TAG = 10;
        Intent intent;

        public SetRemoteViewsAdapterIntent(int i, Intent intent) {
            super();
            this.viewId = i;
            this.intent = intent;
        }

        public SetRemoteViewsAdapterIntent(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.intent = Intent.CREATOR.createFromParcel(parcel);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            if (!(viewGroup instanceof AppWidgetHostView)) {
                Log.e(RemoteViews.LOG_TAG, "SetRemoteViewsAdapterIntent action can only be used for AppWidgets (root id: " + this.viewId + ")");
            } else if (!(findViewById instanceof AbsListView) && !(findViewById instanceof AdapterViewAnimator)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot setRemoteViewsAdapter on a view which is not an AbsListView or AdapterViewAnimator (id: " + this.viewId + ")");
            } else {
                this.intent.putExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, ((AppWidgetHostView) viewGroup).getAppWidgetId());
                if (findViewById instanceof AbsListView) {
                    AbsListView absListView = (AbsListView) findViewById;
                    absListView.setRemoteViewsAdapter(this.intent);
                    absListView.setRemoteViewsOnClickHandler(onClickHandler);
                } else if (findViewById instanceof AdapterViewAnimator) {
                    AdapterViewAnimator adapterViewAnimator = (AdapterViewAnimator) findViewById;
                    adapterViewAnimator.setRemoteViewsAdapter(this.intent);
                    adapterViewAnimator.setRemoteViewsOnClickHandler(onClickHandler);
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetRemoteViewsAdapterIntent";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(10);
            parcel.writeInt(this.viewId);
            this.intent.writeToParcel(parcel, i);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$SetRemoteViewsAdapterList.class */
    private class SetRemoteViewsAdapterList extends Action {
        public static final int TAG = 15;
        ArrayList<RemoteViews> list;
        int viewTypeCount;

        public SetRemoteViewsAdapterList(int i, ArrayList<RemoteViews> arrayList, int i2) {
            super();
            this.viewId = i;
            this.list = arrayList;
            this.viewTypeCount = i2;
        }

        public SetRemoteViewsAdapterList(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.viewTypeCount = parcel.readInt();
            int readInt = parcel.readInt();
            this.list = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return;
                }
                this.list.add(RemoteViews.CREATOR.createFromParcel(parcel));
                i = i2 + 1;
            }
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            if (!(viewGroup instanceof AppWidgetHostView)) {
                Log.e(RemoteViews.LOG_TAG, "SetRemoteViewsAdapterIntent action can only be used for AppWidgets (root id: " + this.viewId + ")");
            } else if (!(findViewById instanceof AbsListView) && !(findViewById instanceof AdapterViewAnimator)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot setRemoteViewsAdapter on a view which is not an AbsListView or AdapterViewAnimator (id: " + this.viewId + ")");
            } else if (findViewById instanceof AbsListView) {
                AbsListView absListView = (AbsListView) findViewById;
                ListAdapter adapter = absListView.getAdapter();
                if (!(adapter instanceof RemoteViewsListAdapter) || this.viewTypeCount > adapter.getViewTypeCount()) {
                    absListView.setAdapter((ListAdapter) new RemoteViewsListAdapter(absListView.getContext(), this.list, this.viewTypeCount));
                } else {
                    ((RemoteViewsListAdapter) adapter).setViewsList(this.list);
                }
            } else if (findViewById instanceof AdapterViewAnimator) {
                AdapterViewAnimator adapterViewAnimator = (AdapterViewAnimator) findViewById;
                Adapter adapter2 = adapterViewAnimator.getAdapter();
                if (!(adapter2 instanceof RemoteViewsListAdapter) || this.viewTypeCount > adapter2.getViewTypeCount()) {
                    adapterViewAnimator.setAdapter(new RemoteViewsListAdapter(adapterViewAnimator.getContext(), this.list, this.viewTypeCount));
                } else {
                    ((RemoteViewsListAdapter) adapter2).setViewsList(this.list);
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "SetRemoteViewsAdapterList";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(15);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.viewTypeCount);
            if (this.list == null || this.list.size() == 0) {
                parcel.writeInt(0);
                return;
            }
            int size = this.list.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                this.list.get(i3).writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$TextViewDrawableAction.class */
    public class TextViewDrawableAction extends Action {
        public static final int TAG = 11;
        int d1;
        int d2;
        int d3;
        int d4;
        boolean isRelative;

        public TextViewDrawableAction(int i, boolean z, int i2, int i3, int i4, int i5) {
            super();
            this.isRelative = false;
            this.viewId = i;
            this.isRelative = z;
            this.d1 = i2;
            this.d2 = i3;
            this.d3 = i4;
            this.d4 = i5;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextViewDrawableAction(RemoteViews remoteViews, Parcel parcel) {
            super();
            boolean z = false;
            RemoteViews.this = remoteViews;
            this.isRelative = false;
            this.viewId = parcel.readInt();
            this.isRelative = parcel.readInt() != 0 ? true : z;
            this.d1 = parcel.readInt();
            this.d2 = parcel.readInt();
            this.d3 = parcel.readInt();
            this.d4 = parcel.readInt();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            TextView textView = (TextView) view.findViewById(this.viewId);
            if (textView == null) {
                return;
            }
            if (this.isRelative) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(this.d1, this.d2, this.d3, this.d4);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(this.d1, this.d2, this.d3, this.d4);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "TextViewDrawableAction";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(11);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.isRelative ? 1 : 0);
            parcel.writeInt(this.d1);
            parcel.writeInt(this.d2);
            parcel.writeInt(this.d3);
            parcel.writeInt(this.d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$TextViewDrawableColorFilterAction.class */
    public class TextViewDrawableColorFilterAction extends Action {
        public static final int TAG = 17;
        final int color;
        final int index;
        final boolean isRelative;
        final PorterDuff.Mode mode;

        public TextViewDrawableColorFilterAction(int i, boolean z, int i2, int i3, PorterDuff.Mode mode) {
            super();
            this.viewId = i;
            this.isRelative = z;
            this.index = i2;
            this.color = i3;
            this.mode = mode;
        }

        public TextViewDrawableColorFilterAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.isRelative = parcel.readInt() != 0;
            this.index = parcel.readInt();
            this.color = parcel.readInt();
            this.mode = readPorterDuffMode(parcel);
        }

        private PorterDuff.Mode readPorterDuffMode(Parcel parcel) {
            int readInt = parcel.readInt();
            return (readInt < 0 || readInt >= PorterDuff.Mode.values().length) ? PorterDuff.Mode.CLEAR : PorterDuff.Mode.values()[readInt];
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            TextView textView = (TextView) view.findViewById(this.viewId);
            if (textView == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.isRelative ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
            if (this.index < 0 || this.index >= 4) {
                throw new IllegalStateException("index must be in range [0, 3].");
            }
            Drawable drawable = compoundDrawablesRelative[this.index];
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(this.color, this.mode);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "TextViewDrawableColorFilterAction";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(17);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.isRelative ? 1 : 0);
            parcel.writeInt(this.index);
            parcel.writeInt(this.color);
            parcel.writeInt(this.mode.ordinal());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$TextViewSizeAction.class */
    public class TextViewSizeAction extends Action {
        public static final int TAG = 13;
        float size;
        int units;

        public TextViewSizeAction(int i, int i2, float f) {
            super();
            this.viewId = i;
            this.units = i2;
            this.size = f;
        }

        public TextViewSizeAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.units = parcel.readInt();
            this.size = parcel.readFloat();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            TextView textView = (TextView) view.findViewById(this.viewId);
            if (textView == null) {
                return;
            }
            textView.setTextSize(this.units, this.size);
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "TextViewSizeAction";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(13);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.units);
            parcel.writeFloat(this.size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$ViewGroupAction.class */
    public class ViewGroupAction extends Action {
        public static final int TAG = 4;
        RemoteViews nestedViews;

        public ViewGroupAction(int i, RemoteViews remoteViews) {
            super();
            this.viewId = i;
            this.nestedViews = remoteViews;
            if (remoteViews != null) {
                RemoteViews.this.configureRemoteViewsAsChild(remoteViews);
            }
        }

        public ViewGroupAction(Parcel parcel, BitmapCache bitmapCache) {
            super();
            this.viewId = parcel.readInt();
            if (parcel.readInt() == 0) {
                this.nestedViews = null;
            } else {
                this.nestedViews = new RemoteViews(parcel, bitmapCache);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            Context context = view.getContext();
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(this.viewId);
            if (viewGroup2 == null) {
                return;
            }
            if (this.nestedViews != null) {
                viewGroup2.addView(this.nestedViews.apply(context, viewGroup2, onClickHandler));
            } else {
                viewGroup2.removeAllViews();
            }
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "ViewGroupAction" + (this.nestedViews == null ? "Remove" : "Add");
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return 1;
        }

        @Override // android.widget.RemoteViews.Action
        public void setBitmapCache(BitmapCache bitmapCache) {
            if (this.nestedViews != null) {
                this.nestedViews.setBitmapCache(bitmapCache);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public void updateMemoryUsageEstimate(MemoryUsageCounter memoryUsageCounter) {
            if (this.nestedViews != null) {
                memoryUsageCounter.increment(this.nestedViews.estimateMemoryUsage());
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(4);
            parcel.writeInt(this.viewId);
            if (this.nestedViews == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            this.nestedViews.writeToParcel(parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViews$ViewPaddingAction.class */
    public class ViewPaddingAction extends Action {
        public static final int TAG = 14;
        int bottom;
        int left;
        int right;
        int top;

        public ViewPaddingAction(int i, int i2, int i3, int i4, int i5) {
            super();
            this.viewId = i;
            this.left = i2;
            this.top = i3;
            this.right = i4;
            this.bottom = i5;
        }

        public ViewPaddingAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.left = parcel.readInt();
            this.top = parcel.readInt();
            this.right = parcel.readInt();
            this.bottom = parcel.readInt();
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
            View findViewById = view.findViewById(this.viewId);
            if (findViewById == null) {
                return;
            }
            findViewById.setPadding(this.left, this.top, this.right, this.bottom);
        }

        @Override // android.widget.RemoteViews.Action
        public String getActionName() {
            return "ViewPaddingAction";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(14);
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.left);
            parcel.writeInt(this.top);
            parcel.writeInt(this.right);
            parcel.writeInt(this.bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RemoteViews(ApplicationInfo applicationInfo, int i) {
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mIsWidgetCollectionChild = false;
        this.mPair = new MutablePair<>(null, null);
        this.mApplication = applicationInfo;
        this.mLayoutId = i;
        this.mBitmapCache = new BitmapCache();
        this.mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
    }

    public RemoteViews(Parcel parcel) {
        this(parcel, (BitmapCache) null);
    }

    private RemoteViews(Parcel parcel, BitmapCache bitmapCache) {
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mIsWidgetCollectionChild = false;
        this.mPair = new MutablePair<>(null, null);
        int readInt = parcel.readInt();
        if (bitmapCache == null) {
            this.mBitmapCache = new BitmapCache(parcel);
        } else {
            setBitmapCache(bitmapCache);
            setNotRoot();
        }
        if (readInt == 0) {
            this.mApplication = (ApplicationInfo) parcel.readParcelable(null);
            this.mLayoutId = parcel.readInt();
            this.mIsWidgetCollectionChild = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                this.mActions = new ArrayList<>(readInt2);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < readInt2) {
                        int readInt3 = parcel.readInt();
                        switch (readInt3) {
                            case 1:
                                this.mActions.add(new SetOnClickPendingIntent(parcel));
                                break;
                            case 2:
                                this.mActions.add(new ReflectionAction(parcel));
                                break;
                            case 3:
                                this.mActions.add(new SetDrawableParameters(parcel));
                                break;
                            case 4:
                                this.mActions.add(new ViewGroupAction(parcel, this.mBitmapCache));
                                break;
                            case 5:
                                this.mActions.add(new ReflectionActionWithoutParams(parcel));
                                break;
                            case 6:
                                this.mActions.add(new SetEmptyView(parcel));
                                break;
                            case 7:
                            case 16:
                            default:
                                throw new ActionException("Tag " + readInt3 + " not found");
                            case 8:
                                this.mActions.add(new SetPendingIntentTemplate(parcel));
                                break;
                            case 9:
                                this.mActions.add(new SetOnClickFillInIntent(parcel));
                                break;
                            case 10:
                                this.mActions.add(new SetRemoteViewsAdapterIntent(parcel));
                                break;
                            case 11:
                                this.mActions.add(new TextViewDrawableAction(this, parcel));
                                break;
                            case 12:
                                this.mActions.add(new BitmapReflectionAction(parcel));
                                break;
                            case 13:
                                this.mActions.add(new TextViewSizeAction(parcel));
                                break;
                            case 14:
                                this.mActions.add(new ViewPaddingAction(parcel));
                                break;
                            case 15:
                                this.mActions.add(new SetRemoteViewsAdapterList(parcel));
                                break;
                            case 17:
                                this.mActions.add(new TextViewDrawableColorFilterAction(parcel));
                                break;
                        }
                        i = i2 + 1;
                    }
                }
            }
        } else {
            this.mLandscape = new RemoteViews(parcel, this.mBitmapCache);
            this.mPortrait = new RemoteViews(parcel, this.mBitmapCache);
            this.mApplication = this.mPortrait.mApplication;
            this.mLayoutId = this.mPortrait.getLayoutId();
        }
        this.mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
    }

    public RemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mIsWidgetCollectionChild = false;
        this.mPair = new MutablePair<>(null, null);
        if (remoteViews == null || remoteViews2 == null) {
            throw new RuntimeException("Both RemoteViews must be non-null");
        }
        if (remoteViews.mApplication.uid != remoteViews2.mApplication.uid || !remoteViews.mApplication.packageName.equals(remoteViews2.mApplication.packageName)) {
            throw new RuntimeException("Both RemoteViews must share the same package and user");
        }
        this.mApplication = remoteViews2.mApplication;
        this.mLayoutId = remoteViews2.getLayoutId();
        this.mLandscape = remoteViews;
        this.mPortrait = remoteViews2;
        this.mMemoryUsageCounter = new MemoryUsageCounter();
        this.mBitmapCache = new BitmapCache();
        configureRemoteViewsAsChild(remoteViews);
        configureRemoteViewsAsChild(remoteViews2);
        recalculateMemoryUsage();
    }

    public RemoteViews(String str, int i) {
        this(getApplicationInfo(str, UserHandle.myUserId()), i);
    }

    public RemoteViews(String str, int i, int i2) {
        this(getApplicationInfo(str, i), i2);
    }

    private void addAction(Action action) {
        if (hasLandscapeAndPortraitLayouts()) {
            throw new RuntimeException("RemoteViews specifying separate landscape and portrait layouts cannot be modified. Instead, fully configure the landscape and portrait layouts individually before constructing the combined layout.");
        }
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        this.mActions.add(action);
        action.updateMemoryUsageEstimate(this.mMemoryUsageCounter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureRemoteViewsAsChild(RemoteViews remoteViews) {
        this.mBitmapCache.assimilate(remoteViews.mBitmapCache);
        remoteViews.setBitmapCache(this.mBitmapCache);
        remoteViews.setNotRoot();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r0.packageName.equals(r7) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String r7, int r8) {
        /*
            r0 = r7
            if (r0 != 0) goto L8
            r0 = 0
            r9 = r0
        L6:
            r0 = r9
            return r0
        L8:
            android.app.Application r0 = android.app.ActivityThread.currentApplication()
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L1d
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Cannot create remote views out of an aplication."
            r1.<init>(r2)
            throw r0
        L1d:
            r0 = r11
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            r10 = r0
            r0 = r10
            int r0 = r0.uid
            int r0 = android.os.UserHandle.getUserId(r0)
            r1 = r8
            if (r0 != r1) goto L3b
            r0 = r10
            r9 = r0
            r0 = r10
            java.lang.String r0 = r0.packageName
            r1 = r7
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L6
        L3b:
            r0 = r11
            android.content.Context r0 = r0.getBaseContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L53
            r1 = r7
            r2 = 0
            android.os.UserHandle r3 = new android.os.UserHandle     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L53
            r4 = r3
            r5 = r8
            r4.<init>(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L53
            android.content.Context r0 = r0.createPackageContextAsUser(r1, r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L53
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L53
            r9 = r0
            r0 = r9
            return r0
        L53:
            r9 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "No such package "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.RemoteViews.getApplicationInfo(java.lang.String, int):android.content.pm.ApplicationInfo");
    }

    private Context getContextForResources(Context context, String str) {
        if (this.mApplication == null || (context.getUserId() == UserHandle.getUserId(this.mApplication.uid) && context.getPackageName().equals(this.mApplication.packageName))) {
            return context;
        }
        try {
            return context.createApplicationContext(this.mApplication, str, 4);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(LOG_TAG, "Package name " + this.mApplication.packageName + " not found");
            return context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Method getMethod(View view, String str, Class<?> cls) {
        Method method;
        Class<?> cls2 = view.getClass();
        synchronized (sMethodsLock) {
            ArrayMap<MutablePair<String, Class<?>>, Method> arrayMap = sMethods.get(cls2);
            ArrayMap<MutablePair<String, Class<?>>, Method> arrayMap2 = arrayMap;
            if (arrayMap == null) {
                arrayMap2 = new ArrayMap<>();
                sMethods.put(cls2, arrayMap2);
            }
            this.mPair.first = str;
            this.mPair.second = cls;
            Method method2 = arrayMap2.get(this.mPair);
            method = method2;
            if (method2 == null) {
                try {
                    method = cls == 0 ? cls2.getMethod(str, new Class[0]) : cls2.getMethod(str, cls);
                    if (!method.isAnnotationPresent(RemotableViewMethod.class)) {
                        throw new ActionException("view: " + cls2.getName() + " can't use method with RemoteViews: " + str + getParameters(cls));
                    }
                    arrayMap2.put(new MutablePair<>(str, cls), method);
                } catch (NoSuchMethodException e) {
                    throw new ActionException("view: " + cls2.getName() + " doesn't have method: " + str + getParameters(cls));
                }
            }
        }
        return method;
    }

    private static String getParameters(Class<?> cls) {
        return cls == null ? "()" : "(" + cls + ")";
    }

    private RemoteViews getRemoteViewsToApply(Context context) {
        RemoteViews remoteViews = this;
        if (hasLandscapeAndPortraitLayouts()) {
            if (context.getResources().getConfiguration().orientation != 2) {
                return this.mPortrait;
            }
            remoteViews = this.mLandscape;
        }
        return remoteViews;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect getSourceBounds(View view) {
        float f = view.getContext().getResources().getCompatibilityInfo().applicationScale;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = (int) ((iArr[0] * f) + 0.5f);
        rect.top = (int) ((iArr[1] * f) + 0.5f);
        rect.right = (int) (((iArr[0] + view.getWidth()) * f) + 0.5f);
        rect.bottom = (int) (((iArr[1] + view.getHeight()) * f) + 0.5f);
        return rect;
    }

    private boolean hasLandscapeAndPortraitLayouts() {
        return (this.mLandscape == null || this.mPortrait == null) ? false : true;
    }

    private void performApply(View view, ViewGroup viewGroup, OnClickHandler onClickHandler) {
        if (this.mActions == null) {
            return;
        }
        OnClickHandler onClickHandler2 = onClickHandler;
        if (onClickHandler == null) {
            onClickHandler2 = DEFAULT_ON_CLICK_HANDLER;
        }
        int size = this.mActions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mActions.get(i2).apply(view, viewGroup, onClickHandler2);
            i = i2 + 1;
        }
    }

    private void recalculateMemoryUsage() {
        this.mMemoryUsageCounter.clear();
        if (hasLandscapeAndPortraitLayouts()) {
            this.mMemoryUsageCounter.increment(this.mLandscape.estimateMemoryUsage());
            this.mMemoryUsageCounter.increment(this.mPortrait.estimateMemoryUsage());
            this.mBitmapCache.addBitmapMemory(this.mMemoryUsageCounter);
            return;
        }
        if (this.mActions != null) {
            int size = this.mActions.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.mActions.get(i2).updateMemoryUsageEstimate(this.mMemoryUsageCounter);
                i = i2 + 1;
            }
        }
        if (this.mIsRoot) {
            this.mBitmapCache.addBitmapMemory(this.mMemoryUsageCounter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitmapCache(BitmapCache bitmapCache) {
        this.mBitmapCache = bitmapCache;
        if (hasLandscapeAndPortraitLayouts()) {
            this.mLandscape.setBitmapCache(bitmapCache);
            this.mPortrait.setBitmapCache(bitmapCache);
        } else if (this.mActions == null) {
        } else {
            int size = this.mActions.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.mActions.get(i2).setBitmapCache(bitmapCache);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] wrapArg(Object obj) {
        Object[] objArr = sInvokeArgsTls.get();
        objArr[0] = obj;
        return objArr;
    }

    public void addView(int i, RemoteViews remoteViews) {
        addAction(new ViewGroupAction(i, remoteViews));
    }

    public View apply(Context context, ViewGroup viewGroup) {
        return apply(context, viewGroup, null);
    }

    public View apply(Context context, ViewGroup viewGroup, OnClickHandler onClickHandler) {
        return apply(context, viewGroup, onClickHandler, null);
    }

    public View apply(Context context, ViewGroup viewGroup, OnClickHandler onClickHandler, String str) {
        RemoteViews remoteViewsToApply = getRemoteViewsToApply(context);
        final Context contextForResources = getContextForResources(context, str);
        LayoutInflater cloneInContext = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).cloneInContext(new ContextWrapper(context) { // from class: android.widget.RemoteViews.2
            @Override // android.content.ContextWrapper, android.content.Context
            public Resources getResources() {
                return contextForResources.getResources();
            }

            @Override // android.content.ContextWrapper, android.content.Context
            public Resources.Theme getTheme() {
                return contextForResources.getTheme();
            }
        });
        cloneInContext.setFilter(this);
        View inflate = cloneInContext.inflate(remoteViewsToApply.getLayoutId(), viewGroup, false);
        remoteViewsToApply.performApply(inflate, viewGroup, onClickHandler);
        return inflate;
    }

    @Override // 
    /* renamed from: clone */
    public RemoteViews mo120clone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        RemoteViews remoteViews = new RemoteViews(obtain);
        obtain.recycle();
        return remoteViews;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int estimateMemoryUsage() {
        return this.mMemoryUsageCounter.getMemoryUsage();
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }

    public String getPackage() {
        if (this.mApplication != null) {
            return this.mApplication.packageName;
        }
        return null;
    }

    public int getSequenceNumber() {
        if (this.mActions == null) {
            return 0;
        }
        return this.mActions.size();
    }

    public void mergeRemoteViews(RemoteViews remoteViews) {
        if (remoteViews == null) {
            return;
        }
        RemoteViews mo120clone = remoteViews.mo120clone();
        HashMap hashMap = new HashMap();
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        int size = this.mActions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Action action = this.mActions.get(i2);
            hashMap.put(action.getUniqueKey(), action);
            i = i2 + 1;
        }
        ArrayList<Action> arrayList = mo120clone.mActions;
        if (arrayList == null) {
            return;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                this.mBitmapCache = new BitmapCache();
                setBitmapCache(this.mBitmapCache);
                return;
            }
            Action action2 = arrayList.get(i4);
            String uniqueKey = arrayList.get(i4).getUniqueKey();
            int mergeBehavior = arrayList.get(i4).mergeBehavior();
            if (hashMap.containsKey(uniqueKey) && mergeBehavior == 0) {
                this.mActions.remove(hashMap.get(uniqueKey));
                hashMap.remove(uniqueKey);
            }
            if (mergeBehavior == 0 || mergeBehavior == 1) {
                this.mActions.add(action2);
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.view.LayoutInflater.Filter
    public boolean onLoadClass(Class cls) {
        return cls.isAnnotationPresent(RemoteView.class);
    }

    public void reapply(Context context, View view) {
        reapply(context, view, null);
    }

    public void reapply(Context context, View view, OnClickHandler onClickHandler) {
        RemoteViews remoteViewsToApply = getRemoteViewsToApply(context);
        if (hasLandscapeAndPortraitLayouts() && view.getId() != remoteViewsToApply.getLayoutId()) {
            throw new RuntimeException("Attempting to re-apply RemoteViews to a view that that does not share the same root layout id.");
        }
        remoteViewsToApply.performApply(view, (ViewGroup) view.getParent(), onClickHandler);
    }

    public void removeAllViews(int i) {
        addAction(new ViewGroupAction(i, (RemoteViews) null));
    }

    public void setAccessibilityTraversalAfter(int i, int i2) {
        setInt(i, "setAccessibilityTraversalAfter", i2);
    }

    public void setAccessibilityTraversalBefore(int i, int i2) {
        setInt(i, "setAccessibilityTraversalBefore", i2);
    }

    public void setBitmap(int i, String str, Bitmap bitmap) {
        addAction(new BitmapReflectionAction(i, str, bitmap));
    }

    public void setBoolean(int i, String str, boolean z) {
        addAction(new ReflectionAction(i, str, 1, Boolean.valueOf(z)));
    }

    public void setBundle(int i, String str, Bundle bundle) {
        addAction(new ReflectionAction(i, str, 13, bundle));
    }

    public void setByte(int i, String str, byte b) {
        addAction(new ReflectionAction(i, str, 2, Byte.valueOf(b)));
    }

    public void setChar(int i, String str, char c2) {
        addAction(new ReflectionAction(i, str, 8, Character.valueOf(c2)));
    }

    public void setCharSequence(int i, String str, CharSequence charSequence) {
        addAction(new ReflectionAction(i, str, 10, charSequence));
    }

    public void setChronometer(int i, long j, String str, boolean z) {
        setLong(i, "setBase", j);
        setString(i, "setFormat", str);
        setBoolean(i, "setStarted", z);
    }

    public void setContentDescription(int i, CharSequence charSequence) {
        setCharSequence(i, "setContentDescription", charSequence);
    }

    public void setDisplayedChild(int i, int i2) {
        setInt(i, "setDisplayedChild", i2);
    }

    public void setDouble(int i, String str, double d) {
        addAction(new ReflectionAction(i, str, 7, Double.valueOf(d)));
    }

    public void setDrawableParameters(int i, boolean z, int i2, int i3, PorterDuff.Mode mode, int i4) {
        addAction(new SetDrawableParameters(i, z, i2, i3, mode, i4));
    }

    public void setEmptyView(int i, int i2) {
        addAction(new SetEmptyView(i, i2));
    }

    public void setFloat(int i, String str, float f) {
        addAction(new ReflectionAction(i, str, 6, Float.valueOf(f)));
    }

    public void setImageViewBitmap(int i, Bitmap bitmap) {
        setBitmap(i, "setImageBitmap", bitmap);
    }

    public void setImageViewResource(int i, int i2) {
        setInt(i, "setImageResource", i2);
    }

    public void setImageViewUri(int i, Uri uri) {
        setUri(i, "setImageURI", uri);
    }

    public void setInt(int i, String str, int i2) {
        addAction(new ReflectionAction(i, str, 4, Integer.valueOf(i2)));
    }

    public void setIntent(int i, String str, Intent intent) {
        addAction(new ReflectionAction(i, str, 14, intent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsWidgetCollectionChild(boolean z) {
        this.mIsWidgetCollectionChild = z;
    }

    public void setLabelFor(int i, int i2) {
        setInt(i, "setLabelFor", i2);
    }

    public void setLong(int i, String str, long j) {
        addAction(new ReflectionAction(i, str, 5, Long.valueOf(j)));
    }

    void setNotRoot() {
        this.mIsRoot = false;
    }

    public void setOnClickFillInIntent(int i, Intent intent) {
        addAction(new SetOnClickFillInIntent(i, intent));
    }

    public void setOnClickPendingIntent(int i, PendingIntent pendingIntent) {
        addAction(new SetOnClickPendingIntent(i, pendingIntent));
    }

    public void setPendingIntentTemplate(int i, PendingIntent pendingIntent) {
        addAction(new SetPendingIntentTemplate(i, pendingIntent));
    }

    public void setProgressBackgroundTintList(int i, ColorStateList colorStateList) {
        addAction(new ReflectionAction(i, "setProgressBackgroundTintList", 15, colorStateList));
    }

    public void setProgressBar(int i, int i2, int i3, boolean z) {
        setBoolean(i, "setIndeterminate", z);
        if (z) {
            return;
        }
        setInt(i, "setMax", i2);
        setInt(i, "setProgress", i3);
    }

    public void setProgressIndeterminateTintList(int i, ColorStateList colorStateList) {
        addAction(new ReflectionAction(i, "setIndeterminateTintList", 15, colorStateList));
    }

    public void setProgressTintList(int i, ColorStateList colorStateList) {
        addAction(new ReflectionAction(i, "setProgressTintList", 15, colorStateList));
    }

    public void setRelativeScrollPosition(int i, int i2) {
        setInt(i, "smoothScrollByOffset", i2);
    }

    @Deprecated
    public void setRemoteAdapter(int i, int i2, Intent intent) {
        setRemoteAdapter(i2, intent);
    }

    public void setRemoteAdapter(int i, Intent intent) {
        addAction(new SetRemoteViewsAdapterIntent(i, intent));
    }

    public void setRemoteAdapter(int i, ArrayList<RemoteViews> arrayList, int i2) {
        addAction(new SetRemoteViewsAdapterList(i, arrayList, i2));
    }

    public void setScrollPosition(int i, int i2) {
        setInt(i, "smoothScrollToPosition", i2);
    }

    public void setShort(int i, String str, short s) {
        addAction(new ReflectionAction(i, str, 3, Short.valueOf(s)));
    }

    public void setString(int i, String str, String str2) {
        addAction(new ReflectionAction(i, str, 9, str2));
    }

    public void setTextColor(int i, int i2) {
        setInt(i, "setTextColor", i2);
    }

    public void setTextViewCompoundDrawables(int i, int i2, int i3, int i4, int i5) {
        addAction(new TextViewDrawableAction(i, false, i2, i3, i4, i5));
    }

    public void setTextViewCompoundDrawablesRelative(int i, int i2, int i3, int i4, int i5) {
        addAction(new TextViewDrawableAction(i, true, i2, i3, i4, i5));
    }

    public void setTextViewCompoundDrawablesRelativeColorFilter(int i, int i2, int i3, PorterDuff.Mode mode) {
        if (i2 < 0 || i2 >= 4) {
            throw new IllegalArgumentException("index must be in range [0, 3].");
        }
        addAction(new TextViewDrawableColorFilterAction(i, true, i2, i3, mode));
    }

    public void setTextViewText(int i, CharSequence charSequence) {
        setCharSequence(i, "setText", charSequence);
    }

    public void setTextViewTextSize(int i, int i2, float f) {
        addAction(new TextViewSizeAction(i, i2, f));
    }

    public void setUri(int i, String str, Uri uri) {
        Uri uri2 = uri;
        if (uri != null) {
            Uri canonicalUri = uri.getCanonicalUri();
            uri2 = canonicalUri;
            if (StrictMode.vmFileUriExposureEnabled()) {
                canonicalUri.checkFileUriExposed("RemoteViews.setUri()");
                uri2 = canonicalUri;
            }
        }
        addAction(new ReflectionAction(i, str, 11, uri2));
    }

    public void setViewPadding(int i, int i2, int i3, int i4, int i5) {
        addAction(new ViewPaddingAction(i, i2, i3, i4, i5));
    }

    public void setViewVisibility(int i, int i2) {
        setInt(i, "setVisibility", i2);
    }

    public void showNext(int i) {
        addAction(new ReflectionActionWithoutParams(i, "showNext"));
    }

    public void showPrevious(int i) {
        addAction(new ReflectionActionWithoutParams(i, "showPrevious"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (hasLandscapeAndPortraitLayouts()) {
            parcel.writeInt(1);
            if (this.mIsRoot) {
                this.mBitmapCache.writeBitmapsToParcel(parcel, i);
            }
            this.mLandscape.writeToParcel(parcel, i);
            this.mPortrait.writeToParcel(parcel, i);
            return;
        }
        parcel.writeInt(0);
        if (this.mIsRoot) {
            this.mBitmapCache.writeBitmapsToParcel(parcel, i);
        }
        parcel.writeParcelable(this.mApplication, i);
        parcel.writeInt(this.mLayoutId);
        parcel.writeInt(this.mIsWidgetCollectionChild ? 1 : 0);
        int size = this.mActions != null ? this.mActions.size() : 0;
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            this.mActions.get(i3).writeToParcel(parcel, 0);
            i2 = i3 + 1;
        }
    }
}
