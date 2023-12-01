package com.sobot.chat.widget.timePicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.timePicker.lib.SobotWheelView;
import com.sobot.chat.widget.timePicker.listener.SobotCustomListener;
import com.sobot.chat.widget.timePicker.view.SobotBasePickerView;
import com.sobot.chat.widget.timePicker.view.SobotWheelTime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/SobotTimePickerView.class */
public class SobotTimePickerView extends SobotBasePickerView implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private int Color_Background_Title;
    private int Color_Background_Wheel;
    private int Color_Cancel;
    private int Color_Submit;
    private int Color_Title;
    private int Size_Content;
    private int Size_Submit_Cancel;
    private int Size_Title;
    private String Str_Cancel;
    private String Str_Submit;
    private String Str_Title;
    private int backgroundId;
    private ImageView btnCancel;
    private Button btnSubmit;
    private boolean cancelable;
    private SobotCustomListener customListener;
    private boolean cyclic;
    private Calendar date;
    private int dividerColor;
    private SobotWheelView.DividerType dividerType;
    private Calendar endDate;
    private int endYear;
    private int gravity;
    private boolean isCenterLabel;
    private boolean isDialog;
    private String label_day;
    private String label_hours;
    private String label_mins;
    private String label_month;
    private String label_seconds;
    private String label_year;
    private String layoutRes;
    private float lineSpacingMultiplier;
    private Calendar startDate;
    private int startYear;
    private int textColorCenter;
    private int textColorOut;
    private OnTimeSelectListener timeSelectListener;
    private TextView tvTitle;
    private boolean[] type;
    SobotWheelTime wheelTime;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/SobotTimePickerView$Builder.class */
    public static class Builder {
        private int Color_Background_Title;
        private int Color_Background_Wheel;
        private int Color_Cancel;
        private int Color_Submit;
        private int Color_Title;
        private String Str_Cancel;
        private String Str_Submit;
        private String Str_Title;
        private int backgroundId;
        private Context context;
        private SobotCustomListener customListener;
        private Calendar date;
        public ViewGroup decorView;
        private int dividerColor;
        private SobotWheelView.DividerType dividerType;
        private Calendar endDate;
        private int endYear;
        private boolean isDialog;
        private String label_day;
        private String label_hours;
        private String label_mins;
        private String label_month;
        private String label_seconds;
        private String label_year;
        private Calendar startDate;
        private int startYear;
        private int textColorCenter;
        private int textColorOut;
        private OnTimeSelectListener timeSelectListener;
        private String layoutRes = "sobot_pickerview_time";
        private boolean[] type = {true, true, true, true, true, true};
        private int gravity = 17;
        private int Size_Submit_Cancel = 17;
        private int Size_Title = 18;
        private int Size_Content = 18;
        private boolean cyclic = false;
        private boolean cancelable = true;
        private boolean isCenterLabel = true;
        private float lineSpacingMultiplier = 1.6f;

        public Builder(Context context, OnTimeSelectListener onTimeSelectListener) {
            this.context = context;
            this.timeSelectListener = onTimeSelectListener;
        }

        public SobotTimePickerView build() {
            return new SobotTimePickerView(this);
        }

        public Builder gravity(int i) {
            this.gravity = i;
            return this;
        }

        public Builder isCenterLabel(boolean z) {
            this.isCenterLabel = z;
            return this;
        }

        public Builder isCyclic(boolean z) {
            this.cyclic = z;
            return this;
        }

        public Builder isDialog(boolean z) {
            this.isDialog = z;
            return this;
        }

        public Builder setBackgroundId(int i) {
            this.backgroundId = i;
            return this;
        }

        public Builder setBgColor(int i) {
            this.Color_Background_Wheel = i;
            return this;
        }

        public Builder setCancelColor(int i) {
            this.Color_Cancel = i;
            return this;
        }

        public Builder setCancelText(String str) {
            this.Str_Cancel = str;
            return this;
        }

        public Builder setContentSize(int i) {
            this.Size_Content = i;
            return this;
        }

        public Builder setDate(Calendar calendar) {
            this.date = calendar;
            return this;
        }

        public Builder setDecorView(ViewGroup viewGroup) {
            this.decorView = viewGroup;
            return this;
        }

        public Builder setDividerColor(int i) {
            this.dividerColor = i;
            return this;
        }

        public Builder setDividerType(SobotWheelView.DividerType dividerType) {
            this.dividerType = dividerType;
            return this;
        }

        public Builder setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
            this.label_year = str;
            this.label_month = str2;
            this.label_day = str3;
            this.label_hours = str4;
            this.label_mins = str5;
            this.label_seconds = str6;
            return this;
        }

        public Builder setLayoutRes(String str, SobotCustomListener sobotCustomListener) {
            this.layoutRes = str;
            this.customListener = sobotCustomListener;
            return this;
        }

        public Builder setLineSpacingMultiplier(float f) {
            this.lineSpacingMultiplier = f;
            return this;
        }

        public Builder setOutSideCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public Builder setRangDate(Calendar calendar, Calendar calendar2) {
            this.startDate = calendar;
            this.endDate = calendar2;
            return this;
        }

        public Builder setRange(int i, int i2) {
            this.startYear = i;
            this.endYear = i2;
            return this;
        }

        public Builder setSubCalSize(int i) {
            this.Size_Submit_Cancel = i;
            return this;
        }

        public Builder setSubmitColor(int i) {
            this.Color_Submit = i;
            return this;
        }

        public Builder setSubmitText(String str) {
            this.Str_Submit = str;
            return this;
        }

        public Builder setTextColorCenter(int i) {
            this.textColorCenter = i;
            return this;
        }

        public Builder setTextColorOut(int i) {
            this.textColorOut = i;
            return this;
        }

        public Builder setTitleBgColor(int i) {
            this.Color_Background_Title = i;
            return this;
        }

        public Builder setTitleColor(int i) {
            this.Color_Title = i;
            return this;
        }

        public Builder setTitleSize(int i) {
            this.Size_Title = i;
            return this;
        }

        public Builder setTitleText(String str) {
            this.Str_Title = str;
            return this;
        }

        public Builder setType(boolean[] zArr) {
            this.type = zArr;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/SobotTimePickerView$OnTimeSelectListener.class */
    public interface OnTimeSelectListener {
        void onTimeSelect(Date date, View view);
    }

    public SobotTimePickerView(Builder builder) {
        super(builder.context);
        this.gravity = 17;
        this.lineSpacingMultiplier = 1.6f;
        this.timeSelectListener = builder.timeSelectListener;
        this.gravity = builder.gravity;
        this.type = builder.type;
        this.Str_Submit = builder.Str_Submit;
        this.Str_Cancel = builder.Str_Cancel;
        this.Str_Title = builder.Str_Title;
        this.Color_Submit = builder.Color_Submit;
        this.Color_Cancel = builder.Color_Cancel;
        this.Color_Title = builder.Color_Title;
        this.Color_Background_Wheel = builder.Color_Background_Wheel;
        this.Color_Background_Title = builder.Color_Background_Title;
        this.Size_Submit_Cancel = builder.Size_Submit_Cancel;
        this.Size_Title = builder.Size_Title;
        this.Size_Content = builder.Size_Content;
        this.startYear = builder.startYear;
        this.endYear = builder.endYear;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.date = builder.date;
        this.cyclic = builder.cyclic;
        this.isCenterLabel = builder.isCenterLabel;
        this.cancelable = builder.cancelable;
        this.label_year = builder.label_year;
        this.label_month = builder.label_month;
        this.label_day = builder.label_day;
        this.label_hours = builder.label_hours;
        this.label_mins = builder.label_mins;
        this.label_seconds = builder.label_seconds;
        this.textColorCenter = builder.textColorCenter;
        this.textColorOut = builder.textColorOut;
        this.dividerColor = builder.dividerColor;
        this.customListener = builder.customListener;
        this.layoutRes = builder.layoutRes;
        this.lineSpacingMultiplier = builder.lineSpacingMultiplier;
        this.isDialog = builder.isDialog;
        this.dividerType = builder.dividerType;
        this.backgroundId = builder.backgroundId;
        this.decorView = builder.decorView;
        initView(builder.context);
    }

    private void initView(Context context) {
        int i;
        setDialogOutSideCancelable(this.cancelable);
        initViews(this.backgroundId);
        init();
        initEvents();
        SobotCustomListener sobotCustomListener = this.customListener;
        if (sobotCustomListener == null) {
            LayoutInflater.from(context).inflate(ResourceUtils.getIdByName(context, "layout", "sobot_pickerview_time"), this.contentContainer);
            this.tvTitle = (TextView) findViewById(ResourceUtils.getIdByName(context, "id", "tvTitle"));
            this.btnSubmit = (Button) findViewById(ResourceUtils.getIdByName(context, "id", "btnSubmit"));
            this.btnCancel = (ImageView) findViewById(ResourceUtils.getIdByName(context, "id", "btnCancel"));
            this.btnSubmit.setTag("submit");
            this.btnCancel.setTag("cancel");
            this.btnSubmit.setOnClickListener(this);
            this.btnCancel.setOnClickListener(this);
            this.btnSubmit.setText(TextUtils.isEmpty(this.Str_Submit) ? ResourceUtils.getResString(context, "sobot_btn_submit") : this.Str_Submit);
            this.tvTitle.setText(TextUtils.isEmpty(this.Str_Title) ? "" : this.Str_Title);
            Button button = this.btnSubmit;
            int i2 = this.Color_Submit;
            int i3 = i2;
            if (i2 == 0) {
                i3 = this.pickerview_timebtn_nor;
            }
            button.setTextColor(i3);
            TextView textView = this.tvTitle;
            int i4 = this.Color_Title;
            int i5 = i4;
            if (i4 == 0) {
                i5 = this.pickerview_topbar_title;
            }
            textView.setTextColor(i5);
            this.btnSubmit.setTextSize(this.Size_Submit_Cancel);
            this.tvTitle.setTextSize(this.Size_Title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResourceUtils.getIdByName(context, "id", "rv_topbar"));
            int i6 = this.Color_Background_Title;
            int i7 = i6;
            if (i6 == 0) {
                i7 = this.pickerview_bg_topbar;
            }
            relativeLayout.setBackgroundColor(i7);
        } else {
            sobotCustomListener.customLayout(LayoutInflater.from(context).inflate(ResourceUtils.getIdByName(context, "layout", this.layoutRes), this.contentContainer));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResourceUtils.getIdByName(context, "id", "timepicker"));
        int i8 = this.Color_Background_Wheel;
        int i9 = i8;
        if (i8 == 0) {
            i9 = this.bgColor_default;
        }
        linearLayout.setBackgroundColor(i9);
        this.wheelTime = new SobotWheelTime(linearLayout, this.type, this.gravity, this.Size_Content);
        int i10 = this.startYear;
        if (i10 != 0 && (i = this.endYear) != 0 && i10 <= i) {
            setRange();
        }
        Calendar calendar = this.startDate;
        if (calendar == null || this.endDate == null) {
            if (this.startDate != null && this.endDate == null) {
                setRangDate();
            } else if (this.startDate == null && this.endDate != null) {
                setRangDate();
            }
        } else if (calendar.getTimeInMillis() <= this.endDate.getTimeInMillis()) {
            setRangDate();
        }
        setTime();
        this.wheelTime.setLabels(this.label_year, this.label_month, this.label_day, this.label_hours, this.label_mins, this.label_seconds);
        setOutSideCancelable(this.cancelable);
        this.wheelTime.setCyclic(this.cyclic);
        this.wheelTime.setDividerColor(this.dividerColor);
        this.wheelTime.setDividerType(this.dividerType);
        this.wheelTime.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wheelTime.setTextColorOut(this.textColorOut);
        this.wheelTime.setTextColorCenter(this.textColorCenter);
        this.wheelTime.isCenterLabel(Boolean.valueOf(this.isCenterLabel));
    }

    private void setRangDate() {
        this.wheelTime.setRangDate(this.startDate, this.endDate);
        if (this.startDate != null && this.endDate != null) {
            Calendar calendar = this.date;
            if (calendar == null || calendar.getTimeInMillis() < this.startDate.getTimeInMillis() || this.date.getTimeInMillis() > this.endDate.getTimeInMillis()) {
                this.date = this.startDate;
                return;
            }
            return;
        }
        Calendar calendar2 = this.startDate;
        if (calendar2 != null) {
            this.date = calendar2;
            return;
        }
        Calendar calendar3 = this.endDate;
        if (calendar3 != null) {
            this.date = calendar3;
        }
    }

    private void setRange() {
        this.wheelTime.setStartYear(this.startYear);
        this.wheelTime.setEndYear(this.endYear);
    }

    private void setTime() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.date;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = calendar2.get(1);
            i2 = this.date.get(2);
            i3 = this.date.get(5);
            i4 = this.date.get(11);
            i5 = this.date.get(12);
            i6 = this.date.get(13);
        }
        this.wheelTime.setPicker(i, i2, i3, i4, i5, i6);
    }

    @Override // com.sobot.chat.widget.timePicker.view.SobotBasePickerView
    public boolean isDialog() {
        return this.isDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (((String) view.getTag()).equals("submit")) {
            returnData();
        }
        dismiss();
    }

    public void returnData() {
        if (this.timeSelectListener != null) {
            try {
                this.timeSelectListener.onTimeSelect(SobotWheelTime.dateFormat.parse(this.wheelTime.getTime()), this.clickView);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDate(Calendar calendar) {
        this.date = calendar;
        setTime();
    }
}
