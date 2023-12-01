package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.PreconditionFailure;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/rpc/PreconditionFailureOrBuilder.class */
public interface PreconditionFailureOrBuilder extends MessageOrBuilder {
    PreconditionFailure.Violation getViolations(int i);

    int getViolationsCount();

    List<PreconditionFailure.Violation> getViolationsList();

    PreconditionFailure.ViolationOrBuilder getViolationsOrBuilder(int i);

    List<? extends PreconditionFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}
