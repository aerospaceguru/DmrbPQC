
/* Foundation Class 1 is for CAPPING ONLY
 * Hcap min = 150mm
 * Esb between 50MPa and 100MPa
 */

package info.martinoconnell.dmrb;

import java.util.Scanner;

public class FdnClass1 {
	
	private double hCap1;
	private double hCap2;
	private double hCap3;
	private double ECap;
	private double cbr;
	
	public double gethCap1() {
		return hCap1;
	}

	public void sethCap1(double hCap1) {
		this.hCap1 = hCap1;
	}

	public double gethCap2() {
		return hCap2;
	}

	public void sethCap2(double hCap2) {
		this.hCap2 = hCap2;
	}

	public double gethCap3() {
		return hCap3;
	}

	public void sethCap3(double hCap3) {
		this.hCap3 = hCap3;
	}

	public double getECap() {
		return ECap;
	}

	public void setECap(double eCap) {
		ECap = eCap;
	}

	public double getCbr() {
		return cbr;
	}

	public void setCbr(double cbr) {
		this.cbr = cbr;
	}

	FdnClass1(){
		
		System.out.println("Enter subgrade CBR value between 2.5% and 15%: ");
		Scanner input1 = new Scanner(System.in);
		cbr = input1.nextDouble();
		
		System.out.println("Enter capping modulus of elasticity 'Ecap' between 50MPa and 100MPa: ");
		Scanner input2 = new Scanner(System.in);
		ECap = input2.nextDouble();
		
		calculate();
	
	}
	

	
	// For a CBR of >= 2.5% and <= 5%
	
	public double hCapLowCalc(double ECapVar, double cbrVar) {
		
		hCap1 = 1.845 * Math.pow(10, 3) * Math.pow(ECapVar, -0.25) * (1 - 0.395*Math.pow(ECapVar, -0.025)*Math.log(cbrVar));
		
		return hCap1;
		
	}
	
	// For a CBR of >= 2.5% and <= 5%
	
	public double hCapHigherCalc(double ECapVar, double cbrVar) {
		
		hCap2 = 2.0 * Math.pow(10, 2) * ECapVar*(Math.log(cbrVar) - 1.538) - 10.918 * Math.pow(10, 3)*(Math.log(cbrVar) - 1.541);
		
		return hCap2;
	}
	
	// For a CBR of >5% and <=15%
	
	public double hCapUpperCalc(double ECapVar, double cbrVar) {
		
		hCap3 = 1.016 * Math.pow(10, 3) * Math.pow(ECapVar, -0.214) * (1 - 0.23*(Math.pow(ECapVar, -0.026) * Math.log(cbrVar)));
		
		return hCap3;
	}

	// Choose which equation to use and calculate the answer
	
	public void calculate() {
		
		if(this.getCbr() >= 2.5 && this.getCbr() <=5.0) {
			
			double ans1 = this.hCapLowCalc(this.getECap(), this.getCbr());
			double ans2 = this.hCapHigherCalc(this.getECap(), this.getCbr());
			
			double result = Math.max(ans1, ans2);
			int result1 = (int) result;
			System.out.println("\nHCap = " + result1 + " mm\n");
			
		} 
		
		else if(this.getCbr() > 5.0 && this.getCbr() <= 15.0) {
	
		double ans3 = this.hCapUpperCalc(this.getECap(), this.getCbr());
		int result = (int) ans3;
		System.out.println("\nHcap = " + result + " mm\n");
		
		}
	
	}
	
}
