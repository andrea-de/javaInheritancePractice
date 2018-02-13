/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancepractice;

/**
 *
 * @author Andy
 */
public class InheritancePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello");
        Chair a = new Chair(Material.WOOD);
        System.out.println(a);
        a.sits();
        a.floodedAction();
        Chair b = new Chair(Material.METAL);
        System.out.println(b.destroy());
    }
    
}

enum Material{
    WOOD, PLASTIC, STONE, METAL, FABRICS, MIXED
}

interface Furniture {
    
    String destroy();
    
    static String ddestroy(){
        return "something";
    }

}

interface insideFurniture extends Furniture {
    
    void floodedAction();
    
}

abstract class Seat {
    
    {
        System.out.println("A seat has been made in your honor.");
    }
    
    int places;
    
    abstract void sits();
    
    @Override
    public String toString(){
        return "This seat, " + this.hashCode() + ", has " + places + " places for people to sit.";
    }
    
}

class Chair extends Seat implements insideFurniture {
    
    static {
        System.out.println("This will only happen once no matter how many chairs you create.");
    }
    
    Material material;
    
    Chair(Material material){
        this.material = material;
        this.places = 1;
    }
    
    @Override
    void sits(){
        System.out.println("some dude sits down");
    }

    @Override
    public void floodedAction() {
        System.out.println("A flood came and ruined your chair");
    }

    @Override
    public String destroy() {
        switch(this.material){
            case WOOD:
                return "you're rich with vampire steaks.";
            case PLASTIC:
                return "find a recycling bin, you've got some plastic to dispose of.";
            case STONE:
                return "in pulverizing this stone you've realized your superhuman strength";
            case METAL:
                return "you've smelted your chair into a 2 crude swords.";
            case FABRICS:
                return "Perhaps you can fashion a coat out of this upholstery.";
            default:
                return "I hope you can find some use of this scrap.";
        }
    }
    
}