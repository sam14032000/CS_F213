/**
 * A Campus consists of multiple dorms and guests checking In and Out.
 * @author Arshdeep Singh, Mayur Jartarkar
 * @version August 20, 2019
*/
public class Campus
{
	/** Represents the number of Dorms in the Campus.
	*/
	private int dormCount;

	/** Represents a final static int that reoresents the maximum number of dorms that can be there in Campus.
	 	The value is equal to 10.
	*/
	static final int MAX_DORMS = 10;

	/** Represents an array containing objects of Dorm class.
	*/
	private Dorm[] dormList;

	/** Constructor for Campus Class. It is used to initilaze the dormList array with MAX_DORMS dorms.
		It also initilazes the dormCount to 0.
	*/
	public Campus(){
		this.dormCount = 0;
		dormList = new Dorm[MAX_DORMS];
	}

	/** Adds a dorm object to the Campus.
	  * @param capacity integer representing the capacity of the dorm to be added.
	  * @return boolean true if dorm is added successfully else false.
	*/
	public boolean addDorm(int capacity){
		if(dormCount<MAX_DORMS){
			dormList[dormCount] = new Dorm(capacity);
			dormCount++;
			return true;
		}
		else{
			return false;
		}
	}

	/** Return the total furniture count in all dorms.
	  * @return integer representing total furniture count.
	*/
	public int getFurnitureCount(){
		int count=0;
		for(int currentDormIndex=0; currentDormIndex < dormCount; currentDormIndex++){
			count += dormList[currentDormIndex].getFurnitureCount();
		}
		return count;
	}

	/** Adds a new furniture to a particular dorm object of the Campus.
	  * @param index integer representing the index of the dorm to which furniture has to be added.
	  * @param furniture string representing the furniture that is to be added.
	  * @return boolean true if furniture is added successfully else false.
	*/
	public boolean insertFurniture(int index, String furniture){
		if(index<this.dormCount)
			return dormList[index].addFurniture(furniture);
		else
			return false;
	}

	/** Checks in a new guest to the first dorm according to their index which is empty.
	  * @return boolean true if guest is added successfully else false.
	*/
	public boolean checkIn(){
		int index = 0;
		while(index<dormCount && dormList[index].getEmptyCapacity()==0){
			index++;
		}
		if(index<dormCount){
			return dormList[index].checkIn();
		}
		else{
			return false;
		}
	}

	/** Checks in a new guest to the dorm whose index is given.
	  * @param index integer representing index of the dorm to be added.
	  * @return boolean true if guest is added successfully else false.
	*/
	public boolean checkIn(int index){
		if(index<dormCount && index>=0){
			return dormList[index].checkIn();
		}
		else{
			return false;
		}
	}

	/** Checks out a existing guest from the dorm whose index is given.
	  * @param index integer representing index of dorm.
	  * @return boolean true if guest is checked out successfully else false.
	*/
	public boolean checkOut(int index){
		if(index<dormCount && index>=0){
			return dormList[index].checkOut();
		}
		else{
			return false;
		}
	}
}
