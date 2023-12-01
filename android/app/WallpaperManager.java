package android.app;

import android.R;
import android.app.IWallpaperManager;
import android.app.IWallpaperManagerCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManagerGlobal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/app/WallpaperManager.class */
public class WallpaperManager {
    public static final String ACTION_CHANGE_LIVE_WALLPAPER = "android.service.wallpaper.CHANGE_LIVE_WALLPAPER";
    public static final String ACTION_CROP_AND_SET_WALLPAPER = "android.service.wallpaper.CROP_AND_SET_WALLPAPER";
    public static final String ACTION_LIVE_WALLPAPER_CHOOSER = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    public static final String COMMAND_DROP = "android.home.drop";
    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    public static final String COMMAND_TAP = "android.wallpaper.tap";
    public static final String EXTRA_LIVE_WALLPAPER_COMPONENT = "android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT";
    private static final String PROP_WALLPAPER = "ro.config.wallpaper";
    private static final String PROP_WALLPAPER_COMPONENT = "ro.config.wallpaper_component";
    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    private static Globals sGlobals;
    private final Context mContext;
    private float mWallpaperXStep = -1.0f;
    private float mWallpaperYStep = -1.0f;
    private static String TAG = "WallpaperManager";
    private static boolean DEBUG = false;
    private static final Object sSync = new Object[0];

    /* loaded from: source-9557208-dex2jar.jar:android/app/WallpaperManager$FastBitmapDrawable.class */
    static class FastBitmapDrawable extends Drawable {
        private final Bitmap mBitmap;
        private int mDrawLeft;
        private int mDrawTop;
        private final int mHeight;
        private final Paint mPaint;
        private final int mWidth;

