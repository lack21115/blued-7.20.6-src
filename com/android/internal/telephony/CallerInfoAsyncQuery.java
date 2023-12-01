package com.android.internal.telephony;

import android.app.ActivityManager;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery.class */
public class CallerInfoAsyncQuery {
    private static final boolean DBG = false;
    private static final boolean ENABLE_UNKNOWN_NUMBER_GEO_DESCRIPTION = true;
    private static final int EVENT_ADD_LISTENER = 2;
    private static final int EVENT_EMERGENCY_NUMBER = 4;
    private static final int EVENT_END_OF_QUEUE = 3;
    private static final int EVENT_NEW_QUERY = 1;
    private static final int EVENT_VOICEMAIL_NUMBER = 5;
    private static final String LOG_TAG = "CallerInfoAsyncQuery";
    private CallerInfoAsyncQueryHandler mHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery$CallerInfoAsyncQueryHandler.class */
    public class CallerInfoAsyncQueryHandler extends AsyncQueryHandler {
        private CallerInfo mCallerInfo;
        private Context mContext;
        private Uri mQueryUri;

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery$CallerInfoAsyncQueryHandler$CallerInfoWorkerHandler.class */
        protected class CallerInfoWorkerHandler extends AsyncQueryHandler.WorkerHandler {
            public CallerInfoWorkerHandler(Looper looper) {
                super(looper);
            }

            @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
            public void handleMessage(Message message) {
                AsyncQueryHandler.WorkerArgs workerArgs = (AsyncQueryHandler.WorkerArgs) message.obj;
                CookieWrapper cookieWrapper = (CookieWrapper) workerArgs.cookie;
                if (cookieWrapper == null) {
                    super.handleMessage(message);
                    return;
                }
                switch (cookieWrapper.event) {
                    case 1:
                        super.handleMessage(message);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        Message obtainMessage = workerArgs.handler.obtainMessage(message.what);
                        obtainMessage.obj = workerArgs;
                        obtainMessage.arg1 = message.arg1;
                        obtainMessage.sendToTarget();
                        return;
                    default:
                        return;
                }
            }
        }

        private CallerInfoAsyncQueryHandler(Context context) {
            super(CallerInfoAsyncQuery.getCurrentProfileContentResolver(context));
            this.mContext = context;
        }

