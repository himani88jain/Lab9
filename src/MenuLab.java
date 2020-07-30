import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;

public class MenuLab {
	
 private static Scanner scnr;
 private static Map<String,Double> items=new TreeMap<>();
 private static List<String> orderNames = new ArrayList<>();
 private static List<Double> orderPrices = new ArrayList<>();
 private static DecimalFormat df = new DecimalFormat("0.00");
 private static String itemName;
 private static double itemPrice;
 private static int count=0;
 private static List<Integer> listNumber= new ArrayList<>();

 
	public static void main(String[] args) {
		scnr=new Scanner(System.in);
		fillItemsMap();
		printMenu();
		boolean choice=false;
		boolean response=true;
    do {
		do {
		System.out.println("What item would you like to order?");
		itemName=scnr.nextLine();
		int checkChoice = 0;
	for(String s:items.keySet()) {
		if(s.equalsIgnoreCase(itemName))	
		{
			count++;
			itemPrice=items.get(s);
			System.out.println("Adding "+itemName+" to cart at $"+itemPrice);
			addOrder();
			addPrice();
			checkChoice++;
			choice=false;
		}
		}

		if(checkChoice==0) {
			System.out.println("Sorry we dont have those.Please try again");
			printMenu();
			choice=true;
		}
		}while(choice);
		System.out.println();
		response=Validator.getYesNo(scnr, "Would you like to order anything else?(y/n)");
    	}while(response);
		System.out.println("Thanks for your order!");
		System.out.println("Here what you got:");
		for(int i=0;i<count;i++) {
			System.out.printf("%-20s%-1s%-20.2f\n",orderNames.get(i),"$",orderPrices.get(i));
		}
		
		
		System.out.println("Average price per item in order was $"+df.format(average(orderPrices)));
		System.out.println();
		System.out.println("Index of highest priced item in menu is "+findMaxIndexMenu(items));
		System.out.println();
		System.out.println("Index of lowest priced item in menu is"+findMinIndexMenu(items));
		System.out.println();
		int maxIndex=findMaxIndex(orderPrices);
		System.out.println("Your highest cost item is "+orderNames.get(maxIndex));
		System.out.println();
		int minIndex=findMinIndex(orderPrices);
		System.out.println("Your lowest cost item is "+orderNames.get(minIndex));
		scnr.close();

	}
	
	//Filling Values in Menu
	private static void fillItemsMap() {
		items.put("apple",.99);
		items.put("banana",.59);
		items.put("cauliflower",1.59);
		items.put("dragonfruit",2.19);
		items.put("elderberry",1.79);
		items.put("figs",2.09);
		items.put("grapefruit",1.99);
		items.put("honeydew",3.49);
		items.put("lemon",1.67);
	}
	
	//Printing menu
	private static void printMenu() {
		System.out.println("Item\t\tPrice");
		System.out.println("=================================");
		int i=0;
		for(Map.Entry<String,Double> entry: items.entrySet()) {
			listNumber.add(i+1);
			System.out.printf("%-5d%-20s%-1s%-20.2f\n",listNumber.get(i),entry.getKey(),"$",entry.getValue());
			i++;
	}
	}	
	
	
	//calculating average of order
	private static double average(List<Double> orderPrice) {
		double total=0,average=0;
		for(double d:orderPrice) {
			total+=d;
		}
		average=total/orderPrice.size();
		return average;
	}
	
	//Adding items to your order
	private static List<String> addOrder() {
	
	 orderNames.add(itemName);
	return orderNames;
	}
	
	
	//Adding price corresponding to order
	private static List<Double> addPrice() {
		orderPrices.add(itemPrice);
		return orderPrices;
	}
	
	
	//Finding index of  most costly item of order
	private static int findMaxIndex(List<Double> nums) {
		double max=nums.get(0);
		int indexMax=0;
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)>max) {
				max=nums.get(i);
				indexMax=i;
			}
		}
		return indexMax;
	}
	
	//Finding index of cheapest menu of order
	private static int findMinIndex(List<Double> nums) {
		double min=nums.get(nums.size()-1);
		int indexMin=0;
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)<min) {
				min=nums.get(i);
				indexMin=i;
			}
		}
		return indexMin;
	}
	
	//Finding index of most expensive item of menu
	private static int findMaxIndexMenu(Map<String,Double> itemsInMenu) {
		double max=0;
		int indexMax=0;
		for(double d:itemsInMenu.values())
		{
			if(d>max) {
				max=d;
				indexMax++;
			}
	}
		return indexMax;
	}
	
	//Finding index of most cheap item of menu
	private static int findMinIndexMenu(Map<String,Double> itemsInMenu) {
		double min=100;
		int indexMin=0;
		for(double d:itemsInMenu.values())
		{
			if(d<min) {
				min=d;
				indexMin++;
			}
	}
		return indexMin;
	}
	
 }
