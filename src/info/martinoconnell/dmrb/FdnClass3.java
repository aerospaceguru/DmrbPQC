
/* Foundation Class 3 is for SUB-BASE only 
 * Hsb min = 175mm
 * Esb between 500 and 1000MPa
 */

package info.martinoconnell.dmrb;

import java.util.Scanner;

public class FdnClass3 {

	private double Hsb;
	private double Esb;
	private double cbr;
	
	public double getHsb() {
		return Hsb;
	}
	public void setHsb(double hsb) {
		Hsb = hsb;
	}
	public double getEsb() {
		return Esb;
	}
	public void setEsb(double esb) {
		Esb = esb;
	}
	public double getCbr() {
		return cbr;
	}
	public void setCbr(double cbr) {
		this.cbr = cbr;
	}

	FdnClass3(){

		System.out.println("Enter subgrade CBR value between 2.5% and 30%: ");
		Scanner input1 = new Scanner(System.in);
		cbr = input1.nextDouble();

		System.out.println("Enter sub-base modulus of elasticity 'Esb' between 500MPa and 1000MPa: ");
		Scanner input2 = new Scanner(System.in);
		Esb = input2.nextDouble();

		calculate();

	}

	public double HsbCalc(double EsbVar, double cbrVar) {

		Hsb = 8.44*Math.pow(10, 3) * Math.pow(EsbVar, -0.48) * (1 - 0.261*Math.pow(EsbVar, -0.008)*Math.log(cbrVar));

		return Hsb;

	}

	public void calculate() {

		if(this.cbr >= 2.5 && this.cbr <= 30) {

			double ans = this.HsbCalc(getEsb(), getCbr());
			int ans1 = (int) ans;
			System.out.println("\nHsb = " + ans1 + " mm\n");

		}

		else { System.out.println("CBR value out of range");

		}

	}

}
