package domain;

import java.util.ArrayList;
import java.util.Collection;

public class CountForLoggersObservable {
    private Collection<ICountFroLoggersObserver> observerCollection = new ArrayList<>();
    public void update(int count){
        System.out.println("Observable");
        for(ICountFroLoggersObserver iCountObserver: observerCollection){
            iCountObserver.update(count);
        }
    }

    public void addObserver(ICountFroLoggersObserver iCountObserver){
        observerCollection.add(iCountObserver);
    }

    public void removeObserver(ICountFroLoggersObserver iCountObserver){
        observerCollection.remove(iCountObserver);
    }
}
