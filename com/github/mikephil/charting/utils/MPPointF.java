package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/MPPointF.class */
public class MPPointF extends ObjectPool.Poolable {

    /* renamed from: c  reason: collision with root package name */
    public static final Parcelable.Creator<MPPointF> f8596c;
    private static ObjectPool<MPPointF> d;

    /* renamed from: a  reason: collision with root package name */
    public float f8597a;
    public float b;

    static {
        ObjectPool<MPPointF> a2 = ObjectPool.a(32, new MPPointF(0.0f, 0.0f));
        d = a2;
        a2.a(0.5f);
        f8596c = new Parcelable.Creator<MPPointF>() { // from class: com.github.mikephil.charting.utils.MPPointF.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MPPointF createFromParcel(Parcel parcel) {
                MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
                mPPointF.a(parcel);
                return mPPointF;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MPPointF[] newArray(int i) {
                return new MPPointF[i];
            }
        };
    }

    public MPPointF() {
    }

    public MPPointF(float f, float f2) {
        this.f8597a = f;
        this.b = f2;
    }

    public static MPPointF a() {
        return d.a();
    }

    public static MPPointF a(float f, float f2) {
        MPPointF a2 = d.a();
        a2.f8597a = f;
        a2.b = f2;
        return a2;
    }

    public static MPPointF a(MPPointF mPPointF) {
        MPPointF a2 = d.a();
        a2.f8597a = mPPointF.f8597a;
        a2.b = mPPointF.b;
        return a2;
    }

    public static void b(MPPointF mPPointF) {
        d.a((ObjectPool<MPPointF>) mPPointF);
    }

    public void a(Parcel parcel) {
        this.f8597a = parcel.readFloat();
        this.b = parcel.readFloat();
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable b() {
        return new MPPointF(0.0f, 0.0f);
    }
}
