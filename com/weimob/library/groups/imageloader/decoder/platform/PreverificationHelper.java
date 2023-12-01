package com.weimob.library.groups.imageloader.decoder.platform;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/decoder/platform/PreverificationHelper.class */
class PreverificationHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
