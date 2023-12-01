package android.content;

/* loaded from: source-9557208-dex2jar.jar:android/content/MutableContextWrapper.class */
public class MutableContextWrapper extends ContextWrapper {
    public MutableContextWrapper(Context context) {
        super(context);
    }

    public void setBaseContext(Context context) {
        this.mBase = context;
    }
}
