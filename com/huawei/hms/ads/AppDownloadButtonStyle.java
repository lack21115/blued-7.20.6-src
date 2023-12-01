package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButtonStyle.class */
public class AppDownloadButtonStyle {
    protected Style normalStyle = new Style();
    protected Style processingStyle = new Style();
    protected Style installingStyle = new Style();

    /* renamed from: com.huawei.hms.ads.AppDownloadButtonStyle$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButtonStyle$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[AppDownloadStatus.values().length];
            Code = iArr;
            try {
                iArr[AppDownloadStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[AppDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[AppDownloadStatus.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[AppDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[AppDownloadStatus.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[AppDownloadStatus.INSTALL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButtonStyle$Style.class */
    public static class Style {
        protected Drawable background;
        protected int textColor;
        protected int textSize = 12;
        protected Typeface tf;

        public Drawable getBackground() {
            return this.background;
        }

        public int getTextColor() {
            return this.textColor;
        }

        public int getTextSize() {
            return this.textSize;
        }

        public Typeface getTypeface() {
            return this.tf;
        }

        public void setBackground(Drawable drawable) {
            this.background = drawable;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }

        public void setTextSize(int i) {
            this.textSize = i;
        }

        public void setTypeface(Typeface typeface) {
            this.tf = typeface;
        }
    }

    public AppDownloadButtonStyle(Context context) {
        this.normalStyle.background = context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal);
        this.normalStyle.textColor = context.getResources().getColor(R.color.hiad_down_normal_text);
        this.processingStyle.setBackground(Code(context, R.drawable.hiad_app_down_btn_processing));
        this.processingStyle.setTextColor(context.getResources().getColor(R.color.hiad_app_down_processing_text));
        this.installingStyle.setBackground(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_installing));
        this.installingStyle.setTextColor(context.getResources().getColor(R.color.hiad_app_down_installing_text));
    }

    protected Drawable Code(Context context, int i) {
        Drawable drawable = context.getResources().getDrawable(i);
        if (Build.VERSION.SDK_INT >= 23 && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    public Style Code() {
        return this.normalStyle;
    }

    public Style getStyle(Context context, AppDownloadStatus appDownloadStatus) {
        int i = AnonymousClass1.Code[appDownloadStatus.ordinal()];
        return (i == 1 || i == 2) ? this.processingStyle : i != 3 ? Code() : this.installingStyle;
    }
}
