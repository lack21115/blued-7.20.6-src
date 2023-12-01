package com.weimob.library.groups.imageloader.decoder.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/decoder/platform/OreoDecoder.class */
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
    }

    private static boolean hasColorGamutMismatch(BitmapFactory.Options options) {
        return (options.outColorSpace == null || !options.outColorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true;
    }

    @Override // com.weimob.library.groups.imageloader.decoder.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        return hasColorGamutMismatch(options) ? i * i2 * 8 : BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
    }
}
