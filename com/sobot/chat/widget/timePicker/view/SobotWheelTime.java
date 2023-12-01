package com.sobot.chat.widget.timePicker.view;

import android.provider.MediaStore;
import android.view.View;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.timePicker.adapter.SobotNumericWheelAdapter;
import com.sobot.chat.widget.timePicker.lib.SobotWheelView;
import com.sobot.chat.widget.timePicker.listener.SobotOnItemSelectedListener;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/view/SobotWheelTime.class */
public class SobotWheelTime {
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_MONTH = 12;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_DAY = 1;
    private static final int DEFAULT_START_MONTH = 1;
    private static final int DEFAULT_START_YEAR = 1900;
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int currentYear;
    int dividerColor;
    private SobotWheelView.DividerType dividerType;
    private int endDay;
    private int endMonth;
    private int endYear;
    private int gravity;
    float lineSpacingMultiplier;
    private int startDay;
    private int startMonth;
    private int startYear;
    int textColorCenter;
    int textColorOut;
    private int textSize;
    private boolean[] type;
    private View view;
    private SobotWheelView wv_day;
    private SobotWheelView wv_hours;
    private SobotWheelView wv_mins;
    private SobotWheelView wv_month;
    private SobotWheelView wv_seconds;
    private SobotWheelView wv_year;

    public SobotWheelTime(View view) {
        this.startYear = 1900;
        this.endYear = 2100;
        this.startMonth = 1;
        this.endMonth = 12;
        this.startDay = 1;
        this.endDay = 31;
        this.textSize = 18;
        this.lineSpacingMultiplier = 1.6f;
        this.view = view;
        this.type = new boolean[]{true, true, true, true, true, true};
        setView(view);
    }

