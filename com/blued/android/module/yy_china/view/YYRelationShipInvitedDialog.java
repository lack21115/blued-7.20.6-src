package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRelationshipInvitedBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomImMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipInvitedDialog.class */
public final class YYRelationShipInvitedDialog extends BaseFullScreenDialog {
    private DialogRelationshipInvitedBinding a;
    private YYRelationShipRoomImMode b;
    private final RelationShipInvitedHandler c = new RelationShipInvitedHandler(this);
    private int d = 15;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipInvitedDialog this$0, View view) {
        String day;
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RELATION_USER_INVITE_POP_DISAGREE_CLICK;
        String str = b.room_id;
        String str2 = b.uid;
        YYRelationShipRoomImMode f = this$0.f();
        String str3 = null;
        String relation_id = f == null ? null : f.getRelation_id();
        YYRelationShipRoomImMode f2 = this$0.f();
        String target_uid = f2 == null ? null : f2.getTarget_uid();
        YYRelationShipRoomImMode f3 = this$0.f();
        int parseInt = (f3 == null || (day = f3.getDay()) == null) ? 0 : Integer.parseInt(day);
        YYRelationShipRoomImMode f4 = this$0.f();
        if (f4 != null) {
            str3 = f4.getGoods_id();
        }
        YYRelationShipRoomImMode f5 = this$0.f();
        EventTrackYY.a(event, str, str2, relation_id, target_uid, parseInt, str3, f5 == null ? 0 : f5.getBeans());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final YYRelationShipInvitedDialog this$0, View view) {
        String day;
        Intrinsics.e(this$0, "this$0");
        YYRelationShipRoomImMode yYRelationShipRoomImMode = this$0.b;
        String str = null;
        String uid = yYRelationShipRoomImMode == null ? null : yYRelationShipRoomImMode.getUid();
        YYRelationShipRoomImMode yYRelationShipRoomImMode2 = this$0.b;
        String relation_id = yYRelationShipRoomImMode2 == null ? null : yYRelationShipRoomImMode2.getRelation_id();
        final ActivityFragmentActive a = this$0.a();
        YYRoomHttpUtils.s(uid, relation_id, new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.view.YYRelationShipInvitedDialog$initView$4$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYRelationShipInvitedDialog.this.dismissAllowingStateLoss();
            }
        }, this$0.a());
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RELATION_USER_INVITE_POP_AGREE_CLICK;
        String str2 = b.room_id;
        String str3 = b.uid;
        YYRelationShipRoomImMode f = this$0.f();
        String relation_id2 = f == null ? null : f.getRelation_id();
        YYRelationShipRoomImMode f2 = this$0.f();
        String target_uid = f2 == null ? null : f2.getTarget_uid();
        YYRelationShipRoomImMode f3 = this$0.f();
        int parseInt = (f3 == null || (day = f3.getDay()) == null) ? 0 : Integer.parseInt(day);
        YYRelationShipRoomImMode f4 = this$0.f();
        if (f4 != null) {
            str = f4.getGoods_id();
        }
        YYRelationShipRoomImMode f5 = this$0.f();
        EventTrackYY.a(event, str2, str3, relation_id2, target_uid, parseInt, str, f5 == null ? 0 : f5.getBeans());
    }

    private final DialogRelationshipInvitedBinding h() {
        DialogRelationshipInvitedBinding dialogRelationshipInvitedBinding = this.a;
        Intrinsics.a(dialogRelationshipInvitedBinding);
        return dialogRelationshipInvitedBinding;
    }

    private final void i() {
        String day;
        YYRelationShipRoomImMode yYRelationShipRoomImMode = this.b;
        if (yYRelationShipRoomImMode != null) {
            h().h.setText("邀请配对");
            YYRoomInfoManager.e().a(a(), (ImageView) h().e, yYRelationShipRoomImMode.getUid(), yYRelationShipRoomImMode.getUid_avatar());
            YYRoomInfoManager.e().a(a(), (ImageView) h().f, yYRelationShipRoomImMode.getTarget_uid(), yYRelationShipRoomImMode.getTarget_uid_avatar());
            ImageLoader.a(a(), yYRelationShipRoomImMode.getGoods_img()).a(h().d);
            h().g.setText(String.valueOf(yYRelationShipRoomImMode.getBeans()));
            h().i.setText(yYRelationShipRoomImMode.getUid_name() + "邀请你成为他的" + yYRelationShipRoomImMode.getDay() + "天「" + yYRelationShipRoomImMode.getRelation_name() + "」，你是否接受？接受则可收到价值" + yYRelationShipRoomImMode.getBeans() + "弯豆的该礼物");
        }
        h().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInvitedDialog$8j0OyKxnUNq4Zm_qdHRvfJ3zJEU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInvitedDialog.a(YYRelationShipInvitedDialog.this, view);
            }
        });
        h().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInvitedDialog$JMrKDcvUZngc7S7hqqHIQRuiTwE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInvitedDialog.a(view);
            }
        });
        h().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInvitedDialog$PGd5HTgLNUpGhtlQK7hjmA2hDzo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInvitedDialog.b(YYRelationShipInvitedDialog.this, view);
            }
        });
        this.c.sendEmptyMessageDelayed(1, 1000L);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RELATION_USER_INVITE_POP_SHOW;
        String str = b.room_id;
        String str2 = b.uid;
        YYRelationShipRoomImMode f = f();
        String str3 = null;
        String relation_id = f == null ? null : f.getRelation_id();
        YYRelationShipRoomImMode f2 = f();
        String target_uid = f2 == null ? null : f2.getTarget_uid();
        YYRelationShipRoomImMode f3 = f();
        int parseInt = (f3 == null || (day = f3.getDay()) == null) ? 0 : Integer.parseInt(day);
        YYRelationShipRoomImMode f4 = f();
        if (f4 != null) {
            str3 = f4.getGoods_id();
        }
        YYRelationShipRoomImMode f5 = f();
        EventTrackYY.a(event, str, str2, relation_id, target_uid, parseInt, str3, f5 == null ? 0 : f5.getBeans());
    }

    public final void a(YYRelationShipRoomImMode yYRelationShipRoomImMode) {
        this.b = yYRelationShipRoomImMode;
    }

    public final YYRelationShipRoomImMode f() {
        return this.b;
    }

    public final boolean g() {
        ShapeTextView shapeTextView = h().b;
        shapeTextView.setText("接受 " + this.d + 's');
        int i = this.d - 1;
        this.d = i;
        if (i > -1) {
            return true;
        }
        dismissAllowingStateLoss();
        return false;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogRelationshipInvitedBinding.a(inflater.inflate(R.layout.dialog_relationship_invited, viewGroup, true));
        i();
        return h().getRoot();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        RelationShipInvitedHandler relationShipInvitedHandler = this.c;
        if (relationShipInvitedHandler == null) {
            return;
        }
        relationShipInvitedHandler.removeCallbacksAndMessages(null);
    }
}
