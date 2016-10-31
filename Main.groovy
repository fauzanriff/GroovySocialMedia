import User;

class Main{

  static void main(String[] args){

      def user1 = new User(1,"fauzan");
      def user2 = new User(2,"visat");
      def user3 = new User(3,"ahmad");

      user1.addFriend(user2);
      user1.addFriend(user3);
      user1.addFriend(user2);
      user1.removeFriend(user2);

      println(user1.getFriendSize());

      def sn = new SocialNetwork();
      sn.register("try", "try", "try@try.com", "try");
      println sn.login("try", "try");
  }
}