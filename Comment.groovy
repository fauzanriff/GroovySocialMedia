class Comment {

    def id
    def content
    def createTime
    def updateTime
    def postedBy

    public Comment() { }

    public Comment(int id, String content, User postedBy) {
        this.id = id
        this.content = content
        this.postedBy = new User(postedBy)
    }

    public Comment(int id, String content, Date createTime, Date updateTime, User postedBy) {
        this.id = id
        this.content = content
        this.createTime = createTime
        this.updateTime = updateTime
        this.postedBy = new User(postedBy)
    }

}
