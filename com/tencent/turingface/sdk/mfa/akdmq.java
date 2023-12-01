package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/akdmq.class */
public final class akdmq extends ucT3w implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public int f26247c = 0;
    public QjsR0 d = null;
    public long e = 0;
    public static final /* synthetic */ boolean b = !akdmq.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static QjsR0 f26246a = new QjsR0();

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f26247c, 0);
        QjsR0 qjsR0 = this.d;
        if (qjsR0 != null) {
            d5hoq.a((ucT3w) qjsR0, 1);
        }
        d5hoq.a(this.e, 2);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f26247c = nyvkz.a(this.f26247c, 0, true);
        this.d = (QjsR0) nyvkz.a((ucT3w) f26246a, 1, false);
        this.e = nyvkz.a(this.e, 2, true);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        akdmq akdmqVar = (akdmq) obj;
        boolean z = false;
        if (fi6GY.a(this.f26247c, akdmqVar.f26247c)) {
            z = false;
            if (this.d.equals(akdmqVar.d)) {
                z = false;
                if (fi6GY.a(this.e, akdmqVar.e)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
