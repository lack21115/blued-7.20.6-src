package com.tencent.cos.xml.model.tag.eventstreaming;

import android.util.Xml;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller.class */
public abstract class SelectObjectContentEventUnmarshaller {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$ContinuationEventUnmarshaller.class */
    public static class ContinuationEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent.ContinuationEvent unmarshal(Message message) {
            return new SelectObjectContentEvent.ContinuationEvent();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$EndEventUnmarshaller.class */
    public static class EndEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent.EndEvent unmarshal(Message message) {
            return new SelectObjectContentEvent.EndEvent();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$ProgressEventUnmarshaller.class */
    public static class ProgressEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent.ProgressEvent unmarshal(Message message) throws Exception {
            return new SelectObjectContentEvent.ProgressEvent().withDetails(SelectObjectContentEventUnmarshaller.parsePayloadProgress(message));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$RecordsEventUnmarshaller.class */
    public static class RecordsEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent.RecordsEvent unmarshal(Message message) {
            return new SelectObjectContentEvent.RecordsEvent().withPayload(ByteBuffer.wrap(message.getPayload()));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$StatsEventUnmarshaller.class */
    public static class StatsEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent.StatsEvent unmarshal(Message message) throws Exception {
            return new SelectObjectContentEvent.StatsEvent().withDetails(SelectObjectContentEventUnmarshaller.parsePayloadStats(message));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventUnmarshaller$UnknownEventUnmarshaller.class */
    public static class UnknownEventUnmarshaller extends SelectObjectContentEventUnmarshaller {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller
        public SelectObjectContentEvent unmarshal(Message message) {
            return new SelectObjectContentEvent();
        }
    }

    public static SelectObjectContentEventUnmarshaller forEventType(String str) {
        return "Records".equals(str) ? new RecordsEventUnmarshaller() : "Stats".equals(str) ? new StatsEventUnmarshaller() : "Progress".equals(str) ? new ProgressEventUnmarshaller() : "Cont".equals(str) ? new ContinuationEventUnmarshaller() : "End".equals(str) ? new EndEventUnmarshaller() : new UnknownEventUnmarshaller();
    }

    private static String getStringHeader(Message message, String str) throws CosXmlServiceException {
        HeaderValue headerValue = message.getHeaders().get(str);
        if (headerValue == null) {
            throw new CosXmlServiceException("Unexpected lack of '" + str + "' header from service.");
        } else if (headerValue.getType() == HeaderType.STRING) {
            return headerValue.getString();
        } else {
            throw new CosXmlServiceException("Unexpected non-string '" + str + "' header: " + headerValue.getType());
        }
    }

    private static long[] parsePayloadBytesProgress(Message message) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(new ByteArrayInputStream(message.getPayload()), "UTF-8");
        int eventType = newPullParser.getEventType();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (eventType != 1) {
            if (eventType != 2) {
                j = j3;
                j2 = j4;
            } else {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("BytesScanned")) {
                    newPullParser.next();
                    j = Long.parseLong(newPullParser.getText());
                    j2 = j4;
                } else if (name.equalsIgnoreCase("BytesProcessed")) {
                    newPullParser.next();
                    j2 = Long.parseLong(newPullParser.getText());
                    j = j3;
                } else {
                    j = j3;
                    j2 = j4;
                    if (name.equalsIgnoreCase("BytesReturned")) {
                        newPullParser.next();
                        j5 = Long.parseLong(newPullParser.getText());
                        j2 = j4;
                        j = j3;
                    }
                }
            }
            eventType = newPullParser.next();
            j3 = j;
            j4 = j2;
        }
        return new long[]{j3, j4, j5};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Progress parsePayloadProgress(Message message) throws XmlPullParserException, IOException {
        long[] parsePayloadBytesProgress = parsePayloadBytesProgress(message);
        return new Progress(Long.valueOf(parsePayloadBytesProgress[0]), Long.valueOf(parsePayloadBytesProgress[1]), Long.valueOf(parsePayloadBytesProgress[2]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Stats parsePayloadStats(Message message) throws XmlPullParserException, IOException {
        long[] parsePayloadBytesProgress = parsePayloadBytesProgress(message);
        return new Stats(Long.valueOf(parsePayloadBytesProgress[0]), Long.valueOf(parsePayloadBytesProgress[1]), Long.valueOf(parsePayloadBytesProgress[2]));
    }

    private static CosXmlServiceException unmarshalErrorMessage(Message message) throws CosXmlServiceException {
        String stringHeader = getStringHeader(message, ":error-code");
        String stringHeader2 = getStringHeader(message, ":error-message");
        SelectObjectContentEventException selectObjectContentEventException = new SelectObjectContentEventException("S3 returned an error: " + stringHeader2 + " (" + stringHeader + ")");
        selectObjectContentEventException.setErrorCode(stringHeader);
        selectObjectContentEventException.setErrorMessage(stringHeader2);
        return new CosXmlServiceException("Select object content error event", selectObjectContentEventException);
    }

    private static SelectObjectContentEvent unmarshalEventMessage(Message message) throws CosXmlServiceException {
        String stringHeader = getStringHeader(message, ":event-type");
        try {
            return forEventType(stringHeader).unmarshal(message);
        } catch (Exception e) {
            throw new CosXmlServiceException("Failed to read response event of type " + stringHeader, e);
        }
    }

    public static SelectObjectContentEvent unmarshalMessage(Message message) throws CosXmlServiceException {
        String stringHeader = getStringHeader(message, ":message-type");
        if ("error".equals(stringHeader)) {
            throw unmarshalErrorMessage(message);
        }
        if ("event".equals(stringHeader)) {
            return unmarshalEventMessage(message);
        }
        throw new CosXmlServiceException("Service returned unknown message type: " + stringHeader);
    }

    public abstract SelectObjectContentEvent unmarshal(Message message) throws Exception;
}
