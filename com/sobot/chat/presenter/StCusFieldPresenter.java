package com.sobot.chat.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.igexin.push.core.b;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.SobotChooseCityActivity;
import com.sobot.chat.activity.SobotCusFieldActivity;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotProvinInfo;
import com.sobot.chat.listener.ISobotCusField;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/presenter/StCusFieldPresenter.class */
public class StCusFieldPresenter {
    public static void addWorkOrderCusFields(Activity activity, final Context context, ArrayList<SobotFieldModel> arrayList, ViewGroup viewGroup, final ISobotCusField iSobotCusField) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            final SobotFieldModel sobotFieldModel = arrayList.get(i2);
            final SobotCusFieldConfig cusFieldConfig = sobotFieldModel.getCusFieldConfig();
            if (cusFieldConfig != null) {
                View inflate = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_post_msg_cusfield_list_item"), null);
                inflate.setTag(cusFieldConfig.getFieldId());
                inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_bootom_line")).setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_more_relativelayout"));
                final TextView textView = (TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_more_text_lable"));
                final TextView textView2 = (TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_edit_hint_text_label_2"));
                textView2.setText(ResourceUtils.getResString(context, "sobot_please_input"));
                textView2.setVisibility(8);
                displayInNotch(activity, textView);
                displayInNotch(activity, textView2);
                final EditText editText = (EditText) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_more_content"));
                displayInNotch(activity, editText);
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.2
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        Tracker.onFocusChange(view, z);
                        if (z) {
                            TextView textView3 = textView;
                            Context context2 = context;
                            textView3.setTextColor(ContextCompat.getColor(context2, ResourceUtils.getResColorId(context2, "sobot_common_gray2")));
                            textView.setTextSize(12.0f);
                            textView2.setVisibility(8);
                            EditText.this.setVisibility(0);
                        } else if (StringUtils.isEmpty(EditText.this.getText().toString().trim())) {
                            textView.setTextSize(14.0f);
                            TextView textView4 = textView;
                            Context context3 = context;
                            textView4.setTextColor(ContextCompat.getColor(context3, ResourceUtils.getResColorId(context3, "sobot_common_gray1")));
                            EditText.this.setVisibility(8);
                            textView2.setVisibility(0);
                        }
                    }
                });
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text"));
                final TextView textView3 = (TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_lable"));
                final TextView textView4 = (TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_edit_hint_text_label"));
                textView4.setText(ResourceUtils.getResString(context, "sobot_please_input"));
                textView4.setVisibility(8);
                displayInNotch(activity, textView3);
                displayInNotch(activity, textView4);
                TextView textView5 = (TextView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_date_text_click"));
                EditText editText2 = (EditText) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_content"));
                final EditText editText3 = (EditText) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_number"));
                EditText editText4 = (EditText) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_single"));
                ImageView imageView = (ImageView) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_img"));
                final LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_ll"));
                displayInNotch(activity, editText3);
                displayInNotch(activity, editText4);
                displayInNotch(activity, editText2);
                displayInNotch(activity, textView5);
                if (1 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(8);
                    imageView.setVisibility(8);
                    linearLayout2.setVisibility(0);
                    textView4.setVisibility(0);
                    editText3.setVisibility(8);
                    editText2.setVisibility(8);
                    editText4.setVisibility(0);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                    if (!StringUtils.isEmpty(cusFieldConfig.getLimitChar())) {
                        editText4.setMaxLines(Integer.parseInt(cusFieldConfig.getLimitChar()));
                    }
                    editText4.setSingleLine(true);
                    editText4.setMaxEms(11);
                    editText4.setInputType(1);
                    if (!StringUtils.isEmpty(cusFieldConfig.getLimitOptions())) {
                        if (cusFieldConfig.getLimitOptions().contains("6") && !StringUtils.isEmpty(cusFieldConfig.getLimitChar())) {
                            editText4.setMaxLines(Integer.parseInt(cusFieldConfig.getLimitChar()));
                        }
                        if (cusFieldConfig.getLimitOptions().contains("5")) {
                            editText4.setInputType(2);
                        }
                        if (cusFieldConfig.getLimitOptions().contains("7")) {
                            editText4.setInputType(32);
                        }
                        if (cusFieldConfig.getLimitOptions().contains("8")) {
                            editText4.setInputType(3);
                        }
                        editText4.addTextChangedListener(new TextWatcher() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.3
                            private CharSequence temp;

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                if (editable.length() == 0) {
                                    return;
                                }
                                if (SobotCusFieldConfig.this.getLimitOptions().contains("6") && !StringUtils.isEmpty(SobotCusFieldConfig.this.getLimitChar()) && this.temp.length() > Integer.parseInt(SobotCusFieldConfig.this.getLimitChar())) {
                                    Context context2 = context;
                                    ToastUtil.showCustomToast(context2, SobotCusFieldConfig.this.getFieldName() + ResourceUtils.getResString(context, "sobot_only_can_write") + Integer.parseInt(SobotCusFieldConfig.this.getLimitChar()) + ResourceUtils.getResString(context, "sobot_char_length"));
                                    editable.delete(this.temp.length() - 1, this.temp.length());
                                }
                                if (!SobotCusFieldConfig.this.getLimitOptions().contains("4") || Pattern.compile("^[a-zA-Z0-9一-龥]+$").matcher(editable).matches()) {
                                    return;
                                }
                                Context context3 = context;
                                ToastUtil.showCustomToast(context3, SobotCusFieldConfig.this.getFieldName() + ResourceUtils.getResString(context, "sobot_only_can_write") + ResourceUtils.getResString(context, "sobot_number_english_china"));
                                this.temp.length();
                                editable.delete(this.temp.length() - 1, this.temp.length());
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                                this.temp = charSequence;
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                            }
                        });
                    }
                } else if (2 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(0);
                    textView2.setVisibility(0);
                    editText.setVisibility(8);
                    linearLayout2.setVisibility(8);
                    imageView.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView.setText(cusFieldConfig.getFieldName());
                    }
                    editText.setInputType(1);
                    editText.setInputType(131072);
                    editText.setGravity(48);
                    editText.setSingleLine(false);
                    editText.setHorizontallyScrolling(false);
                } else if (3 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    imageView.setVisibility(0);
                    editText4.setVisibility(8);
                    editText2.setVisibility(8);
                    editText3.setVisibility(8);
                    textView3.setText(cusFieldConfig.getFieldName());
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                } else if (4 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    imageView.setVisibility(0);
                    editText2.setVisibility(8);
                    editText3.setVisibility(8);
                    editText4.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                } else if (5 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(8);
                    linearLayout2.setVisibility(0);
                    textView4.setVisibility(0);
                    editText4.setVisibility(8);
                    imageView.setVisibility(8);
                    editText2.setVisibility(8);
                    editText3.setVisibility(0);
                    editText3.setSingleLine(true);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                    editText3.setInputType(2);
                    if (StringUtils.isEmpty(cusFieldConfig.getLimitOptions()) || !"[3]".equals(cusFieldConfig.getLimitOptions())) {
                        editText3.setInputType(2);
                    } else {
                        editText3.setInputType(8194);
                        editText3.addTextChangedListener(new TextWatcher() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.4
                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                                CharSequence charSequence2 = charSequence;
                                if (charSequence.toString().contains(".")) {
                                    charSequence2 = charSequence;
                                    if ((charSequence.length() - 1) - charSequence.toString().indexOf(".") > 2) {
                                        charSequence2 = charSequence.toString().subSequence(0, charSequence.toString().indexOf(".") + 3);
                                        EditText.this.setText(charSequence2);
                                        EditText.this.setSelection(charSequence2.length());
                                    }
                                }
                                String str = charSequence2;
                                if (charSequence2.toString().trim().substring(0).equals(".")) {
                                    str = "0" + ((Object) charSequence2);
                                    EditText.this.setText(str);
                                    EditText.this.setSelection(2);
                                }
                                if (!str.toString().startsWith("0") || str.toString().trim().length() <= 1 || str.toString().substring(1, 2).equals(".")) {
                                    return;
                                }
                                EditText.this.setText(str.subSequence(0, 1));
                                EditText.this.setSelection(1);
                            }
                        });
                    }
                } else if (8 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    editText3.setVisibility(8);
                    editText4.setVisibility(8);
                    imageView.setVisibility(0);
                    editText2.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                } else if (6 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    imageView.setVisibility(0);
                    editText3.setVisibility(8);
                    editText2.setVisibility(8);
                    editText4.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                } else if (7 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    imageView.setVisibility(0);
                    editText2.setVisibility(8);
                    editText4.setVisibility(8);
                    editText3.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                } else if (9 == cusFieldConfig.getFieldType()) {
                    linearLayout.setVisibility(8);
                    textView5.setVisibility(0);
                    linearLayout2.setVisibility(0);
                    editText3.setVisibility(8);
                    editText4.setVisibility(8);
                    imageView.setVisibility(0);
                    editText2.setVisibility(8);
                    if (1 == cusFieldConfig.getFillFlag()) {
                        textView3.setText(Html.fromHtml(cusFieldConfig.getFieldName() + "<font color='#f9676f'>&nbsp;*</font>"));
                    } else {
                        textView3.setText(cusFieldConfig.getFieldName());
                    }
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (2 != SobotCusFieldConfig.this.getFieldType()) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= linearLayout3.getChildCount()) {
                                    break;
                                }
                                if ((linearLayout3.getChildAt(i4) instanceof EditText) && linearLayout3.getChildAt(i4).getVisibility() == 0) {
                                    linearLayout3.setVisibility(0);
                                    TextView textView6 = textView3;
                                    Context context2 = context;
                                    textView6.setTextColor(ContextCompat.getColor(context2, ResourceUtils.getResColorId(context2, "sobot_common_gray2")));
                                    textView3.setTextSize(12.0f);
                                    textView4.setVisibility(8);
                                    final EditText editText5 = (EditText) linearLayout3.getChildAt(i4);
                                    editText5.setFocusable(true);
                                    KeyboardUtil.showKeyboard(editText5);
                                    editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.5.1
                                        @Override // android.view.View.OnFocusChangeListener
                                        public void onFocusChange(View view2, boolean z) {
                                            Tracker.onFocusChange(view2, z);
                                            if (z) {
                                                textView4.setVisibility(8);
                                            } else if (StringUtils.isEmpty(editText5.getText().toString().trim())) {
                                                textView3.setTextSize(14.0f);
                                                textView3.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray1")));
                                                linearLayout3.setVisibility(8);
                                                textView4.setVisibility(0);
                                            }
                                        }
                                    });
                                }
                                i3 = i4 + 1;
                            }
                        } else {
                            textView2.setVisibility(8);
                            editText.setVisibility(0);
                            editText.setFocusableInTouchMode(true);
                            editText.setFocusable(true);
                            editText.requestFocus();
                        }
                        ISobotCusField iSobotCusField2 = iSobotCusField;
                        if (iSobotCusField2 != null) {
                            iSobotCusField2.onClickCusField(view, SobotCusFieldConfig.this.getFieldType(), sobotFieldModel);
                        }
                    }
                });
                viewGroup.addView(inflate);
            }
            i = i2 + 1;
        }
    }

    public static void displayInNotch(Activity activity, final View view) {
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
            NotchScreenManager.getInstance().getNotchInfo(activity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.presenter.StCusFieldPresenter.1
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                    if (notchScreenInfo.hasNotch) {
                        for (Rect rect : notchScreenInfo.notchRects) {
                            View view2 = View.this;
                            int i = 110;
                            if (rect.right <= 110) {
                                i = rect.right;
                            }
                            view2.setPadding(i, View.this.getPaddingTop(), View.this.getPaddingRight(), View.this.getPaddingBottom());
                        }
                    }
                }
            });
        }
    }

    public static String formatCusFieldVal(Context context, ViewGroup viewGroup, List<SobotFieldModel> list) {
        View findViewWithTag;
        if (list == null || list.size() == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return "";
            }
            if (list.get(i2).getCusFieldConfig() != null && (findViewWithTag = viewGroup.findViewWithTag(list.get(i2).getCusFieldConfig().getFieldId())) != null) {
                if (1 == list.get(i2).getCusFieldConfig().getFieldType()) {
                    EditText editText = (EditText) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_single"));
                    SobotCusFieldConfig cusFieldConfig = list.get(i2).getCusFieldConfig();
                    cusFieldConfig.setValue(((Object) editText.getText()) + "");
                    if (StringUtils.isNumber(list.get(i2).getCusFieldConfig().getLimitOptions()) && list.get(i2).getCusFieldConfig().getLimitOptions().contains("7") && !ScreenUtils.isEmail(editText.getText().toString().trim())) {
                        return list.get(i2).getCusFieldConfig().getFieldName() + ResourceUtils.getResString(context, "sobot_input_type_err_email");
                    } else if (StringUtils.isNumber(list.get(i2).getCusFieldConfig().getLimitOptions()) && list.get(i2).getCusFieldConfig().getLimitOptions().contains("8") && !ScreenUtils.isMobileNO(editText.getText().toString().trim())) {
                        return list.get(i2).getCusFieldConfig().getFieldName() + ResourceUtils.getResString(context, "sobot_phone") + ResourceUtils.getResString(context, "sobot_input_type_err");
                    }
                } else if (2 == list.get(i2).getCusFieldConfig().getFieldType()) {
                    EditText editText2 = (EditText) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_more_content"));
                    SobotCusFieldConfig cusFieldConfig2 = list.get(i2).getCusFieldConfig();
                    cusFieldConfig2.setValue(((Object) editText2.getText()) + "");
                } else if (4 == list.get(i2).getCusFieldConfig().getFieldType() || 3 == list.get(i2).getCusFieldConfig().getFieldType()) {
                    TextView textView = (TextView) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_date_text_click"));
                    SobotCusFieldConfig cusFieldConfig3 = list.get(i2).getCusFieldConfig();
                    cusFieldConfig3.setValue(((Object) textView.getText()) + "");
                } else if (5 == list.get(i2).getCusFieldConfig().getFieldType()) {
                    EditText editText3 = (EditText) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_number"));
                    SobotCusFieldConfig cusFieldConfig4 = list.get(i2).getCusFieldConfig();
                    cusFieldConfig4.setValue(((Object) editText3.getText()) + "");
                    if (StringUtils.isNumber(list.get(i2).getCusFieldConfig().getLimitOptions()) && list.get(i2).getCusFieldConfig().getLimitOptions().contains("3") && !StringUtils.isNumber(editText3.getText().toString().trim())) {
                        return list.get(i2).getCusFieldConfig().getFieldName() + ResourceUtils.getResString(context, "sobot_input_type_err");
                    }
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
    }

    public static String getCusFieldVal(ArrayList<SobotFieldModel> arrayList, SobotProvinInfo.SobotProvinceModel sobotProvinceModel) {
        HashMap hashMap = new HashMap();
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                SobotCusFieldConfig cusFieldConfig = arrayList.get(i2).getCusFieldConfig();
                if (cusFieldConfig != null && !StringUtils.isEmpty(cusFieldConfig.getFieldId()) && !StringUtils.isEmpty(cusFieldConfig.getValue())) {
                    hashMap.put(arrayList.get(i2).getCusFieldConfig().getFieldId(), arrayList.get(i2).getCusFieldConfig().getValue());
                }
                i = i2 + 1;
            }
        }
        if (sobotProvinceModel != null) {
            hashMap.put("proviceId", sobotProvinceModel.provinceId);
            hashMap.put("proviceName", sobotProvinceModel.provinceName);
            hashMap.put("cityId", sobotProvinceModel.cityId);
            hashMap.put("cityName", sobotProvinceModel.cityName);
            hashMap.put("areaId", sobotProvinceModel.areaId);
            hashMap.put("areaName", sobotProvinceModel.areaName);
        }
        if (hashMap.size() > 0) {
            return GsonUtil.map2Json(hashMap);
        }
        return null;
    }

    public static Map getSaveFieldNameAndVal(ArrayList<SobotFieldModel> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return hashMap;
            }
            if (arrayList.get(i2).getCusFieldConfig() != null) {
                hashMap.put(arrayList.get(i2).getCusFieldConfig().getFieldName(), TextUtils.isEmpty(arrayList.get(i2).getCusFieldConfig().getShowName()) ? arrayList.get(i2).getCusFieldConfig().getValue() : arrayList.get(i2).getCusFieldConfig().getShowName());
            }
            i = i2 + 1;
        }
    }

    public static String getSaveFieldVal(ArrayList<SobotFieldModel> arrayList) {
        ArrayList arrayList2;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList2 = arrayList3;
                if (i2 >= arrayList.size()) {
                    break;
                }
                HashMap hashMap = new HashMap();
                SobotCusFieldConfig cusFieldConfig = arrayList.get(i2).getCusFieldConfig();
                if (cusFieldConfig != null && !StringUtils.isEmpty(cusFieldConfig.getFieldId()) && !StringUtils.isEmpty(cusFieldConfig.getValue())) {
                    hashMap.put("id", arrayList.get(i2).getCusFieldConfig().getFieldId());
                    hashMap.put("value", arrayList.get(i2).getCusFieldConfig().getValue());
                    hashMap.put("text", arrayList.get(i2).getCusFieldConfig().getShowName());
                    arrayList3.add(hashMap);
                }
                i = i2 + 1;
            }
        } else {
            arrayList2 = null;
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return null;
        }
        return new JSONArray((Collection) arrayList2).toString();
    }

    public static void onStCusFieldActivityResult(Context context, Intent intent, ArrayList<SobotFieldModel> arrayList, ViewGroup viewGroup) {
        if (intent == null || !"CATEGORYSMALL".equals(intent.getStringExtra("CATEGORYSMALL")) || -1 == intent.getIntExtra("fieldType", -1)) {
            return;
        }
        String stringExtra = intent.getStringExtra("category_typeName");
        String stringExtra2 = intent.getStringExtra("category_fieldId");
        if (b.l.equals(stringExtra2) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        String stringExtra3 = intent.getStringExtra("category_typeValue");
        if (arrayList == null || StringUtils.isEmpty(stringExtra) || StringUtils.isEmpty(stringExtra3)) {
            if (StringUtils.isEmpty(stringExtra3)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    SobotCusFieldConfig cusFieldConfig = arrayList.get(i2).getCusFieldConfig();
                    if (cusFieldConfig != null && cusFieldConfig.getFieldId() != null && cusFieldConfig.getFieldId().equals(stringExtra2)) {
                        cusFieldConfig.setChecked(false);
                        cusFieldConfig.setValue(stringExtra3);
                        cusFieldConfig.setId(stringExtra2);
                    }
                    i = i2 + 1;
                }
            }
            View findViewWithTag = viewGroup.findViewWithTag(stringExtra2);
            if (findViewWithTag != null) {
                TextView textView = (TextView) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_date_text_click"));
                String str = stringExtra;
                if (stringExtra.endsWith(",")) {
                    str = stringExtra.substring(0, stringExtra.length() - 1);
                }
                textView.setText(str);
                TextView textView2 = (TextView) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_lable"));
                ((LinearLayout) findViewWithTag.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_ll"))).setVisibility(8);
                textView2.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray1")));
                textView2.setTextSize(14.0f);
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                return;
            }
            SobotCusFieldConfig cusFieldConfig2 = arrayList.get(i4).getCusFieldConfig();
            if (cusFieldConfig2 != null && cusFieldConfig2.getFieldId() != null && cusFieldConfig2.getFieldId().equals(stringExtra2)) {
                cusFieldConfig2.setChecked(true);
                cusFieldConfig2.setValue(stringExtra3);
                cusFieldConfig2.setId(stringExtra2);
                View findViewWithTag2 = viewGroup.findViewWithTag(cusFieldConfig2.getFieldId());
                ((TextView) findViewWithTag2.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_date_text_click"))).setText(stringExtra.endsWith(",") ? stringExtra.substring(0, stringExtra.length() - 1) : stringExtra);
                cusFieldConfig2.setShowName(stringExtra.endsWith(",") ? stringExtra.substring(0, stringExtra.length() - 1) : stringExtra);
                TextView textView3 = (TextView) findViewWithTag2.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_lable"));
                ((LinearLayout) findViewWithTag2.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_ll"))).setVisibility(0);
                textView3.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
                textView3.setTextSize(12.0f);
            }
            i3 = i4 + 1;
        }
    }

    public static void openTimePicker(Activity activity, View view, int i) {
        Date date;
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(view.getContext(), "id", "work_order_customer_date_text_click"));
        String charSequence = textView.getText().toString();
        if (StringUtils.isEmpty(charSequence)) {
            date = null;
        } else {
            date = DateUtil.parse(charSequence, i == 3 ? DateUtil.DATE_FORMAT2 : DateUtil.DATE_FORMAT0);
        }
        KeyboardUtil.hideKeyboard(textView);
        DateUtil.openTimePickerView(activity, view, textView, date, i == 3 ? 0 : 1);
    }

    public static void startChooseCityAct(Activity activity, SobotProvinInfo sobotProvinInfo, SobotFieldModel sobotFieldModel) {
        Intent intent = new Intent(activity, SobotChooseCityActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("cusFieldConfig", sobotFieldModel.getCusFieldConfig());
        bundle.putSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_PROVININFO, sobotProvinInfo);
        SobotCusFieldConfig cusFieldConfig = sobotFieldModel.getCusFieldConfig();
        if (cusFieldConfig != null) {
            bundle.putSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD_ID, cusFieldConfig.getFieldId());
        }
        intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA, bundle);
        activity.startActivityForResult(intent, 106);
    }

    public static void startSobotCusFieldActivity(Activity activity, Fragment fragment, SobotFieldModel sobotFieldModel) {
        SobotCusFieldConfig cusFieldConfig = sobotFieldModel.getCusFieldConfig();
        Intent intent = new Intent(activity, SobotCusFieldActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("fieldType", cusFieldConfig.getFieldType());
        bundle.putSerializable("cusFieldConfig", cusFieldConfig);
        bundle.putSerializable("cusFieldList", sobotFieldModel);
        intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
        if (fragment != null) {
            fragment.startActivityForResult(intent, cusFieldConfig.getFieldType());
        } else {
            activity.startActivityForResult(intent, cusFieldConfig.getFieldType());
        }
    }

    public static void startSobotCusFieldActivity(Activity activity, SobotFieldModel sobotFieldModel) {
        startSobotCusFieldActivity(activity, null, sobotFieldModel);
    }
}
