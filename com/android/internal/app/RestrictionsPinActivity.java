package com.android.internal.app;

import android.content.Context;
import android.os.Bundle;
import android.os.UserManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.app.AlertController;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/RestrictionsPinActivity.class */
public class RestrictionsPinActivity extends AlertActivity implements View.OnClickListener, TextWatcher, TextView.OnEditorActionListener {
    private Button mCancelButton;
    private Runnable mCountdownRunnable = new Runnable() { // from class: com.android.internal.app.RestrictionsPinActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (RestrictionsPinActivity.this.updatePinTimer(-1)) {
                RestrictionsPinActivity.this.mPinErrorMessage.setVisibility(4);
            }
        }
    };
    protected boolean mHasRestrictionsPin;
    private Button mOkButton;
    protected TextView mPinErrorMessage;
    protected EditText mPinText;
    protected UserManager mUserManager;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updatePinTimer(int i) {
        boolean z;
        int i2 = i;
        if (i < 0) {
            i2 = this.mUserManager.checkRestrictionsChallenge(null);
        }
        if (i2 >= 200) {
            if (i2 <= 60000) {
                int i3 = (i2 + 200) / 1000;
                this.mPinErrorMessage.setText(String.format(getResources().getQuantityString(R.plurals.restr_pin_countdown, i3), Integer.valueOf(i3)));
            } else {
                this.mPinErrorMessage.setText(R.string.restr_pin_try_later);
            }
            z = false;
            this.mPinErrorMessage.setVisibility(0);
            this.mPinText.setText("");
            this.mPinText.postDelayed(this.mCountdownRunnable, Math.min(1000, i2));
        } else {
            z = true;
            this.mPinErrorMessage.setText(R.string.restr_pin_incorrect);
        }
        this.mPinText.setEnabled(z);
        setPositiveButtonState(z);
        return z;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected void initUi() {
        AlertController.AlertParams alertParams = this.mAlertParams;
        alertParams.mTitle = getString(R.string.restr_pin_enter_admin_pin);
        alertParams.mView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.restrictions_pin_challenge, (ViewGroup) null);
        this.mPinErrorMessage = (TextView) alertParams.mView.findViewById(R.id.pin_error_message);
        this.mPinText = (EditText) alertParams.mView.findViewById(R.id.pin_text);
        this.mOkButton = (Button) alertParams.mView.findViewById(R.id.pin_ok_button);
        this.mCancelButton = (Button) alertParams.mView.findViewById(R.id.pin_cancel_button);
        this.mPinText.addTextChangedListener(this);
        this.mOkButton.setOnClickListener(this);
        this.mCancelButton.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mOkButton) {
            performPositiveButtonAction();
        } else if (view == this.mCancelButton) {
            setResult(0);
            finish();
        }
    }

    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserManager = (UserManager) getSystemService("user");
        this.mHasRestrictionsPin = this.mUserManager.hasRestrictionsChallenge();
        initUi();
        setupAlert();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        performPositiveButtonAction();
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        setPositiveButtonState(false);
        if (this.mUserManager.hasRestrictionsChallenge()) {
            this.mPinErrorMessage.setVisibility(4);
            this.mPinText.setOnEditorActionListener(this);
            updatePinTimer(-1);
        } else if (verifyingPin()) {
            setResult(-1);
            finish();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Editable text = this.mPinText.getText();
        setPositiveButtonState(text != null && text.length() >= 4);
    }

    protected void performPositiveButtonAction() {
        int checkRestrictionsChallenge = this.mUserManager.checkRestrictionsChallenge(this.mPinText.getText().toString());
        if (checkRestrictionsChallenge == -1) {
            setResult(-1);
            finish();
        } else if (checkRestrictionsChallenge >= 0) {
            this.mPinErrorMessage.setText(R.string.restr_pin_incorrect);
            this.mPinErrorMessage.setVisibility(0);
            updatePinTimer(checkRestrictionsChallenge);
            this.mPinText.setText("");
        }
    }

    protected void setPositiveButtonState(boolean z) {
        this.mOkButton.setEnabled(z);
    }

    protected boolean verifyingPin() {
        return true;
    }
}
