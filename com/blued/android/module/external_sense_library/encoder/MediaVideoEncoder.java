package com.blued.android.module.external_sense_library.encoder;

import android.view.Surface;
import com.blued.android.module.external_sense_library.encoder.utils.RenderHandler;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaVideoEncoder.class */
public class MediaVideoEncoder extends MediaEncoder {
    protected static int[] j = {2130708361};
    private RenderHandler k;
    private Surface l;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.external_sense_library.encoder.MediaEncoder
    public void a() {
        Surface surface = this.l;
        if (surface != null) {
            surface.release();
            this.l = null;
        }
        RenderHandler renderHandler = this.k;
        if (renderHandler != null) {
            renderHandler.a();
            this.k = null;
        }
        super.a();
    }

    @Override // com.blued.android.module.external_sense_library.encoder.MediaEncoder
    public boolean c() {
        boolean c = super.c();
        if (c) {
            this.k.a(null);
        }
        return c;
    }

    @Override // com.blued.android.module.external_sense_library.encoder.MediaEncoder
    protected void d() {
        this.g.signalEndOfInputStream();
        this.d = true;
    }
}
