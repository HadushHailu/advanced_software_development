package counter;

import java.util.ArrayList;
import java.util.Collection;

public class CountObservable {
    private Collection<ICountObserver> observerCollection = new ArrayList<>();
    public void setCount(int count){
        for(ICountObserver iCountObserver: observerCollection){
            iCountObserver.setCount(count);
        }
    }

    public void addObserver(ICountObserver iCountObserver){
        observerCollection.add(iCountObserver);
    }

    public void removeObserver(ICountObserver iCountObserver){
        observerCollection.remove(iCountObserver);
    }
}
