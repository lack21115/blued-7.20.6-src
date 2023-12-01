package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AlertDialog.class */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    final AlertController f1509a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AlertDialog$Builder.class */
    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.a(context, 0));
        }

        public Builder(Context context, int i) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.a(context, i)));
            this.mTheme = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(alertDialog.f1509a);
            alertDialog.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.P.mOnDismissListener);
            if (this.P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.P.mOnKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.P.mAdapter = listAdapter;
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.P.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.P.mCursor = cursor;
            this.P.mLabelColumn = str;
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.P.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.P.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.P.mItems = charSequenceArr;
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.P.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.P.mCheckedItems = zArr;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.P.mCursor = cursor;
            this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.P.mIsCheckedColumn = str;
            this.P.mLabelColumn = str2;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.P.mItems = charSequenceArr;
            this.P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.P.mCheckedItems = zArr;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.mNegativeButtonText = charSequence;
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.P.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.mNeutralButtonText = charSequence;
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.P.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.mPositiveButtonText = charSequence;
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.P.mPositiveButtonIcon = drawable;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnClickListener = onClickListener;
            this.P.mCheckedItem = i2;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.P.mCursor = cursor;
            this.P.mOnClickListener = onClickListener;
            this.P.mCheckedItem = i;
            this.P.mLabelColumn = str;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.P.mAdapter = listAdapter;
            this.P.mOnClickListener = onClickListener;
            this.P.mCheckedItem = i;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.P.mItems = charSequenceArr;
            this.P.mOnClickListener = onClickListener;
            this.P.mCheckedItem = i;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.P.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.P.mView = null;
            this.P.mViewLayoutResId = i;
            this.P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.P.mView = view;
            this.P.mViewLayoutResId = 0;
            this.P.mViewSpacingSpecified = false;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.P.mView = view;
            this.P.mViewLayoutResId = 0;
            this.P.mViewSpacingSpecified = true;
            this.P.mViewSpacingLeft = i;
            this.P.mViewSpacingTop = i2;
            this.P.mViewSpacingRight = i3;
            this.P.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(Context context, int i) {
        super(context, a(context, i));
        this.f1509a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.f1509a.getButton(i);
    }

    public ListView getListView() {
        return this.f1509a.getListView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1509a.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1509a.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1509a.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1509a.setButton(i, charSequence, onClickListener, null, null);
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f1509a.setButton(i, charSequence, onClickListener, null, drawable);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.f1509a.setButton(i, charSequence, null, message, null);
    }

    public void setCustomTitle(View view) {
        this.f1509a.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.f1509a.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1509a.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.f1509a.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.f1509a.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1509a.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f1509a.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.f1509a.setView(view, i, i2, i3, i4);
    }
}
