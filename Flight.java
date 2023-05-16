public class Flight {
    private int ID;
    private String name;
    private int capacity;

    private int[][] seats;
    Flight(int x, int y){
        this.seats = new int[x][y];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                this.seats[i][j] = 0;
            }
        }
    }
    int[][] getSeats(){
        return this.seats;
    }

    void setSeat(int x, int y){
        this.seats[x][y] = 1;
    }

}
