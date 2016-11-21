class Controller {

    def dbConnector

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
                    [biodata: { my_biodata ->
                        [sex: { sex ->
                            [location: { location ->
                                [dateofbirth: { dateofbirth ->
                                    def date = Date.parse('dd-M-yyyy', dateofbirth)
                                    def profile = new Profile(name, my_biodata, date, sex, location)
                                    def user = new User(username, password, email, profile)

                                    dbConnector.addUser(user)
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
                return true
            } else {
                return false
            }
        }]
    }

    def post(content) {
        [by : { who ->
            [privacy : { privacy ->
                def createTime = new Date().format("yyyy-MM-dd hh:mm:ss")
                def updateTime = createTime
                def user = dbConnector.getUser(who)
                def post = new Post(null, content, createTime, updateTime, user, privacy)

                dbConnector.addPost(post)
            }]
        }]
    }

}
