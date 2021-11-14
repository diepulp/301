public class MagicGame {
    private MagicSquare ms;
    private String player1;
    private String player2;

    byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};

    public MagicGame(String player1, String player2){
        this.player1 = player1;
        this.player1 = player2;
        ms = new MagicSquare(square);
    }

    public void run(){
        ms = new MagicSquare(square);
    }

    public MagicSquare getMs() {
        return ms;
    }

    public void setMs(MagicSquare ms) {
        this.ms = ms;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }


}
