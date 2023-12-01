package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberCPView.class */
public class YYMemberCPView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private YYBaseUserHeadView f18309a;
    private ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18310c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private YYRoomModel j;
    private boolean k;
    private YYSeatMemberModel l;
    private View.OnClickListener m;
    private int n;
    private int o;
    private int p;

    public YYMemberCPView(Context context) {
        this(context, null);
    }

    public YYMemberCPView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMemberCPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.n = DensityUtils.a(getContext(), 6.0f);
        this.o = DensityUtils.a(getContext(), 4.0f);
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_member_cp, (ViewGroup) this, true);
        this.f18309a = (YYBaseUserHeadView) findViewById(R.id.base_us_head);
        this.b = (ConstraintLayout) findViewById(R.id.fl_cp_heart);
        this.f18310c = (TextView) findViewById(R.id.tv_like_index);
        this.d = (TextView) findViewById(R.id.tv_audience_index);
        this.e = (TextView) findViewById(R.id.tv_audience_name);
        this.f = (TextView) findViewById(R.id.tv_selected_number);
        this.g = (ImageView) findViewById(R.id.img_selected_bg);
        this.h = (ImageView) findViewById(R.id.img_selected);
        this.i = (LinearLayout) findViewById(R.id.ll_normal_number);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYMemberCPView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYMemberCPView.this.m == null || YYMemberCPView.this.l == null || TextUtils.equals(YYMemberCPView.this.l.getUid(), YYRoomInfoManager.e().k())) {
                    return;
                }
                view.setTag(YYMemberCPView.this.l.getUid());
                YYMemberCPView.this.m.onClick(view);
            }
        });
    }

    private boolean c(YYSeatMemberModel yYSeatMemberModel) {
        boolean z = false;
        if (StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLlNormalNumberMargin(ConstraintLayout.LayoutParams layoutParams) {
        if (this.l.isVip) {
            layoutParams.topMargin = this.p + this.o;
        } else {
            layoutParams.topMargin = this.p - this.n;
        }
    }

    public void a() {
        this.h.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        YYBaseUserHeadView yYBaseUserHeadView = this.f18309a;
        if (yYBaseUserHeadView != null) {
            yYBaseUserHeadView.a(iRequestHost, str, str2, yYImModel);
        }
    }

    public void a(YYSeatMemberModel yYSeatMemberModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.j = b;
        if (this.b == null || b == null) {
            return;
        }
        if (!YYRoomInfoManager.e().y() && this.j.getCPPresentStep() < 3) {
            yYSeatMemberModel.likeNum = "";
            this.b.setVisibility(8);
        } else if (TextUtils.isEmpty(yYSeatMemberModel.likeNum)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            int a2 = StringUtils.a(yYSeatMemberModel.likeNum, 0);
            TextView textView = this.f18310c;
            textView.setText(a2 + "");
        }
    }

    public void a(final YYSeatMemberModel yYSeatMemberModel, final BaseFragment baseFragment) {
        this.l = yYSeatMemberModel;
        YYBaseUserHeadView yYBaseUserHeadView = this.f18309a;
        if (yYBaseUserHeadView != null) {
            yYBaseUserHeadView.a(yYSeatMemberModel, baseFragment.getFragmentActive());
            if (this.p <= 0) {
                this.p = this.f18309a.getHeight();
            }
        }
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(yYSeatMemberModel.isVip ? R.drawable.shape_layer_vip_background : R.color.transparent);
            final ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.i.getLayoutParams();
            if (this.p <= 0) {
                this.f18309a.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYMemberCPView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        YYMemberCPView yYMemberCPView = YYMemberCPView.this;
                        yYMemberCPView.p = yYMemberCPView.f18309a.getHeight();
                        YYMemberCPView.this.setLlNormalNumberMargin(layoutParams);
                    }
                });
            } else {
                setLlNormalNumberMargin(layoutParams);
            }
        }
        TextView textView = this.d;
        if (textView != null) {
            if (!this.k) {
                textView.setVisibility(8);
            } else if (!yYSeatMemberModel.isVip || c(yYSeatMemberModel)) {
                this.d.setVisibility(0);
                this.d.setBackgroundResource(yYSeatMemberModel.isVip ? R.color.transparent : R.drawable.shape_raduis_2dp_b3000000);
                TextView textView2 = this.d;
                textView2.setText(yYSeatMemberModel.mic_position + "");
            } else {
                this.d.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(yYSeatMemberModel.getName())) {
                this.e.setText(YYRoomInfoManager.e().a(yYSeatMemberModel.getUid(), yYSeatMemberModel.getName()));
            } else if (yYSeatMemberModel.isVip) {
                this.e.setText("老板位");
            } else {
                this.e.setText("号麦位");
            }
        }
        LiveEventBus.get("take_off_mask", String.class).observe(baseFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYMemberCPView.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                LogUtils.d("YYMemberCPView", "member uid: " + yYSeatMemberModel.getUid() + " ; uid: " + str);
                YYSeatMemberModel yYSeatMemberModel2 = yYSeatMemberModel;
                if (yYSeatMemberModel2 == null || !TextUtils.equals(yYSeatMemberModel2.getUid(), str) || YYMemberCPView.this.f18309a == null) {
                    return;
                }
                YYMemberCPView.this.e.setText(YYRoomInfoManager.e().a(yYSeatMemberModel.getUid(), yYSeatMemberModel.getName()));
                YYMemberCPView.this.f18309a.a(yYSeatMemberModel, baseFragment.getFragmentActive());
            }
        });
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.f18309a.a(getViewX_Y_W_H);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        YYBaseUserHeadView yYBaseUserHeadView = this.f18309a;
        if (yYBaseUserHeadView != null) {
            yYBaseUserHeadView.a(set, yYSeatMemberModel);
        }
    }

    public void b(YYSeatMemberModel yYSeatMemberModel) {
        if (yYSeatMemberModel == null) {
            return;
        }
        if (yYSeatMemberModel.isSelected) {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            this.h.setVisibility(8);
            this.f.setVisibility(0);
            TextView textView = this.f;
            textView.setText(yYSeatMemberModel.mic_position + "");
        }
        if (!TextUtils.equals(this.l.getUid(), YYRoomInfoManager.e().k())) {
            this.g.setVisibility(0);
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setVisibility(8);
    }

    public void setOnSelectListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setSeatNumberBackground(int i) {
        this.d.setBackgroundResource(i);
    }

    public void setShowPosition(boolean z) {
        this.k = z;
    }
}
