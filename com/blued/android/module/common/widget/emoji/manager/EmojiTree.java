package com.blued.android.module.common.widget.emoji.manager;

import android.util.LruCache;
import androidx.collection.SparseArrayCompat;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiTree.class */
public final class EmojiTree {
    private EmojiNode a = new EmojiNode(null);
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
        final SparseArrayCompat<EmojiNode> a = new SparseArrayCompat<>();
        private Emoji b;

        EmojiNode(Emoji emoji) {
            this.b = emoji;
        }

        Emoji a() {
            return this.b;
        }

        EmojiNode a(char c) {
            return (EmojiNode) this.a.get(c);
        }

        void a(char c, Emoji emoji) {
            EmojiNode emojiNode = (EmojiNode) this.a.get(c);
            if (emojiNode != null) {
                emojiNode.a(emoji);
                return;
            }
            this.a.put(c, new EmojiNode(emoji));
        }

        void a(Emoji emoji) {
            this.b = emoji;
        }

        EmojiNode b(char c) {
            EmojiNode emojiNode = (EmojiNode) this.a.get(c);
            EmojiNode emojiNode2 = emojiNode;
            if (emojiNode == null) {
                emojiNode2 = new EmojiNode(null);
                this.a.put(c, emojiNode2);
            }
            return emojiNode2;
        }
    }

    public Emoji a(CharSequence charSequence) {
        EmojiNode emojiNode = this.a;
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
        this.a = new EmojiNode(null);
    }

    public void a(Emoji emoji) {
        String a = emoji.a();
        EmojiNode emojiNode = this.a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.length() - 1) {
                break;
            }
            emojiNode = emojiNode.b(a.charAt(i2));
            i = i2 + 1;
        }
        emojiNode.a(a.charAt(a.length() - 1), emoji);
        for (Emoji emoji2 : emoji.c()) {
            a(emoji2);
        }
    }
}
