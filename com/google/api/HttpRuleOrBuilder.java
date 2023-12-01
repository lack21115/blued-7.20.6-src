package com.google.api;

import com.google.api.HttpRule;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpRuleOrBuilder.class */
public interface HttpRuleOrBuilder extends MessageOrBuilder {
    HttpRule getAdditionalBindings(int i);

    int getAdditionalBindingsCount();

    List<HttpRule> getAdditionalBindingsList();

    HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i);

    List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList();

    String getBody();

    ByteString getBodyBytes();

    CustomHttpPattern getCustom();

    CustomHttpPatternOrBuilder getCustomOrBuilder();

    String getDelete();

    ByteString getDeleteBytes();

    String getGet();

    ByteString getGetBytes();

    String getPatch();

    ByteString getPatchBytes();

    HttpRule.PatternCase getPatternCase();

    String getPost();

    ByteString getPostBytes();

    String getPut();

    ByteString getPutBytes();

    String getResponseBody();

    ByteString getResponseBodyBytes();

    String getSelector();

    ByteString getSelectorBytes();

    boolean hasCustom();
}
