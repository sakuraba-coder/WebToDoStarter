package com.example.demo.app.collatz;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Collatz {

	//sample

	private MaxCount mc = new MaxCount("", 0);

	private DataBean data;
	private List<DataBean> dataList = new ArrayList<DataBean>();

	public Collatz() {
	};

	/**
	 * 対象の数値にコラッツ演算を行う
	 * @param num
	 * @return
	 */
	public Output calc(String num) {
		calc(num, true);
		return new Output(data);
	}

	/**
	 *
	 * @param num 計算対象の数字
	 * @param flag  trueの場合はプロセスを保存、falseの場合はプロセスを破棄
	 */
	private void calc(String num, Boolean flag) {
		BigInteger bi = new BigInteger(num); //計算対象の数

		int len = bi.toString().length(); //桁数
		int count = 0; //計算回数
		int oddCount = 0; //奇数
		int evenCount = 0; //偶数
		BigInteger max = BigInteger.ZERO; //出現する最大値

		List<BigInteger> list = new ArrayList<BigInteger>(); //毎回の処理

		while (bi.compareTo(BigInteger.ONE) != 0) {
			list.add(bi);
			//現れる最大値 値1 > 値2なら1を返す
			if (bi.compareTo(max) == 1) {
				max = bi;
			}
			//コラッツ演算
			if (bi.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0) {
				bi = bi.divide(BigInteger.valueOf(2));
				evenCount++;
			} else {
				bi = bi.multiply(new BigInteger("3")).add(BigInteger.ONE);
				oddCount++;
			}
			count++;
		}
		list.add(bi);

		if (flag) {
			//プロセスを入れる
			data = new DataBean(num, list, len, count, evenCount, oddCount, max);
		} else {
			//プロセスをいれない
			data = new DataBean(num, len, count, evenCount, oddCount, max);
		}
	}

	/**
	 * 初期値から最大値までのそれぞれの数値に対してコラッツ演算を行う
	 * @param min 初期値
	 * @param max
	 * @return
	 */
	public Output calcs(String min, String max) {
		for (BigInteger bi = new BigInteger(min); bi.compareTo(new BigInteger(max)) == -1; bi = bi.add(BigInteger.ONE)) {
			if (bi.mod(BigInteger.valueOf(10000)).compareTo(BigInteger.ZERO) == 0) {
				System.out.println(bi.toString() + "終了");
			}
			calc(bi.toString(), false);
			//試行回数の最大値の計算
			mc.compare(bi.toString(), data.getCount());
			dataList.add(data);
		}
		return new Output(dataList, mc);
	}

	/**
	 * elmをcount回接続して、それぞれにコラッツ演算を行う
	 * 例 elm="123", count=3の場合、123, 123123, 123123123 のそれぞれに対してコラッツ演算を行う
	 * @param elm
	 * @param count
	 * @return
	 */
	public Output calcs(String elm, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(elm);
			calc(sb.toString(), false);
			dataList.add(data);
		}
		return new Output(dataList);
	}

	public DataBean getData() {
		return data;
	}


}
