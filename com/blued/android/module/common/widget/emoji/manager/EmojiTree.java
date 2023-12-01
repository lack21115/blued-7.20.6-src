package com.blued.android.module.common.widget.emoji.manager;

import android.util.LruCache;
import androidx.collection.SparseArrayCompat;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiTree.class */
public final class EmojiTree {

    /* renamed from: a  reason: collision with root package name */
    private EmojiNode f11146a = new EmojiNode(null);
    private LruCache<CharSequence, Emoji> b = new LruCache<CharSequence, Emoji>(200) { // from class: com.blued.android.module.common.widget.emoji.manager.EmojiTree.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(CharSequence charSequence, Emoji emoji) {
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, CharSequence charSequence, Emoji emoji, Emoji emoji2) {
            super.entryRemoved(z, charSequence, emoji, emoji2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiTree$EmojiNode.class */
    public static class EmojiNode {

        /* renamed from: a  reason: collision with root package name */
        final SparseArrayCompat<EmojiNode> f11148a = new SparseArrayCompat<>();
        private Emoji b;

        EmojiNode(Emoji emoji) {
            this.b = emoji;
        }

        Emoji a() {
            return this.b;
        }

        EmojiNode a(char c2) {
            return this.f11148a.get(c2);
        }

        void a(char c2, Emoji emoji) {
            EmojiNode emojiNode = this.f11148a.get(c2);
            if (emojiNode != null) {
                emojiNode.a(emoji);
                return;
            }
            this.f11148a.put(c2, new EmojiNode(emoji));
        }

        void a(Emoji emoji) {
            this.b = emoji;
        }

        EmojiNode b(char c2) {
            EmojiNode emojiNode = this.f11148a.get(c2);
            EmojiNode emojiNode2 = emojiNode;
            if (emojiNode == null) {
                emojiNode2 = new EmojiNode(null);
                this.f11148a.put(c2, emojiNode2);
            }
            return emojiNode2;
        }
    }

    public Emoji a(CharSequence charSequence) {
        EmojiNode emojiNode = this.f11146a;
        Emoji emoji = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charSequence.length()) {
                return emoji;
            }
            emojiNode = emojiNode.a(charSequence.charAt(i2));
            if (emojiNode == null) {
                return emoji;
            }
            if (emojiNode.a() != null) {
                emoji = emojiNode.a();
            }
            i = i2 + 1;
        }
    }

    public void a() {
        this.f11146a = new EmojiNode(null);
    }

    public void a(Emoji emoji) {
        String a2 = emoji.a();
        EmojiNode emojiNode = this.f11146a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length() - 1) {
                break;
            }
            emojiNode = emojiNode.b(a2.charAt(i2));
            i = i2 + 1;
        }
        emojiNode.a(a2.charAt(a2.length() - 1), emoji);
        for (Emoji emoji2 : emoji.c()) {
            a(emoji2);
        }
    }
}
