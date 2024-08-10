package visitor;

public class TVOrderCountVisitor implements OrderVisitor{
    private int tvCount = 0;

    @Override
    public void visit(InternalOrder internalOrder) {
        countTVs(internalOrder);
    }

    @Override
    public void visit(IndividualOrder individualOrder) {
        countTVs(individualOrder);
    }

    @Override
    public void visit(CorporateOrder corporateOrder) {
        countTVs(corporateOrder);
    }

    private void countTVs(Order order) {
        for (OrderLine orderLine : order.getOrderLines()) {
            if (orderLine.getProduct().getName().equalsIgnoreCase("TV")) {
                tvCount += orderLine.getQuantity();
            }
        }
    }

    public int getTvCount() {
        return tvCount;
    }
}
