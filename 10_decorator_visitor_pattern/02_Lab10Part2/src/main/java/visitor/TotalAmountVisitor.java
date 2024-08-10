package visitor;

public class TotalAmountVisitor implements OrderVisitor{
    private double totalAmount = 0;

    @Override
    public void visit(InternalOrder internalOrder) {
        totalAmount += internalOrder.getAmount();
    }

    @Override
    public void visit(IndividualOrder individualOrder) {
        totalAmount += individualOrder.getAmount();
    }

    @Override
    public void visit(CorporateOrder corporateOrder) {
        totalAmount += corporateOrder.getAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
