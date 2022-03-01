public class Order {
    public static final int MAX_NUMBERS_ORDER = 10;
    private int qtyOrdered;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBERS_ORDER)
        {
            System.out.println("Full!");
        }
        else
        {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Success!");
        }

    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered <= 0)
        {
            System.out.println("Khong con sp trong gio hang!");
        }
        else
        {   
            for(int i = 0 ; i < qtyOrdered -1 ; i++)
            {   
                if(itemOrdered[i] == disc )
                {
                    for ( int j = i ; j < qtyOrdered - 1 ; j++)
                    itemOrdered[j] = itemOrdered[j+1] ;
                }      
            }
            qtyOrdered--;   
            System.out.println("Xoa thanh cong !");
        }
    }
    public float totalCost() {
        float totalCost = 0.0f;
        for ( int i = 0 ; i < qtyOrdered ; i++)
        {
            totalCost += itemOrdered[i].getCost();
        }
        return totalCost;
    }
}
