package com.sobot.chat.widget.gif;

import android.graphics.Bitmap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifFrame.class */
public class GifFrame {
    public int delay;
    public Bitmap image;
    public GifFrame nextFrame = null;

    public GifFrame(Bitmap bitmap, int i) {
        this.image = bitmap;
        this.delay = i;
    }
}
