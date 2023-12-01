package com.blued.android.chat.utils;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/AsyncHelperChat.class */
public class AsyncHelperChat extends AsyncTask<Void, Void, Void> {
    private OnAsyncListener onAsyncListener;
    private ProgressDialog progressDialog;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/AsyncHelperChat$OnAsyncListener.class */
    public interface OnAsyncListener {
        void onAsyncDoInBackground();

        void onAsyncFinish();

        void onAsyncStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        OnAsyncListener onAsyncListener = this.onAsyncListener;
        if (onAsyncListener != null) {
            onAsyncListener.onAsyncDoInBackground();
            return null;
        }
        return null;
    }

    public ProgressDialog getProgressDialog() {
        return this.progressDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Void r4) {
        super.onPostExecute((AsyncHelperChat) r4);
        OnAsyncListener onAsyncListener = this.onAsyncListener;
        if (onAsyncListener != null) {
            onAsyncListener.onAsyncFinish();
        }
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.show();
        }
        OnAsyncListener onAsyncListener = this.onAsyncListener;
        if (onAsyncListener != null) {
            onAsyncListener.onAsyncStart();
        }
    }

    public void setOnAsyncListener(OnAsyncListener onAsyncListener) {
        this.onAsyncListener = onAsyncListener;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }
}
