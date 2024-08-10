package domain;

public class Counter extends CountForFramesObservable {
	
	private int count=0;
	private CountDigitState countDigitState;
	private CountForLoggersObservable countForLoggersObservable;

	public void setCountForLoggersObservable(CountForLoggersObservable countForLoggersObservable) {
		this.countForLoggersObservable = countForLoggersObservable;
	}

	public CountForLoggersObservable getCountForLoggersObservable() {
		return countForLoggersObservable;
	}

	public int getCount() {
		return count;
	}

	public void increment(){
		countDigitState.increment();
		super.update(count);
		countForLoggersObservable.update(count);

	}

	public void decrement(){
		countDigitState.decrement();
		super.update(count);
		countForLoggersObservable.update(count);
	}

	public void setCountDigitState(CountDigitState countDigitState) {
		this.countDigitState = countDigitState;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
