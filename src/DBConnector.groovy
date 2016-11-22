import java.sql.*
import org.sqlite.*
import groovy.sql.Sql

import java.text.SimpleDateFormat

/**
 * Created by Ahmad on 11/21/2016.
 */
class DBConnector {

    public DBConnector() {
        createUserTable()
        createCommentTable()
        createPostTable()
        createProfileTable()
        createFriendTable()
    }

    def getDB() {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:sample.db");
        return c
    }

    public void createUserTable() {
        def conn = getDB()
        def stmt = conn.createStatement();
        def sql = "CREATE TABLE IF NOT EXISTS user (" +
                    "id integer primary key autoincrement," +
                    "username string," +
                    "password string," +
                    "email string" +
                    ")"

        stmt.executeUpdate(sql)
        stmt.close()
        conn.close()
    }

    public void createPostTable() {
        def conn = getDB()
        def stmt = conn.createStatement();
        def sql = "CREATE TABLE IF NOT EXISTS post (" +
                    "id integer primary key autoincrement," +
                    "content string," +
                    "create_time datetime," +
                    "update_time datetime," +
                    "posted_by string," +
                    "privacy string" +
                    ")"

        stmt.executeUpdate(sql)
        stmt.close()
        conn.close()
    }

    public void createFriendTable() {
        def conn = getDB()
        def stmt = conn.createStatement();
        def sql = "CREATE TABLE IF NOT EXISTS friend (" +
                    "friend1 string," +
                    "friend2 string" +
                    ")"

        stmt.executeUpdate(sql)
        stmt.close()
        conn.close()
    }

    public void createCommentTable() {
        def conn = getDB()
        def stmt = conn.createStatement();
        def sql = "CREATE TABLE IF NOT EXISTS comment (" +
                        "post_id integer," +
                        "content string," +
                        "create_time datetime," +
                        "update_time datetime," +
                        "posted_by string" +
                        ")"

        stmt.executeUpdate(sql)
        stmt.close()
        conn.close()
    }

    public void createProfileTable() {
        def conn = getDB()
        def stmt = conn.createStatement();
        def sql = "CREATE TABLE IF NOT EXISTS profile (" +
                    "name string," +
                    "description string," +
                    "date_of_birth date," +
                    "sex string," +
                    "location string," +
                    "username string" +
                    ")"

        stmt.executeUpdate(sql)
        stmt.close()
        conn.close()
    }

    public int addUser(User user) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "INSERT INTO user (username, password, email) VALUES (?,?,?)"
        )

        stmt.setString(1, user.getUsername())
        stmt.setString(2, user.getPassword())
        stmt.setString(3, user.getEmail())

        def retval = stmt.executeUpdate()
        conn.close()
        return retval
    }

    public int addProfile(User user) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "INSERT INTO profile (name, description, date_of_birth, sex, location, username) VALUES (?,?,?,?,?,?)"
        )

        stmt.setString(1, user.getProfile().getName())
        stmt.setString(2, user.getProfile().getDescription())
        stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(user.getProfile().getDateOfBirth()))
        stmt.setString(4, user.getProfile().getSex())
        stmt.setString(5, user.getProfile().getLocation())
        stmt.setString(6, user.getUsername())

        def retval = stmt.executeUpdate()
        conn.close()
        return retval
    }

    public int getUserCredentials(String username, String password) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "select * from user where username = ? and password = ?"
        )

        stmt.setString(1, username)
        stmt.setString(2, password)
        def res = stmt.executeQuery()

        if (res.next()) {
            conn.close()
            res.close()
            return 1
        } else {
            conn.close()
            res.close()
            return 0
        }
    }

    public User getUser(String username) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "select * from user where username = ?"
        )

        stmt.setString(1, username)
        def res = stmt.executeQuery()
        if (res.next()) {
            conn.close()
            def user = new User(res.getString("username"), res.getString("password"), res.getString("email"), new Profile())
            res.close()
            return user
        } else {
            conn.close()
            res.close()
            return null
        }
    }

    public int addPost(Post post) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "INSERT INTO post (content, create_time, update_time, posted_by, privacy) VALUES (?,?,?,?,?)"
        )

        stmt.setString(1, post.getContent())
        stmt.setString(2, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(post.getCreateTime()))
        stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(post.getUpdateTime()))
        stmt.setString(4, post.getPostedBy().getUsername())
        stmt.setString(5, post.getPrivacy())

        def retval = stmt.executeUpdate()
        conn.close()
        return retval
    }

    public int addFriend(String who, String friend) {
        def conn = getDB()
        def stmt = conn.prepareStatement(
                "INSERT INTO friend (friend1, friend2) VALUES (?,?)"
        )

        stmt.setString(1, who)
        stmt.setString(2, friend)

        def retval = stmt.executeUpdate()
        conn.close()
        return retval
    }

    public int addComment(Comment comment, Post post) {

    }

}
