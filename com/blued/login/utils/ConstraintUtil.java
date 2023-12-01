package com.blued.login.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/ConstraintUtil.class */
public final class ConstraintUtil {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f20583a;
    private ConstraintModify b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintSet f20584c;
    private final ConstraintSet d;

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/ConstraintUtil$ConstraintModify.class */
    public static final class ConstraintModify {

        /* renamed from: a  reason: collision with root package name */
        private final ConstraintSet f20585a;
        private final ConstraintLayout b;

        public ConstraintModify(ConstraintSet applyConstraintSet, ConstraintLayout constraintLayout) {
            Intrinsics.e(applyConstraintSet, "applyConstraintSet");
            Intrinsics.e(constraintLayout, "constraintLayout");
            this.f20585a = applyConstraintSet;
            this.b = constraintLayout;
        }

        public final ConstraintModify a(int i, int i2) {
            this.f20585a.setMargin(i, 3, i2);
            return this;
        }

        public final void a() {
            this.f20585a.applyTo(this.b);
        }
    }

    public ConstraintUtil(ConstraintLayout constraintLayout) {
        Intrinsics.e(constraintLayout, "constraintLayout");
        this.f20583a = constraintLayout;
        this.f20584c = new ConstraintSet();
        ConstraintSet constraintSet = new ConstraintSet();
        this.d = constraintSet;
        constraintSet.clone(this.f20583a);
    }

    public final ConstraintLayout a() {
        return this.f20583a;
    }

    public final ConstraintModify b() {
        synchronized (ConstraintModify.class) {
            try {
                if (this.b == null) {
                    this.b = new ConstraintModify(this.f20584c, a());
                }
                Unit unit = Unit.f42314a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f20584c.clone(this.f20583a);
        return this.b;
    }
}
