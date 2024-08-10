package customers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class AddressFilterIterator<T>  implements Iterator<T> {
    private final List<T> custmors;
    private int position;
    private Predicate<T> predicate;
    public AddressFilterIterator(List<T> custmors, Predicate<T> predicate) {
        this.custmors = custmors;
        this.predicate=predicate;
        this.position = 0;
    }
    public Iterator<T> iterator() {
        return this;
    }
    @Override
    public boolean hasNext() {
        int tempPosition = position;
        while (tempPosition < custmors.size()) {
            T nextElement = custmors.get(tempPosition);
            if (predicate.test(nextElement)) {
                return true;
            } else {
                tempPosition++;
            }
        }
        return false;
    }

    @Override
    public T next() {
        int tempPosition = position;
        while (tempPosition < custmors.size()) {
            T nextElement = custmors.get(tempPosition);
            if (predicate.test(nextElement)) {
                position=tempPosition+1;
                return nextElement;
            }
            else {
                tempPosition++;
            }
        }
        return null;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
