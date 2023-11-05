public class Monde implements Environnement {
    private StringBuilder monde;

    public Monde(StringBuilder monde) {
        this.monde = monde;
    }

    @Override
    public char regarder(int position) {
        if (position >= 0 && position < monde.length()) {
            return monde.charAt(position);
        }
        return '.';
    }

    @Override
    public void ramasserMinerai(int position) {
        if (position >= 0 && position < monde.length()) {
            monde.setCharAt(position, '.');
        }
    }

    @Override
    public boolean estMondeValide() {
        for (int i = 0; i < monde.length(); i++) {
            char c = monde.charAt(i);
            if (c != '.' && (c < '0' || c > '9')) {
                return false; 
            }
        }
        return true; 
    }
}
