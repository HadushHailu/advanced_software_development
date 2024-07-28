package customers;

import java.util.*;

public class AgeIterator<C extends Customer> implements Iterator<C> {
    private List<C> sortedCustomers;
    private int currentIndex;

    public AgeIterator(List<C> customers) {
        sortedCustomers = new ArrayList<>(customers);
        sortedCustomers.sort(Comparator.comparingInt(Customer::getAge));
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sortedCustomers.size();
    }

    @Override
    public C next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sortedCustomers.get(currentIndex++);
    }
}
