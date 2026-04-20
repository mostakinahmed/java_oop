class Developer {

    private String name;
    private String id;
    private String department;
    private int batch;
    private String phone;
    private String email;
    private String website;

    // GETTERS
    public String getName() { return name; }
    public String getId() { return id; }
    public String getDept() { return department; }
    public int getBatch() { return batch; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getWebsite() { return website; }

    // SETTERS 
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setDept(String department) { this.department = department; }
    public void setBatch(int batch) { this.batch = batch; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setWebsite(String website) { this.website = website; }
}

public class Main {
    public static void main(String[] args) {
  
        Developer dev = new Developer();
     
        dev.setName("Mostakin Ahmed");
        dev.setId("242-35-831");
        dev.setDept("Software Engineering");
        dev.setBatch(43);
        dev.setPhone("017738250336");
        dev.setEmail("me@mostakinahmed.com");
        dev.setWebsite("mostakinahmed.com");
      
        System.out.println("Name    : " + dev.getName());
        System.out.println("ID      : " + dev.getId());
        System.out.println("Dept    : " + dev.getDept());
        System.out.println("Batch   : " + dev.getBatch());
        System.out.println("Phone   : " + dev.getPhone());
        System.out.println("Email   : " + dev.getEmail());
        System.out.println("Website : " + dev.getWebsite());
     
    }
}