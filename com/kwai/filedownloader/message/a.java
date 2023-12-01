package com.kwai.filedownloader.message;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/a.class */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/a$a.class */
    public static final class C0420a extends MessageSnapshot implements a {
        private final MessageSnapshot aIp;

        public C0420a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.Gq() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq())));
            }
            this.aIp = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public final MessageSnapshot In() {
            return this.aIp;
        }
    }

    MessageSnapshot In();
}
