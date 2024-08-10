package counter;

public class Counter extends CountObservable{
	
	private int count=0;
	private CountDigitState countDigitState;

	public int getCount() {
		return count;
	}

	public void increment(){
		countDigitState.increment();
		super.update(count);

	}

	public void decrement(){
		countDigitState.decrement();
		super.update(count);
	}

	public void setCountDigitState(CountDigitState countDigitState) {
		this.countDigitState = countDigitState;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
