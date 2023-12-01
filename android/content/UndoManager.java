package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ParcelableParcel;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/content/UndoManager.class */
public class UndoManager {
    public static final int MERGE_MODE_ANY = 2;
    public static final int MERGE_MODE_NONE = 0;
    public static final int MERGE_MODE_UNIQUE = 1;
    private boolean mInUndo;
    private boolean mMerged;
    private int mNextSavedIdx;
    private UndoOwner[] mStateOwners;
    private int mStateSeq;
    private int mUpdateCount;
    private UndoState mWorking;
    private final HashMap<String, UndoOwner> mOwners = new HashMap<>();
    private final ArrayList<UndoState> mUndos = new ArrayList<>();
    private final ArrayList<UndoState> mRedos = new ArrayList<>();
    private int mHistorySize = 20;
    private int mCommitId = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/UndoManager$UndoState.class */
    public static final class UndoState {
        private boolean mCanMerge;
        private final int mCommitId;
        private boolean mExecuted;
        private CharSequence mLabel;
        private final UndoManager mManager;
        private final ArrayList<UndoOperation<?>> mOperations;
        private ArrayList<UndoOperation<?>> mRecent;

        UndoState(UndoManager undoManager, int i) {
            this.mOperations = new ArrayList<>();
            this.mCanMerge = true;
            this.mManager = undoManager;
            this.mCommitId = i;
        }

