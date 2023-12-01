package android.text.style;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/ImageSpan.class */
public class ImageSpan extends DynamicDrawableSpan {
    private Uri mContentUri;
    private Context mContext;
    private Drawable mDrawable;
    private int mResourceId;
    private String mSource;

    public ImageSpan(Context context, int i) {
        this(context, i, 0);
    }

    public ImageSpan(Context context, int i, int i2) {
        super(i2);
        this.mContext = context;
        this.mResourceId = i;
    }

    public ImageSpan(Context context, Bitmap bitmap) {
        this(context, bitmap, 0);
    }

    public ImageSpan(Context context, Bitmap bitmap, int i) {
        super(i);
        this.mContext = context;
        this.mDrawable = context != null ? new BitmapDrawable(context.getResources(), bitmap) : new BitmapDrawable(bitmap);
        int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        this.mDrawable.setBounds(0, 0, intrinsicWidth <= 0 ? 0 : intrinsicWidth, intrinsicHeight <= 0 ? 0 : intrinsicHeight);
    }

    public ImageSpan(Context context, Uri uri) {
        this(context, uri, 0);
    }

    public ImageSpan(Context context, Uri uri, int i) {
        super(i);
        this.mContext = context;
        this.mContentUri = uri;
        this.mSource = uri.toString();
    }

    @Deprecated
    public ImageSpan(Bitmap bitmap) {
        this((Context) null, bitmap, 0);
    }

    @Deprecated
    public ImageSpan(Bitmap bitmap, int i) {
        this((Context) null, bitmap, i);
    }

    public ImageSpan(Drawable drawable) {
        this(drawable, 0);
    }

    public ImageSpan(Drawable drawable, int i) {
        super(i);
        this.mDrawable = drawable;
    }

    public ImageSpan(Drawable drawable, String str) {
        this(drawable, str, 0);
    }

    public ImageSpan(Drawable drawable, String str, int i) {
        super(i);
        this.mDrawable = drawable;
        this.mSource = str;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        BitmapDrawable bitmapDrawable = null;
        if (this.mDrawable != null) {
            return this.mDrawable;
        }
        if (this.mContentUri == null) {
            Drawable drawable = null;
            try {
                Drawable drawable2 = this.mContext.getDrawable(this.mResourceId);
                drawable = drawable2;
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                return drawable2;
            } catch (Exception e) {
                Log.e("sms", "Unable to find resource: " + this.mResourceId);
                return drawable;
            }
        }
        try {
            InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.mContentUri);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
            try {
                bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                openInputStream.close();
                return bitmapDrawable2;
            } catch (Exception e2) {
                bitmapDrawable = bitmapDrawable2;
                e = e2;
                Log.e("sms", "Failed to loaded content " + this.mContentUri, e);
                return bitmapDrawable;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public String getSource() {
        return this.mSource;
    }
}
