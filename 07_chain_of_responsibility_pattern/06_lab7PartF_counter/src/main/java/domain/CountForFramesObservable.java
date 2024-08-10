package domain;

import java.util.ArrayList;
import java.util.Collection;

public class CountForFramesObservable {
    private Collection<ICountForFramesObserver> observerCollection = new ArrayList<>();
    public void update(int count){
        System.out.println("Observable");
        for(ICountForFramesObserver iCountObserver: observerCollection){
            iCountObserver.update(count);
        }
    }

    public void addObserver(ICountForFramesObserver iCountObserver){
        observerCollection.add(iCountObserver);
    }

    public void removeObserver(ICountForFramesObserver iCountObserver){
        observerCollection.remove(iCountObserver);
    }
}
