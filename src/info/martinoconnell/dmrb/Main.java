package info.martinoconnell.dmrb;

import java.util.Scanner;

public class Main {

	static int foundationClass;
	
	public static void main(String[] args) {
		
		System.out.println("Foundation Class 1 = Ecap between 50MPa and 100MPa\n"
				+ "Foundation Class 2 = Esb between 150MPa and 250MPa\n"
				+ "Foundation Class 3 = Esb between 500MPa and 1000MPa\n"
				+ "Foundation Class 4 = Esb between 1000MPa and 3500MPa\n");
		
		System.out.println("Note: sub-base is hydraulically bound and not unbound, e.g. CBGM\n");
		
		System.out.println("Enter Foundation Class: 1, 2, 3 or 4: ");
		Scanner input = new Scanner(System.in);
		foundationClass = input.nextInt();
		
		switch(foundationClass) {
		
		case 1:
			FdnClass1 calc1 = new FdnClass1();
			break;
			
		case 2:
			FdnClass2 calc2 = new FdnClass2();
			break;
			
		case 3:
			FdnClass3 calc3 = new FdnClass3();
			break;
			
		case 4:
			FdnClass4 calc4 = new FdnClass4();
			break;
			
		}
		
		UnRePQC calc5 = new UnRePQC();

	}

}
