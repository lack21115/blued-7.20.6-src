package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.adapter.MsgAblumAdapter;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.util.LocalMediaLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoPagerFragment.class */
public class MsgPhotoPagerFragment extends BaseFragment implements EventCallBackListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f29902a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private HackyViewPager f29903c;
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
    private boolean r;
    private List<ChildImageInfo> s = new ArrayList();
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoPagerFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MsgPhotoPagerFragment.this.s.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            String str = !TextUtils.isEmpty(((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).imgUri) ? ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).imgUri : ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).mImagePath;
            if (LocalMediaLoader.MediaType.a(((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).mediaType)) {
                VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
                videoPlayConfig.f15652a = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).mImagePath;
                videoPlayConfig.b = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).mImagePath;
                videoPlayConfig.y = new MediaInfo();
                videoPlayConfig.o = false;
                videoPlayConfig.p = false;
                videoPlayConfig.q = true;
                videoPlayConfig.r = false;
                videoPlayConfig.m = true;
                videoPlayConfig.j = true;
                videoPlayConfig.v = true;
                videoPlayConfig.y.height = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).height;
                videoPlayConfig.y.width = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).width;
                videoPlayConfig.y.path = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).mImagePath;
                videoPlayConfig.y.videoTime = ((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i)).duration;
                videoPlayConfig.y.media_type = 3;
                return VideoDetailFragment.a(videoPlayConfig);
            }
            return ImageDetailFragment.a(str, true, 4, null, i, MsgPhotoPagerFragment.this.s.size());
        }
    }

    public static void a(BaseFragment baseFragment, int i, int i2, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i2);
        bundle.putInt("photo_index", i);
        bundle.putBoolean("photo_destroy_switch", z);
        bundle.putBoolean("photo_from_group", z2);
        TerminalActivity.a(baseFragment, MsgPhotoPagerFragment.class, bundle, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        ChildImageInfo a2 = ChildPhotoManager.a().a(i);
        if (LocalMediaLoader.MediaType.a(a2.mediaType)) {
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
            return;
        }
        if (this.t) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        }
        this.m.setVisibility(0);
        if (a2.mSelect) {
            this.m.setImageResource(R.drawable.photo_selected);
        } else {
            this.m.setImageResource(R.drawable.photo_unselected);
        }
    }

    private void e() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = arguments.getInt("photo_index", 0);
            this.r = arguments.getBoolean("photo_destroy_switch", false);
            this.t = arguments.getBoolean("photo_from_group", false);
        }
        this.s.addAll(ChildPhotoManager.a().c());
    }

    private void f() {
        this.d = LayoutInflater.from(this.f29902a);
        this.f29903c = (HackyViewPager) this.b.findViewById(2131368810);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.e = imagePagerAdapter;
        this.f29903c.setAdapter(imagePagerAdapter);
        this.p = this.b.findViewById(2131363095);
        View findViewById = this.b.findViewById(2131370694);
        this.j = findViewById;
        this.l = (ImageView) findViewById.findViewById(2131363120);
        this.k = (TextView) this.j.findViewById(2131363108);
        this.m = (ImageView) this.j.findViewById(2131363126);
        View findViewById2 = this.b.findViewById(2131362490);
        this.f = findViewById2;
        findViewById2.setBackgroundColor(getResources().getColor(2131101202));
        TextView textView = (TextView) this.b.findViewById(2131372554);
        this.g = textView;
        textView.setTextColor(getResources().getColor(2131101191));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.1
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        });
        CheckBox checkBox = (CheckBox) this.b.findViewById(R.id.iv_destroy_switch);
        this.i = checkBox;
        checkBox.setChecked(this.r);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_destroy);
        this.h = textView2;
        textView2.setTextColor(getResources().getColor(2131101191));
        TextView textView3 = this.h;
        textView3.setText(this.f29902a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ComplianceUtils.f10878a.a(MsgPhotoPagerFragment.this.getContext())) {
                    return;
                }
                int i = 1;
                if (FlashPhotoManager.a().b().flash_left_times > 0 && FlashPhotoManager.a().b().flash_left_times >= SelectPhotoManager.a().b()) {
                    MsgPhotoPagerFragment.this.i.setChecked(true ^ MsgPhotoPagerFragment.this.i.isChecked());
                    return;
                }
                PayVIPPopupWindow.Companion companion = PayVIPPopupWindow.f19924c;
                Context context = MsgPhotoPagerFragment.this.f29902a;
                if (SelectPhotoManager.a().b() != 0) {
                    i = SelectPhotoManager.a().b();
                }
                companion.a(context, i, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.2.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        TextView textView4 = MsgPhotoPagerFragment.this.h;
                        textView4.setText(MsgPhotoPagerFragment.this.f29902a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
                    }
                });
                MsgPhotoPagerFragment.this.i.setChecked(false);
            }
        });
        if (this.t) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        }
        this.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z && ComplianceUtils.f10878a.a(MsgPhotoPagerFragment.this.getContext())) {
                    MsgPhotoPagerFragment.this.i.setChecked(false);
                    return;
                }
                int i = 1;
                if (FlashPhotoManager.a().b().flash_left_times > 0 && FlashPhotoManager.a().b().flash_left_times >= SelectPhotoManager.a().b()) {
                    if (MsgPhotoPagerFragment.this.t) {
                        InstantLog.a("chat_burn_pic_click", (Object) 1);
                        return;
                    } else {
                        InstantLog.a("chat_burn_pic_click", (Object) 0);
                        return;
                    }
                }
                PayVIPPopupWindow.Companion companion = PayVIPPopupWindow.f19924c;
                Context context = MsgPhotoPagerFragment.this.f29902a;
                if (SelectPhotoManager.a().b() != 0) {
                    i = SelectPhotoManager.a().b();
                }
                companion.a(context, i, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.3.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        TextView textView4 = MsgPhotoPagerFragment.this.h;
                        textView4.setText(MsgPhotoPagerFragment.this.f29902a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
                    }
                });
                MsgPhotoPagerFragment.this.i.setChecked(false);
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.photo_ablum_listView);
        this.n = recyclerView;
        recyclerView.setHasFixedSize(true);
        g();
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChildImageInfo a2 = ChildPhotoManager.a().a(MsgPhotoPagerFragment.this.q);
                if (a2.mSelect) {
                    a2.mSelect = false;
                    MsgPhotoPagerFragment.this.m.setImageResource(R.drawable.photo_unselected);
                    SelectPhotoManager.a().b(a2);
                    MsgPhotoPagerFragment.this.o.b(a2);
                    MsgPhotoPagerFragment.this.h();
                    return;
                }
                int i = 1;
                if (SelectPhotoManager.a().b() >= PhotoConstants.CONFIG.f10707a) {
                    AppMethods.a((CharSequence) String.format(MsgPhotoPagerFragment.this.getResources().getString(2131890590), Integer.valueOf(PhotoConstants.CONFIG.f10707a)));
                } else if (!MsgPhotoPagerFragment.this.i.isChecked() || MsgPhotoPagerFragment.this.o.getItemCount() + 1 <= FlashPhotoManager.a().b().flash_left_times) {
                    a2.mSelect = true;
                    MsgPhotoPagerFragment.this.m.setImageResource(R.drawable.photo_selected);
                    SelectPhotoManager.a().a(a2);
                    MsgPhotoPagerFragment.this.h();
                    MsgPhotoPagerFragment.this.o.a(a2);
                } else {
                    PayVIPPopupWindow.Companion companion = PayVIPPopupWindow.f19924c;
                    Context context = MsgPhotoPagerFragment.this.f29902a;
                    if (MsgPhotoPagerFragment.this.o.getItemCount() != 0) {
                        i = MsgPhotoPagerFragment.this.o.getItemCount();
                    }
                    companion.a(context, i, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.4.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TextView textView4 = MsgPhotoPagerFragment.this.h;
                            textView4.setText(MsgPhotoPagerFragment.this.f29902a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
                        }
                    });
                }
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MsgPhotoPagerFragment.this.i();
            }
        });
        this.f29903c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.6
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                MsgPhotoPagerFragment.this.q = i;
                MsgPhotoPagerFragment msgPhotoPagerFragment = MsgPhotoPagerFragment.this;
                msgPhotoPagerFragment.b(msgPhotoPagerFragment.q);
                MsgPhotoPagerFragment.this.o.c((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(MsgPhotoPagerFragment.this.q));
            }
        });
        b(this.q);
        this.f29903c.setCurrentItem(this.q);
    }

    private void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.n.setLayoutManager(linearLayoutManager);
        this.n.setItemAnimator(new DefaultItemAnimator());
        MsgAblumAdapter msgAblumAdapter = new MsgAblumAdapter(getContext(), getFragmentActive(), this.n, ChildPhotoManager.a().a(this.q));
        this.o = msgAblumAdapter;
        this.n.setAdapter(msgAblumAdapter);
        this.o.a(new MsgAblumAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoPagerFragment.7
            @Override // com.soft.blued.ui.feed.adapter.MsgAblumAdapter.OnItemClickListener
            public void a(ChildImageInfo childImageInfo) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= MsgPhotoPagerFragment.this.s.size()) {
                        return;
                    }
                    if (TextUtils.equals(((ChildImageInfo) MsgPhotoPagerFragment.this.s.get(i2)).mImagePath, childImageInfo.mImagePath)) {
                        MsgPhotoPagerFragment.this.q = i2;
                        MsgPhotoPagerFragment.this.f29903c.setCurrentItem(MsgPhotoPagerFragment.this.q, false);
                        MsgPhotoPagerFragment.this.h();
                        return;
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
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
    public void i() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(float f, float f2, float f3) {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(int i) {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
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

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(Object... objArr) {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void ak_() {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void al_() {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void am_() {
        i();
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void b(View view) {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void b(Object... objArr) {
    }

    @Override // com.blued.android.module.player.media.observer.EventCallBackListener
    public void d() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1000 && intent != null && intent.getBooleanExtra("close_page", false)) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        EventCallbackObserver.a().a(this);
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f29902a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_msg_photo_pager, viewGroup, false);
            e();
            f();
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventCallbackObserver.a().b(this);
        super.onDestroy();
    }
}
