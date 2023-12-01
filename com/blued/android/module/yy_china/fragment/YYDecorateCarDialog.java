package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogDecorateCarLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarDialog.class */
public final class YYDecorateCarDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogDecorateCarLayoutBinding f17199a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f17200c;
    private String d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateCarDialog$DecoratePageAdapter.class */
    public final class DecoratePageAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYDecorateCarDialog f17201a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoratePageAdapter(YYDecorateCarDialog this$0, FragmentManager manager) {
            super(manager, 1);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(manager, "manager");
            this.f17201a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new YYDecorateCarFragment() : new YYDecorateExhibitionFragment(this.f17201a.d, this.f17201a.e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public YYDecorateCarDialog(java.lang.String r4, java.lang.String r5, int r6, com.blued.android.core.ui.BaseFragment r7) {
        /*
            r3 = this;
            r0 = r7
            java.lang.String r1 = "fragment"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r3
            r0.<init>()
            r0 = r4
            if (r0 == 0) goto L1c
            r0 = r4
            r8 = r0
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L2b
        L1c:
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r0 = r0.k()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "{\n            YYRoomInfo…stance().selfId\n        }"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
        L2b:
            r0 = r3
            r1 = r8
            r0.d = r1
            r0 = r5
            if (r0 == 0) goto L41
            r0 = r5
            r4 = r0
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4e
        L41:
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r0 = r0.l()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "{\n            YYRoomInfo…ance().selfName\n        }"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
        L4e:
            r0 = r3
            r1 = r4
            r0.e = r1
            r0 = r3
            r1 = r6
            r0.b = r1
            r0 = r3
            r1 = r7
            r0.f17200c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYDecorateCarDialog.<init>(java.lang.String, java.lang.String, int, com.blued.android.core.ui.BaseFragment):void");
    }

    private final void a(int i, String str) {
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.g.setVisibility(8);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this.f17199a;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding3 = null;
        }
        dialogDecorateCarLayoutBinding3.f.setVisibility(8);
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this.f17200c, YYRoomInfoManager.e().c().a(i));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYWebViewDialogFragment.show(childFragmentManager, str);
    }

    private final void a(final SVGAImageView sVGAImageView, String str, final int i) {
        sVGAImageView.setVisibility(0);
        sVGAImageView.setLoops(1);
        SVGAParser.a(new SVGAParser(getContext()), str, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarDialog$playSvga$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                Intrinsics.e(svgaVideoEntity, "svgaVideoEntity");
                SVGAImageView.this.setImageDrawable(new SVGADrawable(svgaVideoEntity, new SVGADynamicEntity()));
                SVGAImageView.this.a();
                final SVGAImageView sVGAImageView2 = SVGAImageView.this;
                final int i2 = i;
                sVGAImageView2.setCallback(new SVGACallback() { // from class: com.blued.android.module.yy_china.fragment.YYDecorateCarDialog$playSvga$1$onComplete$1
                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onFinished() {
                        SVGAImageView.this.b();
                        SVGAImageView.this.setImageResource(i2);
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onPause() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onRepeat() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onStep(int i3, double d) {
                    }
                });
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_CAR_TAB_CLICK, b.room_id, b.uid);
        }
        this$0.getChildFragmentManager().setFragmentResult("close_keyboard", BundleKt.bundleOf(new Pair[0]));
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.k.a(true);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        dialogDecorateCarLayoutBinding4.k.setImageResource(R.drawable.icon_decorate_exhibition_tab_normal);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding6 = dialogDecorateCarLayoutBinding5;
        if (dialogDecorateCarLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding6 = null;
        }
        SVGAImageView sVGAImageView = dialogDecorateCarLayoutBinding6.j;
        Intrinsics.c(sVGAImageView, "mBinding.tabLeftSvga");
        this$0.a(sVGAImageView, "decorate_car.svga", R.drawable.icon_decorate_car_tab_selected);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding7 = this$0.f17199a;
        if (dialogDecorateCarLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding7 = null;
        }
        dialogDecorateCarLayoutBinding7.l.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_HALL_TAB_CLICK, b.room_id, b.uid);
        }
        this$0.getChildFragmentManager().setFragmentResult("close_keyboard", BundleKt.bundleOf(new Pair[0]));
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.j.a(true);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        dialogDecorateCarLayoutBinding4.j.setImageResource(R.drawable.icon_decorate_car_tab_normal);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding6 = dialogDecorateCarLayoutBinding5;
        if (dialogDecorateCarLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding6 = null;
        }
        SVGAImageView sVGAImageView = dialogDecorateCarLayoutBinding6.k;
        Intrinsics.c(sVGAImageView, "mBinding.tabRightSvga");
        this$0.a(sVGAImageView, "decorate_exhibition.svga", R.drawable.icon_decorate_exhibition_tab_selected);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding7 = this$0.f17199a;
        if (dialogDecorateCarLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding7 = null;
        }
        dialogDecorateCarLayoutBinding7.l.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_MORE_CLICK, b.room_id, b.uid);
        }
        this$0.getChildFragmentManager().setFragmentResult("close_keyboard", BundleKt.bundleOf(new Pair[0]));
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        ConstraintLayout constraintLayout = dialogDecorateCarLayoutBinding2.g;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        constraintLayout.setVisibility(dialogDecorateCarLayoutBinding4.g.getVisibility() == 0 ? 8 : 0);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding6 = dialogDecorateCarLayoutBinding5;
        if (dialogDecorateCarLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding6 = null;
        }
        View view2 = dialogDecorateCarLayoutBinding6.f;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding7 = this$0.f17199a;
        if (dialogDecorateCarLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding7 = null;
        }
        int i = 0;
        if (dialogDecorateCarLayoutBinding7.f.getVisibility() == 0) {
            i = 8;
        }
        view2.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this$0.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.g.setVisibility(8);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this$0.f17199a;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding3 = null;
        }
        dialogDecorateCarLayoutBinding3.f.setVisibility(8);
    }

    private final void f() {
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.l.a(false);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        DecoratePageAdapter decoratePageAdapter = new DecoratePageAdapter(this, childFragmentManager);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        dialogDecorateCarLayoutBinding4.l.setAdapter(decoratePageAdapter);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this.f17199a;
        if (dialogDecorateCarLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding5 = null;
        }
        dialogDecorateCarLayoutBinding5.l.setOffscreenPageLimit(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_RULE_CLICK, b.room_id, b.uid);
        }
        this$0.a(13, "yy_car_introduction_dialog");
    }

    private final void g() {
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$RMoz8IwwUQM28j_j5eA91BTS-U4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.b(YYDecorateCarDialog.this, view);
            }
        });
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this.f17199a;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding3 = null;
        }
        dialogDecorateCarLayoutBinding3.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$BbW3hUXvBBraBn4LVNOAlDFdC-g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.c(YYDecorateCarDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYDecorateCarDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_MADE_CAR_PAGE_RECORD_CLICK, b.room_id, b.uid);
        }
        this$0.a(14, "yy_car_record_dialog");
    }

    private final void h() {
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$hP3wD5bS3REVN-Fd95iSLzVmTj8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.d(YYDecorateCarDialog.this, view);
            }
        });
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        dialogDecorateCarLayoutBinding4.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$dnZBaRfeoqoFVPV2ZoX-1nrr4ug
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.e(YYDecorateCarDialog.this, view);
            }
        });
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding6 = dialogDecorateCarLayoutBinding5;
        if (dialogDecorateCarLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding6 = null;
        }
        dialogDecorateCarLayoutBinding6.f16326a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$yKiOFZcNtmFfa6rIpE-KYLU9V34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.f(YYDecorateCarDialog.this, view);
            }
        });
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding7 = this.f17199a;
        if (dialogDecorateCarLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding7 = null;
        }
        dialogDecorateCarLayoutBinding7.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$8yIjTzAz-DUY08IJMegJlNovIqM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDecorateCarDialog.g(YYDecorateCarDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_decorate_car_layout, (ViewGroup) null);
        DialogDecorateCarLayoutBinding a2 = DialogDecorateCarLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f17199a = a2;
        f();
        g();
        h();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding2 = dialogDecorateCarLayoutBinding;
        if (dialogDecorateCarLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding2 = null;
        }
        dialogDecorateCarLayoutBinding2.f16327c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateCarDialog$CLkgcSpMBvFApgn6iOqB32B8t5I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateCarDialog.a(YYDecorateCarDialog.this, view2);
            }
        });
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding3 = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding4 = dialogDecorateCarLayoutBinding3;
        if (dialogDecorateCarLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding4 = null;
        }
        dialogDecorateCarLayoutBinding4.l.setCurrentItem(this.b);
        if (this.b == 1) {
            DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding5 = this.f17199a;
            DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding6 = dialogDecorateCarLayoutBinding5;
            if (dialogDecorateCarLayoutBinding5 == null) {
                Intrinsics.c("mBinding");
                dialogDecorateCarLayoutBinding6 = null;
            }
            dialogDecorateCarLayoutBinding6.j.setImageResource(R.drawable.icon_decorate_car_tab_normal);
            DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding7 = this.f17199a;
            if (dialogDecorateCarLayoutBinding7 == null) {
                Intrinsics.c("mBinding");
                dialogDecorateCarLayoutBinding7 = null;
            }
            dialogDecorateCarLayoutBinding7.k.setImageResource(R.drawable.icon_decorate_exhibition_tab_selected);
            return;
        }
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding8 = this.f17199a;
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding9 = dialogDecorateCarLayoutBinding8;
        if (dialogDecorateCarLayoutBinding8 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding9 = null;
        }
        dialogDecorateCarLayoutBinding9.j.setImageResource(R.drawable.icon_decorate_car_tab_selected);
        DialogDecorateCarLayoutBinding dialogDecorateCarLayoutBinding10 = this.f17199a;
        if (dialogDecorateCarLayoutBinding10 == null) {
            Intrinsics.c("mBinding");
            dialogDecorateCarLayoutBinding10 = null;
        }
        dialogDecorateCarLayoutBinding10.k.setImageResource(R.drawable.icon_decorate_exhibition_tab_normal);
    }
}
