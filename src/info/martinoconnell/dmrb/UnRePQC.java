package info.martinoconnell.dmrb;

import java.util.Scanner;

public class UnRePQC {
	
	private double h1;
	private int traffic;	// MSA (Million Standard Axles)
	private int Rc; 		// Mean compressive strength at 28 days
	private int stiffness;	// Long term foundation target stiffness: 50MPa, 100MPa, 200MPa or 400MPa
	private double lnH1;
	
	public double getH1() {
		return h1;
	}
	public void setH1(double h1) {
		this.h1 = h1;
	}
	public int getTraffic() {
		return traffic;
	}
	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}
	public int getRc() {
		return Rc;
	}
	public void setRc(int rc) {
		Rc = rc;
	}
	public int getStifness() {
		return stiffness;
	}
	public void setStifness(int stiffness) {
		this.stiffness = stiffness;
	}
	public double getLnH1() {
		return lnH1;
	}
	public void setLnH1(double lnH1) {
		this.lnH1 = lnH1;
	}
	
	UnRePQC(){
		
		System.out.println("Enter design traffic in MSA: ");
		Scanner input1 = new Scanner(System.in);
		traffic = input1.nextInt();
		
		System.out.println("Enter mean concrete compressive strength after 28 days (N/mm2): ");
		Scanner input2 = new Scanner(System.in);
		Rc = input2.nextInt();
		
		System.out.println("Enter target foundation stiffness --> 50MPa, 100MPa, 200MPa or 400MPa: ");
		Scanner input3 = new Scanner(System.in);
		stiffness = input3.nextInt();
		
		calculate();
		
	}
	
	public void calculate() {
		
		lnH1 = (Math.log(traffic) - 3.466*Math.log(Rc) - 0.484*Math.log(stiffness) + 40.483) / 5.094;
		
		h1 = Math.exp(lnH1);
		int h1int = (int) h1;
		System.out.println("\nPQC slab thikness = "+ h1int + " mm\n");
		
	}

}
