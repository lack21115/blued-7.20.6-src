package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.constants.PhotoConstants;
import com.blued.android.module.common.utils.ComplianceUtils;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.adapter.MsgAblumAdapter;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectedPagerFragment.class */
public class MsgPhotoSelectedPagerFragment extends BaseFragment implements EventCallBackListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f16259a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private HackyViewPager f16260c;
    private LayoutInflater d;
    private ImagePagerAdapter e;
    private View f;
    private TextView g;
    private TextView h;
    private CheckBox i;
    private View j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private RecyclerView n;
    private MsgAblumAdapter o;
    private View p;
    private int q;
    private int r;
    private boolean s;
    private boolean t = false;
    private List<ChildImageInfo> u = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectedPagerFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MsgPhotoSelectedPagerFragment.this.u.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageDetailFragment.a(!TextUtils.isEmpty(((ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(i)).imgUri) ? ((ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(i)).imgUri : ((ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(i)).mImagePath, true, 4, null, i, MsgPhotoSelectedPagerFragment.this.u.size());
        }
    }

    public static void a(BaseFragment baseFragment, int i, int i2, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i2);
        bundle.putInt("photo_index", i);
        bundle.putBoolean("photo_destroy_switch", z);
        bundle.putBoolean("photo_from_group", z2);
        TerminalActivity.a(baseFragment, MsgPhotoSelectedPagerFragment.class, bundle, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.u.get(i).mSelect) {
            this.m.setImageResource(R.drawable.photo_selected);
        } else {
            this.m.setImageResource(R.drawable.photo_unselected);
        }
    }

    private void e() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = arguments.getInt("photo_index", 0);
            this.r = arguments.getInt("select_photo", 0);
            this.s = arguments.getBoolean("photo_destroy_switch", false);
            this.t = arguments.getBoolean("photo_from_group", false);
        }
        this.u.addAll(SelectPhotoManager.a().c());
    }

    private void f() {
        this.d = LayoutInflater.from(this.f16259a);
        this.f16260c = (HackyViewPager) this.b.findViewById(2131368810);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.e = imagePagerAdapter;
        this.f16260c.setAdapter(imagePagerAdapter);
        this.p = this.b.findViewById(2131363095);
        View findViewById = this.b.findViewById(2131370694);
        this.j = findViewById;
        this.l = (ImageView) findViewById.findViewById(2131363120);
        this.k = (TextView) this.j.findViewById(2131363108);
        this.m = (ImageView) this.j.findViewById(2131363126);
        View findViewById2 = this.b.findViewById(R.id.bottom_view);
        this.f = findViewById2;
        findViewById2.setBackgroundColor(getResources().getColor(2131101202));
        TextView textView = (TextView) this.b.findViewById(R.id.tv_send);
        this.g = textView;
        textView.setTextColor(getResources().getColor(2131101191));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.1
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        });
        CheckBox checkBox = (CheckBox) this.b.findViewById(R.id.iv_destroy_switch);
        this.i = checkBox;
        checkBox.setChecked(this.s);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_destroy);
        this.h = textView2;
        textView2.setTextColor(getResources().getColor(2131101191));
        TextView textView3 = this.h;
        textView3.setText(this.f16259a.getString(R.string.delete_automatically) + FlashPhotoManager.a().b().flash_prompt);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ComplianceUtils.a.a(MsgPhotoSelectedPagerFragment.this.getContext())) {
                    return;
                }
                if (FlashPhotoManager.a().b().flash_left_times <= 0 || FlashPhotoManager.a().b().flash_left_times < SelectPhotoManager.a().b()) {
                    PayVIPPopupWindow.c.a(MsgPhotoSelectedPagerFragment.this.f16259a, SelectPhotoManager.a().b(), new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.2.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TextView textView4 = MsgPhotoSelectedPagerFragment.this.h;
                            textView4.setText(MsgPhotoSelectedPagerFragment.this.f16259a.getString(R.string.delete_automatically) + FlashPhotoManager.a().b().flash_prompt);
                        }
                    });
                } else {
                    MsgPhotoSelectedPagerFragment.this.i.setChecked(!MsgPhotoSelectedPagerFragment.this.i.isChecked());
                }
            }
        });
        if (BluedConfig.a().j() && this.t) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        }
        this.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z && ComplianceUtils.a.a(MsgPhotoSelectedPagerFragment.this.getContext())) {
                    MsgPhotoSelectedPagerFragment.this.i.setChecked(false);
                } else if (FlashPhotoManager.a().b().flash_left_times <= 0 || FlashPhotoManager.a().b().flash_left_times < SelectPhotoManager.a().b()) {
                    PayVIPPopupWindow.c.a(MsgPhotoSelectedPagerFragment.this.f16259a, SelectPhotoManager.a().b(), new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.3.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TextView textView4 = MsgPhotoSelectedPagerFragment.this.h;
                            textView4.setText(MsgPhotoSelectedPagerFragment.this.f16259a.getString(R.string.delete_automatically) + FlashPhotoManager.a().b().flash_prompt);
                        }
                    });
                    MsgPhotoSelectedPagerFragment.this.i.setChecked(false);
                } else if (MsgPhotoSelectedPagerFragment.this.t) {
                    InstantLog.a("chat_burn_pic_click", (Object) 1);
                } else {
                    InstantLog.a("chat_burn_pic_click", (Object) 0);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.photo_ablum_listView);
        this.n = recyclerView;
        recyclerView.setHasFixedSize(true);
        i();
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChildImageInfo childImageInfo = (ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(MsgPhotoSelectedPagerFragment.this.q);
                if (childImageInfo.mSelect) {
                    childImageInfo.mSelect = false;
                    MsgPhotoSelectedPagerFragment.this.m.setImageResource(R.drawable.photo_unselected);
                    SelectPhotoManager.a().b(childImageInfo);
                    MsgPhotoSelectedPagerFragment.this.g();
                    MsgPhotoSelectedPagerFragment.this.o.b(childImageInfo);
                    MsgPhotoSelectedPagerFragment.this.e.notifyDataSetChanged();
                } else if (SelectPhotoManager.a().b() >= PhotoConstants.CONFIG.a) {
                    AppMethods.a(String.format(MsgPhotoSelectedPagerFragment.this.getResources().getString(R.string.max_select_num), Integer.valueOf(PhotoConstants.CONFIG.a)));
                } else if (MsgPhotoSelectedPagerFragment.this.i.isChecked() && MsgPhotoSelectedPagerFragment.this.o.getItemCount() + 1 > FlashPhotoManager.a().b().flash_left_times) {
                    PayVIPPopupWindow.c.a(MsgPhotoSelectedPagerFragment.this.f16259a, SelectPhotoManager.a().b(), new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.4.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TextView textView4 = MsgPhotoSelectedPagerFragment.this.h;
                            textView4.setText(MsgPhotoSelectedPagerFragment.this.f16259a.getString(R.string.delete_automatically) + FlashPhotoManager.a().b().flash_prompt);
                        }
                    });
                } else {
                    childImageInfo.mSelect = true;
                    MsgPhotoSelectedPagerFragment.this.m.setImageResource(R.drawable.photo_selected);
                    SelectPhotoManager.a().a(childImageInfo);
                    MsgPhotoSelectedPagerFragment.this.g();
                    MsgPhotoSelectedPagerFragment.this.o.a(childImageInfo);
                }
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MsgPhotoSelectedPagerFragment.this.h();
            }
        });
        this.f16260c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.6
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                MsgPhotoSelectedPagerFragment.this.q = i;
                MsgPhotoSelectedPagerFragment.this.b(i);
                MsgPhotoSelectedPagerFragment.this.o.c((ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(MsgPhotoSelectedPagerFragment.this.q));
            }
        });
        b(this.q);
        this.f16260c.setCurrentItem(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int b = SelectPhotoManager.a().b();
        if (b == 0) {
            this.g.setText(getString(R.string.send));
            this.g.setBackgroundResource(R.drawable.msg_send_photo_selector);
            return;
        }
        TextView textView = this.g;
        textView.setText(getString(R.string.send) + "(" + b + ")");
        this.g.setBackgroundResource(R.drawable.msg_send_photo_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void h() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void i() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.n.setLayoutManager(linearLayoutManager);
        this.n.setItemAnimator(new DefaultItemAnimator());
        MsgAblumAdapter msgAblumAdapter = new MsgAblumAdapter(getContext(), getFragmentActive(), this.n, SelectPhotoManager.a().a(this.q));
        this.o = msgAblumAdapter;
        this.n.setAdapter(msgAblumAdapter);
        this.o.a(new MsgAblumAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectedPagerFragment.7
            @Override // com.soft.blued.ui.feed.adapter.MsgAblumAdapter.OnItemClickListener
            public void a(ChildImageInfo childImageInfo) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= MsgPhotoSelectedPagerFragment.this.u.size()) {
                        return;
                    }
                    if (TextUtils.equals(((ChildImageInfo) MsgPhotoSelectedPagerFragment.this.u.get(i2)).mImagePath, childImageInfo.mImagePath)) {
                        MsgPhotoSelectedPagerFragment.this.q = i2;
                        MsgPhotoSelectedPagerFragment.this.f16260c.setCurrentItem(MsgPhotoSelectedPagerFragment.this.q, false);
                        return;
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    public void a(float f, float f2, float f3) {
    }

    public void a(int i) {
    }

    public void a(View view) {
        View view2 = this.p;
        if (view2 == null) {
            return;
        }
        if (view2.getVisibility() == 0) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
        }
    }

    public void a(Object... objArr) {
    }

    public void ak_() {
    }

    public void al_() {
    }

    public void am_() {
        h();
    }

    public void b(View view) {
    }

    public void b(Object... objArr) {
    }

    public void d() {
    }

    public void onCreate(Bundle bundle) {
        EventCallbackObserver.a().a(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16259a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_msg_photo_pager, viewGroup, false);
            e();
            f();
            g();
            b(this.q);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        EventCallbackObserver.a().b(this);
        super.onDestroy();
    }
}
