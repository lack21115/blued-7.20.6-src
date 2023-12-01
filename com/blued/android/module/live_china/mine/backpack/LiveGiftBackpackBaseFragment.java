package com.blued.android.module.live_china.mine.backpack;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.MultiItemTypeSupport;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.OverridingMethodsMustInvokeSuper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackBaseFragment.class */
public abstract class LiveGiftBackpackBaseFragment<p extends MvpPresenter> extends MvpFragment<p> {
    protected ImageView a;
    protected View b;
    protected ListView c;
    protected CommonAdapter d;
    protected CommonLiveGiftModel g;
    protected LiveGiftBackpackBaseFragment<p>.LiveGiftComboTimer k;
    private ViewGroup q;
    protected String e = "";
    protected boolean f = true;
    private int n = 0;
    private int o = 100;
    protected int l = 10;
    private String p = "live_gift";
    int[] m = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackBaseFragment$2.class */
    public class AnonymousClass2 extends CommonAdapter<LiveGiftNumberModel> {
        AnonymousClass2(List list, MultiItemTypeSupport multiItemTypeSupport) {
            super(list, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveGiftNumberModel liveGiftNumberModel, View view) {
            if (liveGiftNumberModel.isUserDefined) {
                LiveGiftBackpackBaseFragment.this.a(liveGiftNumberModel);
            } else {
                LiveGiftBackpackBaseFragment.this.b(liveGiftNumberModel);
            }
            LiveGiftBackpackBaseFragment.this.b(false);
        }

        @Override // com.blued.android.module.common.adapter.CommonAdapter
        public void a(CommonAdapter.ViewHolder viewHolder, final LiveGiftNumberModel liveGiftNumberModel, int i) {
            viewHolder.a(R.id.item_live_gift_select_name, liveGiftNumberModel.name).a(R.id.item_live_gift_select_num_tv, String.valueOf(liveGiftNumberModel.count));
            if (LiveGiftBackpackBaseFragment.this.f) {
                viewHolder.b(R.id.item_live_gift_select_name, 0);
            } else {
                viewHolder.b(R.id.item_live_gift_select_name, 8);
            }
            if (liveGiftNumberModel.selected) {
                viewHolder.a(R.id.item_live_gift_select_num_tv, -1);
                viewHolder.a(R.id.item_live_gift_select_name, -1);
            } else {
                viewHolder.a(R.id.item_live_gift_select_num_tv, Color.parseColor("#99FFFFFF"));
                viewHolder.a(R.id.item_live_gift_select_name, Color.parseColor("#99FFFFFF"));
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackBaseFragment$2$Q-i0NPSROUYUlSs8FVuv2ZMXqCo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBackpackBaseFragment.AnonymousClass2.this.a(liveGiftNumberModel, view);
                }
            });
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackBaseFragment$LiveGiftComboTimer.class */
    public class LiveGiftComboTimer extends Timer {
        CommonLiveGiftModel a;

        public LiveGiftComboTimer(CommonLiveGiftModel commonLiveGiftModel) {
            this.a = commonLiveGiftModel;
        }
    }

    static /* synthetic */ int a(LiveGiftBackpackBaseFragment liveGiftBackpackBaseFragment) {
        int i = liveGiftBackpackBaseFragment.n;
        liveGiftBackpackBaseFragment.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b(false);
    }

