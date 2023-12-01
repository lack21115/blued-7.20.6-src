package com.soft.blued.ui.msg.pop;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.utils.ToastUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.model.CardWordCheckModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GiftCardEditPop.class */
public class GiftCardEditPop extends BottomPopupView {
    private EditText b;

    /* renamed from: c  reason: collision with root package name */
    private GiftGivingOptionForJsonParse.CardGift f32476c;

    public GiftCardEditPop(Context context, GiftGivingOptionForJsonParse.CardGift cardGift) {
        super(context);
        this.f32476c = cardGift;
        if (context instanceof Activity) {
            Logger.c(getClass().getSimpleName(), "SOFT_INPUT_ADJUST_NOTHING");
            ((Activity) context).getWindow().setSoftInputMode(48);
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        this.b = (EditText) findViewById(R.id.et_content);
        GiftGivingOptionForJsonParse.CardGift cardGift = this.f32476c;
        if (cardGift != null && !TextUtils.isEmpty(cardGift.text)) {
            this.b.setText(this.f32476c.text);
        }
        EditText editText = this.b;
        editText.setSelection(editText.getText().length());
        final EditText editText2 = (EditText) findViewById(R.id.et_to);
        final EditText editText3 = (EditText) findViewById(R.id.et_from);
        ((TextView) findViewById(2131372161)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftCardEditPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.isEmpty(GiftCardEditPop.this.b.getText().toString()) || TextUtils.isEmpty(editText3.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {
                    ToastUtils.a(GiftCardEditPop.this.getResources().getString(R.string.msg_card_gift_content_empty));
                    return;
                }
                BluedUIHttpResponse<BluedEntityA<CardWordCheckModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<CardWordCheckModel>>(null) { // from class: com.soft.blued.ui.msg.pop.GiftCardEditPop.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<CardWordCheckModel> bluedEntityA) {
                        if (bluedEntityA.hasData()) {
                            if (!bluedEntityA.data.get(0).validation) {
                                ToastUtils.a(GiftCardEditPop.this.getResources().getString(R.string.msg_card_gift_content_sensitive));
                                return;
                            }
                            GiftGivingOptionForJsonParse.CardGift cardGift2 = new GiftGivingOptionForJsonParse.CardGift();
                            cardGift2.from = editText3.getText().toString();
                            cardGift2.to = editText2.getText().toString();
                            cardGift2.text = GiftCardEditPop.this.b.getText().toString();
                            LiveEventBus.get(EventBusConstant.KEY_EVENT_CARD_EDIT).post(cardGift2);
                            GiftCardEditPop.this.p();
                        }
                    }
                };
                ChatHttpUtils.a(bluedUIHttpResponse, GiftCardEditPop.this.b.getText().toString() + editText3.getText().toString() + editText2.getText().toString());
            }
        });
        ((TextView) findViewById(R.id.tv_office)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftCardEditPop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GiftCardEditPop.this.b.setText(BlueAppLocal.d() ? "CN".equals(BlueAppLocal.c().getCountry().toUpperCase()) ? GiftCardEditPop.this.f32476c.text_zh_cn : GiftCardEditPop.this.f32476c.text_zh_tw : GiftCardEditPop.this.f32476c.text_en_us);
                GiftCardEditPop.this.b.setSelection(GiftCardEditPop.this.b.getText().toString().length());
            }
        });
        GiftGivingOptionForJsonParse.CardGift cardGift2 = this.f32476c;
        if (cardGift2 != null) {
            editText2.setText(cardGift2.to);
            editText2.setSelection(editText2.getText().toString().length());
            editText3.setText(this.f32476c.from);
            editText3.setSelection(editText3.getText().toString().length());
        }
        this.b.setFilters(new InputFilter[]{new InputFilter() { // from class: com.soft.blued.ui.msg.pop.GiftCardEditPop.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5;
                int i6;
                String obj = spanned.toString();
                char[] charArray = obj.toCharArray();
                int length = charArray.length;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    i5 = i8;
                    if (i7 >= length) {
                        break;
                    }
                    char c2 = charArray[i7];
                    if (c2 != '\n') {
                        i6 = i5;
                        if (c2 != '\r') {
                            Logger.c("GiftCardEditPop", Integer.valueOf(c2));
                            i7++;
                            i8 = i6;
                        }
                    }
                    i6 = i5 + 1;
                    Logger.c("GiftCardEditPop", Integer.valueOf(c2));
                    i7++;
                    i8 = i6;
                }
                if (GiftCardEditPop.this.b.getHeight() >= DensityUtil.a(50.0f)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) GiftCardEditPop.this.b.getLayoutParams();
                    layoutParams.height = DensityUtil.a(50.0f);
                    GiftCardEditPop.this.b.setLayoutParams(layoutParams);
                }
                if (i5 < 7) {
                    if ((((Object) charSequence) + obj).length() > 100) {
                        return "";
                    }
                    return null;
                }
                return "";
            }
        }});
        editText2.clearFocus();
        editText3.clearFocus();
        this.b.requestFocus();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_gift_card_edit;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
        if (getContext() instanceof Activity) {
            Logger.c(getClass().getSimpleName(), "SOFT_INPUT_ADJUST_RESIZE");
            ((Activity) getContext()).getWindow().setSoftInputMode(16);
        }
    }
}
