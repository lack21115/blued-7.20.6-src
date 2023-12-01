package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/PopPushSwitch.class */
public final class PopPushSwitch extends BottomPopupView {
    private static final int t = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18814c;
    private boolean d;
    private boolean e;
    private boolean f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ShapeTextView k;
    public static final Companion b = new Companion(null);
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/PopPushSwitch$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopPushSwitch(Context context) {
        super(context);
        Intrinsics.e(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.f18814c = !popPushSwitch.f18814c;
        popPushSwitch.f = false;
        popPushSwitch.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.d = !popPushSwitch.d;
        popPushSwitch.f = false;
        popPushSwitch.d();
    }

    private final void c() {
        Map<String, String> a2 = BluedHttpTools.a();
        if (this.f) {
            if (!BluedPreferences.aj()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_other_message_push", "1");
                BluedPreferences.p(true);
            }
            if (!BluedPreferences.ak()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_private_msg_push", "1");
                BluedPreferences.q(true);
            }
            if (!BluedPreferences.am()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_groups_notify", "1");
                BluedPreferences.s(true);
            }
            if (!BluedPreferences.ao()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_like_push", "1");
                BluedPreferences.u(true);
            }
            if (!BluedPreferences.an()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_comment_push", "1");
                BluedPreferences.t(true);
            }
            if (!BluedPreferences.ap()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_at_push", "1");
                BluedPreferences.v(true);
            }
            if (!BluedPreferences.ai()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_live_push", "0");
                BluedPreferences.o(true);
            }
            if (!BluedPreferences.al()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_followed_push", "1");
                BluedPreferences.r(true);
            }
        } else {
            if (this.f18814c && !BluedPreferences.ak()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_private_msg_push", "1");
                BluedPreferences.q(true);
            }
            if (this.d && !BluedPreferences.am()) {
                Intrinsics.c(a2, "ajaxParams");
                a2.put("is_groups_notify", "1");
                BluedPreferences.s(true);
            }
            if (this.e) {
                if (!BluedPreferences.ao()) {
                    Intrinsics.c(a2, "ajaxParams");
                    a2.put("is_like_push", "1");
                    BluedPreferences.u(true);
                }
                if (!BluedPreferences.an()) {
                    Intrinsics.c(a2, "ajaxParams");
                    a2.put("is_comment_push", "1");
                    BluedPreferences.t(true);
                }
                if (!BluedPreferences.ap()) {
                    Intrinsics.c(a2, "ajaxParams");
                    a2.put("is_at_push", "1");
                    BluedPreferences.v(true);
                }
            }
        }
        setReminding(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.e = !popPushSwitch.e;
        popPushSwitch.f = false;
        popPushSwitch.d();
    }

    private final void d() {
        ImageView imageView = this.g;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("cb_chat");
            imageView2 = null;
        }
        imageView2.setImageResource(!this.f18814c ? 2131237252 : 2131237255);
        ImageView imageView3 = this.h;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("cb_group");
            imageView4 = null;
        }
        imageView4.setImageResource(!this.d ? 2131237252 : 2131237255);
        ImageView imageView5 = this.i;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("cb_community");
            imageView6 = null;
        }
        imageView6.setImageResource(!this.e ? 2131237252 : 2131237255);
        ImageView imageView7 = this.j;
        if (imageView7 == null) {
            Intrinsics.c("cb_all");
            imageView7 = null;
        }
        imageView7.setImageResource(!this.f ? 2131237252 : 2131237255);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.f = !popPushSwitch.f;
        popPushSwitch.d = false;
        popPushSwitch.f18814c = false;
        popPushSwitch.e = false;
        popPushSwitch.d();
    }

    private final void e() {
        boolean z;
        if (this.f || (z = this.f18814c) || this.d || z) {
            ShapeTextView shapeTextView = this.k;
            ShapeTextView shapeTextView2 = shapeTextView;
            if (shapeTextView == null) {
                Intrinsics.c("tv_open");
                shapeTextView2 = null;
            }
            shapeTextView2.setEnabled(true);
            ShapeTextView shapeTextView3 = this.k;
            if (shapeTextView3 == null) {
                Intrinsics.c("tv_open");
                shapeTextView3 = null;
            }
            ShapeHelper.b(shapeTextView3, 2131101766);
            return;
        }
        ShapeTextView shapeTextView4 = this.k;
        ShapeTextView shapeTextView5 = shapeTextView4;
        if (shapeTextView4 == null) {
            Intrinsics.c("tv_open");
            shapeTextView5 = null;
        }
        shapeTextView5.setEnabled(false);
        ShapeTextView shapeTextView6 = this.k;
        if (shapeTextView6 == null) {
            Intrinsics.c("tv_open");
            shapeTextView6 = null;
        }
        ShapeHelper.b(shapeTextView6, 2131102263);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.p();
        EventTrackMessage.a(MessageProtos.Event.MSG_OPEN_PUSH_POP_NO_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PopPushSwitch popPushSwitch, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popPushSwitch, "this$0");
        popPushSwitch.c();
        popPushSwitch.p();
        EventTrackMessage.a(MessageProtos.Event.MSG_OPEN_PUSH_POP_OPEN_CLICK, popPushSwitch.getType());
    }

    private final String getType() {
        StringBuilder sb = new StringBuilder();
        if (this.f) {
            sb.append(String.valueOf(t));
        }
        if (this.f18814c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(u);
            sb2.append(',');
            sb.append(sb2.toString());
        }
        if (this.d) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(v);
            sb3.append(',');
            sb.append(sb3.toString());
        }
        if (this.e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(w);
            sb4.append(',');
            sb.append(sb4.toString());
        }
        String sb5 = sb.toString();
        Intrinsics.c(sb5, "stringBuilder.toString()");
        return sb5;
    }

    private final void setReminding(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.msg.pop.PopPushSwitch$setReminding$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    ToastUtils.a(AppInfo.d().getString(R.string.msg_push_open_succeed));
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, (IRequestHost) null);
    }

    public void b() {
        super.b();
        View findViewById = findViewById(R.id.cb_chat);
        Intrinsics.c(findViewById, "findViewById(R.id.cb_chat)");
        this.g = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.cb_group);
        Intrinsics.c(findViewById2, "findViewById(R.id.cb_group)");
        this.h = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.cb_community);
        Intrinsics.c(findViewById3, "findViewById(R.id.cb_community)");
        this.i = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.cb_all);
        Intrinsics.c(findViewById4, "findViewById(R.id.cb_all)");
        this.j = (ImageView) findViewById4;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_chat);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_group);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_community);
        ShapeTextView findViewById5 = findViewById(R.id.tv_ignore);
        ShapeTextView findViewById6 = findViewById(R.id.tv_open);
        Intrinsics.c(findViewById6, "findViewById<ShapeTextView>(R.id.tv_open)");
        this.k = findViewById6;
        if (BluedPreferences.ak()) {
            relativeLayout.setVisibility(8);
        }
        if (BluedPreferences.am()) {
            relativeLayout2.setVisibility(8);
        }
        if (BluedPreferences.ao() && BluedPreferences.an() && BluedPreferences.ap()) {
            relativeLayout3.setVisibility(8);
        }
        ImageView imageView = this.g;
        ImageView imageView2 = imageView;
        if (imageView == null) {
            Intrinsics.c("cb_chat");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$l5O_La4dqoXdw6oulfN4-S5XH9M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.a(PopPushSwitch.this, view);
            }
        });
        ImageView imageView3 = this.h;
        ImageView imageView4 = imageView3;
        if (imageView3 == null) {
            Intrinsics.c("cb_group");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$piXCLz8nLLrYwMWaKfG_h1gu-yA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.b(PopPushSwitch.this, view);
            }
        });
        ImageView imageView5 = this.i;
        ImageView imageView6 = imageView5;
        if (imageView5 == null) {
            Intrinsics.c("cb_community");
            imageView6 = null;
        }
        imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$e5m9hlZbsRmf2UxtftMyynVVvvs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.c(PopPushSwitch.this, view);
            }
        });
        ImageView imageView7 = this.j;
        ImageView imageView8 = imageView7;
        if (imageView7 == null) {
            Intrinsics.c("cb_all");
            imageView8 = null;
        }
        imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$9ay8nArSkoyIdxBf_12FmY4U6pk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.d(PopPushSwitch.this, view);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$vCXPswdiEL7nicmJDwTbsz3cncM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.e(PopPushSwitch.this, view);
            }
        });
        ShapeTextView shapeTextView = this.k;
        if (shapeTextView == null) {
            Intrinsics.c("tv_open");
            shapeTextView = null;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopPushSwitch$4E6X7vk_kJ5MLettpZ0TbnPbu-A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopPushSwitch.f(PopPushSwitch.this, view);
            }
        });
        this.f = true;
        d();
    }

    public int getImplLayoutId() {
        return R.layout.pop_push_switch;
    }
}
