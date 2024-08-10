package visitor;

public class OrderTypeCounterVisitor implements OrderVisitor{
    private int internalOrderCount = 0;
    private int individualOrderCount = 0;
    private int corporateOrderCount = 0;

    @Override
    public void visit(InternalOrder internalOrder) {
        internalOrderCount++;
    }

    @Override
    public void visit(IndividualOrder individualOrder) {
        individualOrderCount++;
    }

    @Override
    public void visit(CorporateOrder corporateOrder) {
        corporateOrderCount++;
    }

    public int getInternalOrderCount() {
        return internalOrderCount;
    }

    public int getIndividualOrderCount() {
        return individualOrderCount;
    }

    public int getCorporateOrderCount() {
        return corporateOrderCount;
    }
}
