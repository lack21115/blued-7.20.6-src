package com.blued.android.module.yy_china.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYHongbaoModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRedEnvRoomAdapter.class */
public final class YYRedEnvRoomAdapter extends BaseQuickAdapter<YYHongbaoModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final BaseFragmentActivity f16213a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRedEnvRoomAdapter(BaseFragmentActivity fragmentActive) {
        super(R.layout.item_red_env_room);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f16213a = fragmentActive;
    }

    private final String a(TextView textView, int i, String str) {
        Resources resources;
        String string;
        if (textView == null || (resources = textView.getResources()) == null || (string = resources.getString(i)) == null) {
            return null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.c(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedEnvRoomAdapter this$0, YYHongbaoModel yYHongbaoModel, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(R.id.item_root_view, 2000L)) {
            return;
        }
        this$0.a(yYHongbaoModel);
    }

    private final void a(YYHongbaoModel yYHongbaoModel) {
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) this.mContext.getString(R.string.yy_living_toast));
            return;
        }
        EventTrackYY.f(ChatRoomProtos.Event.YY_REDBAG_PAGE_GET_CLICK, yYHongbaoModel.hongbao_beans);
        YYRoomInfoManager.e().a(this.f16213a, yYHongbaoModel.room_id, "red_list");
    }

    public final BaseFragmentActivity a() {
        return this.f16213a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final YYHongbaoModel yYHongbaoModel) {
        if (yYHongbaoModel == null) {
            return;
        }
        String str = null;
        RelativeLayout relativeLayout = baseViewHolder == null ? null : (RelativeLayout) baseViewHolder.getView(R.id.item_root_view);
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_user_img);
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_user_name);
        TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_room_name);
        TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_count);
        TextView textView4 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_hongbao_value);
        ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_get_prize);
        if (TextUtils.equals(yYHongbaoModel.is_receive, "1")) {
            if (shapeTextView != null) {
                Resources resources = shapeTextView.getResources();
                if (resources != null) {
                    str = resources.getString(R.string.yy_hongbao_got);
                }
                shapeTextView.setText(str);
            }
            if (shapeTextView != null) {
                shapeTextView.setEnabled(false);
            }
            ShapeHelper.a(shapeTextView, R.color.syc_D8D8D8, R.color.syc_D8D8D8);
        } else {
            if (shapeTextView != null) {
                Resources resources2 = shapeTextView.getResources();
                shapeTextView.setText(resources2 == null ? null : resources2.getString(R.string.yy_hongbao_get));
            }
            if (shapeTextView != null) {
                shapeTextView.setEnabled(true);
            }
            ShapeHelper.a(shapeTextView, R.color.syc_00E0AB, R.color.syc_649FFF);
        }
        if (textView2 != null) {
            textView2.setTextColor(BluedSkinUtils.a(textView2.getContext(), R.color.syc_h));
        }
        ImageLoader.a(a().a(), yYHongbaoModel.user_avatar).a(imageView);
        if (textView != null) {
            textView.setText(yYHongbaoModel.user_name);
        }
        if (textView2 != null) {
            textView2.setText(yYHongbaoModel.room_name);
        }
        if (textView3 != null) {
            int i = R.string.yy_audience_number_in_room;
            String str2 = yYHongbaoModel.room_member_count;
            Intrinsics.c(str2, "it.room_member_count");
            textView3.setText(a(textView3, i, str2));
        }
        if (textView4 != null) {
            int i2 = R.string.yy_gitf_price;
            String str3 = yYHongbaoModel.hongbao_beans;
            Intrinsics.c(str3, "it.hongbao_beans");
            textView4.setText(a(textView4, i2, str3));
        }
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRedEnvRoomAdapter$QxO8t3waeeCH-vwG2uXqlStuYPk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRedEnvRoomAdapter.a(YYRedEnvRoomAdapter.this, yYHongbaoModel, view);
            }
        });
    }
}
