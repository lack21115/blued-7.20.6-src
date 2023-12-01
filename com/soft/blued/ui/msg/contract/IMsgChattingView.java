package com.soft.blued.ui.msg.contract;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.ui.msg.adapter.MessageChatAdapter;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IMsgChattingView.class */
public interface IMsgChattingView {
    void D();

    void E();

    void F();

    String G();

    void H();

    void K();

    void L();

    IRequestHost M();

    void a(int i);

    void a(int i, long j);

    void a(int i, String str);

    void a(int i, String str, String str2);

    void a(int i, boolean z);

    void a(SessionModel sessionModel);

    void a(BluedIngSelfFeed bluedIngSelfFeed);

    void a(FeedPostSignStateItem feedPostSignStateItem);

    void a(UserInfoBasicModel userInfoBasicModel);

    void a(FuGiftListEvent fuGiftListEvent);

    void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse);

    void a(List<ServiceMenuModel> list);

    void b(int i);

    void b(List<ChattingModel> list);

    void b(boolean z);

    void c(int i);

    void c(List<HelloExpressionData> list);

    void d();

    void d(int i);

    void e(int i);

    void f();

    void g();

    Activity getActivity();

    Bundle getArguments();

    Context getContext();

    void h();

    void i();

    void j();

    void l();

    boolean postDelaySafeRunOnUiThread(Runnable runnable, long j);

    boolean postSafeRunOnUiThread(Runnable runnable);

    BaseFragment v();

    MessageChatAdapter z();
}
