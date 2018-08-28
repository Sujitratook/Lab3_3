public class OX {
    private String [][] table = {
            {" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"},
    };

    private String player;
    private int countX;
    private int countO;
    private int countdraw;
    private int turncount;

    public OX(){
        player = "X";
        countX = 0;
        countO = 0;
        countdraw = 0;
        turncount = 0;
    }

    public String getTableString() {
        String result = "";
        for(int row =0; row < table.length;row++){
            for(int col=0; col <table[row].length; col++){
                result = result + table[row][col];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getcountO() {

        return countO;
    }

    public int getcountX() {

        return countX;
    }

    public int getcountdraw() {
        return countdraw;
    }

    public boolean put(int col, int row) {
        try {
            if(!table[row+1][col+1].equals("-")){
                return false;
            }else{
            table[row+1][col+1] = getCurrentPlayer();
            turncount++;
            if (Checkwin(row,col)){
                if (player.equals("X")){
                    countX++;
                }else if (player.equals("O")){
                    countO++;
                }
            }
                }
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public void Switchplayer() {
        if(player == "X"){
            player = "O";
        }else{
            player = "X";
        }
    }

    public boolean Checkwin(int col, int row) {
        boolean rowWin = true;
        for(int i=0;i<3;i++){
            if(!table[row+1][i+1].equals(player)){
                rowWin=false;
            }
        }
        if(rowWin){
            return true;
        }

        boolean colWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][col+1].equals(player)){
                colWin=false;
            }
        }
        if(colWin){
            return true;
        }

        boolean esWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][i+1].equals(player)){
                esWin=false;
            }
        }
        if(esWin){
            return true;
        }

        boolean ssWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][3-i].equals(player)){
                ssWin=false;
            }
        }
        if(ssWin){
            return true;
        }

        return false;
    }
    public void reset() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                table[i+1][j+1]="-";
            }
        }
        player = "X";
        turncount = 0;
    }

    public String get(int col, int row) {
        if(col > 2 || col < 0 || row > 2 || row < 0){
            return null;
        }
        return table[row+1][col+1];
    }

    public int getTurncount() {
        return turncount;
    }

    public boolean isDraw() {
        if (turncount < 9){
            return false;
        }
        return true;
    }

    public int getAtscoreX() {
        return countX;
    }

    public int getAtscoreO() {
        return countO;
    }

    public int getAtscoreDraw() {
        return countdraw;
    }
}
