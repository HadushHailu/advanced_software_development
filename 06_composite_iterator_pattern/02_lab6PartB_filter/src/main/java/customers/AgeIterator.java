package customers;

import java.util.*;

public class AgeIterator<T extends Customer> implements Iterator<T> {
    private List<T> sortedCustomers;
    private int currentIndex;

    public AgeIterator(List<T> customers) {
        sortedCustomers = new ArrayList<>(customers);
        sortedCustomers.sort(Comparator.comparingInt(Customer::getAge));
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sortedCustomers.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sortedCustomers.get(currentIndex++);
    }
}
