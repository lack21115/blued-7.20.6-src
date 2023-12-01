package android.os;

import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/os/WorkSource.class */
public class WorkSource implements Parcelable {
    static final boolean DEBUG = false;
    static final String TAG = "WorkSource";
    static WorkSource sGoneWork;
    static WorkSource sNewbWork;
    String[] mNames;
    int mNum;
    int[] mUids;
    static final WorkSource sTmpWorkSource = new WorkSource(0);
    public static final Parcelable.Creator<WorkSource> CREATOR = new Parcelable.Creator<WorkSource>() { // from class: android.os.WorkSource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkSource createFromParcel(Parcel parcel) {
            return new WorkSource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkSource[] newArray(int i) {
            return new WorkSource[i];
        }
    };

    public WorkSource() {
        this.mNum = 0;
    }

    public WorkSource(int i) {
        this.mNum = 1;
        this.mUids = new int[]{i, 0};
        this.mNames = null;
    }

    public WorkSource(int i, String str) {
        if (str == null) {
            throw new NullPointerException("Name can't be null");
        }
        this.mNum = 1;
        this.mUids = new int[]{i, 0};
        this.mNames = new String[]{str, null};
    }

    WorkSource(Parcel parcel) {
        this.mNum = parcel.readInt();
        this.mUids = parcel.createIntArray();
        this.mNames = parcel.createStringArray();
    }

    public WorkSource(WorkSource workSource) {
        if (workSource == null) {
            this.mNum = 0;
            return;
        }
        this.mNum = workSource.mNum;
        if (workSource.mUids != null) {
            this.mUids = (int[]) workSource.mUids.clone();
            this.mNames = workSource.mNames != null ? (String[]) workSource.mNames.clone() : null;
            return;
        }
        this.mUids = null;
        this.mNames = null;
    }

    private static WorkSource addWork(WorkSource workSource, int i) {
        if (workSource == null) {
            return new WorkSource(i);
        }
        workSource.insert(workSource.mNum, i);
        return workSource;
    }

    private static WorkSource addWork(WorkSource workSource, int i, String str) {
        if (workSource == null) {
            return new WorkSource(i, str);
        }
        workSource.insert(workSource.mNum, i, str);
        return workSource;
    }

    private int compare(WorkSource workSource, int i, int i2) {
        int i3 = this.mUids[i] - workSource.mUids[i2];
        return i3 != 0 ? i3 : this.mNames[i].compareTo(workSource.mNames[i2]);
    }

    private void insert(int i, int i2) {
        if (this.mUids == null) {
            this.mUids = new int[4];
            this.mUids[0] = i2;
            this.mNum = 1;
        } else if (this.mNum < this.mUids.length) {
            if (i < this.mNum) {
                System.arraycopy(this.mUids, i, this.mUids, i + 1, this.mNum - i);
            }
            this.mUids[i] = i2;
            this.mNum++;
        } else {
            int[] iArr = new int[(this.mNum * 3) / 2];
            if (i > 0) {
                System.arraycopy(this.mUids, 0, iArr, 0, i);
            }
            if (i < this.mNum) {
                System.arraycopy(this.mUids, i, iArr, i + 1, this.mNum - i);
            }
            this.mUids = iArr;
            this.mUids[i] = i2;
            this.mNum++;
        }
    }

    private void insert(int i, int i2, String str) {
        if (this.mUids == null) {
            this.mUids = new int[4];
            this.mUids[0] = i2;
            this.mNames = new String[4];
            this.mNames[0] = str;
            this.mNum = 1;
        } else if (this.mNum < this.mUids.length) {
            if (i < this.mNum) {
                System.arraycopy(this.mUids, i, this.mUids, i + 1, this.mNum - i);
                System.arraycopy(this.mNames, i, this.mNames, i + 1, this.mNum - i);
            }
            this.mUids[i] = i2;
            this.mNames[i] = str;
            this.mNum++;
        } else {
            int[] iArr = new int[(this.mNum * 3) / 2];
            String[] strArr = new String[(this.mNum * 3) / 2];
            if (i > 0) {
                System.arraycopy(this.mUids, 0, iArr, 0, i);
                System.arraycopy(this.mNames, 0, strArr, 0, i);
            }
            if (i < this.mNum) {
                System.arraycopy(this.mUids, i, iArr, i + 1, this.mNum - i);
                System.arraycopy(this.mNames, i, strArr, i + 1, this.mNum - i);
            }
            this.mUids = iArr;
            this.mNames = strArr;
            this.mUids[i] = i2;
            this.mNames[i] = str;
            this.mNum++;
        }
    }

