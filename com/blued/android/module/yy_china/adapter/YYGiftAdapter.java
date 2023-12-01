package com.blued.android.module.yy_china.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyGiftBagBinding;
import com.blued.android.module.yy_china.databinding.ItemYyGiftNomerBinding;
import com.blued.android.module.yy_china.model.YYGiftModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYGiftAdapter.class */
public class YYGiftAdapter extends BaseGiftAdapter<YYGiftModel> {
    private Drawable a;
    private IRequestHost b;

    public YYGiftAdapter(BaseFragment baseFragment, int i) {
        super(baseFragment.getContext(), i);
        this.b = baseFragment.getFragmentActive();
        Drawable drawable = baseFragment.getContext().getResources().getDrawable(R.drawable.yy_gift_item_beans_true);
        this.a = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.a.getMinimumHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new CubicInterpolator(0.2f, 0.04f, 0.83f, 0.96f));
        scaleAnimation.setDuration(700L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.yy_china.adapter.YYGiftAdapter.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                YYGiftAdapter.this.b(view);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(scaleAnimation);
    }

    private void a(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, YYGiftModel yYGiftModel) {
        ItemYyGiftBagBinding a = ItemYyGiftBagBinding.a(commonAdapterHolder.itemView);
        a.e.setText(yYGiftModel.name);
        ImageLoader.a(this.b, yYGiftModel.images_static).b(R.drawable.gift_default_icon).a(a.f);
        a.c.setText(yYGiftModel.expire);
        ShapeTextView shapeTextView = a.b;
        shapeTextView.setText(yYGiftModel.count + "");
        if (yYGiftModel.marker == null || "".equals(yYGiftModel.marker)) {
            a.g.setVisibility(8);
        } else {
            a.g.setText(yYGiftModel.marker);
            a.g.setVisibility(0);
        }
        if (yYGiftModel.double_hit != 1 || TextUtils.equals("1", yYGiftModel.is_free)) {
            a.d.setVisibility(8);
        } else {
            a.d.setVisibility(0);
            if (yYGiftModel.comboWaitTime > 0) {
                a.d.a(yYGiftModel.comboWaitTime);
            } else {
                a.d.b();
            }
        }
        if (yYGiftModel.isSelected) {
            a.h.setBackgroundResource(R.drawable.shape_gift_select);
            if (yYGiftModel.comboWaitTime == 0) {
                a(commonAdapterHolder.a(R.id.item_live_gift_view_iv));
            }
        } else {
            a.h.setBackgroundResource(R.color.transparent);
        }
        if (StringUtils.a(yYGiftModel.fans_exclusive_level, 0) <= 0) {
            a.a.setText("");
            a.a.setVisibility(8);
            return;
        }
        a.a.setVisibility(0);
        ShapeTextView shapeTextView2 = a.a;
        shapeTextView2.setText("Lv." + yYGiftModel.fans_exclusive_level);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new CubicInterpolator(0.2f, 0.04f, 0.83f, 0.96f));
        scaleAnimation.setDuration(700L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.yy_china.adapter.YYGiftAdapter.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                YYGiftAdapter.this.a(view);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(scaleAnimation);
    }

    private void b(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, YYGiftModel yYGiftModel) {
        ItemYyGiftNomerBinding a = ItemYyGiftNomerBinding.a(commonAdapterHolder.itemView);
        a.c.setText(yYGiftModel.name);
        ImageLoader.a(this.b, yYGiftModel.images_static).b(R.drawable.gift_default_icon).a(a.e);
        if (yYGiftModel.type == 1) {
            a.d.setText("攒人气");
            a.d.setCompoundDrawables(null, null, null, null);
        } else {
            a.d.setText(CommonStringUtils.a(yYGiftModel.beans));
            a.d.setCompoundDrawables(this.a, null, null, null);
        }
        if (yYGiftModel.marker == null || "".equals(yYGiftModel.marker)) {
            a.f.setVisibility(8);
        } else {
            a.f.setText(yYGiftModel.marker);
            a.f.setVisibility(0);
        }
        if (yYGiftModel.double_hit != 1 || TextUtils.equals("1", yYGiftModel.is_free)) {
            a.b.setVisibility(8);
        } else {
            a.b.setVisibility(0);
            if (yYGiftModel.comboWaitTime > 0) {
                a.b.a(yYGiftModel.comboWaitTime);
            } else {
                a.b.b();
            }
        }
        if (yYGiftModel.isSelected) {
            a.g.setBackgroundResource(R.drawable.shape_gift_select);
            if (yYGiftModel.comboWaitTime == 0) {
                a(commonAdapterHolder.a(R.id.item_live_gift_view_iv));
            }
        } else {
            a.g.setBackgroundResource(R.color.transparent);
        }
        if (StringUtils.a(yYGiftModel.fans_exclusive_level, 0) <= 0) {
            a.a.setText("");
            a.a.setVisibility(8);
            return;
        }
        a.a.setVisibility(0);
        ShapeTextView shapeTextView = a.a;
        shapeTextView.setText("Lv." + yYGiftModel.fans_exclusive_level);
    }

    @Override // com.blued.android.module.common.adapter.BaseGiftAdapter
    public void a(BaseGiftModel baseGiftModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        if (baseGiftModel instanceof YYGiftModel) {
            YYGiftModel yYGiftModel = (YYGiftModel) baseGiftModel;
            if (yYGiftModel.isBag()) {
                a(commonAdapterHolder, yYGiftModel);
            } else {
                b(commonAdapterHolder, yYGiftModel);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getItemViewType(int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return i == 1 ? R.layout.item_yy_gift_bag : R.layout.item_yy_gift_nomer;
    }
}
