package com.sobot.chat.widget.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/subscaleview/decoder/ImageDecoder.class */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
