package snake_ladder;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> oldList;
    private ArrayList<Integer> diceList;
    private ArrayList<Integer> newList;

    public Player(){
        oldList = new ArrayList<Integer>();
        oldList.add(0);
        diceList = new ArrayList<Integer>();
        newList = new ArrayList<Integer>();
    }
    
    public boolean update(){
        int index = oldList.size() - 1;
        int oldStep = oldList.get(index);
        int dice = diceList.get(index);
        int newStep = oldStep + dice;
        if (newStep == 13){
            newStep = 7; 
        }
        else if (newStep == 25){
            newStep = 40;
        }
        else if (newStep == 50){
            newStep = 38;
        }
        else if (newStep == 63){
            newStep = 78;
        }
        else if (newStep == 83){
            newStep = 97;
        }
        else if (newStep == 95){
            newStep = 76;
        }
        else if (newStep > 100){
            newStep = 100 - (newStep - 100);
        }
        newList.add(newStep);
        oldList.add(newStep);
        if (newStep == 100){
            return true;
        }
        return false;
    }

    public void destroy(){
        newList.add(0);
    }
    public void insertDice(int dice){
        diceList.add(dice);
    }

    public int getOldStep(int index){
        return oldList.get(index);
    }

    public int getDice(int index){
        return diceList.get(index);
    }

    public int getNewStep(int index){
        return newList.get(index);
    }

    public int getNewListSize(){
        return newList.size();
    }
}
