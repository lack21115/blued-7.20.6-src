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
        hashMap.put(TextView.class, 16842884);
        DEFAULT_STYLES.put(Button.class, 16842824);
        DEFAULT_STYLES.put(EditText.class, 16842862);
        DEFAULT_STYLES.put(AutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(MultiAutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(CheckBox.class, 16842860);
        DEFAULT_STYLES.put(RadioButton.class, 16842878);
        DEFAULT_STYLES.put(ToggleButton.class, 16842827);
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
        DEFAULT_STYLES.put(AppCompatTextView.class, 16842884);
        DEFAULT_STYLES.put(AppCompatButton.class, 16842824);
        DEFAULT_STYLES.put(AppCompatEditText.class, 16842862);
        DEFAULT_STYLES.put(AppCompatAutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(AppCompatMultiAutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(AppCompatCheckBox.class, 16842860);
        DEFAULT_STYLES.put(AppCompatRadioButton.class, 16842878);
        if (Build.VERSION.SDK_INT >= 17) {
            DEFAULT_STYLES.put(AppCompatCheckedTextView.class, 16843720);
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