        @Override // android.content.AsyncQueryHandler
        protected Handler createHandler(Looper looper) {
            return new CallerInfoWorkerHandler(looper);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int i, Object obj, Cursor cursor) {
            CookieWrapper cookieWrapper = (CookieWrapper) obj;
            if (cookieWrapper == null) {
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cookieWrapper.event == 3) {
                CallerInfoAsyncQuery.this.release();
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                if (this.mCallerInfo == null) {
                    if (this.mContext == null || this.mQueryUri == null) {
                        throw new QueryPoolException("Bad context or query uri, or CallerInfoAsyncQuery already released.");
                    }
                    if (cookieWrapper.event == 4) {
                        this.mCallerInfo = new CallerInfo().markAsEmergency(this.mContext);
                    } else if (cookieWrapper.event == 5) {
                        this.mCallerInfo = new CallerInfo().markAsVoiceMail(cookieWrapper.subId);
                    } else {
                        this.mCallerInfo = CallerInfo.getCallerInfo(this.mContext, this.mQueryUri, cursor);
                        CallerInfo doSecondaryLookupIfNecessary = CallerInfo.doSecondaryLookupIfNecessary(this.mContext, cookieWrapper.number, this.mCallerInfo);
                        if (doSecondaryLookupIfNecessary != this.mCallerInfo) {
                            this.mCallerInfo = doSecondaryLookupIfNecessary;
                        }
                        if (TextUtils.isEmpty(this.mCallerInfo.name)) {
                            this.mCallerInfo.updateGeoDescription(this.mContext, cookieWrapper.number);
                        }
                        if (!TextUtils.isEmpty(cookieWrapper.number)) {
                            this.mCallerInfo.phoneNumber = PhoneNumberUtils.formatNumber(cookieWrapper.number, this.mCallerInfo.normalizedNumber, CallerInfo.getCurrentCountryIso(this.mContext));
                        }
                    }
                    CookieWrapper cookieWrapper2 = new CookieWrapper();
                    cookieWrapper2.event = 3;
                    startQuery(i, cookieWrapper2, null, null, null, null, null);
                }
                if (cookieWrapper.listener != null) {
                    cookieWrapper.listener.onQueryComplete(i, cookieWrapper.cookie, this.mCallerInfo);
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery$CookieWrapper.class */
    public static final class CookieWrapper {
        public Object cookie;
        public int event;
        public OnQueryCompleteListener listener;
        public String number;
        public int subId;

        private CookieWrapper() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery$OnQueryCompleteListener.class */
    public interface OnQueryCompleteListener {
        void onQueryComplete(int i, Object obj, CallerInfo callerInfo);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfoAsyncQuery$QueryPoolException.class */
    public static class QueryPoolException extends SQLException {
        public QueryPoolException(String str) {
            super(str);
        }
    }

    private CallerInfoAsyncQuery() {
    }

    private void allocate(Context context, Uri uri) {
        if (context == null || uri == null) {
            throw new QueryPoolException("Bad context or query uri.");
        }
        this.mHandler = new CallerInfoAsyncQueryHandler(context);
        this.mHandler.mQueryUri = uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentResolver getCurrentProfileContentResolver(Context context) {
        int currentUser = ActivityManager.getCurrentUser();
        if (UserManager.get(context).getUserHandle() != currentUser) {
            try {
                return context.createPackageContextAsUser(context.getPackageName(), 0, new UserHandle(currentUser)).getContentResolver();
            } catch (PackageManager.NameNotFoundException e) {
                Rlog.e(LOG_TAG, "Can't find self package", e);
            }
        }
        return context.getContentResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mHandler.mContext = null;
        this.mHandler.mQueryUri = null;
        this.mHandler.mCallerInfo = null;
        this.mHandler = null;
    }

    private static String sanitizeUriToString(Uri uri) {
        int lastIndexOf;
        if (uri != null) {
            String uri2 = uri.toString();
            String str = uri2;
            if (uri2.lastIndexOf(47) > 0) {
                str = uri2.substring(0, lastIndexOf) + "/xxxxxxx";
            }
            return str;
        }
        return "";
    }

    public static CallerInfoAsyncQuery startQuery(int i, Context context, Uri uri, OnQueryCompleteListener onQueryCompleteListener, Object obj) {
        CallerInfoAsyncQuery callerInfoAsyncQuery = new CallerInfoAsyncQuery();
        callerInfoAsyncQuery.allocate(context, uri);
        CookieWrapper cookieWrapper = new CookieWrapper();
        cookieWrapper.listener = onQueryCompleteListener;
        cookieWrapper.cookie = obj;
        cookieWrapper.event = 1;
        callerInfoAsyncQuery.mHandler.startQuery(i, cookieWrapper, uri, null, null, null, null);
        return callerInfoAsyncQuery;
    }

    public static CallerInfoAsyncQuery startQuery(int i, Context context, String str, OnQueryCompleteListener onQueryCompleteListener, Object obj) {
        return startQuery(i, context, str, onQueryCompleteListener, obj, SubscriptionManager.getDefaultSubId());
    }

    public static CallerInfoAsyncQuery startQuery(int i, Context context, String str, OnQueryCompleteListener onQueryCompleteListener, Object obj, int i2) {
        Uri build = ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI.buildUpon().appendPath(str).appendQueryParameter("sip", String.valueOf(PhoneNumberUtils.isUriNumber(str))).build();
        CallerInfoAsyncQuery callerInfoAsyncQuery = new CallerInfoAsyncQuery();
        callerInfoAsyncQuery.allocate(context, build);
        CookieWrapper cookieWrapper = new CookieWrapper();
        cookieWrapper.listener = onQueryCompleteListener;
        cookieWrapper.cookie = obj;
        cookieWrapper.number = str;
        cookieWrapper.subId = i2;
        if (PhoneNumberUtils.isLocalEmergencyNumber(context, str)) {
            cookieWrapper.event = 4;
        } else if (PhoneNumberUtils.isVoiceMailNumber(i2, str)) {
            cookieWrapper.event = 5;
        } else {
            cookieWrapper.event = 1;
        }
        callerInfoAsyncQuery.mHandler.startQuery(i, cookieWrapper, build, null, null, null, null);
        return callerInfoAsyncQuery;
    }

    public void addQueryListener(int i, OnQueryCompleteListener onQueryCompleteListener, Object obj) {
        CookieWrapper cookieWrapper = new CookieWrapper();
        cookieWrapper.listener = onQueryCompleteListener;
        cookieWrapper.cookie = obj;
        cookieWrapper.event = 2;
        this.mHandler.startQuery(i, cookieWrapper, null, null, null, null, null);
    }
}
