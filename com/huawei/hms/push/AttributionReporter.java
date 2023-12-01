package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.AttributionReportTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.AttributionReportReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/AttributionReporter.class */
public class AttributionReporter {
    public static final String APP_VERSION = "appVersion";
    public static final String SYSTEM_PERMISSION = "permission";

    /* renamed from: a  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f22828a;
    private Context b;

    private AttributionReporter(Context context) {
        Preconditions.checkNotNull(context);
        this.b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f22828a = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f22828a = new HuaweiApi<>(context, api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f22828a.setKitSdkVersion(60700300);
    }

    private Task<Void> a(AttributionEvent attributionEvent, Bundle bundle) {
        TaskCompletionSource taskCompletionSource;
        int statusCode;
        String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.PUSH_ANALYSIS_REPORT);
        if (bundle != null) {
            try {
                if (attributionEvent != null) {
                    try {
                        if (c.d(this.b)) {
                            long j = new PushPreferences(this.b, "hwpush_local_config").getLong("analysis_last_failed_time");
                            if (j > 0 && System.currentTimeMillis() - j < 86400000) {
                                throw ErrorEnum.ERROR_NOT_IN_SERVICE.toApiException();
                            }
                            return this.f22828a.doWrite(new AttributionReportTask(PushNaming.PUSH_ANALYSIS_REPORT, JsonUtil.createJsonString(a(attributionEvent, new SafeBundle(bundle))), reportEntry));
                        }
                        throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
                    } catch (Exception e) {
                        taskCompletionSource = new TaskCompletionSource();
                        taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                        statusCode = ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode();
                        PushBiUtil.reportExit(this.b, PushNaming.PUSH_ANALYSIS_REPORT, reportEntry, statusCode);
                        return taskCompletionSource.getTask();
                    }
                }
            } catch (ApiException e2) {
                taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(e2);
                statusCode = e2.getStatusCode();
            }
        }
        PushBiUtil.reportExit(this.b, PushNaming.PUSH_ANALYSIS_REPORT, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        HMSLog.e("AttributionReporter", "Invalid argument: argument should not be null");
        throw new IllegalArgumentException("Invalid argument: argument should not be null");
    }

    private AttributionReportReq a(AttributionEvent attributionEvent, SafeBundle safeBundle) throws ApiException {
        Bundle bundle = safeBundle.getBundle().getBundle("analysisExt");
        if (bundle == null || bundle.isEmpty()) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String string = bundle.getString(RemoteMessageConst.MSGID);
        if (TextUtils.isEmpty(string)) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String string2 = bundle.getString("hsId");
        if (TextUtils.isEmpty(string2)) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        AttributionReportReq attributionReportReq = new AttributionReportReq();
        attributionReportReq.setCampaignId(bundle.getString("cid"));
        attributionReportReq.setMsgId(string);
        attributionReportReq.setHaStorageId(string2);
        attributionReportReq.setEventId(attributionEvent.getEventId());
        attributionReportReq.setPkgName(this.b.getPackageName());
        if (attributionEvent.equals(AttributionEvent.PERMISSION_GRANTED) || attributionEvent.equals(AttributionEvent.PERMISSION_DENIED)) {
            String string3 = safeBundle.getString("permission");
            if (TextUtils.isEmpty(string3) || !string3.startsWith("android.permission")) {
                throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
            }
            attributionReportReq.setReqPermission(string3);
        }
        attributionReportReq.setTimeStamp(System.currentTimeMillis());
        attributionReportReq.setAppVersion(safeBundle.getString(APP_VERSION));
        return attributionReportReq;
    }

    public static AttributionReporter getInstance(Context context) {
        return new AttributionReporter(context);
    }

    public Task<Void> report(AttributionEvent attributionEvent, Bundle bundle) {
        return a(attributionEvent, bundle);
    }
}
