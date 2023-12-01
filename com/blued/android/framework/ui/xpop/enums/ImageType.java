package com.blued.android.framework.ui.xpop.enums;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/enums/ImageType.class */
public enum ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);
    
    private final boolean i;

    ImageType(boolean z) {
        this.i = z;
    }
}
