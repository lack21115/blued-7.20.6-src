package com.blued.android.module.common.view;

import android.content.Context;
import android.content.DialogInterface;
import com.blued.android.module.common.R;
import net.simonvt.datepicker.DatePickerDialog;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/MDatePickerDialog.class */
public class MDatePickerDialog extends DatePickerDialog {
    public MDatePickerDialog(Context context, int i, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i, onDateSetListener, i2, i3, i4);
        setButton(-2, context.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        setButton(-1, context.getResources().getString(R.string.biao_v4_ok), this);
    }

    public MDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        super(context, onDateSetListener, i, i2, i3);
        setButton(-2, context.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        setButton(-1, context.getResources().getString(R.string.biao_v4_ok), this);
    }
}
