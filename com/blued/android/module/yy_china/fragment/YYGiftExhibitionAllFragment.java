package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.GiftExhibitionAdapter;
import com.blued.android.module.yy_china.databinding.GiftExhibitionPageAllBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftWallInfoModel;
import com.blued.android.module.yy_china.model.YYGoodsWallListMode;
import com.blued.android.module.yy_china.model.YYGoodsWallMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftExhibitionAllFragment.class */
public final class YYGiftExhibitionAllFragment extends BaseLazyFragment {

    /* renamed from: a  reason: collision with root package name */
    private String f17249a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f17250c;
    private GiftExhibitionPageAllBinding d;
    private GiftExhibitionAdapter e;
    private YYUserInfo f;

    public YYGiftExhibitionAllFragment(String str, String str2, String str3) {
        this.f17249a = str;
        this.b = str2;
        this.f17250c = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding = this.d;
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding2 = giftExhibitionPageAllBinding;
        if (giftExhibitionPageAllBinding == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding2 = null;
        }
        giftExhibitionPageAllBinding2.f16555a.setVisibility(z ? 0 : 8);
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding3 = this.d;
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding4 = giftExhibitionPageAllBinding3;
        if (giftExhibitionPageAllBinding3 == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding4 = null;
        }
        giftExhibitionPageAllBinding4.f16556c.setVisibility(z ? 0 : 8);
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding5 = this.d;
        if (giftExhibitionPageAllBinding5 == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding5 = null;
        }
        RecyclerView recyclerView = giftExhibitionPageAllBinding5.b;
        int i = 0;
        if (z) {
            i = 8;
        }
        recyclerView.setVisibility(i);
    }

