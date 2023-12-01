package com.blued.android.module.yy_china.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.adapter.YYSeatSoloAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.TopicListDialog;
import com.blued.android.module.yy_china.view.YYConsumptionView;
import com.blued.android.module.yy_china.view.YYSetSoloGiftView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYSoloPresenter.class */
public class YYSoloPresenter extends AbstractBasePresenter {
    public YYSoloPresenter(BaseYYStudioFragment baseYYStudioFragment) {
        super(baseYYStudioFragment);
    }

    private void d(YYClickApplyEvent yYClickApplyEvent) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.S(b.room_id, new BluedUIHttpResponse<BluedEntityA<YYWishGoodsModel>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYWishGoodsModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    if (YYRoomInfoManager.e().y()) {
                        YYSoloPresenter.this.f();
                    } else {
                        ToastUtils.a(R.string.yy_not_gift);
                    }
                } else if (YYRoomInfoManager.e().y()) {
                    YYSoloPresenter.this.f17634a.u();
                } else {
                    YYSoloPresenter.this.f();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 40380002) {
                    ToastUtils.a("房间已关闭");
                    YYSoloPresenter.this.f17634a.G();
                }
                return super.onUIFailure(i, str);
            }
        }, this.f17634a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f17634a == null) {
            return;
        }
        YYSetSoloGiftView yYSetSoloGiftView = new YYSetSoloGiftView(this.f17634a.getContext());
        yYSetSoloGiftView.a(this.f17634a);
        this.f17634a.a(yYSetSoloGiftView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f17634a == null) {
            return;
        }
        YYConsumptionView yYConsumptionView = new YYConsumptionView(this.f17634a.getContext());
        yYConsumptionView.a(this.f17634a);
        this.f17634a.a(yYConsumptionView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f17634a != null) {
            this.f17634a.c(0);
        }
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    protected String b() {
        return "是否向房主发起粉丝麦位申请";
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("event_solo_friend", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null && b.soloLock) {
                    YYSoloPresenter.this.g();
                } else if (YYRoomInfoManager.e().y()) {
                    YYSoloPresenter.this.h();
                } else {
                    ToastUtils.a("该麦位为陪伴麦位，仅被邀请用户才可上麦。");
                }
            }
        });
        LiveEventBus.get("event_solo_fans", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYSoloPresenter.this.b(new YYClickApplyEvent(YYConstants.ApplyFromSource.SoloFans, "3"));
            }
        });
        LiveEventBus.get("event_solo_edit_topic", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYSoloPresenter.this.f17634a == null) {
                    return;
                }
                new TopicListDialog().show(YYSoloPresenter.this.f17634a.getChildFragmentManager(), "TopicListDialog");
            }
        });
        LiveEventBus.get("event_solo_set_gift", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYSoloPresenter.this.f17634a == null || YYSoloPresenter.this.f17634a.E == null || !(YYSoloPresenter.this.f17634a.E instanceof YYSeatSoloAdapter)) {
                    return;
                }
                ((YYSeatSoloAdapter) YYSoloPresenter.this.f17634a.E).a();
            }
        });
        LiveEventBus.get("event_solo_auto_apply", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYSoloPresenter.super.c(new YYClickApplyEvent(YYConstants.ApplyFromSource.SoloAutoApply, "3"));
            }
        });
        LiveEventBus.get("event_solo_lock", Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.blued.android.module.yy_china.presenter.YYSoloPresenter.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null && YYRoomInfoManager.e().y()) {
                    EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_ACCOMPANY_UNLOCK, b.room_id, b.uid);
                }
                if (YYSoloPresenter.this.f17634a == null || YYSoloPresenter.this.f17634a.E == null || !(YYSoloPresenter.this.f17634a.E instanceof YYSeatSoloAdapter)) {
                    return;
                }
                ((YYSeatSoloAdapter) YYSoloPresenter.this.f17634a.E).a(bool.booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(YYClickApplyEvent yYClickApplyEvent) {
        if (yYClickApplyEvent.getSource() == YYConstants.ApplyFromSource.SoloAutoApply) {
            super.b(yYClickApplyEvent);
        } else {
            d(yYClickApplyEvent);
        }
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
    }
}