        private FastBitmapDrawable(Bitmap bitmap) {
            this.mBitmap = bitmap;
            this.mWidth = bitmap.getWidth();
            this.mHeight = bitmap.getHeight();
            setBounds(0, 0, this.mWidth, this.mHeight);
            this.mPaint = new Paint();
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawBitmap(this.mBitmap, this.mDrawLeft, this.mDrawTop, this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mHeight;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.mHeight;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.mWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            this.mDrawLeft = (((i3 - i) - this.mWidth) / 2) + i;
            this.mDrawTop = (((i4 - i2) - this.mHeight) / 2) + i2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/WallpaperManager$Globals.class */
    public static class Globals extends IWallpaperManagerCallback.Stub {
        private static final int MSG_CLEAR_WALLPAPER = 1;
        private Bitmap mDefaultWallpaper;
        private Bitmap mKeyguardWallpaper;
        private IWallpaperManager mService = IWallpaperManager.Stub.asInterface(ServiceManager.getService(Context.WALLPAPER_SERVICE));
        private Bitmap mWallpaper;

        Globals(Looper looper) {
        }

        private Bitmap getCurrentKeyguardWallpaperLocked(Context context) {
            if (this.mService == null) {
                Log.w(WallpaperManager.TAG, "WallpaperService not running");
                return null;
            }
            try {
                ParcelFileDescriptor keyguardWallpaper = this.mService.getKeyguardWallpaper(this, new Bundle());
                if (keyguardWallpaper != null) {
                    try {
                        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(keyguardWallpaper.getFileDescriptor(), null, new BitmapFactory.Options());
                        try {
                            keyguardWallpaper.close();
                            return decodeFileDescriptor;
                        } catch (IOException e) {
                            return decodeFileDescriptor;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.w(WallpaperManager.TAG, "Can't decode file", e2);
                        try {
                            keyguardWallpaper.close();
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    }
                }
                return null;
            } catch (RemoteException e4) {
                return null;
            }
        }

        private Bitmap getCurrentWallpaperLocked(Context context) {
            if (this.mService == null) {
                Log.w(WallpaperManager.TAG, "WallpaperService not running");
                return null;
            }
            try {
                ParcelFileDescriptor wallpaper = this.mService.getWallpaper(this, new Bundle());
                if (wallpaper != null) {
                    try {
                        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(wallpaper.getFileDescriptor(), null, new BitmapFactory.Options());
                        try {
                            wallpaper.close();
                        } catch (IOException e) {
                        }
                        return decodeFileDescriptor;
                    } catch (OutOfMemoryError e2) {
                        Log.w(WallpaperManager.TAG, "Can't decode file", e2);
                        try {
                            wallpaper.close();
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    }
                }
                return null;
            } catch (RemoteException e4) {
                return null;
            }
        }

        private Bitmap getDefaultWallpaperLocked(Context context) {
            InputStream openDefaultWallpaper = WallpaperManager.openDefaultWallpaper(context);
            Bitmap bitmap = null;
            try {
                if (openDefaultWallpaper != null) {
                    try {
                        bitmap = BitmapFactory.decodeStream(openDefaultWallpaper, null, new BitmapFactory.Options());
                        try {
                        } catch (IOException e) {
                            return bitmap;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.w(WallpaperManager.TAG, "Can't decode stream", e2);
                        try {
                            openDefaultWallpaper.close();
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    }
                }
                return bitmap;
            } finally {
                try {
                    openDefaultWallpaper.close();
                } catch (IOException e4) {
                }
            }
        }

        public void clearKeyguardWallpaper() {
            synchronized (this) {
                try {
                    this.mService.clearKeyguardWallpaper();
                } catch (RemoteException e) {
                }
                this.mKeyguardWallpaper = null;
            }
        }

        public void forgetLoadedKeyguardWallpaper() {
            synchronized (this) {
                this.mKeyguardWallpaper = null;
            }
        }

        public void forgetLoadedWallpaper() {
            synchronized (this) {
                this.mWallpaper = null;
                this.mDefaultWallpaper = null;
            }
        }

        @Override // android.app.IWallpaperManagerCallback
        public void onKeyguardWallpaperChanged() {
            synchronized (this) {
                this.mKeyguardWallpaper = null;
            }
        }

        @Override // android.app.IWallpaperManagerCallback
        public void onWallpaperChanged() {
            synchronized (this) {
                this.mWallpaper = null;
                this.mDefaultWallpaper = null;
            }
        }

        public Bitmap peekKeyguardWallpaperBitmap(Context context) {
            synchronized (this) {
                if (this.mKeyguardWallpaper != null) {
                    return this.mKeyguardWallpaper;
                }
                try {
                    this.mKeyguardWallpaper = getCurrentKeyguardWallpaperLocked(context);
                } catch (OutOfMemoryError e) {
                    Log.w(WallpaperManager.TAG, "No memory load current keyguard wallpaper", e);
                }
                return this.mKeyguardWallpaper;
            }
        }

        public Bitmap peekWallpaperBitmap(Context context, boolean z) {
            synchronized (this) {
                if (this.mWallpaper != null) {
                    return this.mWallpaper;
                } else if (this.mDefaultWallpaper != null) {
                    return this.mDefaultWallpaper;
                } else {
                    this.mWallpaper = null;
                    try {
                        this.mWallpaper = getCurrentWallpaperLocked(context);
                    } catch (OutOfMemoryError e) {
                        Log.w(WallpaperManager.TAG, "No memory load current wallpaper", e);
                    }
                    if (z) {
                        if (this.mWallpaper == null) {
                            this.mDefaultWallpaper = getDefaultWallpaperLocked(context);
                            return this.mDefaultWallpaper;
                        }
                        this.mDefaultWallpaper = null;
                    }
                    return this.mWallpaper;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WallpaperManager(Context context, Handler handler) {
        this.mContext = context;
        initGlobals(context.getMainLooper());
    }

    public static ComponentName getDefaultWallpaperComponent(Context context) {
        ComponentName componentName;
        ComponentName unflattenFromString;
        String str = SystemProperties.get(PROP_WALLPAPER_COMPONENT);
        if (TextUtils.isEmpty(str) || (unflattenFromString = ComponentName.unflattenFromString(str)) == null) {
            String string = context.getString(17039587);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(string);
            componentName = unflattenFromString2;
            if (unflattenFromString2 == null) {
                return null;
            }
        } else {
            componentName = unflattenFromString;
        }
        return componentName;
    }

    public static WallpaperManager getInstance(Context context) {
        return (WallpaperManager) context.getSystemService(Context.WALLPAPER_SERVICE);
    }

    private static RectF getMaxCropRect(int i, int i2, int i3, int i4, float f, float f2) {
        RectF rectF = new RectF();
        if (i / i2 > i3 / i4) {
            rectF.top = 0.0f;
            rectF.bottom = i2;
            float f3 = i3 * (i2 / i4);
            rectF.left = (i - f3) * f;
            rectF.right = rectF.left + f3;
            return rectF;
        }
        rectF.left = 0.0f;
        rectF.right = i;
        float f4 = i4 * (i / i3);
        rectF.top = (i2 - f4) * f2;
        rectF.bottom = rectF.top + f4;
        return rectF;
    }

    static void initGlobals(Looper looper) {
        synchronized (sSync) {
            if (sGlobals == null) {
                sGlobals = new Globals(looper);
            }
        }
    }

    public static InputStream openDefaultWallpaper(Context context) {
        String str = SystemProperties.get(PROP_WALLPAPER);
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    return new FileInputStream(file);
                } catch (IOException e) {
                }
            }
        }
        return context.getResources().openRawResource(17302155);
    }

    private void setWallpaper(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public void clear() throws IOException {
        clear(true);
    }

    public void clear(boolean z) throws IOException {
        if (z) {
            setStream(openDefaultWallpaper(this.mContext));
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        createBitmap.setPixel(0, 0, this.mContext.getResources().getColor(R.color.black));
        setBitmap(createBitmap);
    }

    public void clearKeyguardWallpaper() {
        sGlobals.clearKeyguardWallpaper();
    }

    public void clearWallpaperOffsets(IBinder iBinder) {
        try {
            WindowManagerGlobal.getWindowSession().setWallpaperPosition(iBinder, -1.0f, -1.0f, -1.0f, -1.0f);
        } catch (RemoteException e) {
        }
    }

    public void forgetLoadedKeyguardWallpaper() {
        sGlobals.forgetLoadedKeyguardWallpaper();
    }

    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
    }

    public Bitmap getBitmap() {
        return sGlobals.peekWallpaperBitmap(this.mContext, true);
    }

    public Drawable getBuiltInDrawable() {
        return getBuiltInDrawable(0, 0, false, 0.0f, 0.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0239, code lost:
        if (r17.getHeight() != r0) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.drawable.Drawable getBuiltInDrawable(int r9, int r10, boolean r11, float r12, float r13) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.WallpaperManager.getBuiltInDrawable(int, int, boolean, float, float):android.graphics.drawable.Drawable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
        if (r0.queryIntentActivities(r0, 0).size() > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Intent getCropAndSetWallpaperIntent(android.net.Uri r6) {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto Lf
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Image URI must not be null"
            r1.<init>(r2)
            throw r0
        Lf:
            java.lang.String r0 = "content"
            r1 = r6
            java.lang.String r1 = r1.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L27
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Image URI must be of the content scheme type"
            r1.<init>(r2)
            throw r0
        L27:
            r0 = r5
            android.content.Context r0 = r0.mContext
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r7 = r0
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            java.lang.String r2 = "android.service.wallpaper.CROP_AND_SET_WALLPAPER"
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r1 = 1
            android.content.Intent r0 = r0.addFlags(r1)
            r0 = r7
            android.content.Intent r1 = new android.content.Intent
            r2 = r1
            java.lang.String r3 = "android.intent.action.MAIN"
            r2.<init>(r3)
            java.lang.String r2 = "android.intent.category.HOME"
            android.content.Intent r1 = r1.addCategory(r2)
            r2 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r0 = r0.resolveActivity(r1, r2)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L78
            r0 = r6
            r1 = r8
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            java.lang.String r1 = r1.packageName
            android.content.Intent r0 = r0.setPackage(r1)
            r0 = r7
            r1 = r6
            r2 = 0
            java.util.List r0 = r0.queryIntentActivities(r1, r2)
            int r0 = r0.size()
            if (r0 <= 0) goto L78
        L76:
            r0 = r6
            return r0
        L78:
            r0 = r6
            java.lang.String r1 = "com.android.wallpapercropper"
            android.content.Intent r0 = r0.setPackage(r1)
            r0 = r7
            r1 = r6
            r2 = 0
            java.util.List r0 = r0.queryIntentActivities(r1, r2)
            int r0 = r0.size()
            if (r0 > 0) goto L76
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Cannot use passed URI to set wallpaper; check that the type returned by ContentProvider matches image/*"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.WallpaperManager.getCropAndSetWallpaperIntent(android.net.Uri):android.content.Intent");
    }

    public int getDesiredMinimumHeight() {
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return 0;
        }
        try {
            return sGlobals.mService.getHeightHint();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public int getDesiredMinimumWidth() {
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return 0;
        }
        try {
            return sGlobals.mService.getWidthHint();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public Drawable getDrawable() {
        Bitmap peekWallpaperBitmap = sGlobals.peekWallpaperBitmap(this.mContext, true);
        if (peekWallpaperBitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), peekWallpaperBitmap);
            bitmapDrawable.setDither(false);
            return bitmapDrawable;
        }
        return null;
    }

    public Drawable getFastDrawable() {
        Bitmap peekWallpaperBitmap = sGlobals.peekWallpaperBitmap(this.mContext, true);
        if (peekWallpaperBitmap != null) {
            return new FastBitmapDrawable(peekWallpaperBitmap);
        }
        return null;
    }

    public Drawable getFastKeyguardDrawable() {
        Bitmap peekKeyguardWallpaperBitmap = sGlobals.peekKeyguardWallpaperBitmap(this.mContext);
        if (peekKeyguardWallpaperBitmap != null) {
            return new FastBitmapDrawable(peekKeyguardWallpaperBitmap);
        }
        return null;
    }

    public IWallpaperManager getIWallpaperManager() {
        return sGlobals.mService;
    }

    public Bitmap getKeyguardBitmap() {
        return sGlobals.peekKeyguardWallpaperBitmap(this.mContext);
    }

    public int getLastWallpaperX() {
        try {
            return WindowManagerGlobal.getWindowSession().getLastWallpaperX();
        } catch (RemoteException e) {
            return -1;
        }
    }

    public int getLastWallpaperY() {
        try {
            return WindowManagerGlobal.getWindowSession().getLastWallpaperY();
        } catch (RemoteException e) {
            return -1;
        }
    }

    public WallpaperInfo getWallpaperInfo() {
        try {
            if (sGlobals.mService == null) {
                Log.w(TAG, "WallpaperService not running");
                return null;
            }
            return sGlobals.mService.getWallpaperInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean hasResourceWallpaper(int i) {
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return false;
        }
        try {
            return sGlobals.mService.hasNamedWallpaper("res:" + this.mContext.getResources().getResourceName(i));
        } catch (RemoteException e) {
            return false;
        }
    }

    public Drawable peekDrawable() {
        Bitmap peekWallpaperBitmap = sGlobals.peekWallpaperBitmap(this.mContext, false);
        if (peekWallpaperBitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), peekWallpaperBitmap);
            bitmapDrawable.setDither(false);
            return bitmapDrawable;
        }
        return null;
    }

    public Drawable peekFastDrawable() {
        Bitmap peekWallpaperBitmap = sGlobals.peekWallpaperBitmap(this.mContext, false);
        if (peekWallpaperBitmap != null) {
            return new FastBitmapDrawable(peekWallpaperBitmap);
        }
        return null;
    }

    public void sendWallpaperCommand(IBinder iBinder, String str, int i, int i2, int i3, Bundle bundle) {
        try {
            WindowManagerGlobal.getWindowSession().sendWallpaperCommand(iBinder, str, i, i2, i3, bundle, false);
        } catch (RemoteException e) {
        }
    }

    public void setBitmap(Bitmap bitmap) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return;
        }
        try {
            ParcelFileDescriptor wallpaper = sGlobals.mService.setWallpaper(null);
            if (wallpaper == null) {
                return;
            }
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(wallpaper);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, autoCloseOutputStream2);
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream = autoCloseOutputStream2;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                autoCloseOutputStream = null;
                th = th3;
            }
        } catch (RemoteException e) {
        }
    }

    public void setDisplayOffset(IBinder iBinder, int i, int i2) {
        try {
            WindowManagerGlobal.getWindowSession().setWallpaperDisplayOffset(iBinder, i, i2);
        } catch (RemoteException e) {
        }
    }

    public void setDisplayPadding(Rect rect) {
        try {
            if (sGlobals.mService == null) {
                Log.w(TAG, "WallpaperService not running");
            } else {
                sGlobals.mService.setDisplayPadding(rect);
            }
        } catch (RemoteException e) {
        }
    }

    public void setKeyguardBitmap(Bitmap bitmap) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return;
        }
        try {
            ParcelFileDescriptor keyguardWallpaper = sGlobals.mService.setKeyguardWallpaper(null);
            if (keyguardWallpaper == null) {
                return;
            }
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(keyguardWallpaper);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, autoCloseOutputStream2);
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream = autoCloseOutputStream2;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                autoCloseOutputStream = null;
                th = th3;
            }
        } catch (RemoteException e) {
        }
    }

    public void setKeyguardStream(InputStream inputStream) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return;
        }
        try {
            ParcelFileDescriptor keyguardWallpaper = sGlobals.mService.setKeyguardWallpaper(null);
            if (keyguardWallpaper == null) {
                return;
            }
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(keyguardWallpaper);
                try {
                    setWallpaper(inputStream, autoCloseOutputStream2);
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream = autoCloseOutputStream2;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                autoCloseOutputStream = null;
                th = th3;
            }
        } catch (RemoteException e) {
        }
    }

    public void setResource(int i) throws IOException {
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return;
        }
        try {
            Resources resources = this.mContext.getResources();
            ParcelFileDescriptor wallpaper = sGlobals.mService.setWallpaper("res:" + resources.getResourceName(i));
            if (wallpaper == null) {
                return;
            }
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = null;
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(wallpaper);
                try {
                    setWallpaper(resources.openRawResource(i), autoCloseOutputStream2);
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.close();
                    }
                } catch (Throwable th) {
                    autoCloseOutputStream = autoCloseOutputStream2;
                    th = th;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (RemoteException e) {
        }
    }

    public void setStream(InputStream inputStream) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        if (sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            return;
        }
        try {
            ParcelFileDescriptor wallpaper = sGlobals.mService.setWallpaper(null);
            if (wallpaper == null) {
                return;
            }
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(wallpaper);
                try {
                    setWallpaper(inputStream, autoCloseOutputStream2);
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream = autoCloseOutputStream2;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                autoCloseOutputStream = null;
                th = th3;
            }
        } catch (RemoteException e) {
        }
    }

    public void setWallpaperOffsetSteps(float f, float f2) {
        this.mWallpaperXStep = f;
        this.mWallpaperYStep = f2;
    }

    public void setWallpaperOffsets(IBinder iBinder, float f, float f2) {
        try {
            WindowManagerGlobal.getWindowSession().setWallpaperPosition(iBinder, f, f2, this.mWallpaperXStep, this.mWallpaperYStep);
        } catch (RemoteException e) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r7 > r9) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void suggestDesiredDimensions(int r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "sys.max_texture_size"
            r1 = 0
            int r0 = android.os.SystemProperties.getInt(r0, r1)     // Catch: java.lang.Exception -> L7d
            r9 = r0
        L9:
            r0 = r6
            r10 = r0
            r0 = r7
            r11 = r0
            r0 = r9
            if (r0 <= 0) goto L42
            r0 = r6
            r1 = r9
            if (r0 > r1) goto L26
            r0 = r6
            r10 = r0
            r0 = r7
            r11 = r0
            r0 = r7
            r1 = r9
            if (r0 <= r1) goto L42
        L26:
            r0 = r7
            float r0 = (float) r0
            r1 = r6
            float r1 = (float) r1
            float r0 = r0 / r1
            r8 = r0
            r0 = r6
            r1 = r7
            if (r0 <= r1) goto L56
            r0 = r9
            float r0 = (float) r0
            r1 = r8
            float r0 = r0 * r1
            double r0 = (double) r0
            r1 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 + r1
            int r0 = (int) r0
            r11 = r0
            r0 = r9
            r10 = r0
        L42:
            android.app.WallpaperManager$Globals r0 = android.app.WallpaperManager.sGlobals     // Catch: android.os.RemoteException -> L7a
            android.app.IWallpaperManager r0 = android.app.WallpaperManager.Globals.access$100(r0)     // Catch: android.os.RemoteException -> L7a
            if (r0 != 0) goto L6a
            java.lang.String r0 = android.app.WallpaperManager.TAG     // Catch: android.os.RemoteException -> L7a
            java.lang.String r1 = "WallpaperService not running"
            int r0 = android.util.Log.w(r0, r1)     // Catch: android.os.RemoteException -> L7a
            return
        L56:
            r0 = r9
            float r0 = (float) r0     // Catch: android.os.RemoteException -> L7a
            r1 = r8
            float r0 = r0 / r1
            double r0 = (double) r0     // Catch: android.os.RemoteException -> L7a
            r1 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 + r1
            int r0 = (int) r0     // Catch: android.os.RemoteException -> L7a
            r10 = r0
            r0 = r9
            r11 = r0
            goto L42
        L6a:
            android.app.WallpaperManager$Globals r0 = android.app.WallpaperManager.sGlobals     // Catch: android.os.RemoteException -> L7a
            android.app.IWallpaperManager r0 = android.app.WallpaperManager.Globals.access$100(r0)     // Catch: android.os.RemoteException -> L7a
            r1 = r10
            r2 = r11
            r0.setDimensionHints(r1, r2)     // Catch: android.os.RemoteException -> L7a
            return
        L7a:
            r12 = move-exception
            return
        L7d:
            r12 = move-exception
            r0 = 0
            r9 = r0
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.WallpaperManager.suggestDesiredDimensions(int, int):void");
    }
}
