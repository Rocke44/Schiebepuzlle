package schiebepuzzle;

import java.util.ArrayList;

public class SlidingPuzzle {
	private int size;
	private ArrayList<Integer> field;
	
	public SlidingPuzzle(int size){
		if(size < 1 || size > 10){throw new RuntimeException("This size is Impossible");}
		this.size = size;
		this.field = new ArrayList<Integer>();
		field.ensureCapacity(size * size);
		for(int i = 1; i < size * size; i++){
			field.add(i);
		}
		field.add(0);	
	}
	
	public void slide(int num){
		if(num < 1 || num > size*size - 1){throw new WrongNumberException("The number is invalid!");
		int inZero = findNumber(0);
		int inNumber = findNumber(num);
		if(inZero == inNumber - 1 || inZero == inNumber + 1 || inZero == inNumber + size || inZero == inNumber - size ){
			field.set(inZero , num);
			field.set(inNumber, 0);
		}else{
			throw new WrongMoveException("The choosen number is not next to the empty place.");
		}
	}
	
	private int findNumber(int num){
		return field.indexOf(num);
	}
	
	private int getIndex(int row, int colum){
		return row*size + colum;
	}
	
	private int getRow(int i){
		return i / size;
	}
	
	private int getColum(int i){
		return i % size;
	}
}
