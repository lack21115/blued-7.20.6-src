package android.view.accessibility;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/CaptioningManager.class */
public class CaptioningManager {
    private static final int DEFAULT_ENABLED = 0;
    private static final float DEFAULT_FONT_SCALE = 1.0f;
    private static final int DEFAULT_PRESET = 0;
    private final ContentResolver mContentResolver;
    private final ArrayList<CaptioningChangeListener> mListeners = new ArrayList<>();
    private final Handler mHandler = new Handler();
    private final ContentObserver mContentObserver = new ContentObserver(this.mHandler) { // from class: android.view.accessibility.CaptioningManager.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            String path = uri.getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            if ("accessibility_captioning_enabled".equals(substring)) {
                CaptioningManager.this.notifyEnabledChanged();
            } else if ("accessibility_captioning_locale".equals(substring)) {
                CaptioningManager.this.notifyLocaleChanged();
            } else if ("accessibility_captioning_font_scale".equals(substring)) {
                CaptioningManager.this.notifyFontScaleChanged();
            } else {
                CaptioningManager.this.mHandler.removeCallbacks(CaptioningManager.this.mStyleChangedRunnable);
                CaptioningManager.this.mHandler.post(CaptioningManager.this.mStyleChangedRunnable);
            }
        }
    };
    private final Runnable mStyleChangedRunnable = new Runnable() { // from class: android.view.accessibility.CaptioningManager.2
        @Override // java.lang.Runnable
        public void run() {
            CaptioningManager.this.notifyUserStyleChanged();
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/CaptioningManager$CaptionStyle.class */
    public static final class CaptionStyle {
        private static final int COLOR_NONE_OPAQUE = 255;
        private static final int COLOR_UNSPECIFIED = 511;
        public static final int EDGE_TYPE_DEPRESSED = 4;
        public static final int EDGE_TYPE_DROP_SHADOW = 2;
        public static final int EDGE_TYPE_NONE = 0;
        public static final int EDGE_TYPE_OUTLINE = 1;
        public static final int EDGE_TYPE_RAISED = 3;
        public static final int EDGE_TYPE_UNSPECIFIED = -1;
        public static final int PRESET_CUSTOM = -1;
        public final int backgroundColor;
        public final int edgeColor;
        public final int edgeType;
        public final int foregroundColor;
        private final boolean mHasBackgroundColor;
        private final boolean mHasEdgeColor;
        private final boolean mHasEdgeType;
        private final boolean mHasForegroundColor;
        private final boolean mHasWindowColor;
        private Typeface mParsedTypeface;
        public final String mRawTypeface;
        public final int windowColor;
        private static final CaptionStyle WHITE_ON_BLACK = new CaptionStyle(-1, View.MEASURED_STATE_MASK, 0, View.MEASURED_STATE_MASK, 255, null);
        private static final CaptionStyle BLACK_ON_WHITE = new CaptionStyle(View.MEASURED_STATE_MASK, -1, 0, View.MEASURED_STATE_MASK, 255, null);
        private static final CaptionStyle YELLOW_ON_BLACK = new CaptionStyle(-256, View.MEASURED_STATE_MASK, 0, View.MEASURED_STATE_MASK, 255, null);
        private static final CaptionStyle YELLOW_ON_BLUE = new CaptionStyle(-256, -16776961, 0, View.MEASURED_STATE_MASK, 255, null);
        private static final CaptionStyle UNSPECIFIED = new CaptionStyle(511, 511, -1, 511, 511, null);
        public static final CaptionStyle[] PRESETS = {WHITE_ON_BLACK, BLACK_ON_WHITE, YELLOW_ON_BLACK, YELLOW_ON_BLUE, UNSPECIFIED};
        private static final CaptionStyle DEFAULT_CUSTOM = WHITE_ON_BLACK;
        public static final CaptionStyle DEFAULT = WHITE_ON_BLACK;

        private CaptionStyle(int i, int i2, int i3, int i4, int i5, String str) {
            this.mHasForegroundColor = i != 511;
            this.mHasBackgroundColor = i2 != 511;
            this.mHasEdgeType = i3 != -1;
            this.mHasEdgeColor = i4 != 511;
            this.mHasWindowColor = i5 != 511;
            this.foregroundColor = this.mHasForegroundColor ? i : -1;
            this.backgroundColor = this.mHasBackgroundColor ? i2 : -16777216;
            this.edgeType = this.mHasEdgeType ? i3 : 0;
            this.edgeColor = this.mHasEdgeColor ? i4 : -16777216;
            this.windowColor = this.mHasWindowColor ? i5 : 255;
            this.mRawTypeface = str;
        }

        public static CaptionStyle getCustomStyle(ContentResolver contentResolver) {
            CaptionStyle captionStyle = DEFAULT_CUSTOM;
            int i = Settings.Secure.getInt(contentResolver, "accessibility_captioning_foreground_color", captionStyle.foregroundColor);
            int i2 = Settings.Secure.getInt(contentResolver, "accessibility_captioning_background_color", captionStyle.backgroundColor);
            int i3 = Settings.Secure.getInt(contentResolver, "accessibility_captioning_edge_type", captionStyle.edgeType);
            int i4 = Settings.Secure.getInt(contentResolver, "accessibility_captioning_edge_color", captionStyle.edgeColor);
            int i5 = Settings.Secure.getInt(contentResolver, "accessibility_captioning_window_color", captionStyle.windowColor);
            String string = Settings.Secure.getString(contentResolver, "accessibility_captioning_typeface");
            String str = string;
            if (string == null) {
                str = captionStyle.mRawTypeface;
            }
            return new CaptionStyle(i, i2, i3, i4, i5, str);
        }

        public CaptionStyle applyStyle(CaptionStyle captionStyle) {
            return new CaptionStyle(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : this.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : this.backgroundColor, captionStyle.hasEdgeType() ? captionStyle.edgeType : this.edgeType, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : this.edgeColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : this.windowColor, captionStyle.mRawTypeface != null ? captionStyle.mRawTypeface : this.mRawTypeface);
        }

        public Typeface getTypeface() {
            if (this.mParsedTypeface == null && !TextUtils.isEmpty(this.mRawTypeface)) {
                this.mParsedTypeface = Typeface.create(this.mRawTypeface, 0);
            }
            return this.mParsedTypeface;
        }

        public boolean hasBackgroundColor() {
            return this.mHasBackgroundColor;
        }

        public boolean hasEdgeColor() {
            return this.mHasEdgeColor;
        }

        public boolean hasEdgeType() {
            return this.mHasEdgeType;
        }

        public boolean hasForegroundColor() {
            return this.mHasForegroundColor;
        }

        public boolean hasWindowColor() {
            return this.mHasWindowColor;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/CaptioningManager$CaptioningChangeListener.class */
    public static abstract class CaptioningChangeListener {
        public void onEnabledChanged(boolean z) {
        }

        public void onFontScaleChanged(float f) {
        }

        public void onLocaleChanged(Locale locale) {
        }

        public void onUserStyleChanged(CaptionStyle captionStyle) {
        }
    }

    public CaptioningManager(Context context) {
        this.mContentResolver = context.getContentResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEnabledChanged() {
        boolean isEnabled = isEnabled();
        synchronized (this.mListeners) {
            Iterator<CaptioningChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onEnabledChanged(isEnabled);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFontScaleChanged() {
        float fontScale = getFontScale();
        synchronized (this.mListeners) {
            Iterator<CaptioningChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onFontScaleChanged(fontScale);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLocaleChanged() {
        Locale locale = getLocale();
        synchronized (this.mListeners) {
            Iterator<CaptioningChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onLocaleChanged(locale);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUserStyleChanged() {
        CaptionStyle userStyle = getUserStyle();
        synchronized (this.mListeners) {
            Iterator<CaptioningChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onUserStyleChanged(userStyle);
            }
        }
    }

    private void registerObserver(String str) {
        this.mContentResolver.registerContentObserver(Settings.Secure.getUriFor(str), false, this.mContentObserver);
    }

    public void addCaptioningChangeListener(CaptioningChangeListener captioningChangeListener) {
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                registerObserver("accessibility_captioning_enabled");
                registerObserver("accessibility_captioning_foreground_color");
                registerObserver("accessibility_captioning_background_color");
                registerObserver("accessibility_captioning_window_color");
                registerObserver("accessibility_captioning_edge_type");
                registerObserver("accessibility_captioning_edge_color");
                registerObserver("accessibility_captioning_typeface");
                registerObserver("accessibility_captioning_font_scale");
                registerObserver("accessibility_captioning_locale");
                registerObserver("accessibility_captioning_preset");
            }
            this.mListeners.add(captioningChangeListener);
        }
    }

    public final float getFontScale() {
        return Settings.Secure.getFloat(this.mContentResolver, "accessibility_captioning_font_scale", 1.0f);
    }

    public final Locale getLocale() {
        String rawLocale = getRawLocale();
        if (TextUtils.isEmpty(rawLocale)) {
            return null;
        }
        String[] split = rawLocale.split(BridgeUtil.UNDERLINE_STR);
        switch (split.length) {
            case 1:
                return new Locale(split[0]);
            case 2:
                return new Locale(split[0], split[1]);
            case 3:
                return new Locale(split[0], split[1], split[2]);
            default:
                return null;
        }
    }

    public final String getRawLocale() {
        return Settings.Secure.getString(this.mContentResolver, "accessibility_captioning_locale");
    }

    public int getRawUserStyle() {
        return Settings.Secure.getInt(this.mContentResolver, "accessibility_captioning_preset", 0);
    }

    public CaptionStyle getUserStyle() {
        int rawUserStyle = getRawUserStyle();
        return rawUserStyle == -1 ? CaptionStyle.getCustomStyle(this.mContentResolver) : CaptionStyle.PRESETS[rawUserStyle];
    }

    public final boolean isEnabled() {
        return Settings.Secure.getInt(this.mContentResolver, "accessibility_captioning_enabled", 0) == 1;
    }

    public void removeCaptioningChangeListener(CaptioningChangeListener captioningChangeListener) {
        synchronized (this.mListeners) {
            this.mListeners.remove(captioningChangeListener);
            if (this.mListeners.isEmpty()) {
                this.mContentResolver.unregisterContentObserver(this.mContentObserver);
            }
        }
    }
}
