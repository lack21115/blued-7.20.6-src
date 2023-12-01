package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/TextWatcher.class */
public interface TextWatcher extends NoCopySpan {
    void afterTextChanged(Editable editable);

    void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

    void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
}
