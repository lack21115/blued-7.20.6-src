package android.content.res;

/* loaded from: source-259656-dex2jar.jar:android/content/res/XResForwarder.class */
public class XResForwarder {
    private final int id;
    private final Resources res;

    public XResForwarder(Resources resources, int i) {
        this.res = resources;
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public Resources getResources() {
        return this.res;
    }
}
