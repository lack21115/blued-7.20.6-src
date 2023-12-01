package android.telephony;

import android.os.SystemProperties;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.android.i18n.phonenumbers.AsYouTypeFormatter;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/PhoneNumberFormattingTextWatcher.class */
public class PhoneNumberFormattingTextWatcher implements TextWatcher {
    private AsYouTypeFormatter mFormatter;
    private boolean mSelfChange;
    private boolean mStopFormatting;

    public PhoneNumberFormattingTextWatcher() {
        this(Locale.getDefault().getCountry());
    }

    public PhoneNumberFormattingTextWatcher(String str) {
        this.mSelfChange = false;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(str);
    }

    private String getFormattedNumber(char c2, boolean z) {
        String inputDigitAndRememberPosition = z ? this.mFormatter.inputDigitAndRememberPosition(c2) : this.mFormatter.inputDigit(c2);
        String str = inputDigitAndRememberPosition;
        if (!SystemProperties.getBoolean("persist.env.sys.hypenenable", true)) {
            str = inputDigitAndRememberPosition.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        }
        return str;
    }

    private boolean hasSeparator(CharSequence charSequence, int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return false;
            }
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i4))) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    private String reformat(CharSequence charSequence, int i) {
        String str = null;
        this.mFormatter.clear();
        char c2 = 0;
        boolean z = false;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            String str2 = str;
            boolean z2 = z;
            char c3 = c2;
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
                z2 = z;
                if (c2 != 0) {
                    str = getFormattedNumber(c2, z);
                    z2 = false;
                }
                c3 = charAt;
                str2 = str;
            }
            z = z2;
            if (i2 == i - 1) {
                z = true;
            }
            i2++;
            str = str2;
            c2 = c3;
        }
        if (c2 != 0) {
            str = getFormattedNumber(c2, z);
        }
        return str;
    }

    private void stopFormatting() {
        this.mStopFormatting = true;
        this.mFormatter.clear();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z = true;
        synchronized (this) {
            if (this.mStopFormatting) {
                if (editable.length() == 0) {
                    z = false;
                }
                this.mStopFormatting = z;
            } else if (!this.mSelfChange) {
                String reformat = reformat(editable, Selection.getSelectionEnd(editable));
                if (reformat != null) {
                    int rememberedPosition = this.mFormatter.getRememberedPosition();
                    this.mSelfChange = true;
                    editable.replace(0, editable.length(), reformat, 0, reformat.length());
                    if (reformat.equals(editable.toString())) {
                        Selection.setSelection(editable, rememberedPosition);
                    }
                    this.mSelfChange = false;
                }
                PhoneNumberUtils.ttsSpanAsPhoneNumber(editable, 0, editable.length());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mSelfChange || this.mStopFormatting || i2 <= 0 || !hasSeparator(charSequence, i, i2)) {
            return;
        }
        stopFormatting();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mSelfChange || this.mStopFormatting || i3 <= 0 || !hasSeparator(charSequence, i, i3)) {
            return;
        }
        stopFormatting();
    }
}
