package hrv.calc.statistical;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import hrv.HRVParameter;
import hrv.RRData;
import hrv.calc.HRVDataProcessor;

public class SD2Calculator implements HRVDataProcessor {

	@Override
	public HRVParameter process(RRData data) {
		SDSDCalculator sdsdCalc = new SDSDCalculator();
		double sdsd = sdsdCalc.process(data).getValue();
		StandardDeviation sdnnCalc = new StandardDeviation();
		double sdnn = sdnnCalc.evaluate(data.getValueAxis());
		double val = 2 * sdsd * sdsd - 0.5 * sdnn * sdnn;
		return new HRVParameter("SD2", Math.sqrt(val), "non");
	}

}
