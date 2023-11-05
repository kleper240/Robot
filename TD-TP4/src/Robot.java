// package robots;

public class Robot {
    private int minerai;
    private int position;
    private Environnement monde;
    // private StringBuilder monde;
    // private final char VIDE = '.';

    public Robot(int minerai, Environnement environnement) {
        this.minerai = minerai;
        this.position = 1;
        this.monde = environnement;
    }

    public int getMinerai() {
        return minerai;
    }

    public int getPosition() {
        return position;
    }

    public String avancer() {
        if (minerai == 0)
            return "epuise";
        ++position;
        --minerai;
        return "avance";
    }

    public String reculer() {
        if (minerai == 0)
            return "epuise";
        --position;
        --minerai;
        return "recule";
    }

    // public char regarder() {
    //     return monde.charAt(position);
    // }

    public char regarder() {
        return monde.regarder(position);
    }

    public int getMinerai(char c) {
        if (c < '0' || c > '9')
            return 0; // pas de minerai
        else
            return c - '0';
    }

    public String recolter() {
        char c = regarder();
        int recolte = getMinerai(c);
        if (recolte > 0) {
            minerai += recolte;
            monde.ramasserMinerai(position);
            return "recolte : " + recolte;
        }
        return "pas de recolte";
    }

    public boolean ilFautRentrer() {
        return position > 0 && (position + 1) > minerai;
    }

    public String pas() {
        if (ilFautRentrer())
            return reculer();
        return avancer() + "\n" + recolter();
    }

    String getStatut() {
        return " [" + minerai + "] (" + position + ")";
    }

    public String mission() {
        String journalDeBord = "";
        System.out.println("Position initiale : " + getPosition());
        System.out.println("Minerai initial : " + getMinerai());
        while (position > 0 && minerai > 0)
            journalDeBord += pas() + getStatut() + "\n";

        
        return journalDeBord;
    }

    
}
