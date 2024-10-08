package gui;

public class TypeCalc {
    private static int normalpdx = 0;
    private static int firepdx = 0;
    private static int waterpdx = 0;
    private static int grasspdx = 0;
    private static int electricpdx = 0;
    private static int icepdx = 0;
    private static int fightingpdx = 0;
    private static int poisonpdx = 0;
    private static int groundpdx = 0;
    private static int flyingpdx = 0;
    private static int psychicpdx = 0;
    private static int bugpdx = 0;
    private static int rockpdx = 0;
    private static int ghostpdx = 0;
    private static int dragonpdx = 0;
    private static int darkpdx = 0;
    private static int steelpdx = 0;
    private static int fairypdx = 0;

    public static void typeCalculator(String type) {
    	/* var type is the defense pokemon
    	 -1: weak to, +1: strong to, +100: inmune to */
        switch (type) {
            case "Normal": 
            fightingpdx -= 1; ghostpdx += 100;
            break;
            case "Fire":
            firepdx += 1; waterpdx -= 1; grasspdx += 1; icepdx += 1; groundpdx -= 1; bugpdx += 1; rockpdx -= 1; steelpdx += 1; fairypdx += 1;
            break;  
            case "Water":
            firepdx += 1; waterpdx += 1; grasspdx -= 1; electricpdx -= 1; icepdx += 1; steelpdx += 1;  
            break;
            case "Grass":
            firepdx -= 1; waterpdx += 1; grasspdx += 1; electricpdx += 1; icepdx -= 1; poisonpdx -= 1; groundpdx += 1; flyingpdx -= 1; bugpdx -= 1;  
            break;
            case "Electric":
            electricpdx += 1; groundpdx -= 1; flyingpdx += 1; steelpdx += 1;
            break;
            case "Ice":
            firepdx -= 1; icepdx += 1; fightingpdx -= 1; rockpdx -= 1; steelpdx -= 1; 
            break;
            case "Fighting":
            flyingpdx -= 1; psychicpdx -= 1; bugpdx += 1; rockpdx += 1; darkpdx += 1; fairypdx -= 1;
            break;
            case "Poison":
            grasspdx += 1; fightingpdx += 1; poisonpdx += 1; groundpdx -= 1; psychicpdx += 1; bugpdx += 1; fairypdx += 1;
            break;
            case "Ground":
            waterpdx -= 1; grasspdx -= 1; electricpdx += 100; icepdx -= 1; poisonpdx += 1; rockpdx += 1;  
            break;
            case "Flying":
            grasspdx += 1; electricpdx -= 1; icepdx -= 1; fightingpdx += 1; groundpdx += 100; bugpdx += 1; rockpdx -= 1;  
            break;
            case "Psychic":
            fightingpdx += 1; psychicpdx += 1; bugpdx -= 1; ghostpdx -= 1; darkpdx -= 1;
            break;
            case "Bug":
            firepdx -= 1; grasspdx += 1; fightingpdx += 1; groundpdx += 1; flyingpdx -= 1; rockpdx -= 1;
            break;
            case "Rock":
            normalpdx += 1; firepdx += 1; waterpdx -= 1; grasspdx -= 1; fightingpdx -= 1; poisonpdx += 1; groundpdx -= 1; flyingpdx += 1;  
            break;
            case "Ghost":
            normalpdx += 100; fightingpdx += 100; poisonpdx += 1; bugpdx += 1; ghostpdx -= 1; darkpdx -= 1;   
            break;
            case "Dragon":
            firepdx += 1; waterpdx += 1; grasspdx += 1; electricpdx += 1; icepdx -= 1; dragonpdx -= 1; fairypdx -= 1;  
            break;
            case "Dark":
            fightingpdx -= 1; psychicpdx += 100; bugpdx -= 1; ghostpdx += 1; darkpdx += 1; fairypdx -= 1;
            break;
            case "Steel":
            normalpdx += 1; firepdx -= 1; grasspdx += 1; icepdx += 1; fightingpdx -= 1; poisonpdx += 100; 
            	groundpdx -= 1; flyingpdx += 1; psychicpdx += 1; bugpdx += 1; rockpdx += 1; dragonpdx += 1; fairypdx += 1; 
            break;
            case "Fairy":
            fightingpdx += 1; poisonpdx -= 1; bugpdx += 1; dragonpdx += 100; darkpdx += 1;  steelpdx -= 1; 
            break;
        }
        
    }
    public static void resetTypeValues() {
        normalpdx = 0; 
        firepdx = 0; 
        waterpdx = 0; 
        grasspdx = 0; 
        electricpdx = 0; 
        icepdx = 0; 
        fightingpdx = 0; 
        poisonpdx = 0; 
        groundpdx = 0; 
        flyingpdx = 0; 
        psychicpdx = 0; 
        bugpdx = 0; 
        rockpdx = 0; 
        ghostpdx = 0; 
        dragonpdx = 0; 
        darkpdx = 0; 
        steelpdx = 0; 
        fairypdx = 0;
    }
    
    public static int[] getNewTypeValues() {
        int[] wsAndLs = {normalpdx, firepdx, waterpdx,  grasspdx, electricpdx, icepdx, fightingpdx, poisonpdx, 
        		groundpdx, flyingpdx, psychicpdx, bugpdx, rockpdx, ghostpdx, dragonpdx, darkpdx, steelpdx, fairypdx};
        return wsAndLs;
    }
}
