package com.blued.android.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;
import com.blued.android.framework.utils.SearchTaskTool;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SearchEditText.class */
public class SearchEditText extends AppCompatEditText {
    private SearchTaskTool a;

    public SearchEditText(Context context) {
        this(context, null);
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setInputType(1);
        this.a = new SearchTaskTool(this);
    }

    public void a() {
        SearchTaskTool searchTaskTool = this.a;
        if (searchTaskTool != null) {
            searchTaskTool.a();
        }
    }

    public void a(SearchTaskTool.TaskListener taskListener) {
        SearchTaskTool searchTaskTool = this.a;
        if (searchTaskTool != null) {
            searchTaskTool.a(taskListener);
        }
    }

    public void setDelaymillis(long j) {
        SearchTaskTool searchTaskTool = this.a;
        if (searchTaskTool != null) {
            searchTaskTool.a(j);
        }
    }

    public void setEditorActionListener(boolean z) {
        SearchTaskTool searchTaskTool = this.a;
        if (searchTaskTool != null) {
            searchTaskTool.a(z);
        }
    }
}
