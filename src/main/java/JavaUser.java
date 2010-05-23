public class JavaUser{
    
    private String screenName;
    private String name;
    private String location;
    
    public JavaUser(String screenName, String name, String location){
        this.screenName = screenName;
        this.name = name;
        this.location = location;
    }
    
    public String getScreenName(){
        return screenName;
    }
    
    public void setScreenName(String screenName){
        this.screenName = screenName;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
}