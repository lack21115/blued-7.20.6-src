package android.app;

import android.app.BackStackRecord;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/BackStackState.class */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: android.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(FragmentManagerImpl fragmentManagerImpl, BackStackRecord backStackRecord) {
        int i = 0;
        BackStackRecord.Op op = backStackRecord.mHead;
        while (op != null) {
            int i2 = i;
            if (op.removed != null) {
                i2 = i + op.removed.size();
            }
            op = op.next;
            i = i2;
        }
        this.mOps = new int[(backStackRecord.mNumOp * 7) + i];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        int i3 = 0;
        for (BackStackRecord.Op op2 = backStackRecord.mHead; op2 != null; op2 = op2.next) {
            int i4 = i3 + 1;
            this.mOps[i3] = op2.cmd;
            int i5 = i4 + 1;
            this.mOps[i4] = op2.fragment != null ? op2.fragment.mIndex : -1;
            int i6 = i5 + 1;
            this.mOps[i5] = op2.enterAnim;
            int i7 = i6 + 1;
            this.mOps[i6] = op2.exitAnim;
            int i8 = i7 + 1;
            this.mOps[i7] = op2.popEnterAnim;
            int i9 = i8 + 1;
            this.mOps[i8] = op2.popExitAnim;
            if (op2.removed != null) {
                int size = op2.removed.size();
                this.mOps[i9] = size;
                int i10 = 0;
                int i11 = i9;
                while (true) {
                    i3 = i11 + 1;
                    if (i10 < size) {
                        this.mOps[i3] = op2.removed.get(i10).mIndex;
                        i10++;
                        i11 = i3;
                    }
                }
            } else {
                i3 = i9 + 1;
                this.mOps[i9] = 0;
            }
        }
        this.mTransition = backStackRecord.mTransition;
        this.mTransitionStyle = backStackRecord.mTransitionStyle;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
        this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.mOps.length) {
                backStackRecord.mTransition = this.mTransition;
                backStackRecord.mTransitionStyle = this.mTransitionStyle;
                backStackRecord.mName = this.mName;
                backStackRecord.mIndex = this.mIndex;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
                backStackRecord.bumpBackStackNesting(1);
                return backStackRecord;
            }
            BackStackRecord.Op op = new BackStackRecord.Op();
            int i4 = i + 1;
            op.cmd = this.mOps[i];
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + this.mOps[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.mOps[i4];
            if (i6 >= 0) {
                op.fragment = fragmentManagerImpl.mActive.get(i6);
            } else {
                op.fragment = null;
            }
            int i7 = i5 + 1;
            op.enterAnim = this.mOps[i5];
            int i8 = i7 + 1;
            op.exitAnim = this.mOps[i7];
            int i9 = i8 + 1;
            op.popEnterAnim = this.mOps[i8];
            int i10 = i9 + 1;
            op.popExitAnim = this.mOps[i9];
            int i11 = i10 + 1;
            int i12 = this.mOps[i10];
            int i13 = i11;
            if (i12 > 0) {
                op.removed = new ArrayList<>(i12);
                int i14 = 0;
                while (true) {
                    i13 = i11;
                    if (i14 < i12) {
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.mOps[i11]);
                        }
                        op.removed.add(fragmentManagerImpl.mActive.get(this.mOps[i11]));
                        i14++;
                        i11++;
                    }
                }
            }
            i = i13;
            backStackRecord.addOp(op);
            i2 = i3 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
    }
}
