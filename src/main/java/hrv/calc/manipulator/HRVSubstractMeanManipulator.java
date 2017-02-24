package hrv.calc.manipulator;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

import hrv.RRData;

public class HRVSubstractMeanManipulator implements HRVDataManipulator {

	@Override
	public RRData manipulate(RRData data) {
		
		double[] oldRRY = data.getValueAxis();
		double[] oldRRX = data.getTimeAxis();
		
		double[] newRRY = new double[data.getValueAxis().length];
		double[] newRRX = new double[data.getTimeAxis().length];
		
		Mean m = new Mean();
		double mean = m.evaluate(oldRRY);

		for (int i = 0; i < newRRY.length; i++) {
			newRRY[i] = oldRRY[i] - mean;
			newRRX[i] = oldRRX[i];
		}
		
		return new RRData(newRRX, data.getTimeAxisUnit(), newRRY, data.getValueAxisUnit());
	}

}
