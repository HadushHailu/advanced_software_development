package counter;

public class Counter {
	
	private int count=0;
	private ICountObserver textframe ;
	private ICountObserver rectframe ;
	private ICountObserver ovalframe ;

	public int getCount() {
		return count;
	}

	public void increment(){
		count++;
    	textframe.setCount(count);
    	rectframe.setCount(count);
    	ovalframe.setCount(count);
	}

	public void incrementCommand(){
		count++;
		textframe.setCount(count);
		rectframe.setCount(count);
		ovalframe.setCount(count);
	}
	
	public void decrement(){
		count--;
	   	textframe.setCount(count);
    	rectframe.setCount(count);
    	ovalframe.setCount(count);
	}

	public void setTextframe(ICountObserver textframe) {
		this.textframe = textframe;
	}

	public void setRectframe(ICountObserver rectframe) {
		this.rectframe = rectframe;
	}

	public void setOvalframe(ICountObserver ovalframe) {
		this.ovalframe = ovalframe;
	}


}
