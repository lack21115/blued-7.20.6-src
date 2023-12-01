package com.tencent.ugc;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoFrame.class */
public class UGCVideoFrame extends PixelFrame {
    private boolean isEosFrame;

    public boolean isEosFrame() {
        return this.isEosFrame;
    }

    public void setEosFrame(boolean z) {
        this.isEosFrame = z;
    }
}
