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
		result.setResponseData("Sample is ended with success...".getBytes());
		// 応答データを文字列にしておく。
		result.setDataType(SampleResult.TEXT);
		// 成功失敗の印(成功にしておく)
		result.setSuccessful(true);
		return result;
	}
}
