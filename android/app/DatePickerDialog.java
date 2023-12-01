package android.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import com.android.internal.R;
import java.util.Calendar;

/* loaded from: source-9557208-dex2jar.jar:android/app/DatePickerDialog.class */
public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private final Calendar mCalendar;
    private final DatePicker mDatePicker;
    private final OnDateSetListener mDateSetListener;
    private boolean mTitleNeedsUpdate;
    private final DatePicker.ValidationCallback mValidationCallback;

    /* loaded from: source-9557208-dex2jar.jar:android/app/DatePickerDialog$OnDateSetListener.class */
    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    public DatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, resolveDialogTheme(context, i));
        this.mTitleNeedsUpdate = true;
        this.mValidationCallback = new DatePicker.ValidationCallback() { // from class: android.app.DatePickerDialog.1
            @Override // android.widget.DatePicker.ValidationCallback
            public void onValidationChanged(boolean z) {
                Button button = DatePickerDialog.this.getButton(-1);
                if (button != null) {
                    button.setEnabled(z);
                }
            }
        };
        this.mDateSetListener = onDateSetListener;
        this.mCalendar = Calendar.getInstance();
        Context context2 = getContext();
        View inflate = LayoutInflater.from(context2).inflate(R.layout.date_picker_dialog, (ViewGroup) null);
        setView(inflate);
        setButton(-1, context2.getString(17039370), this);
        setButton(-2, context2.getString(17039360), this);
        setButtonPanelLayoutHint(1);
        this.mDatePicker = (DatePicker) inflate.findViewById(R.id.datePicker);
        this.mDatePicker.init(i2, i3, i4, this);
        this.mDatePicker.setValidationCallback(this.mValidationCallback);
    }

    public DatePickerDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    static int resolveDialogTheme(Context context, int i) {
        int i2 = i;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843948, typedValue, true);
            i2 = typedValue.resourceId;
        }
        return i2;
    }

    private void updateTitle(int i, int i2, int i3) {
        if (this.mDatePicker.getCalendarViewShown()) {
            if (this.mTitleNeedsUpdate) {
                this.mTitleNeedsUpdate = false;
                setTitle(R.string.date_picker_dialog_title);
                return;
            }
            return;
        }
        this.mCalendar.set(1, i);
        this.mCalendar.set(2, i2);
        this.mCalendar.set(5, i3);
        setTitle(DateUtils.formatDateTime(this.mContext, this.mCalendar.getTimeInMillis(), 98326));
        this.mTitleNeedsUpdate = true;
    }

    public DatePicker getDatePicker() {
        return this.mDatePicker;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                cancel();
                return;
            case -1:
                if (this.mDateSetListener != null) {
                    this.mDateSetListener.onDateSet(this.mDatePicker, this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        this.mDatePicker.init(i, i2, i3, this);
        updateTitle(i, i2, i3);
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDatePicker.init(bundle.getInt("year"), bundle.getInt(MONTH), bundle.getInt(DAY), this);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("year", this.mDatePicker.getYear());
        onSaveInstanceState.putInt(MONTH, this.mDatePicker.getMonth());
        onSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        return onSaveInstanceState;
    }

    public void updateDate(int i, int i2, int i3) {
        this.mDatePicker.updateDate(i, i2, i3);
    }
}
