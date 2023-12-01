package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import com.soft.blued.ui.msg.model.MessageTabModel;
import com.soft.blued.ui.msg.observer.MessageSetSelectedTab;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.notify.fragment.SystemNoticeFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MessagePageFragment.class */
public class MessagePageFragment extends MvpFragment<MvpPresenter> implements HomeTabClick.TabClickListener, MessageSetSelectedTab.IMessageSetSelectedTab {
    public static int b = -1;

    /* renamed from: a  reason: collision with root package name */
    public List<MessageTabModel> f31712a;

    /* renamed from: c  reason: collision with root package name */
    private Context f31713c;
    @BindView
    ImageView cttLeft;
    @BindView
    ImageView cttRight;
    private int d;
    private MyAdapter e;
    @BindView
    QBadgeContainer findBadgeContainer;
    private MsgFragment g;
    private SystemNoticeFragment k;
    @BindView
    CustomViewPager mainMsgViewpager;
    @BindView
    View title;
    @BindView
    TabPageIndicatorWithDot vpIndicator;
    private int f = 0;
    private String l = "";
    private int m = 1;
    private final int n = 604800;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MessagePageFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MessagePageFragment.this.f31712a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 1) {
                MessagePageFragment messagePageFragment = MessagePageFragment.this;
                messagePageFragment.k = (SystemNoticeFragment) messagePageFragment.f31712a.get(i).getFragment();
                return MessagePageFragment.this.k;
            }
            MessagePageFragment messagePageFragment2 = MessagePageFragment.this;
            messagePageFragment2.g = (MsgFragment) messagePageFragment2.f31712a.get(i).getFragment();
            Bundle bundle = new Bundle();
            bundle.putString("details", MessagePageFragment.this.l);
            MessagePageFragment.this.g.setArguments(bundle);
            MessagePageFragment.this.l = "";
            return MessagePageFragment.this.g;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return MessagePageFragment.this.f31712a.get(i).title;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        ChatHttpUtils.b();
    }

    private void a(boolean z, String str) {
        MsgFragment msgFragment;
        if (this.m == 1 && (msgFragment = this.g) != null) {
            if (z) {
                msgFragment.d(str);
                return;
            } else {
                msgFragment.c(str);
                return;
            }
        }
        SystemNoticeFragment systemNoticeFragment = this.k;
        if (systemNoticeFragment != null) {
            if (z) {
                systemNoticeFragment.d(str);
            } else {
                systemNoticeFragment.c(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 1) {
            this.cttRight.setImageDrawable(BluedSkinUtils.b(this.f31713c, R.drawable.icon_title_filter_off));
        } else {
            this.cttRight.setImageDrawable(BluedSkinUtils.b(this.f31713c, R.drawable.icon_title_delete));
        }
    }

    private void c() {
        if (StatusBarHelper.a()) {
            this.findBadgeContainer.setPadding(0, StatusBarHelper.a((Context) getActivity()), 0, 0);
        }
        this.vpIndicator.b(2131101780, 2);
        ViewGroup.LayoutParams layoutParams = this.vpIndicator.getLayoutParams();
        int a2 = DensityUtils.a(this.f31713c, 50.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(a2, 0, a2, 0);
        this.vpIndicator.setLayoutParams(layoutParams);
        if (BlueAppLocal.d()) {
            return;
        }
        this.vpIndicator.setTabPaddingLeftRight(DensityUtils.a(this.f31713c, 5.0f));
    }

    private void d() {
        long ep = BluedPreferences.ep();
        long eq = BluedPreferences.eq();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        getString(R.string.group_join_guide);
        int i = (ep > 0L ? 1 : (ep == 0L ? 0 : -1));
        if (i == 0) {
            getString(R.string.group_join_guide);
            BluedPreferences.ab(false);
            BluedPreferences.u(currentTimeMillis);
        } else if (i <= 0 || currentTimeMillis - ep <= 604800) {
            int i2 = (eq > 0L ? 1 : (eq == 0L ? 0 : -1));
            if (i2 == 0 && !BluedPreferences.er() && TimeAndDateUtils.d("21:00:00", "23:59:59")) {
                getString(R.string.group_have_new);
                BluedPreferences.ab(true);
                BluedPreferences.v(eq);
            } else if (i2 <= 0 || eq - ep <= 604800 || BluedPreferences.er() || !TimeAndDateUtils.d("21:00:00", "23:59:59")) {
                return;
            } else {
                getString(R.string.group_have_new);
                BluedPreferences.ab(true);
                BluedPreferences.v(eq);
            }
        } else {
            getString(R.string.group_join_guide);
            BluedPreferences.ab(false);
            BluedPreferences.u(currentTimeMillis);
        }
        ChatHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<GroupGuideModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.MessagePageFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(final BluedEntityA<GroupGuideModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                MessagePageFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MessagePageFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessagePageFragment.this.e(((GroupGuideModel) bluedEntityA.getSingleData()).message);
                    }
                });
            }
        });
    }

    private void e() {
        this.cttLeft.setVisibility(BluedConstant.f28239a ? 4 : 0);
        String str = "icon_msg_list_my_group_animation.png";
        if (!BluedSkinUtils.c()) {
            str = "dark_icon_msg_list_my_group_animation.png";
        }
        long es = BluedPreferences.es();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int i = (es > 0L ? 1 : (es == 0L ? 0 : -1));
        if (i == 0 || (i > 0 && currentTimeMillis - es > b.Q)) {
            final ImageWrapper c2 = ImageLoader.c(getFragmentActive(), str);
            c2.f();
            c2.g(1);
            BluedPreferences.w(currentTimeMillis);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MessagePageFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    c2.a(MessagePageFragment.this.cttLeft);
                }
            }, 100L);
        } else if (BluedPreferences.cK()) {
            this.cttLeft.setImageResource(R.drawable.icon_msg_list_my_group_dark);
        } else {
            this.cttLeft.setImageResource(R.drawable.icon_msg_list_my_group);
        }
        this.cttLeft.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MessagePageFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MyGroupFragmentNew.f32768a.a(MessagePageFragment.this.getContext(), null);
            }
        });
        this.cttRight.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MessagePageFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (MessagePageFragment.this.mainMsgViewpager.getCurrentItem() == 0) {
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_RIGHT_DELETE).post(view);
                } else {
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_RIGHT_POP_MENU).post(view);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final BasePopupView h = new XPopup.Builder(getContext()).a(this.cttLeft).d((Boolean) false).b(-DensityUtils.a(getContext(), 3.0f)).c(-DensityUtils.a(getContext(), 8.0f)).a(PopupPosition.Bottom).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) new CommonGuidePop(getContext(), str, NinePatchUtils.GuideArrowPosition.LEFT, 2131232900)).h();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MessagePageFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.s()) {
                    h.p();
                }
            }
        }, 5000L);
    }

    private void v() {
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.e = myAdapter;
        this.mainMsgViewpager.setAdapter(myAdapter);
        this.vpIndicator.setViewPager(this.mainMsgViewpager);
        this.mainMsgViewpager.setOffscreenPageLimit(1);
        a(this.m);
        this.vpIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.msg.MessagePageFragment.9
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                MessagePageFragment.this.b(i);
                MessagePageFragment.this.m = i;
                if (MessagePageFragment.this.getActivity() != null && (MessagePageFragment.this.getActivity() instanceof HomeActivity)) {
                    ((HomeActivity) MessagePageFragment.this.getActivity()).a(i);
                }
                if (i == 1) {
                    for (Fragment fragment : MessagePageFragment.this.getChildFragmentManager().getFragments()) {
                        if (fragment instanceof MsgFragment) {
                            ((MsgFragment) fragment).j().z();
                        }
                    }
                }
            }
        });
        this.vpIndicator.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.soft.blued.ui.msg.MessagePageFragment.10
            @Override // com.soft.blued.customview.TabPageIndicatorWithDot.OnTitleClickListener
            public void onClick(int i) {
                if (MessagePageFragment.this.getActivity() != null && (MessagePageFragment.this.getActivity() instanceof HomeActivity)) {
                    ((HomeActivity) MessagePageFragment.this.getActivity()).a(i);
                }
                if (i != 0 || MessagePageFragment.this.k == null) {
                    return;
                }
                MessagePageFragment.this.k.d("msg");
            }
        });
    }

    public void a(int i) {
        if (this.mainMsgViewpager == null || i < 0 || this.e.getCount() < i) {
            return;
        }
        this.mainMsgViewpager.setCurrentItem(i);
        b(i);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f31712a = MessageTabModel.getMessageTabs(this.f31713c);
        if (getActivity() != null && (getActivity() instanceof HomeActivity)) {
            this.m = ((HomeActivity) getActivity()).g();
        }
        Logger.c("MessagePageFragment", "currentIndex = " + this.m);
        c();
        v();
        TabPageIndicatorWithDot tabPageIndicatorWithDot = this.vpIndicator;
        if (tabPageIndicatorWithDot != null) {
            tabPageIndicatorWithDot.a(1, this.d);
        }
        if (this.vpIndicator == null || !(getActivity() instanceof HomeActivity)) {
            return;
        }
        if (((HomeActivity) getActivity()).d) {
            this.vpIndicator.b(0);
        } else {
            this.vpIndicator.c(0);
        }
    }

    public int b() {
        return this.m;
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        a(false, str);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        a(true, str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_message_page;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HomeTabClick.a("msg", this);
        this.f31713c = getActivity();
        MessageSetSelectedTab.a().a(this);
        SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel) ViewModelProviders.of(getActivity()).get(SystemNoticeViewModel.class);
        systemNoticeViewModel.f.observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg.MessagePageFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                MessagePageFragment.this.f = num.intValue();
                Logger.c("MessagePageFragment", "new_system_msg_count = " + num + "=vpIndicator==" + MessagePageFragment.this.vpIndicator);
                if (MessagePageFragment.this.vpIndicator != null) {
                    MessagePageFragment.this.vpIndicator.a(0, MessagePageFragment.this.f);
                }
            }
        });
        systemNoticeViewModel.e.observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg.MessagePageFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                MessagePageFragment.this.d = num.intValue();
                Logger.c("MessagePageFragment", "new_private_msg_count = " + num);
                if (MessagePageFragment.this.vpIndicator != null) {
                    MessagePageFragment.this.vpIndicator.a(1, MessagePageFragment.this.d);
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_NEW_SYSTEM_MSG_READ_COUNT, Integer.class).observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg.MessagePageFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                Logger.e("MessagePageFragment", "new_system_msg_read_count = " + num);
                if (MessagePageFragment.this.vpIndicator != null) {
                    MessagePageFragment.this.f -= num.intValue();
                    if (MessagePageFragment.this.f <= 0) {
                        MessagePageFragment.this.vpIndicator.c(0);
                    }
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_FLASH_FREE_TIMES_TO_POST, Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$MessagePageFragment$snlNfAsWtrHeCKkyfPALOjAvr-0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessagePageFragment.a((Boolean) obj);
            }
        });
        MessageEventUtils.c("MESSAGE_SHOW");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.e("MessagePageFragment", "onDestroy ... ");
        MessageSetSelectedTab.a().b(this);
        HomeTabClick.b("msg", this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Logger.e("MessagePageFragment", "onDestroyView ... ");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e();
        int i = b;
        if (i != -1) {
            this.m = i;
            b = -1;
            if (getActivity() != null && (getActivity() instanceof HomeActivity)) {
                ((HomeActivity) getActivity()).a(this.m);
            }
            a(this.m);
        }
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("arg_subfragment_args");
        if (bundleExtra != null) {
            this.l = bundleExtra.getString("details", "");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (BluedConstant.f28239a) {
            return;
        }
        d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }
}
