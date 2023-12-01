package com.google.android.util;

import com.google.android.util.AbstractMessageParser;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/util/SmileyResources.class */
public class SmileyResources implements AbstractMessageParser.Resources {
    private HashMap<String, Integer> mSmileyToRes = new HashMap<>();
    private final AbstractMessageParser.TrieNode smileys = new AbstractMessageParser.TrieNode();

    public SmileyResources(String[] strArr, int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            AbstractMessageParser.TrieNode.addToTrie(this.smileys, strArr[i2], "");
            this.mSmileyToRes.put(strArr[i2], Integer.valueOf(iArr[i2]));
            i = i2 + 1;
        }
    }

    @Override // com.google.android.util.AbstractMessageParser.Resources
    public AbstractMessageParser.TrieNode getAcronyms() {
        return null;
    }

    @Override // com.google.android.util.AbstractMessageParser.Resources
    public AbstractMessageParser.TrieNode getDomainSuffixes() {
        return null;
    }

    @Override // com.google.android.util.AbstractMessageParser.Resources
    public Set<String> getSchemes() {
        return null;
    }

    public int getSmileyRes(String str) {
        Integer num = this.mSmileyToRes.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.util.AbstractMessageParser.Resources
    public AbstractMessageParser.TrieNode getSmileys() {
        return this.smileys;
    }
}
