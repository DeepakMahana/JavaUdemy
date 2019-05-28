package javaCollections;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Theatre theatre = new Theatre("Olympian", 8, 12);
		
		if(theatre.reserveSeat("D12")) {
			System.out.println("Please Pay for D12");
		}else {
			System.out.println("Seat Already Reserved");
		}
		
		if(theatre.reserveSeat("B13")) {
			System.out.println("Please Pay for B13");
		}else {
			System.out.println("Seat Already Reserved");
		}
		
		if(theatre.reserveSeat("B13")) {
			System.out.println("Please Pay for B13");
		}else {
			System.out.println("Seat Already Reserved");
		}
		
		List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		printList(reverseSeats);
		
		List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(theatre.new Seat("B00", 13.00));
		priceSeats.add(theatre.new Seat("A00", 13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats);
	}
	
	public static void printList(List<Theatre.Seat> list){
		for(Theatre.Seat seat: list) {
			System.out.print(" " + seat.getSeatNumber() + "$" + seat.getPrice());
		}
		System.out.println();
		System.out.println("===================================================================================================================================================================================");
	}
	
//	public static void sortList(List<? extends Theatre.Seat> list){
//		for(int i=0; i<list.size(); i++){
//			for(int j=i + 1; j<list.size(); j++){
//				if(list.get(i).compareTo(list.get(j)) > 0){
//					Collections.swap(list, i, j);
//				}
//			}
//		}
//	}

}