        UndoState(UndoManager undoManager, Parcel parcel, ClassLoader classLoader) {
            this.mOperations = new ArrayList<>();
            this.mCanMerge = true;
            this.mManager = undoManager;
            this.mCommitId = parcel.readInt();
            this.mCanMerge = parcel.readInt() != 0;
            this.mExecuted = parcel.readInt() != 0;
            this.mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return;
                }
                UndoOwner restoreOwner = this.mManager.restoreOwner(parcel);
                UndoOperation<?> undoOperation = (UndoOperation) parcel.readParcelable(classLoader);
                undoOperation.mOwner = restoreOwner;
                this.mOperations.add(undoOperation);
                i = i2 + 1;
            }
        }

        void addOperation(UndoOperation<?> undoOperation) {
            if (this.mOperations.contains(undoOperation)) {
                throw new IllegalStateException("Already holds " + undoOperation);
            }
            this.mOperations.add(undoOperation);
            if (this.mRecent == null) {
                this.mRecent = new ArrayList<>();
                this.mRecent.add(undoOperation);
            }
            undoOperation.mOwner.mOpCount++;
        }

        boolean canMerge() {
            return this.mCanMerge && !this.mExecuted;
        }

        void commit() {
            int size = this.mRecent != null ? this.mRecent.size() : 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.mRecent = null;
                    return;
                } else {
                    this.mRecent.get(i2).commit();
                    i = i2 + 1;
                }
            }
        }

        int countOperations() {
            return this.mOperations.size();
        }

        void destroy() {
            int size = this.mOperations.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                UndoOwner undoOwner = this.mOperations.get(i).mOwner;
                undoOwner.mOpCount--;
                if (undoOwner.mOpCount <= 0) {
                    if (undoOwner.mOpCount < 0) {
                        throw new IllegalStateException("Underflow of op count on owner " + undoOwner + " in op " + this.mOperations.get(i));
                    }
                    this.mManager.removeOwner(undoOwner);
                }
                size = i;
            }
        }

        int getCommitId() {
            return this.mCommitId;
        }

        CharSequence getLabel() {
            return this.mLabel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
            if (r0.getClass() == r5) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        <T extends android.content.UndoOperation> T getLastOperation(java.lang.Class<T> r5, android.content.UndoOwner r6) {
            /*
                r4 = this;
                r0 = 0
                r9 = r0
                r0 = r4
                java.util.ArrayList<android.content.UndoOperation<?>> r0 = r0.mOperations
                int r0 = r0.size()
                r7 = r0
                r0 = r5
                if (r0 != 0) goto L2d
                r0 = r6
                if (r0 != 0) goto L2d
                r0 = r9
                r8 = r0
                r0 = r7
                if (r0 <= 0) goto L2a
                r0 = r4
                java.util.ArrayList<android.content.UndoOperation<?>> r0 = r0.mOperations
                r1 = r7
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object r0 = r0.get(r1)
                android.content.UndoOperation r0 = (android.content.UndoOperation) r0
                r8 = r0
            L2a:
                r0 = r8
                return r0
            L2d:
                r0 = r7
                r1 = 1
                int r0 = r0 - r1
                r7 = r0
            L31:
                r0 = r9
                r8 = r0
                r0 = r7
                if (r0 < 0) goto L2a
                r0 = r4
                java.util.ArrayList<android.content.UndoOperation<?>> r0 = r0.mOperations
                r1 = r7
                java.lang.Object r0 = r0.get(r1)
                android.content.UndoOperation r0 = (android.content.UndoOperation) r0
                r10 = r0
                r0 = r6
                if (r0 == 0) goto L5a
                r0 = r10
                android.content.UndoOwner r0 = r0.getOwner()
                r1 = r6
                if (r0 == r1) goto L5a
                r0 = r7
                r1 = 1
                int r0 = r0 - r1
                r7 = r0
                goto L31
            L5a:
                r0 = r5
                if (r0 == 0) goto L6b
                r0 = r9
                r8 = r0
                r0 = r10
                java.lang.Class r0 = r0.getClass()
                r1 = r5
                if (r0 != r1) goto L2a
            L6b:
                r0 = r10
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.content.UndoManager.UndoState.getLastOperation(java.lang.Class, android.content.UndoOwner):android.content.UndoOperation");
        }

        boolean hasData() {
            int size = this.mOperations.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.mOperations.get(i).hasData()) {
                    return true;
                }
                size = i;
            }
        }

        boolean hasMultipleOwners() {
            int size = this.mOperations.size();
            if (size <= 1) {
                return false;
            }
            UndoOwner owner = this.mOperations.get(0).getOwner();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return false;
                }
                if (this.mOperations.get(i2).getOwner() != owner) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        boolean hasOperation(UndoOwner undoOwner) {
            int size = this.mOperations.size();
            if (undoOwner == null) {
                return size != 0;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return false;
                }
                if (this.mOperations.get(i2).getOwner() == undoOwner) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        void makeExecuted() {
            this.mExecuted = true;
        }

        boolean matchOwner(UndoOwner undoOwner) {
            int size = this.mOperations.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.mOperations.get(i).matchOwner(undoOwner)) {
                    return true;
                }
                size = i;
            }
        }

        void redo() {
            int size = this.mOperations.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.mOperations.get(i2).redo();
                i = i2 + 1;
            }
        }

        boolean setCanMerge(boolean z) {
            if (z && this.mExecuted) {
                return false;
            }
            this.mCanMerge = z;
            return true;
        }

        void setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
        }

        void undo() {
            int size = this.mOperations.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                this.mOperations.get(i).undo();
                size = i;
            }
        }

        void updateLabel(CharSequence charSequence) {
            if (this.mLabel != null) {
                this.mLabel = charSequence;
            }
        }

        void writeToParcel(Parcel parcel) {
            if (this.mRecent != null) {
                throw new IllegalStateException("Can't save state before committing");
            }
            parcel.writeInt(this.mCommitId);
            parcel.writeInt(this.mCanMerge ? 1 : 0);
            parcel.writeInt(this.mExecuted ? 1 : 0);
            TextUtils.writeToParcel(this.mLabel, parcel, 0);
            int size = this.mOperations.size();
            parcel.writeInt(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                UndoOperation<?> undoOperation = this.mOperations.get(i2);
                this.mManager.saveOwner(undoOperation.mOwner, parcel);
                parcel.writeParcelable(undoOperation, 0);
                i = i2 + 1;
            }
        }
    }

    private void createWorkingState() {
        int i = this.mCommitId;
        this.mCommitId = i + 1;
        this.mWorking = new UndoState(this, i);
        if (this.mCommitId < 0) {
            this.mCommitId = 1;
        }
    }

    private void pushWorkingState() {
        int size = this.mUndos.size() + 1;
        if (this.mWorking.hasData()) {
            this.mUndos.add(this.mWorking);
            forgetRedos(null, -1);
            this.mWorking.commit();
            if (size >= 2) {
                this.mUndos.get(size - 2).makeExecuted();
            }
        } else {
            this.mWorking.destroy();
        }
        this.mWorking = null;
        if (this.mHistorySize < 0 || size <= this.mHistorySize) {
            return;
        }
        forgetUndos(null, size - this.mHistorySize);
    }

    public void addOperation(UndoOperation<?> undoOperation, int i) {
        UndoState topUndo;
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        if (undoOperation.getOwner().mManager != this) {
            throw new IllegalArgumentException("Given operation's owner is not in this undo manager.");
        }
        if (i != 0 && !this.mMerged && !this.mWorking.hasData() && (topUndo = getTopUndo(null)) != null && ((i == 2 || !topUndo.hasMultipleOwners()) && topUndo.canMerge() && topUndo.hasOperation(undoOperation.getOwner()))) {
            this.mWorking.destroy();
            this.mWorking = topUndo;
            this.mUndos.remove(topUndo);
            this.mMerged = true;
        }
        this.mWorking.addOperation(undoOperation);
    }

    public void beginUpdate(CharSequence charSequence) {
        if (this.mInUndo) {
            throw new IllegalStateException("Can't being update while performing undo/redo");
        }
        if (this.mUpdateCount <= 0) {
            createWorkingState();
            this.mMerged = false;
            this.mUpdateCount = 0;
        }
        this.mWorking.updateLabel(charSequence);
        this.mUpdateCount++;
    }

    public int commitState(UndoOwner undoOwner) {
        if (this.mWorking == null || !this.mWorking.hasData()) {
            UndoState topUndo = getTopUndo(null);
            if (topUndo != null) {
                if (undoOwner == null || topUndo.hasOperation(undoOwner)) {
                    topUndo.setCanMerge(false);
                    return topUndo.getCommitId();
                }
                return -1;
            }
            return -1;
        } else if (undoOwner == null || this.mWorking.hasOperation(undoOwner)) {
            this.mWorking.setCanMerge(false);
            int commitId = this.mWorking.getCommitId();
            pushWorkingState();
            createWorkingState();
            this.mMerged = true;
            return commitId;
        } else {
            return -1;
        }
    }

    public int countRedos(UndoOwner[] undoOwnerArr) {
        int i;
        if (undoOwnerArr != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int findNextState = findNextState(this.mRedos, undoOwnerArr, i3);
                i = i2;
                if (findNextState < 0) {
                    break;
                }
                i2++;
                i3 = findNextState + 1;
            }
        } else {
            i = this.mRedos.size();
        }
        return i;
    }

    public int countUndos(UndoOwner[] undoOwnerArr) {
        int i;
        if (undoOwnerArr != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int findNextState = findNextState(this.mUndos, undoOwnerArr, i3);
                i = i2;
                if (findNextState < 0) {
                    break;
                }
                i2++;
                i3 = findNextState + 1;
            }
        } else {
            i = this.mUndos.size();
        }
        return i;
    }

    public void endUpdate() {
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        this.mUpdateCount--;
        if (this.mUpdateCount == 0) {
            pushWorkingState();
        }
    }

    int findNextState(ArrayList<UndoState> arrayList, UndoOwner[] undoOwnerArr, int i) {
        int size = arrayList.size();
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        if (i2 >= size) {
            return -1;
        }
        if (undoOwnerArr == null) {
            return i2;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (matchOwners(arrayList.get(i3), undoOwnerArr)) {
                return i3;
            }
        }
        return -1;
    }

    int findPrevState(ArrayList<UndoState> arrayList, UndoOwner[] undoOwnerArr, int i) {
        int size = arrayList.size();
        int i2 = i;
        if (i == -1) {
            i2 = size - 1;
        }
        if (i2 >= size) {
            return -1;
        }
        if (undoOwnerArr == null) {
            return i2;
        }
        for (int i3 = i2; i3 >= 0; i3--) {
            if (matchOwners(arrayList.get(i3), undoOwnerArr)) {
                return i3;
            }
        }
        return -1;
    }

    public int forgetRedos(UndoOwner[] undoOwnerArr, int i) {
        int i2 = i;
        if (i < 0) {
            i2 = this.mRedos.size();
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.mRedos.size() && i3 < i2) {
            UndoState undoState = this.mRedos.get(i4);
            int i5 = i3;
            if (i2 > 0) {
                i5 = i3;
                if (matchOwners(undoState, undoOwnerArr)) {
                    undoState.destroy();
                    this.mRedos.remove(i4);
                    i5 = i3 + 1;
                }
            }
            i4++;
            i3 = i5;
        }
        return i3;
    }

    public int forgetUndos(UndoOwner[] undoOwnerArr, int i) {
        int i2 = i;
        if (i < 0) {
            i2 = this.mUndos.size();
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.mUndos.size() && i3 < i2) {
            UndoState undoState = this.mUndos.get(i4);
            int i5 = i3;
            if (i2 > 0) {
                i5 = i3;
                if (matchOwners(undoState, undoOwnerArr)) {
                    undoState.destroy();
                    this.mUndos.remove(i4);
                    i5 = i3 + 1;
                }
            }
            i4++;
            i3 = i5;
        }
        return i3;
    }

    public int getHistorySize() {
        return this.mHistorySize;
    }

    public UndoOperation<?> getLastOperation(int i) {
        return getLastOperation(null, null, i);
    }

    public UndoOperation<?> getLastOperation(UndoOwner undoOwner, int i) {
        return getLastOperation(null, undoOwner, i);
    }

    public <T extends UndoOperation> T getLastOperation(Class<T> cls, UndoOwner undoOwner, int i) {
        UndoState topUndo;
        T t;
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        if (i == 0 || this.mMerged || this.mWorking.hasData() || (topUndo = getTopUndo(null)) == null || ((i != 2 && topUndo.hasMultipleOwners()) || !topUndo.canMerge() || (t = (T) topUndo.getLastOperation(cls, undoOwner)) == null || !t.allowMerge())) {
            return (T) this.mWorking.getLastOperation(cls, undoOwner);
        }
        this.mWorking.destroy();
        this.mWorking = topUndo;
        this.mUndos.remove(topUndo);
        this.mMerged = true;
        return t;
    }

    public UndoOwner getOwner(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("tag can't be null");
        }
        if (obj == null) {
            throw new NullPointerException("data can't be null");
        }
        UndoOwner undoOwner = this.mOwners.get(str);
        if (undoOwner != null) {
            if (undoOwner.mData != obj) {
                if (undoOwner.mData != null) {
                    throw new IllegalStateException("Owner " + undoOwner + " already exists with data " + undoOwner.mData + " but giving different data " + obj);
                }
                undoOwner.mData = obj;
            }
            return undoOwner;
        }
        UndoOwner undoOwner2 = new UndoOwner(str);
        undoOwner2.mManager = this;
        undoOwner2.mData = obj;
        this.mOwners.put(str, undoOwner2);
        return undoOwner2;
    }

    public CharSequence getRedoLabel(UndoOwner[] undoOwnerArr) {
        UndoState topRedo = getTopRedo(undoOwnerArr);
        if (topRedo != null) {
            return topRedo.getLabel();
        }
        return null;
    }

    UndoState getTopRedo(UndoOwner[] undoOwnerArr) {
        int findPrevState;
        if (this.mRedos.size() > 0 && (findPrevState = findPrevState(this.mRedos, undoOwnerArr, -1)) >= 0) {
            return this.mRedos.get(findPrevState);
        }
        return null;
    }

    UndoState getTopUndo(UndoOwner[] undoOwnerArr) {
        int findPrevState;
        if (this.mUndos.size() > 0 && (findPrevState = findPrevState(this.mUndos, undoOwnerArr, -1)) >= 0) {
            return this.mUndos.get(findPrevState);
        }
        return null;
    }

    public CharSequence getUndoLabel(UndoOwner[] undoOwnerArr) {
        UndoState topUndo = getTopUndo(undoOwnerArr);
        if (topUndo != null) {
            return topUndo.getLabel();
        }
        return null;
    }

    public int getUpdateNestingLevel() {
        return this.mUpdateCount;
    }

    public boolean hasOperation(UndoOwner undoOwner) {
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        return this.mWorking.hasOperation(undoOwner);
    }

    public boolean isInUndo() {
        return this.mInUndo;
    }

    public boolean isInUpdate() {
        return this.mUpdateCount > 0;
    }

    boolean matchOwners(UndoState undoState, UndoOwner[] undoOwnerArr) {
        if (undoOwnerArr == null) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= undoOwnerArr.length) {
                return false;
            }
            if (undoState.matchOwner(undoOwnerArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public int redo(UndoOwner[] undoOwnerArr, int i) {
        int i2;
        if (this.mWorking != null) {
            throw new IllegalStateException("Can't be called during an update");
        }
        int i3 = -1;
        this.mInUndo = true;
        int i4 = i;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i4 <= 0) {
                break;
            }
            i3 = findPrevState(this.mRedos, undoOwnerArr, i3);
            if (i3 < 0) {
                break;
            }
            UndoState remove = this.mRedos.remove(i3);
            remove.redo();
            this.mUndos.add(remove);
            i4--;
            i5 = i2 + 1;
        }
        this.mInUndo = false;
        return i2;
    }

    void removeOwner(UndoOwner undoOwner) {
    }

    public void restoreInstanceState(Parcelable parcelable) {
        if (this.mUpdateCount > 0) {
            throw new IllegalStateException("Can't save state while updating");
        }
        forgetUndos(null, -1);
        forgetRedos(null, -1);
        ParcelableParcel parcelableParcel = (ParcelableParcel) parcelable;
        Parcel parcel = parcelableParcel.getParcel();
        this.mHistorySize = parcel.readInt();
        this.mStateOwners = new UndoOwner[parcel.readInt()];
        while (true) {
            int readInt = parcel.readInt();
            if (readInt == 0) {
                return;
            }
            UndoState undoState = new UndoState(this, parcel, parcelableParcel.getClassLoader());
            if (readInt == 1) {
                this.mUndos.add(0, undoState);
            } else {
                this.mRedos.add(0, undoState);
            }
        }
    }

    UndoOwner restoreOwner(Parcel parcel) {
        int readInt = parcel.readInt();
        UndoOwner undoOwner = this.mStateOwners[readInt];
        UndoOwner undoOwner2 = undoOwner;
        if (undoOwner == null) {
            String readString = parcel.readString();
            undoOwner2 = new UndoOwner(readString);
            this.mStateOwners[readInt] = undoOwner2;
            this.mOwners.put(readString, undoOwner2);
        }
        return undoOwner2;
    }

    public Parcelable saveInstanceState() {
        if (this.mUpdateCount > 0) {
            throw new IllegalStateException("Can't save state while updating");
        }
        ParcelableParcel parcelableParcel = new ParcelableParcel(getClass().getClassLoader());
        Parcel parcel = parcelableParcel.getParcel();
        this.mStateSeq++;
        if (this.mStateSeq <= 0) {
            this.mStateSeq = 0;
        }
        this.mNextSavedIdx = 0;
        parcel.writeInt(this.mHistorySize);
        parcel.writeInt(this.mOwners.size());
        int size = this.mUndos.size();
        while (size > 0) {
            parcel.writeInt(1);
            size--;
            this.mUndos.get(size).writeToParcel(parcel);
        }
        int size2 = this.mRedos.size();
        parcel.writeInt(size2);
        while (size2 > 0) {
            parcel.writeInt(2);
            size2--;
            this.mRedos.get(size2).writeToParcel(parcel);
        }
        parcel.writeInt(0);
        return parcelableParcel;
    }

    void saveOwner(UndoOwner undoOwner, Parcel parcel) {
        if (undoOwner.mStateSeq == this.mStateSeq) {
            parcel.writeInt(undoOwner.mSavedIdx);
            return;
        }
        undoOwner.mStateSeq = this.mStateSeq;
        undoOwner.mSavedIdx = this.mNextSavedIdx;
        parcel.writeInt(undoOwner.mSavedIdx);
        parcel.writeString(undoOwner.mTag);
        this.mNextSavedIdx++;
    }

    public void setHistorySize(int i) {
        this.mHistorySize = i;
        if (this.mHistorySize < 0 || countUndos(null) <= this.mHistorySize) {
            return;
        }
        forgetUndos(null, countUndos(null) - this.mHistorySize);
    }

    public void setUndoLabel(CharSequence charSequence) {
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        this.mWorking.setLabel(charSequence);
    }

    public void suggestUndoLabel(CharSequence charSequence) {
        if (this.mWorking == null) {
            throw new IllegalStateException("Must be called during an update");
        }
        this.mWorking.updateLabel(charSequence);
    }

    public boolean uncommitState(int i, UndoOwner undoOwner) {
        if (this.mWorking != null && this.mWorking.getCommitId() == i) {
            if (undoOwner == null || this.mWorking.hasOperation(undoOwner)) {
                return this.mWorking.setCanMerge(true);
            }
            return false;
        }
        UndoState topUndo = getTopUndo(null);
        if (topUndo != null) {
            if ((undoOwner == null || topUndo.hasOperation(undoOwner)) && topUndo.getCommitId() == i) {
                return topUndo.setCanMerge(true);
            }
            return false;
        }
        return false;
    }

    public int undo(UndoOwner[] undoOwnerArr, int i) {
        if (this.mWorking != null) {
            throw new IllegalStateException("Can't be called during an update");
        }
        this.mInUndo = true;
        UndoState topUndo = getTopUndo(null);
        int i2 = -1;
        int i3 = 0;
        int i4 = i;
        if (topUndo != null) {
            topUndo.makeExecuted();
            i4 = i;
            i3 = 0;
            i2 = -1;
        }
        while (i4 > 0) {
            i2 = findPrevState(this.mUndos, undoOwnerArr, i2);
            if (i2 < 0) {
                break;
            }
            UndoState remove = this.mUndos.remove(i2);
            remove.undo();
            this.mRedos.add(remove);
            i4--;
            i3++;
        }
        this.mInUndo = false;
        return i3;
    }
}
