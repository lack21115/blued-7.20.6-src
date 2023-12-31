package com.weimob.library.groups.imageloader.decoder.platform;

import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/decoder/platform/ArtDecoder.class */
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
    }

    @Override // com.weimob.library.groups.imageloader.decoder.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        return BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
    }
}
