public class Connection {
  
    public void executeMessage() {
        Message mes = new Message();
        mes.getMessageDetails();
    
      try {
          mes.insertMessageDetails();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }  
    }
}
