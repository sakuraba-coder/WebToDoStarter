package com.example.demo.app.collatz;

import java.math.BigInteger;
import java.util.List;

import lombok.Data;

@Data
public class DataBean {

	private String num = null;
	private List<BigInteger> procList = null;
	private int len;
	private int count;
	private int evenCount;
	private int oddCount;
	private BigInteger max = null;
	private MaxCount mc = null;

	public DataBean(String num, List<BigInteger> procList, int len, int count, int evenCount, int oddCount, BigInteger max) {
		this.num = num;
		this.procList = procList;
		this.len = len;
		this.setCount(count);
		this.evenCount = evenCount;
		this.oddCount = oddCount;
		this.max = max;
	}

	public DataBean(String num, int len, int count, int evenCount, int oddCount, BigInteger max) {
		this.num = num;
		this.len = len;
		this.setCount(count);
		this.evenCount = evenCount;
		this.oddCount = oddCount;
		this.max = max;
	}

	@Override
	public String toString() {
		return len + "," + count + "," + evenCount + "," + oddCount + "," + max.toString() + "," +
				"桁数,試行回数,偶数回,奇数回,最大出現値";
	}


}
