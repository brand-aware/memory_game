/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.io.IOException;

import javax.swing.JButton;

import highscores.NameInput;

public class UtilsBoardActions extends CommonBoard{
	
	
	protected final void top1() throws IOException{
		if(!isCorrect(top1)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir() , board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected final void top2() throws IOException{
		if(!isCorrect(top2)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir() , board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected final void left() throws IOException{
		if(!isCorrect(left)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir() , board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected final void right() throws IOException{
		if(!isCorrect(right)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir() , board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected final void bottom1() throws IOException{
		if(!isCorrect(bottom1)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir() , board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected final void bottom2() throws IOException {
		if(!isCorrect(bottom2)){
			int size = order.size();
			animateButton = false;
			balogger.stopTimer();
			balogger.logScore("", "" + size);
			NameInput nameInput = new NameInput(properties.getRootDir(), board, PRODUCT_NAME, userDir);
			try {
				nameInput.setDescending();
				nameInput.init(size - 1);
				desktopPane.add(nameInput);
				desktopPane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			reloadButtons();
			disable();
			count = 0;
		}else{
			count++;
		}
		int size = order.size();
		if(count == size){
			doMove();
			count = 0;
		}
	}
	
	protected void doMove(){
		if(normalFlag){
			double random = Math.random();
			int index = (int) (random * BUTTONS);
			order.add(index);
		}else if(hardFlag){
			double random = Math.random();
			int index = (int) (random * BUTTONS);
			order.add(index);
			random = Math.random();
			index = (int) (random * BUTTONS);
			order.add(index);
		}else if(harderFlag){
			double random = Math.random();
			int index = (int) (random * BUTTONS);
			order.add(index);
			if(count > 0 && count % 5 == 0){
				for(int x = 0; x < 5; x++){
					random = Math.random();
					index = (int) (random * BUTTONS);
					order.set(x, index);
				}
			}
		}
		showOrder = true;
	}
	
	private boolean isCorrect(JButton button){
		Integer index = lookupTable.get(button);
		int size = order.size();
		if(count < size){
			int correctButton = order.get(count);
			if(correctButton == index){
				return true;
			}
		}
		return false;
	}
	
	private void reloadButtons(){
		createLookupTable();
		top1.setText(getButtonText(0));
		top2.setText(getButtonText(1));
		left.setText(getButtonText(2));
		right.setText(getButtonText(3));
		bottom1.setText(getButtonText(4));
		bottom2.setText(getButtonText(5));
	}
	
	protected void createLookupTable(){
		lookupTable.put(top1, 0);
		lookupTable.put(top2, 1);
		lookupTable.put(left, 2);
		lookupTable.put(right, 3);
		lookupTable.put(bottom1, 4);
		lookupTable.put(bottom2, 5);
		
		lookupTable2.put(0, top1);
		lookupTable2.put(1, top2);
		lookupTable2.put(2, left);
		lookupTable2.put(3, right);
		lookupTable2.put(4, bottom1);
		lookupTable2.put(5, bottom2);
	}
	
	protected String getButtonText(int index){
		if(index == 0){
			return "blue";
		}else if(index == 1){
			return "black";
		}else if(index == 2){
			return "green";
		}else if(index == 3){
			return "yellow";
		}else if(index == 4){
			return "red";
		}else if(index == 5){
			return "orange";
		}
		return null;
	}
	
	public void disable(){
		fileMenu.setEnabled(false);
		options.setEnabled(false);
		help.setEnabled(false);
		
		left.setEnabled(false);
		right.setEnabled(false);
		top1.setEnabled(false);
		top2.setEnabled(false);
		bottom1.setEnabled(false);
		bottom2.setEnabled(false);
		middle.setEnabled(false);
	}

}
