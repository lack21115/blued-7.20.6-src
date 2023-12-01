package android.content;

/* loaded from: source-9557208-dex2jar.jar:android/content/UndoOwner.class */
public class UndoOwner {
    Object mData;
    UndoManager mManager;
    int mOpCount;
    int mSavedIdx;
    int mStateSeq;
    final String mTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UndoOwner(String str) {
        this.mTag = str;
    }

    public Object getData() {
        return this.mData;
    }

    public String getTag() {
        return this.mTag;
    }
}
