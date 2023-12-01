package com.blued.community.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.community.R;
import com.bytedance.applog.tracker.Tracker;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/EditInputNumView.class */
public class EditInputNumView extends AppCompatTextView implements BluedSkinSupportable {
    private static final int EMPTY_NUM = 0;
    private static final String SPLIT_MARK = " / ";
    private int editMaxLength;
    private int editShowType;
    private EditText editText;
    private int inTextColor;
    private boolean isChineseAsTwo;
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private int outTextColor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/EditInputNumView$showType.class */
    public interface showType {
        public static final int always = 1;
        public static final int has_content = 3;
        public static final int has_focus = 2;
    }

    public EditInputNumView(Context context) {
        this(context, null);
    }

    public EditInputNumView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditInputNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inTextColor = R.color.syc_j;
        this.outTextColor = R.color.syc_g;
        this.editMaxLength = 256;
        this.editShowType = 1;
        this.isChineseAsTwo = false;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        initView(attributeSet);
    }

    private int calculateTextLength(CharSequence charSequence) {
        int i;
        int i2;
        if (this.isChineseAsTwo) {
            int i3 = 0;
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                if (charSequence.charAt(i4) < 128) {
                    i = i3;
                    i2 = 1;
                } else {
                    i = i3;
                    i2 = 2;
                }
                i3 = i + i2;
            }
            return i3;
        }
        return charSequence.length();
    }

    private int getEditLength() {
        EditText editText = this.editText;
        if (editText == null) {
            return 0;
        }
        return calculateTextLength(editText.getText());
    }

    private void initView(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.EditInputNumView);
            this.inTextColor = obtainAttributes.getResourceId(R.styleable.EditInputNumView_inTextColor, R.color.syc_j);
            this.outTextColor = obtainAttributes.getResourceId(R.styleable.EditInputNumView_outTextColor, R.color.syc_g);
            this.editMaxLength = obtainAttributes.getInteger(R.styleable.EditInputNumView_editMaxLength, 256);
            this.editShowType = obtainAttributes.getInt(R.styleable.EditInputNumView_editShowType, 1);
            obtainAttributes.recycle();
        }
        setTextColor(BluedSkinUtils.a(getContext(), this.inTextColor));
        setInputText(0);
        if (this.editShowType != 1) {
            setVisibility(4);
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public int getEditMaxLength() {
        return this.editMaxLength;
    }

    public int getInTextColor() {
        return this.inTextColor;
    }

    public int getOutTextColor() {
        return this.outTextColor;
    }

    public void init(EditText editText) {
        this.editText = editText;
        setInputText(getEditLength());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.view.EditInputNumView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if (EditInputNumView.this.editShowType == 3) {
                    if (length > 0) {
                        EditInputNumView.this.setVisibility(0);
                    } else {
                        EditInputNumView.this.setVisibility(4);
                    }
                }
                EditInputNumView.this.setInputText(length);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.view.EditInputNumView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (EditInputNumView.this.editShowType == 2) {
                    if (z) {
                        EditInputNumView.this.setVisibility(0);
                    } else {
                        EditInputNumView.this.setVisibility(4);
                    }
                }
            }
        });
    }

    public void init(EditText editText, int i) {
        init(editText, i, false);
    }

    public void init(EditText editText, int i, boolean z) {
        this.editMaxLength = i;
        this.isChineseAsTwo = z;
        init(editText);
    }

    public boolean isOutOfBounds() {
        return getEditLength() > this.editMaxLength;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setEditMaxLength(int i) {
        if (i > 0) {
            this.editMaxLength = i;
        }
        if (this.editText != null) {
            setInputText(getEditLength());
        } else {
            setInputText(0);
        }
    }

    public void setInTextColor(int i) {
        this.inTextColor = i;
    }

    public void setInputText(int i) {
        if (isOutOfBounds()) {
            setTextColor(getContext().getResources().getColor(this.outTextColor));
            setText(i + SPLIT_MARK + this.editMaxLength);
            return;
        }
        setTextColor(getContext().getResources().getColor(this.inTextColor));
        setText(i + SPLIT_MARK + this.editMaxLength);
    }

    public void setOutTextColor(int i) {
        this.outTextColor = i;
    }
}
