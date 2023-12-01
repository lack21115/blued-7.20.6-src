package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.customview.AutoHeightViewPager;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.fragment.UserGiftFragment;
import com.soft.blued.ui.msg.fragment.UserGiftPackageFragment;
import com.soft.blued.ui.msg.model.UserGiftModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/UserGiftDialogFragment.class */
public class UserGiftDialogFragment extends CommonDialogFragment implements View.OnClickListener {
    public ActivityFragmentActive b;

    /* renamed from: c  reason: collision with root package name */
    public BuySucceedListener f18816c;
    private FragmentActivity d;
    private String e;
    private String f;
    private String g;
    private int h;
    private List<GiftGivingOptionForJsonParse> i;
    private UserGiftFmAdapter j;
    private AutoHeightViewPager k;
    private RelativeLayout l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private View u;
    private FrameLayout v;
    private TextView w;
    private TextView x;
    private int y;
    private String z;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/UserGiftDialogFragment$BuySucceedListener.class */
    public interface BuySucceedListener {
        void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/UserGiftDialogFragment$UserGiftFmAdapter.class */
    public static class UserGiftFmAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public UserGiftFragment f18821a;
        public UserGiftPackageFragment b;

        /* renamed from: c  reason: collision with root package name */
        private List<GiftGivingOptionForJsonParse> f18822c;
        private String d;
        private String e;
        private BuySucceedListener f;
        private UserGiftDialogFragment g;
        private int h;
        private String i;

