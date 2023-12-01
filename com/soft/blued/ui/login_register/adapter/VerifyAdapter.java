package com.soft.blued.ui.login_register.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.model.AccountNumberVerifyModel;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/adapter/VerifyAdapter.class */
public class VerifyAdapter extends BaseQuickAdapter<AccountNumberVerifyModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private ShapeTextView f17854a;
    private Context b;

    public VerifyAdapter(Context context) {
        super(R.layout.login_verify_item, new ArrayList());
        this.b = context;
    }

    private void a(ShapeTextView shapeTextView) {
        ShapeHelper.a(shapeTextView, 2131102254);
        ShapeHelper.d(shapeTextView, 2131102254);
        ShapeHelper.b(shapeTextView, 2131102388);
        ShapeHelper.a(shapeTextView, DensityUtils.a(this.b, 1.0f), 0.0f, 0.0f);
    }

    private void b(ShapeTextView shapeTextView) {
        ShapeHelper.a(shapeTextView, 2131101780);
        ShapeHelper.b(shapeTextView, 2131101766);
        ShapeHelper.d(shapeTextView, 2131101766);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final AccountNumberVerifyModel accountNumberVerifyModel) {
        if (baseViewHolder != null) {
            ShapeTextView view = baseViewHolder.getView(R.id.verify_number);
            this.f17854a = view;
            view.setText(accountNumberVerifyModel.number);
            if (accountNumberVerifyModel.isSelect) {
                b(this.f17854a);
            } else {
                a(this.f17854a);
            }
            baseViewHolder.setOnClickListener(R.id.verify_root, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.adapter.VerifyAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (!accountNumberVerifyModel.isSelect) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= VerifyAdapter.this.mData.size()) {
                                break;
                            }
                            ((AccountNumberVerifyModel) VerifyAdapter.this.mData.get(i2)).isSelect = false;
                            i = i2 + 1;
                        }
                        accountNumberVerifyModel.isSelect = true;
                    }
                    VerifyAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }
}
