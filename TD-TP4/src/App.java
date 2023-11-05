public class App {
    public static void main(String[] args) {
        // Crée un StringBuilder pour représenter le monde (exemple)
        StringBuilder MonMonde = new StringBuilder("0245753296");

        Environnement monde = new Monde(MonMonde);

        // Crée un robot avec 5 unités de minerai et le monde
        Robot robot = new Robot(5, monde);
        // Affiche la position et le minerai initial du robot

        System.out.println("Position initiale : " + robot.getPosition());
        System.out.println("Minerai initial : " + robot.getMinerai());

        System.out.println("regarder  : " + robot.regarder());
        // Le robot avance et recule tout en ramassant du minerai
        System.out.println(robot.avancer());
        System.out.println("Minerai initial : " + robot.getMinerai());
        System.out.println(robot.recolter());
        System.out.println(robot.reculer());
        System.out.println(robot.recolter());

        // Affiche le statut actuel du robot
        System.out.println("Statut actuel : " + robot.getStatut());

        System.out.println("---------------------------------------------------");

        // Effectue une mission jusqu'à épuisement du minerai ou retour à la base
        String journalDeBord = robot.mission();
        System.out.println(journalDeBord);

        // Affiche le statut final du robot après la mission
        System.out.println("Statut final : " + robot.getStatut());
    }
}
