/**
 * Created by Ahmad on 11/21/2016.
 */
class Main {

    static void main(String[] args) {
        def user1 = new User("fauzan", "fauzan", "fauzan", new Profile());
        def user2 = new User("visat", "visat", "visat", new Profile());
        def user3 = new User("ahmad", "ahmad", "ahmad", new Profile());

        def dbCon = new DBConnector()
        dbCon.createUserTable()
        dbCon.addUser(user1)
    }

}
