package socialnetwork

class Post{

  def id;
  def content;
  // def media;
  def createTime;
  def updateTime;
  def postedBy;
  def privacy;
  def comments = []

  public Post(){ }

  public Post(int id, String content){
    this.id = id;
    this.content = content;
  } 

  public Post(int id, String content, Date createTime, Date updateTime, User postedBy, String privacy){
    this.id = id;
    this.content = content;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.postedBy = new User(postedBy);
    this.privacy = privacy;
  }

  public def getId(){
    return id;
  }

  public def setId(int id){
    this.id = id;
  }

  public def getContent(){
    return content;
  }

  public def setContent(String content){
    this.content = content;
  }

  public def getCreateTime(){
    return createTime;
  }

  public def setCreateTime(Date createTime){
    this.createTime = createTime;
  }

  public def getUpdateDate(){
    return updateTime;
  }

  public def setUpdateDate(Date updateTime){
    this.updateTime = updateTime;
  }

  public def getPostedBy(){
    return postedBy;
  }

  public def setPostedBy(User postedBy){
    this.postedBy = postedBy;
  }

  public def getPrivacy(){
    return privacy;
  }

  public def setPrivacy(String privacy){
    this.privacy = privacy;
  }

  public def addComment(int id, User user, String content) {
    def comment = new Comment(id, user, content)
    comments << comment
  }
}













