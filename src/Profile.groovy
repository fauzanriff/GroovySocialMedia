class Profile{

    def name;
    def description;
    def dateOfBirth;
    def sex;
    def location;

    public Profile(){ }

    public Profile(String name){
        this.name = name;
    }
    public Profile(String name, String description, Date dateOfBirth, String sex, String location){
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.location = location;
    }

    public Profile(Profile profile){
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.dateOfBirth = profile.getDateOfBirth();
        this.sex = profile.getSex();
        this.location = profile.getLocation();
    }

    public def getName(){
        return name;
    }

    public def setName(String name){
        this.name = name;
    }

    public def getDescription(){
        return description;
    }

    public def setDescription(String description){
        this.description = description;
    }

    public def getDateOfBirth(){
        return dateOfBirth;
    }

    public def setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public def getSex(){
        return sex;
    }

    public def setSex(String sex){
        this.sex = sex;
    }

    public def getLocation(){
        return location;
    }

    public def setLocation(String location){
        this.location = location;
    }
}