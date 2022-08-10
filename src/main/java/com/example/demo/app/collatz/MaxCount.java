package com.example.demo.app.collatz;

public class MaxCount {

	private String num;
	private long count;

	public MaxCount(String num, long count) {
		this.num = num;
		this.count = count;
	}

	public void compare(String num , long comparedCount) {
		if(comparedCount > count ) {
			this.num = num;
			this.count = comparedCount;
		}
	}



	@Override
	public String toString() {
		return "最大値:" + getNum() + ",最大カウント:" + getCount();
	}

	/**
	 * @return num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num セットする num
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(long count) {
		this.count = count;
	}


}
