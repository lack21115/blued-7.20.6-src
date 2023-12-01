package android.media.effect;

import android.filterfw.core.Frame;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/SizeChangeEffect.class */
public class SizeChangeEffect extends SingleFilterEffect {
    public SizeChangeEffect(EffectContext effectContext, String str, Class cls, String str2, String str3, Object... objArr) {
        super(effectContext, str, cls, str2, str3, objArr);
    }

    @Override // android.media.effect.SingleFilterEffect, android.media.effect.Effect
    public void apply(int i, int i2, int i3, int i4) {
        beginGLEffect();
        Frame frameFromTexture = frameFromTexture(i, i2, i3);
        Frame executeWithArgList = this.mFunction.executeWithArgList(this.mInputName, frameFromTexture);
        Frame frameFromTexture2 = frameFromTexture(i4, executeWithArgList.getFormat().getWidth(), executeWithArgList.getFormat().getHeight());
        frameFromTexture2.setDataFromFrame(executeWithArgList);
        frameFromTexture.release();
        frameFromTexture2.release();
        executeWithArgList.release();
        endGLEffect();
    }
}
