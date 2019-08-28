/**
 * A dorm is a part of a Campus.
 * @author Arshdeep Singh, Mayur Jartarkar
 * @version August 20, 2019
*/
public class Dorm
{
	/** Represents the capacity of the Dorm.
	*/
	private int capacity;
	/** Represents the current Furniture Count.
	*/
	private int furnitureCount;
	/** Represents the current Guest Count.
	*/
	private int guestCount;
	/** Represents a static fixed value of maximum furnitures that can be present in dorm. This value is equal to 10.
	*/
	static final int MAX_FURNITURES = 10;
	/** Represents an array containing strings of furnitures.
	*/
	private String[] furnitureList;

	/** Constructor for Dorm Class. Takes an input parameter capacity and set the class capacity to it.
		It is used to initilaze the furnitureList array. It also initilazes the furnitureCount and guestCount to 0.
	  * @param capacity integer representing the capacity of the dorm.
	*/
	public Dorm(int capacity){
		this.capacity = capacity;
		this.furnitureCount = 0;
		this.guestCount = 0;
		furnitureList = new String[MAX_FURNITURES];
	}

	/** Adds a furniture of type String to the dorm.
	  * @param furniture String representing the furniture to be added to the dorm.
	  * @return boolean true if furniture is added successfully else false.
	*/
	public boolean addFurniture(String furniture){
		if(furnitureCount<MAX_FURNITURES){
			furnitureList[furnitureCount] = furniture;
			furnitureCount++;
			return true;
		}
		else{
			return false;
		}
	}

	/** Return the furniture count.
	  * @return integer representing furniture count.
	*/
	public int getFurnitureCount(){
		return furnitureCount;
	}

	/** Returns the furniture string at the index location. If not filled return null.
	  * @param index integer representing the location of the furniture to be extracted.
	  * @return string returns the furniture string at the index location. If not filled return null.
	*/
	public String getFurniture(int index){
		if(index<furnitureCount && index>=0){
			return furnitureList[index];
		}
		else{
			return null;
		}
	}

	/** Checks in a new guest to the dorm.
	  * @return boolean true if guest is added successfully else false.
	*/
	public boolean checkIn(){
		if(guestCount<capacity){
			guestCount++;
			return true;
		}
		else{
			return false;
		}
	}

	/** Checks out a existing guest from the dorm.
	  * @return boolean true if guest is checked out successfully else false.
	*/
	public boolean checkOut(){
		if(guestCount>0){
			guestCount--;
			return true;
		}
		else{
			return false;
		}
	}

	/** Returns the count of Guests statying in the dorm.
	  * @return int guestCount.
	*/
	public int getGuestCount(){
		return this.guestCount;
	}

	/** Returns the remaining capacity of the dorm.
	  * @return int remaining capacity.
	*/
	public int getEmptyCapacity(){
		return (capacity - guestCount);
	}
}
