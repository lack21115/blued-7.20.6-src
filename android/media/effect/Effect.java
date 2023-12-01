package android.media.effect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/Effect.class */
public abstract class Effect {
    public abstract void apply(int i, int i2, int i3, int i4);

    public abstract String getName();

    public abstract void release();

    public abstract void setParameter(String str, Object obj);

    public void setUpdateListener(EffectUpdateListener effectUpdateListener) {
    }
}
