package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRecommendAdapter;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiverecommendListData;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.recommend.RecommendRefreshFooter;
import com.blued.android.module.live_china.view.recommend.RecommendRefreshHeader;
import com.blued.das.live.LiveProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRecommendDialogFragment.class */
public class LiveRecommendDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f13214a;
    public PlayingOnliveFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f13215c;
    private View d;
    private View e;
    private View f;
    private View g;
    private RecyclerView h;
    private SmartRefreshLayout i;
    private LiveRecommendAdapter j;
    private List<LiverecommendListData> k;
    private ImageView l;
    private AtomicBoolean m;
    private int n;
    private final int o;
    private float p;
    private float q;
    private DecelerateInterpolator r;
    private long s;
    private int t;

    public LiveRecommendDialogFragment() {
        this.m = new AtomicBoolean(false);
        this.n = 1;
        this.o = 20;
        this.t = 0;
        this.f13214a = getContext();
    }

    public LiveRecommendDialogFragment(Context context, PlayingOnliveFragment playingOnliveFragment) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.m = atomicBoolean;
        this.n = 1;
        this.o = 20;
        this.t = 0;
        this.f13214a = context;
        this.b = playingOnliveFragment;
        atomicBoolean.set(false);
    }

    public LiveRecommendDialogFragment(Context context, PlayingOnliveFragment playingOnliveFragment, boolean z) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.m = atomicBoolean;
        this.n = 1;
        this.o = 20;
        this.t = 0;
        this.f13214a = context;
        this.b = playingOnliveFragment;
        atomicBoolean.set(z);
    }

    static /* synthetic */ int a(LiveRecommendDialogFragment liveRecommendDialogFragment) {
        int i = liveRecommendDialogFragment.n;
        liveRecommendDialogFragment.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void a(LiverecommendListData liverecommendListData) {
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = StringUtils.a(liverecommendListData.lid, 0L);
        liveRoomData.description = liverecommendListData.description;
        liveRoomData.live_type = Integer.parseInt(liverecommendListData.live_type);
        liveRoomData.live_url = liverecommendListData.live_play;
        liveRoomData.screen_pattern = Integer.parseInt(liverecommendListData.screen_pattern);
        liveRoomData.profile = new LiveRoomAnchorModel();
        liveRoomData.profile.name = liverecommendListData.anchor.name;
        liveRoomData.profile.avatar = liverecommendListData.anchor.avatar;
        liveRoomData.profile.vbadge = Integer.parseInt(liverecommendListData.anchor.vbadge);
        LiveDataListManager.a().a(liveRoomData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.m.set(false);
            this.p = motionEvent.getX();
            this.s = System.currentTimeMillis();
            this.t = 0;
            this.q = 0.0f;
            return true;
        } else if (action == 1) {
            if (Math.abs(this.q) < 10.0f && System.currentTimeMillis() - this.s < 100) {
                dismiss();
                return true;
            }
            int i = this.t;
            if (i == 1) {
                this.f.animate().scaleX(1.0f).setDuration(300L).setInterpolator(new OvershootInterpolator(1.5f));
                this.g.animate().scaleX(1.0f).setDuration(300L).setInterpolator(new OvershootInterpolator(1.5f));
                return true;
            } else if (i == 2) {
                if (this.q > this.f.getWidth() / 3) {
                    dismiss();
                    return true;
                }
                this.f.animate().translationX(0.0f).setDuration(300L).setInterpolator(this.r);
                return true;
            } else {
                return true;
            }
        } else if (action != 2) {
            return true;
        } else {
            float x = motionEvent.getX() - this.p;
            this.q = x;
            if (x >= 0.0f) {
                this.t = 2;
                this.f.setTranslationX(x);
                return true;
            }
            this.t = 1;
            this.q = Math.abs(x);
            int width = this.f.getWidth();
            float f = this.q;
            if (f > width * 1.1d) {
                return true;
            }
            float interpolation = (this.r.getInterpolation(f / width) * 0.15f) + 1.0f;
            this.f.setScaleX(interpolation);
            float width2 = this.g.getWidth();
            this.g.setScaleX(width2 / (interpolation * width2));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(LiverecommendListData liverecommendListData) {
        dismiss();
        EventTrackLive.c(LiveProtos.Event.LIVE_RECOMMEND_FOR_YOU_ROOM_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), liverecommendListData.lid, liverecommendListData.uid);
        if (liverecommendListData.lid.equals(LiveRoomManager.a().e())) {
            return;
        }
        if (!String.valueOf(LiveDataListManager.a().c()).equals(liverecommendListData.lid)) {
            a(liverecommendListData);
        }
        k();
    }

    private void e() {
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRecommendDialogFragment$Apq_JnlDNE4v1rOzJEbXH_RWtDw
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecommendDialogFragment.this.n();
            }
        }, 5000L);
    }

    private void f() {
        this.i.b(new RecommendRefreshHeader(this.f13214a));
        this.i.a(new RecommendRefreshFooter(this.f13214a));
        this.i.k(true);
        this.i.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecommendDialogFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveRecommendDialogFragment.a(LiveRecommendDialogFragment.this);
                LiveRecommendDialogFragment.this.i();
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                LiveRecommendDialogFragment.this.n = 1;
                LiveRecommendDialogFragment.this.i();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRecommendDialogFragment$xOtBjOqL-NI9Y1UQu3LpCYVVveg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRecommendDialogFragment.this.a(view);
            }
        });
        this.f.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRecommendDialogFragment$O7kENIpYqfWNoEsVlpMaMp_dVR4
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecommendDialogFragment.this.m();
            }
        });
        if (this.m.get()) {
            this.h.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecommendDialogFragment.2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (LiveRecommendDialogFragment.this.m.get() && i == 1) {
                        LiveRecommendDialogFragment.this.m.set(false);
                    }
                }
            });
        }
    }

    private void g() {
        this.j = new LiveRecommendAdapter(this.f13214a, new LiveRecommendAdapter.LiveClickCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRecommendDialogFragment$xQlGN6D2Xz52rxxr_jBvNOfTEjQ
            @Override // com.blued.android.module.live_china.adapter.LiveRecommendAdapter.LiveClickCallBack
            public final void addDesireSuccess(LiverecommendListData liverecommendListData) {
                LiveRecommendDialogFragment.this.b(liverecommendListData);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.h.setLayoutManager(linearLayoutManager);
        this.j.setHasStableIds(true);
        this.h.setAdapter(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.n == 1) {
            this.j.a(this.k);
        } else {
            this.j.notifyDataSetChanged();
        }
        if (this.h.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
        if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        LiveRoomHttpUtils.a(this.n, 20, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LiverecommendListData>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveRecommendDialogFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiverecommendListData> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    LiveRecommendDialogFragment.this.j();
                } else if (bluedEntityA.data.size() == 0) {
                    if (LiveRecommendDialogFragment.this.n == 1) {
                        LiveRecommendDialogFragment.this.j();
                        return;
                    }
                    LiveRecommendDialogFragment.this.i.k(false);
                    LiveRecommendDialogFragment.this.i.i(true);
                } else {
                    if (LiveRecommendDialogFragment.this.k == null) {
                        LiveRecommendDialogFragment.this.k = new ArrayList();
                    } else if (LiveRecommendDialogFragment.this.n == 1) {
                        LiveRecommendDialogFragment.this.k.clear();
                    }
                    LiveRecommendDialogFragment.this.k.addAll(bluedEntityA.data);
                    LiveRecommendDialogFragment.this.h();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveRecommendDialogFragment.this.j();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveRecommendDialogFragment.this.i.j();
                LiveRecommendDialogFragment.this.i.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.n == 1) {
            if (this.h.getVisibility() != 8) {
                this.h.setVisibility(8);
            }
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
    }

    private void k() {
        if (this.b == null) {
            LiveFloatManager.a().n();
            return;
        }
        InstantLog.a("live_room_slide");
        this.b.aT.setVisibility(8);
        LiveFloatManager.a().b(false);
        if (!LiveDataListManager.a().a(this.f13214a, this.b.t, 0, "room_recommend")) {
            LiveFloatManager.a().n();
        }
        this.b.T();
        getActivity().overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m() {
        View view = this.f;
        view.setPivotX(view.getWidth());
        this.g.setPivotX(0.0f);
        this.r = new DecelerateInterpolator(2.0f);
        this.f13215c.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRecommendDialogFragment$kVS_IPDhWQgETAgz_jkxPB3ZvfQ
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean a2;
                a2 = LiveRecommendDialogFragment.this.a(view2, motionEvent);
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || !this.m.get()) {
            return;
        }
        dismiss();
    }

    protected boolean d() {
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        this.m.set(false);
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing()) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        if (bundle != null && d()) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int height;
        this.f13214a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_recommend, (ViewGroup) null);
        int i = -1;
        if (this.f13214a.getResources().getConfiguration().orientation == 1) {
            i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            height = -1;
        } else {
            height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        }
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(i, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.right_recommen_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i;
        attributes.height = height;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_recommend, viewGroup);
        this.f13215c = inflate.findViewById(R.id.view_gesture);
        this.d = inflate.findViewById(R.id.rl_data_error);
        this.e = inflate.findViewById(R.id.iv_recommend_side);
        this.f = inflate.findViewById(R.id.rl_content);
        this.g = inflate.findViewById(R.id.rl_list_root);
        this.h = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.i = (SmartRefreshLayout) inflate.findViewById(R.id.smart_refresh);
        this.l = (ImageView) inflate.findViewById(R.id.img_live_recommend);
        ImageLoader.c(a(), "img_live_recommend.png").g(-1).f().a(this.l);
        f();
        g();
        this.i.i();
        if (this.m.get()) {
            e();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null || !d()) {
            return;
        }
        bundle.remove("android:support:fragments");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_FOR_YOU_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
