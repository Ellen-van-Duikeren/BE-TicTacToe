public class Player {
    private String name;
    private String token;
    private int score;

    public Player(String name, String token) {
    this.name = name;
    this.token = token;
    }


    //getersNsetters
    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int extraPoints) { // let op, je kan ook gewoon score++ doen en de extraPoints weglaten als je elke keer een punt geeft als iemand wint
        score += extraPoints;
    }


}
