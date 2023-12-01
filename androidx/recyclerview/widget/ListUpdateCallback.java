package androidx.recyclerview.widget;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ListUpdateCallback.class */
public interface ListUpdateCallback {
    void onChanged(int i, int i2, Object obj);

    void onInserted(int i, int i2);

    void onMoved(int i, int i2);

    void onRemoved(int i, int i2);
}
