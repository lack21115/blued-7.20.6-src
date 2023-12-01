package com.blued.login.test;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.login.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginAccountAdapter.class */
public final class LoginAccountAdapter extends BaseQuickAdapter<LoginAccountModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6960a;
    private final LoginViewModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginAccountAdapter(Context context, LoginViewModel loginViewModel) {
        super(R.layout.login_account_item_test);
        Intrinsics.e(loginViewModel, "viewModel");
        this.f6960a = context;
        this.b = loginViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginAccountAdapter loginAccountAdapter, LoginAccountModel loginAccountModel, View view) {
        Intrinsics.e(loginAccountAdapter, "this$0");
        LoginViewModel loginViewModel = loginAccountAdapter.b;
        if (loginViewModel != null) {
            loginViewModel.a(loginAccountAdapter.f6960a, loginAccountModel);
        }
        for (LoginAccountModel loginAccountModel2 : loginAccountAdapter.getData()) {
            Intrinsics.c(loginAccountModel2, "data");
            LoginAccountModel loginAccountModel3 = loginAccountModel2;
            loginAccountModel3.a(Intrinsics.a(loginAccountModel, loginAccountModel3));
        }
        loginAccountAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final LoginAccountModel loginAccountModel) {
        View view;
        if (baseViewHolder != null) {
            baseViewHolder.setText(R.id.tv_name, loginAccountModel == null ? null : loginAccountModel.a());
        }
        if (baseViewHolder != null && (view = baseViewHolder.getView(R.id.sf_lay)) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginAccountAdapter$4gdWShLB1S4-XWkZ-zWhVpxD5Q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginAccountAdapter.a(LoginAccountAdapter.this, loginAccountModel, view2);
                }
            });
        }
        ShapeModel shapeModel = new ShapeModel();
        Boolean valueOf = loginAccountModel == null ? null : Boolean.valueOf(loginAccountModel.g());
        Intrinsics.a(valueOf);
        if (valueOf.booleanValue()) {
            Context context = this.f6960a;
            Intrinsics.a(context);
            shapeModel.k = ContextCompat.getColor(context, R.color.syc_dark_59004DDD);
        } else {
            Context context2 = this.f6960a;
            Intrinsics.a(context2);
            shapeModel.k = ContextCompat.getColor(context2, R.color.syc_dark_b);
            Context context3 = this.f6960a;
            Intrinsics.a(context3);
            shapeModel.l = ContextCompat.getColor(context3, R.color.syc_dark_59004DDD);
        }
        shapeModel.H = DensityUtils.a(this.mContext, 20.0f);
        ShapeFrameLayout view2 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.sf_lay);
        if (view2 == null) {
            return;
        }
        view2.setShapeModel(shapeModel);
    }

    public final Context getContext() {
        return this.f6960a;
    }
}