    private ViewGroup y() {
        if (this.q == null) {
            this.q = (ViewGroup) getActivity().getWindow().getDecorView();
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CommonLiveGiftModel commonLiveGiftModel) {
        w();
    }

    protected void a(CommonLiveGiftModel commonLiveGiftModel, int i) {
        int i2 = this.l;
        int i3 = i;
        if (i > i2) {
            i3 = i2;
        }
        if (commonLiveGiftModel == null) {
            return;
        }
        LogUtils.c(commonLiveGiftModel.index + " left double hit time: " + i3);
        if (commonLiveGiftModel.double_hit == 1) {
            commonLiveGiftModel.comboWaitTime = i3;
            if (i3 <= 0) {
                commonLiveGiftModel.hit_count = 0;
            }
            LiveEventBus.get("gift_item_update").post(commonLiveGiftModel);
        }
    }

    protected void a(LiveGiftNumberModel liveGiftNumberModel) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<LiveGiftNumberModel> list) {
        if (TypeUtils.a((List<?>) list)) {
            return;
        }
        b(true);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackBaseFragment$A3JXCjnHs_tUPSawn8tYlr3-wCs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftBackpackBaseFragment.this.a(view);
            }
        });
        if (this.d == null) {
            e();
            this.c.setAdapter((ListAdapter) this.d);
        }
        this.d.a(list);
    }

    protected abstract int b();

    protected void b(CommonLiveGiftModel commonLiveGiftModel, int i) {
        LiveGiftModel x = x();
        if (x == null || commonLiveGiftModel == null || !StringUtils.a(x.goods_id, commonLiveGiftModel.goods_id) || x.comboWaitTime <= 0) {
            w();
        } else {
            v();
        }
        LiveGiftBackpackBaseFragment<p>.LiveGiftComboTimer liveGiftComboTimer = new LiveGiftComboTimer(commonLiveGiftModel);
        this.k = liveGiftComboTimer;
        liveGiftComboTimer.schedule(new TimerTask() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LiveGiftBackpackBaseFragment.this.getParentFragment() == null || !((BaseFragment) LiveGiftBackpackBaseFragment.this.getParentFragment()).getFragmentActive().isActive()) {
                    return;
                }
                LiveGiftBackpackBaseFragment.a(LiveGiftBackpackBaseFragment.this);
                LiveGiftModel x2 = LiveGiftBackpackBaseFragment.this.x();
                if (LiveGiftBackpackBaseFragment.this.k == null || LiveGiftBackpackBaseFragment.this.k.a == null) {
                    LiveGiftBackpackBaseFragment.this.n = 0;
                    return;
                }
                if (x2 != null) {
                    try {
                        if (LiveGiftBackpackBaseFragment.this.k != null && LiveGiftBackpackBaseFragment.this.k.a != null && StringUtils.a(x2.goods_id, LiveGiftBackpackBaseFragment.this.k.a.goods_id)) {
                            LiveGiftBackpackBaseFragment.this.d(x2, LiveGiftBackpackBaseFragment.this.n);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LiveGiftBackpackBaseFragment.this.v();
                        return;
                    }
                }
                LiveGiftBackpackBaseFragment.this.v();
            }
        }, 0L, this.o);
        c(commonLiveGiftModel, i);
    }

    protected void b(LiveGiftNumberModel liveGiftNumberModel) {
    }

    public void b(boolean z) {
        if (c() != -1 && d() != -1) {
            this.a.setImageResource(z ? c() : d());
        }
        this.b.setVisibility(z ? 0 : 8);
    }

    public int c() {
        return -1;
    }

    protected void c(CommonLiveGiftModel commonLiveGiftModel, int i) {
    }

    public int d() {
        return -1;
    }

    protected void d(CommonLiveGiftModel commonLiveGiftModel, int i) {
        int i2 = i / 5;
        if (i % 5 == 0) {
            a(commonLiveGiftModel, this.l - i2);
        }
        if (i2 >= this.l) {
            a(commonLiveGiftModel);
        }
    }

    protected void e() {
        this.d = new AnonymousClass2(new ArrayList(), new MultiItemTypeSupport<LiveGiftNumberModel>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment.1
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a() {
                return 2;
            }

            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a(int i, LiveGiftNumberModel liveGiftNumberModel) {
                return liveGiftNumberModel.isUserDefined ? R.layout.item_live_gift_define_num_layout : R.layout.item_live_gift_select_num_layout;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int b(int i, LiveGiftNumberModel liveGiftNumberModel) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OverridingMethodsMustInvokeSuper
    public void e(CommonLiveGiftModel commonLiveGiftModel, int i) {
        CommonLiveGiftModel commonLiveGiftModel2 = this.g;
        if (commonLiveGiftModel2 == null || StringUtils.a(commonLiveGiftModel2.index, commonLiveGiftModel.index)) {
            return;
        }
        v();
        if (this.g.double_hit == 1) {
            a(this.g, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(CommonLiveGiftModel commonLiveGiftModel, int i) {
        if (commonLiveGiftModel == null) {
            return;
        }
        if (commonLiveGiftModel != null && commonLiveGiftModel.getDeleteItemCount() <= 0) {
            w();
        } else if (commonLiveGiftModel.double_hit == 1 && i == 1) {
            b(commonLiveGiftModel, i);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        View view = this.b;
        if (view == null || view.getVisibility() != 0) {
            return super.onBackPressed();
        }
        b(false);
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            return;
        }
        w();
        int childCount = y().getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            try {
                View childAt = y().getChildAt(i2);
                if ("Gift_View".equals(childAt.getTag()) && childAt.getAnimation() == null) {
                    y().removeView(childAt);
                }
                i = i2 + 1;
            } catch (Exception e) {
                return;
            }
        }
    }

    protected void v() {
        LiveGiftBackpackBaseFragment<p>.LiveGiftComboTimer liveGiftComboTimer = this.k;
        if (liveGiftComboTimer != null) {
            liveGiftComboTimer.a = null;
            this.k.cancel();
            this.k = null;
        }
        this.n = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        v();
        a(x(), 0);
    }

    protected abstract LiveGiftModel x();
}
