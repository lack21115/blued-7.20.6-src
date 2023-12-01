package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/DocumentationOrBuilder.class */
public interface DocumentationOrBuilder extends MessageOrBuilder {
    String getDocumentationRootUrl();

    ByteString getDocumentationRootUrlBytes();

    String getOverview();

    ByteString getOverviewBytes();

    Page getPages(int i);

    int getPagesCount();

    List<Page> getPagesList();

    PageOrBuilder getPagesOrBuilder(int i);

    List<? extends PageOrBuilder> getPagesOrBuilderList();

    DocumentationRule getRules(int i);

    int getRulesCount();

    List<DocumentationRule> getRulesList();

    DocumentationRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList();

    String getSummary();

    ByteString getSummaryBytes();
}
