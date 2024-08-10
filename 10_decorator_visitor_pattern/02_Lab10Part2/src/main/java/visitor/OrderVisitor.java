package visitor;

public interface OrderVisitor {
    void visit(InternalOrder internalOrder);
    void visit(IndividualOrder individualOrder);
    void visit(CorporateOrder corporateOrder);
}
