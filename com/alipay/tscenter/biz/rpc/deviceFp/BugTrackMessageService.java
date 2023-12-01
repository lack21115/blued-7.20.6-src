package com.alipay.tscenter.biz.rpc.deviceFp;

import com.alipay.mobile.framework.service.annotation.OperationType;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/tscenter/biz/rpc/deviceFp/BugTrackMessageService.class */
public interface BugTrackMessageService {
    @OperationType("alipay.security.errorLog.collect")
    String logCollect(String str);
}
