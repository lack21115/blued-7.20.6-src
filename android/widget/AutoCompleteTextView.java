package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.PopupWindow;
import com.android.internal.R;
import java.lang.ref.WeakReference;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView.class */
public class AutoCompleteTextView extends EditText implements Filter.FilterListener {
    static final boolean DEBUG = false;
    static final int EXPAND_MAX = 3;
    static final String TAG = "AutoCompleteTextView";
    private ListAdapter mAdapter;
    private boolean mBlockCompletion;
    private int mDropDownAnchorId;
    private boolean mDropDownDismissedOnCompletion;
    private Filter mFilter;
    private int mHintResource;
    private CharSequence mHintText;
    private TextView mHintView;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mLastKeyCode;
    private PopupDataSetObserver mObserver;
    private boolean mOpenBefore;
    private PassThroughClickListener mPassThroughClickListener;
    private ListPopupWindow mPopup;
    private boolean mPopupCanBeUpdated;
    private int mThreshold;
    private Validator mValidator;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$DropDownItemClickListener.class */
    private class DropDownItemClickListener implements AdapterView.OnItemClickListener {
        private DropDownItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            AutoCompleteTextView.this.performCompletion(view, i, j);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$MyWatcher.class */
    private class MyWatcher implements TextWatcher {
        private MyWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView.this.doAfterTextChanged();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AutoCompleteTextView.this.doBeforeTextChanged();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$OnDismissListener.class */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$PassThroughClickListener.class */
    private class PassThroughClickListener implements View.OnClickListener {
        private View.OnClickListener mWrapped;

        private PassThroughClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoCompleteTextView.this.onClickImpl();
            if (this.mWrapped != null) {
                this.mWrapped.onClick(view);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$PopupDataSetObserver.class */
    private static class PopupDataSetObserver extends DataSetObserver {
        private final WeakReference<AutoCompleteTextView> mViewReference;
        private final Runnable updateRunnable;

        private PopupDataSetObserver(AutoCompleteTextView autoCompleteTextView) {
            this.updateRunnable = new Runnable() { // from class: android.widget.AutoCompleteTextView.PopupDataSetObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    ListAdapter listAdapter;
                    AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) PopupDataSetObserver.this.mViewReference.get();
                    if (autoCompleteTextView2 == null || (listAdapter = autoCompleteTextView2.mAdapter) == null) {
                        return;
                    }
                    autoCompleteTextView2.updateDropDownForFilter(listAdapter.getCount());
                }
            };
            this.mViewReference = new WeakReference<>(autoCompleteTextView);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AutoCompleteTextView autoCompleteTextView = this.mViewReference.get();
            if (autoCompleteTextView == null || autoCompleteTextView.mAdapter == null) {
                return;
            }
            autoCompleteTextView.post(this.updateRunnable);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AutoCompleteTextView$Validator.class */
    public interface Validator {
        CharSequence fixText(CharSequence charSequence);

        boolean isValid(CharSequence charSequence);
    }

    public AutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDropDownDismissedOnCompletion = true;
        this.mLastKeyCode = 0;
        this.mValidator = null;
        this.mPopupCanBeUpdated = true;
        this.mPopup = new ListPopupWindow(context, attributeSet, i, i2);
        this.mPopup.setSoftInputMode(16);
        this.mPopup.setPromptPosition(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoCompleteTextView, i, i2);
        this.mThreshold = obtainStyledAttributes.getInt(2, 2);
        this.mPopup.setListSelector(obtainStyledAttributes.getDrawable(3));
        this.mDropDownAnchorId = obtainStyledAttributes.getResourceId(6, -1);
        this.mPopup.setWidth(obtainStyledAttributes.getLayoutDimension(5, -2));
        this.mPopup.setHeight(obtainStyledAttributes.getLayoutDimension(7, -2));
        this.mHintResource = obtainStyledAttributes.getResourceId(1, R.layout.simple_dropdown_hint);
        this.mPopup.setOnItemClickListener(new DropDownItemClickListener());
        setCompletionHint(obtainStyledAttributes.getText(0));
        int inputType = getInputType();
        if ((inputType & 15) == 1) {
            setRawInputType(inputType | 65536);
        }
        obtainStyledAttributes.recycle();
        setFocusable(true);
        addTextChangedListener(new MyWatcher());
        this.mPassThroughClickListener = new PassThroughClickListener();
        super.setOnClickListener(this.mPassThroughClickListener);
    }