    private final void e() {
        GiftExhibitionAdapter giftExhibitionAdapter;
        Context context = getContext();
        if (context == null) {
            giftExhibitionAdapter = null;
        } else {
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            giftExhibitionAdapter = new GiftExhibitionAdapter(context, 0, fragmentActive);
        }
        Intrinsics.a(giftExhibitionAdapter);
        this.e = giftExhibitionAdapter;
        GiftExhibitionAdapter giftExhibitionAdapter2 = giftExhibitionAdapter;
        if (giftExhibitionAdapter == null) {
            Intrinsics.c("adapter");
            giftExhibitionAdapter2 = null;
        }
        giftExhibitionAdapter2.a(new YYGiftExhibitionAllFragment$initView$2(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.fragment.YYGiftExhibitionAllFragment$initView$3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                GiftExhibitionAdapter giftExhibitionAdapter3;
                giftExhibitionAdapter3 = YYGiftExhibitionAllFragment.this.e;
                GiftExhibitionAdapter giftExhibitionAdapter4 = giftExhibitionAdapter3;
                if (giftExhibitionAdapter3 == null) {
                    Intrinsics.c("adapter");
                    giftExhibitionAdapter4 = null;
                }
                int type = ((GiftWallInfoModel) giftExhibitionAdapter4.getData().get(i)).getType();
                int i2 = 4;
                if (type != 0) {
                    if (type != 1) {
                        i2 = 4;
                        if (type != 2) {
                            if (type != 3) {
                                return 4;
                            }
                        }
                    }
                    i2 = 1;
                }
                return i2;
            }
        });
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding = this.d;
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding2 = giftExhibitionPageAllBinding;
        if (giftExhibitionPageAllBinding == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding2 = null;
        }
        RecyclerView recyclerView = giftExhibitionPageAllBinding2.b;
        GiftExhibitionAdapter giftExhibitionAdapter3 = this.e;
        GiftExhibitionAdapter giftExhibitionAdapter4 = giftExhibitionAdapter3;
        if (giftExhibitionAdapter3 == null) {
            Intrinsics.c("adapter");
            giftExhibitionAdapter4 = null;
        }
        recyclerView.setAdapter(giftExhibitionAdapter4);
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding3 = this.d;
        if (giftExhibitionPageAllBinding3 == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding3 = null;
        }
        giftExhibitionPageAllBinding3.b.setLayoutManager(gridLayoutManager);
    }

    private final void f() {
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding = this.d;
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding2 = giftExhibitionPageAllBinding;
        if (giftExhibitionPageAllBinding == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding2 = null;
        }
        giftExhibitionPageAllBinding2.f16555a.setImageResource(R.drawable.icon_gift_exhibition_empty_all);
        GiftExhibitionPageAllBinding giftExhibitionPageAllBinding3 = this.d;
        if (giftExhibitionPageAllBinding3 == null) {
            Intrinsics.c("bind");
            giftExhibitionPageAllBinding3 = null;
        }
        giftExhibitionPageAllBinding3.f16556c.setText("暂未收到钻石");
    }

    private final void g() {
        String str = this.f17249a;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.w(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYGoodsWallListMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYGiftExhibitionAllFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGoodsWallListMode> result) {
                YYUserInfo yYUserInfo;
                YYUserInfo yYUserInfo2;
                YYUserInfo yYUserInfo3;
                YYUserInfo yYUserInfo4;
                GiftExhibitionAdapter giftExhibitionAdapter;
                ArrayList<YYGoodsWallMode> no_lights;
                ArrayList<YYGoodsWallMode> lights;
                GiftExhibitionAdapter giftExhibitionAdapter2;
                Intrinsics.e(result, "result");
                if (!result.hasData()) {
                    giftExhibitionAdapter2 = YYGiftExhibitionAllFragment.this.e;
                    GiftExhibitionAdapter giftExhibitionAdapter3 = giftExhibitionAdapter2;
                    if (giftExhibitionAdapter3 == null) {
                        Intrinsics.c("adapter");
                        giftExhibitionAdapter3 = null;
                    }
                    if (giftExhibitionAdapter3.getData().isEmpty()) {
                        YYGiftExhibitionAllFragment.this.a(true);
                        return;
                    }
                    return;
                }
                YYGiftExhibitionAllFragment.this.a(false);
                YYGoodsWallListMode singleData = result.getSingleData();
                if (singleData == null) {
                    return;
                }
                YYGiftExhibitionAllFragment yYGiftExhibitionAllFragment = YYGiftExhibitionAllFragment.this;
                ArrayList arrayList = new ArrayList();
                GiftWallInfoModel giftWallInfoModel = new GiftWallInfoModel();
                giftWallInfoModel.setType(0);
                yYGiftExhibitionAllFragment.f = new YYUserInfo();
                yYUserInfo = yYGiftExhibitionAllFragment.f;
                YYUserInfo yYUserInfo5 = yYUserInfo;
                if (yYUserInfo == null) {
                    Intrinsics.c("user");
                    yYUserInfo5 = null;
                }
                yYUserInfo5.setUid(yYGiftExhibitionAllFragment.b());
                yYUserInfo2 = yYGiftExhibitionAllFragment.f;
                YYUserInfo yYUserInfo6 = yYUserInfo2;
                if (yYUserInfo2 == null) {
                    Intrinsics.c("user");
                    yYUserInfo6 = null;
                }
                yYUserInfo6.setName(yYGiftExhibitionAllFragment.c());
                yYUserInfo3 = yYGiftExhibitionAllFragment.f;
                YYUserInfo yYUserInfo7 = yYUserInfo3;
                if (yYUserInfo3 == null) {
                    Intrinsics.c("user");
                    yYUserInfo7 = null;
                }
                yYUserInfo7.setAvatar(yYGiftExhibitionAllFragment.d());
                yYUserInfo4 = yYGiftExhibitionAllFragment.f;
                YYUserInfo yYUserInfo8 = yYUserInfo4;
                if (yYUserInfo4 == null) {
                    Intrinsics.c("user");
                    yYUserInfo8 = null;
                }
                giftWallInfoModel.setUs(yYUserInfo8);
                giftWallInfoModel.setGiftWallModel(singleData);
                arrayList.add(giftWallInfoModel);
                YYGoodsWallListMode.Goods_wallMode goods_wall = singleData.getGoods_wall();
                if (goods_wall != null && (lights = goods_wall.getLights()) != null) {
                    if (lights.size() > 0) {
                        GiftWallInfoModel giftWallInfoModel2 = new GiftWallInfoModel();
                        giftWallInfoModel2.setType(2);
                        giftWallInfoModel2.setTitleName("已点亮");
                        giftWallInfoModel2.setSubTitleName("累计已点亮" + lights.size() + "个礼物");
                        arrayList.add(giftWallInfoModel2);
                    }
                    for (YYGoodsWallMode yYGoodsWallMode : lights) {
                        GiftWallInfoModel giftWallInfoModel3 = new GiftWallInfoModel();
                        giftWallInfoModel3.setType(1);
                        giftWallInfoModel3.setGoodItem(yYGoodsWallMode);
                        arrayList.add(giftWallInfoModel3);
                    }
                }
                YYGoodsWallListMode.Goods_wallMode goods_wall2 = singleData.getGoods_wall();
                if (goods_wall2 != null && (no_lights = goods_wall2.getNo_lights()) != null) {
                    if (no_lights.size() > 0) {
                        GiftWallInfoModel giftWallInfoModel4 = new GiftWallInfoModel();
                        giftWallInfoModel4.setType(2);
                        giftWallInfoModel4.setTitleName("未点亮");
                        arrayList.add(giftWallInfoModel4);
                    }
                    for (YYGoodsWallMode yYGoodsWallMode2 : no_lights) {
                        GiftWallInfoModel giftWallInfoModel5 = new GiftWallInfoModel();
                        giftWallInfoModel5.setType(3);
                        giftWallInfoModel5.setGoodItem(yYGoodsWallMode2);
                        arrayList.add(giftWallInfoModel5);
                    }
                }
                giftExhibitionAdapter = yYGiftExhibitionAllFragment.e;
                GiftExhibitionAdapter giftExhibitionAdapter4 = giftExhibitionAdapter;
                if (giftExhibitionAdapter4 == null) {
                    Intrinsics.c("adapter");
                    giftExhibitionAdapter4 = null;
                }
                giftExhibitionAdapter4.setNewData(arrayList);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                GiftExhibitionAdapter giftExhibitionAdapter;
                super.onUIFinish(z);
                giftExhibitionAdapter = YYGiftExhibitionAllFragment.this.e;
                GiftExhibitionAdapter giftExhibitionAdapter2 = giftExhibitionAdapter;
                if (giftExhibitionAdapter == null) {
                    Intrinsics.c("adapter");
                    giftExhibitionAdapter2 = null;
                }
                if (giftExhibitionAdapter2.getData().isEmpty()) {
                    YYGiftExhibitionAllFragment.this.a(true);
                }
            }
        }, (IRequestHost) getFragmentActive());
    }

    public final String b() {
        return this.f17249a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.f17250c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gift_exhibition_page_all, (ViewGroup) null);
        GiftExhibitionPageAllBinding a2 = GiftExhibitionPageAllBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.d = a2;
        e();
        f();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return inflate;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_EXHIBITION_PAGE_SHOW, b.room_id, b.uid);
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g();
    }
}
