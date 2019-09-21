
/* Foundation Class 2 is for SUB-BASE ONLY and SUB-BASE with CAPPING
 * Hsb1, Hsb2 and Hsb3 min = 150mm
 * Esb between 150MPa and 250MPa
 */

package info.martinoconnell.dmrb;

import java.util.Scanner;

public class FdnClass2 {

	private double Hsb1;
	private double Hsb2;
	private double Hsb3;
	private double HCap;
	private double Esb;
	private double ECap;
	private double cbr;
	private String sb;

	public double getHCap() {
		return HCap;
	}

	public void setHCap(double hCap) {
		HCap = hCap;
	}

	public double getHsb3() {
		return Hsb3;
	}

	public void setHsb3(double hsb3) {
		Hsb3 = hsb3;
	}

	public double getECap() {
		return ECap;
	}

	public void setECap(double eCap) {
		ECap = eCap;
	}

	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}

	public double getHsb1() {
		return Hsb1;
	}

	public void setHsb1(double hsb1) {
		Hsb1 = hsb1;
	}

	public double getHsb2() {
		return Hsb2;
	}

	public void setHsb2(double hsb2) {
		Hsb2 = hsb2;
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

	FdnClass2(){

		System.out.println("Enter subgrade CBR value between 2.5% and 30%: ");
		Scanner input1 = new Scanner(System.in);
		cbr = input1.nextDouble();

		System.out.println("Enter sub-base modulus of elasticity 'Esb' between 150MPa and 250MPa : ");
		Scanner input2 = new Scanner(System.in);
		Esb = input2.nextDouble();

		System.out.println("Is the sub-base on capping? 'y' or 'n' ");
		Scanner input3 = new Scanner(System.in);
		sb = input3.nextLine();

		calculate();

	}

	// For CBR >= 2.5% and <= 5%

	public double HsbLowCalc(double EsbVar, double cbrVar) {

		Hsb1 = 2.85 * Math.pow(10, 3) * Math.pow(EsbVar, -0.341) * (1 - 0.389*Math.pow(EsbVar, -0.021) * Math.log(cbrVar));

		return Hsb1;

	}

	// For CBR > 5% and <= 30%

	public double HsbHighCalc(double EsbVar, double cbrVar) {

		Hsb2 = 9.25 * Math.pow(10, 2) * Math.pow(EsbVar, -0.202) - 69*Math.log(cbrVar);

		return Hsb2;

	}

	// For CBR > 2.5% and <= 15% AND sub-base on capping

	public double HsbOtherCalc(double ECapVar, double EsbVar, double cbrVar) {

		Hsb3 = 8.27*Math.pow(10, 4) * (0.4123*Math.log(ECapVar) - 1) * Math.pow(EsbVar, -1*(0.2075 + 0.1933*Math.log(ECapVar)))
				- 21.39*Math.pow(ECapVar, 1.745)*Math.pow(EsbVar, (0.271 - 0.335*Math.log(ECapVar)));

		return Hsb3;

	}

	public void calculate() {

		if(this.getCbr() >= 2.5 && this.getCbr() <=5.0) {

			if(this.getSb().equals("y")) {

				System.out.println("For 2.5% <= CBR <= 5%, enter capping modulus of elasticity 'Ecap' between 150MPa and 250MPa: ");
				Scanner input4 = new Scanner(System.in);
				ECap = input4.nextDouble();

				double ans3 = this.HsbOtherCalc(this.getECap(), this.getEsb(), this.getCbr());
				int result = (int) ans3;
				HCap = 3.01 * Math.pow(10, 2) - 56*Math.log(this.getCbr());
				int HCap1 = (int) HCap;
				
				System.out.println("\nHsb = " + result + " mm");
				System.out.println("Hcap = " + HCap1 + " mm\n");
				
			}

			else if(this.getSb().equals("n")) {
				
				double ans1 = this.HsbLowCalc(this.getEsb(), this.getCbr());
				int result = (int) ans1;
				
				System.out.println("\nHsb = " + result + " mm\n");

				
			}
		}

		else if(this.getCbr() > 5.0 && this.getCbr() <= 30.0) {

			if(this.getSb().equals("y") && this.getCbr() > 5.0 && this.getCbr() <= 15.0) {

				System.out.println("For 5% <= CBR <= 15%, enter capping modulus of elasticity 'Ecap' between 150MPa and 250MPa: ");
				Scanner input4 = new Scanner(System.in);
				ECap = input4.nextDouble();

				double ans3 = this.HsbOtherCalc(this.getECap(), this.getEsb(), this.getCbr());
				int result = (int) ans3;
				HCap = 3.01 * Math.pow(10, 2) - 56*Math.log(this.getCbr());
				int HCap1 = (int) HCap;
				
				System.out.println("\nHsb = " + result + " mm");
				System.out.println("Hcap = " + HCap1 + " mm\n");
				
			}

			else if(this.getSb().equals("n") || this.getCbr() > 15.0) {

				double ans2 = this.HsbHighCalc(this.getEsb(), this.getCbr());
				int result = (int) ans2;
				
				System.out.println("\nHsb = " + result + " mm\n");

			}

		}

	}
	
}
