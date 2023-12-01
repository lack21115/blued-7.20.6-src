package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogChooseASongBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.MusicDTO;
import com.blued.android.module.yy_china.model.NewSongMessageModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYChooseSongDialog.class */
public final class YYChooseSongDialog extends LinearLayout implements View.OnClickListener {
    private DialogChooseASongBinding a;
    private NewSongMessageModel b;
    private BaseYYStudioFragment c;
    private long d;
    private long e;
    private int f;
    private YYGiftModel g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYChooseSongDialog(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYChooseSongDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYChooseSongDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        DialogChooseASongBinding a = DialogChooseASongBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        a.c.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NewSongMessageModel single, YYChooseSongDialog this$0, String str) {
        MusicDTO musicDTO;
        Intrinsics.e(single, "$single");
        Intrinsics.e(this$0, "this$0");
        if (!"YY_SU_PASSWORD_YYChooseASongdialog".equals(str) || (musicDTO = single.music) == null) {
            return;
        }
        this$0.a(musicDTO.getMusicId(), musicDTO.getMusicName(), musicDTO.getArtist(), musicDTO.getCoverUrl(), musicDTO.getDuration());
    }

    private final void a(final YYGiftModel yYGiftModel, String str, boolean z) {
        YYRoomModel b;
        String str2;
        if (yYGiftModel == null) {
            return;
        }
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYGiftModel.hit_id = System.currentTimeMillis();
        if (YYRoomInfoManager.e().b() == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        long currentTimeMillis = System.currentTimeMillis();
        if (yYGiftModel.double_hit == 1) {
            YYGiftModel yYGiftModel2 = this.g;
            if (yYGiftModel2 != null) {
                Intrinsics.a(yYGiftModel2);
                str2 = yYGiftModel2.goods_id;
            } else {
                str2 = "";
            }
            if (!StringUtils.a(str2, yYGiftModel.goods_id) || this.d <= 0 || currentTimeMillis - this.e >= 8000) {
                this.d = currentTimeMillis;
                this.e = currentTimeMillis;
                this.f = 1;
            } else {
                this.e = currentTimeMillis;
                this.f++;
            }
            yYGiftModel.hit_count = this.f;
        } else {
            this.d = 0L;
            yYGiftModel.hit_count = 1;
        }
        yYPayRequestModel.hit_id = this.d;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = b.uid;
        yYPayRequestModel.pay_from = 1;
        yYGiftModel.hit_id = this.d;
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        BaseYYStudioFragment baseYYStudioFragment = this.c;
        YYPayUtils.a(yYPayRequestModel, payFromSource, baseYYStudioFragment, baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.view.YYChooseSongDialog$buyGift$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                MusicDTO musicDTO;
                Intrinsics.e(goodsModel, "goodsModel");
                YYChooseSongDialog.this.g = yYGiftModel;
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, goodsModel, false);
                NewSongMessageModel single = YYChooseSongDialog.this.getSingle();
                if (single == null || (musicDTO = single.music) == null) {
                    return;
                }
                YYChooseSongDialog.this.a(musicDTO.getMusicId(), musicDTO.getMusicName(), musicDTO.getArtist(), musicDTO.getCoverUrl(), musicDTO.getDuration());
            }
        }, "YY_SU_PASSWORD_YYChooseASongdialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, String str3, String str4, long j) {
        final BaseYYStudioFragment baseYYStudioFragment = this.c;
        if (baseYYStudioFragment == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str5 = b == null ? null : b.room_id;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment.getFragmentActive();
        YYRoomHttpUtils.a(str5, str, str2, str3, str4, j, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYChooseSongDialog$chooseSong$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("点歌成功");
                YYRoomInfoManager.e().H();
                FragmentKt.setFragmentResult(BaseYYStudioFragment.this, "key_cancel", BundleKt.bundleOf(new Pair[0]));
                BaseYYStudioFragment.this.y();
            }
        }, baseYYStudioFragment.getFragmentActive());
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment, final NewSongMessageModel single) {
        Intrinsics.e(baseYYStudioFragment, "baseYYStudioFragment");
        Intrinsics.e(single, "single");
        this.b = single;
        this.c = baseYYStudioFragment;
        ImageLoader.a(baseYYStudioFragment.getFragmentActive(), single.music.getCoverUrl()).a(this.a.a);
        TextView textView = this.a.b;
        textView.setText("本次排麦需支付单次点歌费用（一个" + ((Object) single.goods.name) + "礼物）");
        this.a.d.setText(single.music.getMusicName());
        this.a.f.setText(single.music.getArtist());
        LiveEventBus.get("YYSuccessPasswordEvent", String.class).observe((LifecycleOwner) baseYYStudioFragment, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYChooseSongDialog$mLKlasE78hsdjkvPcMGO66REHO8
            public final void onChanged(Object obj) {
                YYChooseSongDialog.a(NewSongMessageModel.this, this, (String) obj);
            }
        });
    }

    public final BaseYYStudioFragment getBaseYYStudioFragment() {
        return this.c;
    }

    public final DialogChooseASongBinding getBinding() {
        return this.a;
    }

    public final NewSongMessageModel getSingle() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        NewSongMessageModel newSongMessageModel = this.b;
        if (newSongMessageModel == null) {
            return;
        }
        a(newSongMessageModel.goods, "", false);
    }

    public final void setBaseYYStudioFragment(BaseYYStudioFragment baseYYStudioFragment) {
        this.c = baseYYStudioFragment;
    }

    public final void setBinding(DialogChooseASongBinding dialogChooseASongBinding) {
        Intrinsics.e(dialogChooseASongBinding, "<set-?>");
        this.a = dialogChooseASongBinding;
    }

    public final void setSingle(NewSongMessageModel newSongMessageModel) {
        this.b = newSongMessageModel;
    }
}
