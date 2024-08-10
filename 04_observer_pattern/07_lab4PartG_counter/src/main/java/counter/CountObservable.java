package counter;

import java.util.ArrayList;
import java.util.Collection;

public class CountObservable {
    private Collection<ICountObserver> observerCollection = new ArrayList<>();
    public void update(int count){
        for(ICountObserver iCountObserver: observerCollection){
            iCountObserver.update(count);
        }
    }

    public void addObserver(ICountObserver iCountObserver){
        observerCollection.add(iCountObserver);
    }

    public void removeObserver(ICountObserver iCountObserver){
        observerCollection.remove(iCountObserver);
    }
}
