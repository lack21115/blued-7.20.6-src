package android.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;

/* loaded from: source-4181928-dex2jar.jar:android/widget/Filter.class */
public abstract class Filter {
    private static final int FILTER_TOKEN = -791613427;
    private static final int FINISH_TOKEN = -559038737;
    private static final String LOG_TAG = "Filter";
    private static final String THREAD_NAME = "Filter";
    private Delayer mDelayer;
    private final Object mLock = new Object();
    private Handler mResultHandler = new ResultsHandler();
    private Handler mThreadHandler;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$Delayer.class */
    public interface Delayer {
        long getPostingDelay(CharSequence charSequence);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$FilterListener.class */
    public interface FilterListener {
        void onFilterComplete(int i);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$FilterResults.class */
    protected static class FilterResults {
        public int count;
        public Object values;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$RequestArguments.class */
    public static class RequestArguments {
        CharSequence constraint;
        FilterListener listener;
        FilterResults results;

        private RequestArguments() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$RequestHandler.class */
    public class RequestHandler extends Handler {
        public RequestHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case Filter.FILTER_TOKEN /* -791613427 */:
                    RequestArguments requestArguments = (RequestArguments) message.obj;
                    try {
                        try {
                            requestArguments.results = Filter.this.performFiltering(requestArguments.constraint);
                            Message obtainMessage = Filter.this.mResultHandler.obtainMessage(i);
                            obtainMessage.obj = requestArguments;
                            obtainMessage.sendToTarget();
                        } catch (Exception e) {
                            requestArguments.results = new FilterResults();
                            Log.w("Filter", "An exception occured during performFiltering()!", e);
                            Message obtainMessage2 = Filter.this.mResultHandler.obtainMessage(i);
                            obtainMessage2.obj = requestArguments;
                            obtainMessage2.sendToTarget();
                        }
                        requestArguments = Filter.this.mLock;
                        synchronized (requestArguments) {
                            if (Filter.this.mThreadHandler != null) {
                                Filter.this.mThreadHandler.sendMessageDelayed(Filter.this.mThreadHandler.obtainMessage(Filter.FINISH_TOKEN), m.ag);
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        Message obtainMessage3 = Filter.this.mResultHandler.obtainMessage(i);
                        obtainMessage3.obj = requestArguments;
                        obtainMessage3.sendToTarget();
                        throw th;
                    }
                case Filter.FINISH_TOKEN /* -559038737 */:
                    synchronized (Filter.this.mLock) {
                        if (Filter.this.mThreadHandler != null) {
                            Filter.this.mThreadHandler.getLooper().quit();
                            Filter.this.mThreadHandler = null;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Filter$ResultsHandler.class */
    private class ResultsHandler extends Handler {
        private ResultsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RequestArguments requestArguments = (RequestArguments) message.obj;
            Filter.this.publishResults(requestArguments.constraint, requestArguments.results);
            if (requestArguments.listener != null) {
                requestArguments.listener.onFilterComplete(requestArguments.results != null ? requestArguments.results.count : -1);
            }
        }
    }

    public CharSequence convertResultToString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public final void filter(CharSequence charSequence) {
        filter(charSequence, null);
    }

    public final void filter(CharSequence charSequence, FilterListener filterListener) {
        String str = null;
        synchronized (this.mLock) {
            if (this.mThreadHandler == null) {
                HandlerThread handlerThread = new HandlerThread("Filter", 10);
                handlerThread.start();
                this.mThreadHandler = new RequestHandler(handlerThread.getLooper());
            }
            long postingDelay = this.mDelayer == null ? 0L : this.mDelayer.getPostingDelay(charSequence);
            Message obtainMessage = this.mThreadHandler.obtainMessage(FILTER_TOKEN);
            RequestArguments requestArguments = new RequestArguments();
            if (charSequence != null) {
                str = charSequence.toString();
            }
            requestArguments.constraint = str;
            requestArguments.listener = filterListener;
            obtainMessage.obj = requestArguments;
            this.mThreadHandler.removeMessages(FILTER_TOKEN);
            this.mThreadHandler.removeMessages(FINISH_TOKEN);
            this.mThreadHandler.sendMessageDelayed(obtainMessage, postingDelay);
        }
    }

    protected abstract FilterResults performFiltering(CharSequence charSequence);

    protected abstract void publishResults(CharSequence charSequence, FilterResults filterResults);

    public void setDelayer(Delayer delayer) {
        synchronized (this.mLock) {
            this.mDelayer = delayer;
        }
    }
}
