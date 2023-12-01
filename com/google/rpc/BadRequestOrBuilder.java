package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.BadRequest;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/rpc/BadRequestOrBuilder.class */
public interface BadRequestOrBuilder extends MessageOrBuilder {
    BadRequest.FieldViolation getFieldViolations(int i);

    int getFieldViolationsCount();

    List<BadRequest.FieldViolation> getFieldViolationsList();

    BadRequest.FieldViolationOrBuilder getFieldViolationsOrBuilder(int i);

    List<? extends BadRequest.FieldViolationOrBuilder> getFieldViolationsOrBuilderList();
}
