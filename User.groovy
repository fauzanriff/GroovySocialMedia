import Profile;

class User{

  def id;
  def username;
  def password;
  def email;
  def status;
  def profile;
  def friends;
  def following;
  def block;
  // def posts;

  public User(){ 
    friends = new ArrayList<User>();
  }
  public User(Integer id, String username){
    this.id = id;
    this.username = username;
      friends = new ArrayList<User>();
  }
  public User(int id, String username, String password, String email, int status, Profile profile){
      this.id = id;
      this.username = username;
      this.password = password;
      this.email = email;
      this.status = status;
      this.profile = new Profile();
      friends = [];
  }

  public def getId(){
    return id;
  }

  public def setId(int id){
    this.id = id;
  }

  public def getUsername(){
    return username;
  }

  public def setUsername(String username){
    this.username = username;
  }

  public def getPassword(){
    return password;
  }

  public def setPassword(String password){
    this.password = password;
  }

  public def getEmail(){
    return email;
  }

  public def setEmail(String email){
    this.email = email;
  }

  public def getStatus(){
    return status;
  }

  public def setStatus(int status){
    this.status = status;
  }

  public Profile getProfile(){
    return profile;
  }

  public setProfile(Profile profile){
    this.profile = profile;
  }

  public def addFriend(User friend){
    if(!friends.contains(friend))
      friends << friend;
  }

  public def removeFriend(User friend){
    friends.remove(friend);
  }

  public def getFriend(int i){
    return friends[i];
  }

  public def getFriends(){
    return friends;
  }

  public def getFriendSize(){
    return friends.size();
  }

  public def followUser(User user){
    if(!following.contains(friend))
      following << friend;
  }

  public def unfollowUser(User user){
    following.remove(friend);
  }

  public def getFollowedUser(int i){
    return following[i];
  }

  public def getFollowedUsers(){
    return following;
  }

  public def getFollowedSize(){
    return following.size();
  }

  public def blockUser(User user){
    if(!block.contains(friend))
      block << friend;
  }

  public def unblockUser(User user){
    block.remove(friend);
  }

  public def getBlockedUser(int i){
    return block[i];
  }

  public def getBlockedUsers(){
    return block;
  }

  public def getBlockedSize(){
    return block.size();
  }

}













