package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewAdInGiftListBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftActivityModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYAdInGiftListView.class */
public final class YYAdInGiftListView extends ConstraintLayout {
    private final ViewAdInGiftListBinding a;
    private YYGiftActivityModel b;
    private YYRoomModel c;
    private ClickAdvertisementListener d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYAdInGiftListView$ClickAdvertisementListener.class */
    public interface ClickAdvertisementListener {
        void a();

        void a(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYAdInGiftListView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYAdInGiftListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYAdInGiftListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewAdInGiftListBinding a = ViewAdInGiftListBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYAdInGiftListView$_K90F7EhyDAEUuXjLVdDc4DQbZY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYAdInGiftListView.a(view);
            }
        });
        this.a.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYAdInGiftListView$FuSH_bGgPa6GLLuq3gbmV31SKXk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYAdInGiftListView.a(YYAdInGiftListView.this, view);
            }
        });
    }

    private final void a() {
        YYRoomModel b;
        YYRoomModel b2;
        int i = 0;
        setVisibility(0);
        YYGiftActivityModel yYGiftActivityModel = this.b;
        if (yYGiftActivityModel == null) {
            this.a.b.setVisibility(8);
            b();
        } else if (yYGiftActivityModel == null) {
        } else {
            b();
            if (TextUtils.isEmpty(yYGiftActivityModel.activity_title) && TextUtils.isEmpty(yYGiftActivityModel.activity_image)) {
                this.a.b.setVisibility(8);
                b();
                return;
            }
            if (yYGiftActivityModel.type == 2 && (b2 = YYRoomInfoManager.e().b()) != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_MADE_CAR_GO_SHOW, b2.room_id, b2.uid);
            }
            if (yYGiftActivityModel.type == 4 && (b = YYRoomInfoManager.e().b()) != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_LOVE_GIFT_BAR_SHOW, b.room_id, b.uid);
            }
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(8);
            ShapeTextView shapeTextView = this.a.d;
            if (TextUtils.isEmpty(yYGiftActivityModel.activity_title)) {
                i = 8;
            }
            shapeTextView.setVisibility(i);
            this.a.d.setText(yYGiftActivityModel.activity_title);
            ImageLoader.a((IRequestHost) null, yYGiftActivityModel.activity_image).b(R.drawable.shape_card_6_1b1b1b).a(this.a.a);
            String str = yYGiftActivityModel.activity_url;
            Intrinsics.c(str, "it.activity_url");
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("frist_rechage").post("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYAdInGiftListView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ClickAdvertisementListener clickAdvertisementListener = this$0.d;
        if (clickAdvertisementListener == null) {
            return;
        }
        YYGiftActivityModel yYGiftActivityModel = this$0.b;
        clickAdvertisementListener.a(this$0.b(yYGiftActivityModel == null ? null : yYGiftActivityModel.activity_url));
    }

    private final void a(String str) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null) {
            return;
        }
        EventTrackYY.p(ChatRoomProtos.Event.CHAT_ROOM_GIFT_ACTIVITY_SHOW, yYRoomModel.room_id, yYRoomModel.uid, b(str));
    }

    private final String b(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.clearQuery();
            YYRoomModel yYRoomModel = this.c;
            buildUpon.appendQueryParameter("room_id", yYRoomModel == null ? null : yYRoomModel.room_id);
            buildUpon.appendQueryParameter("uid", EncryptTool.b(YYRoomInfoManager.e().k()));
            str2 = buildUpon.toString();
        }
        return str2;
    }

    private final void b() {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null) {
            return;
        }
        if (yYRoomModel.yyPerFirstGiftModel == null || yYRoomModel.yyPerFirstGiftModel.getType() != 1) {
            this.a.c.setVisibility(8);
            return;
        }
        this.a.c.setVisibility(0);
        ClickAdvertisementListener clickAdvertisementListener = this.d;
        if (clickAdvertisementListener == null) {
            return;
        }
        clickAdvertisementListener.a();
    }

    public final void a(YYGiftActivityModel yYGiftActivityModel, ClickAdvertisementListener clickAdvertisementListener) {
        this.b = yYGiftActivityModel;
        this.c = YYRoomInfoManager.e().b();
        this.d = clickAdvertisementListener;
        a();
    }
}
