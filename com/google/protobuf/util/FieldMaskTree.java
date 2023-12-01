package com.google.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.util.FieldMaskUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/util/FieldMaskTree.class */
final class FieldMaskTree {
    private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
    private static final Logger logger = Logger.getLogger(FieldMaskTree.class.getName());
    private final Node root = new Node();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/util/FieldMaskTree$Node.class */
    public static final class Node {
        final SortedMap<String, Node> children;

        private Node() {
            this.children = new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMaskTree() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMaskTree(FieldMask fieldMask) {
        mergeFromFieldMask(fieldMask);
    }

    private void getFieldPaths(Node node, String str, List<String> list) {
        if (node.children.isEmpty()) {
            list.add(str);
            return;
        }
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            getFieldPaths(entry.getValue(), str.isEmpty() ? entry.getKey() : str + "." + entry.getKey(), list);
        }
    }

    private void merge(Node node, String str, Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        if (message.getDescriptorForType() != builder.getDescriptorForType()) {
            throw new IllegalArgumentException(String.format("source (%s) and destination (%s) descriptor must be equal", message.getDescriptorForType(), builder.getDescriptorForType()));
        }
        Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName(entry.getKey());
            if (findFieldByName == null) {
                logger.warning("Cannot find field \"" + entry.getKey() + "\" in message type " + descriptorForType.getFullName());
            } else if (entry.getValue().children.isEmpty()) {
                if (findFieldByName.isRepeated()) {
                    if (mergeOptions.replaceRepeatedFields()) {
                        builder.setField(findFieldByName, message.getField(findFieldByName));
                    } else {
                        for (Object obj : (List) message.getField(findFieldByName)) {
                            builder.addRepeatedField(findFieldByName, obj);
                        }
                    }
                } else if (findFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (mergeOptions.replaceMessageFields()) {
                        if (message.hasField(findFieldByName)) {
                            builder.setField(findFieldByName, message.getField(findFieldByName));
                        } else {
                            builder.clearField(findFieldByName);
                        }
                    } else if (message.hasField(findFieldByName)) {
                        builder.getFieldBuilder(findFieldByName).mergeFrom((Message) message.getField(findFieldByName));
                    }
                } else if (message.hasField(findFieldByName) || !mergeOptions.replacePrimitiveFields()) {
                    builder.setField(findFieldByName, message.getField(findFieldByName));
                } else {
                    builder.clearField(findFieldByName);
                }
            } else if (findFieldByName.isRepeated() || findFieldByName.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                logger.warning("Field \"" + findFieldByName.getFullName() + "\" is not a singluar message field and cannot have sub-fields.");
            } else {
                merge(entry.getValue(), str.isEmpty() ? entry.getKey() : str + "." + entry.getKey(), (Message) message.getField(findFieldByName), builder.getFieldBuilder(findFieldByName), mergeOptions);
            }
        }
    }

    FieldMaskTree addFieldPath(String str) {
        String[] split = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (split.length == 0) {
            return this;
        }
        Node node = this.root;
        boolean z = false;
        for (String str2 : split) {
            if (!z && node != this.root && node.children.isEmpty()) {
                return this;
            }
            if (node.children.containsKey(str2)) {
                node = node.children.get(str2);
            } else {
                Node node2 = new Node();
                node.children.put(str2, node2);
                node = node2;
                z = true;
            }
        }
        node.children.clear();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void intersectFieldPath(String str, FieldMaskTree fieldMaskTree) {
        if (this.root.children.isEmpty()) {
            return;
        }
        String[] split = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (split.length == 0) {
            return;
        }
        Node node = this.root;
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                ArrayList<String> arrayList = new ArrayList();
                getFieldPaths(node, str, arrayList);
                for (String str2 : arrayList) {
                    fieldMaskTree.addFieldPath(str2);
                }
                return;
            }
            String str3 = split[i2];
            if (node != this.root && node.children.isEmpty()) {
                fieldMaskTree.addFieldPath(str);
                return;
            } else if (!node.children.containsKey(str3)) {
                return;
            } else {
                node = node.children.get(str3);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        if (message.getDescriptorForType() != builder.getDescriptorForType()) {
            throw new IllegalArgumentException("Cannot merge messages of different types.");
        }
        if (this.root.children.isEmpty()) {
            return;
        }
        merge(this.root, "", message, builder, mergeOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMaskTree mergeFromFieldMask(FieldMask fieldMask) {
        for (String str : fieldMask.getPathsList()) {
            addFieldPath(str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMask toFieldMask() {
        if (this.root.children.isEmpty()) {
            return FieldMask.getDefaultInstance();
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(this.root, "", arrayList);
        return FieldMask.newBuilder().addAllPaths(arrayList).build();
    }

    public String toString() {
        return FieldMaskUtil.toString(toFieldMask());
    }
}
