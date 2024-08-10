package dao;

import domain.ICountForFramesObserver;
import domain.ICountFroLoggersObserver;

public class CounterDAO implements ICountFroLoggersObserver {
    @Override
    public void update(int count){
        System.out.println("Count stored in db="+count);
    }
}
