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
    private final ConstraintLayout f6977a;
    private ConstraintModify b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintSet f6978c;
    private final ConstraintSet d;

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/ConstraintUtil$ConstraintModify.class */
    public static final class ConstraintModify {

        /* renamed from: a  reason: collision with root package name */
        private final ConstraintSet f6979a;
        private final ConstraintLayout b;

        public ConstraintModify(ConstraintSet constraintSet, ConstraintLayout constraintLayout) {
            Intrinsics.e(constraintSet, "applyConstraintSet");
            Intrinsics.e(constraintLayout, "constraintLayout");
            this.f6979a = constraintSet;
            this.b = constraintLayout;
        }

        public final ConstraintModify a(int i, int i2) {
            this.f6979a.setMargin(i, 3, i2);
            return this;
        }

        public final void a() {
            this.f6979a.applyTo(this.b);
        }
    }

    public ConstraintUtil(ConstraintLayout constraintLayout) {
        Intrinsics.e(constraintLayout, "constraintLayout");
        this.f6977a = constraintLayout;
        this.f6978c = new ConstraintSet();
        ConstraintSet constraintSet = new ConstraintSet();
        this.d = constraintSet;
        constraintSet.clone(this.f6977a);
    }

    public final ConstraintLayout a() {
        return this.f6977a;
    }

    public final ConstraintModify b() {
        synchronized (ConstraintModify.class) {
            try {
                if (this.b == null) {
                    this.b = new ConstraintModify(this.f6978c, a());
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6978c.clone(this.f6977a);
        return this.b;
    }
}
