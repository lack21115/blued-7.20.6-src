package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentMagicalBoxBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPreciousPackageModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYMagicalBoxFragment.class */
public final class YYMagicalBoxFragment extends BaseFullScreenDialog {
    private YYPreciousPackageModel a;
    private FragmentMagicalBoxBinding b;
    private boolean c;
    private int d;
    private int e;
    private long f;

    public YYMagicalBoxFragment(YYPreciousPackageModel yYPreciousPackageModel) {
        this.a = yYPreciousPackageModel;
    }

    private final void a(int i) {
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        ProgressBar progressBar = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.h;
        if (progressBar != null) {
            progressBar.setMax(this.d);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        ProgressBar progressBar2 = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.h;
        if (progressBar2 != null) {
            progressBar2.setProgress(i);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        TextView textView = fragmentMagicalBoxBinding3 == null ? null : fragmentMagicalBoxBinding3.m;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('/');
            sb.append(this.d);
            textView.setText(sb.toString());
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding4 = this.b;
        TextView textView2 = fragmentMagicalBoxBinding4 == null ? null : fragmentMagicalBoxBinding4.j;
        if (textView2 == null) {
            return;
        }
        int i2 = this.d;
        int i3 = this.e;
        textView2.setText(String.valueOf(i2 - i3 < 0 ? 0 : i2 - i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxFragment this$0, YYPreciousPackageModel yYPreciousPackageModel) {
        Intrinsics.e(this$0, "this$0");
        if (yYPreciousPackageModel == null) {
            return;
        }
        if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_big)) {
            ImageWrapper b = ImageLoader.a(this$0.a(), yYPreciousPackageModel.icon_big).b(R.drawable.icon_precious_box);
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this$0.b;
            b.a(fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.f);
        }
        if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_small)) {
            ImageWrapper b2 = ImageLoader.a(this$0.a(), yYPreciousPackageModel.icon_small).b(R.drawable.icon_precious_box_small);
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this$0.b;
            b2.a(fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.e);
        }
        if (StringUtils.a(yYPreciousPackageModel.grant, -1) >= 0) {
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this$0.b;
            TextView textView = fragmentMagicalBoxBinding3 == null ? null : fragmentMagicalBoxBinding3.k;
            if (textView != null) {
                textView.setText("今日累计掉落宝箱雨" + ((Object) yYPreciousPackageModel.grant) + (char) 27425);
            }
        }
        if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_small)) {
            ImageWrapper b3 = ImageLoader.a(this$0.a(), yYPreciousPackageModel.icon_small).b(R.drawable.icon_precious_box_small);
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding4 = this$0.b;
            b3.a(fragmentMagicalBoxBinding4 == null ? null : fragmentMagicalBoxBinding4.e);
        }
        if (StringUtils.a(yYPreciousPackageModel.grant, -1) >= 0) {
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding5 = this$0.b;
            TextView textView2 = fragmentMagicalBoxBinding5 == null ? null : fragmentMagicalBoxBinding5.k;
            if (textView2 != null) {
                textView2.setText("今日累计掉落宝箱雨" + ((Object) yYPreciousPackageModel.grant) + (char) 27425);
            }
        }
        this$0.a(yYPreciousPackageModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxFragment this$0, Long l) {
        Intrinsics.e(this$0, "this$0");
        this$0.c = true;
        this$0.a(l);
    }

    private final void a(YYPreciousPackageModel yYPreciousPackageModel) {
        ImageView imageView;
        if (yYPreciousPackageModel != null) {
            this.d = StringUtils.a(yYPreciousPackageModel.need_total_beans, 0);
            this.e = StringUtils.a(yYPreciousPackageModel.current_beans, 0);
        }
        a(this.e);
        j();
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        ImageView imageView2 = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.b;
        if (imageView2 != null) {
            imageView2.setEnabled(false);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        TextView textView = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.n;
        if (textView != null) {
            textView.setText("暂不可掉落");
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        if (fragmentMagicalBoxBinding3 == null || (imageView = fragmentMagicalBoxBinding3.b) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.icon_take_prize_inactive);
    }

    private final void a(Long l) {
        ImageView imageView;
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        ImageView imageView2 = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.b;
        if (imageView2 != null) {
            imageView2.setEnabled(true);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        TextView textView = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.n;
        if (textView != null) {
            SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
            Intrinsics.a(simpleDateFormat);
            textView.setText(Intrinsics.a("掉落 ", (Object) simpleDateFormat.format(l)));
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        if (fragmentMagicalBoxBinding3 == null || (imageView = fragmentMagicalBoxBinding3.b) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.icon_take_prize_waiting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalBoxFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalBoxFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.c) {
            ToastUtils.a("宝箱雨即将掉落，请耐心等待");
        } else {
            this$0.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalBoxFragment this$0, YYPreciousPackageModel yYPreciousPackageModel) {
        Intrinsics.e(this$0, "this$0");
        if (yYPreciousPackageModel == null) {
            return;
        }
        YYPreciousPackageModel yYPreciousPackageModel2 = this$0.a;
        if (yYPreciousPackageModel2 != null) {
            if (yYPreciousPackageModel2 != null) {
                yYPreciousPackageModel2.count_down = yYPreciousPackageModel.count_down;
            }
            YYPreciousPackageModel yYPreciousPackageModel3 = this$0.a;
            if (yYPreciousPackageModel3 != null) {
                yYPreciousPackageModel3.level = yYPreciousPackageModel.level;
            }
            YYPreciousPackageModel yYPreciousPackageModel4 = this$0.a;
            if (yYPreciousPackageModel4 != null) {
                yYPreciousPackageModel4.trigger_vanish_time = yYPreciousPackageModel.trigger_vanish_time;
            }
            YYPreciousPackageModel yYPreciousPackageModel5 = this$0.a;
            if (yYPreciousPackageModel5 != null) {
                yYPreciousPackageModel5.animation = yYPreciousPackageModel.animation;
            }
            YYPreciousPackageModel yYPreciousPackageModel6 = this$0.a;
            if (yYPreciousPackageModel6 != null) {
                yYPreciousPackageModel6.grant = yYPreciousPackageModel.grant;
            }
            YYPreciousPackageModel yYPreciousPackageModel7 = this$0.a;
            if (yYPreciousPackageModel7 != null) {
                yYPreciousPackageModel7.icon_big = yYPreciousPackageModel.icon_big;
            }
            YYPreciousPackageModel yYPreciousPackageModel8 = this$0.a;
            if (yYPreciousPackageModel8 != null) {
                yYPreciousPackageModel8.icon_middle = yYPreciousPackageModel.icon_middle;
            }
            YYPreciousPackageModel yYPreciousPackageModel9 = this$0.a;
            if (yYPreciousPackageModel9 != null) {
                yYPreciousPackageModel9.icon_small = yYPreciousPackageModel.icon_middle;
            }
        } else {
            this$0.a = yYPreciousPackageModel;
        }
        this$0.b(yYPreciousPackageModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalBoxFragment this$0, Long l) {
        Intrinsics.e(this$0, "this$0");
        this$0.c = true;
        this$0.a(l);
    }

    private final void b(YYPreciousPackageModel yYPreciousPackageModel) {
        String str;
        String str2;
        this.f = StringUtils.a(yYPreciousPackageModel == null ? null : yYPreciousPackageModel.trigger_vanish_time, 0L);
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        TextView textView = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.k;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("今日累计掉落宝箱雨");
            sb.append((Object) (yYPreciousPackageModel == null ? null : yYPreciousPackageModel.grant));
            sb.append((char) 27425);
            textView.setText(sb.toString());
        }
        if (yYPreciousPackageModel != null && (str2 = yYPreciousPackageModel.icon_small) != null) {
            ImageWrapper b = ImageLoader.a(a(), str2).b(R.drawable.icon_precious_box_small);
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
            b.a(fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.e);
        }
        if (yYPreciousPackageModel == null || (str = yYPreciousPackageModel.icon_big) == null) {
            return;
        }
        ImageWrapper b2 = ImageLoader.a(a(), str).b(R.drawable.icon_precious_box);
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        b2.a(fragmentMagicalBoxBinding3 == null ? null : fragmentMagicalBoxBinding3.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYMagicalBoxFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (YYRoomInfoManager.e().b() != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_RAIN_QUESTION_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid);
        }
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a((BaseFragment) this$0.getParentFragment(), YYRoomInfoManager.e().c(9));
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYWebViewDialogFragment.show(childFragmentManager, "yy_precious_box_guide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYMagicalBoxFragment this$0, YYPreciousPackageModel yYPreciousPackageModel) {
        Intrinsics.e(this$0, "this$0");
        if (yYPreciousPackageModel == null) {
            return;
        }
        this$0.d = StringUtils.a(yYPreciousPackageModel.need_total_beans, 0);
        int a = StringUtils.a(yYPreciousPackageModel.current_beans, 0);
        this$0.e = a;
        this$0.a(a);
        this$0.j();
    }

    private final void f() {
        ImageView imageView;
        ImageView imageView2;
        View view;
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        if (fragmentMagicalBoxBinding != null && (view = fragmentMagicalBoxBinding.c) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$U-mZIbXOi2FB5wQx9_RI4gyxImk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYMagicalBoxFragment.a(YYMagicalBoxFragment.this, view2);
                }
            });
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        if (fragmentMagicalBoxBinding2 != null && (imageView2 = fragmentMagicalBoxBinding2.b) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$jbY8-Misz_PZBiAMybEgcE2kx-o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYMagicalBoxFragment.b(YYMagicalBoxFragment.this, view2);
                }
            });
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        if (fragmentMagicalBoxBinding3 == null || (imageView = fragmentMagicalBoxBinding3.a) == null) {
            return;
        }
        imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$YekCZF1ChwNs19eGezvk_VJS9Mw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYMagicalBoxFragment.c(YYMagicalBoxFragment.this, view2);
            }
        }));
    }

    private final void g() {
        YYPreciousPackageModel yYPreciousPackageModel = this.a;
        if (yYPreciousPackageModel == null) {
            return;
        }
        a(yYPreciousPackageModel);
        b(yYPreciousPackageModel);
        int i = this.e;
        int i2 = this.d;
        if (i < i2) {
            h();
        } else if (i >= i2) {
            if (StringUtils.a(yYPreciousPackageModel.count_down, 0L) > 1) {
                a(Long.valueOf(StringUtils.a(yYPreciousPackageModel.count_down, 0L)));
            } else {
                i();
            }
        }
    }

    private final void h() {
        ImageView imageView;
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        ImageView imageView2 = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.b;
        if (imageView2 != null) {
            imageView2.setEnabled(false);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        TextView textView = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.n;
        if (textView != null) {
            textView.setText("暂不可掉落");
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        if (fragmentMagicalBoxBinding3 == null || (imageView = fragmentMagicalBoxBinding3.b) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.icon_take_prize_inactive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        ImageView imageView;
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
        ImageView imageView2 = fragmentMagicalBoxBinding == null ? null : fragmentMagicalBoxBinding.b;
        if (imageView2 != null) {
            imageView2.setEnabled(true);
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
        TextView textView = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.n;
        if (textView != null) {
            textView.setText("抢");
        }
        FragmentMagicalBoxBinding fragmentMagicalBoxBinding3 = this.b;
        if (fragmentMagicalBoxBinding3 != null && (imageView = fragmentMagicalBoxBinding3.b) != null) {
            imageView.setImageResource(R.drawable.icon_take_prize_active);
        }
        long j = this.f;
        if (j <= 0) {
            return;
        }
        this.f = j * 1000;
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$PDqt8ByooWTh1jeXEmwGEaj0tRc
            @Override // java.lang.Runnable
            public final void run() {
                YYMagicalBoxFragment.b(YYMagicalBoxFragment.this);
            }
        }, this.f);
    }

    private final void j() {
        int i = this.e;
        int i2 = this.d;
        TextView textView = null;
        if (i < i2) {
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding = this.b;
            if (fragmentMagicalBoxBinding != null) {
                textView = fragmentMagicalBoxBinding.l;
            }
            if (textView == null) {
                return;
            }
            textView.setText(getResources().getString(R.string.yy_ready_fall_gift));
        } else if (i >= i2) {
            FragmentMagicalBoxBinding fragmentMagicalBoxBinding2 = this.b;
            TextView textView2 = fragmentMagicalBoxBinding2 == null ? null : fragmentMagicalBoxBinding2.l;
            if (textView2 == null) {
                return;
            }
            textView2.setText("已达到掉落宝箱雨");
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_magical_box, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…cal_box, container, true)");
        this.b = FragmentMagicalBoxBinding.a(inflate);
        f();
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("update_coin_num", YYPreciousPackageModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$4gMwctaI_mQ0Ilr3dH5zioQDACI
            public final void onChanged(Object obj) {
                YYMagicalBoxFragment.a(YYMagicalBoxFragment.this, (YYPreciousPackageModel) obj);
            }
        });
        LiveEventBus.get("fall_down_prize", YYPreciousPackageModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$IoS4HRppJvI5PBAy8HEpkWFLG4w
            public final void onChanged(Object obj) {
                YYMagicalBoxFragment.b(YYMagicalBoxFragment.this, (YYPreciousPackageModel) obj);
            }
        });
        LiveEventBus.get("reset_magical_info", YYPreciousPackageModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$noDML3ofyDs9lM-0sFwhpnxsQ_g
            public final void onChanged(Object obj) {
                YYMagicalBoxFragment.c(YYMagicalBoxFragment.this, (YYPreciousPackageModel) obj);
            }
        });
        LiveEventBus.get("grab_prize_prepare", Long.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$dWeIdLDm-xegJGtrGHCZTmSyRp4
            public final void onChanged(Object obj) {
                YYMagicalBoxFragment.a(YYMagicalBoxFragment.this, (Long) obj);
            }
        });
        LiveEventBus.get("grab_prize_start", Long.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalBoxFragment$iNccDpW5aJ2t7a5OiKaEd972FcU
            public final void onChanged(Object obj) {
                YYMagicalBoxFragment.b(YYMagicalBoxFragment.this, (Long) obj);
            }
        });
        LiveEventBus.get("grab_prize_end", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.fragment.YYMagicalBoxFragment$onViewCreated$6
            /* renamed from: a */
            public void onChanged(String str) {
                YYMagicalBoxFragment.this.c = false;
                YYMagicalBoxFragment.this.i();
            }
        });
    }
}
