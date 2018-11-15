import java.util.Random;

public class Client {

    private int serverTime;
    private int pTime;
    private int waitTime;
    private String id;
    private boolean queueSwitched;
    private int wouldHaveWaitedTime;
    private String sId;
    private String otherId;
    private int originalQueue;
    private int currentQueue;

    private static Random random = new Random();

    Client(String ID){
        id = ID;
        waitTime = 0;
        serverTime = random.nextInt(1 + 5);
        wouldHaveWaitedTime = 0;
        queueSwitched = false;
        sId = "";
        pTime = -1;
    }

    public void copyClient(Client client){
        this.waitTime = client.getWaitTime();
        this.serverTime = client.getServerTime();
        this.wouldHaveWaitedTime = client.getWouldHaveWaitedTime();
        this.queueSwitched = client.getQueueSwitched();
        this.sId = client.getsId();
        this.pTime = client.getpTime();
    }

    public String getId(){
        return id;
    }

    public void setOriginalQueue(int original){
        originalQueue = original;
    }

    public void setCurrentQueue(int current){
        currentQueue = current;
    }

    public void setpTime(int pTime){
        this.pTime = pTime;
    }

    public int getpTime(){
        return pTime;
    }

    public void setsId(String otherId){
        this.sId = otherId;
    }

    public String getsId(){
        return sId;
    }

    public void setOtherId(String otherId2){
        otherId = otherId2;
    }

    public String getOtherId(){
        return otherId;
    }

    public boolean getQueueSwitched(){
        return queueSwitched;
    }

    public void setQueueSwitched(boolean j){
        queueSwitched = j;
    }
    public int getWaitTime(){
        return waitTime;
    }

    public void setWaitTime(int setWaitTime){
        waitTime = setWaitTime;
    }

    public void setWouldHaveWaitedTime(int waitTime){
        wouldHaveWaitedTime = waitTime;
    }

    public int getWouldHaveWaitedTime(){
        return wouldHaveWaitedTime;
    }

    public int getServerTime(){
        return serverTime;
    }

    public void setServerTime(int time){
        serverTime = time;
    }

    public String toString(){
        boolean terseOutput = true;
        String output = "\n ID "+this.id+" CURRENT WAIT TIME "+this.waitTime+" ORIGINAL QUEUE "+this.originalQueue+"  CURRENT QUEUE "+this.currentQueue+" SERVER TIME "+serverTime;
        if (terseOutput == true) output += " WOULD HAVE WAITED "+wouldHaveWaitedTime;
        return output;
    }
}
