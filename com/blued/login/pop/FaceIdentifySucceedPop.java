package com.blued.login.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.login.R;
import com.blued.login.databinding.LoginPopFaceSucceedBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/pop/FaceIdentifySucceedPop.class */
public final class FaceIdentifySucceedPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f6957c = {(KProperty) Reflection.a(new PropertyReference1Impl(FaceIdentifySucceedPop.class, "vb", "getVb()Lcom/blued/login/databinding/LoginPopFaceSucceedBinding;", 0))};
    private final View.OnClickListener d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceIdentifySucceedPop(Context context, View.OnClickListener onClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(onClickListener, "clickListener");
        this.d = onClickListener;
        BasePopupView basePopupView = (BasePopupView) this;
        this.e = new CustomViewBindingProperty(new Function1<FaceIdentifySucceedPop, LoginPopFaceSucceedBinding>() { // from class: com.blued.login.pop.FaceIdentifySucceedPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final LoginPopFaceSucceedBinding invoke(FaceIdentifySucceedPop faceIdentifySucceedPop) {
                Intrinsics.e(faceIdentifySucceedPop, "popView");
                return LoginPopFaceSucceedBinding.a(faceIdentifySucceedPop.getPopupImplView());
            }
        });
    }

    private final LoginPopFaceSucceedBinding getVb() {
        return (LoginPopFaceSucceedBinding) this.e.b(this, f6957c[0]);
    }

    public void b() {
        ShapeTextView shapeTextView;
        super.b();
        LoginPopFaceSucceedBinding vb = getVb();
        if (vb == null || (shapeTextView = vb.b) == null) {
            return;
        }
        shapeTextView.setOnClickListener(this.d);
    }

    public final View.OnClickListener getClickListener() {
        return this.d;
    }

    public int getImplLayoutId() {
        return R.layout.login_pop_face_succeed;
    }
}
