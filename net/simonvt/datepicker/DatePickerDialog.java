package net.simonvt.datepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.blued.blued_third_library.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.Calendar;
import net.simonvt.datepicker.DatePicker;

/* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/DatePickerDialog.class */
public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private final DatePicker a;
    private final OnDateSetListener b;
    private final Calendar c;
    private boolean d;

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/DatePickerDialog$OnDateSetListener.class */
    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    public DatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i);
        this.d = true;
        this.b = onDateSetListener;
        this.c = Calendar.getInstance();
        Context context2 = getContext();
        setButton(-1, context2.getText(R.string.date_time_done), this);
        setIcon(0);
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.date_picker_dialog, (ViewGroup) null);
        setView(inflate);
        DatePicker datePicker = (DatePicker) inflate.findViewById(R.id.datePicker);
        this.a = datePicker;
        datePicker.a(i2, i3, i4, this);
        a(i2, i3, i4);
    }

    public DatePickerDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, Build.VERSION.SDK_INT < 11 ? R.style.Theme_Dialog_Alert : 0, onDateSetListener, i, i2, i3);
    }

    private void a() {
        if (this.b != null) {
            this.a.clearFocus();
            OnDateSetListener onDateSetListener = this.b;
            DatePicker datePicker = this.a;
            onDateSetListener.onDateSet(datePicker, datePicker.getYear(), this.a.getMonth(), this.a.getDayOfMonth());
        }
    }

    private void a(int i, int i2, int i3) {
        if (this.a.getCalendarViewShown()) {
            if (this.d) {
                this.d = false;
                setTitle(R.string.date_picker_dialog_title);
                return;
            }
            return;
        }
        this.c.set(1, i);
        this.c.set(2, i2);
        this.c.set(5, i3);
        setTitle(DateUtils.formatDateTime(getContext(), this.c.getTimeInMillis(), 98326));
        this.d = true;
    }

    @Override // net.simonvt.datepicker.DatePicker.OnDateChangedListener
    public void a(DatePicker datePicker, int i, int i2, int i3) {
        this.a.a(i, i2, i3, this);
        a(i, i2, i3);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        a();
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.a.a(bundle.getInt("year"), bundle.getInt("month"), bundle.getInt("day"), this);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("year", this.a.getYear());
        onSaveInstanceState.putInt("month", this.a.getMonth());
        onSaveInstanceState.putInt("day", this.a.getDayOfMonth());
        return onSaveInstanceState;
    }
}
