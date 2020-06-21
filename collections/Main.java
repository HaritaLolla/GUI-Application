package collections;



public class Main {

	public static void main(String[] args) {
		
		System.out.println("================ SetCar ================"); //$NON-NLS-1$
		SetCar setCar = new SetCar();
		setCar.fill();
		System.out.println("After fill()"); //$NON-NLS-1$
		setCar.list();
		System.out.println("------------------- Checking cars -------------------"); //$NON-NLS-1$
		Car tesla = new Car("Tesla", "Racing", 20054634, 2018); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(String.format("Does tesla exists :%s", setCar.contains(tesla)? "true":"false")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Car Verna = new Car("Verna", "Sedan", 11411, 2013); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(String.format("Dose Verna exists:%s", setCar.contains(Verna)? "true":"false")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		System.out.println("================ ListCar ================"); //$NON-NLS-1$
		ListCar listCar=new ListCar();
		listCar.fill();
		System.out.println("After fill()"); //$NON-NLS-1$
		listCar.list();
		listCar.sortByName();
		System.out.println("After sortByName()"); //$NON-NLS-1$
		listCar.list();
		listCar.sortByCategory();
		System.out.println("After sortByCategory()"); //$NON-NLS-1$
		listCar.list();


	}

}
