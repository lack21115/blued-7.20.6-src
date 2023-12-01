package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/e.class */
public interface e {
    void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch);

    File zu();
}
