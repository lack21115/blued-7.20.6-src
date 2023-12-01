package io.grpc.stub.annotations;

import io.grpc.MethodDescriptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/annotations/RpcMethod.class */
public @interface RpcMethod {
    String fullMethodName();

    MethodDescriptor.MethodType methodType();

    Class<?> requestType();

    Class<?> responseType();
}
