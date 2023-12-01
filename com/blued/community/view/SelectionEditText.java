package com.blued.community.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.module.common.widget.emoji.view.EmojiEditText;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/SelectionEditText.class */
public class SelectionEditText extends EmojiEditText {
    private boolean isAllowInterceptParent;
    private OnSelectionChangeListener onSelectionChangeListener;
    private List<OnSelectionChangeListener> onSelectionChangeListeners;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/SelectionEditText$OnSelectionChangeListener.class */
    public interface OnSelectionChangeListener {
        void onSelectionChange(int i, int i2);
    }

    public SelectionEditText(Context context) {
        super(context);
        this.isAllowInterceptParent = false;
    }

    public SelectionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAllowInterceptParent = false;
    }

    public SelectionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAllowInterceptParent = false;
    }

    public void addOnSelectionChangeListener(OnSelectionChangeListener onSelectionChangeListener) {
        if (this.onSelectionChangeListeners == null) {
            this.onSelectionChangeListeners = new ArrayList();
        }
        this.onSelectionChangeListeners.add(onSelectionChangeListener);
    }

    public void clearOnSelectionChangedListener() {
        List<OnSelectionChangeListener> list = this.onSelectionChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.blued.android.module.common.widget.emoji.view.EmojiEditText, android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        OnSelectionChangeListener onSelectionChangeListener = this.onSelectionChangeListener;
        if (onSelectionChangeListener != null) {
            onSelectionChangeListener.onSelectionChange(i, i2);
        }
        if (this.onSelectionChangeListeners == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.onSelectionChangeListeners.size()) {
                return;
            }
            this.onSelectionChangeListeners.get(i4).onSelectionChange(i, i2);
            i3 = i4 + 1;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnSelectionChangedListener(OnSelectionChangeListener onSelectionChangeListener) {
        List<OnSelectionChangeListener> list = this.onSelectionChangeListeners;
        if (list != null) {
            list.remove(onSelectionChangeListener);
        }
    }

    public void setAllowInterceptParent() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.view.SelectionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == SelectionEditText.this.getId()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public void setOnSelectionChangeListener(OnSelectionChangeListener onSelectionChangeListener) {
        this.onSelectionChangeListener = onSelectionChangeListener;
    }
}
