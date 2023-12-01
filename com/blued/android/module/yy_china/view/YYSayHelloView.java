package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.databinding.ViewYySayHelloLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSayHelloView.class */
public final class YYSayHelloView extends ConstraintLayout {
    private ViewYySayHelloLayoutBinding a;
    private BaseYYStudioFragment b;
    private YYRoomModel c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSayHelloView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSayHelloView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSayHelloView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYySayHelloLayoutBinding a = ViewYySayHelloLayoutBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYSayHelloView$tOAdCKySSENB8cggTXqo1wPsJlc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSayHelloView.a(YYSayHelloView.this, view);
            }
        });
    }

    private final void a() {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null) {
            return;
        }
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        String k = YYRoomInfoManager.e().k();
        YYRoomModel yYRoomModel2 = this.c;
        String str2 = yYRoomModel2 == null ? null : yYRoomModel2.uid;
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<YYUserInfo>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYSayHelloView$sendCommunication$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYUserInfo> bluedEntityA) {
                BaseYYStudioFragment baseYYStudioFragment2;
                YYImMsgManager.a().g();
                baseYYStudioFragment2 = YYSayHelloView.this.b;
                if (baseYYStudioFragment2 == null) {
                    return;
                }
                baseYYStudioFragment2.y();
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.b;
        YYRoomHttpUtils.a(str, k, str2, 1, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) (baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSayHelloView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.c != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_BACK_INTERACT_CLICK;
            YYRoomModel yYRoomModel = this$0.c;
            String str = null;
            String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
            YYRoomModel yYRoomModel2 = this$0.c;
            if (yYRoomModel2 != null) {
                str = yYRoomModel2.uid;
            }
            EventTrackYY.d(event, str2, str);
        }
        this$0.a();
    }

    public final void a(BaseYYStudioFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.c = YYRoomInfoManager.e().b();
        this.b = fragment;
        ImageLoader.c(fragment.getFragmentActive(), "say_hello.png").f().g(-1).a(this.a.a);
    }
}
