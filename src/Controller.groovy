class Controller {

    def dbConnector = new DBConnector()

    def comment(post) {
        [from: { who ->
            [content: { content ->
                def user = dbConnector.getUser(who)
            }]
        }]
    }

    // Register method
    def register(username) {
        [password: { password ->
            [email: { email ->
                [name: { name ->
                    [profil: { profil ->
                        [sex: { sex ->
                            [location: { location ->
                                [dateofbirth: { dateofbirth ->
                                    def date = Date.parse('dd-M-yyyy', dateofbirth)
                                    def profile = new Profile(name, profil, date, sex, location)
                                    def user = new User(username, password, email, profile)

                                    if (dbConnector.addUser(user) > 0 && dbConnector.addProfile(user) > 0) {
                                        println "Register is successful!"
                                    } else {
                                        println "Register failed!"
                                    }
                                }]
                            }]
                        }]
                    }]
                }]
            }]
        }]
    }

    def login(username) {
        [password: { password ->
            def result = dbConnector.getUserCredentials(username, password)
            if (result == 1) {
                println "Login for username " + username + " results: login is true!"
                return true
            } else {
                println "Login for username " + username + " results: wrong login!"
                return false
            }
        }]
    }

    def post(content) {
        [by : { who ->
            [privacy : { privacy ->
                def createTime = new Date()
                def updateTime = createTime
                def user = dbConnector.getUser(who)
                def post = new Post(1, content, createTime, updateTime, user, privacy)

                if (dbConnector.addPost(post) > 0) {
                    println "Add post is successful!"
                } else {
                    println "add post failed!"
                }
            }]
        }]
    }

    def addfriend(friend) {
        [to :  { who ->
            if (dbConnector.addFriend(who, friend)) {
                println "Add friend " + friend + " to " + who + " successful"
            } else {
                println "Add friend failed"
            }
        }]
    }

}
