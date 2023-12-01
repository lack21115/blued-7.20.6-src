package android.view.animation;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/BaseInterpolator.class */
public abstract class BaseInterpolator implements Interpolator {
    private int mChangingConfiguration;

    public int getChangingConfiguration() {
        return this.mChangingConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChangingConfiguration(int i) {
        this.mChangingConfiguration = i;
    }
}
