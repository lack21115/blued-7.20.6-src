package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/HmsInstanceId.class */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a  reason: collision with root package name */
    private Context f8783a;
    private PushPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f8784c;

    private HmsInstanceId(Context context) {
        this.f8783a = context.getApplicationContext();
        this.b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f8784c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f8784c = new HuaweiApi<>(context, api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f8784c.setKitSdkVersion(60700300);
    }

    private String a(TokenReq tokenReq, int i) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f8783a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a2 = h.a(this.f8783a, "push.gettoken");
        try {
            String str = TAG;
            HMSLog.d(str, "getToken req :" + tokenReq.toString());
            f fVar = new f("push.gettoken", tokenReq, this.f8783a, a2);
            fVar.setApiLevel(i);
            return ((TokenResult) Tasks.await(this.f8784c.doWrite(fVar))).getToken();
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                h.a(this.f8783a, "push.gettoken", a2, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f8783a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.gettoken", a2, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f8783a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f8783a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }

    private void a(DeleteTokenReq deleteTokenReq, int i) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f8783a, subjectId, null);
            return;
        }
        String a2 = h.a(this.f8783a, "push.deletetoken");
        try {
            String b = i.a(this.f8783a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(b) || b.equals(i.a(this.f8783a).b(null)))) {
                i.a(this.f8783a).removeKey(subjectId);
                HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(b);
            e eVar = new e("push.deletetoken", deleteTokenReq, a2);
            eVar.setApiLevel(i);
            Tasks.await(this.f8784c.doWrite(eVar));
            i.a(this.f8783a).c(subjectId);
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                h.a(this.f8783a, "push.deletetoken", a2, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f8783a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.deletetoken", a2, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!d.e(this.f8783a)) {
            i.a(this.f8783a).removeKey("subjectId");
            return;
        }
        String string = i.a(this.f8783a).getString("subjectId");
        if (TextUtils.isEmpty(string)) {
            i.a(this.f8783a).saveString("subjectId", str);
        } else if (string.contains(str)) {
        } else {
            i a2 = i.a(this.f8783a);
            a2.saveString("subjectId", string + "," + str);
        }
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        o.c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.b.containsKey("aaid")) {
                this.b.removeKey("aaid");
                this.b.removeKey(CalendarContract.CalendarAlertsColumns.CREATION_TIME);
                if (b.e(this.f8783a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f8783a);
                        return;
                    }
                    DeleteTokenReq b = b.b(this.f8783a);
                    b.setDeleteType(1);
                    b.setMultiSender(false);
                    a(b, 1);
                    BaseUtils.deleteAllTokenCache(this.f8783a);
                }
            }
        } catch (ApiException e) {
            throw e;
        } catch (Exception e2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (TextUtils.isEmpty(str)) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String d = b.d(this.f8783a);
        if (TextUtils.isEmpty(d)) {
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        if (str.equals(d)) {
            deleteToken(null, null);
            return;
        }
        DeleteTokenReq a2 = b.a(this.f8783a, str);
        a2.setMultiSender(true);
        a(a2, 2);
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a2 = b.a(this.f8783a, str, str2);
        a2.setMultiSender(false);
        a(a2, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new a(this.f8783a.getApplicationContext()));
        } catch (Exception e) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.b.containsKey(CalendarContract.CalendarAlertsColumns.CREATION_TIME)) {
                getAAID();
            }
            return this.b.getLong(CalendarContract.CalendarAlertsColumns.CREATION_TIME);
        } catch (Exception e) {
            return 0L;
        }
    }

    public String getId() {
        return b.c(this.f8783a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception e) {
            return null;
        }
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (TextUtils.isEmpty(str)) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String d = b.d(this.f8783a);
        if (TextUtils.isEmpty(d)) {
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        if (str.equals(d)) {
            return getToken(null, null);
        }
        TokenReq b = b.b(this.f8783a, str);
        b.setAaid(getId());
        b.setMultiSender(true);
        return a(b, 2);
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b = b.b(this.f8783a, null, str2);
        b.setAaid(getId());
        b.setMultiSender(false);
        i.a(this.f8783a).saveString(this.f8783a.getPackageName(), "1");
        return a(b, 1);
    }
}
