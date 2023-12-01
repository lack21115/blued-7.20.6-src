package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.QuotaFailure;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/rpc/QuotaFailureOrBuilder.class */
public interface QuotaFailureOrBuilder extends MessageOrBuilder {
    QuotaFailure.Violation getViolations(int i);

    int getViolationsCount();

    List<QuotaFailure.Violation> getViolationsList();

    QuotaFailure.ViolationOrBuilder getViolationsOrBuilder(int i);

    List<? extends QuotaFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}
