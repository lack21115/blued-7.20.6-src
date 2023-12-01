package com.sobot.chat.widget.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.widget.subscaleview.SobotScaleImageView;
import java.io.InputStream;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/subscaleview/decoder/SkiaImageDecoder.class */
public class SkiaImageDecoder implements ImageDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(Bitmap.Config config) {
        Bitmap.Config preferredBitmapConfig = SobotScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }

    @Override // com.sobot.chat.widget.subscaleview.decoder.ImageDecoder
    public Bitmap decode(Context context, Uri uri) throws Exception {
        InputStream inputStream;
        Bitmap decodeStream;
        int i;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.bitmapConfig;
        if (uri2.startsWith(RESOURCE_PREFIX)) {
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals(i.f5112c)) {
                i = resources.getIdentifier(pathSegments.get(1), i.f5112c, authority);
            } else {
                i = 0;
                if (size == 1) {
                    i = 0;
                    if (TextUtils.isDigitsOnly(pathSegments.get(0))) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException e) {
                            i = 0;
                        }
                    }
                }
            }
            decodeStream = BitmapFactory.decodeResource(context.getResources(), i, options);
        } else if (uri2.startsWith(ASSET_PREFIX)) {
            decodeStream = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(22)), null, options);
        } else if (uri2.startsWith(FILE_PREFIX)) {
            decodeStream = BitmapFactory.decodeFile(uri2.substring(7), options);
        } else {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                try {
                    decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        }
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    }
}
