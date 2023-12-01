package com.blued.android.module.live_china.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftPropExpireDlgFragment.class */
public class LiveGiftPropExpireDlgFragment extends LiveBaseDialogFragment {
    private ImageView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private ShapeTextView p;
    private TextView q;
    private LiveGiftModel r;

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
        if (this.r == null) {
            return;
        }
        ImageLoader.a(a(), this.r.images_static).b(R.drawable.gift_default_icon).a(this.j);
        this.k.setText(this.r.name);
        if (this.r.effect_time <= 0 || this.r.is_use == 1) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
            if (this.r.effect_time < b.P) {
                this.o.setText(String.format(getString(R.string.live_pocket_exp_time_minute), Long.valueOf(this.r.effect_time / 60)));
            } else if (this.r.effect_time <= 86400) {
                this.o.setText(String.format(getString(R.string.live_pocket_exp_time_hour), Long.valueOf(this.r.effect_time / b.P)));
            } else {
                this.o.setText(String.format(getString(R.string.live_pocket_exp_time_day), Long.valueOf(this.r.effect_time / 86400)));
            }
        }
        if (Long.parseLong(this.r.expire_time) <= 0) {
            this.n.setVisibility(0);
            this.n.setText(getString(R.string.never_expires));
        } else {
            this.n.setVisibility(0);
            if (this.r.is_use != 1) {
                this.n.setText(String.format(getString(R.string.live_prop_date_use), ((SimpleDateFormat) Objects.requireNonNull(TimeAndDateUtils.i.get())).format(new Date(Long.parseLong(this.r.expire_time) * 1000))));
            } else {
                this.n.setText(String.format(AppInfo.d().getString(R.string.live_pocket_exp_over1), TimeAndDateUtils.i.get().format(new Date(Long.parseLong(this.r.expire_time) * 1000))));
            }
        }
        if (this.r.is_use == 1) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.r.desc)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(this.r.desc);
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_gift_prop_expire;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftPropExpireDlgFragment$VaAAfVXbegtmKE2iwSkUv1SVgrg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftPropExpireDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.live_gift_expire_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftPropExpireDlgFragment$hmisZb1jHagazKoZFoJFQxJvSSw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftPropExpireDlgFragment.this.b(view);
            }
        });
        this.b.findViewById(R.id.live_gift_expire_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftPropExpireDlgFragment$V0NgaojzqBPErgNfCHh6XCQJv4w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftPropExpireDlgFragment.this.a(view);
            }
        });
        this.j = (ImageView) this.b.findViewById(R.id.live_gift_expire_img);
        this.k = (TextView) this.b.findViewById(R.id.live_gift_expire_name);
        this.l = (ImageView) this.b.findViewById(R.id.live_gift_expire_price_icon);
        this.m = (TextView) this.b.findViewById(R.id.live_gift_expire_price);
        this.n = (TextView) this.b.findViewById(R.id.live_gift_expire_time);
        this.o = (TextView) this.b.findViewById(R.id.live_gift_expire_effective_time);
        this.p = (ShapeTextView) this.b.findViewById(R.id.live_gift_expire_in_effect);
        this.q = (TextView) this.b.findViewById(R.id.live_gift_expire_info);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        super.f();
        this.r = (LiveGiftModel) this.f10822c.getSerializable("gift_model");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k();
    }
}
