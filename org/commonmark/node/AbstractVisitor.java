package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/AbstractVisitor.class */
public abstract class AbstractVisitor implements Visitor {
    protected void a(Node node) {
        Node j = node.j();
        while (true) {
            Node node2 = j;
            if (node2 == null) {
                return;
            }
            Node h = node2.h();
            node2.a(this);
            j = h;
        }
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BlockQuote blockQuote) {
        a(blockQuote);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BulletList bulletList) {
        a(bulletList);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Code code) {
        a(code);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(CustomNode customNode) {
        a(customNode);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Document document) {
        a(document);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Emphasis emphasis) {
        a(emphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(FencedCodeBlock fencedCodeBlock) {
        a(fencedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HardLineBreak hardLineBreak) {
        a(hardLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Heading heading) {
        a(heading);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlBlock htmlBlock) {
        a(htmlBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlInline htmlInline) {
        a(htmlInline);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Image image) {
        a(image);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(IndentedCodeBlock indentedCodeBlock) {
        a(indentedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Link link) {
        a(link);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(LinkReferenceDefinition linkReferenceDefinition) {
        a(linkReferenceDefinition);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ListItem listItem) {
        a(listItem);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(OrderedList orderedList) {
        a(orderedList);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Paragraph paragraph) {
        a(paragraph);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(SoftLineBreak softLineBreak) {
        a(softLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(StrongEmphasis strongEmphasis) {
        a(strongEmphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Text text) {
        a(text);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ThematicBreak thematicBreak) {
        a(thematicBreak);
    }
}
