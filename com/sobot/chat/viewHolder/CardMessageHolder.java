package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/CardMessageHolder.class */
public class CardMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private int defaultPicResId;
    private ConsultingContent mConsultingContent;
    private View mContainer;
    private TextView mDes;
    private TextView mLabel;
    private ImageView mPic;
    private TextView mTitle;

    public CardMessageHolder(Context context, View view) {
        super(context, view);
        this.mContainer = view.findViewById(ResourceUtils.getResId(context, "sobot_rl_hollow_container"));
        this.mPic = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_pic"));
        this.mTitle = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_title"));
        this.mLabel = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_label"));
        this.mDes = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_des"));
        this.defaultPicResId = ResourceUtils.getDrawableId(context, "sobot_icon_consulting_default_pic");
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mConsultingContent = zhiChiMessageBase.getConsultingContent();
        if (zhiChiMessageBase.getConsultingContent() != null) {
            if (TextUtils.isEmpty(CommonUtils.encode(zhiChiMessageBase.getConsultingContent().getSobotGoodsImgUrl()))) {
                this.mPic.setVisibility(8);
            } else {
                this.mPic.setVisibility(0);
                this.mDes.setMaxLines(1);
                this.mDes.setEllipsize(TextUtils.TruncateAt.END);
                String encode = CommonUtils.encode(zhiChiMessageBase.getConsultingContent().getSobotGoodsImgUrl());
                ImageView imageView = this.mPic;
                int i = this.defaultPicResId;
                SobotBitmapUtil.display(context, encode, imageView, i, i);
            }
            this.mTitle.setText(zhiChiMessageBase.getConsultingContent().getSobotGoodsTitle());
            this.mLabel.setText(zhiChiMessageBase.getConsultingContent().getSobotGoodsLable());
            this.mDes.setText(zhiChiMessageBase.getConsultingContent().getSobotGoodsDescribe());
            if (this.isRight) {
                try {
                    this.msgStatus.setClickable(true);
                    if (zhiChiMessageBase.getSendSuccessState() == 1) {
                        this.msgStatus.setVisibility(8);
                        this.msgProgressBar.setVisibility(8);
                    } else if (zhiChiMessageBase.getSendSuccessState() == 0) {
                        this.msgStatus.setVisibility(0);
                        this.msgProgressBar.setVisibility(8);
                    } else if (zhiChiMessageBase.getSendSuccessState() == 2) {
                        this.msgProgressBar.setVisibility(0);
                        this.msgStatus.setVisibility(8);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.mContainer.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view != this.mContainer || this.mConsultingContent == null) {
            return;
        }
        if (SobotOption.hyperlinkListener != null) {
            SobotOption.hyperlinkListener.onUrlClick(this.mConsultingContent.getSobotGoodsFromUrl());
        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(this.mContext, this.mConsultingContent.getSobotGoodsFromUrl())) {
            Intent intent = new Intent(this.mContext, WebViewActivity.class);
            intent.putExtra("url", this.mConsultingContent.getSobotGoodsFromUrl());
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }
}