        public UserGiftFmAdapter(FragmentManager fragmentManager, List<GiftGivingOptionForJsonParse> list, String str, String str2, int i, String str3, BuySucceedListener buySucceedListener, UserGiftDialogFragment userGiftDialogFragment) {
            super(fragmentManager, 1);
            this.f18822c = list;
            this.d = str;
            this.e = str2;
            this.f = buySucceedListener;
            this.g = userGiftDialogFragment;
            this.h = i;
            this.i = str3;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.fragment.app.Fragment, com.soft.blued.ui.msg.fragment.UserGiftPackageFragment] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.fragment.app.Fragment, com.soft.blued.ui.msg.fragment.UserGiftFragment] */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                ?? userGiftFragment = new UserGiftFragment(this.f18822c, this.d, this.e, this.h, this.i, this.f, this.g);
                this.f18821a = userGiftFragment;
                return userGiftFragment;
            } else if (i == 1) {
                ?? userGiftPackageFragment = new UserGiftPackageFragment(this.d, this.e, this.i, this.f, this.g);
                this.b = userGiftPackageFragment;
                return userGiftPackageFragment;
            } else {
                return null;
            }
        }
    }

    public UserGiftDialogFragment() {
        this.h = 2;
    }

    public UserGiftDialogFragment(Context context, ActivityFragmentActive activityFragmentActive, String str, String str2, List<GiftGivingOptionForJsonParse> list, int i, int i2, String str3, String str4) {
        this.h = 2;
        this.d = (FragmentActivity) context;
        this.b = activityFragmentActive;
        this.e = str;
        if (TextUtils.isEmpty(str2)) {
            this.f = "";
        } else {
            this.f = str2;
        }
        this.i = list;
        this.h = i;
        this.y = i2;
        this.z = str3;
        this.g = str4;
    }

    public static void a(final Context context, final ActivityFragmentActive activityFragmentActive, final String str, final String str2, final BuySucceedListener buySucceedListener, final String str3, final String str4, final int... iArr) {
        UserHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserGiftModel>>(activityFragmentActive) { // from class: com.soft.blued.ui.msg.pop.UserGiftDialogFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
                if (r14 == 3) goto L51;
             */
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.soft.blued.ui.msg.model.UserGiftModel> r13) {
                /*
                    Method dump skipped, instructions count: 559
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.pop.UserGiftDialogFragment.AnonymousClass3.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            public boolean onUIFailure(int i, String str5) {
                return super.onUIFailure(i, str5);
            }

            public void onUIFinish() {
                super.onUIFinish();
            }
        }, str, (IRequestHost) activityFragmentActive);
    }

    private void k() {
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout == null || this.m == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        this.m.setVisibility(8);
    }

    public void a(View view) {
        FragmentActivity fragmentActivity = this.d;
        if (fragmentActivity == null) {
            dismiss();
            return;
        }
        fragmentActivity.getWindow().setSoftInputMode(51);
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.GIFT_BUY_PAGE_SHOW, this.e, "user_page_gift".equals(this.f) ? PersonalProfileProtos.GiftFrom.PERSONAL_PAGE : PersonalProfileProtos.GiftFrom.MESSAGE_PAGE);
        this.k = (AutoHeightViewPager) view.findViewById(R.id.auto_vp);
        this.j = new UserGiftFmAdapter(getChildFragmentManager(), this.i, this.e, this.f, this.h, this.g, this.f18816c, this);
        this.k.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftDialogFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                UserGiftDialogFragment.this.k.a(i);
                UserGiftDialogFragment.this.y = i;
                UserGiftDialogFragment.this.l.setVisibility(8);
                UserGiftDialogFragment.this.m.setVisibility(8);
                UserGiftDialogFragment.this.r.setTextColor(ContextCompat.getColor(UserGiftDialogFragment.this.getContext(), i == 0 ? 2131102203 : 2131102205));
                TextView textView = UserGiftDialogFragment.this.s;
                Context context = UserGiftDialogFragment.this.getContext();
                int i2 = 2131102203;
                if (i == 0) {
                    i2 = 2131102205;
                }
                textView.setTextColor(ContextCompat.getColor(context, i2));
                if (i == 0) {
                    if (UserGiftDialogFragment.this.j.f18821a != null) {
                        UserGiftDialogFragment.this.j.f18821a.e();
                    }
                } else if (i == 1 && UserGiftDialogFragment.this.j.b != null) {
                    UserGiftDialogFragment.this.j.b.e();
                }
                if (UserGiftDialogFragment.this.x.getVisibility() == 0 && i == 1) {
                    UserGiftDialogFragment.this.x.setVisibility(8);
                    BluedPreferences.aa(false);
                }
            }
        });
        this.k.setCurrentItem(2);
        this.k.setAdapter(this.j);
        this.l = (RelativeLayout) view.findViewById(R.id.cl_fu_top);
        this.m = (LinearLayout) view.findViewById(R.id.ll_top_hint);
        this.p = (LinearLayout) view.findViewById(2131367715);
        this.n = (TextView) view.findViewById(R.id.tv_top_hint);
        this.o = (TextView) view.findViewById(R.id.tv_fu_hint);
        this.q = (TextView) view.findViewById(R.id.tv_top);
        this.r = (TextView) view.findViewById(R.id.tv_gift);
        this.s = (TextView) view.findViewById(R.id.tv_package);
        this.u = view.findViewById(R.id.viewStub);
        this.v = (FrameLayout) view.findViewById(2131364006);
        this.x = (TextView) view.findViewById(R.id.red);
        this.t = (ImageView) view.findViewById(R.id.iv_fu);
        this.w = (TextView) view.findViewById(R.id.tv_fu_title);
        this.u.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_GIFT_HINT, GiftHintEvent.class).observe(this.d, new Observer<GiftHintEvent>() { // from class: com.soft.blued.ui.msg.pop.UserGiftDialogFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GiftHintEvent giftHintEvent) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) UserGiftDialogFragment.this.p.getLayoutParams();
                UserGiftDialogFragment.this.l.setVisibility(8);
                UserGiftDialogFragment.this.m.setVisibility(8);
                if (giftHintEvent.d) {
                    layoutParams.topMargin = -DensityUtil.a(16.0f);
                    if (giftHintEvent.f18635a == 2 || giftHintEvent.f18635a == 3) {
                        UserGiftDialogFragment.this.m.setVisibility(0);
                        UserGiftDialogFragment.this.n.setText(giftHintEvent.b);
                        UserGiftDialogFragment.this.q.setVisibility(0);
                        if (giftHintEvent.f18635a == 3) {
                            UserGiftDialogFragment.this.q.setText(UserGiftDialogFragment.this.getString(R.string.msg_gift_card));
                        }
                    } else if (giftHintEvent.f18635a == 1) {
                        UserGiftDialogFragment.this.q.setVisibility(8);
                        UserGiftDialogFragment.this.m.setVisibility(0);
                        UserGiftDialogFragment.this.n.setText(giftHintEvent.b);
                    } else {
                        if (!TextUtils.isEmpty(giftHintEvent.e)) {
                            ImageLoader.a(UserGiftDialogFragment.this.b, giftHintEvent.e).a(UserGiftDialogFragment.this.t);
                        }
                        UserGiftDialogFragment.this.l.setVisibility(0);
                        UserGiftDialogFragment.this.o.setText(giftHintEvent.b);
                        UserGiftDialogFragment.this.w.setText(giftHintEvent.f18636c);
                    }
                } else {
                    layoutParams.topMargin = 0;
                }
                UserGiftDialogFragment.this.p.setLayoutParams(layoutParams);
            }
        });
        if (BluedPreferences.ea()) {
            this.x.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.p.setLayoutParams(layoutParams);
        int i = this.y;
        if (i != 0) {
            this.k.setCurrentItem(i);
        }
    }

    public int d() {
        return R.layout.pop_user_gift_new;
    }

    public int e() {
        return -1;
    }

    public int f() {
        return -1;
    }

    public AutoHeightViewPager h() {
        return this.k;
    }

    public String i() {
        return this.z;
    }

    public int j() {
        return this.y;
    }

    public boolean onBackPressed() {
        k();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131371524) {
            this.k.setCurrentItem(0);
        } else if (id == 2131372208) {
            EventTrackPersonalProfile.b(PersonalProfileProtos.Event.GIFT_BUY_PAGE_BAG_CLICK, this.e, this.f.equals("user_page_gift") ? PersonalProfileProtos.GiftFrom.PERSONAL_PAGE : PersonalProfileProtos.GiftFrom.MESSAGE_PAGE);
            this.k.setCurrentItem(1);
        } else if (id != 2131373101) {
        } else {
            dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        k();
    }
}
