package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/OrderCardMessageHolder.class */
public class OrderCardMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private int defaultPicResId;
    private View mContainer;
    private TextView mGoodsCount;
    private View mGoodsOrderSplit;
    private TextView mGoodsTotalMoney;
    private TextView mOrderCreatetime;
    private TextView mOrderNumber;
    private TextView mOrderStatus;
    private SobotRCImageView mPic;
    private TextView mTitle;
    private OrderCardContentModel orderCardContent;

    public OrderCardMessageHolder(Context context, View view) {
        super(context, view);
        this.mContainer = view.findViewById(ResourceUtils.getResId(context, "sobot_rl_hollow_container"));
        this.mPic = (SobotRCImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_pic"));
        this.mTitle = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_title"));
        this.mGoodsCount = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_count"));
        this.mGoodsTotalMoney = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_goods_total_money"));
        this.mGoodsOrderSplit = view.findViewById(ResourceUtils.getResId(context, "sobot_goods_order_split"));
        this.mOrderStatus = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_order_status"));
        this.mOrderNumber = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_order_number"));
        this.mOrderCreatetime = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_order_createtime"));
        this.defaultPicResId = ResourceUtils.getDrawableId(context, "sobot_icon_consulting_default_pic");
    }

    private String getMoney(int i) {
        if (this.mContext == null) {
            return "";
        }
        return "" + (i / 100.0f);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        String resString;
        OrderCardContentModel orderCardContent = zhiChiMessageBase.getOrderCardContent();
        this.orderCardContent = orderCardContent;
        if (orderCardContent != null) {
            if (orderCardContent.getGoods() == null || this.orderCardContent.getGoods().size() <= 0) {
                this.mPic.setVisibility(8);
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                OrderCardContentModel.Goods goods = this.orderCardContent.getGoods().get(0);
                if (goods != null) {
                    if (TextUtils.isEmpty(goods.getPictureUrl())) {
                        this.mPic.setVisibility(8);
                    } else {
                        this.mPic.setVisibility(0);
                        String encode = CommonUtils.encode(goods.getPictureUrl());
                        SobotRCImageView sobotRCImageView = this.mPic;
                        int i = this.defaultPicResId;
                        SobotBitmapUtil.display(context, encode, sobotRCImageView, i, i);
                    }
                    if (TextUtils.isEmpty(goods.getName())) {
                        this.mTitle.setVisibility(8);
                    } else {
                        this.mTitle.setVisibility(0);
                        this.mTitle.setText(goods.getName());
                    }
                }
            }
            if ((this.orderCardContent.getGoods() == null || this.orderCardContent.getGoods().size() <= 0) && TextUtils.isEmpty(this.orderCardContent.getGoodsCount()) && this.orderCardContent.getTotalFee() <= 0) {
                this.mGoodsOrderSplit.setVisibility(8);
            } else {
                this.mGoodsOrderSplit.setVisibility(0);
            }
            if (this.orderCardContent.getOrderStatus() != 0) {
                this.mOrderStatus.setVisibility(0);
                switch (this.orderCardContent.getOrderStatus()) {
                    case 1:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_1");
                        break;
                    case 2:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_2");
                        break;
                    case 3:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_3");
                        break;
                    case 4:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_4");
                        break;
                    case 5:
                        resString = ResourceUtils.getResString(context, "sobot_completed");
                        break;
                    case 6:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_6");
                        break;
                    case 7:
                        resString = ResourceUtils.getResString(context, "sobot_order_status_7");
                        break;
                    default:
                        resString = "";
                        break;
                }
                TextView textView = this.mOrderStatus;
                textView.setText("：" + resString);
            } else if (TextUtils.isEmpty(this.orderCardContent.getStatusCustom())) {
                this.mOrderStatus.setVisibility(8);
            } else {
                this.mOrderStatus.setVisibility(0);
                TextView textView2 = this.mOrderStatus;
                textView2.setText("：" + this.orderCardContent.getStatusCustom());
            }
            this.mGoodsTotalMoney.setVisibility(0);
            TextView textView3 = this.mGoodsTotalMoney;
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.isEmpty(this.orderCardContent.getGoodsCount()) ? "" : ",");
            sb.append(ResourceUtils.getResString(context, "sobot_order_total_money"));
            sb.append(getMoney(this.orderCardContent.getTotalFee()));
            sb.append(ResourceUtils.getResString(context, "sobot_money_format"));
            textView3.setText(sb.toString());
            if (TextUtils.isEmpty(this.orderCardContent.getGoodsCount())) {
                this.mGoodsCount.setVisibility(8);
            } else {
                this.mGoodsCount.setVisibility(0);
                TextView textView4 = this.mGoodsCount;
                textView4.setText(this.orderCardContent.getGoodsCount() + ResourceUtils.getResString(context, "sobot_how_goods"));
            }
            if (TextUtils.isEmpty(this.orderCardContent.getOrderCode())) {
                this.mOrderNumber.setVisibility(8);
            } else {
                TextView textView5 = this.mOrderNumber;
                textView5.setText(ResourceUtils.getResString(context, "sobot_order_code_lable") + "：" + this.orderCardContent.getOrderCode());
                this.mOrderNumber.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.orderCardContent.getCreateTime())) {
                this.mOrderCreatetime.setVisibility(8);
            } else {
                TextView textView6 = this.mOrderCreatetime;
                textView6.setText(ResourceUtils.getResString(context, "sobot_order_time_lable") + "：" + DateUtil.longToDateStr(Long.valueOf(Long.parseLong(this.orderCardContent.getCreateTime())), "yyyy-MM-dd HH:mm:ss"));
                this.mOrderCreatetime.setVisibility(0);
            }
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
        OrderCardContentModel orderCardContentModel;
        Tracker.onClick(view);
        if (view != this.mContainer || (orderCardContentModel = this.orderCardContent) == null) {
            return;
        }
        if (TextUtils.isEmpty(orderCardContentModel.getOrderUrl())) {
            LogUtils.i("订单卡片跳转链接为空，不跳转，不拦截");
        } else if (SobotOption.orderCardListener != null) {
            SobotOption.orderCardListener.onClickOrderCradMsg(this.orderCardContent);
        } else if (SobotOption.hyperlinkListener != null) {
            SobotOption.hyperlinkListener.onUrlClick(this.orderCardContent.getOrderUrl());
        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(this.mContext, this.orderCardContent.getOrderUrl())) {
            Intent intent = new Intent(this.mContext, WebViewActivity.class);
            intent.putExtra("url", this.orderCardContent.getOrderUrl());
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }
}
