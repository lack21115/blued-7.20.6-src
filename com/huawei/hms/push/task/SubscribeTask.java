package com.huawei.hms.push.task;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/task/SubscribeTask.class */
public class SubscribeTask extends BaseVoidTask {
    public SubscribeTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }
}
