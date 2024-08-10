package customers;

import java.util.*;

public class SkipIterator<T> implements Iterator<T> {
    private List<T> customers;
    private int currentIndex;

    public SkipIterator(List<T> customers) {
        this.customers = customers;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < customers.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T valueCurrentIndex = customers.get(currentIndex);
        currentIndex += 2;
        return valueCurrentIndex;
    }
}
