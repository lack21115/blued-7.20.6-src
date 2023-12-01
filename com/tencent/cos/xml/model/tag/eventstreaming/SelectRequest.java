package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectRequest.class */
public class SelectRequest {
    private String expression;
    private String expressionType;
    private InputSerialization inputSerialization;
    private OutputSerialization outputSerialization;
    private RequestProgress requestProgress;

    public SelectRequest(String str, String str2, RequestProgress requestProgress, InputSerialization inputSerialization, OutputSerialization outputSerialization) {
        this.expressionType = str;
        this.expression = str2;
        this.requestProgress = requestProgress;
        this.inputSerialization = inputSerialization;
        this.outputSerialization = outputSerialization;
    }

    public String getExpression() {
        return this.expression;
    }

    public String getExpressionType() {
        return this.expressionType;
    }

    public InputSerialization getInputSerialization() {
        return this.inputSerialization;
    }

    public OutputSerialization getOutputSerialization() {
        return this.outputSerialization;
    }

    public RequestProgress getRequestProgress() {
        return this.requestProgress;
    }
}
