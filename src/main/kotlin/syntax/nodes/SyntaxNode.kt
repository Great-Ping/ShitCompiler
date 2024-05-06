package syntax.nodes

interface SyntaxNode {
    val parent: SyntaxNode;

    fun toList(): List<SyntaxNode> {
        TODO()
    }
}