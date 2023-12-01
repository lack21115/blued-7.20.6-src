package android.app;

import android.app.ComposedIconInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ThemeUtils;
import android.content.res.AssetManager;
import android.content.res.IThemeService;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.VectorDrawable;
import android.nfc.cardemulation.CardEmulation;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.cm.palette.Palette;
import com.anythink.expressad.foundation.h.i;
import com.huawei.hms.ads.fw;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-9557208-dex2jar.jar:android/app/IconPackHelper.class */
public class IconPackHelper {
    private static final String ANGLE_ATTR = "angle";
    private static final String ANGLE_VARIANCE = "plusMinus";
    private static final int COMPOSED_ICON_COOKIE = 128;
    private static final boolean DEBUG = false;
    private static final float DEFAULT_SCALE = 1.0f;
    private static final String DEFAULT_SWATCH_COLOR_ATTR = "defaultSwatchColor";
    private static final String ICON_BACK_FORMAT = "iconback%d";
    private static final String ICON_PALETTIZED_BACK_TAG = "paletteback";
    private static final String ICON_ROTATE_TAG = "rotate";
    private static final String ICON_SCALE_TAG = "scale";
    private static final String ICON_TRANSLATE_TAG = "translate";
    private static final String IMG_ATTR = "img";
    private static final String MUTED_DARK_VALUE = "mutedDark";
    private static final String MUTED_LIGHT_VALUE = "mutedLight";
    private static final String MUTED_VALUE = "muted";
    private static final int NUM_PALETTE_COLORS = 32;
    private static final String SWATCH_TYPE_ATTR = "swatchType";
    private static final String TRANSLATE_X_ATTR = "xOffset";
    private static final String TRANSLATE_Y_ATTR = "yOffset";
    private static final String VIBRANT_DARK_VALUE = "vibrantDark";
    private static final String VIBRANT_LIGHT_VALUE = "vibrantLight";
    private static final String VIBRANT_VALUE = "vibrant";
    private ComposedIconInfo mComposedIconInfo;
    private final Context mContext;
    private ColorFilterUtils.Builder mFilterBuilder;
    private int mIconBackCount = 0;
    private Map<ComponentName, String> mIconPackResourceMap = new HashMap();
    private String mLoadedIconPackName;
    private Resources mLoadedIconPackResource;
    private static final String TAG = IconPackHelper.class.getSimpleName();
    private static final String ICON_BACK_TAG = "iconback";
    private static final ComponentName ICON_BACK_COMPONENT = new ComponentName(ICON_BACK_TAG, "");
    private static final String ICON_MASK_TAG = "iconmask";
    private static final ComponentName ICON_MASK_COMPONENT = new ComponentName(ICON_MASK_TAG, "");
    private static final String ICON_UPON_TAG = "iconupon";
    private static final ComponentName ICON_UPON_COMPONENT = new ComponentName(ICON_UPON_TAG, "");
    private static final ComponentName ICON_SCALE_COMPONENT = new ComponentName("scale", "");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.app.IconPackHelper$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/app/IconPackHelper$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$app$ComposedIconInfo$SwatchType = new int[ComposedIconInfo.SwatchType.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:27:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0053 -> B:29:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0057 -> B:37:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005b -> B:35:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005f -> B:33:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.Vibrant.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.VibrantLight.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.VibrantDark.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.Muted.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.MutedLight.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$app$ComposedIconInfo$SwatchType[ComposedIconInfo.SwatchType.MutedDark.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/IconPackHelper$ColorFilterUtils.class */
    public static class ColorFilterUtils {
        private static final String FILTER_ALPHA = "alpha";
        private static final String FILTER_BRIGHTNESS = "brightness";
        private static final String FILTER_CONTRAST = "contrast";
        private static final String FILTER_HUE = "hue";
        private static final String FILTER_INVERT = "invert";
        private static final String FILTER_SATURATION = "saturation";
        private static final String FILTER_TINT = "tint";
        private static final int MAX_ALPHA = 100;
        private static final int MAX_BRIGHTNESS = 200;
        private static final int MAX_CONTRAST = 100;
        private static final int MAX_HUE = 180;
        private static final int MAX_SATURATION = 200;
        private static final int MIN_ALPHA = 0;
        private static final int MIN_BRIGHTNESS = 0;
        private static final int MIN_CONTRAST = -100;
        private static final int MIN_HUE = -180;
        private static final int MIN_SATURATION = 0;
        private static final String TAG_FILTER = "filter";

        /* loaded from: source-9557208-dex2jar.jar:android/app/IconPackHelper$ColorFilterUtils$Builder.class */
        public static class Builder {
            private List<ColorMatrix> mMatrixList = new ArrayList();

            public Builder alpha(float f) {
                this.mMatrixList.add(ColorFilterUtils.adjustAlpha(f));
                return this;
            }

            public Builder brightness(float f) {
                this.mMatrixList.add(ColorFilterUtils.adjustBrightness(f));
                return this;
            }

            public ColorMatrix build() {
                ColorMatrix colorMatrix;
                if (this.mMatrixList != null && this.mMatrixList.size() != 0) {
                    ColorMatrix colorMatrix2 = new ColorMatrix();
                    Iterator<ColorMatrix> it = this.mMatrixList.iterator();
                    while (true) {
                        colorMatrix = colorMatrix2;
                        if (!it.hasNext()) {
                            break;
                        }
                        colorMatrix2.postConcat(it.next());
                    }
                } else {
                    colorMatrix = null;
                }
                return colorMatrix;
            }

            public Builder contrast(float f) {
                this.mMatrixList.add(ColorFilterUtils.adjustContrast(f));
                return this;
            }

            public Builder hue(float f) {
                this.mMatrixList.add(ColorFilterUtils.adjustHue(f));
                return this;
            }

            public Builder invertColors() {
                this.mMatrixList.add(ColorFilterUtils.invertColors());
                return this;
            }

            public Builder saturate(float f) {
                this.mMatrixList.add(ColorFilterUtils.adjustSaturation(f));
                return this;
            }

            public Builder tint(int i) {
                this.mMatrixList.add(ColorFilterUtils.applyTint(i));
                return this;
            }
        }

        public static ColorMatrix adjustAlpha(float f) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setScale(1.0f, 1.0f, 1.0f, f / 100.0f);
            return colorMatrix;
        }

        public static ColorMatrix adjustBrightness(float f) {
            float f2 = f / 100.0f;
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setScale(f2, f2, f2, 1.0f);
            return colorMatrix;
        }

        public static ColorMatrix adjustContrast(float f) {
            float f2 = (f / 100.0f) + 1.0f;
            float f3 = (((-0.5f) * f2) + 0.5f) * 255.0f;
            return new ColorMatrix(new float[]{f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, f2, 0.0f, 0.0f, f3, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        }

        public static ColorMatrix adjustHue(float f) {
            ColorMatrix colorMatrix = new ColorMatrix();
            float f2 = (f / 180.0f) * 3.1415927f;
            if (f2 != 0.0f) {
                float cos = (float) Math.cos(f2);
                float sin = (float) Math.sin(f2);
                colorMatrix.set(new float[]{((1.0f - 0.213f) * cos) + 0.213f + ((-0.213f) * sin), ((-0.715f) * cos) + 0.715f + ((-0.715f) * sin), ((-0.072f) * cos) + 0.072f + ((1.0f - 0.072f) * sin), 0.0f, 0.0f, ((-0.213f) * cos) + 0.213f + (0.143f * sin), ((1.0f - 0.715f) * cos) + 0.715f + (0.14f * sin), ((-0.072f) * cos) + 0.072f + ((-0.283f) * sin), 0.0f, 0.0f, ((-0.213f) * cos) + 0.213f + ((-(1.0f - 0.213f)) * sin), ((-0.715f) * cos) + 0.715f + (sin * 0.715f), ((1.0f - 0.072f) * cos) + 0.072f + (sin * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
            }
            return colorMatrix;
        }

        public static ColorMatrix adjustSaturation(float f) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(f / 100.0f);
            return colorMatrix;
        }

        public static ColorMatrix applyTint(int i) {
            float alpha = Color.alpha(i) / 255.0f;
            return new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(i) * alpha, 0.0f, 1.0f, 0.0f, 0.0f, Color.green(i) * alpha, 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(i) * alpha, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        }

        private static int clampValue(int i, int i2, int i3) {
            return Math.min(i3, Math.max(i2, i));
        }

        private static int getInt(String str, int i) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
                return i;
            }
        }

        public static ColorMatrix invertColors() {
            return new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        }

        public static boolean parseIconFilter(XmlPullParser xmlPullParser, Builder builder) throws IOException, XmlPullParserException {
            if (TAG_FILTER.equals(xmlPullParser.getName())) {
                int attributeCount = xmlPullParser.getAttributeCount();
                String str = null;
                while (true) {
                    int i = attributeCount - 1;
                    if (attributeCount <= 0) {
                        break;
                    } else if (xmlPullParser.getAttributeName(i).equals("name")) {
                        str = xmlPullParser.getAttributeValue(i);
                        attributeCount = i;
                    } else {
                        attributeCount = i;
                    }
                }
                String nextText = xmlPullParser.nextText();
                if (str == null || nextText == null || nextText.length() <= 0) {
                    return true;
                }
                String trim = nextText.trim();
                if (FILTER_HUE.equalsIgnoreCase(str)) {
                    builder.hue(clampValue(getInt(trim, 0), -180, 180));
                    return true;
                } else if (FILTER_SATURATION.equalsIgnoreCase(str)) {
                    builder.saturate(clampValue(getInt(trim, 100), 0, 200));
                    return true;
                } else if (FILTER_INVERT.equalsIgnoreCase(str)) {
                    if (fw.Code.equalsIgnoreCase(trim)) {
                        builder.invertColors();
                        return true;
                    }
                    return true;
                } else if (FILTER_BRIGHTNESS.equalsIgnoreCase(str)) {
                    builder.brightness(clampValue(getInt(trim, 100), 0, 200));
                    return true;
                } else if (FILTER_CONTRAST.equalsIgnoreCase(str)) {
                    builder.contrast(clampValue(getInt(trim, 0), -100, 100));
                    return true;
                } else if ("alpha".equalsIgnoreCase(str)) {
                    builder.alpha(clampValue(getInt(trim, 100), 0, 100));
                    return true;
                } else if (FILTER_TINT.equalsIgnoreCase(str)) {
                    try {
                        builder.tint(Color.parseColor(trim));
                        return true;
                    } catch (IllegalArgumentException e) {
                        Log.w(IconPackHelper.TAG, "Cannot apply tint, invalid argument: " + trim);
                        return true;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/IconPackHelper$IconCustomizer.class */
    public static class IconCustomizer {
        private static final Random sRandom = new Random();
        private static final IThemeService sThemeService = IThemeService.Stub.asInterface(ServiceManager.getService(Context.THEME_SERVICE));

        private static boolean cacheComposedIcon(Bitmap bitmap, String str) {
            try {
                return sThemeService.cacheComposedIcon(bitmap, str);
            } catch (RemoteException e) {
                Log.e(IconPackHelper.TAG, "Unable to cache icon.", e);
                return false;
            }
        }

        private static Bitmap createIconBitmap(Drawable drawable, Resources resources, int i, int i2, ComposedIconInfo composedIconInfo) {
            int i3;
            int i4;
            int i5;
            Drawable drawable2;
            Drawable drawable3;
            Drawable drawable4;
            if (composedIconInfo.iconSize <= 0) {
                return null;
            }
            Canvas canvas = new Canvas();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(1, 2));
            int i6 = 0;
            int i7 = 0;
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(composedIconInfo.iconSize);
                paintDrawable.setIntrinsicHeight(composedIconInfo.iconSize);
                i6 = composedIconInfo.iconSize;
                i7 = composedIconInfo.iconSize;
                i3 = 0;
            } else if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmap.getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
                }
                canvas.setDensity(bitmap.getDensity());
                if (bitmap.getWidth() >= composedIconInfo.iconSize * 2 || bitmap.getHeight() >= composedIconInfo.iconSize * 2) {
                    i4 = composedIconInfo.iconSize;
                    i5 = composedIconInfo.iconSize;
                } else {
                    i4 = bitmap.getWidth();
                    i5 = bitmap.getHeight();
                }
                i3 = 0;
                i7 = i5;
                i6 = i4;
                if (composedIconInfo.swatchType != ComposedIconInfo.SwatchType.None) {
                    Palette generate = Palette.generate(bitmap, 32);
                    switch (AnonymousClass1.$SwitchMap$android$app$ComposedIconInfo$SwatchType[composedIconInfo.swatchType.ordinal()]) {
                        case 1:
                            i3 = generate.getVibrantColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        case 2:
                            i3 = generate.getLightVibrantColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        case 3:
                            i3 = generate.getDarkVibrantColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        case 4:
                            i3 = generate.getMutedColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        case 5:
                            i3 = generate.getLightMutedColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        case 6:
                            i3 = generate.getDarkMutedColor(i2);
                            i7 = i5;
                            i6 = i4;
                            break;
                        default:
                            i3 = 0;
                            i7 = i5;
                            i6 = i4;
                            break;
                    }
                }
            } else {
                i3 = 0;
                if (drawable instanceof VectorDrawable) {
                    i7 = composedIconInfo.iconSize;
                    i6 = i7;
                    i3 = 0;
                }
            }
            if (i6 <= 0 || i7 <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            canvas.setBitmap(createBitmap);
            Rect rect = new Rect();
            rect.set(drawable.getBounds());
            drawable.setBounds(0, 0, i6, i7);
            canvas.save();
            float f = i6 / 2.0f;
            float f2 = i7 / 2.0f;
            float f3 = composedIconInfo.iconRotation;
            float f4 = f3;
            if (composedIconInfo.iconRotationVariance != 0.0f) {
                f4 = f3 + ((sRandom.nextFloat() * (composedIconInfo.iconRotationVariance * 2.0f)) - composedIconInfo.iconRotationVariance);
            }
            canvas.scale(composedIconInfo.iconScale, composedIconInfo.iconScale, f, f2);
            canvas.translate(composedIconInfo.iconTranslationX, composedIconInfo.iconTranslationY);
            canvas.rotate(f4, f, f2);
            if (composedIconInfo.colorFilter != null) {
                Paint paint = null;
                if (drawable instanceof BitmapDrawable) {
                    paint = ((BitmapDrawable) drawable).getPaint();
                } else if (drawable instanceof PaintDrawable) {
                    paint = ((PaintDrawable) drawable).getPaint();
                }
                if (paint != null) {
                    paint.setColorFilter(new ColorMatrixColorFilter(composedIconInfo.colorFilter));
                }
            }
            drawable.draw(canvas);
            canvas.restore();
            if (composedIconInfo.iconMask != 0 && (drawable4 = resources.getDrawable(composedIconInfo.iconMask)) != null) {
                drawable4.setBounds(drawable.getBounds());
                ((BitmapDrawable) drawable4).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                drawable4.draw(canvas);
            }
            if (i != 0 && (drawable3 = resources.getDrawable(i)) != null) {
                drawable3.setBounds(drawable.getBounds());
                Paint paint2 = ((BitmapDrawable) drawable3).getPaint();
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                if (i3 != 0) {
                    paint2.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.MULTIPLY));
                }
                drawable3.draw(canvas);
            }
            if (composedIconInfo.iconUpon != 0 && (drawable2 = resources.getDrawable(composedIconInfo.iconUpon)) != null) {
                drawable2.setBounds(drawable.getBounds());
                drawable2.draw(canvas);
            }
            drawable.setBounds(rect);
            createBitmap.setDensity(canvas.getDensity());
            return createBitmap;
        }

        private static String getCachedIconName(String str, int i, int i2) {
            return String.format("%s_%08x_%d.png", str, Integer.valueOf(i), Integer.valueOf(i2));
        }

        private static String getCachedIconPath(String str, int i, int i2) {
            return String.format("%s/%s", ThemeUtils.SYSTEM_THEME_ICON_CACHE_DIR, getCachedIconName(str, i, i2));
        }

        public static Drawable getComposedIconDrawable(Drawable drawable, Context context, ComposedIconInfo composedIconInfo) {
            return getComposedIconDrawable(drawable, context.getResources(), composedIconInfo);
        }

        public static Drawable getComposedIconDrawable(Drawable drawable, Resources resources, ComposedIconInfo composedIconInfo) {
            int i;
            int i2;
            if (composedIconInfo == null) {
                return drawable;
            }
            if (composedIconInfo.swatchType != ComposedIconInfo.SwatchType.None) {
                int i3 = composedIconInfo.iconPaletteBack;
                i = i3;
                i2 = 0;
                if (composedIconInfo.defaultSwatchColors.length > 0) {
                    i2 = composedIconInfo.defaultSwatchColors[sRandom.nextInt(composedIconInfo.defaultSwatchColors.length)];
                    i = i3;
                }
            } else {
                i = 0;
                i2 = 0;
                if (composedIconInfo.iconBacks != null) {
                    i = 0;
                    i2 = 0;
                    if (composedIconInfo.iconBacks.length > 0) {
                        i = composedIconInfo.iconBacks[sRandom.nextInt(composedIconInfo.iconBacks.length)];
                        i2 = 0;
                    }
                }
            }
            Bitmap createIconBitmap = createIconBitmap(drawable, resources, i, i2, composedIconInfo);
            return createIconBitmap != null ? new BitmapDrawable(resources, createIconBitmap) : null;
        }

        public static void getValue(Resources resources, int i, TypedValue typedValue, Drawable drawable) {
            int i2;
            int i3;
            String appName = resources.getAssets().getAppName();
            ComposedIconInfo composedIconInfo = resources.getComposedIconInfo();
            if (composedIconInfo == null) {
                return;
            }
            TypedValue typedValue2 = new TypedValue();
            typedValue2.setTo(typedValue);
            typedValue.assetCookie = 128;
            typedValue.data = (-2130706433) & i;
            typedValue.string = getCachedIconPath(appName, i, typedValue.density);
            int hashCode = typedValue.string.hashCode() & Integer.MAX_VALUE;
            if (new File(typedValue.string.toString()).exists()) {
                return;
            }
            if (composedIconInfo.swatchType != ComposedIconInfo.SwatchType.None) {
                int i4 = composedIconInfo.iconPaletteBack;
                i2 = i4;
                i3 = 0;
                if (composedIconInfo.defaultSwatchColors.length > 0) {
                    i3 = composedIconInfo.defaultSwatchColors[hashCode % composedIconInfo.defaultSwatchColors.length];
                    i2 = i4;
                }
            } else {
                i2 = 0;
                i3 = 0;
                if (composedIconInfo.iconBacks != null) {
                    i2 = 0;
                    i3 = 0;
                    if (composedIconInfo.iconBacks.length > 0) {
                        i2 = composedIconInfo.iconBacks[hashCode % composedIconInfo.iconBacks.length];
                        i3 = 0;
                    }
                }
            }
            if (cacheComposedIcon(createIconBitmap(drawable, resources, i2, i3, composedIconInfo), getCachedIconName(appName, i, typedValue.density))) {
                return;
            }
            Log.w(IconPackHelper.TAG, "Unable to cache icon " + ((Object) typedValue.string));
            typedValue.setTo(typedValue2);
        }
    }

    public IconPackHelper(Context context) {
        this.mContext = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.mComposedIconInfo = new ComposedIconInfo();
        this.mComposedIconInfo.iconSize = activityManager.getLauncherLargeIconSize();
        this.mComposedIconInfo.iconDensity = activityManager.getLauncherLargeIconDensity();
        this.mFilterBuilder = new ColorFilterUtils.Builder();
    }

    public static Resources createIconResource(Context context, String str) throws PackageManager.NameNotFoundException {
        String str2;
        String str3;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        String str4 = packageInfo.applicationInfo.publicSourceDir;
        if (packageInfo.isLegacyIconPackApk) {
            str3 = "";
            str2 = "";
        } else {
            str2 = ThemeUtils.ICONS_PATH;
            String iconPackApkPath = ThemeUtils.getIconPackApkPath(str);
            ThemeUtils.getIconPackResPath(str);
            str3 = iconPackApkPath;
        }
        AssetManager assetManager = new AssetManager();
        assetManager.addIconPath(str4, str3, str2, 98);
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    private int getResourceIdForDrawable(String str) {
        return this.mLoadedIconPackResource.getIdentifier(str, i.f5112c, this.mLoadedIconPackName);
    }

    private int getResourceIdForName(ComponentName componentName) {
        String str = this.mIconPackResourceMap.get(componentName);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return getResourceIdForDrawable(str);
    }

    private boolean isComposedIconComponent(String str) {
        return ICON_MASK_TAG.equalsIgnoreCase(str) || ICON_BACK_TAG.equalsIgnoreCase(str) || ICON_UPON_TAG.equalsIgnoreCase(str) || ICON_PALETTIZED_BACK_TAG.equalsIgnoreCase(str);
    }

    private void loadComposedIconComponents() {
        this.mComposedIconInfo.iconMask = getResourceIdForName(ICON_MASK_COMPONENT);
        this.mComposedIconInfo.iconUpon = getResourceIdForName(ICON_UPON_COMPONENT);
        if (this.mIconBackCount > 0) {
            this.mComposedIconInfo.iconBacks = new int[this.mIconBackCount];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mIconBackCount) {
                    break;
                }
                this.mComposedIconInfo.iconBacks[i2] = getResourceIdForName(new ComponentName(String.format(ICON_BACK_FORMAT, Integer.valueOf(i2)), ""));
                i = i2 + 1;
            }
        }
        String str = this.mIconPackResourceMap.get(ICON_SCALE_COMPONENT);
        if (str == null) {
            this.mComposedIconInfo.iconScale = 1.0f;
            return;
        }
        try {
            this.mComposedIconInfo.iconScale = Float.valueOf(str).floatValue();
        } catch (NumberFormatException e) {
            this.mComposedIconInfo.iconScale = 1.0f;
        }
    }

    private void loadResourcesFromXmlParser(XmlPullParser xmlPullParser, Map<ComponentName, String> map) throws XmlPullParserException, IOException {
        int next;
        this.mIconBackCount = 0;
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2 && !parseComposedIconComponent(xmlPullParser, map) && !ColorFilterUtils.parseIconFilter(xmlPullParser, this.mFilterBuilder)) {
                if (xmlPullParser.getName().equalsIgnoreCase("scale")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "factor");
                    String str = attributeValue;
                    if (attributeValue == null) {
                        str = attributeValue;
                        if (xmlPullParser.getAttributeCount() == 1) {
                            str = xmlPullParser.getAttributeValue(0);
                        }
                    }
                    map.put(ICON_SCALE_COMPONENT, str);
                } else if (!parseRotationComponent(xmlPullParser, this.mComposedIconInfo) && !parseTranslationComponent(xmlPullParser, this.mComposedIconInfo) && xmlPullParser.getName().equalsIgnoreCase("item")) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, CardEmulation.EXTRA_SERVICE_COMPONENT);
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, i.f5112c);
                    if (!TextUtils.isEmpty(attributeValue2) && !TextUtils.isEmpty(attributeValue3) && attributeValue2.startsWith("ComponentInfo{") && attributeValue2.endsWith("}") && attributeValue2.length() >= 16 && attributeValue3.length() != 0) {
                        String lowerCase = attributeValue2.substring(14, attributeValue2.length() - 1).toLowerCase();
                        ComponentName componentName = !lowerCase.contains("/") ? new ComponentName(lowerCase.toLowerCase(), "") : ComponentName.unflattenFromString(lowerCase);
                        if (componentName != null) {
                            map.put(componentName, attributeValue3);
                        }
                    }
                }
            }
            next = xmlPullParser.next();
            eventType = next;
        } while (next != 1);
    }

    private boolean parseComposedIconComponent(XmlPullParser xmlPullParser, Map<ComponentName, String> map) {
        String name = xmlPullParser.getName();
        if (!isComposedIconComponent(name) || xmlPullParser.getAttributeCount() < 1) {
            return false;
        }
        if (!ICON_BACK_TAG.equalsIgnoreCase(name)) {
            if (ICON_PALETTIZED_BACK_TAG.equalsIgnoreCase(name)) {
                parsePalettizedBackground(xmlPullParser, this.mComposedIconInfo);
                return true;
            }
            map.put(new ComponentName(name, ""), xmlPullParser.getAttributeValue(0));
            return true;
        }
        this.mIconBackCount = xmlPullParser.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mIconBackCount) {
                return true;
            }
            map.put(new ComponentName(String.format(ICON_BACK_FORMAT, Integer.valueOf(i2)), ""), xmlPullParser.getAttributeValue(i2));
            i = i2 + 1;
        }
    }

    private void parsePalettizedBackground(XmlPullParser xmlPullParser, ComposedIconInfo composedIconInfo) {
        int attributeCount = xmlPullParser.getAttributeCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                return;
            }
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            if (TextUtils.isEmpty(attributeName)) {
                Log.w(TAG, "Attribute name cannot be empty or null");
            } else if (TextUtils.isEmpty(attributeValue)) {
                Log.w(TAG, "Attribute value cannot be empty or null");
            } else {
                if ("img".equalsIgnoreCase(attributeName)) {
                    composedIconInfo.iconPaletteBack = getResourceIdForDrawable(attributeValue);
                } else if (SWATCH_TYPE_ATTR.equalsIgnoreCase(attributeName)) {
                    ComposedIconInfo.SwatchType swatchType = ComposedIconInfo.SwatchType.None;
                    if (VIBRANT_VALUE.equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.Vibrant;
                    } else if (VIBRANT_LIGHT_VALUE.equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.VibrantLight;
                    } else if (VIBRANT_DARK_VALUE.equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.VibrantDark;
                    } else if ("muted".equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.Muted;
                    } else if (MUTED_LIGHT_VALUE.equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.MutedLight;
                    } else if (MUTED_DARK_VALUE.equalsIgnoreCase(attributeValue)) {
                        swatchType = ComposedIconInfo.SwatchType.MutedDark;
                    }
                    if (swatchType != ComposedIconInfo.SwatchType.None) {
                        composedIconInfo.swatchType = swatchType;
                    }
                } else if (attributeName.startsWith(DEFAULT_SWATCH_COLOR_ATTR)) {
                    try {
                        arrayList.add(Integer.valueOf(Color.parseColor(attributeValue) | (-16777216)));
                    } catch (IllegalArgumentException e) {
                        Log.w(TAG, "Invalid color format", e);
                    }
                }
                if (arrayList.size() > 0) {
                    composedIconInfo.defaultSwatchColors = new int[arrayList.size()];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < arrayList.size()) {
                            composedIconInfo.defaultSwatchColors[i4] = ((Integer) arrayList.get(i4)).intValue();
                            i3 = i4 + 1;
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private boolean parseRotationComponent(XmlPullParser xmlPullParser, ComposedIconInfo composedIconInfo) {
        if (xmlPullParser.getName().equalsIgnoreCase(ICON_ROTATE_TAG)) {
            String attributeValue = xmlPullParser.getAttributeValue(null, ANGLE_ATTR);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, ANGLE_VARIANCE);
            if (attributeValue != null) {
                try {
                    composedIconInfo.iconRotation = Float.valueOf(attributeValue).floatValue();
                } catch (NumberFormatException e) {
                    Log.w(TAG, "Error parsing angle", e);
                }
            }
            if (attributeValue2 != null) {
                try {
                    composedIconInfo.iconRotationVariance = Float.valueOf(attributeValue2).floatValue();
                    return true;
                } catch (NumberFormatException e2) {
                    Log.w(TAG, "Error parsing plusMinus", e2);
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    private boolean parseTranslationComponent(XmlPullParser xmlPullParser, ComposedIconInfo composedIconInfo) {
        if (xmlPullParser.getName().equalsIgnoreCase(ICON_TRANSLATE_TAG)) {
            float f = this.mContext.getResources().getDisplayMetrics().density;
            String attributeValue = xmlPullParser.getAttributeValue(null, TRANSLATE_X_ATTR);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, TRANSLATE_Y_ATTR);
            if (attributeValue != null) {
                try {
                    composedIconInfo.iconTranslationX = Float.valueOf(attributeValue).floatValue() * f;
                } catch (NumberFormatException e) {
                    Log.w(TAG, "Error parsing xOffset", e);
                }
            }
            if (attributeValue2 != null) {
                try {
                    composedIconInfo.iconTranslationY = Float.valueOf(attributeValue2).floatValue() * f;
                    return true;
                } catch (NumberFormatException e2) {
                    Log.w(TAG, "Error parsing yOffset", e2);
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean shouldComposeIcon(ComposedIconInfo composedIconInfo) {
        if (composedIconInfo != null) {
            return (composedIconInfo.iconBacks == null && composedIconInfo.iconMask == 0 && composedIconInfo.iconUpon == 0 && composedIconInfo.colorFilter == null && composedIconInfo.iconPaletteBack == 0 && composedIconInfo.iconRotation == 0.0f && composedIconInfo.iconRotationVariance == 0.0f && composedIconInfo.iconTranslationX == 0.0f && composedIconInfo.iconTranslationY == 0.0f && composedIconInfo.iconScale == 1.0f) ? false : true;
        }
        return false;
    }

    public ComposedIconInfo getComposedIconInfo() {
        return this.mComposedIconInfo;
    }

    public Drawable getDrawableForActivity(ActivityInfo activityInfo) {
        int resourceIdForActivityIcon = getResourceIdForActivityIcon(activityInfo);
        if (resourceIdForActivityIcon == 0) {
            return null;
        }
        return this.mLoadedIconPackResource.getDrawable(resourceIdForActivityIcon, null, false);
    }

    public Drawable getDrawableForActivityWithDensity(ActivityInfo activityInfo, int i) {
        int resourceIdForActivityIcon = getResourceIdForActivityIcon(activityInfo);
        if (resourceIdForActivityIcon == 0) {
            return null;
        }
        return this.mLoadedIconPackResource.getDrawableForDensity(resourceIdForActivityIcon, i, null, false);
    }

    public Map<ComponentName, String> getIconResMapFromXml(Resources resources, String str) {
        InputStream inputStream;
        String substring;
        InputStream inputStream2 = null;
        HashMap hashMap = new HashMap();
        XmlResourceParser xmlResourceParser = null;
        try {
            inputStream = resources.getAssets().open("appfilter.xml");
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            inputStream2 = inputStream;
            xmlResourceParser = newPullParser;
            newPullParser.setInput(inputStream, "UTF-8");
            xmlResourceParser = newPullParser;
        } catch (Exception e) {
            int identifier = resources.getIdentifier("appfilter", "xml", str);
            inputStream = inputStream2;
            if (identifier != 0) {
                xmlResourceParser = resources.getXml(identifier);
                inputStream = inputStream2;
            }
        }
        try {
            if (xmlResourceParser != null) {
                try {
                    try {
                        loadResourcesFromXmlParser(xmlResourceParser, hashMap);
                        if (xmlResourceParser instanceof XmlResourceParser) {
                            xmlResourceParser.close();
                        } else if (inputStream != null) {
                            try {
                                inputStream.close();
                                return hashMap;
                            } catch (IOException e2) {
                                return hashMap;
                            }
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        if (xmlResourceParser instanceof XmlResourceParser) {
                            xmlResourceParser.close();
                        } else if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                } catch (XmlPullParserException e5) {
                    e5.printStackTrace();
                    if (xmlResourceParser instanceof XmlResourceParser) {
                        xmlResourceParser.close();
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                }
                return hashMap;
            }
            int identifier2 = resources.getIdentifier("theme_iconpack", "array", str);
            int i = identifier2;
            if (identifier2 == 0) {
                i = resources.getIdentifier("icon_pack", "array", str);
            }
            if (i != 0) {
                String[] stringArray = resources.getStringArray(i);
                int length = stringArray.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    String str2 = stringArray[i3];
                    if (!TextUtils.isEmpty(str2)) {
                        String replaceAll = str2.replaceAll("_", ".");
                        hashMap.put(new ComponentName(replaceAll.toLowerCase(), ""), str2);
                        int lastIndexOf = replaceAll.lastIndexOf(".");
                        if (lastIndexOf > 0 && lastIndexOf != replaceAll.length() - 1) {
                            String substring2 = replaceAll.substring(0, lastIndexOf);
                            if (!TextUtils.isEmpty(substring2)) {
                                if (!TextUtils.isEmpty(replaceAll.substring(lastIndexOf + 1))) {
                                    String lowerCase = substring2.toLowerCase();
                                    hashMap.put(new ComponentName(lowerCase, lowerCase + "." + substring.toLowerCase()), str2);
                                }
                            }
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            return hashMap;
        } catch (Throwable th) {
            if (xmlResourceParser instanceof XmlResourceParser) {
                xmlResourceParser.close();
            } else if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (r0 == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getResourceIdForActivityIcon(android.content.pm.ActivityInfo r6) {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.isIconPackLoaded()
            if (r0 != 0) goto Lb
            r0 = 0
            r7 = r0
        L9:
            r0 = r7
            return r0
        Lb:
            android.content.ComponentName r0 = new android.content.ComponentName
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.packageName
            java.lang.String r2 = r2.toLowerCase()
            r3 = r6
            java.lang.String r3 = r3.name
            java.lang.String r3 = r3.toLowerCase()
            r1.<init>(r2, r3)
            r9 = r0
            r0 = r5
            java.util.Map<android.content.ComponentName, java.lang.String> r0 = r0.mIconPackResourceMap
            r1 = r9
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L44
            r0 = r5
            r1 = r9
            int r0 = r0.getResourceIdForDrawable(r1)
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L9
        L44:
            android.content.ComponentName r0 = new android.content.ComponentName
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.packageName
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = ""
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r5
            java.util.Map<android.content.ComponentName, java.lang.String> r0 = r0.mIconPackResourceMap
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L69
            r0 = 0
            return r0
        L69:
            r0 = r5
            r1 = r6
            int r0 = r0.getResourceIdForDrawable(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.IconPackHelper.getResourceIdForActivityIcon(android.content.pm.ActivityInfo):int");
    }

    public int getResourceIdForApp(String str) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.packageName = str;
        activityInfo.name = "";
        return getResourceIdForActivityIcon(activityInfo);
    }

    boolean isIconPackLoaded() {
        return (this.mLoadedIconPackResource == null || this.mLoadedIconPackName == null || this.mIconPackResourceMap == null) ? false : true;
    }

    public void loadIconPack(String str) throws PackageManager.NameNotFoundException {
        if (str != null) {
            this.mIconBackCount = 0;
            Resources createIconResource = createIconResource(this.mContext, str);
            this.mLoadedIconPackResource = createIconResource;
            this.mLoadedIconPackName = str;
            this.mIconPackResourceMap = getIconResMapFromXml(createIconResource, str);
            loadComposedIconComponents();
            ColorMatrix build = this.mFilterBuilder.build();
            if (build != null) {
                this.mComposedIconInfo.colorFilter = (float[]) build.getArray().clone();
                return;
            }
            return;
        }
        this.mLoadedIconPackResource = null;
        this.mLoadedIconPackName = null;
        this.mComposedIconInfo.iconBacks = null;
        ComposedIconInfo composedIconInfo = this.mComposedIconInfo;
        this.mComposedIconInfo.iconUpon = 0;
        composedIconInfo.iconMask = 0;
        this.mComposedIconInfo.iconScale = 0.0f;
        this.mComposedIconInfo.iconRotation = 0.0f;
        this.mComposedIconInfo.iconTranslationX = 0.0f;
        this.mComposedIconInfo.iconTranslationY = 0.0f;
        this.mComposedIconInfo.colorFilter = null;
        this.mComposedIconInfo.iconPaletteBack = 0;
        this.mComposedIconInfo.swatchType = ComposedIconInfo.SwatchType.None;
    }
}
