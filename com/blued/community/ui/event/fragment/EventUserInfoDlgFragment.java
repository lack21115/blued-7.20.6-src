package com.blued.community.ui.event.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentEventUserInfoBinding;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommonEditDlgFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.event.model.EventUserModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.das.client.feed.FeedProtos;
import com.igexin.c.a.c.a.d;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventUserInfoDlgFragment.class */
public final class EventUserInfoDlgFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19559a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private EventUserModel f19560c;
    private boolean f;
    private boolean g;
    private CommunityHttpUtils.IAddOrRemoveAttentionDone h;
    private boolean i;
    private EventLogData j;
    private int k;
    private final Lazy b = LazyKt.a(new Function0<FragmentEventUserInfoBinding>() { // from class: com.blued.community.ui.event.fragment.EventUserInfoDlgFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentEventUserInfoBinding invoke() {
            return FragmentEventUserInfoBinding.a(LayoutInflater.from(EventUserInfoDlgFragment.this.getContext()));
        }
    });
    private String d = "";
    private String e = "";

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventUserInfoDlgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, String str, String str2, EventLogData eventLogData) {
            if (fragmentManager == null) {
                return;
            }
            EventUserInfoDlgFragment eventUserInfoDlgFragment = new EventUserInfoDlgFragment();
            Bundle bundle = new Bundle();
            bundle.putString("uid", str);
            bundle.putString("aid", str2);
            bundle.putSerializable(d.d, eventLogData);
            eventUserInfoDlgFragment.setArguments(bundle);
            eventUserInfoDlgFragment.show(fragmentManager, EventUserInfoDlgFragment.class.getSimpleName());
            EventTrackFeed.a(FeedProtos.Event.ACTIVITY_PROFILE_LAYER_SHOW, eventLogData);
        }
    }

    private final void A() {
        CommonAlertDialog.a(getActivity(), getString(R.string.event_cancel_sub_dialog_title), getString(R.string.event_cancel_sub_dialog_content), getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$0lDYbI5CFLPOl6k6qk4ilL0kL8c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventUserInfoDlgFragment.a(EventUserInfoDlgFragment.this, dialogInterface, i);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void B() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        CommonEditDlgFragment.Companion companion = CommonEditDlgFragment.j;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        String k = k();
        boolean z = true;
        if (eventUserModel.is_activity_create_uid() != 1) {
            z = false;
        }
        companion.a(parentFragmentManager, k, z, eventUserModel.getActivity_sign_content());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        if (eventUserModel.is_followed() == 1) {
            h().n.setTextColor(getResources().getColor(R.color.syc_k));
            h().n.setText(R.string.followed);
            return;
        }
        h().n.setTextColor(getResources().getColor(R.color.syc_a));
        h().n.setText(R.string.follow);
    }

    private final void D() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        if (eventUserModel.is_followed() == 1) {
            CommonAlertDialog.a(getActivity(), getString(R.string.community_notice), getString(R.string.cancel_follow_hint), getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$wDEcpQfNYMfItqMMTgIplDL0dMY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    EventUserInfoDlgFragment.b(EventUserInfoDlgFragment.this, dialogInterface, i);
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            CommunityHttpUtils.b(getContext(), n(), j(), "event_user_info", a());
        }
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_PROFILE_LAYER_FOLLOW_CLICK, p());
    }

    private final void E() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        final ActivityFragmentActive a2 = a();
        eventHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<EventUserModel>>(a2) { // from class: com.blued.community.ui.event.fragment.EventUserInfoDlgFragment$onLoadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventUserModel> result) {
                Intrinsics.e(result, "result");
                EventUserInfoDlgFragment.this.a(result.getSingleData());
                EventUserInfoDlgFragment.this.s();
            }
        }, this.d, this.e, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final EventUserInfoDlgFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        final ActivityFragmentActive a2 = this$0.a();
        EventHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.community.ui.event.fragment.EventUserInfoDlgFragment$showCancelSubDialog$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                Intrinsics.e(parseData, "parseData");
                EventUserModel i2 = EventUserInfoDlgFragment.this.i();
                if (i2 != null) {
                    i2.set_subscribe(0);
                }
                EventUserInfoDlgFragment.this.y();
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.f20461a;
                EventUserModel i3 = EventUserInfoDlgFragment.this.i();
                commEventBusUtil.e(i3 == null ? null : i3.uid);
            }
        }, this$0.d, this$0.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventUserInfoDlgFragment this$0, String it) {
        Intrinsics.e(this$0, "this$0");
        EventUserModel eventUserModel = this$0.f19560c;
        if (eventUserModel != null) {
            Intrinsics.c(it, "it");
            eventUserModel.setActivity_sign_content(it);
        }
        EventUserModel eventUserModel2 = this$0.f19560c;
        if (eventUserModel2 != null) {
            eventUserModel2.setActivity_sign_status(1);
        }
        this$0.s();
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventUserInfoDlgFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        CommunityHttpUtils.a(this$0.getContext(), this$0.h, this$0.d, "event_user_info", this$0.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.B();
    }

    private final StaticLayout c(String str) {
        int a2 = AppInfo.l - DisplayUtil.a(getContext(), 120.0f);
        if (Build.VERSION.SDK_INT >= 23) {
            StaticLayout build = StaticLayout.Builder.obtain(str, 0, str.length(), h().j.getPaint(), a2).setLineSpacing(h().j.getLineSpacingExtra(), h().j.getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setHyphenationFrequency(2).build();
            Intrinsics.c(build, "{\n             StaticLay…       .build()\n        }");
            return build;
        }
        return new StaticLayout(str, 0, str.length(), h().j.getPaint(), a2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EventUserInfoDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.w();
    }

    private final void r() {
        this.h = new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.event.fragment.EventUserInfoDlgFragment$initView$1
            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                EventUserModel i = EventUserInfoDlgFragment.this.i();
                if (i != null) {
                    i.set_followed(1);
                }
                EventUserInfoDlgFragment.this.C();
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.f20461a;
                EventUserModel i2 = EventUserInfoDlgFragment.this.i();
                commEventBusUtil.a(i2 == null ? null : i2.uid);
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                EventUserModel i = EventUserInfoDlgFragment.this.i();
                if (i != null) {
                    i.set_followed(0);
                }
                EventUserInfoDlgFragment.this.C();
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.f20461a;
                EventUserModel i2 = EventUserInfoDlgFragment.this.i();
                commEventBusUtil.b(i2 == null ? null : i2.uid);
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void c() {
            }
        };
        if (CommunityManager.f19086a.a().s()) {
            h().i.setBackgroundResource(R.drawable.community_dlg_fragment_bg_dark);
        } else {
            h().i.setBackgroundResource(R.drawable.community_dlg_fragment_bg);
        }
        h().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$7qcRh_puEuVgoyy6m-nws6_Q450
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventUserInfoDlgFragment.a(EventUserInfoDlgFragment.this, view);
            }
        });
        h().l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$-hd87nKt0oKYXGy4jtcsNKIr7Bk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventUserInfoDlgFragment.b(EventUserInfoDlgFragment.this, view);
            }
        });
        if (CommunityManager.f19086a.a().s()) {
            h().k.setCardBackgroundColor(Color.parseColor("#19D0D0D0"));
            h().l.setImageResource(R.drawable.event_signature_edit_icon_dark);
            this.k = getResources().getColor(R.color.syc_dark_d0d0d0);
        } else {
            h().k.setCardBackgroundColor(Color.parseColor("#19777777"));
            h().l.setImageResource(R.drawable.event_signature_edit_icon);
            this.k = getResources().getColor(R.color.syc_dark_777777);
        }
        LiveEventBus.get("event_signature_post_success", String.class).observe(this, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$6DwJ_MKV8mEum6Zbwcd6yN3Bsto
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventUserInfoDlgFragment.a(EventUserInfoDlgFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        a(eventUserModel.is_activity_create_uid() == 1);
        ImageLoader.a(a(), eventUserModel.avatar).b(R.drawable.user_bg_round).c().a(h().f);
        UserInfoHelper.b(h().z, eventUserModel.vbadge);
        h().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$48pK1jTj80dPTG0sqWd9_FPIHpQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventUserInfoDlgFragment.c(EventUserInfoDlgFragment.this, view);
            }
        });
        UserInfoHelper.a(h().A, eventUserModel);
        h().p.setText(eventUserModel.name);
        h().q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$w5Z7tmMJsGBCXZNAMIIVCUSkJW8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventUserInfoDlgFragment.d(EventUserInfoDlgFragment.this, view);
            }
        });
        if (UserInfoHelper.b(eventUserModel.vbadge)) {
            h().e.setVisibility(8);
        } else {
            h().e.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(eventUserModel.age)) {
                sb.append(eventUserModel.age);
            }
            if (!TextUtils.isEmpty(eventUserModel.height)) {
                if (sb.length() > 0) {
                    sb.append(BridgeUtil.SPLIT_MARK);
                }
                sb.append(eventUserModel.height);
            }
            if (!TextUtils.isEmpty(eventUserModel.weight)) {
                if (sb.length() > 0) {
                    sb.append(BridgeUtil.SPLIT_MARK);
                }
                sb.append(eventUserModel.weight);
            }
            if (!TextUtils.isEmpty(eventUserModel.role)) {
                if (sb.length() > 0) {
                    sb.append(" · ");
                }
                sb.append(UserInfoHelper.a(getContext(), eventUserModel.role));
            }
            h().e.setText(sb.toString());
        }
        t();
        h().t.setVisibility(0);
        h().s.setVisibility(0);
        h().s.setText(FeedMethods.i().get(String.valueOf(eventUserModel.getRegistration_time())));
        h().f18861c.setText(String.valueOf(eventUserModel.getRelease_activity_num()));
        h().f18861c.setVisibility(0);
        h().d.setVisibility(0);
        h().f18860a.setText(String.valueOf(eventUserModel.getJoin_activity_num()));
        h().f18860a.setVisibility(0);
        h().b.setVisibility(0);
        if (m()) {
            h().u.setVisibility(8);
        } else {
            h().u.setVisibility(0);
            h().u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$G5yxwLOvN5vUpUxR_07sRuQPQ_w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventUserInfoDlgFragment.e(EventUserInfoDlgFragment.this, view);
                }
            });
        }
        if (!l() || m()) {
            h().v.setVisibility(8);
            h().g.setVisibility(8);
            h().h.setVisibility(8);
            h().x.setVisibility(8);
        } else {
            h().v.setVisibility(0);
            h().x.setVisibility(0);
            h().x.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$wukewbkGImW7zQ9d-mS-6l9ztFo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventUserInfoDlgFragment.f(EventUserInfoDlgFragment.this, view);
                }
            });
            y();
            h().h.setVisibility(0);
            h().g.setVisibility(0);
            h().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$hONkR1FCr-pW-uI8DsmZwrtrWdo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventUserInfoDlgFragment.g(EventUserInfoDlgFragment.this, view);
                }
            });
        }
        if (m() || l()) {
            h().o.setVisibility(8);
            h().n.setVisibility(8);
        } else {
            h().o.setVisibility(0);
            h().n.setVisibility(0);
            h().n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$pQn9F70gZvPmEJg6ZiIjkfVIqGY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventUserInfoDlgFragment.h(EventUserInfoDlgFragment.this, view);
                }
            });
            C();
        }
        h().r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventUserInfoDlgFragment$tpbo27b1xwQL8kDkjFAVDw0Pa5A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventUserInfoDlgFragment.i(EventUserInfoDlgFragment.this, view);
            }
        });
    }

    private final void t() {
        String activity_sign_content;
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        h().m.setVisibility(0);
        if (o()) {
            h().j.setMaxLines(20);
        } else {
            h().j.setMaxLines(2);
        }
        h().j.setMaxWidth(AppInfo.l - DisplayUtil.a(AppInfo.d(), 120.0f));
        if (!m()) {
            h().k.setVisibility(8);
            h().l.setVisibility(8);
        } else if (TextUtils.isEmpty(eventUserModel.getActivity_sign_content()) || eventUserModel.getActivity_sign_status() != 0) {
            h().k.setVisibility(8);
            h().l.setVisibility(0);
        } else {
            h().k.setVisibility(0);
            h().l.setVisibility(8);
        }
        if (m()) {
            if (!TextUtils.isEmpty(eventUserModel.getActivity_sign_content())) {
                activity_sign_content = eventUserModel.getActivity_sign_content();
            }
            activity_sign_content = "";
        } else {
            if (!TextUtils.isEmpty(eventUserModel.getActivity_sign_content()) && eventUserModel.getActivity_sign_status() == 0) {
                activity_sign_content = eventUserModel.getActivity_sign_content();
            }
            activity_sign_content = "";
        }
        String str = activity_sign_content;
        if (TextUtils.isEmpty(activity_sign_content)) {
            str = eventUserModel.getActivity_sign_content();
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getString(m() ? R.string.event_introduce_yourselef : R.string.event_no_signature);
            Intrinsics.c(str2, "getString(\n             …      }\n                )");
        }
        StaticLayout c2 = c(str2);
        if (c2.getLineCount() <= 2) {
            h().j.setText(str2);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (o()) {
            h().j.setMaxLines(20);
            spannableStringBuilder.append((CharSequence) Intrinsics.a(str2, (Object) " "));
            String string = getString(R.string.event_signature_collapse);
            Intrinsics.c(string, "getString(R.string.event_signature_collapse)");
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(q()), 0, string.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            h().j.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        String substring = str2.substring(0, c2.getLineEnd(1));
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        while (true) {
            if (c(substring + "..." + getString(R.string.event_signature_expand)).getLineCount() <= 2) {
                spannableStringBuilder.append((CharSequence) Intrinsics.a(substring, (Object) "..."));
                String string2 = getString(R.string.event_signature_expand);
                Intrinsics.c(string2, "getString(R.string.event_signature_expand)");
                SpannableString spannableString2 = new SpannableString(string2);
                spannableString2.setSpan(new ForegroundColorSpan(q()), 0, string2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString2);
                h().j.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            substring = substring.substring(0, substring.length() - 1);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
    }

    private final void u() {
        if (this.f19560c != null) {
            this.i = !this.i;
            t();
        }
    }

    private final void v() {
        dismissAllowingStateLoss();
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        CommunityServiceManager.b().a(getContext(), eventUserModel.name, k(), 0, j(), 1, eventUserModel.getActivity_sign_id());
    }

    private final void w() {
        dismissAllowingStateLoss();
        CommunityServiceManager.b().a(getContext(), this.d, "event_user_info");
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_PROFILE_LAYER_LOOK_CLICK, this.j);
    }

    private final void x() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null || UserInfoHelper.a(eventUserModel.relationship)) {
            return;
        }
        dismissAllowingStateLoss();
        FeedMethods.a(getContext(), i(), FeedMethods.j(), FeedMethods.b(0, 0));
        EventLogData eventLogData = new EventLogData();
        eventLogData.setUid(j());
        eventLogData.setEventId(k());
        eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_DETAIL);
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_PROFILE_LAYER_MSG_CLICK, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        if (eventUserModel.is_subscribe() == 1) {
            h().w.setVisibility(8);
            h().y.setText(getString(R.string.subscribed));
            h().y.setTextColor(getResources().getColor(R.color.syc_k));
            return;
        }
        h().w.setVisibility(0);
        h().y.setText(getString(R.string.subscribe));
        h().y.setTextColor(getResources().getColor(R.color.syc_a));
    }

    private final void z() {
        EventUserModel eventUserModel = this.f19560c;
        if (eventUserModel == null) {
            return;
        }
        if (eventUserModel.is_subscribe() == 1) {
            A();
            return;
        }
        final ActivityFragmentActive a2 = a();
        EventHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.community.ui.event.fragment.EventUserInfoDlgFragment$onClickSub$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                Intrinsics.e(parseData, "parseData");
                EventUserModel i = EventUserInfoDlgFragment.this.i();
                if (i != null) {
                    i.set_subscribe(1);
                }
                EventUserInfoDlgFragment.this.y();
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.f20461a;
                EventUserModel i2 = EventUserInfoDlgFragment.this.i();
                commEventBusUtil.d(i2 == null ? null : i2.uid);
            }
        }, j(), a());
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_PROFILE_LAYER_SUBSCRIBE_CLICK, p());
    }

    public final void a(EventLogData eventLogData) {
        this.j = eventLogData;
    }

    public final void a(EventUserModel eventUserModel) {
        this.f19560c = eventUserModel;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.d = str;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.e = str;
    }

    public final void b(boolean z) {
        this.g = z;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean e() {
        return false;
    }

    public final FragmentEventUserInfoBinding h() {
        return (FragmentEventUserInfoBinding) this.b.getValue();
    }

    public final EventUserModel i() {
        return this.f19560c;
    }

    public final String j() {
        return this.d;
    }

    public final String k() {
        return this.e;
    }

    public final boolean l() {
        return this.f;
    }

    public final boolean m() {
        return this.g;
    }

    public final CommunityHttpUtils.IAddOrRemoveAttentionDone n() {
        return this.h;
    }

    public final boolean o() {
        return this.i;
    }

    public final EventLogData p() {
        return this.j;
    }

    public final int q() {
        return this.k;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(h().getRoot());
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("uid", "");
            Intrinsics.c(string, "it.getString(\"uid\", \"\")");
            a(string);
            String string2 = arguments.getString("aid", "");
            Intrinsics.c(string2, "it.getString(\"aid\", \"\")");
            b(string2);
            b(CommunityManager.f19086a.a().c(j()));
            Serializable serializable = arguments.getSerializable(d.d);
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.event.model.EventLogData");
            }
            a((EventLogData) serializable);
        }
        r();
        E();
    }
}
