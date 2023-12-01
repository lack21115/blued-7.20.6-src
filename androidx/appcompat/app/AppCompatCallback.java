package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/AppCompatCallback.class */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode actionMode);

    void onSupportActionModeStarted(ActionMode actionMode);

    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback);
}
