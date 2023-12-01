package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ViewKtvNoticeTypeMessBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.AbstractBasePresenter;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvNoticeTypeMess.class */
public final class YYKtvNoticeTypeMess extends BaseFullScreenDialog {
    private ViewKtvNoticeTypeMessBinding a;
    private boolean b;
    private BaseYYStudioFragment c;
    private String d = "";
    private String e = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvNoticeTypeMess this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYKtvNoticeTypeMess this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.c;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.a(true, "", this$0.d, this$0.e);
        }
        this$0.dismissAllowingStateLoss();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_GUIDE_SONG_POP_GO_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final YYKtvNoticeTypeMess this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.view.YYKtvNoticeTypeMess$initView$3$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                AbstractBasePresenter l;
                YYClickApplyEvent yYClickApplyEvent = new YYClickApplyEvent(YYConstants.ApplyFromSource.BottomView, "0");
                BaseYYStudioFragment h = YYKtvNoticeTypeMess.this.h();
                if (h != null && (l = h.l()) != null) {
                    l.c(yYClickApplyEvent);
                }
                YYKtvNoticeTypeMess.this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] perms) {
                Intrinsics.e(perms, "perms");
                AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
            }
        });
        BaseYYStudioFragment baseYYStudioFragment = this$0.c;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.y();
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_GO_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYKtvNoticeTypeMess this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.c;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.y();
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(this$0.g() ? ChatRoomProtos.Event.CHAT_ROOM_KTV_GUIDE_SONG_POP_IGNORE_CLICK : ChatRoomProtos.Event.CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_IGNORE_CLICK, b.room_id, b.uid);
    }

    private final void i() {
        if (this.b) {
            TextView textView = f().d;
            Context context = getContext();
            textView.setText(context == null ? null : context.getString(R.string.yy_ktv_notice_type_title_send_gift));
            ShapeTextView shapeTextView = f().c;
            Context context2 = getContext();
            shapeTextView.setText(context2 == null ? null : context2.getString(R.string.yy_ktv_notice_type_btn_send_gift));
            f().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvNoticeTypeMess$IMc6Bv8AiURUChJQj9KMxJVhals
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYKtvNoticeTypeMess.b(YYKtvNoticeTypeMess.this, view);
                }
            });
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_GUIDE_SONG_POP_SHOW, b.room_id, b.uid);
            }
        } else {
            TextView textView2 = f().d;
            Context context3 = getContext();
            textView2.setText(context3 == null ? null : context3.getString(R.string.yy_ktv_notice_type_title_up_mic));
            ShapeTextView shapeTextView2 = f().c;
            Context context4 = getContext();
            shapeTextView2.setText(context4 == null ? null : context4.getString(R.string.yy_ktv_notice_type_btn_up_mic));
            f().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvNoticeTypeMess$yUUI7NQ5FCFgSF5SBe35LdqeKYI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYKtvNoticeTypeMess.c(YYKtvNoticeTypeMess.this, view);
                }
            });
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_SHOW, b2.room_id, b2.uid);
            }
        }
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvNoticeTypeMess$p9gvxPl0IsacMDGWN-mQVEAxjMc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYKtvNoticeTypeMess.d(YYKtvNoticeTypeMess.this, view);
            }
        });
    }

    public final void a(boolean z, BaseYYStudioFragment fra, String goodsId, String userId) {
        Intrinsics.e(fra, "fra");
        Intrinsics.e(goodsId, "goodsId");
        Intrinsics.e(userId, "userId");
        this.b = z;
        this.c = fra;
        this.d = goodsId;
        this.e = userId;
    }

    public final ViewKtvNoticeTypeMessBinding f() {
        ViewKtvNoticeTypeMessBinding viewKtvNoticeTypeMessBinding = this.a;
        Intrinsics.a(viewKtvNoticeTypeMessBinding);
        return viewKtvNoticeTypeMessBinding;
    }

    public final boolean g() {
        return this.b;
    }

    public final BaseYYStudioFragment h() {
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = ViewKtvNoticeTypeMessBinding.a(inflater.inflate(R.layout.view_ktv_notice_type_mess, viewGroup, true));
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvNoticeTypeMess$UsaJU05_H2DM6liA4xvk3qzkZnw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYKtvNoticeTypeMess.a(YYKtvNoticeTypeMess.this, view);
            }
        });
        i();
        ViewKtvNoticeTypeMessBinding viewKtvNoticeTypeMessBinding = this.a;
        return viewKtvNoticeTypeMessBinding == null ? null : viewKtvNoticeTypeMessBinding.getRoot();
    }
}
