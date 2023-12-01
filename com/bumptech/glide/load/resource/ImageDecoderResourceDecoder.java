package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/ImageDecoderResourceDecoder.class */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final HardwareConfigState f20930a = HardwareConfigState.a();

    protected abstract Resource<T> a(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource<T> a(ImageDecoder.Source source, final int i, final int i2, Options options) throws IOException {
        final DecodeFormat decodeFormat = (DecodeFormat) options.a(Downsampler.f20951a);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.a(DownsampleStrategy.h);
        final boolean z = options.a(Downsampler.e) != null && ((Boolean) options.a(Downsampler.e)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.a(Downsampler.b);
        return a(source, i, i2, new ImageDecoder.OnHeaderDecodedListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                if (ImageDecoderResourceDecoder.this.f20930a.a(i, i2, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                    @Override // android.graphics.ImageDecoder.OnPartialImageListener
                    public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i3 = i;
                int i4 = i3;
                if (i3 == Integer.MIN_VALUE) {
                    i4 = size.getWidth();
                }
                int i5 = i2;
                int i6 = i5;
                if (i5 == Integer.MIN_VALUE) {
                    i6 = size.getHeight();
                }
                float a2 = downsampleStrategy.a(size.getWidth(), size.getHeight(), i4, i6);
                int round = Math.round(size.getWidth() * a2);
                int round2 = Math.round(size.getHeight() * a2);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + a2);
                }
                imageDecoder.setTargetSize(round, round2);
                if (Build.VERSION.SDK_INT < 28) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                        return;
                    }
                    return;
                }
                boolean z2 = false;
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                    z2 = false;
                    if (imageInfo.getColorSpace() != null) {
                        z2 = false;
                        if (imageInfo.getColorSpace().isWideGamut()) {
                            z2 = true;
                        }
                    }
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z2 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        });
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(ImageDecoder.Source source, Options options) {
        return true;
    }
}
