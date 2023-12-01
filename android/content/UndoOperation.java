package android.content;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/content/UndoOperation.class */
public abstract class UndoOperation<DATA> implements Parcelable {
    UndoOwner mOwner;

    public UndoOperation(UndoOwner undoOwner) {
        this.mOwner = undoOwner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UndoOperation(Parcel parcel, ClassLoader classLoader) {
    }

    public boolean allowMerge() {
        return true;
    }

    public abstract void commit();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UndoOwner getOwner() {
        return this.mOwner;
    }

    public DATA getOwnerData() {
        return (DATA) this.mOwner.getData();
    }

    public boolean hasData() {
        return true;
    }

    public boolean matchOwner(UndoOwner undoOwner) {
        return undoOwner == getOwner();
    }

    public abstract void redo();

    public abstract void undo();
}
