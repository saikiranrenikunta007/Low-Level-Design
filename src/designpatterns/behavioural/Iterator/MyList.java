package src.designpatterns.behavioural.Iterator;

public class MyList implements Iterator<Integer>{

    private int[] items;

    private int lastAvailableIndex;

    MyList(int [] items) {
        this.items = items;
        lastAvailableIndex = items.length - 1;
    }

    private int currIndex = -1;
    @Override
    public Boolean hasNext() {
        return currIndex < lastAvailableIndex;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return items[++currIndex];
        }
        return null;
    }
    public void display(){
        while(true){
            Integer next = this.next();
            if(next == null) break;
            System.out.print(next + " ");
        }
        System.out.println();
    }
}
