package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.mcssdk.constant.IntentConstant;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupHelpDetailBinding;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.model.GroupCommandDetailResp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupHelpDetail.class */
public final class PopGroupHelpDetail extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19108c = {(KProperty) Reflection.a(new PropertyReference1Impl(PopGroupHelpDetail.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupHelpDetailBinding;", 0))};
    private final String d;
    private final GroupCommandDetailResp e;
    private final ViewBindingProperty f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopGroupHelpDetail(Context context, String str, GroupCommandDetailResp groupCommandDetailResp) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, IntentConstant.COMMAND);
        Intrinsics.e(groupCommandDetailResp, "resp");
        this.d = str;
        this.e = groupCommandDetailResp;
        BasePopupView basePopupView = (BasePopupView) this;
        this.f = new CustomViewBindingProperty(new Function1<PopGroupHelpDetail, PopGroupHelpDetailBinding>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupHelpDetail$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupHelpDetailBinding invoke(PopGroupHelpDetail popGroupHelpDetail) {
                Intrinsics.e(popGroupHelpDetail, "popView");
                return PopGroupHelpDetailBinding.a(popGroupHelpDetail.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupHelpDetail popGroupHelpDetail, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupHelpDetail, "this$0");
        popGroupHelpDetail.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopGroupHelpDetail popGroupHelpDetail, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupHelpDetail, "this$0");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PASSWORD_SUPPORT_CLICK, popGroupHelpDetail.d);
        popGroupHelpDetail.p();
        popGroupHelpDetail.c();
    }

    private final void c() {
        MineHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<?>>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupHelpDetail$sendHelpRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((IRequestHost) null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<?> bluedEntityA) {
            }

            public boolean onUIFailure(int i, String str) {
                EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PASSWORD_SUPPORT_FAIL, PopGroupHelpDetail.this.getCommand());
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                PopGroupHelpDetail.this.p();
                if (z) {
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PASSWORD_SUPPORT_SUCCESS, PopGroupHelpDetail.this.getCommand());
                    ToastUtils.a(PopGroupHelpDetail.this.getContext().getString(R.string.group_help_toast_succeed));
                }
            }
        }, this.d);
    }

    private final PopGroupHelpDetailBinding getVb() {
        return (PopGroupHelpDetailBinding) this.f.b(this, f19108c[0]);
    }

    public void b() {
        super.b();
        PopGroupHelpDetailBinding vb = getVb();
        if (vb == null) {
            return;
        }
        ShapeTextView shapeTextView = vb.d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getContext().getString(R.string.group_help_detail_title);
        Intrinsics.c(string, "context.getString(R.stri….group_help_detail_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getResp().getName()}, 1));
        Intrinsics.c(format, "format(format, *args)");
        shapeTextView.setText(format);
        ImageLoader.a((IRequestHost) null, getResp().getAvatar()).c().a(vb.b);
        vb.f15839a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpDetail$Gy6pD1un1f4BQbqTfEny8wO4imM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupHelpDetail.a(PopGroupHelpDetail.this, view);
            }
        });
        vb.f15840c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupHelpDetail$_GktNGCb8xx1Dh1yiQ1RRptqnpY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupHelpDetail.b(PopGroupHelpDetail.this, view);
            }
        });
    }

    public final String getCommand() {
        return this.d;
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_help_detail;
    }

    public final GroupCommandDetailResp getResp() {
        return this.e;
    }
}
