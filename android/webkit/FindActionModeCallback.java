package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/FindActionModeCallback.class */
public class FindActionModeCallback implements ActionMode.Callback, TextWatcher, View.OnClickListener, WebView.FindListener {
    private ActionMode mActionMode;
    private int mActiveMatchIndex;
    private View mCustomView;
    private EditText mEditText;
    private InputMethodManager mInput;
    private TextView mMatches;
    private boolean mMatchesFound;
    private int mNumberOfMatches;
    private Resources mResources;
    private WebView mWebView;
    private Rect mGlobalVisibleRect = new Rect();
    private Point mGlobalVisibleOffset = new Point();

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/FindActionModeCallback$NoAction.class */
    public static class NoAction implements ActionMode.Callback {
        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public FindActionModeCallback(Context context) {
        this.mCustomView = LayoutInflater.from(context).inflate(R.layout.webview_find, (ViewGroup) null);
        this.mEditText = (EditText) this.mCustomView.findViewById(16908291);
        this.mEditText.setCustomSelectionActionModeCallback(new NoAction());
        this.mEditText.setOnClickListener(this);
        setText("");
        this.mMatches = (TextView) this.mCustomView.findViewById(R.id.matches);
        this.mInput = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        this.mResources = context.getResources();
    }

    private void findNext(boolean z) {
        if (this.mWebView == null) {
            throw new AssertionError("No WebView for FindActionModeCallback::findNext");
        }
        if (!this.mMatchesFound) {
            findAll();
        } else if (this.mNumberOfMatches != 0) {
            this.mWebView.findNext(z);
            updateMatchesString();
        }
    }

    private void updateMatchesString() {
        if (this.mNumberOfMatches == 0) {
            this.mMatches.setText(R.string.no_matches);
        } else {
            this.mMatches.setText(this.mResources.getQuantityString(R.plurals.matches_found, this.mNumberOfMatches, Integer.valueOf(this.mActiveMatchIndex + 1), Integer.valueOf(this.mNumberOfMatches)));
        }
        this.mMatches.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void findAll() {
        if (this.mWebView == null) {
            throw new AssertionError("No WebView for FindActionModeCallback::findAll");
        }
        Editable text = this.mEditText.getText();
        if (text.length() == 0) {
            this.mWebView.clearMatches();
            this.mMatches.setVisibility(8);
            this.mMatchesFound = false;
            this.mWebView.findAll(null);
            return;
        }
        this.mMatchesFound = true;
        this.mMatches.setVisibility(4);
        this.mNumberOfMatches = 0;
        this.mWebView.findAllAsync(text.toString());
    }

    public void finish() {
        this.mActionMode.finish();
    }

    public int getActionModeGlobalBottom() {
        if (this.mActionMode == null) {
            return 0;
        }
        View view = (View) this.mCustomView.getParent();
        View view2 = view;
        if (view == null) {
            view2 = this.mCustomView;
        }
        view2.getGlobalVisibleRect(this.mGlobalVisibleRect, this.mGlobalVisibleOffset);
        return this.mGlobalVisibleRect.bottom;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (this.mWebView == null) {
            throw new AssertionError("No WebView for FindActionModeCallback::onActionItemClicked");
        }
        this.mInput.hideSoftInputFromWindow(this.mWebView.getWindowToken(), 0);
        switch (menuItem.getItemId()) {
            case R.id.find_prev /* 16909290 */:
                findNext(false);
                return true;
            case R.id.find_next /* 16909291 */:
                findNext(true);
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        findNext(true);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (actionMode.isUiFocusable()) {
            actionMode.setCustomView(this.mCustomView);
            actionMode.getMenuInflater().inflate(R.menu.webview_find, menu);
            this.mActionMode = actionMode;
            Editable text = this.mEditText.getText();
            Selection.setSelection(text, text.length());
            this.mMatches.setVisibility(8);
            this.mMatchesFound = false;
            this.mMatches.setText("0");
            this.mEditText.requestFocus();
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.mActionMode = null;
        this.mWebView.notifyFindDialogDismissed();
        this.mWebView.setFindDialogFindListener(null);
        this.mInput.hideSoftInputFromWindow(this.mWebView.getWindowToken(), 0);
    }

    @Override // android.webkit.WebView.FindListener
    public void onFindResultReceived(int i, int i2, boolean z) {
        if (z) {
            updateMatchCount(i, i2, i2 == 0);
        }
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        findAll();
    }

    public void setText(String str) {
        this.mEditText.setText(str);
        Editable text = this.mEditText.getText();
        int length = text.length();
        Selection.setSelection(text, length, length);
        text.setSpan(this, 0, length, 18);
        this.mMatchesFound = false;
    }

    public void setWebView(WebView webView) {
        if (webView == null) {
            throw new AssertionError("WebView supplied to FindActionModeCallback cannot be null");
        }
        this.mWebView = webView;
        this.mWebView.setFindDialogFindListener(this);
    }

    public void showSoftInput() {
        this.mInput.startGettingWindowFocus(this.mEditText.getRootView());
        this.mInput.focusIn(this.mEditText);
        this.mInput.showSoftInput(this.mEditText, 0);
    }

    public void updateMatchCount(int i, int i2, boolean z) {
        if (z) {
            this.mMatches.setVisibility(8);
            this.mNumberOfMatches = 0;
            return;
        }
        this.mNumberOfMatches = i2;
        this.mActiveMatchIndex = i;
        updateMatchesString();
    }
}
