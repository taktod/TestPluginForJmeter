package com.ttProject.jmeter.test;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;

/**
 * テストでつくっているサンプラー
 * @author taktod
 */
public class MyTestSampler extends AbstractSampler implements TestBean {
	/** シリアルバージョンIDを追加 */
	private static final long serialVersionUID = -1L;
	/** 設定項目 */
	private String data1;
	private String data2;
	/**
	 * @return the data1
	 */
	public String getData1() {
		return data1;
	}
	/**
	 * @param data1 the data1 to set
	 */
	public void setData1(String data1) {
		this.data1 = data1;
	}
	/**
	 * @return the data2
	 */
	public String getData2() {
		return data2;
	}
	/**
	 * @param data2 the data2 to set
	 */
	public void setData2(String data2) {
		this.data2 = data2;
	}
	/**
	 * サンプリング動作
	 */
	@Override
	public SampleResult sample(Entry paramEntry) {
		SampleResult result = new SampleResult();
		// 動作結果のところに追加する動作タイトル
		result.setSampleLabel("TestResult");
		// サンプリングスタート
		result.sampleStart();
		try {
			// 時間のかかる本処理
			Thread.sleep(500L);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// サンプル終了
		result.sampleEnd();
		// 応答内容
		String response = 
			 "data1:" + data1 + 
			" data2:" + data2;
		
		result.setResponseData(response.getBytes());
		// 応答データを文字列にしておく。
		result.setDataType(SampleResult.TEXT);
		// 成功失敗の印(成功にしておく)
		result.setSuccessful(true);
		return result;
	}
}