    public SobotWheelTime(View view, boolean[] zArr, int i, int i2) {
        this.startYear = 1900;
        this.endYear = 2100;
        this.startMonth = 1;
        this.endMonth = 12;
        this.startDay = 1;
        this.endDay = 31;
        this.textSize = 18;
        this.lineSpacingMultiplier = 1.6f;
        this.view = view;
        this.type = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    private void setContentTextSize() {
        this.wv_day.setTextSize(this.textSize);
        this.wv_month.setTextSize(this.textSize);
        this.wv_year.setTextSize(this.textSize);
        this.wv_hours.setTextSize(this.textSize);
        this.wv_mins.setTextSize(this.textSize);
        this.wv_seconds.setTextSize(this.textSize);
    }

    private void setDividerColor() {
        this.wv_day.setDividerColor(this.dividerColor);
        this.wv_month.setDividerColor(this.dividerColor);
        this.wv_year.setDividerColor(this.dividerColor);
        this.wv_hours.setDividerColor(this.dividerColor);
        this.wv_mins.setDividerColor(this.dividerColor);
        this.wv_seconds.setDividerColor(this.dividerColor);
    }

    private void setDividerType() {
        this.wv_day.setDividerType(this.dividerType);
        this.wv_month.setDividerType(this.dividerType);
        this.wv_year.setDividerType(this.dividerType);
        this.wv_hours.setDividerType(this.dividerType);
        this.wv_mins.setDividerType(this.dividerType);
        this.wv_seconds.setDividerType(this.dividerType);
    }

    private void setLineSpacingMultiplier() {
        this.wv_day.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_month.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_year.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_hours.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_mins.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_seconds.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReDay(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.wv_day.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            int i5 = i4;
            if (i4 > 31) {
                i5 = 31;
            }
            this.wv_day.setAdapter(new SobotNumericWheelAdapter(i3, i5));
        } else if (list2.contains(String.valueOf(i2))) {
            int i6 = i4;
            if (i4 > 30) {
                i6 = 30;
            }
            this.wv_day.setAdapter(new SobotNumericWheelAdapter(i3, i6));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            int i7 = i4;
            if (i4 > 28) {
                i7 = 28;
            }
            this.wv_day.setAdapter(new SobotNumericWheelAdapter(i3, i7));
        } else {
            int i8 = i4;
            if (i4 > 29) {
                i8 = 29;
            }
            this.wv_day.setAdapter(new SobotNumericWheelAdapter(i3, i8));
        }
        if (currentItem > this.wv_day.getAdapter().getItemsCount() - 1) {
            this.wv_day.setCurrentItem(this.wv_day.getAdapter().getItemsCount() - 1);
        }
    }

    private void setTextColorCenter() {
        this.wv_day.setTextColorCenter(this.textColorCenter);
        this.wv_month.setTextColorCenter(this.textColorCenter);
        this.wv_year.setTextColorCenter(this.textColorCenter);
        this.wv_hours.setTextColorCenter(this.textColorCenter);
        this.wv_mins.setTextColorCenter(this.textColorCenter);
        this.wv_seconds.setTextColorCenter(this.textColorCenter);
    }

    private void setTextColorOut() {
        this.wv_day.setTextColorOut(this.textColorOut);
        this.wv_month.setTextColorOut(this.textColorOut);
        this.wv_year.setTextColorOut(this.textColorOut);
        this.wv_hours.setTextColorOut(this.textColorOut);
        this.wv_mins.setTextColorOut(this.textColorOut);
        this.wv_seconds.setTextColorOut(this.textColorOut);
    }

    public int getEndYear() {
        return this.endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public String getTime() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.currentYear == this.startYear) {
            int currentItem = this.wv_month.getCurrentItem();
            int i = this.startMonth;
            if (currentItem + i == i) {
                stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_day.getCurrentItem() + this.startDay);
                stringBuffer.append(" ");
                stringBuffer.append(this.wv_hours.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.wv_mins.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.wv_seconds.getCurrentItem());
            } else {
                stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_day.getCurrentItem() + 1);
                stringBuffer.append(" ");
                stringBuffer.append(this.wv_hours.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.wv_mins.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.wv_seconds.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(this.wv_month.getCurrentItem() + 1);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(this.wv_day.getCurrentItem() + 1);
            stringBuffer.append(" ");
            stringBuffer.append(this.wv_hours.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.wv_mins.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.wv_seconds.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    public View getView() {
        return this.view;
    }

    public void isCenterLabel(Boolean bool) {
        this.wv_day.isCenterLabel(bool);
        this.wv_month.isCenterLabel(bool);
        this.wv_year.isCenterLabel(bool);
        this.wv_hours.isCenterLabel(bool);
        this.wv_mins.isCenterLabel(bool);
        this.wv_seconds.isCenterLabel(bool);
    }

    public void setCyclic(boolean z) {
        this.wv_year.setCyclic(z);
        this.wv_month.setCyclic(z);
        this.wv_day.setCyclic(z);
        this.wv_hours.setCyclic(z);
        this.wv_mins.setCyclic(z);
        this.wv_seconds.setCyclic(z);
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        setDividerColor();
    }

    public void setDividerType(SobotWheelView.DividerType dividerType) {
        this.dividerType = dividerType;
        setDividerType();
    }

    public void setEndYear(int i) {
        this.endYear = i;
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.wv_year.setLabel(str);
        }
        if (str2 != null) {
            this.wv_month.setLabel(str2);
        }
        if (str3 != null) {
            this.wv_day.setLabel(str3);
        }
        if (str4 != null) {
            this.wv_hours.setLabel(str4);
        }
        if (str5 != null) {
            this.wv_mins.setLabel(str5);
        }
        if (str6 != null) {
            this.wv_seconds.setLabel(str6);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        setLineSpacingMultiplier();
    }

    public void setPicker(int i, int i2, int i3) {
        setPicker(i, i2, i3, 0, 0, 0);
    }

    public void setPicker(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.currentYear = i;
        View view = this.view;
        SobotWheelView sobotWheelView = (SobotWheelView) view.findViewById(ResourceUtils.getIdByName(view.getContext(), "id", MediaStore.Audio.AudioColumns.YEAR));
        this.wv_year = sobotWheelView;
        sobotWheelView.setAdapter(new SobotNumericWheelAdapter(this.startYear, this.endYear));
        this.wv_year.setCurrentItem(i - this.startYear);
        this.wv_year.setGravity(this.gravity);
        View view2 = this.view;
        SobotWheelView sobotWheelView2 = (SobotWheelView) view2.findViewById(ResourceUtils.getIdByName(view2.getContext(), "id", "month"));
        this.wv_month = sobotWheelView2;
        int i9 = this.startYear;
        int i10 = this.endYear;
        if (i9 == i10) {
            sobotWheelView2.setAdapter(new SobotNumericWheelAdapter(this.startMonth, this.endMonth));
            this.wv_month.setCurrentItem((i2 + 1) - this.startMonth);
        } else if (i == i9) {
            sobotWheelView2.setAdapter(new SobotNumericWheelAdapter(this.startMonth, 12));
            this.wv_month.setCurrentItem((i2 + 1) - this.startMonth);
        } else if (i == i10) {
            sobotWheelView2.setAdapter(new SobotNumericWheelAdapter(1, this.endMonth));
            this.wv_month.setCurrentItem(i2);
        } else {
            sobotWheelView2.setAdapter(new SobotNumericWheelAdapter(1, 12));
            this.wv_month.setCurrentItem(i2);
        }
        this.wv_month.setGravity(this.gravity);
        View view3 = this.view;
        this.wv_day = (SobotWheelView) view3.findViewById(ResourceUtils.getIdByName(view3.getContext(), "id", "day"));
        if (this.startYear == this.endYear && this.startMonth == this.endMonth) {
            int i11 = i2 + 1;
            if (asList.contains(String.valueOf(i11))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, this.endDay));
            } else if (asList2.contains(String.valueOf(i11))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, this.endDay));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, this.endDay));
            } else {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, this.endDay));
            }
            this.wv_day.setCurrentItem(i3 - this.startDay);
        } else if (i == this.startYear && (i8 = i2 + 1) == this.startMonth) {
            if (asList.contains(String.valueOf(i8))) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, 28));
            } else {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(this.startDay, 29));
            }
            this.wv_day.setCurrentItem(i3 - this.startDay);
        } else if (i == this.endYear && (i7 = i2 + 1) == this.endMonth) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, this.endDay));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, this.endDay));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, this.endDay));
            } else {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, this.endDay));
            }
            this.wv_day.setCurrentItem(i3 - 1);
        } else {
            int i12 = i2 + 1;
            if (asList.contains(String.valueOf(i12))) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i12))) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, 28));
            } else {
                this.wv_day.setAdapter(new SobotNumericWheelAdapter(1, 29));
            }
            this.wv_day.setCurrentItem(i3 - 1);
        }
        this.wv_day.setGravity(this.gravity);
        View view4 = this.view;
        SobotWheelView sobotWheelView3 = (SobotWheelView) view4.findViewById(ResourceUtils.getIdByName(view4.getContext(), "id", "hour"));
        this.wv_hours = sobotWheelView3;
        sobotWheelView3.setAdapter(new SobotNumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(i4);
        this.wv_hours.setGravity(this.gravity);
        View view5 = this.view;
        SobotWheelView sobotWheelView4 = (SobotWheelView) view5.findViewById(ResourceUtils.getIdByName(view5.getContext(), "id", "min"));
        this.wv_mins = sobotWheelView4;
        sobotWheelView4.setAdapter(new SobotNumericWheelAdapter(0, 59));
        this.wv_mins.setCurrentItem(i5);
        this.wv_mins.setGravity(this.gravity);
        View view6 = this.view;
        SobotWheelView sobotWheelView5 = (SobotWheelView) view6.findViewById(ResourceUtils.getIdByName(view6.getContext(), "id", "second"));
        this.wv_seconds = sobotWheelView5;
        sobotWheelView5.setAdapter(new SobotNumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(i6);
        this.wv_seconds.setGravity(this.gravity);
        SobotOnItemSelectedListener sobotOnItemSelectedListener = new SobotOnItemSelectedListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotWheelTime.1
            @Override // com.sobot.chat.widget.timePicker.listener.SobotOnItemSelectedListener
            public void onItemSelected(int i13) {
                int i14 = i13 + SobotWheelTime.this.startYear;
                SobotWheelTime.this.currentYear = i14;
                int currentItem = SobotWheelTime.this.wv_month.getCurrentItem();
                if (SobotWheelTime.this.startYear == SobotWheelTime.this.endYear) {
                    SobotWheelTime.this.wv_month.setAdapter(new SobotNumericWheelAdapter(SobotWheelTime.this.startMonth, SobotWheelTime.this.endMonth));
                    int i15 = currentItem;
                    if (currentItem > SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        i15 = SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        SobotWheelTime.this.wv_month.setCurrentItem(i15);
                    }
                    int i16 = i15 + SobotWheelTime.this.startMonth;
                    if (SobotWheelTime.this.startMonth == SobotWheelTime.this.endMonth) {
                        SobotWheelTime sobotWheelTime = SobotWheelTime.this;
                        sobotWheelTime.setReDay(i14, i16, sobotWheelTime.startDay, SobotWheelTime.this.endDay, asList, asList2);
                    } else if (i16 != SobotWheelTime.this.startMonth) {
                        SobotWheelTime.this.setReDay(i14, i16, 1, 31, asList, asList2);
                    } else {
                        SobotWheelTime sobotWheelTime2 = SobotWheelTime.this;
                        sobotWheelTime2.setReDay(i14, i16, sobotWheelTime2.startDay, 31, asList, asList2);
                    }
                } else if (i14 == SobotWheelTime.this.startYear) {
                    SobotWheelTime.this.wv_month.setAdapter(new SobotNumericWheelAdapter(SobotWheelTime.this.startMonth, 12));
                    int i17 = currentItem;
                    if (currentItem > SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        i17 = SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        SobotWheelTime.this.wv_month.setCurrentItem(i17);
                    }
                    int i18 = i17 + SobotWheelTime.this.startMonth;
                    if (i18 != SobotWheelTime.this.startMonth) {
                        SobotWheelTime.this.setReDay(i14, i18, 1, 31, asList, asList2);
                        return;
                    }
                    SobotWheelTime sobotWheelTime3 = SobotWheelTime.this;
                    sobotWheelTime3.setReDay(i14, i18, sobotWheelTime3.startDay, 31, asList, asList2);
                } else if (i14 != SobotWheelTime.this.endYear) {
                    SobotWheelTime.this.wv_month.setAdapter(new SobotNumericWheelAdapter(1, 12));
                    SobotWheelTime sobotWheelTime4 = SobotWheelTime.this;
                    sobotWheelTime4.setReDay(i14, 1 + sobotWheelTime4.wv_month.getCurrentItem(), 1, 31, asList, asList2);
                } else {
                    SobotWheelTime.this.wv_month.setAdapter(new SobotNumericWheelAdapter(1, SobotWheelTime.this.endMonth));
                    int i19 = currentItem;
                    if (currentItem > SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        i19 = SobotWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        SobotWheelTime.this.wv_month.setCurrentItem(i19);
                    }
                    int i20 = 1 + i19;
                    if (i20 != SobotWheelTime.this.endMonth) {
                        SobotWheelTime.this.setReDay(i14, i20, 1, 31, asList, asList2);
                        return;
                    }
                    SobotWheelTime sobotWheelTime5 = SobotWheelTime.this;
                    sobotWheelTime5.setReDay(i14, i20, 1, sobotWheelTime5.endDay, asList, asList2);
                }
            }
        };
        SobotOnItemSelectedListener sobotOnItemSelectedListener2 = new SobotOnItemSelectedListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotWheelTime.2
            @Override // com.sobot.chat.widget.timePicker.listener.SobotOnItemSelectedListener
            public void onItemSelected(int i13) {
                int i14 = i13 + 1;
                if (SobotWheelTime.this.startYear == SobotWheelTime.this.endYear) {
                    int i15 = (i14 + SobotWheelTime.this.startMonth) - 1;
                    if (SobotWheelTime.this.startMonth == SobotWheelTime.this.endMonth) {
                        SobotWheelTime sobotWheelTime = SobotWheelTime.this;
                        sobotWheelTime.setReDay(sobotWheelTime.currentYear, i15, SobotWheelTime.this.startDay, SobotWheelTime.this.endDay, asList, asList2);
                    } else if (SobotWheelTime.this.startMonth == i15) {
                        SobotWheelTime sobotWheelTime2 = SobotWheelTime.this;
                        sobotWheelTime2.setReDay(sobotWheelTime2.currentYear, i15, SobotWheelTime.this.startDay, 31, asList, asList2);
                    } else if (SobotWheelTime.this.endMonth == i15) {
                        SobotWheelTime sobotWheelTime3 = SobotWheelTime.this;
                        sobotWheelTime3.setReDay(sobotWheelTime3.currentYear, i15, 1, SobotWheelTime.this.endDay, asList, asList2);
                    } else {
                        SobotWheelTime sobotWheelTime4 = SobotWheelTime.this;
                        sobotWheelTime4.setReDay(sobotWheelTime4.currentYear, i15, 1, 31, asList, asList2);
                    }
                } else if (SobotWheelTime.this.currentYear == SobotWheelTime.this.startYear) {
                    int i16 = (i14 + SobotWheelTime.this.startMonth) - 1;
                    if (i16 == SobotWheelTime.this.startMonth) {
                        SobotWheelTime sobotWheelTime5 = SobotWheelTime.this;
                        sobotWheelTime5.setReDay(sobotWheelTime5.currentYear, i16, SobotWheelTime.this.startDay, 31, asList, asList2);
                        return;
                    }
                    SobotWheelTime sobotWheelTime6 = SobotWheelTime.this;
                    sobotWheelTime6.setReDay(sobotWheelTime6.currentYear, i16, 1, 31, asList, asList2);
                } else if (SobotWheelTime.this.currentYear != SobotWheelTime.this.endYear) {
                    SobotWheelTime sobotWheelTime7 = SobotWheelTime.this;
                    sobotWheelTime7.setReDay(sobotWheelTime7.currentYear, i14, 1, 31, asList, asList2);
                } else if (i14 == SobotWheelTime.this.endMonth) {
                    SobotWheelTime sobotWheelTime8 = SobotWheelTime.this;
                    sobotWheelTime8.setReDay(sobotWheelTime8.currentYear, SobotWheelTime.this.wv_month.getCurrentItem() + 1, 1, SobotWheelTime.this.endDay, asList, asList2);
                } else {
                    SobotWheelTime sobotWheelTime9 = SobotWheelTime.this;
                    sobotWheelTime9.setReDay(sobotWheelTime9.currentYear, SobotWheelTime.this.wv_month.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
            }
        };
        this.wv_year.setOnItemSelectedListener(sobotOnItemSelectedListener);
        this.wv_month.setOnItemSelectedListener(sobotOnItemSelectedListener2);
        boolean[] zArr = this.type;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.wv_year.setVisibility(zArr[0] ? 0 : 8);
        this.wv_month.setVisibility(this.type[1] ? 0 : 8);
        this.wv_day.setVisibility(this.type[2] ? 0 : 8);
        this.wv_hours.setVisibility(this.type[3] ? 0 : 8);
        this.wv_mins.setVisibility(this.type[4] ? 0 : 8);
        this.wv_seconds.setVisibility(this.type[5] ? 0 : 8);
        setContentTextSize();
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.startYear;
            if (i > i4) {
                this.endYear = i;
                this.endMonth = i2;
                this.endDay = i3;
            } else if (i == i4) {
                int i5 = this.startMonth;
                if (i2 > i5) {
                    this.endYear = i;
                    this.endMonth = i2;
                    this.endDay = i3;
                } else if (i2 != i5 || i3 <= this.startDay) {
                } else {
                    this.endYear = i;
                    this.endMonth = i2;
                    this.endDay = i3;
                }
            }
        } else if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.startMonth = calendar.get(2) + 1;
            this.endMonth = calendar2.get(2) + 1;
            this.startDay = calendar.get(5);
            this.endDay = calendar2.get(5);
        } else {
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.endYear;
            if (i6 < i9) {
                this.startMonth = i7;
                this.startDay = i8;
                this.startYear = i6;
            } else if (i6 == i9) {
                int i10 = this.endMonth;
                if (i7 < i10) {
                    this.startMonth = i7;
                    this.startDay = i8;
                    this.startYear = i6;
                } else if (i7 != i10 || i8 >= this.endDay) {
                } else {
                    this.startMonth = i7;
                    this.startDay = i8;
                    this.startYear = i6;
                }
            }
        }
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        setTextColorCenter();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        setTextColorOut();
    }

    public void setView(View view) {
        this.view = view;
    }
}
