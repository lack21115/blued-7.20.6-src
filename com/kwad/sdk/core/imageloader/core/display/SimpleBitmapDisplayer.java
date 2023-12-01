package com.kwad.sdk.core.imageloader.core.display;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/display/SimpleBitmapDisplayer.class */
public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public final void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(decodedResult.mBitmap);
    }
}
