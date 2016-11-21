class User{

    def username
    def password
    def email
    def profile
    def friends = []
    def following = []
    def block = []
    // def posts

    public User(){
    }
    public User(String username){
        this.username = username
    }
    public User(String username, String password, String email, Profile profile){
        this.username = username
        this.password = password
        this.email = email
        this.profile = new Profile(profile)
    }

    public User(User user){
        this.username = user.getUsername()
        this.password = user.getPassword()
        this.email = user.getEmail()
        this.profile = new Profile(user.getProfile())
        for(int i=0; i < user.getFriendSize(); i++){
            this.friends << user.getFriend(i)
        }
        for(int i=0; i < user.getFollowedSize(); i++){
            this.following << user.getFollowedUser(i)
        }
        for(int i=0; i < user.getBlockedSize(); i++){
            this.block << user.getBlockedUser(i)
        }
    }

    public def getUsername(){
        return username
    }

    public def setUsername(String username){
        this.username = username
    }

    public def getPassword() {
        return password
    }

    public def setPassword(String password){
        this.password = password
    }

    public def getEmail(){
        return email
    }

    public def setEmail(String email){
        this.email = email
    }

    public Profile getProfile(){
        return profile
    }

    public setProfile(Profile profile){
        this.profile = profile
    }

    public def addFriend(User friend){
        if(!friends.contains(friend))
            friends << friend
    }

    public def removeFriend(User friend){
        friends.remove(friend)
    }

    public def getFriend(int i){
        return friends[i]
    }

    public def getFriends(){
        return friends
    }

    public def getFriendSize(){
        return friends.size()
    }

    public def followUser(User friend){
        if(!following.contains(friend))
            following << friend
    }

    public def unfollowUser(User friend){
        following.remove(friend)
    }

    public def getFollowedUser(int i){
        return following[i]
    }

    public def getFollowedUsers(){
        return following
    }

    public def getFollowedSize(){
        return following.size()
    }

    public def blockUser(User friend){
        if(!block.contains(friend))
            block << friend
    }

    public def unblockUser(User friend){
        block.remove(friend)
    }

    public def getBlockedUser(int i){
        return block[i]
    }

    public def getBlockedUsers(){
        return block
    }

    public def getBlockedSize(){
        return block.size()
    }

}