    private boolean removeUids(WorkSource workSource) {
        int i = this.mNum;
        int[] iArr = this.mUids;
        int i2 = workSource.mNum;
        int[] iArr2 = workSource.mUids;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i && i4 < i2) {
            if (iArr2[i4] == iArr[i3]) {
                i--;
                z = true;
                if (i3 < i) {
                    System.arraycopy(iArr, i3 + 1, iArr, i3, i - i3);
                }
                i4++;
            } else if (iArr2[i4] > iArr[i3]) {
                i3++;
            } else {
                i4++;
            }
        }
        this.mNum = i;
        return z;
    }

    private boolean removeUidsAndNames(WorkSource workSource) {
        int i = this.mNum;
        int[] iArr = this.mUids;
        String[] strArr = this.mNames;
        int i2 = workSource.mNum;
        int[] iArr2 = workSource.mUids;
        String[] strArr2 = workSource.mNames;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i && i4 < i2) {
            if (iArr2[i4] == iArr[i3] && strArr2[i4].equals(strArr[i3])) {
                i--;
                z = true;
                if (i3 < i) {
                    System.arraycopy(iArr, i3 + 1, iArr, i3, i - i3);
                    System.arraycopy(strArr, i3 + 1, strArr, i3, i - i3);
                }
                i4++;
            } else if (iArr2[i4] > iArr[i3] || (iArr2[i4] == iArr[i3] && strArr2[i4].compareTo(strArr[i3]) > 0)) {
                i3++;
            } else {
                i4++;
            }
        }
        this.mNum = i;
        return z;
    }

    private boolean updateLocked(WorkSource workSource, boolean z, boolean z2) {
        if (this.mNames == null && workSource.mNames == null) {
            return updateUidsLocked(workSource, z, z2);
        }
        if (this.mNum <= 0 || this.mNames != null) {
            if (workSource.mNum <= 0 || workSource.mNames != null) {
                return updateUidsAndNamesLocked(workSource, z, z2);
            }
            throw new IllegalArgumentException("Target " + this + " has names, but other " + workSource + " does not");
        }
        throw new IllegalArgumentException("Other " + workSource + " has names, but target " + this + " does not");
    }

    private boolean updateUidsAndNamesLocked(WorkSource workSource, boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = workSource.mNum;
        int[] iArr = workSource.mUids;
        String[] strArr = workSource.mNames;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= this.mNum && i5 >= i3) {
                return z3;
            }
            int i6 = -1;
            if (i4 < this.mNum) {
                if (i5 < i3) {
                    int compare = compare(workSource, i4, i5);
                    i6 = compare;
                    if (compare > 0) {
                    }
                }
                if (z) {
                    int i7 = i4;
                    while (true) {
                        i = i6;
                        i2 = i7;
                        if (i >= 0) {
                            break;
                        }
                        sGoneWork = addWork(sGoneWork, this.mUids[i7], this.mNames[i7]);
                        i7++;
                        if (i7 >= this.mNum) {
                            i2 = i7;
                            break;
                        }
                        i6 = i5 < i3 ? compare(workSource, i7, i5) : -1;
                    }
                    int i8 = i2;
                    if (i4 < i2) {
                        System.arraycopy(this.mUids, i2, this.mUids, i4, this.mNum - i2);
                        System.arraycopy(this.mNames, i2, this.mNames, i4, this.mNum - i2);
                        this.mNum -= i2 - i4;
                        i8 = i4;
                    }
                    i4 = i8;
                    if (i8 < this.mNum) {
                        i4 = i8;
                        if (i == 0) {
                            i4 = i8 + 1;
                            i5++;
                        }
                    }
                } else {
                    int i9 = i5;
                    if (i5 < i3) {
                        i9 = i5;
                        if (i6 == 0) {
                            i9 = i5 + 1;
                        }
                    }
                    i4++;
                    i5 = i9;
                }
            }
            z3 = true;
            insert(i4, iArr[i5], strArr[i5]);
            if (z2) {
                sNewbWork = addWork(sNewbWork, iArr[i5], strArr[i5]);
            }
            i4++;
            i5++;
        }
    }

    private boolean updateUidsLocked(WorkSource workSource, boolean z, boolean z2) {
        int i;
        int i2 = this.mNum;
        int[] iArr = this.mUids;
        int i3 = workSource.mNum;
        int[] iArr2 = workSource.mUids;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        int[] iArr3 = iArr;
        while (true) {
            if (i4 >= i2 && i5 >= i3) {
                this.mNum = i2;
                this.mUids = iArr3;
                return z3;
            } else if (i4 >= i2 || (i5 < i3 && iArr2[i5] < iArr3[i4])) {
                z3 = true;
                if (iArr3 == null) {
                    iArr3 = new int[4];
                    iArr3[0] = iArr2[i5];
                } else if (i2 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    if (i4 > 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, i4);
                    }
                    if (i4 < i2) {
                        System.arraycopy(iArr3, i4, iArr4, i4 + 1, i2 - i4);
                    }
                    iArr3 = iArr4;
                    iArr3[i4] = iArr2[i5];
                } else {
                    if (i4 < i2) {
                        System.arraycopy(iArr3, i4, iArr3, i4 + 1, i2 - i4);
                    }
                    iArr3[i4] = iArr2[i5];
                }
                if (z2) {
                    sNewbWork = addWork(sNewbWork, iArr2[i5]);
                }
                i2++;
                i4++;
                i5++;
            } else if (z) {
                int i6 = i4;
                while (true) {
                    i = i6;
                    if (i >= i2 || (i5 < i3 && iArr2[i5] <= iArr3[i])) {
                        break;
                    }
                    sGoneWork = addWork(sGoneWork, iArr3[i]);
                    i6 = i + 1;
                }
                int i7 = i2;
                int i8 = i;
                if (i4 < i) {
                    System.arraycopy(iArr3, i, iArr3, i4, i2 - i);
                    i7 = i2 - (i - i4);
                    i8 = i4;
                }
                i2 = i7;
                i4 = i8;
                if (i8 < i7) {
                    i2 = i7;
                    i4 = i8;
                    if (i5 < i3) {
                        i2 = i7;
                        i4 = i8;
                        if (iArr2[i5] == iArr3[i8]) {
                            i4 = i8 + 1;
                            i5++;
                            i2 = i7;
                        }
                    }
                }
            } else {
                int i9 = i5;
                if (i5 < i3) {
                    i9 = i5;
                    if (iArr2[i5] == iArr3[i4]) {
                        i9 = i5 + 1;
                    }
                }
                i4++;
                i5 = i9;
            }
        }
    }

    public boolean add(int i) {
        if (this.mNum <= 0) {
            this.mNames = null;
            insert(0, i);
            return true;
        } else if (this.mNames != null) {
            throw new IllegalArgumentException("Adding without name to named " + this);
        } else {
            int binarySearch = Arrays.binarySearch(this.mUids, 0, this.mNum, i);
            if (binarySearch >= 0) {
                return false;
            }
            insert((-binarySearch) - 1, i);
            return true;
        }
    }

    public boolean add(int i, String str) {
        int i2;
        if (this.mNum <= 0) {
            insert(0, i, str);
            return true;
        } else if (this.mNames == null) {
            throw new IllegalArgumentException("Adding name to unnamed " + this);
        } else {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mNum || this.mUids[i2] > i) {
                    break;
                }
                if (this.mUids[i2] == i) {
                    int compareTo = this.mNames[i2].compareTo(str);
                    if (compareTo > 0) {
                        break;
                    } else if (compareTo == 0) {
                        return false;
                    }
                }
                i3 = i2 + 1;
            }
            insert(i2, i, str);
            return true;
        }
    }

    public boolean add(WorkSource workSource) {
        boolean updateLocked;
        synchronized (sTmpWorkSource) {
            updateLocked = updateLocked(workSource, false, false);
        }
        return updateLocked;
    }

    public WorkSource addReturningNewbs(int i) {
        WorkSource workSource;
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = i;
            updateLocked(sTmpWorkSource, false, true);
            workSource = sNewbWork;
        }
        return workSource;
    }

    public WorkSource addReturningNewbs(WorkSource workSource) {
        WorkSource workSource2;
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            updateLocked(workSource, false, true);
            workSource2 = sNewbWork;
        }
        return workSource2;
    }

    public void clear() {
        this.mNum = 0;
    }

    public void clearNames() {
        if (this.mNames == null) {
            return;
        }
        this.mNames = null;
        int i = 1;
        int i2 = this.mNum;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mNum) {
                this.mNum = i2;
                return;
            }
            if (this.mUids[i4] == this.mUids[i4 - 1]) {
                i2--;
            } else {
                this.mUids[i] = this.mUids[i4];
                i++;
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean diff(WorkSource workSource) {
        int i = this.mNum;
        if (i != workSource.mNum) {
            return true;
        }
        int[] iArr = this.mUids;
        int[] iArr2 = workSource.mUids;
        String[] strArr = this.mNames;
        String[] strArr2 = workSource.mNames;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return false;
            }
            if (iArr[i3] != iArr2[i3]) {
                return true;
            }
            if (strArr != null && strArr2 != null && !strArr[i3].equals(strArr2[i3])) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof WorkSource) && !diff((WorkSource) obj);
    }

    public int get(int i) {
        return this.mUids[i];
    }

    public String getName(int i) {
        if (this.mNames != null) {
            return this.mNames[i];
        }
        return null;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mNum) {
                break;
            }
            i = ((i << 4) | (i >>> 28)) ^ this.mUids[i3];
            i2 = i3 + 1;
        }
        int i4 = i;
        if (this.mNames != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                i4 = i;
                if (i6 >= this.mNum) {
                    break;
                }
                i = ((i << 4) | (i >>> 28)) ^ this.mNames[i6].hashCode();
                i5 = i6 + 1;
            }
        }
        return i4;
    }

    public boolean remove(WorkSource workSource) {
        if (this.mNum <= 0 || workSource.mNum <= 0) {
            return false;
        }
        if (this.mNames == null && workSource.mNames == null) {
            return removeUids(workSource);
        }
        if (this.mNames == null) {
            throw new IllegalArgumentException("Other " + workSource + " has names, but target " + this + " does not");
        }
        if (workSource.mNames == null) {
            throw new IllegalArgumentException("Target " + this + " has names, but other " + workSource + " does not");
        }
        return removeUidsAndNames(workSource);
    }

    public void set(int i) {
        this.mNum = 1;
        if (this.mUids == null) {
            this.mUids = new int[2];
        }
        this.mUids[0] = i;
        this.mNames = null;
    }

    public void set(int i, String str) {
        if (str == null) {
            throw new NullPointerException("Name can't be null");
        }
        this.mNum = 1;
        if (this.mUids == null) {
            this.mUids = new int[2];
            this.mNames = new String[2];
        }
        this.mUids[0] = i;
        this.mNames[0] = str;
    }

    public void set(WorkSource workSource) {
        if (workSource == null) {
            this.mNum = 0;
            return;
        }
        this.mNum = workSource.mNum;
        if (workSource.mUids == null) {
            this.mUids = null;
            this.mNames = null;
            return;
        }
        if (this.mUids == null || this.mUids.length < this.mNum) {
            this.mUids = (int[]) workSource.mUids.clone();
        } else {
            System.arraycopy(workSource.mUids, 0, this.mUids, 0, this.mNum);
        }
        if (workSource.mNames == null) {
            this.mNames = null;
        } else if (this.mNames == null || this.mNames.length < this.mNum) {
            this.mNames = (String[]) workSource.mNames.clone();
        } else {
            System.arraycopy(workSource.mNames, 0, this.mNames, 0, this.mNum);
        }
    }

    public WorkSource[] setReturningDiffs(WorkSource workSource) {
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(workSource, true, true);
            if (sNewbWork == null && sGoneWork == null) {
                return null;
            }
            return new WorkSource[]{sNewbWork, sGoneWork};
        }
    }

    public int size() {
        return this.mNum;
    }

    public WorkSource stripNames() {
        WorkSource workSource;
        if (this.mNum > 0) {
            WorkSource workSource2 = new WorkSource();
            int i = 0;
            while (true) {
                int i2 = i;
                workSource = workSource2;
                if (i2 >= this.mNum) {
                    break;
                }
                int i3 = this.mUids[i2];
                if (i2 == 0 || -1 != i3) {
                    workSource2.add(i3);
                }
                i = i2 + 1;
            }
        } else {
            workSource = new WorkSource();
        }
        return workSource;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkSource{");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNum) {
                sb.append("}");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            sb.append(this.mUids[i2]);
            if (this.mNames != null) {
                sb.append(" ");
                sb.append(this.mNames[i2]);
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mNum);
        parcel.writeIntArray(this.mUids);
        parcel.writeStringArray(this.mNames);
    }
}
