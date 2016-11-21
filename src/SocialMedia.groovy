class SocialMedia {

    HashMap<String, User> users;
    Integer lastId;

    SocialMedia() {
        this.users = new HashMap<String, User>();
        this.lastId = 0;
    }

    public def getUsers() {
        return this.users;
    }

    public def register(String name, String username, String email, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        def profile = new Profile(name);
        def user = new User(username, password, email, profile);
        this.users[username] = user;
        return true;
    }

    public def login(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        return users[username].getPassword() == password;
    }
}