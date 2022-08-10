package com.example.demo.app.collatz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Output {

	private DataBean data;
	private MaxCount mc;
	private List<DataBean> dataList;

	public Output(DataBean data) {
		this.data = data;
	}

	public Output(DataBean data, MaxCount mc) {
		this.data = data;
		this.mc = mc;
	}

	public Output(List<DataBean> dataList, MaxCount mc) {
		this.dataList = dataList;
		this.mc = mc;
	}

	public Output(List<DataBean> dataList) {
		this.dataList = dataList;
	}

	public String getJsonStr() {
		StringBuilder sb = new StringBuilder();
		BigInteger count = BigInteger.ZERO;
		if (dataList==null) {
			sb.append("[");

			for(BigInteger bi : data.getProcList()) {
				sb.append(exJson(count, bi));
				sb.append(",");
				count.add(BigInteger.ONE);
			}
			sb.setLength(sb.length()-1);

			sb.append("]");
			return sb.toString();
		} else {
			sb.append("[");

			for(DataBean db : dataList) {
				sb.append(exJson(new BigInteger(String.valueOf(db.getLen())), BigInteger.valueOf(db.getCount())));
				sb.append(",");
				count.add(BigInteger.ONE);
			}
			sb.setLength(sb.length()-1);

			sb.append("]");
			return sb.toString();
		}
	}

	private String exJson(BigInteger x, BigInteger y) {
		return "{\"x\":" + x + ", \"y\":" + y.toString() +  "}";
	}



	/**
	 * 標準出力
	 */
	public void print() {

		if (dataList == null) {
			int count = 0;
			for(BigInteger bi : data.getProcList()) {
				System.out.println(count + "," + bi);
				count++;
			}
			System.out.println(data.toString());
		} else if (mc == null) {
			for (DataBean data : dataList) {
				System.out.println(data.toString());
			}
		} else {
			for (DataBean data : dataList) {
				System.out.println(data.getNum() + ",数値," + data.toString());
			}
			System.out.println(mc.getNum() + ", " + mc.getCount() + ", 数値, 最大試行回数");
		}
	}

	/**
	 *
	 * @return Dataリストを取得する
	 */
	public List<?> getList() {
		if (dataList==null) {
			return data.getProcList();
		} else {
			return dataList;
		}
	}

	/**
	 *
	 * @return MaxCountの取得
	 */
	public MaxCount getMaxCount() {
		return mc;
	}

	/**
	 * ファイル出力
	 */
	public void write() {
		System.out.println("書き込み中");
		try {
			File file = new File("C:\\Users\\Customer03\\Desktop\\コラッツ.csv");
			FileWriter filewriter = new FileWriter(file);
			if (dataList == null) {
				filewriter.write(data.getProcList().toString());
			} else {
				for (DataBean data : dataList) {
					filewriter.write(data.toString() + "\n");
				}
			}

			filewriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("書き込み終了");
	}

	@Override
	public String toString() {
		return data.getProcList().toString() + "\n" + data.toString();
	}

}
