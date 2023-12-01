package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.module.yy_china.databinding.ViewYySubscriptionLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSubscriptionView.class */
public final class YYSubscriptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public BaseYYStudioFragment f18508a;
    private ViewYySubscriptionLayoutBinding b;

    /* renamed from: c  reason: collision with root package name */
    private YYRoomModel f18509c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSubscriptionView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSubscriptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSubscriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYySubscriptionLayoutBinding a2 = ViewYySubscriptionLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.b = a2;
        a();
    }

    private final void a() {
        this.b.f16962a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYSubscriptionView$bak6NzKbgVFBSj5BK1By7rONW84
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSubscriptionView.a(YYSubscriptionView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSubscriptionView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f18509c == null || this$0.getFragment() == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_CLICK;
        YYRoomModel yYRoomModel = this$0.f18509c;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.f18509c;
        EventTrackYY.d(event, str, yYRoomModel2 == null ? null : yYRoomModel2.uid);
        YYRoomInfoManager e = YYRoomInfoManager.e();
        Context context = this$0.getContext();
        YYRoomModel yYRoomModel3 = this$0.f18509c;
        String str2 = yYRoomModel3 == null ? null : yYRoomModel3.uid;
        YYRoomModel yYRoomModel4 = this$0.f18509c;
        e.b(context, str2, yYRoomModel4 == null ? null : yYRoomModel4.name, this$0.getFragment().getFragmentActive());
        this$0.getFragment().y();
    }

    public final void a(BaseYYStudioFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        setFragment(fragment);
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.f18509c = b;
        if (b != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_SHOW;
            YYRoomModel yYRoomModel = this.f18509c;
            String str = null;
            String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
            YYRoomModel yYRoomModel2 = this.f18509c;
            if (yYRoomModel2 != null) {
                str = yYRoomModel2.uid;
            }
            EventTrackYY.d(event, str2, str);
        }
    }

    public final ViewYySubscriptionLayoutBinding getBinding() {
        return this.b;
    }

    public final BaseYYStudioFragment getFragment() {
        BaseYYStudioFragment baseYYStudioFragment = this.f18508a;
        if (baseYYStudioFragment != null) {
            return baseYYStudioFragment;
        }
        Intrinsics.c("fragment");
        return null;
    }

    public final YYRoomModel getRoomModel() {
        return this.f18509c;
    }

    public final void setBinding(ViewYySubscriptionLayoutBinding viewYySubscriptionLayoutBinding) {
        Intrinsics.e(viewYySubscriptionLayoutBinding, "<set-?>");
        this.b = viewYySubscriptionLayoutBinding;
    }

    public final void setFragment(BaseYYStudioFragment baseYYStudioFragment) {
        Intrinsics.e(baseYYStudioFragment, "<set-?>");
        this.f18508a = baseYYStudioFragment;
    }

    public final void setRoomModel(YYRoomModel yYRoomModel) {
        this.f18509c = yYRoomModel;
    }
}
