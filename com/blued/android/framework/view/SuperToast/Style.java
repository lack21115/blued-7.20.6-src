package com.blued.android.framework.view.SuperToast;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;
import com.blued.android.framework.view.SuperToast.utils.PaletteUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style.class */
public class Style implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.blued.android.framework.view.SuperToast.Style.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Style createFromParcel(Parcel parcel) {
            return new Style(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Style[] newArray(int i) {
            return new Style[i];
        }
    };
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    public Parcelable G;
    public int H;
    public int I;
    public boolean J;
    public int K;

    /* renamed from: a  reason: collision with root package name */
    public String f10189a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f10190c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public String l;
    public Parcelable m;
    public int n;
    protected long o;
    protected boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public String z;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$Animations.class */
    public @interface Animations {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$Duration.class */
    public @interface Duration {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$Frame.class */
    public @interface Frame {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$GravityStyle.class */
    public @interface GravityStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$IconPosition.class */
    public @interface IconPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$PriorityLevel.class */
    public @interface PriorityLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$TextSize.class */
    public @interface TextSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$Type.class */
    public @interface Type {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Style$TypefaceStyle.class */
    public @interface TypefaceStyle {
    }

    public Style() {
        this.b = 2750;
        this.f10190c = PaletteUtils.a("9E9E9E");
        this.g = 81;
        this.i = BackgroundUtils.b(64);
        this.j = -2;
        this.k = -2;
        this.n = 2;
        this.q = 0;
        this.r = PaletteUtils.a("FFFFFF");
        this.s = 14;
        this.t = 1;
        this.A = 1;
        this.B = PaletteUtils.a("FFFFFF");
        this.C = 12;
        this.D = PaletteUtils.a("FFFFFF");
        this.K = PaletteUtils.a("FFFFFF");
        this.J = true;
    }

    private Style(Parcel parcel) {
        this.f10189a = parcel.readString();
        this.b = parcel.readInt();
        this.f10190c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readParcelable(getClass().getClassLoader());
        this.n = parcel.readInt();
        this.o = parcel.readLong();
        this.p = parcel.readByte() != 0;
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readByte() != 0;
        this.y = parcel.readByte() != 0;
        this.z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readString();
        this.G = parcel.readParcelable(getClass().getClassLoader());
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readByte() != 0;
        this.K = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10189a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f10190c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeParcelable(this.m, 0);
        parcel.writeInt(this.n);
        parcel.writeLong(this.o);
        parcel.writeByte(this.p ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeParcelable(this.G, 0);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.K);
    }
}
