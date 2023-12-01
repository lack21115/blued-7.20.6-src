package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ItemYyCpLikeToGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyKtvNoticeSendGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyMsgKtvSingSendGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemYyMsgSystemUpBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationSuccessBinding;
import com.blued.android.module.yy_china.databinding.ItemYySystemToGoBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.CpRoomChooseMode;
import com.blued.android.module.yy_china.model.IMJsonContents108Model;
import com.blued.android.module.yy_china.model.IMJsonContents112Model;
import com.blued.android.module.yy_china.model.LuckGiftModel;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMsgKtvPrize;
import com.blued.android.module.yy_china.model.YYMsgMicStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgMuteStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgOfficeExtra;
import com.blued.android.module.yy_china.model.YYMsgUpSeatExtra;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRelationShipSuccessBuriedPointDataImMode;
import com.blued.android.module.yy_china.model.YYRelationShipSuccessImMode;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYReportMsg;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YyImSong1MlateTogiftModel;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYCommonStringUtils;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYConfessedListDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYImMsgAdapter.class */
public class YYImMsgAdapter extends BaseMultiItemQuickAdapter<YYImModel, BaseViewHolder> {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private BaseYYStudioFragment m;
    private HashMap<String, Bitmap> n;
    private TextPaint o;
    private byte[] p;
    private long q;
    private long r;
    private int s;
    private YYGiftModel t;

    public YYImMsgAdapter(BaseYYStudioFragment baseYYStudioFragment) {
        super((List) null);
        this.a = 6;
        this.b = 7;
        this.c = 8;
        this.d = 9;
        this.e = 14;
        this.f = 15;
        this.g = 16;
        this.h = 17;
        this.i = 18;
        this.j = 19;
        this.k = 20;
        this.l = 0;
        this.n = new HashMap<>();
        this.o = new TextPaint();
        this.q = 0L;
        this.r = 0L;
        this.s = 0;
        this.m = baseYYStudioFragment;
        this.mContext = baseYYStudioFragment.getContext();
        this.l = DensityUtils.a(this.mContext, 3.0f);
        addItemType(21, R.layout.item_yy_msg_system);
        addItemType(-10000, R.layout.item_yy_msg_system_up);
        addItemType(1, R.layout.item_yy_msg_text);
        addItemType(20, R.layout.item_yy_msg_rename);
        addItemType(2, R.layout.item_yy_join_text);
        addItemType(3, R.layout.item_yy_msg_join);
        addItemType(14, R.layout.item_yy_msg_text);
        addItemType(19, R.layout.item_yy_msg_text);
        addItemType(6, R.layout.item_yy_msg_text);
        addItemType(7, R.layout.item_yy_apply_mic);
        addItemType(18, R.layout.item_yy_apply_mic);
        addItemType(17, R.layout.item_yy_apply_mic);
        addItemType(8, R.layout.item_yy_apply_mic);
        addItemType(9, R.layout.item_yy_apply_mic);
        addItemType(15, R.layout.item_yy_apply_mic);
        addItemType(16, R.layout.item_yy_msg_apply_seat);
        addItemType(5, R.layout.item_yy_msg_send_giftt);
        addItemType(23, R.layout.item_yy_apply_mic);
        addItemType(10, R.layout.item_yy_msg_text);
        addItemType(11, R.layout.item_yy_msg_text);
        addItemType(26, R.layout.item_yy_msg_broadcast);
        addItemType(36, R.layout.item_yy_vote_result);
        addItemType(38, R.layout.item_yy_apply_mic);
        addItemType(59, R.layout.item_yy_msg_join);
        addItemType(76, R.layout.item_yy_msg_ktv_sing_send_gift);
        addItemType(72, R.layout.item_yy_vote_result);
        addItemType(112, R.layout.item_yy_apply_mic);
        addItemType(-2, R.layout.item_yy_apply_mic);
        addItemType(-3, R.layout.item_yy_msg_system_follow);
        addItemType(-4, R.layout.item_yy_msg_system_gift);
        addItemType(-5, R.layout.item_yy_msg_edit_broadcast);
        addItemType(-6, R.layout.item_yy_msg_cp_guide);
        addItemType(27, R.layout.item_yy_apply_mic);
        addItemType(28, R.layout.item_yy_apply_mic);
        addItemType(31, R.layout.item_yy_vote_result);
        addItemType(78, R.layout.item_yy_ktv_notice_send_gift);
        addItemType(-7, R.layout.item_yy_cp_like_to_gift);
        addItemType(-8, R.layout.item_yy_relation_success);
        addItemType(108, R.layout.item_yy_theme_activity_start);
        addItemType(-9, R.layout.item_yy_system_to_go);
        this.o.setTextSize(14.0f);
    }

