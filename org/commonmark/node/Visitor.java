package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Visitor.class */
public interface Visitor {
    void visit(BlockQuote blockQuote);

    void visit(BulletList bulletList);

    void visit(Code code);

    void visit(CustomNode customNode);

    void visit(Document document);

    void visit(Emphasis emphasis);

    void visit(FencedCodeBlock fencedCodeBlock);

    void visit(HardLineBreak hardLineBreak);

    void visit(Heading heading);

    void visit(HtmlBlock htmlBlock);

    void visit(HtmlInline htmlInline);

    void visit(Image image);

    void visit(IndentedCodeBlock indentedCodeBlock);

    void visit(Link link);

    void visit(LinkReferenceDefinition linkReferenceDefinition);

    void visit(ListItem listItem);

    void visit(OrderedList orderedList);

    void visit(Paragraph paragraph);

    void visit(SoftLineBreak softLineBreak);

    void visit(StrongEmphasis strongEmphasis);

    void visit(Text text);

    void visit(ThematicBreak thematicBreak);
}
