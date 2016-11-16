package setting;

/**
 * Created by lrkin on 2016/11/16.
 */
public class SettingObject {
    private int workerid;
    private MqObject[] mq;
    private String[] sendto;
    private String[] recvfrom;

    public int getWorkerid() {
        return workerid;
    }

    public void setWorkerid(int workerid) {
        this.workerid = workerid;
    }

    public MqObject[] getMq() {
        return mq;
    }

    public void setMq(MqObject[] mq) {
        this.mq = mq;
    }

    public String[] getSendto() {
        return sendto;
    }

    public void setSendto(String[] sendto) {
        this.sendto = sendto;
    }

    public String[] getRecvfrom() {
        return recvfrom;
    }

    public void setRecvfrom(String[] recvfrom) {
        this.recvfrom = recvfrom;
    }
}
