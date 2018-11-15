public class Server {

    private Client servingC;
    private boolean busy;
    private int start;
    private int remainingTime;

    public Server(){
    }
    public void setServingC(Client c){
        servingC = c;
    }
    public Client getClientServed(){
        return servingC;
    }
    public boolean getIsBusy(){
        return busy;
    }
    public void setIsBusy(boolean b){
        busy = b;
    }
    public boolean isDoneWithClient(int tick){
        boolean result = false;
        if (servingC != null){
            if(busy==true){
                int elapsedTimeWithClient = tick-start;
                remainingTime = elapsedTimeWithClient;
                if (elapsedTimeWithClient>=servingC.getServerTime()){
                    result = true;
                }
            }
            else{
                start = tick;
                result = false;
            }
        }
        return result;
    }
}
