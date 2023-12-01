package com.blued.android.module.live_china.rank;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveRankAllBinding;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankDialogFragment.class */
public final class LiveRankDialogFragment extends BaseDialogFragment implements OnClickCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14067a = new Companion(null);
    private int b;
    private MyPagerAdapter d;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f14068c = LazyKt.a(new Function0<DialogLiveRankAllBinding>() { // from class: com.blued.android.module.live_china.rank.LiveRankDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveRankAllBinding invoke() {
            return DialogLiveRankAllBinding.a(LayoutInflater.from(LiveRankDialogFragment.this.getContext()));
        }
    });
    private final int e = 3;
    private final HashMap<String, View> f = new HashMap<>();
    private final HashMap<Integer, String> g = new HashMap<>();
    private final HashMap<Integer, LiveProtos.Status> h = new HashMap<>();
    private HashMap<String, LiveProtos.Status> i = new HashMap<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveRankDialogFragment a(FragmentManager manager, int i) {
            Intrinsics.e(manager, "manager");
            LiveRankDialogFragment liveRankDialogFragment = new LiveRankDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("from", i);
            liveRankDialogFragment.setArguments(bundle);
            liveRankDialogFragment.show(manager, LiveRankDialogFragment.class.getSimpleName());
            return liveRankDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankDialogFragment$MyPagerAdapter.class */
    public final class MyPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveRankDialogFragment f14069a;

        public MyPagerAdapter(LiveRankDialogFragment this$0) {
            Intrinsics.e(this$0, "this$0");
            this.f14069a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f14069a.e;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            if (((View) this.f14069a.f.get(String.valueOf(i))) == null) {
                this.f14069a.f.put(String.valueOf(i), i == 2 ? this.f14069a.b(container, i) : this.f14069a.a(container, i));
            }
            View view = (View) this.f14069a.f.get(String.valueOf(i));
            if ((view == null ? null : view.getParent()) != null) {
                ViewParent parent = view.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(view);
            }
            container.addView(view);
            Intrinsics.a(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View a(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pop_window_ranking_host, viewGroup, false);
        PopRankingHostCardView popRankingHostCardView = (PopRankingHostCardView) view.findViewById(R.id.host_card_current);
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        popRankingHostCardView.a(activityFragmentActive, childFragmentManager, this.g.get(Integer.valueOf(i)), 0);
        Intrinsics.c(view, "view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRankDialogFragment this$0, Pair pair) {
        Intrinsics.e(this$0, "this$0");
        this$0.d().e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRankDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View b(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pop_window_ranking_union, viewGroup, false);
        PopRankingUnionCardView popRankingUnionCardView = (PopRankingUnionCardView) view.findViewById(R.id.host_card_current);
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        popRankingUnionCardView.a(activityFragmentActive, childFragmentManager, this.g.get(Integer.valueOf(i)), 0);
        Intrinsics.c(view, "view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRankDialogFragment this$0, Pair position) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(position, "position");
        HashMap<String, LiveProtos.Status> hashMap = this$0.i;
        F f = position.first;
        if (f == 0) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) f;
        S s = position.second;
        if (s == 0) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.das.live.LiveProtos.Status");
        }
        hashMap.put(str, (LiveProtos.Status) s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveRankAllBinding d() {
        return (DialogLiveRankAllBinding) this.f14068c.getValue();
    }

    private final void e() {
        LiveRankDialogFragment liveRankDialogFragment = this;
        LiveEventBus.get(LiveEventBusUtil.ab, Pair.class).observe(liveRankDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankDialogFragment$wXNLc0uvl5UBvHHx_2SjfrPHIFg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveRankDialogFragment.a(LiveRankDialogFragment.this, (Pair) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.ac, Pair.class).observe(liveRankDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankDialogFragment$zrJwc1QlztsgygkMFNhmBGA736A
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveRankDialogFragment.b(LiveRankDialogFragment.this, (Pair) obj);
            }
        });
    }

    private final void f() {
        d().h.getLayoutParams().height = DensityUtils.a(getActivity());
        d().e.setVisibility(0);
        if (this.b == 1) {
            StatusBarHelper.a((Activity) getActivity(), false);
        }
        d().g.f12401a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankDialogFragment$I3u4gC24DkEjUpEspwbMRCpXNUA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRankDialogFragment.a(LiveRankDialogFragment.this, view);
            }
        });
        this.f.clear();
        g();
    }

    private final void g() {
        d().f11814c.a(new String[]{"主播榜", "用户榜", "公会榜"});
        d().f11814c.setClickListener(new Function1<Integer, Unit>() { // from class: com.blued.android.module.live_china.rank.LiveRankDialogFragment$initPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(int i) {
                DialogLiveRankAllBinding d;
                d = LiveRankDialogFragment.this.d();
                d.d.setCurrentItem(i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Integer num) {
                a(num.intValue());
                return Unit.f42314a;
            }
        });
        this.d = new MyPagerAdapter(this);
        d().d.setAdapter(this.d);
        ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689660130_95972.webp").g().a(d().b);
        EventTrackLive.a(LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW, this.h.get(0));
        d().d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.rank.LiveRankDialogFragment$initPager$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DialogLiveRankAllBinding d;
                DialogLiveRankAllBinding d2;
                DialogLiveRankAllBinding d3;
                DialogLiveRankAllBinding d4;
                HashMap hashMap;
                HashMap hashMap2;
                HashMap hashMap3;
                DialogLiveRankAllBinding d5;
                DialogLiveRankAllBinding d6;
                HashMap hashMap4;
                HashMap hashMap5;
                HashMap hashMap6;
                DialogLiveRankAllBinding d7;
                DialogLiveRankAllBinding d8;
                HashMap hashMap7;
                d = LiveRankDialogFragment.this.d();
                d.d.setCurrentItem(i);
                d2 = LiveRankDialogFragment.this.d();
                d2.f11814c.setToolBtnSelect(i);
                if (i == 0) {
                    d3 = LiveRankDialogFragment.this.d();
                    RelativeLayout relativeLayout = d3.f;
                    Context context = LiveRankDialogFragment.this.getContext();
                    relativeLayout.setBackground(context == null ? null : AppCompatResources.getDrawable(context, R.drawable.rank_all_host_bg));
                    ImageWrapper g = ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689660130_95972.webp").g();
                    d4 = LiveRankDialogFragment.this.d();
                    g.a(d4.b);
                    hashMap = LiveRankDialogFragment.this.i;
                    if (hashMap.get("anchor") == null) {
                        LiveProtos.Event event = LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW;
                        hashMap3 = LiveRankDialogFragment.this.h;
                        EventTrackLive.a(event, (LiveProtos.Status) hashMap3.get(0));
                        return;
                    }
                    LiveProtos.Event event2 = LiveProtos.Event.LIVE_SHOW_PAGE_LIVER_PAGE_SHOW;
                    hashMap2 = LiveRankDialogFragment.this.i;
                    EventTrackLive.a(event2, (LiveProtos.Status) hashMap2.get("anchor"));
                } else if (i != 1) {
                    d7 = LiveRankDialogFragment.this.d();
                    RelativeLayout relativeLayout2 = d7.f;
                    Context context2 = LiveRankDialogFragment.this.getContext();
                    relativeLayout2.setBackground(context2 == null ? null : AppCompatResources.getDrawable(context2, R.drawable.rank_all_union_bg));
                    ImageWrapper g2 = ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689660130_88233.webp").g();
                    d8 = LiveRankDialogFragment.this.d();
                    g2.a(d8.b);
                    hashMap7 = LiveRankDialogFragment.this.i;
                    if (hashMap7.get("union") == null) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_PAGE_SHOW);
                    } else {
                        EventTrackLive.a(LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_LADDER_SHOW);
                    }
                } else {
                    d5 = LiveRankDialogFragment.this.d();
                    RelativeLayout relativeLayout3 = d5.f;
                    Context context3 = LiveRankDialogFragment.this.getContext();
                    relativeLayout3.setBackground(context3 == null ? null : AppCompatResources.getDrawable(context3, R.drawable.rank_all_user_bg));
                    ImageWrapper g3 = ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1689660130_81238.webp").g();
                    d6 = LiveRankDialogFragment.this.d();
                    g3.a(d6.b);
                    hashMap4 = LiveRankDialogFragment.this.i;
                    if (hashMap4.get("fans") == null) {
                        LiveProtos.Event event3 = LiveProtos.Event.LIVE_SHOW_PAGE_USER_PAGE_SHOW;
                        hashMap6 = LiveRankDialogFragment.this.h;
                        EventTrackLive.a(event3, (LiveProtos.Status) hashMap6.get(0));
                        return;
                    }
                    LiveProtos.Event event4 = LiveProtos.Event.LIVE_SHOW_PAGE_USER_PAGE_SHOW;
                    hashMap5 = LiveRankDialogFragment.this.i;
                    EventTrackLive.a(event4, (LiveProtos.Status) hashMap5.get("fans"));
                }
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        FragmentActivity activity = getActivity();
        Integer valueOf = (activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) ? null : Integer.valueOf(defaultDisplay.getWidth());
        Integer num = valueOf;
        if (valueOf == null) {
            num = -1;
        }
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        Integer num2 = num;
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(num2.intValue(), -1));
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setWindowAnimations(R.style.main_menu_animstyle);
        }
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = num2.intValue();
            attributes.height = -1;
            attributes.gravity = 80;
        }
        if (window != null) {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        if (this.b == 1) {
            StatusBarHelper.a((Activity) getActivity(), true);
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        this.g.put(0, "anchor");
        this.g.put(1, "fans");
        this.g.put(2, "union");
        this.h.put(0, LiveProtos.Status.DAILY);
        this.h.put(1, LiveProtos.Status.WEEKLY);
        this.h.put(2, LiveProtos.Status.MONTHLY);
        f();
        e();
    }
}
