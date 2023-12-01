package com.blued.community.ui.circle.dialog;

import android.content.Context;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.community.R;
import com.blued.community.databinding.DialogCircleViewBinding;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/dialog/CircleViewDialog.class */
public final class CircleViewDialog extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {Reflection.a(new PropertyReference1Impl(CircleViewDialog.class, "vb", "getVb()Lcom/blued/community/databinding/DialogCircleViewBinding;", 0))};
    private final BluedIngSelfFeed u;
    private final ViewBindingProperty v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleViewDialog(Context context, BluedIngSelfFeed circleData) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(circleData, "circleData");
        this.u = circleData;
        this.v = new CustomViewBindingProperty(new Function1<CircleViewDialog, DialogCircleViewBinding>() { // from class: com.blued.community.ui.circle.dialog.CircleViewDialog$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogCircleViewBinding invoke(CircleViewDialog popView) {
                Intrinsics.e(popView, "popView");
                return DialogCircleViewBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleViewDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackFeed.d(FeedProtos.Event.NOTE_DETAIL_PAGE_POP_CLOSE_CLICK, this$0.u.circle_id, this$0.u.feed_id);
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CircleViewDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CircleDetailsFragment.a(this$0.getContext(), this$0.u.circle_id, CircleConstants.CIRCLE_FROM_PAGE.NOTE_DOWN_JOIN);
        this$0.p();
    }

    private final DialogCircleViewBinding getVb() {
        return (DialogCircleViewBinding) this.v.b(this, t[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        EventTrackFeed.d(FeedProtos.Event.NOTE_DETAIL_PAGE_POP_SHOW, this.u.circle_id, this.u.feed_id);
        DialogCircleViewBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.getRoot().getLayoutParams().width = AppInfo.l;
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, this.u.cover)).b(R.drawable.circle_header_default).d(R.drawable.circle_header_default).a(6.0f).a(vb.b);
        vb.d.setText(this.u.circle_title);
        vb.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.dialog.-$$Lambda$CircleViewDialog$tl3qzaQHVQslSETIblrwwAkRgYY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleViewDialog.a(CircleViewDialog.this, view);
            }
        });
        vb.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.dialog.-$$Lambda$CircleViewDialog$lef5gf6lGJk3TWPfWdN_x-gB6cM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleViewDialog.b(CircleViewDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.dialog_circle_view;
    }
}
