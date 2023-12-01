package com.blued.android.module.yy_china.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYMsgAuctionLevelExtra;
import com.blued.android.module.yy_china.model.YYMsgIntimacyExtra;
import com.blued.android.module.yy_china.model.YYMsgRelationExtra;
import com.blued.android.module.yy_china.model.YYMsgSaleFlowExtra;
import com.blued.android.module.yy_china.model.YYMsgUpdateMemberExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYSetRelationTypeModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYIntimateView;
import com.blued.android.module.yy_china.view.YYSaleBroadcastView;
import com.blued.android.module.yy_china.view.YYSetRelationshipView;
import com.blued.android.module.yy_china.view.YYSndgiftAuctionView;
import com.blued.android.module.yy_china.view.YYWishListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYSalePresenter.class */
public class YYSalePresenter extends AbstractBasePresenter {
    public YYSalePresenter(BaseYYStudioFragment baseYYStudioFragment) {
        super(baseYYStudioFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.k(b.room_id, i, new BluedUIHttpResponse<BluedEntityA<YYCPStepModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCPStepModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                }
            }
        }, this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYSndgiftAuctionView yYSndgiftAuctionView = new YYSndgiftAuctionView(this.a.getContext());
        yYSndgiftAuctionView.a(this.a, YYRoomInfoManager.e().b().room_id, str);
        this.a.a(yYSndgiftAuctionView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.a(b.room_id, str, str2, str3, i, new BluedUIHttpResponse<BluedEntityA<Object>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        YYIntimateView yYIntimateView = new YYIntimateView(this.a.getContext());
        yYIntimateView.a(this.a, str);
        this.a.a(yYIntimateView, AppInfo.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.d(b.room_id, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (b == null) {
                    return;
                }
                AudioChannelManager.j().a(str, 0);
                if (TextUtils.equals(b.uid, YYRoomInfoManager.e().k())) {
                    return;
                }
                AudioChannelManager.j().a(21);
            }
        }, (IRequestHost) this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.a == null) {
            return;
        }
        this.a.a(new YYSaleBroadcastView(this.a.getContext()), -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYSetRelationshipView yYSetRelationshipView = new YYSetRelationshipView(this.a.getContext());
        yYSetRelationshipView.a(this.a, b.room_id, new YYSetRelationshipView.SetRelationShipListener() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.13
            @Override // com.blued.android.module.yy_china.view.YYSetRelationshipView.SetRelationShipListener
            public void a(YYSetRelationTypeModel yYSetRelationTypeModel, YYSetRelationTypeModel yYSetRelationTypeModel2) {
                if (YYSalePresenter.this.a == null || YYSalePresenter.this.a.E == null) {
                    return;
                }
                if (b != null) {
                    EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_RELATION_TRUE_CLICK, b.room_id, YYRoomInfoManager.e().k(), StringUtils.a(yYSetRelationTypeModel.getContent(), 0));
                }
                YYSalePresenter.this.a("", yYSetRelationTypeModel2.getId(), yYSetRelationTypeModel.getId(), 0);
                if (YYSalePresenter.this.a.E instanceof YYSeatSaleAdapter) {
                    YYMsgRelationExtra yYMsgRelationExtra = new YYMsgRelationExtra();
                    yYMsgRelationExtra.images_static = yYSetRelationTypeModel2.getRelation_image();
                    yYMsgRelationExtra.relation_id = yYSetRelationTypeModel2.getId();
                    yYMsgRelationExtra.name = yYSetRelationTypeModel2.getContent();
                    yYMsgRelationExtra.validity = yYSetRelationTypeModel.getContent();
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgRelationExtra);
                }
                YYSalePresenter.this.a.y();
            }
        });
        this.a.a(yYSetRelationshipView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.blued.android.module.yy_china.view.YYWishListView] */
    public void h() {
        ?? yYWishListView = new YYWishListView(this.a.getContext());
        yYWishListView.a(this.a, null);
        yYWishListView.setOkListener(new YYWishListView.OnConfirmListener() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.14
            @Override // com.blued.android.module.yy_china.view.YYWishListView.OnConfirmListener
            public void a(YYGiftModel yYGiftModel, int i) {
                if (yYGiftModel == null || YYSalePresenter.this.a == null || YYSalePresenter.this.a.E == null) {
                    return;
                }
                YYSalePresenter.this.a(yYGiftModel.goods_id, "", "", 1);
                if (YYSalePresenter.this.a.E instanceof YYSeatSaleAdapter) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYGiftModel);
                }
                YYSalePresenter.this.a.y();
            }
        });
        this.a.a((View) yYWishListView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.N(b.room_id, new BluedUIHttpResponse<BluedEntityA<Object>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, this.a.getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    protected String b() {
        return "是否向拍卖员发起上麦申请";
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("show_blind_guide", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.1
            /* renamed from: a */
            public void onChanged(String str) {
                YYSalePresenter.this.f();
            }
        });
        LiveEventBus.get("event_sale_relation", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.2
            /* renamed from: a */
            public void onChanged(String str) {
                YYSalePresenter.this.g();
            }
        });
        LiveEventBus.get("event_sale_goods", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.3
            /* renamed from: a */
            public void onChanged(String str) {
                YYSalePresenter.this.h();
            }
        });
        LiveEventBus.get("event_exit_room", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.4
            /* renamed from: a */
            public void onChanged(String str) {
                YYSalePresenter.this.c(YYRoomInfoManager.e().k());
            }
        });
        LiveEventBus.get("event_join_sale", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.5
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYRoomInfoManager.e().A() && !YYRoomInfoManager.e().i()) {
                    ToastUtils.a("竞拍麦位已满，暂无法上麦", 0);
                } else if (YYRoomInfoManager.e().i()) {
                    YYSalePresenter.this.a.a(true, "", "", str);
                } else {
                    YYSalePresenter.this.a(str);
                }
            }
        });
        LiveEventBus.get("event_sale_flow", Integer.class).observe(lifecycleOwner, new Observer<Integer>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.6
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (YYSalePresenter.this.a == null || YYSalePresenter.this.a.E == null) {
                    return;
                }
                YYSalePresenter.this.a(num.intValue());
            }
        });
        LiveEventBus.get("event_im_change_flow", YYMsgSaleFlowExtra.class).observe(lifecycleOwner, new Observer<YYMsgSaleFlowExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.7
            /* renamed from: a */
            public void onChanged(YYMsgSaleFlowExtra yYMsgSaleFlowExtra) {
                if (YYSalePresenter.this.a == null || YYSalePresenter.this.a.E == null || yYMsgSaleFlowExtra == null || !(YYSalePresenter.this.a.E instanceof YYSeatSaleAdapter)) {
                    return;
                }
                ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgSaleFlowExtra.step);
                if (yYMsgSaleFlowExtra.hasGoods()) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgSaleFlowExtra.goods);
                }
                if (yYMsgSaleFlowExtra.hasRelation()) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgSaleFlowExtra.relation);
                }
                int i = yYMsgSaleFlowExtra.step;
                if (i == 1) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgSaleFlowExtra.hasGoods(), yYMsgSaleFlowExtra.hasRelation());
                } else if (i == 2) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).b();
                } else if (i == 3) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).c(yYMsgSaleFlowExtra.stage_list);
                } else {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a();
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b != null) {
                        YYSalePresenter.this.a.E.setNewData(b.mics);
                    }
                }
            }
        });
        LiveEventBus.get("event_im_relation_progress", YYMsgIntimacyExtra.class).observe(lifecycleOwner, new Observer<YYMsgIntimacyExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.8
            /* renamed from: a */
            public void onChanged(YYMsgIntimacyExtra yYMsgIntimacyExtra) {
                if (YYSalePresenter.this.a == null || YYSalePresenter.this.a.E == null || !(YYSalePresenter.this.a.E instanceof YYSeatSaleAdapter)) {
                    return;
                }
                ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).b(yYMsgIntimacyExtra.current_value);
            }
        });
        LiveEventBus.get("event_game_member_status", YYMsgUpdateMemberExtra.class).observe(lifecycleOwner, new Observer<YYMsgUpdateMemberExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.9
            /* renamed from: a */
            public void onChanged(YYMsgUpdateMemberExtra yYMsgUpdateMemberExtra) {
                List<YYSeatMemberModel> list;
                if (yYMsgUpdateMemberExtra == null || (list = yYMsgUpdateMemberExtra.seats) == null) {
                    return;
                }
                for (YYSeatMemberModel yYSeatMemberModel : list) {
                    if (yYSeatMemberModel != null) {
                        YYSalePresenter.this.a.E.a(yYSeatMemberModel);
                    }
                }
            }
        });
        LiveEventBus.get("event_auction_level", YYMsgAuctionLevelExtra.class).observe(lifecycleOwner, new Observer<YYMsgAuctionLevelExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.10
            /* renamed from: a */
            public void onChanged(YYMsgAuctionLevelExtra yYMsgAuctionLevelExtra) {
                if (yYMsgAuctionLevelExtra != null && (YYSalePresenter.this.a.E instanceof YYSeatSaleAdapter)) {
                    ((YYSeatSaleAdapter) YYSalePresenter.this.a.E).a(yYMsgAuctionLevelExtra.level_img);
                }
            }
        });
        LiveEventBus.get("event_confirm_mic", YYAudienceModel.class).observe(lifecycleOwner, new Observer<YYAudienceModel>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.11
            /* renamed from: a */
            public void onChanged(YYAudienceModel yYAudienceModel) {
                if (yYAudienceModel == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k()) || YYRoomInfoManager.e().c().a(YYSalePresenter.this.a.getContext(), (View.OnClickListener) null)) {
                    return;
                }
                PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.11.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        YYSalePresenter.this.i();
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                    }
                });
            }
        });
        LiveEventBus.get("event_intimate_animation", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.YYSalePresenter.12
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                YYSalePresenter.this.b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(YYClickApplyEvent yYClickApplyEvent) {
        if (YYRoomInfoManager.e().i()) {
            ToastUtils.a("你已在麦上", 0);
        } else if (YYRoomInfoManager.e().c().a(this.a.getContext(), (View.OnClickListener) null)) {
        } else {
            super.b(yYClickApplyEvent);
        }
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
    }
}
