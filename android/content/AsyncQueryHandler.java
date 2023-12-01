package android.content;

import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/content/AsyncQueryHandler.class */
public abstract class AsyncQueryHandler extends Handler {
    private static final int EVENT_ARG_DELETE = 4;
    private static final int EVENT_ARG_INSERT = 2;
    private static final int EVENT_ARG_QUERY = 1;
    private static final int EVENT_ARG_UPDATE = 3;
    private static final String TAG = "AsyncQuery";
    private static final boolean localLOGV = false;
    private static Looper sLooper = null;
    final WeakReference<ContentResolver> mResolver;
    private Handler mWorkerThreadHandler;

    /* loaded from: source-9557208-dex2jar.jar:android/content/AsyncQueryHandler$WorkerArgs.class */
    protected static final class WorkerArgs {
        public Object cookie;
        public Handler handler;
        public String orderBy;
        public String[] projection;
        public Object result;
        public String selection;
        public String[] selectionArgs;
        public Uri uri;
        public ContentValues values;

        protected WorkerArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-9557208-dex2jar.jar:android/content/AsyncQueryHandler$WorkerHandler.class */
    public class WorkerHandler extends Handler {
        public WorkerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Cursor cursor;
            ContentResolver contentResolver = AsyncQueryHandler.this.mResolver.get();
            if (contentResolver == null) {
                return;
            }
            WorkerArgs workerArgs = (WorkerArgs) message.obj;
            int i = message.what;
            switch (message.arg1) {
                case 1:
                    try {
                        Cursor query = contentResolver.query(workerArgs.uri, workerArgs.projection, workerArgs.selection, workerArgs.selectionArgs, workerArgs.orderBy);
                        cursor = query;
                        if (query != null) {
                            query.getCount();
                            cursor = query;
                        }
                    } catch (Exception e) {
                        Log.w(AsyncQueryHandler.TAG, "Exception thrown during handling EVENT_ARG_QUERY", e);
                        cursor = null;
                    }
                    workerArgs.result = cursor;
                    break;
                case 2:
                    workerArgs.result = contentResolver.insert(workerArgs.uri, workerArgs.values);
                    break;
                case 3:
                    workerArgs.result = Integer.valueOf(contentResolver.update(workerArgs.uri, workerArgs.values, workerArgs.selection, workerArgs.selectionArgs));
                    break;
                case 4:
                    workerArgs.result = Integer.valueOf(contentResolver.delete(workerArgs.uri, workerArgs.selection, workerArgs.selectionArgs));
                    break;
            }
            Message obtainMessage = workerArgs.handler.obtainMessage(i);
            obtainMessage.obj = workerArgs;
            obtainMessage.arg1 = message.arg1;
            obtainMessage.sendToTarget();
        }
    }

    public AsyncQueryHandler(ContentResolver contentResolver) {
        this.mResolver = new WeakReference<>(contentResolver);
        synchronized (AsyncQueryHandler.class) {
            try {
                if (sLooper == null) {
                    HandlerThread handlerThread = new HandlerThread("AsyncQueryWorker");
                    handlerThread.start();
                    sLooper = handlerThread.getLooper();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mWorkerThreadHandler = createHandler(sLooper);
    }

    public final void cancelOperation(int i) {
        this.mWorkerThreadHandler.removeMessages(i);
    }

    protected Handler createHandler(Looper looper) {
        return new WorkerHandler(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WorkerArgs workerArgs = (WorkerArgs) message.obj;
        int i = message.what;
        switch (message.arg1) {
            case 1:
                onQueryComplete(i, workerArgs.cookie, (Cursor) workerArgs.result);
                return;
            case 2:
                onInsertComplete(i, workerArgs.cookie, (Uri) workerArgs.result);
                return;
            case 3:
                onUpdateComplete(i, workerArgs.cookie, ((Integer) workerArgs.result).intValue());
                return;
            case 4:
                onDeleteComplete(i, workerArgs.cookie, ((Integer) workerArgs.result).intValue());
                return;
            default:
                return;
        }
    }

    protected void onDeleteComplete(int i, Object obj, int i2) {
    }

    protected void onInsertComplete(int i, Object obj, Uri uri) {
    }

    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    protected void onUpdateComplete(int i, Object obj, int i2) {
    }

    public final void startDelete(int i, Object obj, Uri uri, String str, String[] strArr) {
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        obtainMessage.arg1 = 4;
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.uri = uri;
        workerArgs.cookie = obj;
        workerArgs.selection = str;
        workerArgs.selectionArgs = strArr;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public final void startInsert(int i, Object obj, Uri uri, ContentValues contentValues) {
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        obtainMessage.arg1 = 2;
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.uri = uri;
        workerArgs.cookie = obj;
        workerArgs.values = contentValues;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public void startQuery(int i, Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        obtainMessage.arg1 = 1;
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.uri = uri;
        workerArgs.projection = strArr;
        workerArgs.selection = str;
        workerArgs.selectionArgs = strArr2;
        workerArgs.orderBy = str2;
        workerArgs.cookie = obj;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }

    public final void startUpdate(int i, Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
        obtainMessage.arg1 = 3;
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.handler = this;
        workerArgs.uri = uri;
        workerArgs.cookie = obj;
        workerArgs.values = contentValues;
        workerArgs.selection = str;
        workerArgs.selectionArgs = strArr;
        obtainMessage.obj = workerArgs;
        this.mWorkerThreadHandler.sendMessage(obtainMessage);
    }
}
