package android.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.input.IInputManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;

/* loaded from: source-9557208-dex2jar.jar:android/view/PointerIcon.class */
public final class PointerIcon implements Parcelable {
    public static final int STYLE_ARROW = 1000;
    public static final int STYLE_CUSTOM = -1;
    private static final int STYLE_DEFAULT = 1000;
    public static final int STYLE_NULL = 0;
    private static final int STYLE_OEM_FIRST = 10000;
    public static final int STYLE_SPOT_ANCHOR = 2002;
    public static final int STYLE_SPOT_HOVER = 2000;
    public static final int STYLE_SPOT_TOUCH = 2001;
    public static final int STYLE_STYLUS_HOVER = 2003;
    private static final String TAG = "PointerIcon";
    private static IInputManager sInputManager;
    private Bitmap mBitmap;
    private float mHotSpotX;
    private float mHotSpotY;
    private final int mStyle;
    private int mSystemIconResourceId;
    private static final PointerIcon gNullIcon = new PointerIcon(0);
    private static Object sInputManagerSync = new Object();
    public static final Parcelable.Creator<PointerIcon> CREATOR = new Parcelable.Creator<PointerIcon>() { // from class: android.view.PointerIcon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointerIcon createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt == 0) {
                return PointerIcon.getNullIcon();
            }
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                PointerIcon pointerIcon = new PointerIcon(readInt);
                pointerIcon.mSystemIconResourceId = readInt2;
                return pointerIcon;
            }
            return PointerIcon.createCustomIcon(Bitmap.CREATOR.createFromParcel(parcel), parcel.readFloat(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointerIcon[] newArray(int i) {
            return new PointerIcon[i];
        }
    };

    private PointerIcon(int i) {
        this.mStyle = i;
    }

    public static PointerIcon createCustomIcon(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap must not be null");
        }
        validateHotSpot(bitmap, f, f2);
        PointerIcon pointerIcon = new PointerIcon(-1);
        pointerIcon.mBitmap = bitmap;
        pointerIcon.mHotSpotX = f;
        pointerIcon.mHotSpotY = f2;
        return pointerIcon;
    }

    public static PointerIcon getDefaultIcon(Context context) {
        return getSystemIcon(context, 1000);
    }

    private static IInputManager getInputManager() {
        IInputManager iInputManager;
        synchronized (sInputManagerSync) {
            if (sInputManager == null) {
                sInputManager = IInputManager.Stub.asInterface(ServiceManager.getService("input"));
            }
            iInputManager = sInputManager;
        }
        return iInputManager;
    }

    public static PointerIcon getNullIcon() {
        return gNullIcon;
    }

    public static PointerIcon getSystemIcon(Context context, int i) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (i == 0) {
            return gNullIcon;
        }
        int systemIconStyleIndex = getSystemIconStyleIndex(i);
        int i2 = systemIconStyleIndex;
        if (systemIconStyleIndex == 0) {
            i2 = getSystemIconStyleIndex(1000);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Pointer, R.attr.pointerStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(i2, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            Log.w(TAG, "Missing theme resources for pointer icon style " + i);
            return i == 1000 ? gNullIcon : getSystemIcon(context, 1000);
        }
        PointerIcon pointerIcon = new PointerIcon(i);
        if (((-16777216) & resourceId) == 16777216) {
            pointerIcon.mSystemIconResourceId = resourceId;
        } else {
            pointerIcon.loadResource(context, context.getResources(), resourceId);
        }
        return pointerIcon;
    }

    private static int getSystemIconStyleIndex(int i) {
        switch (i) {
            case 1000:
            default:
                return 0;
            case 2000:
                return 1;
            case 2001:
                return 2;
            case 2002:
                return 3;
            case 2003:
                return 4;
        }
    }

    public static PointerIcon loadCustomIcon(Resources resources, int i) {
        if (resources == null) {
            throw new IllegalArgumentException("resources must not be null");
        }
        PointerIcon pointerIcon = new PointerIcon(-1);
        pointerIcon.loadResource(null, resources, i);
        return pointerIcon;
    }

    private void loadResource(Context context, Resources resources, int i) {
        XmlResourceParser xml = resources.getXml(i);
        try {
            try {
                XmlUtils.beginDocument(xml, "pointer-icon");
                TypedArray obtainAttributes = resources.obtainAttributes(xml, R.styleable.PointerIcon);
                int resourceId = obtainAttributes.getResourceId(0, 0);
                float dimension = obtainAttributes.getDimension(1, 0.0f);
                float dimension2 = obtainAttributes.getDimension(2, 0.0f);
                obtainAttributes.recycle();
                if (resourceId == 0) {
                    throw new IllegalArgumentException("<pointer-icon> is missing bitmap attribute.");
                }
                Drawable drawable = context == null ? resources.getDrawable(resourceId) : context.getDrawable(resourceId);
                if (!(drawable instanceof BitmapDrawable)) {
                    throw new IllegalArgumentException("<pointer-icon> bitmap attribute must refer to a bitmap drawable.");
                }
                this.mBitmap = ((BitmapDrawable) drawable).getBitmap();
                this.mHotSpotX = dimension;
                this.mHotSpotY = dimension2;
            } catch (Exception e) {
                throw new IllegalArgumentException("Exception parsing pointer icon resource.", e);
            }
        } finally {
            xml.close();
        }
    }

    public static void setCustomHoverIcon(Bitmap bitmap, int i, int i2) throws RemoteException {
        getInputManager().setCustomHoverIcon(bitmap, i, i2);
    }

    private void throwIfIconIsNotLoaded() {
        if (!isLoaded()) {
            throw new IllegalStateException("The icon is not loaded.");
        }
    }

    private static void validateHotSpot(Bitmap bitmap, float f, float f2) {
        if (f < 0.0f || f >= bitmap.getWidth()) {
            throw new IllegalArgumentException("x hotspot lies outside of the bitmap area");
        }
        if (f2 < 0.0f || f2 >= bitmap.getHeight()) {
            throw new IllegalArgumentException("y hotspot lies outside of the bitmap area");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PointerIcon)) {
            return false;
        }
        PointerIcon pointerIcon = (PointerIcon) obj;
        if (this.mStyle == pointerIcon.mStyle && this.mSystemIconResourceId == pointerIcon.mSystemIconResourceId) {
            if (this.mSystemIconResourceId == 0) {
                return this.mBitmap == pointerIcon.mBitmap && this.mHotSpotX == pointerIcon.mHotSpotX && this.mHotSpotY == pointerIcon.mHotSpotY;
            }
            return true;
        }
        return false;
    }

    public Bitmap getBitmap() {
        throwIfIconIsNotLoaded();
        return this.mBitmap;
    }

    public float getHotSpotX() {
        throwIfIconIsNotLoaded();
        return this.mHotSpotX;
    }

    public float getHotSpotY() {
        throwIfIconIsNotLoaded();
        return this.mHotSpotY;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public boolean isLoaded() {
        return this.mBitmap != null || this.mStyle == 0;
    }

    public boolean isNullIcon() {
        return this.mStyle == 0;
    }

    public PointerIcon load(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (this.mSystemIconResourceId == 0 || this.mBitmap != null) {
            return this;
        }
        PointerIcon pointerIcon = new PointerIcon(this.mStyle);
        pointerIcon.mSystemIconResourceId = this.mSystemIconResourceId;
        pointerIcon.loadResource(context, context.getResources(), this.mSystemIconResourceId);
        return pointerIcon;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStyle);
        if (this.mStyle != 0) {
            parcel.writeInt(this.mSystemIconResourceId);
            if (this.mSystemIconResourceId == 0) {
                this.mBitmap.writeToParcel(parcel, i);
                parcel.writeFloat(this.mHotSpotX);
                parcel.writeFloat(this.mHotSpotY);
            }
        }
    }
}
