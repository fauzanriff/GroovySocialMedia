import java.sql.*
import org.sqlite.*
import groovy.sql.Sql

/**
 * Created by Ahmad on 11/21/2016.
 */
class DBConnector {

    public DBConnector() {

    }

    def getDB() {
        return Sql.newInstance("jdbc:sqlite:sample.db", "org.sqlite.JDBC")
    }

    public void createUserTable() {
        def sql = getDB()
        sql.execute(
                "CREATE TABLE user (" +
                        "id integer primary key autoincrement," +
                        "username string," +
                        "password string," +
                        "email string" +
                        ")"
        )
    }

    public void createPostTable() {
        def sql = getDB()
        sql.execute(
                "CREATE TABLE post (" +
                        "id integer primary key autoincrement," +
                        "content string," +
                        "create_time datetime," +
                        "update_time datetime," +
                        "posted_by string," +
                        "privacy string" +
                        ")"
        )
    }

    public void createCommentTable() {
        def sql = getDB()
        sql.execute(
                "CREATE TABLE comment (" +
                        "post_id integer," +
                        "content string," +
                        "create_time datetime," +
                        "update_time datetime," +
                        "posted_by string" +
                ")"
        )
    }

    public void createProfileTable() {
        def sql = getDB()
        sql.execute(
                "CREATE TABLE profile (" +
                        "name string," +
                        "description string," +
                        "date_of_birth date," +
                        "sex string," +
                        "location string," +
                        "username string" +
                        ")"
        )
    }

    public void addUser(User user) {
        def sql = getDB()
        def userDb = sql.dataSet("user")
        userDb.add(username:user.getUsername(), password:user.getPassword(), email:user.getEmail())
    }

    public void addProfile(User user) {
        def sql = getDB()
        def profileDb = sql.dataSet("profile")
        profileDb.add(
                name:user.getProfile().getName(),
                description:user.getProfile().getDescription(),
                date_of_birth:user.getProfile().getDateOfBirth(),
                sex:user.getProfile().getSex(),
                location:user.getProfile().getLocation(),
                username:user.getUsername()
        )
    }

    public int getUserCredentials(String username, String password) {
        def sql = getDB()
        def res = sql.firstRow("select * from user where username = ?", [username])
        if (res.password == password) {
            return 1
        } else {
            return 0
        }
    }

    public User getUser(String username) {
        def res = sql.firstRow("select * from user where username = ?", [username])
        if (res)
            return new User(res.username, res.password, res.email, new Profile())
        else
            return null
    }

    public void addPost(Post post) {
        def sql = getDB()
        def postDb = sql.dataSet("post")
        postDb.add(
                content:post.getContent(),
                create_time:post.getCreateTime(),
                update_time:post.getUpdateTime(),
                posted_by:post.getPostedBy().getUsername(),
                privacy:post.getPrivacy()
        )
    }

}
