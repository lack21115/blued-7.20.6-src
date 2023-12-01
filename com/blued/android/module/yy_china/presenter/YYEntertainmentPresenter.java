package com.blued.android.module.yy_china.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.module.yy_china.adapter.YYSeatEntertainmentAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYNoAnchorAlertDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ChatroomMIcBeansModel;
import com.blued.android.module.yy_china.model.YYMsgNoAnchorModel;
import com.blued.android.module.yy_china.view.YYEntertainmentBroadcastView;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYEntertainmentPresenter.class */
public class YYEntertainmentPresenter extends AbstractBasePresenter {
    public YYEntertainmentPresenter(BaseYYStudioFragment baseYYStudioFragment) {
        super(baseYYStudioFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.a == null) {
            return;
        }
        this.a.a(new YYEntertainmentBroadcastView(this.a.getContext()), -2);
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    protected String b() {
        return "是否向房主或者场控发起申请上麦申请";
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("show_on_beans_change", ChatroomMIcBeansModel.class).observe(lifecycleOwner, new Observer<ChatroomMIcBeansModel>() { // from class: com.blued.android.module.yy_china.presenter.YYEntertainmentPresenter.1
            /* renamed from: a */
            public void onChanged(ChatroomMIcBeansModel chatroomMIcBeansModel) {
                if (YYEntertainmentPresenter.this.a == null) {
                    return;
                }
                if (YYRoomInfoManager.e().b() != null) {
                    YYRoomInfoManager.e().b().micBeansModel = chatroomMIcBeansModel;
                }
                if (YYEntertainmentPresenter.this.a.E instanceof YYSeatEntertainmentAdapter) {
                    ((YYSeatEntertainmentAdapter) YYEntertainmentPresenter.this.a.E).a();
                }
            }
        });
        LiveEventBus.get("show_no_anchor_alert", YYMsgNoAnchorModel.class).observe(lifecycleOwner, new Observer<YYMsgNoAnchorModel>() { // from class: com.blued.android.module.yy_china.presenter.YYEntertainmentPresenter.2
            /* renamed from: a */
            public void onChanged(YYMsgNoAnchorModel yYMsgNoAnchorModel) {
                if (YYEntertainmentPresenter.this.a == null) {
                    return;
                }
                new YYNoAnchorAlertDialog(yYMsgNoAnchorModel, YYEntertainmentPresenter.this.a).show(YYEntertainmentPresenter.this.a.getParentFragmentManager(), "show_no_anchor_dialog");
            }
        });
        LiveEventBus.get("show_blind_guide", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYEntertainmentPresenter.3
            /* renamed from: a */
            public void onChanged(String str) {
                YYEntertainmentPresenter.this.f();
            }
        });
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
    }
}
