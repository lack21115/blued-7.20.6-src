package android.widget;

import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/DatePickerController.class */
public interface DatePickerController {
    Calendar getSelectedDay();

    void onYearSelected(int i);

    void registerOnDateChangedListener(OnDateChangedListener onDateChangedListener);

    void tryVibrate();
}
