package android.graphics;

import android.graphics.Shader;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/BitmapShader.class */
public class BitmapShader extends Shader {
    public final Bitmap mBitmap;
    private Shader.TileMode mTileX;
    private Shader.TileMode mTileY;

    public BitmapShader(Bitmap bitmap, Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        this.mBitmap = bitmap;
        this.mTileX = tileMode;
        this.mTileY = tileMode2;
        init(nativeCreate(bitmap.ni(), tileMode.nativeInt, tileMode2.nativeInt));
    }

    private static native long nativeCreate(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.Shader
    public Shader copy() {
        BitmapShader bitmapShader = new BitmapShader(this.mBitmap, this.mTileX, this.mTileY);
        copyLocalMatrix(bitmapShader);
        return bitmapShader;
    }
}
