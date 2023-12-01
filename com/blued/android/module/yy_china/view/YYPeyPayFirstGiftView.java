package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogPrePayFirstgiftBinding;
import com.blued.android.module.yy_china.model.GiftListDTOModel;
import com.blued.android.module.yy_china.model.YYPerFirstGiftModel;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPeyPayFirstGiftView.class */
public class YYPeyPayFirstGiftView extends CommonDialogFragment implements View.OnClickListener {
    private DialogPrePayFirstgiftBinding b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f18363c;
    private YYPerFirstGiftModel d;
    private View.OnClickListener e;

    public static void a(Context context, YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener, BaseFragment baseFragment) {
        YYPeyPayFirstGiftView yYPeyPayFirstGiftView = new YYPeyPayFirstGiftView();
        yYPeyPayFirstGiftView.a(yYPerFirstGiftModel, onClickListener, baseFragment);
        yYPeyPayFirstGiftView.show(((FragmentActivity) context).getSupportFragmentManager(), yYPeyPayFirstGiftView.getClass().getName());
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
        DialogPrePayFirstgiftBinding a2 = DialogPrePayFirstgiftBinding.a(view);
        this.b = a2;
        a2.i.setOnClickListener(this);
        YYPerFirstGiftModel yYPerFirstGiftModel = this.d;
        if (yYPerFirstGiftModel != null && yYPerFirstGiftModel.getSel() != null) {
            this.b.d.setText(String.format(getString(R.string.yy_perpay_title_rechargefirst), ((long) this.d.getSel().money) + "", ((long) (this.d.getSel().money * this.d.getSel().ratio)) + ""));
        }
        YYPerFirstGiftModel yYPerFirstGiftModel2 = this.d;
        if (yYPerFirstGiftModel2 != null && yYPerFirstGiftModel2.getGift_list() != null && this.f18363c != null) {
            if (this.d.getGift_list().size() > 0) {
                GiftListDTOModel giftListDTOModel = this.d.getGift_list().get(0);
                ImageLoader.a(this.f18363c.getFragmentActive(), giftListDTOModel.getPic()).a(this.b.f16377a);
                this.b.e.setText(giftListDTOModel.getName());
                this.b.f.setText(String.format("(%s天)", Long.valueOf(giftListDTOModel.getDuration())));
            }
            if (this.d.getGift_list().size() > 1) {
                GiftListDTOModel giftListDTOModel2 = this.d.getGift_list().get(1);
                ImageLoader.a(this.f18363c.getFragmentActive(), giftListDTOModel2.getPic()).a(this.b.b);
                this.b.g.setText(giftListDTOModel2.getName());
                this.b.h.setText(String.format("(%s天)", Long.valueOf(giftListDTOModel2.getDuration())));
            }
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYPeyPayFirstGiftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYPeyPayFirstGiftView.this.dismiss();
            }
        });
        this.b.f16378c.setOnClickListener(this);
    }

    public void a(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener, BaseFragment baseFragment) {
        this.d = yYPerFirstGiftModel;
        this.e = onClickListener;
        this.f18363c = baseFragment;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_pre_pay_firstgift;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public boolean g() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Tracker.onClick(view);
        if (view.getId() != R.id.tv_pre_pay || this.f18363c == null || (onClickListener = this.e) == null) {
            return;
        }
        onClickListener.onClick(view);
        dismissAllowingStateLoss();
    }
}
