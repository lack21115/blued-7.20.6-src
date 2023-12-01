package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/BackStackState.class */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
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

    /* renamed from: a  reason: collision with root package name */
    final int[] f2854a;
    final ArrayList<String> b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f2855c;
    final int[] d;
    final int e;
    final String f;
    final int g;
    final int h;
    final CharSequence i;
    final int j;
    final CharSequence k;
    final ArrayList<String> l;
    final ArrayList<String> m;
    final boolean n;

    public BackStackState(Parcel parcel) {
        this.f2854a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.f2855c = parcel.createIntArray();
        this.d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.k = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.createStringArrayList();
        this.m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.d.size();
        this.f2854a = new int[size * 5];
        if (!backStackRecord.j) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList<>(size);
        this.f2855c = new int[size];
        this.d = new int[size];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= size) {
                this.e = backStackRecord.i;
                this.f = backStackRecord.l;
                this.g = backStackRecord.f2853c;
                this.h = backStackRecord.m;
                this.i = backStackRecord.n;
                this.j = backStackRecord.o;
                this.k = backStackRecord.p;
                this.l = backStackRecord.q;
                this.m = backStackRecord.r;
                this.n = backStackRecord.s;
                return;
            }
            FragmentTransaction.Op op = backStackRecord.d.get(i);
            int i4 = i3 + 1;
            this.f2854a[i3] = op.f2964a;
            this.b.add(op.b != null ? op.b.mWho : null);
            int i5 = i4 + 1;
            this.f2854a[i4] = op.f2965c;
            int i6 = i5 + 1;
            this.f2854a[i5] = op.d;
            int i7 = i6 + 1;
            this.f2854a[i6] = op.e;
            this.f2854a[i7] = op.f;
            this.f2855c[i] = op.g.ordinal();
            this.d[i] = op.h.ordinal();
            i++;
            i2 = i7 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i = 0;
        int i2 = 0;
        while (i < this.f2854a.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i3 = i + 1;
            op.f2964a = this.f2854a[i];
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.f2854a[i3]);
            }
            String str = this.b.get(i2);
            if (str != null) {
                op.b = fragmentManager.b(str);
            } else {
                op.b = null;
            }
            op.g = Lifecycle.State.values()[this.f2855c[i2]];
            op.h = Lifecycle.State.values()[this.d[i2]];
            int i4 = i3 + 1;
            op.f2965c = this.f2854a[i3];
            int i5 = i4 + 1;
            op.d = this.f2854a[i4];
            int i6 = i5 + 1;
            op.e = this.f2854a[i5];
            op.f = this.f2854a[i6];
            backStackRecord.e = op.f2965c;
            backStackRecord.f = op.d;
            backStackRecord.g = op.e;
            backStackRecord.h = op.f;
            backStackRecord.a(op);
            i2++;
            i = i6 + 1;
        }
        backStackRecord.i = this.e;
        backStackRecord.l = this.f;
        backStackRecord.f2853c = this.g;
        backStackRecord.j = true;
        backStackRecord.m = this.h;
        backStackRecord.n = this.i;
        backStackRecord.o = this.j;
        backStackRecord.p = this.k;
        backStackRecord.q = this.l;
        backStackRecord.r = this.m;
        backStackRecord.s = this.n;
        backStackRecord.a(1);
        return backStackRecord;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
