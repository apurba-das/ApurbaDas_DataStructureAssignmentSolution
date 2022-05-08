package com.gl.q1;

import java.util.*;

public class AssembleFloors {
	
	public static void main(String[] args)
    {
		// Queue is used to store the user input of floor size on a particular day
        Queue<Integer> qFloors = new LinkedList<>();
        
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the total no of floors in the building");
		int noOfFloors = sc.nextInt();
		
		int floorSize;
		
		// total no. of floors = total no. of construction days needed
		for (int i = 0; i < noOfFloors; i++) {
			
			System.out.println("enter the floor size given on day : " + (i+1));
			floorSize = sc.nextInt();
			
			// Add the floorSize to the queue
			qFloors.add(floorSize);
			
		}
		       
        System.out.println("The order of construction is as follows\n");
        
        int highest = noOfFloors;
        int currentFloor;
        
        // To store the remaining floors which cannot be assembled on any day
        LinkedList<Integer> listRemaining = new LinkedList<Integer>();
        
        for (int i = 0; i < noOfFloors; i++) {
			
			System.out.println("Day: " + (i+1));
			
			// Queue follows FIFO policy, so the floor removed is the one given to the architect
			currentFloor = qFloors.remove();
			
			if (currentFloor != highest) {
				
				// print empty line if the floor size is not the largest as assembly needs to happen in descending order
				System.out.println();
				
				// add the current floor to the list to refer to in the coming days
				listRemaining.add(currentFloor);
				
			}
			else {
				
				System.out.print("" + currentFloor);
				
				// Decrement the value of the largest floor as it is already assembled
				highest--;
				
				while(listRemaining.contains(highest)) {
					
					System.out.print(" " + highest);
					
					// Remove the largest floor from the list
					listRemaining.remove(listRemaining.indexOf(highest)); 
					
					// Decrement the value of the largest floor as it is already assembled
					highest --;
					
				}
				
				System.out.println(); // leave a line space	
				
			}			
        }	
    	
    	sc.close();
	
    }

}
