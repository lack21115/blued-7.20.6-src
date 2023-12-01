package com.google.common.eventbus;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/SubscriberExceptionHandler.class */
public interface SubscriberExceptionHandler {
    void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext);
}
