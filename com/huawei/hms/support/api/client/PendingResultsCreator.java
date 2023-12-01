package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/client/PendingResultsCreator.class */
public final class PendingResultsCreator {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/client/PendingResultsCreator$DiscardedPendingResult.class */
    public static class DiscardedPendingResult<R extends Result> extends EmptyPendingResult {
        public DiscardedPendingResult() {
        }

        public DiscardedPendingResult(R r) {
            setResult(r);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public boolean isCanceled() {
            return true;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/client/PendingResultsCreator$InstantPendingResult.class */
    public static class InstantPendingResult<R extends Result> extends EmptyPendingResult {
        public InstantPendingResult(R r) {
            setResult(r);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void cancel() {
            throw new IllegalStateException("cancel() is not available.");
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback resultCallback) {
            resultCallback.onResult(getResult());
        }
    }

    public static PendingResult<Status> discardedPendingResult() {
        return new DiscardedPendingResult();
    }

    public static <R extends Result> PendingResult<R> discardedPendingResult(R r) {
        return new DiscardedPendingResult(r);
    }

    public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R r) {
        return new OptionalPendingResultImpl(new InstantPendingResult(r));
    }

    public static PendingResult<Status> instantPendingResult(Status status) {
        return new InstantPendingResult(status);
    }
}