    private void buildImeCompletions() {
        InputMethodManager peekInstance;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || (peekInstance = InputMethodManager.peekInstance()) == null) {
            return;
        }
        int min = Math.min(listAdapter.getCount(), 20);
        CompletionInfo[] completionInfoArr = new CompletionInfo[min];
        int i = 0;
        int i2 = 0;
        while (i2 < min) {
            int i3 = i;
            if (listAdapter.isEnabled(i2)) {
                completionInfoArr[i] = new CompletionInfo(listAdapter.getItemId(i2), i, convertSelectionToString(listAdapter.getItem(i2)));
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        CompletionInfo[] completionInfoArr2 = completionInfoArr;
        if (i != min) {
            completionInfoArr2 = new CompletionInfo[i];
            System.arraycopy(completionInfoArr, 0, completionInfoArr2, 0, i);
        }
        peekInstance.displayCompletions(this, completionInfoArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickImpl() {
        if (isPopupShowing()) {
            ensureImeVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r9 < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void performCompletion(android.view.View r8, int r9, long r10) {
        /*
            r7 = this;
            r0 = r7
            boolean r0 = r0.isPopupShowing()
            if (r0 == 0) goto L83
            r0 = r9
            if (r0 >= 0) goto L23
            r0 = r7
            android.widget.ListPopupWindow r0 = r0.mPopup
            java.lang.Object r0 = r0.getSelectedItem()
            r13 = r0
        L14:
            r0 = r13
            if (r0 != 0) goto L32
            java.lang.String r0 = "AutoCompleteTextView"
            java.lang.String r1 = "performCompletion: no selected item"
            int r0 = android.util.Log.w(r0, r1)
        L22:
            return
        L23:
            r0 = r7
            android.widget.ListAdapter r0 = r0.mAdapter
            r1 = r9
            java.lang.Object r0 = r0.getItem(r1)
            r13 = r0
            goto L14
        L32:
            r0 = r7
            r1 = 1
            r0.mBlockCompletion = r1
            r0 = r7
            r1 = r7
            r2 = r13
            java.lang.CharSequence r1 = r1.convertSelectionToString(r2)
            r0.replaceText(r1)
            r0 = r7
            r1 = 0
            r0.mBlockCompletion = r1
            r0 = r7
            android.widget.AdapterView$OnItemClickListener r0 = r0.mItemClickListener
            if (r0 == 0) goto L83
            r0 = r7
            android.widget.ListPopupWindow r0 = r0.mPopup
            r13 = r0
            r0 = r8
            if (r0 == 0) goto L5e
            r0 = r9
            r12 = r0
            r0 = r9
            if (r0 >= 0) goto L71
        L5e:
            r0 = r13
            android.view.View r0 = r0.getSelectedView()
            r8 = r0
            r0 = r13
            int r0 = r0.getSelectedItemPosition()
            r12 = r0
            r0 = r13
            long r0 = r0.getSelectedItemId()
            r10 = r0
        L71:
            r0 = r7
            android.widget.AdapterView$OnItemClickListener r0 = r0.mItemClickListener
            r1 = r13
            android.widget.ListView r1 = r1.getListView()
            r2 = r8
            r3 = r12
            r4 = r10
            r0.onItemClick(r1, r2, r3, r4)
        L83:
            r0 = r7
            boolean r0 = r0.mDropDownDismissedOnCompletion
            if (r0 == 0) goto L22
            r0 = r7
            android.widget.ListPopupWindow r0 = r0.mPopup
            boolean r0 = r0.isDropDownAlwaysVisible()
            if (r0 != 0) goto L22
            r0 = r7
            r0.dismissDropDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.AutoCompleteTextView.performCompletion(android.view.View, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDropDownForFilter(int i) {
        if (getWindowVisibility() == 8) {
            return;
        }
        boolean isDropDownAlwaysVisible = this.mPopup.isDropDownAlwaysVisible();
        boolean enoughToFilter = enoughToFilter();
        if ((i > 0 || isDropDownAlwaysVisible) && enoughToFilter) {
            if (hasFocus() && hasWindowFocus() && this.mPopupCanBeUpdated) {
                showDropDown();
            }
        } else if (isDropDownAlwaysVisible || !isPopupShowing()) {
        } else {
            dismissDropDown();
            this.mPopupCanBeUpdated = true;
        }
    }

    public void clearListSelection() {
        this.mPopup.clearListSelection();
    }

    protected CharSequence convertSelectionToString(Object obj) {
        return this.mFilter.convertResultToString(obj);
    }

    public void dismissDropDown() {
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (peekInstance != null) {
            peekInstance.displayCompletions(this, null);
        }
        this.mPopup.dismiss();
        this.mPopupCanBeUpdated = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doAfterTextChanged() {
        if (this.mBlockCompletion) {
            return;
        }
        if (!this.mOpenBefore || isPopupShowing()) {
            if (enoughToFilter()) {
                if (this.mFilter != null) {
                    this.mPopupCanBeUpdated = true;
                    performFiltering(getText(), this.mLastKeyCode);
                    return;
                }
                return;
            }
            if (!this.mPopup.isDropDownAlwaysVisible()) {
                dismissDropDown();
            }
            if (this.mFilter != null) {
                this.mFilter.filter(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doBeforeTextChanged() {
        if (this.mBlockCompletion) {
            return;
        }
        this.mOpenBefore = isPopupShowing();
    }

    public boolean enoughToFilter() {
        return getText().length() >= this.mThreshold;
    }

    public void ensureImeVisible(boolean z) {
        this.mPopup.setInputMethodMode(z ? 1 : 2);
        if (this.mPopup.isDropDownAlwaysVisible() || (this.mFilter != null && enoughToFilter())) {
            showDropDown();
        }
    }

    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    public CharSequence getCompletionHint() {
        return this.mHintText;
    }

    public int getDropDownAnchor() {
        return this.mDropDownAnchorId;
    }

    public int getDropDownAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getDropDownBackground() {
        return this.mPopup.getBackground();
    }

    public int getDropDownHeight() {
        return this.mPopup.getHeight();
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup.getHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup.getVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.mPopup.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Filter getFilter() {
        return this.mFilter;
    }

    @Deprecated
    public AdapterView.OnItemClickListener getItemClickListener() {
        return this.mItemClickListener;
    }

    @Deprecated
    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        return this.mItemSelectedListener;
    }

    public int getListSelection() {
        return this.mPopup.getSelectedItemPosition();
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return this.mItemClickListener;
    }

    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return this.mItemSelectedListener;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public Validator getValidator() {
        return this.mValidator;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mPopup.isDropDownAlwaysVisible();
    }

    public boolean isDropDownDismissedOnCompletion() {
        return this.mDropDownDismissedOnCompletion;
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean isPerformingCompletion() {
        return this.mBlockCompletion;
    }

    public boolean isPopupShowing() {
        return this.mPopup.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo completionInfo) {
        if (isPopupShowing()) {
            this.mPopup.performItemClick(completionInfo.getPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        dismissDropDown();
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDisplayHint(int i) {
        super.onDisplayHint(i);
        switch (i) {
            case 4:
                if (this.mPopup.isDropDownAlwaysVisible()) {
                    return;
                }
                dismissDropDown();
                return;
            default:
                return;
        }
    }

    @Override // android.widget.Filter.FilterListener
    public void onFilterComplete(int i) {
        updateDropDownForFilter(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.mTemporaryDetach) {
            return;
        }
        if (!z) {
            performValidation();
        }
        if (z || this.mPopup.isDropDownAlwaysVisible()) {
            return;
        }
        dismissDropDown();
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (!this.mPopup.onKeyDown(i, keyEvent)) {
            if (!isPopupShowing()) {
                switch (i) {
                    case 20:
                        if (keyEvent.hasNoModifiers()) {
                            performValidation();
                            break;
                        }
                        break;
                }
            }
            if (!isPopupShowing() || i != 61 || !keyEvent.hasNoModifiers()) {
                this.mLastKeyCode = i;
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                this.mLastKeyCode = 0;
                z = onKeyDown;
                if (onKeyDown) {
                    z = onKeyDown;
                    if (isPopupShowing()) {
                        clearListSelection();
                        return onKeyDown;
                    }
                }
            }
        }
        return z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isPopupShowing() && !this.mPopup.isDropDownAlwaysVisible()) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismissDropDown();
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mPopup.onKeyUp(i, keyEvent)) {
            switch (i) {
                case 23:
                case 61:
                case 66:
                    if (keyEvent.hasNoModifiers()) {
                        performCompletion();
                        return true;
                    }
                    return true;
            }
        }
        if (isPopupShowing() && i == 61 && keyEvent.hasNoModifiers()) {
            performCompletion();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z || this.mPopup.isDropDownAlwaysVisible()) {
            return;
        }
        dismissDropDown();
    }

    public void performCompletion() {
        performCompletion(null, -1, -1L);
    }

    protected void performFiltering(CharSequence charSequence, int i) {
        this.mFilter.filter(charSequence, this);
    }

    public void performValidation() {
        if (this.mValidator == null) {
            return;
        }
        Editable text = getText();
        if (TextUtils.isEmpty(text) || this.mValidator.isValid(text)) {
            return;
        }
        setText(this.mValidator.fixText(text));
    }

    protected void replaceText(CharSequence charSequence) {
        clearComposingText();
        setText(charSequence);
        Editable text = getText();
        Selection.setSelection(text, text.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = t;
        if (this.mAdapter != null) {
            this.mFilter = ((Filterable) this.mAdapter).getFilter();
            t.registerDataSetObserver(this.mObserver);
        } else {
            this.mFilter = null;
        }
        this.mPopup.setAdapter(this.mAdapter);
    }

    public void setCompletionHint(CharSequence charSequence) {
        this.mHintText = charSequence;
        if (charSequence == null) {
            this.mPopup.setPromptView(null);
            this.mHintView = null;
        } else if (this.mHintView != null) {
            this.mHintView.setText(charSequence);
        } else {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(this.mHintResource, (ViewGroup) null).findViewById(R.id.text1);
            textView.setText(this.mHintText);
            this.mHintView = textView;
            this.mPopup.setPromptView(textView);
        }
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.mPopup.setDropDownAlwaysVisible(z);
    }

    public void setDropDownAnchor(int i) {
        this.mDropDownAnchorId = i;
        this.mPopup.setAnchorView(null);
    }

    public void setDropDownAnimationStyle(int i) {
        this.mPopup.setAnimationStyle(i);
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setDropDownBackgroundResource(int i) {
        this.mPopup.setBackgroundDrawable(getContext().getDrawable(i));
    }

    public void setDropDownDismissedOnCompletion(boolean z) {
        this.mDropDownDismissedOnCompletion = z;
    }

    public void setDropDownHeight(int i) {
        this.mPopup.setHeight(i);
    }

    public void setDropDownHorizontalOffset(int i) {
        this.mPopup.setHorizontalOffset(i);
    }

    public void setDropDownVerticalOffset(int i) {
        this.mPopup.setVerticalOffset(i);
    }

    public void setDropDownWidth(int i) {
        this.mPopup.setWidth(i);
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mPopup.setForceIgnoreOutsideTouch(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (isPopupShowing()) {
            showDropDown();
        }
        return frame;
    }

    public void setListSelection(int i) {
        this.mPopup.setSelection(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mPassThroughClickListener.mWrapped = onClickListener;
    }

    public void setOnDismissListener(final OnDismissListener onDismissListener) {
        PopupWindow.OnDismissListener onDismissListener2 = null;
        if (onDismissListener != null) {
            onDismissListener2 = new PopupWindow.OnDismissListener() { // from class: android.widget.AutoCompleteTextView.1
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    onDismissListener.onDismiss();
                }
            };
        }
        this.mPopup.setOnDismissListener(onDismissListener2);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setText(charSequence);
            return;
        }
        this.mBlockCompletion = true;
        setText(charSequence);
        this.mBlockCompletion = false;
    }

    public void setThreshold(int i) {
        int i2 = i;
        if (i <= 0) {
            i2 = 1;
        }
        this.mThreshold = i2;
    }

    public void setValidator(Validator validator) {
        this.mValidator = validator;
    }

    public void showDropDown() {
        buildImeCompletions();
        if (this.mPopup.getAnchorView() == null) {
            if (this.mDropDownAnchorId != -1) {
                this.mPopup.setAnchorView(getRootView().findViewById(this.mDropDownAnchorId));
            } else {
                this.mPopup.setAnchorView(this);
            }
        }
        if (!isPopupShowing()) {
            this.mPopup.setInputMethodMode(1);
            this.mPopup.setListItemExpandMax(3);
        }
        this.mPopup.show();
        this.mPopup.getListView().setOverScrollMode(0);
    }

    public void showDropDownAfterLayout() {
        this.mPopup.postShow();
    }
}
