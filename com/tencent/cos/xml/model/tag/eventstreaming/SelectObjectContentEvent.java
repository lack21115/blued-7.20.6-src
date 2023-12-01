package com.tencent.cos.xml.model.tag.eventstreaming;

import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent.class */
public class SelectObjectContentEvent {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent$ContinuationEvent.class */
    public static class ContinuationEvent extends SelectObjectContentEvent {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo7154clone() throws CloneNotSupportedException {
            return super.mo7154clone();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent$EndEvent.class */
    public static class EndEvent extends SelectObjectContentEvent {
        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo7154clone() throws CloneNotSupportedException {
            return super.mo7154clone();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent$ProgressEvent.class */
    public static class ProgressEvent extends SelectObjectContentEvent {
        private Progress details;

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo7154clone() throws CloneNotSupportedException {
            return super.mo7154clone();
        }

        public Progress getDetails() {
            return this.details;
        }

        public void setDetails(Progress progress) {
            this.details = progress;
        }

        public ProgressEvent withDetails(Progress progress) {
            setDetails(progress);
            return this;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent$RecordsEvent.class */
    public static class RecordsEvent extends SelectObjectContentEvent {
        private ByteBuffer payload;

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo7154clone() throws CloneNotSupportedException {
            return super.mo7154clone();
        }

        public ByteBuffer getPayload() {
            return this.payload;
        }

        public void setPayload(ByteBuffer byteBuffer) {
            this.payload = byteBuffer;
        }

        public RecordsEvent withPayload(ByteBuffer byteBuffer) {
            setPayload(byteBuffer);
            return this;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEvent$StatsEvent.class */
    public static class StatsEvent extends SelectObjectContentEvent {
        private Stats details;

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo7154clone() throws CloneNotSupportedException {
            return super.mo7154clone();
        }

        public Stats getDetails() {
            return this.details;
        }

        public void setDetails(Stats stats) {
            this.details = stats;
        }

        public StatsEvent withDetails(Stats stats) {
            setDetails(stats);
            return this;
        }
    }

    @Override // 
    /* renamed from: clone */
    public SelectObjectContentEvent mo7154clone() {
        try {
            return (SelectObjectContentEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