    private void A(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        StringBuilder sb = new StringBuilder();
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        if (yYAudienceModel != null) {
            sb.append(YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()));
        }
        sb.append("关注了房主");
        textView.setText(sb.toString());
    }

    private void B(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.target_profile;
        StringBuilder sb = new StringBuilder();
        if (yYAudienceModel != null) {
            sb.append(YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()));
            sb.append(" ");
            sb.append(yYImModel.contents);
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
            textView.setText(sb.toString());
        }
        a(imageView, yYAudienceModel);
    }

    private void C(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.target_profile;
        StringBuilder sb = new StringBuilder();
        if (yYAudienceModel != null) {
            sb.append(yYAudienceModel.getChatAnchorName());
            sb.append(" ");
            sb.append("被移出了房间");
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
            textView.setText(sb.toString());
        }
    }

    private void D(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.target_profile;
        StringBuilder sb = new StringBuilder();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        if (yYAudienceModel != null) {
            sb.append(" ");
            sb.append(YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()));
            sb.append(" ");
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        }
        YYMsgUpSeatExtra yYMsgUpSeatExtra = (YYMsgUpSeatExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpSeatExtra.class);
        if (yYMsgUpSeatExtra != null) {
            if (yYMsgUpSeatExtra.seat_num == 0 && TextUtils.equals(b.chat_type, "9")) {
                sb.append("已上到主持位");
            } else if (yYMsgUpSeatExtra.seat_num == 0 && TextUtils.equals(b.chat_type, "9")) {
                sb.append("已上到主持位");
            } else {
                sb.append(String.format(this.mContext.getResources().getString(R.string.yy_msg_up_seat_success), Integer.valueOf(yYMsgUpSeatExtra.seat_num)));
            }
        }
        if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).gravity = 16;
        }
        textView.setText(sb.toString());
        a(imageView, yYAudienceModel);
    }

    private void E(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ((TextView) baseViewHolder.getView(R.id.tv_msg_content)).setText(yYImModel.contents);
    }

    private void F(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_title);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYMsgOfficeExtra yYMsgOfficeExtra = (YYMsgOfficeExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgOfficeExtra.class);
        if (yYMsgOfficeExtra != null) {
            if (TextUtils.isEmpty(yYMsgOfficeExtra.text_color)) {
                textView.setTextColor(textView2.getResources().getColor(R.color.syc_00E0AB));
                textView2.setTextColor(textView2.getResources().getColor(R.color.syc_00E0AB));
            } else {
                textView.setTextColor(Color.parseColor(yYMsgOfficeExtra.text_color));
                textView2.setTextColor(Color.parseColor(yYMsgOfficeExtra.text_color));
            }
            if (TextUtils.isEmpty(yYMsgOfficeExtra.title)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(yYMsgOfficeExtra.title);
            }
            if (TextUtils.isEmpty(yYMsgOfficeExtra.content)) {
                textView2.setVisibility(8);
                return;
            }
            textView2.setVisibility(0);
            textView2.setText(yYMsgOfficeExtra.content);
        }
    }

    private void G(final BaseViewHolder baseViewHolder, final YYImModel yYImModel) {
        String str;
        int i;
        final View view;
        SquareImageView squareImageView;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        final TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        if (yYAudienceModel != null) {
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
            if (TextUtils.equals("2", yYAudienceModel.chat_anchor)) {
                str = this.mContext.getResources().getString(R.string.yy_role_manager);
                i = R.color.syc_8F38FD;
            } else if (TextUtils.equals("1", yYAudienceModel.chat_anchor)) {
                str = this.mContext.getResources().getString(R.string.yy_role_host);
                i = R.color.syc_3883FD;
            }
            view = (ConstraintLayout) baseViewHolder.itemView.findViewById(R.id.ll_item_root);
            squareImageView = (SquareImageView) baseViewHolder.itemView.findViewById(R.id.iv_decorate);
            view.setBackgroundResource(R.drawable.shape_raduis_16_tran_30_000000);
            squareImageView.setImageResource(R.color.transparent);
            if (yYImModel.source_profile != null && !StringUtils.b(yYImModel.source_profile.message_bubble_img)) {
                a(view, yYImModel.source_profile.message_bubble_img);
                ImageLoader.a(this.m.getFragmentActive(), yYImModel.source_profile.message_bubble_icon).g().g(-1).a(squareImageView);
            }
            textView.setText(a(YYCommonStringUtils.a(this.mContext, textView, yYImModel, str, i, YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), yYImModel.contents)));
            textView.post(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.8
                @Override // java.lang.Runnable
                public void run() {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(view);
                    if (textView.getLineCount() <= 1) {
                        constraintSet.connect(R.id.txt_view, 3, R.id.iv_header, 3);
                        constraintSet.connect(R.id.txt_view, 4, R.id.iv_header, 4);
                    } else {
                        constraintSet.connect(R.id.txt_view, 3, R.id.iv_header, 3);
                    }
                    constraintSet.applyTo(view);
                    ViewGroup.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
                    if (yYImModel.source_profile != null) {
                        if (yYImModel.source_profile.wealth_level >= 20) {
                            ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_20);
                        } else {
                            ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_4);
                        }
                    } else if (StringUtils.b(yYImModel.source_profile.message_bubble_icon)) {
                        ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_4);
                    } else {
                        ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_20);
                    }
                    textView.setLayoutParams(layoutParams);
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    YYImMsgAdapter.this.a(baseViewHolder.getAdapterPosition());
                    return true;
                }
            });
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            a(imageView, yYAudienceModel);
        }
        str = "";
        i = 0;
        view = (ConstraintLayout) baseViewHolder.itemView.findViewById(R.id.ll_item_root);
        squareImageView = (SquareImageView) baseViewHolder.itemView.findViewById(R.id.iv_decorate);
        view.setBackgroundResource(R.drawable.shape_raduis_16_tran_30_000000);
        squareImageView.setImageResource(R.color.transparent);
        if (yYImModel.source_profile != null) {
            a(view, yYImModel.source_profile.message_bubble_img);
            ImageLoader.a(this.m.getFragmentActive(), yYImModel.source_profile.message_bubble_icon).g().g(-1).a(squareImageView);
        }
        textView.setText(a(YYCommonStringUtils.a(this.mContext, textView, yYImModel, str, i, YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), yYImModel.contents)));
        textView.post(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(view);
                if (textView.getLineCount() <= 1) {
                    constraintSet.connect(R.id.txt_view, 3, R.id.iv_header, 3);
                    constraintSet.connect(R.id.txt_view, 4, R.id.iv_header, 4);
                } else {
                    constraintSet.connect(R.id.txt_view, 3, R.id.iv_header, 3);
                }
                constraintSet.applyTo(view);
                ViewGroup.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
                if (yYImModel.source_profile != null) {
                    if (yYImModel.source_profile.wealth_level >= 20) {
                        ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_20);
                    } else {
                        ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_4);
                    }
                } else if (StringUtils.b(yYImModel.source_profile.message_bubble_icon)) {
                    ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_4);
                } else {
                    ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.dp_20);
                }
                textView.setLayoutParams(layoutParams);
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                YYImMsgAdapter.this.a(baseViewHolder.getAdapterPosition());
                return true;
            }
        });
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        a(imageView, yYAudienceModel);
    }

    private void H(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (YYRoomInfoManager.e().a == null || yYAudienceModel == null || b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str = "@(name:" + YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()) + ",id:" + EncryptTool.b(yYAudienceModel.getUid()) + ") ";
        YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        if (b.welcome_info == null || StringUtils.b(b.welcome_info.getContent())) {
            sb.append(str);
            sb.append("进来陪你聊天");
        } else {
            sb.append("欢迎 ");
            sb.append(str);
            sb.append(b.welcome_info.getContent());
        }
        SpannableStringBuilder a = YYCommonStringUtils.a(this.mContext, textView, null, "", R.color.syc_8F38FD, "", sb.toString());
        a(imageView, yYAudienceModel);
        textView.setText(a(a));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        View view = (ConstraintLayout) baseViewHolder.itemView.findViewById(R.id.ll_item_root);
        SquareImageView squareImageView = (SquareImageView) baseViewHolder.itemView.findViewById(R.id.iv_decorate);
        view.setBackgroundResource(R.drawable.shape_raduis_16_tran_30_000000);
        squareImageView.setImageResource(R.color.transparent);
        if (b.welcome_info == null || StringUtils.b(b.welcome_info.getIcon())) {
            return;
        }
        a(view, b.welcome_info.getIcon());
        ImageLoader.a(this.m.getFragmentActive(), b.welcome_info.getIcon_small()).g().g(-1).a(squareImageView);
    }

    private void I(BaseViewHolder baseViewHolder, final YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        final ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_action);
        final YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        final YYRoomModel b = YYRoomInfoManager.e().b();
        final YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null || yYAudienceModel == null || b == null) {
            return;
        }
        if (yYImModel.sayHello) {
            shapeTextView.setText("已撩");
            shapeTextView.setEnabled(false);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
            ShapeHelper.d(shapeTextView, R.color.syc_D8D8D8, R.color.common_v4_gray_font1, R.color.syc_929292);
        } else {
            shapeTextView.setText("撩一下");
            shapeTextView.setEnabled(true);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_1E1F23);
            ShapeHelper.d(shapeTextView, R.color.syc_dark_b, R.color.syc_dark_b, R.color.syc_dark_b);
        }
        StringBuilder sb = new StringBuilder();
        String str = "@(name:" + YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()) + ",id:" + EncryptTool.b(yYAudienceModel.getUid()) + ") ";
        YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        if (YYRoomInfoManager.e().y()) {
            sb.append(str);
            sb.append("进房");
            shapeTextView.setVisibility(0);
        } else {
            shapeTextView.setVisibility(8);
            sb.append(str);
            sb.append("进来陪你聊天");
        }
        SpannableStringBuilder a = YYCommonStringUtils.a(this.mContext, textView, null, TextUtils.equals("2", yYAudienceModel.chat_anchor) ? this.mContext.getResources().getString(R.string.yy_role_manager) : "", R.color.syc_8F38FD, "", sb.toString());
        a(imageView, yYAudienceModel);
        textView.setText(a(a));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (b != null && yYAudienceModel != null) {
                    EventTrackYY.l(ChatRoomProtos.Event.CHAT_ROOM_INTERACT_CLICK, b.room_id, b.uid, yYAudienceModel.getUid());
                }
                shapeTextView.setText("已撩");
                yYImModel.sayHello = true;
                shapeTextView.setEnabled(false);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
                ShapeHelper.d(shapeTextView, R.color.syc_D8D8D8, R.color.common_v4_gray_font1, R.color.syc_929292);
                YYImMsgAdapter.this.a(b.room_id, yYUserInfo.getUid(), yYAudienceModel.getUid());
            }
        });
    }

    private void J(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ((ShapeTextView) baseViewHolder.getView(R.id.tv_rename)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYImMsgAdapter.this.m.k();
            }
        });
    }

    private void K(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_follow);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        if (yYAudienceModel != null) {
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
            textView.setText(this.mContext.getResources().getString(R.string.yy_msg_follow));
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_GUIDE_SHOW, b.room_id, b.uid);
            }
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK, b2.room_id, b2.uid);
                YYRoomInfoManager.e().b(YYImMsgAdapter.this.mContext, b2.uid, b2.name, YYImMsgAdapter.this.m.getFragmentActive());
            }
        });
    }

    private void L(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_send_gift);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        if (yYAudienceModel != null) {
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_SEND_GIFT_CLICK, b.room_id, b.uid);
                }
                YYImMsgAdapter.this.m.a(true, "gift_guiding_robot", "");
            }
        });
    }

    private void M(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        String str;
        int i;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (yYAudienceModel == null || yYAudienceModel2 == null) {
            textView.setText("");
            ImageLoader.a(this.m.getFragmentActive(), "").b(R.drawable.user_bg_round).a(imageView);
            return;
        }
        StringBuilder sb = new StringBuilder();
        YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        int i2 = 0;
        if (TextUtils.equals("2", yYAudienceModel.chat_anchor)) {
            str = this.mContext.getResources().getString(R.string.yy_role_manager);
            i = R.color.syc_8F38FD;
        } else if (TextUtils.equals("1", yYAudienceModel.chat_anchor)) {
            str = this.mContext.getResources().getString(R.string.yy_role_host);
            i = R.color.syc_3883FD;
        } else {
            i2 = this.l;
            str = "";
            i = 0;
        }
        if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = i2;
        }
        sb.append(" 已将 ");
        sb.append(YYRoomInfoManager.e().a(yYAudienceModel2.getUid(), yYAudienceModel2.getName()));
        sb.append(" 禁言");
        SpannableStringBuilder a = YYCommonStringUtils.a(this.mContext, textView, (YYImModel) null, str, i, YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), sb.toString(), false);
        a.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), a.length() - 2, a.length(), 33);
        textView.setText(a);
    }

    private void N(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        String str;
        int i;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (yYAudienceModel == null || yYAudienceModel2 == null) {
            textView.setText("");
            ImageLoader.a(this.m.getFragmentActive(), "").b(R.drawable.user_bg_round).a(imageView);
            return;
        }
        StringBuilder sb = new StringBuilder();
        YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        int i2 = 0;
        if (TextUtils.equals("2", yYAudienceModel.chat_anchor)) {
            str = this.mContext.getResources().getString(R.string.yy_role_manager);
            i = R.color.syc_8F38FD;
        } else if (TextUtils.equals("1", yYAudienceModel.chat_anchor)) {
            str = this.mContext.getResources().getString(R.string.yy_role_host);
            i = R.color.syc_3883FD;
        } else {
            i2 = this.l;
            str = "";
            i = 0;
        }
        if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = i2;
        }
        sb.append(" 已将 ");
        sb.append(YYRoomInfoManager.e().a(yYAudienceModel2.getUid(), yYAudienceModel2.getName()));
        sb.append(" 解除禁言");
        SpannableStringBuilder a = YYCommonStringUtils.a(this.mContext, textView, (YYImModel) null, str, i, YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), sb.toString(), false);
        a.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), a.length() - 4, a.length(), 33);
        textView.setText(a);
    }

    private int a(String str) {
        if (TextUtils.equals(str, "2")) {
            return R.color.syc_8F38FD;
        }
        if (TextUtils.equals(str, "1")) {
            return R.color.syc_3883FD;
        }
        return 0;
    }

    private CharSequence a(SpannableStringBuilder spannableStringBuilder) {
        return YYRoomInfoManager.e().c().a(spannableStringBuilder, "#00E0AB", new ClickAtLinkListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.12
            @Override // com.blued.android.module.yy_china.listener.ClickAtLinkListener
            public void a(String str, String str2) {
                String str3 = YYImMsgAdapter.TAG;
                Logger.e(str3, "click at member (uid : " + str2 + " , uName : " + str);
                YYImMsgAdapter.this.b(str2, str, "");
            }

            @Override // com.blued.android.module.yy_china.listener.ClickAtLinkListener
            public String b(String str, String str2) {
                String str3 = YYImMsgAdapter.TAG;
                Log.e(str3, "click at member (uid : " + str2 + " , uName : " + str);
                String str4 = YYImMsgAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("click at member (uid : ");
                sb.append(YYRoomInfoManager.e().a(str2, str));
                Log.e(str4, sb.toString());
                return YYRoomInfoManager.e().a(str2, str);
            }
        });
    }

    private String a(Context context, String str) {
        String str2 = str;
        if (this.o != null) {
            str2 = str;
            if (str != null) {
                str2 = str;
                if (str.length() > 0) {
                    float measureText = this.o.measureText(str);
                    float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.dp_40);
                    str2 = str;
                    if (measureText > dimensionPixelOffset) {
                        int length = ((int) (str.length() * (dimensionPixelOffset / measureText))) - 2;
                        str2 = str;
                        if (length > 0) {
                            str2 = str;
                            if (length < str.length()) {
                                str2 = str.substring(0, length) + "...";
                            }
                        }
                    }
                }
            }
        }
        return str2;
    }

    private String a(String str, String str2, String str3, int i) {
        if (TextUtils.equals(str, YYRoomInfoManager.e().k())) {
            if (i == 1) {
                return "恭喜您在「浪漫之旅」中点亮了 " + str3;
            } else if (i == 2) {
                return "恭喜您在「浪漫之旅」中点亮了稀有地点 " + str3 + "，已获得专属进场特效";
            } else if (i == 3) {
                return "恭喜您在「浪漫之旅」中点亮了所有地点，已获得专属坐骑";
            } else {
                if (i == 4) {
                    return "恭喜您在「浪漫之旅」中收集到 " + str3;
                } else if (i != 5) {
                    return i == 6 ? "恭喜您在「浪漫之旅」中收集到所有地点，已获得专属勋章和专属称号" : "";
                } else {
                    return "恭喜您在「浪漫之旅」中收集到稀有地点 " + str3;
                }
            }
        } else if (i == 1) {
            return "恭喜 " + str2 + " 在「浪漫之旅」中点亮了 " + str3;
        } else if (i == 2) {
            return "恭喜 " + str2 + " 在「浪漫之旅」中点亮了稀有地点 " + str3 + "，已获得专属进场特效";
        } else if (i == 3) {
            return "恭喜 " + str2 + "在「浪漫之旅」中点亮了所有地点，已获得专属坐骑";
        } else if (i == 4) {
            return "恭喜 " + str2 + " 在「浪漫之旅」中收集到 " + str3;
        } else if (i == 5) {
            return "恭喜 " + str2 + " 在「浪漫之旅」中收集到稀有地点 " + str3;
        } else if (i == 6) {
            return "恭喜 " + str2 + " 在「浪漫之旅」中收集到所有地点，已获得专属勋章和专属称号";
        } else {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ArrayList arrayList = new ArrayList();
        YYReportModel yYReportModel = new YYReportModel();
        int i2 = i;
        while (true) {
            int i3 = i2;
            if (i3 < 0) {
                break;
            }
            YYImModel yYImModel = (YYImModel) getData().get(i3);
            if (yYImModel.type == 1) {
                YYReportMsg yYReportMsg = new YYReportMsg();
                yYReportMsg.uid = yYImModel.source_profile.getUid();
                yYReportMsg.contents = yYImModel.contents;
                if (i == i3) {
                    yYReportMsg.report = 1;
                    yYReportModel.uid = yYImModel.source_profile.getUid();
                } else {
                    yYReportMsg.report = 0;
                }
                yYReportMsg.time = yYImModel.msg_time;
                arrayList.add(yYReportMsg);
                if (arrayList.size() >= 5) {
                    break;
                }
            }
            i2 = i3 - 1;
        }
        yYReportModel.msg = arrayList;
        yYReportModel.reportType = 2;
        LiveEventBus.get("common_report_user").post(yYReportModel);
    }

    private void a(View view, final YYAudienceModel yYAudienceModel) {
        if (view == null || yYAudienceModel == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYImMsgAdapter.this.b(yYAudienceModel.getUid(), yYAudienceModel.getName(), yYAudienceModel.getAvatar());
            }
        });
    }

    private void a(TextView textView, Bitmap bitmap, YYImModel yYImModel, String str, String str2, YYAudienceModel yYAudienceModel) {
        textView.setText(a(YYCommonStringUtils.a(this.mContext, textView, (YYImModel) null, str, a(yYAudienceModel.chat_anchor), a(textView.getContext(), YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName())), str2, bitmap)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CpRoomChooseMode cpRoomChooseMode, View view) {
        a(cpRoomChooseMode.getGift_info(), "", false, cpRoomChooseMode.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel, View view) {
        a(yyImSong1MlateTogiftModel.android_goods_info, "", false, yyImSong1MlateTogiftModel.host_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        YYRoomHttpUtils.a(str, str2, str3, 0, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.m.getFragmentActive()) { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, (IRequestHost) this.m.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel, View view) {
        yyImSong1MlateTogiftModel.isClick = true;
        notifyDataSetChanged();
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().music == null) {
            ToastUtils.a(R.string.yy_toa_ktv_gz_more);
            return;
        }
        YYMsgKtvMusic yYMsgKtvMusic = YYRoomInfoManager.e().b().music;
        if (yYMsgKtvMusic.uid.equals(yyImSong1MlateTogiftModel.host_id) && yYMsgKtvMusic.musicName.equals(yyImSong1MlateTogiftModel.music_name)) {
            YYRoomHttpUtils.b(YYRoomInfoManager.e().b().room_id, yyImSong1MlateTogiftModel.choosed_id, new BluedUIHttpResponse() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.4
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    LiveEventBus.get("event_ktv_show_applaud").post("");
                }
            }, this.m.getFragmentActive());
        } else {
            ToastUtils.a(R.string.yy_toa_ktv_gz_more);
        }
    }

    private void b(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        IMJsonContents112Model iMJsonContents112Model = (IMJsonContents112Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents112Model.class);
        if (iMJsonContents112Model == null) {
            return;
        }
        textView.setText(a(iMJsonContents112Model.getUid(), iMJsonContents112Model.getName(), iMJsonContents112Model.getRegions() != null ? iMJsonContents112Model.getRegions().getName() : "", iMJsonContents112Model.getType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        YYRoomModel b;
        YYUserInfo yYUserInfo;
        if (TextUtils.isEmpty(str) || (b = YYRoomInfoManager.e().b()) == null || (yYUserInfo = YYRoomInfoManager.e().a) == null) {
            return;
        }
        this.m.a(str, str2, str3, yYUserInfo.chat_anchor, b.isExistById(str));
    }

    private void c(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        IMJsonContents108Model iMJsonContents108Model = (IMJsonContents108Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents108Model.class);
        if (iMJsonContents108Model == null) {
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_theme_notice);
        Long valueOf = Long.valueOf(iMJsonContents108Model.getCountdown_time());
        String name = iMJsonContents108Model.getActivity_info().getName();
        if (YYRoomInfoManager.e().y()) {
            if (iMJsonContents108Model.getType() == 1) {
                textView.setText(Html.fromHtml(String.format(this.mContext.getString(R.string.msg_theme_activity_h), name, valueOf)));
                return;
            } else if (iMJsonContents108Model.getType() == 2) {
                textView.setText(Html.fromHtml(String.format(this.mContext.getString(R.string.msg_theme_activity_end_h), name, valueOf)));
                return;
            } else {
                return;
            }
        }
        String str = (YYRoomInfoManager.e().b() != null ? YYRoomInfoManager.e().b().name : "") + "的主题专场活动「" + name + "」";
        String str2 = "还有" + valueOf;
        if (iMJsonContents108Model.getType() == 1) {
            textView.setText(Html.fromHtml(String.format(this.mContext.getString(R.string.msg_theme_activity), str, str2)));
        } else if (iMJsonContents108Model.getType() == 2) {
            textView.setText(Html.fromHtml(String.format(this.mContext.getString(R.string.msg_theme_activity_end), str, str2)));
        }
    }

    private void d(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ItemYyRelationSuccessBinding a = ItemYyRelationSuccessBinding.a(baseViewHolder.itemView);
        if (yYImModel.extra instanceof YYRelationShipSuccessImMode) {
            final YYRelationShipSuccessImMode yYRelationShipSuccessImMode = (YYRelationShipSuccessImMode) yYImModel.extra;
            if (!yYRelationShipSuccessImMode.isUp() && yYRelationShipSuccessImMode.getStatus() == 3) {
                yYRelationShipSuccessImMode.setUp(true);
                YYRelationShipSuccessBuriedPointDataImMode buried_point_data = yYRelationShipSuccessImMode.getBuried_point_data();
                if (YYRoomInfoManager.e().b() != null && buried_point_data != null) {
                    EventTrackYY.a(ChatRoomProtos.Event.YY_RELATION_GUIDE_MSG_SHOW, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid, buried_point_data.getRelation_id(), StringUtils.a(YYRoomInfoManager.e().k(), buried_point_data.getUid()) ? buried_point_data.getTarget_uid() : buried_point_data.getUid(), buried_point_data.getDay(), buried_point_data.getConfirm_beans());
                }
            }
            a.b.setText(yYRelationShipSuccessImMode.getMessage());
            a.a.setVisibility(0);
            a.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYImMsgAdapter.this.m.w();
                    YYRelationShipSuccessBuriedPointDataImMode buried_point_data2 = yYRelationShipSuccessImMode.getBuried_point_data();
                    if (YYRoomInfoManager.e().b() == null || buried_point_data2 == null) {
                        return;
                    }
                    EventTrackYY.a(ChatRoomProtos.Event.YY_RELATION_GUIDE_MSG_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid, buried_point_data2.getRelation_id(), StringUtils.a(YYRoomInfoManager.e().k(), buried_point_data2.getUid()) ? buried_point_data2.getTarget_uid() : buried_point_data2.getUid(), buried_point_data2.getDay(), buried_point_data2.getConfirm_beans());
                }
            });
        }
    }

    private void e(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ItemYySystemToGoBinding a = ItemYySystemToGoBinding.a(baseViewHolder.itemView);
        if (yYImModel.extra instanceof YYMsgOfficeExtra) {
            final YYMsgOfficeExtra yYMsgOfficeExtra = (YYMsgOfficeExtra) yYImModel.extra;
            a.b.setText(yYMsgOfficeExtra.content);
            a.a.setVisibility(0);
            a.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (StringUtils.a(yYMsgOfficeExtra.type, "1")) {
                        YYConfessedListDialog yYConfessedListDialog = new YYConfessedListDialog();
                        yYConfessedListDialog.a("room_screen");
                        yYConfessedListDialog.show(YYImMsgAdapter.this.m.getChildFragmentManager(), "YYConfessedListDialog");
                    }
                }
            });
        }
    }

    private void f(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        String str;
        ItemYyCpLikeToGiftBinding a = ItemYyCpLikeToGiftBinding.a(baseViewHolder.itemView);
        if (yYImModel.extra instanceof CpRoomChooseMode) {
            final CpRoomChooseMode cpRoomChooseMode = (CpRoomChooseMode) yYImModel.extra;
            if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(cpRoomChooseMode.getUid())) {
                str = "你\"心动了\"" + cpRoomChooseMode.getContRealName() + "，快去送花吸引对方的注意吧";
            } else {
                str = "你\"心动了\"" + cpRoomChooseMode.getContName() + "，快去送花吸引对方的注意吧";
            }
            a.b.setText(str);
            a.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYImMsgAdapter$mZupOguGCy68rf_yqzs9t8Hzd1s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYImMsgAdapter.this.a(cpRoomChooseMode, view);
                }
            });
        }
    }

    private void g(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = ItemYyMsgSystemUpBinding.a(baseViewHolder.itemView).a;
        textView.setText("收到type =  " + yYImModel.contents);
    }

    private void h(BaseViewHolder baseViewHolder, final YYImModel yYImModel) {
        final ItemYyKtvNoticeSendGiftBinding a = ItemYyKtvNoticeSendGiftBinding.a(baseViewHolder.itemView);
        final YYRoomModel b = YYRoomInfoManager.e().b();
        a.a.setText(yYImModel.contents);
        if (yYImModel.isKtvSendGift) {
            a.b.setVisibility(8);
        } else {
            a.b.setVisibility(0);
        }
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                yYImModel.isKtvSendGift = true;
                a.b.setVisibility(8);
                LiveEventBus.get("event_ktv_pick_music").post("");
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_GUIDE_MSG_GO_CLICK, b.room_id, b.uid);
                }
            }
        });
        if (yYImModel.isUpEven) {
            return;
        }
        yYImModel.isUpEven = true;
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_GUIDE_MSG_SHOW, b.room_id, b.uid);
        }
    }

    private void i(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ItemYyMsgKtvSingSendGiftBinding a = ItemYyMsgKtvSingSendGiftBinding.a(baseViewHolder.itemView);
        final YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel = (YyImSong1MlateTogiftModel) yYImModel.extra;
        a.b.setText(String.format(a.b.getResources().getString(R.string.yy_im_ktv_guide_appl_cont), yyImSong1MlateTogiftModel.host_name, yyImSong1MlateTogiftModel.music_name));
        a.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYImMsgAdapter$FW9pKLyqbjNxB-Z0aS65eRZKq5U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYImMsgAdapter.this.b(yyImSong1MlateTogiftModel, view);
            }
        });
        a.c.setText(a.c.getResources().getString(R.string.yy_mess_ktv_guide_send, yyImSong1MlateTogiftModel.android_goods_info.name));
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYImMsgAdapter$Wew5Z7eq6MvsijcD6k3LJMw34VM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYImMsgAdapter.this.a(yyImSong1MlateTogiftModel, view);
            }
        });
        if (yyImSong1MlateTogiftModel.isClick) {
            ShapeHelper.a(a.a, R.color.syc_7C7C7C, R.color.syc_ADADAD);
            a.a.setClickable(false);
            return;
        }
        a.a.setClickable(true);
        ShapeHelper.a(a.a, R.color.syc_3883FD, R.color.syc_00E0AB);
    }

    private void j(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_vote_result);
        YYMsgKtvPrize yYMsgKtvPrize = (YYMsgKtvPrize) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgKtvPrize.class);
        if (yYMsgKtvPrize == null) {
            return;
        }
        textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_ktv_prize), yYMsgKtvPrize.name, yYMsgKtvPrize.gift, yYMsgKtvPrize.applause));
    }

    private void k(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        ((ShapeTextView) baseViewHolder.getView(R.id.tv_action)).setVisibility(8);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (yYAudienceModel == null || b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        sb.append("@(name:" + YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()) + ",id:" + EncryptTool.b(yYAudienceModel.getUid()) + ") ");
        sb.append("回撩了房主");
        SpannableStringBuilder a = YYCommonStringUtils.a(this.mContext, textView, null, TextUtils.equals("2", yYAudienceModel.chat_anchor) ? this.mContext.getResources().getString(R.string.yy_role_manager) : "", R.color.syc_8F38FD, "", sb.toString());
        a(imageView, yYAudienceModel);
        textView.setText(a(a));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void l(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYMsgMuteStatusExtra yYMsgMuteStatusExtra = (YYMsgMuteStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMuteStatusExtra.class);
        if (yYMsgMuteStatusExtra == null) {
            return;
        }
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (yYAudienceModel == null || yYAudienceModel2 == null) {
            textView.setText("");
            return;
        }
        String b = UserRelationshipUtils.b(this.mContext, yYAudienceModel.chat_anchor);
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals(YYRoomInfoManager.e().k(), yYMsgMuteStatusExtra.uid)) {
            sb.append("你被");
            sb.append(b);
            sb.append(yYMsgMuteStatusExtra.mute != 0 ? "闭麦" : "解麦");
        } else {
            if (YYRoomInfoManager.e().b() != null) {
                sb.append(YYRoomInfoManager.e().a(yYImModel.target_profile.getUid(), yYImModel.target_profile.getName()));
            }
            sb.append("被");
            sb.append(b);
            sb.append(yYMsgMuteStatusExtra.mute != 0 ? "闭麦" : "解麦");
        }
        textView.setText(sb.toString());
    }

    private void m(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_vote_result);
        if (((YYMsgBlindResultExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgBlindResultExtra.class)) == null) {
            return;
        }
        textView.setText(yYImModel.contents);
    }

    private void n(BaseViewHolder baseViewHolder, final YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_send_gift);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        if (yYAudienceModel != null) {
            textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_apply_up_seat), YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName())));
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYImMsgAdapter.this.m.u();
                YYImMsgAdapter.this.m.O().b(yYImModel);
            }
        });
        a(imageView, yYAudienceModel);
    }

    private void o(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ((TextView) baseViewHolder.getView(R.id.tv_vote_result)).setText(yYImModel.contents);
    }

    private void p(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        textView.setTextColor(this.mContext.getResources().getColor(R.color.syc_dark_b));
        textView.setText(yYImModel.contents);
    }

    private void q(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        textView.setTextColor(this.mContext.getResources().getColor(R.color.syc_dark_b));
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYMsgEmojiExtra yYMsgEmojiExtra = (YYMsgEmojiExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgEmojiExtra.class);
        if (yYMsgEmojiExtra != null) {
            textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_emoji_result), YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), yYMsgEmojiExtra.name, yYMsgEmojiExtra.result));
        } else {
            textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_emoji_result), YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), "猜拳", "出了布"));
        }
    }

    private void r(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ((ShapeTextView) baseViewHolder.getView(R.id.tv_edit)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYImMsgAdapter.this.m.H();
            }
        });
    }

    private void s(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ((TextView) baseViewHolder.getView(R.id.tv_msg_broadcast)).setText(yYImModel.contents);
    }

    private void t(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        if (yYAudienceModel != null) {
            textView.setText(yYAudienceModel.getChatAnchorName() + "拒绝了你的上麦申请");
        }
    }

    private void u(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.txt_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_gift_count);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_gift_img);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (yYAudienceModel != null) {
            YYRoomInfoManager.e().a(this.m.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
            sb2.append(UserRelationshipUtils.b(this.mContext, yYAudienceModel.chat_anchor));
        }
        YYMsgGiftExtra yYMsgGiftExtra = (YYMsgGiftExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgGiftExtra.class);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (!YYRoomInfoManager.e().J() || b == null || b.mMaskedVeiledRoominfo == null || b.mMaskedVeiledRoominfo.getVeiled_card_goods_id() == null || yYMsgGiftExtra == null || !b.mMaskedVeiledRoominfo.getVeiled_card_goods_id().contains(yYMsgGiftExtra.gift_id)) {
            sb.append(this.mContext.getResources().getString(R.string.yy_give_to));
        } else {
            sb.append("揭面了");
        }
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (yYAudienceModel2 == null) {
            return;
        }
        sb.append(" " + a(textView.getContext(), YYRoomInfoManager.e().a(yYAudienceModel2.getUid(), yYAudienceModel2.getName())) + " ");
        if (yYMsgGiftExtra != null) {
            if (yYMsgGiftExtra.is_luck_gift == 1) {
                sb.append(" ");
                sb.append(yYMsgGiftExtra.gift_name);
                sb.append(" 开出了");
                yYMsgGiftExtra.extra = (LuckGiftModel) yYImModel.msgMapExtra.get("extra");
                if (yYMsgGiftExtra.extra != null) {
                    if (yYMsgGiftExtra.extra.getName() != null) {
                        sb.append(yYMsgGiftExtra.extra.getName());
                    }
                    ImageLoader.a(this.m.getFragmentActive(), yYMsgGiftExtra.extra.getImages_static()).b(R.drawable.gift_default_icon).a(imageView2);
                }
            } else {
                ImageLoader.a(this.m.getFragmentActive(), yYMsgGiftExtra.gift_icon).b(R.drawable.gift_default_icon).a(imageView2);
            }
            int i = yYMsgGiftExtra.hit_batch == 1 ? yYMsgGiftExtra.hit_count : 0;
            if (i > 1) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" x" + i);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), 1, 2, 33);
                textView2.setText(spannableStringBuilder);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(4);
            }
            a(textView, null, yYImModel, sb2.toString(), sb.toString(), yYAudienceModel);
        }
        a(imageView, yYAudienceModel);
    }

    private void v(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_guide);
        ((TextView) baseViewHolder.getView(R.id.tv_guide_content)).setText(yYImModel.contents);
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_INSTRUCTION, b.room_id, b.uid);
                }
                LiveEventBus.get("show_blind_guide").post("");
            }
        });
    }

    private void w(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        YYMsgUpSeatExtra yYMsgUpSeatExtra;
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYAudienceModel yYAudienceModel = yYImModel.target_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.source_profile;
        if (yYAudienceModel == null || yYAudienceModel2 == null || (yYMsgUpSeatExtra = (YYMsgUpSeatExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpSeatExtra.class)) == null) {
            return;
        }
        if (yYMsgUpSeatExtra.leave_type == 1 || yYMsgUpSeatExtra.leave_type == 3) {
            String b = UserRelationshipUtils.b(this.mContext, yYAudienceModel2.chat_anchor);
            if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_bean_down), "你", b));
            } else {
                textView.setText(String.format(this.mContext.getResources().getString(R.string.yy_bean_down), YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()), b));
            }
        } else if (yYMsgUpSeatExtra.leave_type == 2) {
            if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                textView.setText("由于发言涉及违规内容，你已被抱下麦位");
                return;
            }
            textView.setText(YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()) + "由于发言涉及违规内容，已被抱下麦位");
        }
    }

    private void x(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYAudienceModel yYAudienceModel = yYImModel.target_profile;
        if (yYAudienceModel == null) {
            return;
        }
        String a = TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k()) ? "你" : YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName());
        if (TextUtils.equals(yYAudienceModel.chat_anchor, "2")) {
            textView.setText(a + "被房主设为场控");
            return;
        }
        textView.setText(a + "被房主取消场控");
    }

    private void y(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYMsgMuteStatusExtra yYMsgMuteStatusExtra = (YYMsgMuteStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMuteStatusExtra.class);
        if (yYMsgMuteStatusExtra == null) {
            return;
        }
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (yYAudienceModel == null || yYAudienceModel2 == null) {
            textView.setText("");
            return;
        }
        String b = UserRelationshipUtils.b(this.mContext, yYAudienceModel.chat_anchor);
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals(YYRoomInfoManager.e().k(), yYMsgMuteStatusExtra.uid)) {
            sb.append("你被");
        } else {
            sb.append(YYRoomInfoManager.e().a(yYImModel.target_profile.getUid(), yYImModel.target_profile.getName()));
            sb.append("被");
        }
        sb.append(b);
        if (yYMsgMuteStatusExtra.muteType == 1) {
            sb.append("解麦");
        } else if (yYMsgMuteStatusExtra.muteType == 2) {
            sb.append("闭麦");
        }
        textView.setText(sb.toString());
    }

    private void z(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_msg_content);
        YYMsgMicStatusExtra yYMsgMicStatusExtra = (YYMsgMicStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMicStatusExtra.class);
        StringBuilder sb = new StringBuilder();
        if (yYMsgMicStatusExtra != null) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (yYImModel.source_profile != null) {
                sb.append(yYImModel.source_profile.getChatAnchorName());
            }
            if (yYMsgMicStatusExtra.seat_close == 0) {
                sb.append("解封");
            } else {
                sb.append("封禁");
            }
            if (b == null || !b.isSaleChannel()) {
                sb.append(yYMsgMicStatusExtra.seat_num);
                sb.append("号麦位");
            } else {
                sb.append(yYMsgMicStatusExtra.seat_num - 2 >= 0 ? yYMsgMicStatusExtra.seat_num - 2 : 0);
                sb.append("号麦位");
            }
        }
        textView.setText(sb.toString());
    }

    public void a() {
        if (this.n == null) {
            return;
        }
        Logger.e(TAG, "onDetachedFromWindow ... 1");
        for (String str : this.n.keySet()) {
            Bitmap bitmap = this.n.get(str);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        this.n.clear();
        Logger.e(TAG, "onDetachedFromWindow ... 2");
    }

    public void a(final View view, String str) {
        ImageLoader.a(this.m.getFragmentActive(), str).a((Target<Drawable>) new CustomTarget<Drawable>() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.17
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                    return;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                view.setBackground(new NinePatchDrawable(YYImMsgAdapter.this.m.getResources(), bitmap, YYImMsgAdapter.this.a(bitmap), null, null));
            }

            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    public void a(final YYGiftModel yYGiftModel, String str, boolean z, String str2) {
        YYRoomModel b;
        if (yYGiftModel == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (yYGiftModel.sendGiftStatus == 1) {
            if (currentTimeMillis - yYGiftModel.sendGiftStatusLoadingTime <= 5000) {
                return;
            }
            yYGiftModel.sendGiftStatus = 0;
        }
        yYGiftModel.sendGiftStatus = 1;
        final YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYGiftModel.hit_id = currentTimeMillis;
        yYGiftModel.sendGiftStatusLoadingTime = currentTimeMillis;
        if (yYGiftModel == null || YYRoomInfoManager.e().b() == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (yYGiftModel.double_hit == 1) {
            YYGiftModel yYGiftModel2 = this.t;
            if (!StringUtils.a(yYGiftModel2 != null ? yYGiftModel2.goods_id : "", yYGiftModel.goods_id) || this.q <= 0 || currentTimeMillis2 - this.r >= 8000) {
                this.q = currentTimeMillis2;
                this.r = currentTimeMillis2;
                this.s = 1;
            } else {
                this.r = currentTimeMillis2;
                this.s++;
            }
            yYGiftModel.hit_count = this.s;
        } else {
            this.q = 0L;
            yYGiftModel.hit_count = 1;
        }
        yYPayRequestModel.hit_id = this.q;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = str2;
        yYPayRequestModel.pay_from = 1;
        yYGiftModel.hit_id = this.q;
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        BaseYYStudioFragment baseYYStudioFragment = this.m;
        YYPayUtils.a(yYPayRequestModel, payFromSource, baseYYStudioFragment, baseYYStudioFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.adapter.YYImMsgAdapter.18
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str3) {
                yYGiftModel.sendGiftStatus = 2;
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                yYGiftModel.sendGiftStatus = 3;
                YYImMsgAdapter.this.t = yYGiftModel;
                YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid);
                if (yYSeatMemberModel == null) {
                    return;
                }
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, yYPayGoodsModel, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYImModel yYImModel) {
        if (baseViewHolder == null) {
            return;
        }
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 1) {
            G(baseViewHolder, yYImModel);
        } else if (itemViewType == 2) {
            H(baseViewHolder, yYImModel);
        } else if (itemViewType == 3) {
            I(baseViewHolder, yYImModel);
        } else {
            switch (itemViewType) {
                case -10000:
                    g(baseViewHolder, yYImModel);
                    return;
                case 23:
                    t(baseViewHolder, yYImModel);
                    return;
                case 31:
                    o(baseViewHolder, yYImModel);
                    return;
                case 36:
                    m(baseViewHolder, yYImModel);
                    return;
                case 38:
                    l(baseViewHolder, yYImModel);
                    return;
                case 59:
                    k(baseViewHolder, yYImModel);
                    return;
                case 72:
                    j(baseViewHolder, yYImModel);
                    return;
                case 76:
                    i(baseViewHolder, yYImModel);
                    return;
                case 78:
                    h(baseViewHolder, yYImModel);
                    return;
                case 108:
                    c(baseViewHolder, yYImModel);
                    return;
                case 112:
                    b(baseViewHolder, yYImModel);
                    return;
                default:
                    switch (itemViewType) {
                        case -9:
                            e(baseViewHolder, yYImModel);
                            return;
                        case -8:
                            d(baseViewHolder, yYImModel);
                            return;
                        case -7:
                            f(baseViewHolder, yYImModel);
                            return;
                        case -6:
                            v(baseViewHolder, yYImModel);
                            return;
                        case -5:
                            r(baseViewHolder, yYImModel);
                            return;
                        case -4:
                            L(baseViewHolder, yYImModel);
                            return;
                        case -3:
                            K(baseViewHolder, yYImModel);
                            return;
                        case -2:
                            E(baseViewHolder, yYImModel);
                            return;
                        default:
                            switch (itemViewType) {
                                case 5:
                                    u(baseViewHolder, yYImModel);
                                    return;
                                case 6:
                                    B(baseViewHolder, yYImModel);
                                    return;
                                case 7:
                                    A(baseViewHolder, yYImModel);
                                    return;
                                case 8:
                                case 9:
                                    x(baseViewHolder, yYImModel);
                                    return;
                                case 10:
                                    M(baseViewHolder, yYImModel);
                                    return;
                                case 11:
                                    N(baseViewHolder, yYImModel);
                                    return;
                                default:
                                    switch (itemViewType) {
                                        case 14:
                                            D(baseViewHolder, yYImModel);
                                            return;
                                        case 15:
                                            w(baseViewHolder, yYImModel);
                                            return;
                                        case 16:
                                            n(baseViewHolder, yYImModel);
                                            return;
                                        case 17:
                                            y(baseViewHolder, yYImModel);
                                            return;
                                        case 18:
                                            z(baseViewHolder, yYImModel);
                                            return;
                                        case 19:
                                            C(baseViewHolder, yYImModel);
                                            return;
                                        case 20:
                                            J(baseViewHolder, yYImModel);
                                            return;
                                        case 21:
                                            F(baseViewHolder, yYImModel);
                                            return;
                                        default:
                                            switch (itemViewType) {
                                                case 26:
                                                    s(baseViewHolder, yYImModel);
                                                    return;
                                                case 27:
                                                    q(baseViewHolder, yYImModel);
                                                    return;
                                                case 28:
                                                    p(baseViewHolder, yYImModel);
                                                    return;
                                                default:
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        }
    }

    public byte[] a(Bitmap bitmap) {
        byte[] bArr = this.p;
        if (bArr != null) {
            return bArr;
        }
        int[] iArr = {bitmap.getWidth() / 2, (bitmap.getWidth() / 2) + 1};
        int[] iArr2 = {bitmap.getHeight() / 2, (bitmap.getHeight() / 2) + 1};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        for (int i = 0; i < 9; i++) {
            order.putInt(1);
        }
        byte[] array = order.array();
        this.p = array;
        return array;
    }
}
