package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyMemberSaleBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberSaleView.class */
public class YYMemberSaleView extends ConstraintLayout {
    private ViewYyMemberSaleBinding a;

    public YYMemberSaleView(Context context) {
        this(context, null);
    }

    public YYMemberSaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMemberSaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private int a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.color.transparent : R.color.syc_B7B7B7 : R.color.syc_FEAC17 : R.color.syc_FF7932 : R.color.syc_FD4848;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        this.a = ViewYyMemberSaleBinding.a(LayoutInflater.from(getContext()), this, true);
        if (YYRoomInfoManager.e().b().voice_skin_info != null) {
            ImageLoader.a((IRequestHost) null, YYRoomInfoManager.e().b().voice_skin_info.getIcon()).a((Target<Drawable>) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYMemberSaleView.1
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    YYMemberSaleView.this.a.e.setBackgroundDrawable(drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(YYSeatMemberModel yYSeatMemberModel, BaseYYStudioFragment baseYYStudioFragment, View view) {
        if (StringUtils.a(yYSeatMemberModel.getUid(), 0) <= 0 || YYRoomInfoManager.e().a == null || baseYYStudioFragment == null || yYSeatMemberModel == null) {
            return;
        }
        baseYYStudioFragment.a(yYSeatMemberModel.getUid(), yYSeatMemberModel.getName(), yYSeatMemberModel.getAvatar(), YYRoomInfoManager.e().a.chat_anchor, true);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.a.a.a(iRequestHost, str, str2, yYImModel);
    }

    public void a(final YYSeatMemberModel yYSeatMemberModel, final BaseYYStudioFragment baseYYStudioFragment) {
        double a = StringUtils.a(yYSeatMemberModel.gift_value, 0);
        int i = (a > 0.0d ? 1 : (a == 0.0d ? 0 : -1));
        this.a.d.setVisibility(i > 0 ? 0 : 8);
        this.a.d.setText(i > 0 ? CommonStringUtils.b(a) : "");
        if (StringUtils.a(yYSeatMemberModel.value_order, 0) == 1) {
            this.a.d.setBackgroundResource(R.drawable.icon_yy_sale_value_light);
        } else {
            this.a.d.setBackgroundResource(R.drawable.icon_yy_sale_value_default);
        }
        if (StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
            this.a.b.setVisibility(8);
            this.a.c.setVisibility(0);
            this.a.c.setText("NO." + yYSeatMemberModel.value_order);
            ShapeHelper.b(this.a.c, a(StringUtils.a(yYSeatMemberModel.value_order, 0)));
        } else {
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(8);
        }
        this.a.a.a(false);
        this.a.a.setNoAudienceView(this.a.b);
        this.a.a.a(yYSeatMemberModel, baseYYStudioFragment.getFragmentActive());
        this.a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMemberSaleView$hcgpcn4dqgegUjBQbvDoEsgV4Zc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMemberSaleView.a(YYSeatMemberModel.this, baseYYStudioFragment, view);
            }
        });
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.a.a.a(getViewX_Y_W_H);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.a.a.a(set, yYSeatMemberModel);
    }
}
