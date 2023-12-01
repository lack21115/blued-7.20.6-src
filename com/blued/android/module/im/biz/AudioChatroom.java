package com.blued.android.module.im.biz;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/AudioChatroom.class */
public final class AudioChatroom {

    /* renamed from: a  reason: collision with root package name */
    private ChannelManager f11332a;
    private IMThreadManager b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener.class */
    public interface OnAudioChatroomResponseListener {
        void a(int i, String str, Exception exc);

        void a(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/AudioChatroom$SendMessageRunnable.class */
    public class SendMessageRunnable extends NamedRunnable {
        private AudioChatroomOuterClass.Request b;

        /* renamed from: c  reason: collision with root package name */
        private OnAudioChatroomResponseListener f11334c;

        public SendMessageRunnable(AudioChatroomOuterClass.Request request, OnAudioChatroomResponseListener onAudioChatroomResponseListener) {
            super("audio-chat");
            this.b = request;
            this.f11334c = onAudioChatroomResponseListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x02e6: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:86:0x02e6 */
        /* JADX WARN: Removed duplicated region for block: B:102:0x036d  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0374  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x03a7  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x02fe  */
        @Override // com.blued.android.statistics.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 961
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.im.biz.AudioChatroom.SendMessageRunnable.a():void");
        }
    }

    public AudioChatroom(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        this.f11332a = channelManager;
        this.b = iMThreadManager;
    }

    public void a(AudioChatroomOuterClass.Request.Builder builder, OnAudioChatroomResponseListener onAudioChatroomResponseListener) {
        if (this.f11332a == null || this.b == null) {
            return;
        }
        this.b.a(new SendMessageRunnable(builder.setCommon(Common.a().b()).build(), onAudioChatroomResponseListener));
    }
}
