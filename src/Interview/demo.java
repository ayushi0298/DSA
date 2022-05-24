package Interview;

class Sender{
    public void createAndSend(Reciever reciver){
        String s="some data from Producer";
        reciver.recieve(s);
    }
}

class Reciever{
    public void recieve(String data){
        System.out.println("I recieved "+data);
    }
}

//lets test it
class TestX{
    public static void main(String[] args) {
        Sender s=new Sender();
        Reciever r=new Reciever();
        System.out.println(r);
        s.createAndSend(r);

    }
}

