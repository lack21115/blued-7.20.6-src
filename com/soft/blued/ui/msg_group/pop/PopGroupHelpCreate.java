package com.soft.blued.ui.msg_group.pop;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupHelpCreateBinding;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.GroupHelpAdapter;
import com.soft.blued.ui.msg_group.model.GroupApplyResp;
import com.soft.blued.ui.user.presenter.PayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupHelpCreate.class */
public final class PopGroupHelpCreate extends CenterPopupView {
    private final int e;
    private final String f;
    private final GroupApplyResp g;
    private final IRequestHost h;
    private final ViewBindingProperty i;
    private final ArrayList<GroupApplyResp.User> j;
    static final /* synthetic */ KProperty<Object>[] d = {(KProperty) Reflection.a(new PropertyReference1Impl(PopGroupHelpCreate.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupHelpCreateBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f19107c = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupHelpCreate$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x006c -> B:6:0x0039). Please submit an issue!!! */
        public final void a(Context context, String str, String str2) {
            Intrinsics.e(context, "context");
            Intrinsics.e(str, "code");
            Intrinsics.e(str2, "groupId");
            Object systemService = context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            try {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", str));
            } catch (Exception e) {
            }
            new XPopup.Builder(context).a(PopupAnimation.a).d(true).a(new PopGroupCommandSend(context, str2)).h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopGroupHelpCreate(Context context, int i, String str, GroupApplyResp groupApplyResp, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, "groupId");
        Intrinsics.e(groupApplyResp, "resp");
        Intrinsics.e(iRequestHost, "requestHost");
        this.e = i;
        this.f = str;
        this.g = groupApplyResp;
        this.h = iRequestHost;
        BasePopupView basePopupView = (BasePopupView) this;
        this.i = new CustomViewBindingProperty(new Function1<PopGroupHelpCreate, PopGroupHelpCreateBinding>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupHelpCreateBinding invoke(PopGroupHelpCreate popGroupHelpCreate) {
                Intrinsics.e(popGroupHelpCreate, "popView");
                return PopGroupHelpCreateBinding.a(popGroupHelpCreate.getPopupImplView());
            }
        });
        this.j = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupHelpCreate popGroupHelpCreate, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupHelpCreate, "this$0");
        popGroupHelpCreate.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r0.length() == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate r5, com.chad.library.adapter.base.BaseQuickAdapter r6, android.view.View r7, int r8) {
        /*
            r0 = r5
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            java.util.List r0 = r0.getData()
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L82
            r0 = r6
            com.soft.blued.ui.msg_group.model.GroupApplyResp$User r0 = (com.soft.blued.ui.msg_group.model.GroupApplyResp.User) r0
            r6 = r0
            r0 = r6
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7 = r0
            r0 = 0
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L3a
            r0 = r7
            int r0 = r0.length()
            if (r0 != 0) goto L35
            goto L3a
        L35:
            r0 = 0
            r8 = r0
            goto L3c
        L3a:
            r0 = 1
            r8 = r0
        L3c:
            r0 = r8
            if (r0 == 0) goto L81
            r0 = r6
            java.lang.String r0 = r0.getAvatar()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L58
            r0 = r9
            r8 = r0
            r0 = r6
            int r0 = r0.length()
            if (r0 != 0) goto L5a
        L58:
            r0 = 1
            r8 = r0
        L5a:
            r0 = r8
            if (r0 == 0) goto L81
            r0 = r5
            r0.p()
            com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate$Companion r0 = com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate.f19107c
            r6 = r0
            r0 = r5
            android.content.Context r0 = r0.getContext()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r6
            r1 = r7
            r2 = r5
            com.soft.blued.ui.msg_group.model.GroupApplyResp r2 = r2.g
            java.lang.String r2 = r2.getCode()
            r3 = r5
            java.lang.String r3 = r3.f
            r0.a(r1, r2, r3)
        L81:
            return
        L82:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            java.lang.String r2 = "null cannot be cast to non-null type com.soft.blued.ui.msg_group.model.GroupApplyResp.User"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate.a(com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopGroupHelpCreate popGroupHelpCreate, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupHelpCreate, "this$0");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_JOIN_LIMIT_POP_INVITE_CLICK, Intrinsics.a(popGroupHelpCreate.f, ""));
        popGroupHelpCreate.p();
        Companion companion = f19107c;
        Context context = popGroupHelpCreate.getContext();
        Intrinsics.c(context, "context");
        companion.a(context, popGroupHelpCreate.g.getCode(), popGroupHelpCreate.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopGroupHelpCreate popGroupHelpCreate, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupHelpCreate, "this$0");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_INVITE_TASK_DOING_POP_BUY_CLICK);
        PayUtils.a(popGroupHelpCreate.getContext(), 0, "groups_task_doing", 34, VipProtos.FromType.UNKNOWN_FROM);
    }

    private final PopGroupHelpCreateBinding getVb() {
        return (PopGroupHelpCreateBinding) this.i.b(this, d[0]);
    }

    public void b() {
        int i;
        List<GroupApplyResp.User> users;
        super.b();
        int number = this.g.getNumber();
        int i2 = 0;
        while (i2 < number) {
            i2++;
            this.j.add(new GroupApplyResp.User());
        }
        List<GroupApplyResp.User> users2 = this.g.getUsers();
        if (!(users2 == null || users2.isEmpty()) && (users = this.g.getUsers()) != null) {
            int size = users.size();
            int size2 = users.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = size;
                if (i4 >= size2) {
                    break;
                }
                this.j.set(i4, users.get(i4));
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        GroupHelpAdapter groupHelpAdapter = new GroupHelpAdapter(this.h);
        groupHelpAdapter.setNewData(this.j);
        groupHelpAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpCreate$cOdojjlbRcYVuxK9hBUoHdnolWk
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i5) {
                PopGroupHelpCreate.a(PopGroupHelpCreate.this, baseQuickAdapter, view, i5);
            }
        });
        PopGroupHelpCreateBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.e.setLayoutManager(new GridLayoutManager(getContext(), 3));
        vb.e.setAdapter(groupHelpAdapter);
        vb.f15837a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpCreate$8HKncEmRtXCfjPRCEkNTRgSojGA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupHelpCreate.a(PopGroupHelpCreate.this, view);
            }
        });
        vb.f15838c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpCreate$d4MXtFMpg-aS5WVlLNnGHyd1AOk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupHelpCreate.b(PopGroupHelpCreate.this, view);
            }
        });
        vb.b.setText(getContext().getString(R.string.group_help_progress) + (char) 65288 + i + '/' + this.g.getNumber() + (char) 65289);
        if (this.e == 1) {
            vb.d.setVisibility(8);
            return;
        }
        vb.d.setText(AppUtils.a(this.e == 2 ? 2131888277 : 2131888276));
        vb.d.setVisibility(0);
        vb.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpCreate$0iJHnT3srBaoDzy1IHz9IWLI2GA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupHelpCreate.c(PopGroupHelpCreate.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_help_create;
    }
}
