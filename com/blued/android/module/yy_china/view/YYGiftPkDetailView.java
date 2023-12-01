package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPkDetailsModel;
import com.blued.android.module.yy_china.model.YYPkGoodItemModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.view.YYGiftPkCountView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftPkDetailView.class */
public class YYGiftPkDetailView extends LinearLayout {
    private YYGiftPkCountView a;
    private YYGiftPkCountView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private BaseYYStudioFragment g;
    private String h;
    private Observer<String> i;

    public YYGiftPkDetailView(Context context) {
        super(context);
        this.i = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    YYGiftPkDetailView.this.e.setText("00:00");
                    YYGiftPkDetailView.this.setVisibility(8);
                    if (YYGiftPkDetailView.this.g != null) {
                        YYGiftPkDetailView.this.g.n();
                        return;
                    }
                    return;
                }
                if (YYGiftPkDetailView.this.getVisibility() != 0) {
                    YYGiftPkDetailView.this.setVisibility(0);
                }
                TextView textView = YYGiftPkDetailView.this.e;
                textView.setText("距离PK结束还有" + str);
            }
        };
        a();
    }

    public YYGiftPkDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    YYGiftPkDetailView.this.e.setText("00:00");
                    YYGiftPkDetailView.this.setVisibility(8);
                    if (YYGiftPkDetailView.this.g != null) {
                        YYGiftPkDetailView.this.g.n();
                        return;
                    }
                    return;
                }
                if (YYGiftPkDetailView.this.getVisibility() != 0) {
                    YYGiftPkDetailView.this.setVisibility(0);
                }
                TextView textView = YYGiftPkDetailView.this.e;
                textView.setText("距离PK结束还有" + str);
            }
        };
        a();
    }

    public YYGiftPkDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    YYGiftPkDetailView.this.e.setText("00:00");
                    YYGiftPkDetailView.this.setVisibility(8);
                    if (YYGiftPkDetailView.this.g != null) {
                        YYGiftPkDetailView.this.g.n();
                        return;
                    }
                    return;
                }
                if (YYGiftPkDetailView.this.getVisibility() != 0) {
                    YYGiftPkDetailView.this.setVisibility(0);
                }
                TextView textView = YYGiftPkDetailView.this.e;
                textView.setText("距离PK结束还有" + str);
            }
        };
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_gift_pk_detail, (ViewGroup) this, true);
        this.a = (YYGiftPkCountView) findViewById(R.id.gift_left);
        this.b = (YYGiftPkCountView) findViewById(R.id.gift_right);
        this.e = (TextView) findViewById(R.id.tv_pk_time);
        this.c = (TextView) findViewById(R.id.tv_pk_user);
        this.d = (ImageView) findViewById(R.id.iv_pk_user);
        this.f = (TextView) findViewById(R.id.tv_stop_pk);
        this.a.setChartColor(R.color.syc_00E0AB);
        this.b.setChartColor(R.color.syc_3883FD);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYGiftPkDetailView.this.b();
            }
        });
        this.a.setSendGiftClickListener(new YYGiftPkCountView.SendGiftClickListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.3
            @Override // com.blued.android.module.yy_china.view.YYGiftPkCountView.SendGiftClickListener
            public void a(String str) {
                YYGiftPkDetailView.this.a(str);
            }
        });
        this.b.setSendGiftClickListener(new YYGiftPkCountView.SendGiftClickListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.4
            @Override // com.blued.android.module.yy_china.view.YYGiftPkCountView.SendGiftClickListener
            public void a(String str) {
                YYGiftPkDetailView.this.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.equals(this.h, YYRoomInfoManager.e().k())) {
            ToastUtils.a("暂无法给自己投票");
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.g;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.a(true, "giftPK_vote", str, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.A(b.room_id, new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (YYGiftPkDetailView.this.g != null) {
                    YYGiftPkDetailView.this.g.y();
                }
            }
        }, this.g.getFragmentActive());
    }

    private void getPkInformation() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.j(b.room_id, 0, new BluedUIHttpResponse<BluedEntityA<YYPkDetailsModel>>(this.g.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGiftPkDetailView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPkDetailsModel> bluedEntityA) {
                int i;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYPkDetailsModel singleData = bluedEntityA.getSingleData();
                YYUserInfo yYUserInfo = singleData.user;
                if (yYUserInfo != null) {
                    YYGiftPkDetailView.this.h = yYUserInfo.getUid();
                    YYGiftPkDetailView.this.c.setText(yYUserInfo.getName());
                    ImageLoader.a(YYGiftPkDetailView.this.g.getFragmentActive(), yYUserInfo.getAvatar()).a(YYGiftPkDetailView.this.d);
                }
                List<YYPkGoodItemModel> list = singleData.event;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < list.size()) {
                    YYPkGoodItemModel yYPkGoodItemModel = list.get(i2);
                    if (i2 == 0) {
                        YYGiftPkDetailView.this.a.setPkGiftImage(yYPkGoodItemModel.image);
                        YYGiftPkDetailView.this.a.setGiftId(yYPkGoodItemModel.goods_id);
                        YYGiftPkDetailView.this.a.setRewardName(yYPkGoodItemModel.event_name);
                        YYGiftPkDetailView.this.a.setReceivedGiftCount(yYPkGoodItemModel.vote_count + "票");
                        i = StringUtils.a(yYPkGoodItemModel.vote_count, 0);
                    } else {
                        i = i3;
                        if (i2 == 1) {
                            YYGiftPkDetailView.this.b.setPkGiftImage(yYPkGoodItemModel.image);
                            YYGiftPkDetailView.this.b.setGiftId(yYPkGoodItemModel.goods_id);
                            YYGiftPkDetailView.this.b.setRewardName(yYPkGoodItemModel.event_name);
                            YYGiftPkDetailView.this.b.setReceivedGiftCount(yYPkGoodItemModel.vote_count + "票");
                            i4 = StringUtils.a(yYPkGoodItemModel.vote_count, 0);
                            i = i3;
                        }
                    }
                    i2++;
                    i3 = i;
                }
                if (i3 > i4) {
                    YYGiftPkDetailView.this.a.setChartRange(1.0f);
                    YYGiftPkDetailView.this.b.setChartRange(0.6f);
                } else if (i3 == i4) {
                    YYGiftPkDetailView.this.a.setChartRange(1.0f);
                    YYGiftPkDetailView.this.b.setChartRange(1.0f);
                } else {
                    YYGiftPkDetailView.this.a.setChartRange(0.6f);
                    YYGiftPkDetailView.this.b.setChartRange(1.0f);
                }
            }
        }, this.g.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.g = baseYYStudioFragment;
        this.f.setVisibility(YYRoomInfoManager.e().y() ? 0 : 4);
        this.e.setVisibility(YYRoomInfoManager.e().y() ? 0 : 4);
        getPkInformation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (YYRoomInfoManager.e().y()) {
            LiveEventBus.get("show_gift_pk_time", String.class).observeForever(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (YYRoomInfoManager.e().y()) {
            LiveEventBus.get("show_gift_pk_time", String.class).removeObserver(this.i);
        }
    }
}
