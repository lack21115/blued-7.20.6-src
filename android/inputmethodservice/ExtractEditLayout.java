package android.inputmethodservice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/ExtractEditLayout.class */
public class ExtractEditLayout extends LinearLayout {
    ExtractActionMode mActionMode;
    Button mEditButton;
    Button mExtractActionButton;

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/ExtractEditLayout$ExtractActionMode.class */
    private class ExtractActionMode extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        MenuBuilder mMenu;

        public ExtractActionMode(ActionMode.Callback callback) {
            this.mMenu = new MenuBuilder(ExtractEditLayout.this.getContext());
            this.mMenu.setCallback(this);
            this.mCallback = callback;
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // android.view.ActionMode
        public void finish() {
            if (ExtractEditLayout.this.mActionMode != this) {
                return;
            }
            this.mCallback.onDestroyActionMode(this);
            this.mCallback = null;
            this.mMenu.close();
            ExtractEditLayout.this.mExtractActionButton.setVisibility(0);
            ExtractEditLayout.this.mEditButton.setVisibility(4);
            ExtractEditLayout.this.sendAccessibilityEvent(32);
            ExtractEditLayout.this.mActionMode = null;
        }

        @Override // android.view.ActionMode
        public View getCustomView() {
            return null;
        }

        @Override // android.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // android.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new MenuInflater(ExtractEditLayout.this.getContext());
        }

        @Override // android.view.ActionMode
        public CharSequence getSubtitle() {
            return null;
        }

        @Override // android.view.ActionMode
        public CharSequence getTitle() {
            return null;
        }

        @Override // android.view.ActionMode
        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // android.view.ActionMode
        public boolean isTitleOptional() {
            return true;
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }

        @Override // android.view.ActionMode
        public void setCustomView(View view) {
        }

        @Override // android.view.ActionMode
        public void setSubtitle(int i) {
        }

        @Override // android.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
        }

        @Override // android.view.ActionMode
        public void setTitle(int i) {
        }

        @Override // android.view.ActionMode
        public void setTitle(CharSequence charSequence) {
        }
    }

    public ExtractEditLayout(Context context) {
        super(context);
    }

    public ExtractEditLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void finishActionMode() {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
    }

    public boolean isActionModeStarted() {
        return this.mActionMode != null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mExtractActionButton = (Button) findViewById(16909074);
        this.mEditButton = (Button) findViewById(16909075);
        this.mEditButton.setOnClickListener(new View.OnClickListener() { // from class: android.inputmethodservice.ExtractEditLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtractEditLayout.this.mActionMode != null) {
                    new MenuPopupHelper(ExtractEditLayout.this.getContext(), ExtractEditLayout.this.mActionMode.mMenu, view).show();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        ExtractActionMode extractActionMode = new ExtractActionMode(callback);
        if (extractActionMode.dispatchOnCreate()) {
            extractActionMode.invalidate();
            this.mExtractActionButton.setVisibility(4);
            this.mEditButton.setVisibility(0);
            this.mActionMode = extractActionMode;
            sendAccessibilityEvent(32);
            return extractActionMode;
        }
        return null;
    }
}
