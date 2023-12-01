package com.blued.android.module.live_china.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftExpireDlgFragment.class */
public class LiveGiftExpireDlgFragment extends LiveBaseDialogFragment {
    private ImageView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private LiveGiftModel o;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        j();
    }

    private void k() {
        if (this.o == null) {
            return;
        }
        ImageLoader.a(a(), this.o.images_static).b(R.drawable.gift_default_icon).a(this.j);
        this.k.setText(this.o.name);
        if (TextUtils.isEmpty(this.o.desc)) {
            this.l.setVisibility(0);
            this.m.setText(CommonStringUtils.a(this.o.beans));
        } else {
            this.l.setVisibility(8);
            this.m.setText(this.o.desc);
        }
        if (TextUtils.isEmpty(this.o.expire_info)) {
            return;
        }
        if (!this.o.expire_info.contains("前使用")) {
            this.n.setText(this.o.expire_info);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.o.expire_info);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6533")), 2, this.o.expire_info.indexOf("前使用"), 33);
        this.n.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_gift_expire;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftExpireDlgFragment$TuunBuDj0QgM8Jd18eq2809tR7M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftExpireDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.live_gift_expire_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftExpireDlgFragment$9mrhyM3iXBgnSE42YM5YBTaQybI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftExpireDlgFragment.this.b(view);
            }
        });
        this.b.findViewById(R.id.live_gift_expire_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftExpireDlgFragment$Ex3fnjbmCCT8y1gUPegrpNbrasA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftExpireDlgFragment.this.a(view);
            }
        });
        this.j = (ImageView) this.b.findViewById(R.id.live_gift_expire_img);
        this.k = (TextView) this.b.findViewById(R.id.live_gift_expire_name);
        this.l = (ImageView) this.b.findViewById(R.id.live_gift_expire_price_icon);
        this.m = (TextView) this.b.findViewById(R.id.live_gift_expire_price);
        this.n = (TextView) this.b.findViewById(R.id.live_gift_expire_time);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        super.f();
        this.o = (LiveGiftModel) this.c.getSerializable("gift_model");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k();
    }
}
