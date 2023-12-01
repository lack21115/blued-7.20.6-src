package android.graphics;

import android.graphics.PorterDuff;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/ComposeShader.class */
public class ComposeShader extends Shader {
    private static final int TYPE_PORTERDUFFMODE = 2;
    private static final int TYPE_XFERMODE = 1;
    private PorterDuff.Mode mPorterDuffMode;
    private final Shader mShaderA;
    private final Shader mShaderB;
    private int mType = 2;
    private Xfermode mXferMode;

    public ComposeShader(Shader shader, Shader shader2, PorterDuff.Mode mode) {
        this.mShaderA = shader;
        this.mShaderB = shader2;
        this.mPorterDuffMode = mode;
        init(nativeCreate2(shader.getNativeInstance(), shader2.getNativeInstance(), mode.nativeInt));
    }

    public ComposeShader(Shader shader, Shader shader2, Xfermode xfermode) {
        this.mShaderA = shader;
        this.mShaderB = shader2;
        this.mXferMode = xfermode;
        init(nativeCreate1(shader.getNativeInstance(), shader2.getNativeInstance(), xfermode != null ? xfermode.native_instance : 0L));
    }

    private static native long nativeCreate1(long j, long j2, long j3);

    private static native long nativeCreate2(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.Shader
    public Shader copy() {
        ComposeShader composeShader;
        switch (this.mType) {
            case 1:
                composeShader = new ComposeShader(this.mShaderA.copy(), this.mShaderB.copy(), this.mXferMode);
                break;
            case 2:
                composeShader = new ComposeShader(this.mShaderA.copy(), this.mShaderB.copy(), this.mPorterDuffMode);
                break;
            default:
                throw new IllegalArgumentException("ComposeShader should be created with either Xfermode or PorterDuffMode");
        }
        copyLocalMatrix(composeShader);
        return composeShader;
    }
}
