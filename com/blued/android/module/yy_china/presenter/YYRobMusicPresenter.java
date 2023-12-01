package com.blued.android.module.yy_china.presenter;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.adapter.BaseConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYRobMusicAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRobMusicManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.RobMusicMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyMode;
import com.blued.android.module.yy_china.model.YYBorImJsonMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.view.YYRobMusicGuideDialog;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYRobMusicPresenter.class */
public final class YYRobMusicPresenter extends AbstractBasePresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRobMusicPresenter(BaseYYStudioFragment fragment) {
        super(fragment);
        Intrinsics.e(fragment, "fragment");
        if (YYRoomInfoManager.e().h == null) {
            YYRoomInfoManager.e().h = new YYRobMusicManager();
        }
    }

    private final void a(YYBorImJsonBodyMode yYBorImJsonBodyMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        String uid;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        int status = yYBorImJsonBodyMode.getStatus();
        if (status == 0) {
            ((YYRobMusicAdapter) baseConnectingAdapter).h();
        } else if (status != 1) {
            ((YYRobMusicAdapter) baseConnectingAdapter).a();
        } else {
            YYRobMusicAdapter yYRobMusicAdapter = (YYRobMusicAdapter) baseConnectingAdapter;
            YYRoomInfoManager e = YYRoomInfoManager.e();
            String k = e == null ? null : e.k();
            YYRoomModel b = YYRoomInfoManager.e().b();
            String str = "";
            if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null && (uid = yYBorImJsonBodyInfoMode.getUid()) != null) {
                str = uid;
            }
            yYRobMusicAdapter.a(StringUtils.a(k, str), 0);
        }
    }

    private final void a(YYBorImJsonMode yYBorImJsonMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        YYBorImJsonBodyMode body = yYBorImJsonMode.getBody();
        if (body == null) {
            return;
        }
        if (body.getStatus() == 1) {
            h();
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.R();
        }
        BaseYYStudioFragment baseYYStudioFragment2 = this.f17634a;
        if (baseYYStudioFragment2 == null || (baseConnectingAdapter = baseYYStudioFragment2.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicPresenter this$0, String d) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        Intrinsics.c(d, "d");
        baseYYStudioFragment.b(Integer.parseInt(d));
    }

    private final void b(YYBorImJsonMode yYBorImJsonMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        Integer valueOf;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.R();
        }
        BaseYYStudioFragment baseYYStudioFragment2 = this.f17634a;
        if (baseYYStudioFragment2 == null || (baseConnectingAdapter = baseYYStudioFragment2.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        if (yYBorImJsonMode == null) {
            valueOf = null;
        } else {
            YYBorImJsonBodyMode body = yYBorImJsonMode.getBody();
            valueOf = body == null ? null : Integer.valueOf(body.getResult());
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            ((YYRobMusicAdapter) baseConnectingAdapter).e();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            ((YYRobMusicAdapter) baseConnectingAdapter).f();
        } else if (valueOf != null && valueOf.intValue() == 3) {
            ((YYRobMusicAdapter) baseConnectingAdapter).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter) || robMusicMode == null) {
            return;
        }
        if (robMusicMode.isHostPlay()) {
            ((YYRobMusicAdapter) baseConnectingAdapter).a(robMusicMode.getTime());
        } else {
            ((YYRobMusicAdapter) baseConnectingAdapter).b(robMusicMode.getTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRobMusicPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        YYBorImJsonBodyMode status;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter) || robMusicMode == null || (status = robMusicMode.getStatus()) == null) {
            return;
        }
        this$0.a(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        YYBorImJsonMode msg;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter) || robMusicMode == null || (msg = robMusicMode.getMsg()) == null) {
            return;
        }
        this$0.b(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        YYBorImJsonMode msg;
        Intrinsics.e(this$0, "this$0");
        if (robMusicMode == null || (msg = robMusicMode.getMsg()) == null) {
            return;
        }
        this$0.a(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYRobMusicPresenter this$0, RobMusicMode d) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(d, "d");
        this$0.a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter) || robMusicMode == null) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).a(new File(robMusicMode.getFile()), robMusicMode.isHostPlay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.a(robMusicMode.getMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(YYRobMusicPresenter this$0, RobMusicMode robMusicMode) {
        BaseConnectingAdapter baseConnectingAdapter;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.R();
        }
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.f17634a;
        if (baseYYStudioFragment2 == null || (baseConnectingAdapter = baseYYStudioFragment2.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).a(robMusicMode.getMsg());
    }

    private final void l() {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        YYRobMusicGuideDialog yYRobMusicGuideDialog = new YYRobMusicGuideDialog();
        FragmentManager childFragmentManager = baseYYStudioFragment.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "it.childFragmentManager");
        yYRobMusicGuideDialog.show(childFragmentManager, "YYRobMusicGuideDialog");
    }

    public final void a(RobMusicMode d) {
        BaseConnectingAdapter baseConnectingAdapter;
        YYRoomModel b;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(d, "d");
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter) || (b = YYRoomInfoManager.e().b()) == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).a(StringUtils.a(yYBorImJsonBodyInfoMode.getUid(), YYRoomInfoManager.e().k()), d.getCountDown());
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycle) {
        Intrinsics.e(lifecycle, "lifecycle");
        LiveEventBus.get("bor_music_show_user_result_uping", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$pJe2L-LKLlBY2FFK2KVDrdrYQPQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.a(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_bg", String.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$wm6GOgXpXh3Y9rWP2Yv1we2ziBQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.a(YYRobMusicPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_time", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$NjoV9j_iata0J6YjlN0Ta2KN88s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.b(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_add_user", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$45dqUCsChK4PYqXohIv456FUthk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.c(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_result", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$J-lLjfCnzXhxgTSVo_AnwDiYnY4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.d(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_show_begin", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$VCy51eGNcoeqSedpqEtAeoy9Whs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.e(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_host_music", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$EZysDzdje-PsD6MAmCwFy31lKus
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.f(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_user_music", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$8H49Javtc3n4nPQsHu8Oq052tA4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.g(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_load_lrc", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$pqLRJw5G0SrX6al2DsbSJs3sE6c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.h(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_paly_rob_music_ani", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$tqf46XA1UGB6PCnv5n-OU-3ESV4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.i(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_light", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$swziSmwUTv9vzJYF8V3WjrfthUg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.j(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("bor_music_ims_paly_rob_by_user", RobMusicMode.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$Dx6RSLC6XrINGchokVIMMnA4ME8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.k(YYRobMusicPresenter.this, (RobMusicMode) obj);
            }
        });
        LiveEventBus.get("show_blind_guide", String.class).observe(lifecycle, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYRobMusicPresenter$21GKdExkG7XyIIE8gNXO_Lhvrtc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYRobMusicPresenter.b(YYRobMusicPresenter.this, (String) obj);
            }
        });
    }

    public final void f() {
        YYRobMusicManager L = YYRoomInfoManager.e().L();
        if (L == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        L.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive());
    }

    public final void g() {
        BaseConnectingAdapter baseConnectingAdapter;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).h();
    }

    public final void h() {
        BaseConnectingAdapter baseConnectingAdapter;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || (baseConnectingAdapter = baseYYStudioFragment.E) == null || !(baseConnectingAdapter instanceof YYRobMusicAdapter)) {
            return;
        }
        ((YYRobMusicAdapter) baseConnectingAdapter).b();
    }

    public final void i() {
        YYRobMusicManager L = YYRoomInfoManager.e().L();
        if (L == null) {
            return;
        }
        L.h();
    }

    public final void j() {
        YYRobMusicManager L = YYRoomInfoManager.e().L();
        if (L == null) {
            return;
        }
        L.b(this.f17634a.getFragmentActive());
    }

    public final void k() {
        YYRobMusicManager L = YYRoomInfoManager.e().L();
        if (L == null) {
            return;
        }
        L.c(this.f17634a.getFragmentActive());
    }
}
