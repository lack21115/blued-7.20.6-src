package io.github.inflationx.calligraphy3;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/calligraphy3/CalligraphyConfig.class */
public class CalligraphyConfig {
    private static final Map<Class<? extends TextView>, Integer> DEFAULT_STYLES;
    private final Set<Class<?>> hasTypefaceViews;
    private final int mAttrId;
    private final Map<Class<? extends TextView>, Integer> mClassStyleAttributeMap;
    private final boolean mCustomViewTypefaceSupport;
    private final FontMapper mFontMapper;
    private final String mFontPath;
    private final boolean mIsFontSet;

    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/calligraphy3/CalligraphyConfig$Builder.class */
    public static class Builder {
        public static final int INVALID_ATTR_ID = -1;
        private FontMapper fontMapper;
        private boolean customViewTypefaceSupport = false;
        private int attrId = R.attr.fontPath;
        private boolean isFontSet = false;
        private String fontAssetPath = null;
        private Map<Class<? extends TextView>, Integer> mStyleClassMap = new HashMap();
        private Set<Class<?>> mHasTypefaceClasses = new HashSet();

        public Builder addCustomStyle(Class<? extends TextView> cls, int i) {
            if (cls != null) {
                if (i == 0) {
                    return this;
                }
                this.mStyleClassMap.put(cls, Integer.valueOf(i));
            }
            return this;
        }

        public Builder addCustomViewWithSetTypeface(Class<?> cls) {
            this.customViewTypefaceSupport = true;
            this.mHasTypefaceClasses.add(cls);
            return this;
        }

        public CalligraphyConfig build() {
            this.isFontSet = !TextUtils.isEmpty(this.fontAssetPath);
            return new CalligraphyConfig(this);
        }

        public Builder setDefaultFontPath(String str) {
            this.isFontSet = !TextUtils.isEmpty(str);
            this.fontAssetPath = str;
            return this;
        }

        public Builder setFontAttrId(int i) {
            this.attrId = i;
            return this;
        }

        public Builder setFontMapper(FontMapper fontMapper) {
            this.fontMapper = fontMapper;
            return this;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        DEFAULT_STYLES = hashMap;
        hashMap.put(TextView.class, Integer.valueOf((int) android.R.attr.textViewStyle));
        DEFAULT_STYLES.put(Button.class, Integer.valueOf((int) android.R.attr.buttonStyle));
        DEFAULT_STYLES.put(EditText.class, Integer.valueOf((int) android.R.attr.editTextStyle));
        Map<Class<? extends TextView>, Integer> map = DEFAULT_STYLES;
        Integer valueOf = Integer.valueOf((int) android.R.attr.autoCompleteTextViewStyle);
        map.put(AutoCompleteTextView.class, valueOf);
        DEFAULT_STYLES.put(MultiAutoCompleteTextView.class, valueOf);
        DEFAULT_STYLES.put(CheckBox.class, Integer.valueOf((int) android.R.attr.checkboxStyle));
        DEFAULT_STYLES.put(RadioButton.class, Integer.valueOf((int) android.R.attr.radioButtonStyle));
        DEFAULT_STYLES.put(ToggleButton.class, Integer.valueOf((int) android.R.attr.buttonStyleToggle));
        if (CalligraphyUtils.canAddV7AppCompatViews()) {
            addAppCompatViews();
        }
    }

    private CalligraphyConfig(Builder builder) {
        this.mIsFontSet = builder.isFontSet;
        this.mFontPath = builder.fontAssetPath;
        this.mAttrId = builder.attrId;
        this.mCustomViewTypefaceSupport = builder.customViewTypefaceSupport;
        HashMap hashMap = new HashMap(DEFAULT_STYLES);
        hashMap.putAll(builder.mStyleClassMap);
        this.mClassStyleAttributeMap = Collections.unmodifiableMap(hashMap);
        this.hasTypefaceViews = Collections.unmodifiableSet(builder.mHasTypefaceClasses);
        this.mFontMapper = builder.fontMapper;
    }

    private static void addAppCompatViews() {
        DEFAULT_STYLES.put(AppCompatTextView.class, Integer.valueOf((int) android.R.attr.textViewStyle));
        DEFAULT_STYLES.put(AppCompatButton.class, Integer.valueOf((int) android.R.attr.buttonStyle));
        DEFAULT_STYLES.put(AppCompatEditText.class, Integer.valueOf((int) android.R.attr.editTextStyle));
        Map<Class<? extends TextView>, Integer> map = DEFAULT_STYLES;
        Integer valueOf = Integer.valueOf((int) android.R.attr.autoCompleteTextViewStyle);
        map.put(AppCompatAutoCompleteTextView.class, valueOf);
        DEFAULT_STYLES.put(AppCompatMultiAutoCompleteTextView.class, valueOf);
        DEFAULT_STYLES.put(AppCompatCheckBox.class, Integer.valueOf((int) android.R.attr.checkboxStyle));
        DEFAULT_STYLES.put(AppCompatRadioButton.class, Integer.valueOf((int) android.R.attr.radioButtonStyle));
        if (Build.VERSION.SDK_INT >= 17) {
            DEFAULT_STYLES.put(AppCompatCheckedTextView.class, Integer.valueOf((int) android.R.attr.checkedTextViewStyle));
        }
    }

    public int getAttrId() {
        return this.mAttrId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Class<? extends TextView>, Integer> getClassStyles() {
        return this.mClassStyleAttributeMap;
    }

    public FontMapper getFontMapper() {
        return this.mFontMapper;
    }

    public String getFontPath() {
        return this.mFontPath;
    }

    public boolean isCustomViewHasTypeface(View view) {
        return this.hasTypefaceViews.contains(view.getClass());
    }

    public boolean isCustomViewTypefaceSupport() {
        return this.mCustomViewTypefaceSupport;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFontSet() {
        return this.mIsFontSet;
    }
}
